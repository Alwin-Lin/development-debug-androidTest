# CTSVerifier
[CTS Verifier](https://source.android.com/compatibility/cts/verifier) provides tests for APIs and functions that can't be tested on a stationary device without manual input.
Similar to [CtsSampleDeviceTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases), there are three folders.

* [ctsVProj](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/ctsVerifier/ctsVProj) 
    * This is Android Studio project folder.
    * Different from the ones in [CtsSampleDeviceTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases) and [CtsCarTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases), ```res.srcDirs ```is added.
* [ctsVSrc](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/ctsVerifier/ctsVSrc)
    * This is modified CTS Verifier source code. Chages are as follows
       * ```@+idandroid:/list```-->```@android:id/list```
       * ```@+idandroid:/empty```-->```@android:id/empty```
       * ```@+idandroid:/test1```-->```@+id/test1```
    * This is downloaded from [Google Git](https://android.googlesource.com/platform/cts/+/master/apps/CtsVerifier/). Curently it does not work with API 28 or 29. More on this in ToDo
* [libs](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCase/libs)
    * Additional libaries that CTS requires 
# Steps: 
 1. Clone this project to your workspace
 2. Open [ctsVProj](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/ctsVerifier/ctsVProj) by Android Studio
    * Similar to [development-debug-androidTest](https://github.com/Alwin-Lin/development-debug-androidTest), build.gradle is setup such that you dont have to change anything. If you want to change the project, or use this as a template, view [Build Configuration File-build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest) for more.
    * The two gradle fiils only differ in the source path
 3. File > Sync Project With Gradle File should be succsesfull
 4. Now you can use Android Studio IDE to explore the project and [manual run test and attatch debugger](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases#manual-run-test-and-attatch-debugger).
 
 # ToDo:
 1. Update CTS verifier source for API 28
 2. After #1, build APK
