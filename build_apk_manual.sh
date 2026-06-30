#!/bin/bash
# Manual APK build script for FlyMe (decompiled project)
# Runs inside WSL

set -e

PROJECT="/mnt/c/T3/Fly1"
OUT="/tmp/flyme-build"
SRC="$PROJECT/app/src/main"
ANDROID_JAR="/home/user/Android/Sdk/platforms/android-34/android.jar"
BUILD_TOOLS="/home/user/Android/Sdk/build-tools/34.0.0"
LOCAL_REPO="/home/user/.gradle/local-maven-repo"
SUPPORT_AAR="$LOCAL_REPO/com/android/support"

echo "=== Step 0: Clean ==="
rm -rf "$OUT"
mkdir -p "$OUT/classes" "$OUT/dex" "$OUT/aar-jars"

echo "=== Step 1: Extract classes.jar from AARs ==="
extract_aar() {
  local pkg="$1" dir="$2"
  local f=$(find "$SUPPORT_AAR/$pkg" -name "*.aar" 2>/dev/null | head -1)
  if [ -n "$f" ]; then
    mkdir -p "$OUT/aar-jars/$dir"
    unzip -o -q "$f" classes.jar -d "$OUT/aar-jars/$dir" 2>/dev/null
    if [ -f "$OUT/aar-jars/$dir/classes.jar" ]; then
      echo "  $dir: OK ($(stat -c%s "$OUT/aar-jars/$dir/classes.jar") bytes)"
    else
      echo "  $dir: no classes.jar"
    fi
  fi
}

extract_aar appcompat-v7 appcompat
extract_aar support-v4 support-v4
extract_aar support-core-utils support-core-utils
extract_aar support-compat support-compat
extract_aar support-fragment support-fragment
extract_aar support-media-compat support-media-compat
extract_aar support-core-ui support-core-ui
extract_aar animated-vector-drawable animated-vector-drawable
extract_aar support-vector-drawable support-vector-drawable

# Lifecycle runtime AAR
LF="$LOCAL_REPO/android/arch/lifecycle/runtime/1.0.0/lifecycle-runtime-1.0.0.aar"
if [ -f "$LF" ]; then
  mkdir -p "$OUT/aar-jars/lifecycle-runtime"
  unzip -o -q "$LF" classes.jar -d "$OUT/aar-jars/lifecycle-runtime" 2>/dev/null
  echo "  lifecycle-runtime: $(stat -c%s "$OUT/aar-jars/lifecycle-runtime/classes.jar" 2>/dev/null || echo 0) bytes"
fi

# JARs
for src in lifecycle-common arch-core-common; do
  j=$(find "$LOCAL_REPO/android/arch/$src" -name "*.jar" 2>/dev/null | head -1)
  if [ -n "$j" ]; then
    cp "$j" "$OUT/aar-jars/$src.jar"
    echo "  $src: OK ($(stat -c%s "$OUT/aar-jars/$src.jar") bytes)"
  fi
done
# support-annotations JAR
j=$(find "$SUPPORT_AAR/support-annotations" -name "*.jar" 2>/dev/null | head -1)
if [ -n "$j" ]; then
  cp "$j" "$OUT/aar-jars/support-annotations.jar"
  echo "  support-annotations: OK ($(stat -c%s "$OUT/aar-jars/support-annotations.jar") bytes)"
fi

