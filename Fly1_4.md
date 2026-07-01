# Fly1 — четвёртая проверка: исходники исправлены, но APK остался старый

> Репозиторий: https://github.com/advogr2022-max/Fly1
> Коммит: `6bae719` — *«FlyMe v0.0.2 — Fixed startForeground crash, permissions, PendingIntent, null intent»*
> Анализ: декомпиляция `FlyMe-aligned.apk` (5 МБ, дата сборки 2026-07-01 00:53), проверка исходников.

---

## 0. 🚨 ГЛАВНАЯ НАХОДКА: APK в репозитории НЕ пересобран

Декомпиляция `FlyMe-aligned.apk` через `androguard` показывает, что **внутри APK находится СТАРЫЙ байткод** — то есть код **до** коммита `6bae719`:

### Доказательство 1: `FlyMeService.onStartCommand` в DEX (старый код)
```
public int onStartCommand(android.content.Intent p4, int p5, int p6) {
    com.xcglobe.xclog.FlyMeService.f470f = this;
    if (!p4.getAction().equals("com.xcglobe.action.startservice")) {  // ← нет null-check!
        if (p4.getAction().equals("com.xcglobe.action.stopservice")) {
            this.f471g.removeCallbacks(this.f472h);
            this.stopForeground(1);
            this.stopSelf();
        }
    } else {
        this.f471g = new android.os.Handler();
        android.os.Handler v0_6 = new com.xcglobe.xclog.FlyMeService$1(this);
        this.f472h = v0_6;
        this.f471g.post(v0_6);  // ← Handler.post (старый код, не startForeground сразу)
    }
    return 1;
}
```

В исходниках же (коммит `6bae719`) код уже исправлен:
```java
String action = intent != null ? intent.getAction() : null;  // ← есть null-check
if ("com.xcglobe.action.startservice".equals(action)) {
    startForeground(101, m458b());                              // ← сразу, без Handler
    ...
}
```

### Доказательство 2: `FlyMeService.m458b` в DEX (старый код)
```
setSmallIcon(com.xcglobe.flyme.R$drawable.notification_color)  // ← XML shape, не системная иконка
...
PendingIntent.getActivity(this, 0, ..., 0);                     // ← нет FLAG_IMMUTABLE
```

В исходниках уже:
```java
int flags = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
        ? PendingIntent.FLAG_IMMUTABLE : 0;                      // ← есть FLAG_IMMUTABLE
.setSmallIcon(android.R.drawable.ic_menu_mylocation)             // ← системная иконка
```

### Доказательство 3: манифест APK (старый код)
```xml
<!-- В декомпилированном манифесте APK НЕТ: -->
<!-- <uses-permission android:name="android.permission.FOREGROUND_SERVICE"/> -->
<!-- <uses-permission android:name="android.permission.FOREGROUND_SERVICE_LOCATION"/> -->
<!-- <uses-permission android:name="android.permission.POST_NOTIFICATIONS"/> -->
<!-- android:foregroundServiceType="location" на <service> -->
<!-- android:requestLegacyExternalStorage="true" на <application> -->
<!-- versionCode=40 (а не 41, как в build.gradle) -->
```

В исходниках все эти правки **применены**.

### Доказательство 4: `ActivityMain.onCreate` в DEX (старый код)
```
com.xcglobe.xclog.App.m440a(0);
com.xcglobe.xclog.App.m438a(this);     // ← ДО super.onCreate
super.onCreate(p8);                     // ← ПОСЛЕ m438a
...
// нет блока проверки POST_NOTIFICATIONS
// нет ContextCompat.startForegroundService (старый startService в App.m444b)
```

В исходниках уже:
```java
f433d = this;
App.m440a((String) null);
super.onCreate(bundle);                 // ← super ПЕРВЫМ
App.m438a(this);                        // ← потом m438a
...
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS")
            != PackageManager.PERMISSION_GRANTED) {
        arrayList.add("android.permission.POST_NOTIFICATIONS");
    }
}
```

### Почему так произошло

