# CtsCarTestCase
CtsCarTestCase is a testing module for automotives. To make it work on Android Studio, there are three parts in [CtsSampleDeviceTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases): 
* [ctsCarTestCaseProject](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases/ctsDeviceTestCaseProject) 
    * This is Android Studio project folder. 
* [ctsSource/tests/sample](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases/ctsSource)
    * This is modified CTS test module source code.
* [libs](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCase/libs)
    * Additional libaries that CTS requires 
# Steps: 
 1. Clone this project to your workspace
 2. Open CtsCarTestCaseProject with Android Studio
    * Similar to [development-debug-androidTest](https://github.com/Alwin-Lin/development-debug-androidTest), build.gradle is setup such that you dont have to change anything. If you want to change the project, or use this as a template, view [Build Configuration File-build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest) for more.
    * The two gradle fiils only differ in the source path
 3. File > Sync Project With Gradle File should be succsesfull
 4. Now you can use Android Studio IDE to explore the project
 
 # Manually run a test case to allow manually attatch debugger
 
The whole test modle only takes a few seconds to run. There is not enought time to manually attatch debugger. Alternativly you can manual run test and attatch debugger, assuming it is [debuggable](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/debugAndroidSystemApp/README.md#make-it-debuggable). E.g.
 1. Install the app
 
 ``` adb install -g %cts_Location%\android-cts\testcases\CtsCarTestCases.apk ```
 * This uses "-g" to [Grant all permissions listed in the app manifest.]((https://developer.android.com/studio/command-line/adb#pm))
 * To check the app permission ```adb shell dumpsys package android.car.cts``` and check grantedPermissions section at the bottom of the output.
 2. Run a test case and wait for debugger
 
 ``` adb shell am instrument -w -r -e debug true -e class 'android.car.cts.CarTest' android.car.cts/androidx.test.runner.AndroidJUnitRunner ```
 * This is useful because normally a test will be over before you have time to attatch debugger.
 * This uses "-e debug true" to make it wait for debugger. Check [am instrument options](https://developer.android.com/studio/test/command-line#AMOptionsSyntax)
 * To use it for others:
    * Change android.car.cts.CarTest to the class in concern, the format is package.className
    * Change android.car.cts to the package name, found in [AndroidManifest.xml](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/CtsCarTestCases/ctsSource/AndroidManifest.xml#L18)
    * If it can not find the runner, "androidx.test.runner.AndroidJUnitRunner". Check the instrumentation setting in [AndroidManifest](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/CtsCarTestCases/ctsSource/AndroidManifest.xml#L36)
 3. Attatch debugger with in Android Studio
    * There is a function to [view and configure breakpoints](https://developer.android.com/studio/debug#breakPointsView) in order to catch exceptions.
 * goDebug.bat can be used, swap out the APK different project.
 
 # ToDo:
 1. The test module is not [debuggable](https://developer.android.com/guide/topics/manifest/application-element), therefore manual attatch only works on an user debug build. e.g. AVD target Android 9.0(Google APIs)
   * Note: AVD Andorid 9.0(Automotive) is a user build, therefore not debuggable.
 2. Fix dependecy issues to be able ot build APK.
    * You can try and manualy attatching debugger onto a running test. However this test does not allow such action because of it's short run time, hence the need to build an APK.
 3. Provide an end to end example to debug APK, set breakpoint and triggered by manual run test.
