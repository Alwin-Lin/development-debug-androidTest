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
 
 Before you run:
 * Is the app debuggable?
    * The default is not debuggable. For apps to be debuggable, you need to see ```android:debuggable=["true"]``` in Android manifest
 * Check device avalibility by typing ```adb shell getprop``` and look for [ro.vendor.build.fingerprint]
    * If it's user/release-keys, add ```android:debuggable=["true"]```
    * If it's userdebug/dev-keys, no action needed
 
The whole test modle only takes a few seconds to run. There is not enought time to manually attatch debugger. Alternativly you can manual run test and attatch debugger. In command line:
 1. ``` adb install %cts_Location%\android-cts\testcases\CtsCarTestCases.apk ```
 2. Run a test case and wait for debugger ``` adb shell am instrument -w -r -e debug true -e class 'android.car.cts.CarTest' android.car.cts/androidx.test.runner.AndroidJUnitRunner ```
    * This is useful because normally a test will be over before you have time to attatch debugger.
 3. Attatch debugger with in Android Studio
    * There is a function to [view and configure breakpoints](https://developer.android.com/studio/debug#breakPointsView) in order to catch exceptions.

 
 # ToDo:
 1. The test module is not [debuggable](https://developer.android.com/guide/topics/manifest/application-element), therefore manual attatch only works on an user debug build. e.g. AVD target Android 9.0(Google APIs)
   * Note: AVD Andorid 9.0(Automotive) is a user build, therefore not debuggable.
 2. Fix dependecy issues to be able ot build APK.
    * You can try and manualy attatching debugger onto a running test. However this test does not allow such action because of it's short run time, hence the need to build an APK.
 3. Provide an end to end example to debug APK, set breakpoint and triggered by manual run test.