`.gitignore` в репозитории содержит:
```
app/build/
*.idsig
```

Но **не содержит** `*.apk` или `FlyMe-aligned.apk`. Поэтому устаревший APK остался в корне репозитория, и автор, скорее всего, тестирует именно его — а не свежесобранный из `app/build/outputs/apk/debug/`.

Проверка через `git log FlyMe-aligned.apk`:
```
8ad9c5e FlyMe v0.0.1 — AndroidX migration, build fixes, crash fixes   ← последний раз закоммичен ЗДЕСЬ
9498240 FlyMe 3.12 Beta — AndroidX migration + compilation fixes
720c048 FlyMe 3.12 Beta — decompiled project with fixes
```

В коммите `6bae719` (v0.0.2, с правками) APK **не пересобирался и не обновлялся в репозитории**.

### Что нужно сделать

**Шаг 1.** Пересобрать APK:
```bash
cd Fly1
./gradlew clean
./gradlew assembleDebug --stacktrace 2>&1 | tee build.log
ls -la app/build/outputs/apk/debug/app-debug.apk
```

**Шаг 2.** Использовать именно `app/build/outputs/apk/debug/app-debug.apk`, **а не** `FlyMe-aligned.apk` из корня репозитория.

**Шаг 3.** Удалить устаревший APK из репозитория и обновить `.gitignore`:
```bash
cd Fly1
git rm FlyMe-aligned.apk
# Обновить .gitignore:
echo "*.apk" >> .gitignore
echo "FlyMe*.apk" >> .gitignore
echo "FlyMe*.idsig" >> .gitignore
git add .gitignore
git commit -m "Remove stale APK from repo, ignore all APK files"
```

**Шаг 4.** Установить новый APK на устройство:
```bash
adb uninstall com.xcglobe.flyme     # удалить старую версию!
adb install -r app/build/outputs/apk/debug/app-debug.apk
adb logcat -c
adb shell am start -n com.xcglobe.flyme/.ActivityMain
adb logcat -d | grep -E "AndroidRuntime|FATAL|com.xcglobe" | head -50
```

⚠️ **Важно:** `adb install -r` обновляет APK, но сохраняет данные. Если в SharedPreferences есть `last_run_version` со старой версией, приложение может пропустить шаг инициализации. Лучше `adb uninstall` + `adb install` (без `-r`).

---

## 1. Остающиеся проблемы в исходниках (после коммита 6bae719)

Даже если пересобрать APK из текущих исходников, есть ещё несколько проблем, которые могут вызывать краш:

### 1.1. 🔴 `STOP_FOREGROUND_REMOVE` требует API 24, а `minSdk = 23`

**`app/src/main/java/com/xcglobe/xclog/FlyMeService.java:116`**
```java
stopForeground(STOP_FOREGROUND_REMOVE);
```

- **Проблема:** Константа `Service.STOP_FOREGROUND_REMOVE` была добавлена в **API 24** (Android 7.0). В `app/build.gradle:9` стоит `minSdk 23` (Android 6.0). На Android 6.0 вызов этой константы вызовет `NoSuchFieldError` при загрузке класса `FlyMeService` — то есть приложение упадёт ещё до `onStartCommand()`, при первом обращении к классу.
- **Исправление:** Использовать числовое значение или `stopForeground(true)` (deprecated, но работает на всех API):

```java
// Было:
stopForeground(STOP_FOREGROUND_REMOVE);

// Стало (вариант A — числовая константа):
stopForeground(1);   // 1 = STOP_FOREGROUND_REMOVE

// Стало (вариант B — старый API):
stopForeground(true);   // deprecated с API 24, но работает на всех версиях

// Стало (вариант C — проверка версии):
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    stopForeground(STOP_FOREGROUND_REMOVE);
} else {
    stopForeground(true);
}
```

### 1.2. 🟡 `startForeground` вызывается после `ContextCompat.startForegroundService` — но всё ещё есть окно в 5 секунд

