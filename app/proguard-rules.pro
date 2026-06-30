# ProGuard rules — original APK was obfuscated (ProGuard output).
# Disable obfuscation for debug builds so the code stays readable while editing.

# Keep all classes that are referenced via reflection (AndroidManifest, JNI, etc.)
-keep class com.xcglobe.** { *; }
-keep class display.** { *; }
-keep class types.** { *; }
-keep class configs.** { *; }
-keep class vmaps.** { *; }
-keep class mymenu.** { *; }
-keep class flyme_** { *; }

# BouncyCastle
-keep class org.bouncycastle.** { *; }
-dontwarn org.bouncycastle.**

# Support library
-dontwarn android.support.**
