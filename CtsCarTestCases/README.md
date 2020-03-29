### Example: CtsCarTestCase
CtsCarTestCase is a testing module for automotives. To make it work on Android Studio, there are three parts in [CtsSampleDeviceTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases): 
* [ctsCarTestCaseProject](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases/ctsDeviceTestCaseProject) 
    * This is Android Studio project folder. 
* [ctsSource/tests/sample](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases/ctsSource)
    * This is modified CTS test module source code.
* [libs](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCase/libs)
    * Additional libaries that CTS requires 
#### Steps: 
 1. Clone this project to your workspace
 2. Open CtsCarTestCaseProject with Android Studio
    * Similar to [development-debug-androidTest](https://github.com/Alwin-Lin/development-debug-androidTest), build.gradle is setup such that you dont have to change anything. If you want to change the project, or use this as a template, view [Build Configuration File-build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest) for more.
    * The two gradle fiils only differ in the source path
 3. File > Sync Project With Gradle File should be succsesfull
 4. Now you can use Android Studio IDE to explore the project
 
 ### ToDo:
 1. Fix dependecy issues to be able ot build APK