**`app/src/main/java/com/xcglobe/xclog/App.java:259-265`**
```java
Intent intent = new Intent(activity, (Class<?>) FlyMeService.class);
intent.setAction("com.xcglobe.action.startservice");
try {
    androidx.core.content.ContextCompat.startForegroundService(activity, intent);
} catch (Exception e3) {
    e3.printStackTrace();
}
```

**`app/src/main/java/com/xcglobe/xclog/FlyMeService.java:103-121`**
```java
public int onStartCommand(Intent intent, int i2, int i3) {
    f470f = this;
    String action = intent != null ? intent.getAction() : null;
    if ("com.xcglobe.action.startservice".equals(action)) {
        startForeground(101, m458b());
        if (this.f471g == null) {
            this.f471g = new Handler();
        }
    } else if ("com.xcglobe.action.stopservice".equals(action)) {
        ...
    }
    return START_STICKY;
}
```

- **Что хорошо:** `startForeground` вызывается синхронно в `onStartCommand`, без `Handler.post`. Это правильно.
- **Что осталось:** Если `m458b()` упадёт (например, `getSystemService("notification")` вернёт null, или `createNotificationChannel` бросит), то `startForeground` не вызовется, и через 5 секунд система убьёт приложение с ANR + краш.
- **Исправление:** Обернуть в try-catch:

```java
public int onStartCommand(Intent intent, int i2, int i3) {
    f470f = this;
    String action = intent != null ? intent.getAction() : null;
    if ("com.xcglobe.action.startservice".equals(action)) {
        try {
            startForeground(101, m458b());
        } catch (Exception e) {
            e.printStackTrace();
            stopSelf();   // не оставлять service без foreground
            return START_NOT_STICKY;
        }
        if (this.f471g == null) {
            this.f471g = new Handler();
        }
    } else if ("com.xcglobe.action.stopservice".equals(action)) {
        if (this.f471g != null) {
            this.f471g.removeCallbacks(this.f472h);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            stopForeground(STOP_FOREGROUND_REMOVE);
        } else {
            stopForeground(true);
        }
        stopSelf();
    }
    return START_STICKY;
}
```

### 1.3. 🟡 `App.m444b` — порядок инициализации vs разрешения

**`app/src/main/java/com/xcglobe/xclog/ActivityMain.java:317-348`**
```java
if (!m423h()) {
    C0101l.m541a();
    C0101l.f523H = ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == ... && ...READ_EXTERNAL_STORAGE...;
    C0236d.f1344f = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == ...;
    if (!C0101l.f523H || !C0236d.f1344f) {
        // Запрашиваем разрешения...
        ActivityCompat.requestPermissions(this, ..., 123);
    } else if (!C0095f.m480i().equals(C0099j.m515a("last_run_version"))) {
        C0101l.m541a();
        m417c();
        App.m448d();
    }
    C0094e.m462a();        // ← ВЫЗЫВАЕТСЯ ВСЕГДА, даже без разрешений
    App.m444b(this);        // ← ВЫЗЫВАЕТСЯ ВСЕГДА, даже без разрешений
    ...
}
```

- **Проблема:** Если разрешения ещё не выданы (пользователь видит диалог системы), код **не дожидается** результата `onRequestPermissionsResult`, а сразу вызывает `App.m444b(this)`. Внутри `m444b`:
  - `C0236d.m1042a(activity)` — проверяет GPS, может показать диалог `m1045b` с `AlertDialog.Builder(activity)...create()` — это работает, но диалог появляется **поверх** системного диалога разрешений.
  - `C0236d.m1041a()` → `m1048e()` → `locationManager.requestLocationUpdates(...)` — если `ACCESS_FINE_LOCATION` ещё не выдано, вызов тихо вернётся (на Android 6+), но на некоторых прошивках может бросить `SecurityException`.
  - `C0091b.m461a("external.cfg", "config", true)` → пишет в `getFilesDir()` (не требует разрешений) — ок.
  - `AsyncTaskC0066g.m348a(C0239g.m1073d())` → запускает AsyncTask, который читает waypoints.cup из хранилища — если `f523H = false` (нет storage permission), `m537a` вернёт путь из `getFilesDir()`, что ок.

