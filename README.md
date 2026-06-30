# FlyMe 3.12 Beta — декомпилированный исходный код

Это проект Android Studio, восстановленный из APK `FlyMe_3.12 Beta` (оригинальная версия 3.12 Beta, versionCode 39, package `com.xcglobe.flyme`).

FlyMe — это flight computer для параглайдеров/дельтапланов от [XCSoar](https://github.com/xcglobe/flyme) (Ondřej Konečný). Оригинальный код распространяется открыто; данный архив — **декомпилированная** копия, собранная из APK. Декомпиляция не может дать 100% идентичный исходнику код — некоторые методы содержат смали-псевдокод, а имена обфусцированных классов/полей были переименованы автоматически.

## Что внутри

```
FlyMe_3.12_Beta_Source/
├── build.gradle                 — корневой build-файл
├── settings.gradle              — настройки Gradle
├── gradle.properties            — JVM flags, AndroidX off
├── gradlew / gradlew.bat        — Gradle wrapper
├── gradle/wrapper/              — wrapper jar + properties
├── .gitignore
├── README.md                    — этот файл
└── app/
    ├── build.gradle             — конфигурация модуля
    ├── proguard-rules.pro
    └── src/main/
        ├── AndroidManifest.xml  — манифест (исправлен для AGP 7+)
        ├── java/                — 926 .java файлов
        ├── res/                 — 287 ресурсов (layouts, drawables, strings, ...)
        └── assets/              — 18 ассетов (egm96.dat, demo.igc, waypoints.cup, ...)
```

## Структура пакетов Java

| Пакет                    | Назначение                                                          |
|--------------------------|---------------------------------------------------------------------|
| `com.xcglobe.xclog`      | **Главный код приложения** — Activity, Service, App, бизнес-логика  |
| `com.xcglobe.flyme`      | Сгенерированный класс R (ресурсные ID)                              |
| `display` / `display.vmap` | Отрисовка векторных карт (VMP)                                      |
| `vmaps` / `vmaps.core`   | Ядро работы с картами                                               |
| `types`                  | Типы данных (Coord, GpsVal, PoiPoint, ...)                          |
| `configs`                | Конфигурация и PreferenceActivity                                   |
| `mymenu`                 | Кастомное меню                                                      |
| `flyme_tasks`            | AsyncTask-и (загрузка, импорт, экспорт) — **переименовано с p004b** |
| `flyme_device`           | Подключение датчиков/Bluetooth — **переименовано с p006d**          |
| `flyme_dialogs`          | Кастомные диалоги — **переименовано с p008f**                       |
| `flyme_io`               | Ввод/вывод — **переименовано с p013i**                              |
| `flyme_data`             | Хранилище данных — **переименовано с p019m**                        |
| `flyme_poi`              | Точки POI — **переименовано с p017k**                               |
| `flyme_fileutil`         | Утилиты файлов — **переименовано с p000a**                          |
| `flyme_apphelper`        | Хелперы приложения — **переименовано с p005c**                      |
| `flyme_collection`       | Обобщённая коллекция — **переименовано с p007e**                    |
| `flyme_misc`             | Прочие классы — **переименовано с p011g**                           |
| `flyme_util1`            | Мелкие утилиты — **переименовано с p012h**                          |
| `flyme_intentutil`       | Intent-хелперы — **переименовано с p016j**                          |
| `flyme_writer`           | Запись файлов — **переименовано с p018l**                           |
| `org.bouncycastle.*`     | Крипто-библиотека BouncyCastle (встроена в APK)                     |
| `android.support.v4.*`   | Support Library v4 (встроена в APK, частично обфусцирована)        |
| `android.arch.lifecycle` | Architecture Components Lifecycle (встроена)                        |

### Переименованные обфусцированные пакеты

Изначально jadx дал обфусцированным пакетам имена вида `p000a, p004b, p005c, p006d, ...`, а внутренним под-пакетам support library — `p001a, p002b, p003c` и т.д. Эти имена были заменены на осмысленные (см. таблицу выше). Имена отдельных классов внутри этих пакетов (например `C0172d`, `AsyncTaskC0061b`, `InterfaceC0182n`) оставлены как есть — они валидные Java-идентификаторы, переименование 800+ классов вручную нереалистично.

## Как открыть в Android Studio

1. Установите **Android Studio Iguana (2023.3.1)** или новее.
2. Убедитесь, что установлен JDK 17 (Android Studio поставляется со встроенным).
3. `File → Open` → выберите корневую папку `FlyMe_3.12_Beta_Source`.
4. Дождитесь окончания Gradle Sync (Gradle 8.5 скачается автоматически).
5. Подтвердите установку **Android SDK Platform 26** и **Build-Tools 26.x**, если студия их предложит.

## Сборка

```bash
./gradlew assembleDebug
```

APK появится в `app/build/outputs/apk/debug/app-debug.apk`.

## ⚠️ Важные ограничения декомпиляции

Декомпилированный код **не соберётся из коробки** без ручной правки. Это нормальное явление для любой декомпиляции. Основные проблемы, с которыми вы столкнётесь:

1. **Недекомпилированные методы** — jadx оставил смали-псевдокод в виде комментариев `/* ... */` и бросает `UnsupportedOperationException` в нескольких местах. Затронуто 4 места:
   - `types/C0378r.java` — метод `m1299b(String)` (XML-парсинг)
   - `org/bouncycastle/asn1/ASN1Set.java` — метод `sort()`
   - По паре мелких методов в `flyme_intentutil/C0225a.java` и `android.arch.lifecycle.ReflectiveGenericLifecycleObserver.java`
   
   Эти методы нужно дописать вручную (смали-псевдокод приведён в комментариях).

2. **Конфликт support library** — в APK уже встроена `android.support.v4.*`. В `app/build.gradle` мы подключили её же через Maven (`com.android.support:support-v4:26.1.0`). Если при сборке возникнут дубликаты классов, удалите папку `app/src/main/java/android/support/` и оставьте только Maven-зависимость.

3. **Конфликт BouncyCastle** — то же самое для `org/bouncycastle/`. Можно подключить `org.bouncycastle:bcprov-jdk15on:1.60` и удалить `app/src/main/java/org/bouncycastle/`.

4. **Обфусцированные имена классов** (`C0172d`, `C0069j`, etc.) и полей (`f460a`, `f461b`) — валидны, компилятор их примет, но читаемость хуже. При желании их можно переименовать через Android Studio: `Shift+F6` на любом имени — рефакторинг обновит все ссылки автоматически.

5. **R-класс** — jadx сгенерировал `com/xcglobe/flyme/R.java` вручную. Android Studio также сгенерирует свой R-класс в `app/build/generated/`. Если возникнет конфликт — удалите декомпилированный `R.java`.

6. **Access modifiers** — jadx иногда делает private-методы public (отмечено комментарием `JADX INFO: Access modifiers changed from: ...`). На компиляцию не влияет.

7. **Generic type erasure** — в смали стёрты параметризованные типы, jadx пытается их восстановить, но иногда ошибается. Если компилятор ругается на несоответствие типов — приведите вручную через `(Type) cast`.

## Полезные ссылки

- Оригинальный репозиторий FlyMe: https://github.com/xcglobe/flyme
- jadx (декомпилятор): https://github.com/skylot/jadx
- apktool (декодер ресурсов): https://github.com/iBotPeaches/Apktool

## Источник

- APK: `FlyMe_3.12+Beta_APKPure.apk`
- Размер: 2.18 MB
- Декомпиляция: jadx 1.5.0 (с деобфускацией) + apktool 2.9.3
- Дата сборки архива: 2026-06-30
