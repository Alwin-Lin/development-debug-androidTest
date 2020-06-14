# Goal
Generic steps to debug Android system apps by Android Studio.

## Steps:
* Get the souce of an Adnroid system app in concern

  E.g. Put systemUi app into C:/workDir/Source/SystemUi, by either:
  *  ```git clone https://android.googlesource.com/platform/frameworks/base --branch android-10.0.0_r39``` 
  * https://android.googlesource.com/platform/frameworks/base/+/refs/tags/android-10.0.0_r39/packages/SystemUI/ Download tgz
  * Or whatever APK in Android, e.g. [CtsCarTestCase](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases#ctscartestcase)
  
* Open it by Android Studio
  * Copy [build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/debugAndroidSystemApp/build.gradle) to C:/workDir/SystemUi
  * Edit the build.gradle for the app
    * appPackage to [the package in the AndroidManifest.xml](https://cs.android.com/android/platform/superproject/+/master:cts/tests/tests/systemui/AndroidManifest.xml;l=19), e.g. android.systemui.cts
    * appRoot to the source path, e.g. C:/workDir/Source/SystemUi
  * In Android Studio, open the project at C:/workDir/SystemUi
* Install new APK if needed
  * Only if you have a new APK, otherwise you can just debug the one in the test device.
  * Need to install manualy by [ADB](https://developer.android.com/studio/command-line/adb#pm) because you cannot build the APK in Android studio without resolve all dependencies. 
   
*  Debug the code in concern
   * Have a test device ready. There are two ways to make it debugable
     * The test device is debugable
        * E.g. An Android Emulator, x86 image, target Android 10.
        * Note: Target Android 10(Google Play) is not debugable
     *  [The app is debugable](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/debugAndroidSystemApp/README.md#make-an-app-debuggable)
   * Attatch to the app process.
     * Click on Attatch Debugger To Android Process and select the process to atatch to.
     * E.g. com.Android.systemUi![attatchPic](https://user-images.githubusercontent.com/22556115/83983639-e834b680-a8e4-11ea-9a7a-91f7b42a224a.png)
   * Set a breakpoint and trigger by the UI.
     * E.g. Break point set on [line 46](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/packages/SystemUI/src/com/android/systemui/volume/Util.java;l=46), trigger by setting volume to 0
     ![YEET](https://user-images.githubusercontent.com/22556115/83983637-e539c600-a8e4-11ea-85a3-667233f7cfb0.png)
# Tips
## Make an app debuggable
* Set [android:debuggable="true"](https://developer.android.com/guide/topics/manifest/application-element#debug) in the AndroidManifest.xml
## [Manuall debug a test run](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/CtsCarTestCases/README.md#manually-run-a-test-case-to-allow-manually-attatch-debugger)