- **Не крашит напрямую**, но создаёт race condition: системный диалог разрешений + AlertDialog от приложения одновременно.

### 1.4. 🟡 `m423h()` — проверка running service

**`app/src/main/java/com/xcglobe/xclog/ActivityMain.java:213-222`**
```java
private boolean m423h() {
    Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
    while (it.hasNext()) {
        if (FlyMeService.class.getName().equals(it.next().service.getClassName())) {
            return true;
        }
    }
    return false;
}
```

- **Проблема:** На Android 8+ (API 26+) `getRunningServices()` **возвращает только сервисы самого приложения**, а не все системные. Это значит, что проверка работает для собственного `FlyMeService`, но это устаревший API.
- **Не крашит**, но если `FlyMeService` уже запущен (например, после поворота экрана), то `m423h()` вернёт `true`, и блок `if (!m423h())` не выполнится — приложение будет использовать уже запущенный service. Это нормально.
- **На Android 14+** — `getRunningServices` deprecated, но работает.

### 1.5. 🟡 `App.m444b(this)` — вызывается всегда, даже если service уже запущен

**`app/src/main/java/com/xcglobe/xclog/ActivityMain.java:344`**
```java
C0094e.m462a();
App.m444b(this);          // ← ВНУТРИ вызывается ContextCompat.startForegroundService
```

Если `m423h()` вернул `true` (service уже запущен), этот блок не выполнится — ок. Но если `m423h()` вернул `false` (service не запущен), то `App.m444b(this)` вызовет `startForegroundService` — и `FlyMeService.onStartCommand` вызовет `startForeground`. Это правильно.

Но если service уже запущен и пользователь переоткрыл активити — `App.m444b` НЕ вызывается, и `startForeground` НЕ вызывается повторно. Это может быть проблемой, если service был остановлен системой (low memory) — `m423h()` может вернуть `false`, и тогда всё ок.

### 1.6. 🟡 `App.m438a(this)` после `super.onCreate()` — но `setTheme(R.style.AppThemeWhite)` после `setContentView`?

Нет, проверим порядок:

**`app/src/main/java/com/xcglobe/xclog/ActivityMain.java:311-353`** (текущий коммит):
```java
public void onCreate(Bundle bundle) {
    f433d = this;
    App.m440a((String) null);    // ← читает SharedPreferences
    super.onCreate(bundle);      // ← super ПЕРВЫМ
    App.m438a(this);             // ← setTheme(AppThemeWhite), getResources(), getWindowManager(), C0096g.m496a()
    this.f476S = true;
    if (!m423h()) {
        ...
        App.m444b(this);
        ...
    }
    App.m446c();                 // ← повторно вызывает C0096g.m500c(...)
    setContentView(com.xcglobe.flyme.R.layout.activity_main2);   // ← ПОСЛЕ setTheme
    this.f436a = (ViewVmp) findViewById(com.xcglobe.flyme.R.id.viewvmp);
    m416b();
}
```

- **Что хорошо:** `setTheme(AppThemeWhite)` вызывается до `setContentView` — это правильно.
- **Что осталось:** В `App.m438a` есть строка 109:
  ```java
  Display defaultDisplay = activityMain.getWindowManager().getDefaultDisplay();
  C0101l.f573aw = defaultDisplay.getHeight();
  C0101l.f574ax = defaultDisplay.getWidth();
  ```
  `Display.getHeight()` и `Display.getWidth()` **deprecated с API 13**. На Android 11+ (API 30) они работают, но возвращают null на некоторых foldable-устройствах. Лучше:
  ```java
  Point size = new Point();
  activityMain.getWindowManager().getDefaultDisplay().getSize(size);
  C0101l.f573aw = size.y;
  C0101l.f574ax = size.x;
  ```
  Не крашит, но может вернуть 0×0 → `f575ay = 0` → `m446c()` делит на 26 → 0, `C0101l.f579d = 0` → `ViewVmp` не отрисуется.

