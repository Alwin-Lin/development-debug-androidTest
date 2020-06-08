# Goal
To create a template that can be used for future projects.

## Steps:
* Two ways of getting source
  *  ```git clone https://android.googlesource.com/platform/frameworks/base --branch android-10.0.0_r39``` 
  * https://android.googlesource.com/platform/frameworks/base/+/refs/tags/android-10.0.0_r39/packages/SystemUI/ Download tgz
* In build.gradle
  * Set appPackage to the package: found in AndroidManifest.xml
  * Set appRoot to source path
* Sync and attatching debugger
  * Open build.gradle with Android Studio
  * Launch an emulator
  * Click on Attatch Debugger To Android Process and select the process to atatch to.
  E.g. com.Android.systemUi
  ![attatchPic](https://user-images.githubusercontent.com/22556115/83983639-e834b680-a8e4-11ea-9a7a-91f7b42a224a.png)
  * Set breakpoints and debug the Java code.
    E.g. ![YEET](https://user-images.githubusercontent.com/22556115/83983637-e539c600-a8e4-11ea-85a3-667233f7cfb0.png)