echo ""
echo "=== Step 2: Build classpath ==="
CLASSPATH="$ANDROID_JAR"
for j in "$OUT/aar-jars"/*/classes.jar "$OUT/aar-jars"/*.jar; do
  if [ -f "$j" ]; then
    CLASSPATH="$CLASSPATH:$j"
  fi
done
echo "  Classpath entries: $(echo "$CLASSPATH" | tr ':' '\n' | wc -l)"

echo ""
echo "=== Step 3: Compile resources with aapt2 ==="
mkdir -p "$OUT/compiled"
"$BUILD_TOOLS/aapt2" compile \
  --dir "$SRC/res" \
  -o "$OUT/compiled/resources.zip" 2>&1 || echo "  (aapt2 compile had warnings/errors)"

echo ""
echo "=== Step 4: Link resources (generate R.java + resources.apk) ==="
mkdir -p "$OUT/apk"
"$BUILD_TOOLS/aapt2" link \
  --manifest "$SRC/AndroidManifest.xml" \
  -I "$ANDROID_JAR" \
  -A "$SRC/assets" \
  --java "$OUT/gen" \
  -o "$OUT/apk/resources.apk" \
  -R "$OUT/compiled/resources.zip" \
  --auto-add-overlay 2>&1 || echo "  (aapt2 link had warnings/errors)"

echo ""
echo "=== Step 5: List Java sources ==="
find "$SRC/java" -name "*.java" > "$OUT/sources.txt"
SC=$(wc -l < "$OUT/sources.txt")
echo "  $SC Java files"

# Check R.java
if [ -f "$OUT/gen/com/xcglobe/flyme/R.java" ]; then
  echo "  R.java: OK"
else
  echo "  R.java: NOT GENERATED"
fi

echo ""
echo "=== Step 6: Compile Java with javac ==="
# Generate R.java path
GEN_SRC="$OUT/gen"
if [ ! -d "$GEN_SRC" ]; then GEN_SRC=""; fi

javac -source 8 -target 8 \
  -cp "$CLASSPATH" \
  -d "$OUT/classes" \
  -implicit:none \
  -Xlint:-options \
  -proc:none \
  ${GEN_SRC:+-sourcepath "$GEN_SRC"} \
  @$OUT/sources.txt 2>&1 | tail -30 || echo "  Compilation had errors"

CC=$(find "$OUT/classes" -name "*.class" 2>/dev/null | wc -l)
echo "  $CC .class files generated"

echo ""
echo "=== Step 7: Convert to DEX with d8 ==="
CLASS_FILES=$(find "$OUT/classes" -name "*.class" 2>/dev/null | wc -l)
if [ "$CLASS_FILES" -gt 0 ]; then
  "$BUILD_TOOLS/d8" \
    --lib "$ANDROID_JAR" \
    --min-api 14 \
    --output "$OUT/dex" \
    $(find "$OUT/classes" -name "*.class") 2>&1 || echo "  d8 had errors"

  DEX_FILE="$OUT/dex/classes.dex"
  if [ -f "$DEX_FILE" ]; then
    echo "  classes.dex: $(stat -c%s "$DEX_FILE") bytes"
  else
    # Check for multi-dex
    for f in "$OUT/dex"/*.dex; do
      echo "  $(basename $f): $(stat -c%s "$f") bytes"
    done
  fi
else
  echo "  No .class files, nothing to dex"
fi

echo ""
echo "=== Step 8: Package APK ==="
APK_UNSIGNED="$PROJECT/FlyMe.apk"
rm -f "$APK_UNSIGNED"

# Start with resources.apk as base
cp "$OUT/apk/resources.apk" "$APK_UNSIGNED"

# Add DEX
if ls "$OUT/dex"/*.dex 2>/dev/null 1>&2; then
  cd "$OUT/dex"
  for d in *.dex; do
    zip -q "$APK_UNSIGNED" "$d" 2>&1 || true
    echo "  Added $d to APK"
  done
fi

echo ""
echo "=== Step 9: Zipalign ==="
APK_ALIGNED="$PROJECT/FlyMe-aligned.apk"
"$BUILD_TOOLS/zipalign" -v -p 4 "$APK_UNSIGNED" "$APK_ALIGNED" 2>&1

echo ""
echo "=== Step 10: Sign ==="
"$BUILD_TOOLS/apksigner" sign \
  --ks /home/user/.android/debug.keystore \
  --ks-key-alias androiddebugkey \
  --ks-pass pass:android \
  --key-pass pass:android \
  --v1-signing-enabled true \
  --v2-signing-enabled true \
  "$APK_ALIGNED" 2>&1

echo ""
echo "=== Step 11: Verify ==="
"$BUILD_TOOLS/apksigner" verify --verbose "$APK_ALIGNED" 2>&1

echo ""
echo "=== DONE ==="
ls -lh "$APK_ALIGNED"
echo "APK: $APK_ALIGNED"