### 1.7. 🟡 `ViewVmp.init()` — `setLayerType(1, null)` deprecated

**`app/src/main/java/display/vmap/ViewVmp.java:278-280`**
```java
if (Build.VERSION.SDK_INT >= 11) {
    setLayerType(1, null);   // ← LAYER_TYPE_SOFTWARE, deprecated
}
```

- `setLayerType(View.LAYER_TYPE_SOFTWARE, null)` deprecated с API 17. На Android 14+ работает, но warning.
- **Не крашит.**

### 1.8. 🟡 `ViewVmp` — `bmpGlider.getWidth() / 2` если `bmpGlider == null`

**`app/src/main/java/display/vmap/ViewVmp.java:287-289`**
```java
bmpGlider = BitmapFactory.decodeResource(App.m443b().getResources(), R.drawable.arrow_white);
this.bmpGliderCenterX = bmpGlider.getWidth() / 2;   // ← NPE, если decodeResource вернул null
this.bmpGliderCenterY = bmpGlider.getHeight() / 4;
```

- `BitmapFactory.decodeResource` может вернуть `null`, если ресурс `R.drawable.arrow_white` не существует или имеет неверный формат. Проверено — ресурс существует (`app/src/main/res/drawable-mdpi/arrow_white.png`, 223 байта). Не должен вернуть null.
- **Не крашит** в нормальных условиях.

### 1.9. 🟡 `requestLegacyExternalStorage` не работает на Android 11+

**`app/src/main/AndroidManifest.xml:20`**
```xml
<application android:requestLegacyExternalStorage="true" ...>
```

- На Android 10 (API 29) — работает, приложение получает доступ к `/sdcard/xcglobe/`.
- На Android 11+ (API 30+) — **игнорируется системой**, даже если `targetSdk 29` (а у нас `targetSdk 34`).
- Это значит, что `Environment.getExternalStorageDirectory().getPath() + "/xcglobe"` в `C0101l.m562d()` **возвращает путь без доступа** на Android 11+. `file.mkdirs()` вернёт `false`, `file.isDirectory()` вернёт `false`, и `m562d()` вернёт `absolutePath`, но писать туда нельзя — `IOException` в `m461a`.
- **Не крашит напрямую**, но `m461a` (копирование ассетов) тихо возвращает `false`, и приложение работает без `external.cfg`, `demo-task.cup`, `demo.igc` — пользователь видит пустой список полётов.
- **Правильное исправление:** см. §2 ниже.

### 1.10. 🟢 `package="com.xcglobe.flyme"` в манифесте

**`app/src/main/AndroidManifest.xml:3`** — остался, deprecated, warning при сборке.

---

## 2. Рекомендации по хранилищу (Scoped Storage)

Даже после всех правок, `C0101l.m562d()` использует устаревший API. На Android 11+ это работать не будет.

**`app/src/main/java/com/xcglobe/xclog/C0101l.java:877-893`**
```java
// Было:
public static String m562d() {
    String absolutePath;
    if (!f523H) {
        return null;
    }
    if (Environment.getExternalStorageState().equals("mounted")) {
        absolutePath = Environment.getExternalStorageDirectory().getPath() + "/xcglobe";
    } else {
        absolutePath = App.m443b().getDir("xcglobe", 1).getAbsolutePath();
    }
    File file = new File(absolutePath);
    if (file.isDirectory()) {
        return absolutePath;
    }
    file.mkdirs();
    return absolutePath;
}

// Стало (Scoped Storage — работает на всех версиях, не требует разрешений):
public static String m562d() {
    File extDir = App.m443b().getExternalFilesDir(null);
    String absolutePath;
    if (extDir != null) {
        absolutePath = extDir.getAbsolutePath() + "/xcglobe";
    } else {
        absolutePath = App.m443b().getFilesDir().getAbsolutePath() + "/xcglobe";
    }
    File file = new File(absolutePath);
    if (file.isDirectory()) {
        return absolutePath;
    }
    file.mkdirs();
    return absolutePath;
}
```

