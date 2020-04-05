# CTSVerifier
CTS Verifier provides tests for APIs and functions that can't be tested on a stationary device without manual input.
Similar to [CtsSampleDeviceTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases), there are three parts in [CtsSampleDeviceTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases): 
* [ctsVProj](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/ctsVerifier/ctsVProj) 
    * This is Android Studio project folder.
    * Different from the ones in [CtsSampleDeviceTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases) and [CtsCarTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases), ```res.srcDirs ```is added.
* [ctsVSrc](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/ctsVerifier/ctsVSrc)
    * This is modified CTS test module source code.
* [libs](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCase/libs)
    * Additional libaries that CTS requires 
# Steps: 
 1. Clone this project to your workspace
 2. Open CTSVerifier with Android Studio
    * Similar to [development-debug-androidTest](https://github.com/Alwin-Lin/development-debug-androidTest), build.gradle is setup such that you dont have to change anything. If you want to change the project, or use this as a template, view [Build Configuration File-build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest) for more.
    * The two gradle fiils only differ in the source path
 3. File > Sync Project With Gradle File should be succsesfull
 4. Now you can use Android Studio IDE to explore the project
 
 # ToDo:
 1. Find CTS verifier source for API 28
 2. After #1, build APK
