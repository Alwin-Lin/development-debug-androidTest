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
 
 # Manual run test and attatch debugger
 The whole test modle only takes a few seconds to run. There is not enought time to manually attatch debugger. Alternativly you can manual run test and attatch debugger
 1. adb install %cts_Location%\android-cts\testcases\CtsCarTestCases.apk 
 2. adb shell am instrument -w -r    -e debug true -e class 'android.car.cts.CarTest' android.car.cts/androidx.test.runner.AndroidJUnitRunner
 3. Attatch debugger with in android studio
    * There is a function to [view and configure breakpoints](https://developer.android.com/studio/debug#breakPointsView) in order to catch exceptions

 
 # ToDo:
 1. Fix dependecy issues to be able ot build APK
    * You can try and manualy attatching debugger onto a running test. However this test does not allow such action because of it's short run time, hence the need to build an APK