Путь изменится с `/sdcard/xcglobe/` на `/sdcard/Android/data/com.xcglobe.flyme/files/xcglobe/` — но это **правильный путь** для Android 11+. Старые файлы пользователя нужно мигрировать (один раз при обновлении).

---

## 3. Минимальный чек-лист: что нужно сделать прямо сейчас

### A. 🚨 КРИТИЧНО: Пересобрать APK и удалить устаревший из репозитория

```bash
cd Fly1

# 1. Удалить устаревший APK из git
git rm FlyMe-aligned.apk

# 2. Обновить .gitignore
cat >> .gitignore << 'EOF'
*.apk
FlyMe-aligned.apk
FlyMe.apk
EOF

# 3. Закоммитить
git add .gitignore
git commit -m "Remove stale APK, ignore all .apk files"

# 4. Пересобрать
./gradlew clean
./gradlew assembleDebug --stacktrace 2>&1 | tee build.log

# 5. Проверить, что APK собрался
ls -la app/build/outputs/apk/debug/app-debug.apk
# Размер должен быть ~5 МБ, дата сборки — сегодняшняя

# 6. Сравнить с устаревшим
ls -la FlyMe-aligned.apk
# Дата сборки должна быть СТАРОЙ (если ещё в репозитории) — НЕ ИСПОЛЬЗОВАТЬ ЕГО
```

### B. Установить правильный APK

```bash
# Удалить старую версию (важно! иначе останутся старые данные)
adb uninstall com.xcglobe.flyme

# Установить новый APK
adb install app/build/outputs/apk/debug/app-debug.apk

# Запустить и смотреть лог
adb logcat -c
adb shell am start -n com.xcglobe.flyme/.ActivityMain
sleep 5
adb logcat -d | grep -E "AndroidRuntime|FATAL|com.xcglobe" | head -50
```

### C. Исправить `STOP_FOREGROUND_REMOVE` (API 24+ при minSdk 23)

**`app/src/main/java/com/xcglobe/xclog/FlyMeService.java:116`**
```java
// Было:
stopForeground(STOP_FOREGROUND_REMOVE);

// Стало:
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    stopForeground(STOP_FOREGROUND_REMOVE);
} else {
    stopForeground(true);   // deprecated, но работает на API 23
}
```

### D. (Опционально) Обернуть `startForeground` в try-catch

**`app/src/main/java/com/xcglobe/xclog/FlyMeService.java:108`**
```java
try {
    startForeground(101, m458b());
} catch (Exception e) {
    e.printStackTrace();
    stopSelf();
    return START_NOT_STICKY;
}
```

### E. (Опционально) Мигрировать на Scoped Storage

Заменить `C0101l.m562d()` как описано в §2. Это уберёт зависимость от `requestLegacyExternalStorage` и `WRITE_EXTERNAL_STORAGE` на Android 11+.

---

## 4. Как проверить, что APK собран правильно

После `./gradlew assembleDebug`:

