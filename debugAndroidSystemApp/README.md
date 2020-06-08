# Goal
Generic steps to debug Android system apps by Android Studio.

## Steps:
* Get an Adnroid system app in concern, e.g. SystemUi app. 

  Get the source into C:/workDir/Source/SystemUi, by either:
  *  ```git clone https://android.googlesource.com/platform/frameworks/base --branch android-10.0.0_r39``` 
  * https://android.googlesource.com/platform/frameworks/base/+/refs/tags/android-10.0.0_r39/packages/SystemUI/ Download tgz
* Open it by Android Studio
  * Copy [build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/debugAndroidSystemApp/build.gradle) to C:/workDir/SystemUi
  * Change its appPackage to the package: found in AndroidManifest.xml
  * Change its appRoot to the source path, e.g. C:/workDir/Source/SystemUi
  * In Android Studio, open the project at C:/workDir/SystemUi
*  Debug the code in concern
   * Have a debugable device ready
     * E.g. An Android Emulator, x86 image, target Android 10. 
     * Note: Target Android 10(Google Play) is not debugable
   * Click on Attatch Debugger To Android Process and select the process to atatch to.
     * E.g. com.Android.systemUi![attatchPic](https://user-images.githubusercontent.com/22556115/83983639-e834b680-a8e4-11ea-9a7a-91f7b42a224a.png)
   * Set a breakpoint and trigger by the UI.
     * E.g. Break point set on [line 46](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/packages/SystemUI/src/com/android/systemui/volume/Util.java;l=46), trigger by setting volume to 0
     ![YEET](https://user-images.githubusercontent.com/22556115/83983637-e539c600-a8e4-11ea-85a3-667233f7cfb0.png)