```bash
# 1. Проверить, что APK существует и свежий
ls -la app/build/outputs/apk/debug/app-debug.apk
# Должна быть сегодняшняя дата, размер ~5 МБ

# 2. Проверить, что в манифесте APK есть новые разрешения
python3.13 << 'EOF'
import logging
logging.disable(logging.CRITICAL)
from androguard.core.apk import APK
apk = APK('app/build/outputs/apk/debug/app-debug.apk')
xml = apk.get_android_manifest_axml().get_xml().decode()
print(xml)
EOF

# В выводе должно быть:
# <uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>
# <uses-permission android:name="android.permission.FOREGROUND_SERVICE_LOCATION"/>
# <uses-permission android:name="android.permission.POST_NOTIFICATIONS"/>
# <service ... android:foregroundServiceType="location"/>
# <application ... android:requestLegacyExternalStorage="true" .../>
# versionCode="41" versionName="3.12.2"

# 3. Проверить, что в DEX правильный FlyMeService.onStartCommand
python3.13 << 'EOF'
import logging
logging.disable(logging.CRITICAL)
from androguard.misc import AnalyzeAPK
a, d, dx = AnalyzeAPK('app/build/outputs/apk/debug/app-debug.apk')
for dex in d:
    for c in dex.get_classes():
        if c.name == 'Lcom/xcglobe/xclog/FlyMeService;':
            for m in c.get_methods():
                if m.name == 'onStartCommand':
                    src = m.get_source()
                    if src:
                        print(src)
                        # ДОЛЖНО БЫТЬ: "String action = intent != null ? intent.getAction() : null;"
                        # НЕ ДОЛЖНО БЫТЬ: "p4.getAction().equals(...)" (старый код)
                        # ДОЛЖНО БЫТЬ: "startForeground(101, ..." без Handler.post
            break
EOF

# 4. Проверить, что в DEX правильный FlyMeService.m458b
python3.13 << 'EOF'
import logging
logging.disable(logging.CRITICAL)
from androguard.misc import AnalyzeAPK
a, d, dx = AnalyzeAPK('app/build/outputs/apk/debug/app-debug.apk')
for dex in d:
    for c in dex.get_classes():
        if c.name == 'Lcom/xcglobe/xclog/FlyMeService;':
            for m in c.get_methods():
                if m.name == 'm458b':
                    src = m.get_source()
                    if src:
                        print(src)
                        # ДОЛЖНО БЫТЬ: "setSmallIcon(android.R.drawable.ic_menu_mylocation)"
                        # НЕ ДОЛЖНО БЫТЬ: "setSmallIcon(com.xcglobe.flyme.R$drawable.notification_color)"
                        # ДОЛЖНО БЫТЬ: "FLAG_IMMUTABLE"
            break
EOF

# 5. Проверить, что ActivityMain.onCreate вызывает super ДО m438a
python3.13 << 'EOF'
import logging
logging.disable(logging.CRITICAL)
from androguard.misc import AnalyzeAPK
a, d, dx = AnalyzeAPK('app/build/outputs/apk/debug/app-debug.apk')
for dex in d:
    for c in dex.get_classes():
        if c.name == 'Lcom/xcglobe/xclog/ActivityMain;':
            for m in c.get_methods():
                if m.name == 'onCreate':
                    src = m.get_source()
                    if src:
                        print(src[:2000])
                        # ДОЛЖНО БЫТЬ: super.onCreate(ПЕРВЫМ), потом m438a
                        # НЕ ДОЛЖНО БЫТЬ: m438a(0) -> m440a(0) -> super.onCreate (старый порядок)
            break
EOF
```

---

## 5. Сводная таблица

| # | Проблема | Где | Критичность | Статус в исходниках | Статус в APK |
|---|----------|-----|-------------|---------------------|--------------|
| **0** | **APK не пересобран** | `FlyMe-aligned.apk` | 🔴 КРИТИЧНО | — | ❌ Старый байткод |
| 1 | `STOP_FOREGROUND_REMOVE` требует API 24, `minSdk=23` | `FlyMeService.java:116` | 🔴 КРАШ на Android 6 | ❌ Не исправлено | — |
| 2 | `startForeground` без try-catch | `FlyMeService.java:108` | 🟡 ANR risk | ❌ Не исправлено | — |
| 3 | `FOREGROUND_SERVICE`, `foregroundServiceType`, `POST_NOTIFICATIONS` | `AndroidManifest.xml` | 🔴 КРАШ | ✅ Исправлено | ❌ Нет в APK |
| 4 | `ContextCompat.startForegroundService` | `App.java:262` | 🔴 КРАШ | ✅ Исправлено | ❌ Старый `startService` |
| 5 | `intent.getAction()` null-check | `FlyMeService.java:105` | 🔴 NPE | ✅ Исправлено | ❌ Старый код |
| 6 | `setSmallIcon` с XML shape | `FlyMeService.java:77, 82` | 🔴 Bad notification | ✅ Исправлено | ❌ Старый `R.drawable.notification_color` |
| 7 | `PendingIntent` без `FLAG_IMMUTABLE` | `FlyMeService.java:71-73` | 🔴 КРАШ Android 12+ | ✅ Исправлено | ❌ Старый `0` |
| 8 | `App.m438a(this)` до `super.onCreate()` | `ActivityMain.java:314-315` | 🟡 NPE risk | ✅ Исправлено | ❌ Старый порядок |
| 9 | `requestLegacyExternalStorage="true"` | `AndroidManifest.xml:20` | 🟡 Silent fail Android 11+ | ✅ Исправлено | ❌ Нет в APK |
| 10 | `POST_NOTIFICATIONS` runtime запрос | `ActivityMain.java:331-336` | 🔴 КРАШ Android 13+ | ✅ Исправлено | ❌ Нет в APK |
| 11 | `Environment.getExternalStorageDirectory()` | `C0101l.java:883` | 🟡 Silent fail | ❌ Не исправлено | — |
| 12 | `package="..."` в манифесте | `AndroidManifest.xml:3` | 🟢 warning | ❌ Не исправлено | — |
| 13 | `configChanges` без `screenSize` | `AndroidManifest.xml:33+` | 🟢 glitch | ❌ Не исправлено | — |
| 14 | `Display.getHeight()/getWidth()` deprecated | `App.java:110-111` | 🟡 Может вернуть 0 | ❌ Не исправлено | — |

---

## 6. Итог

**Автор сделал всё правильно в исходниках** — применил 7 из 8 правок из предыдущего отчёта. Но:

1. **APK в репозитории остался старый** (`FlyMe-aligned.apk` — коммит `8ad9c5e`, не `6bae719`). Пользователь, который ставит этот APK, видит старый код и старые краши. Нужно **обязательно** пересобрать и удалить устаревший.

2. **Не исправлено:** `STOP_FOREGROUND_REMOVE` требует API 24, а `minSdk = 23`. Это вызовет `NoSuchFieldError` на Android 6.0 при первом обращении к классу `FlyMeService`.

3. **Рекомендации по хранилищу** (Scoped Storage) не применены — приложение будет работать на Android 10, но на Android 11+ файлы не будут сохраняться корректно.

**Минимальный план действий:**

```bash
# 1. Удалить устаревший APK из репозитория
cd Fly1
git rm FlyMe-aligned.apk
echo "*.apk" >> .gitignore
git add .gitignore
git commit -m "Remove stale APK, ignore .apk files"

# 2. Исправить STOP_FOREGROUND_REMOVE (см. §3.C)

# 3. Пересобрать
./gradlew clean && ./gradlew assembleDebug

# 4. Установить НОВЫЙ APK (не из корня репозитория!)
adb uninstall com.xcglobe.flyme
adb install app/build/outputs/apk/debug/app-debug.apk

# 5. Проверить лог
adb logcat -c
adb shell am start -n com.xcglobe.flyme/.ActivityMain
sleep 5
adb logcat -d | grep -E "AndroidRuntime|FATAL|com.xcglobe"
```

Если после этого приложение всё ещё падает — пришлите вывод `adb logcat` (хотя бы 50 строк с FATAL EXCEPTION), и я найду конкретную причину.

---

## 7. Что проверить, если краш остался

После пересборки и установки **нового** APK:

```bash
# Полный лог с момента запуска
adb logcat -c
adb shell am start -n com.xcglobe.flyme/.ActivityMain
sleep 10
adb logcat -d > /tmp/flyme_logcat.txt

# Найти FATAL EXCEPTION
grep -A 30 "FATAL EXCEPTION" /tmp/flyme_logcat.txt

# Найти сообщения от приложения
grep "com.xcglobe" /tmp/flyme_logcat.txt | head -50

# Найти краши сервиса
grep -E "FlyMeService|startForeground|ForegroundService" /tmp/flyme_logcat.txt | head -20

# Проверить, что Application onCreate отработал
grep -E "App create|FlyMeService.onCreate" /tmp/flyme_logcat.txt
```

Пришлите мне вывод этих команд, и я смогу точно определить причину краша.
