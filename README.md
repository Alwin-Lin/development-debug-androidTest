# Intorduction
Tools to accelerate Android device test development and debug.
# Problems
- Android device [CTS test](https://source.android.com/compatibility/cts)  is hard.
- Developing Android device test takes a long time.
# Tips
## Debug CTS test APK with [Android Studio](https://developer.android.com/studio)
### Setup CTS to run on Windows 10
* Download [CTS](https://source.android.com/compatibility/cts/downloads)
    * Android 9 ARM is used in this
* Add in [CTS.bat](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/debugCTSTestAPK/android-cts/tools)
    * CTS.bat file, it is coppied from [here](https://scottj.idv.tw/blog/2017/05/07/android-cts-v2-under-windows/), and [here](https://github.com/northbright/Notes/blob/master/Android/cts/Run_CTS_under_Windows.md)
* Edit the following variables in CTS.bat
    * ```SDK_ROOT``` Set this to SDK location, i.e. ```C:\Users\[User_ID]\AppData\Local\Android\Sdk``` 
    * ```CTS_ROOT``` Set this to CTS source
* Add CTS to path in windows
    * Windows key> "config" > Control panle > System > Advance System Setting > Enviroment Variables
    * Under Path, add in the following
       * ```C:\Users\[User_ID]\AppData\Local\Android\Sdk\build-tools\28.0.2```
       * ```D:\Google cloud SDK\google-cloud-sdk\bin```
* Check if all those work with by launching CTS.bat
### Debugging in Android studio without source 
Android Studio allows debuging an APK without the source. Before you start, make sure you have Setup CTS to run. 

Open Android Studio, File> Profile or debug APK. Pick an APK form the testcases folder, and let Android Studio do it's work. After that is done, you should be able to manually atatch a debugger onto the java code.

Since some test does have relativly short run time, it is possible that you might not be able to atatch debugger in time. You could try a test that takes more time to run, or build CTS in Android Studio

## Develop a CTS test module in Android Studio
It is easier to develope and debug with Android Studio. [CTS](https://cs.android.com/android/platform/superproject/+/master:cts/;l=1?q=cts) is open source, it is possible to do so. However, CTS uses [a different build system](https://source.android.com/setup/build). You can create Android Studio [Build configuration file](https://developer.android.com/studio/build#build-files) to develope and debug the test module.

### Example: CtsSampleDeviceTestCases   
CtsSampleDeviceTestCases is a CTS sample test. To make it work on Android Studio, there are three parts in [developCTSTestModule](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/developCTSTestModule): 
* [ctsDeviceTestCaseProject](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/developCTSTestModule/ctsDeviceTestCaseProject) 
    * This is Android Studio project folder. 
* [ctsSource/tests/sample](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/developCTSTestModule/ctsSource/tests/sample)
    * This is modified CTS test module source code.
* [libs](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/developCTSTestModule/libs)
    * Additional libaries that CTS requires 
#### Steps: 
 1. Clone this project to your workspace
 2. Open ctsDeviceTestCaseProject with Android Studio
 3. You should be able to build and debug the test module in Android Studio 
 
### Create The Android Studio Project
A [build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/developCTSTestModule/ctsDeviceTestCaseProject/build.gradle) file is the easiest way to create Android Studio project, because Android Studio will generate all nessasary files acordingly. 

#### Build Configuration File - build.gradle 
* Project Variables
    * appID = 'android.sample.cts'
    * srcRoot = '../ctsSource/tests/sample'
    * appSrc = srcRoot + '/src/android/sample'
    * testSrc = srcRoot + '/src/android/sample/cts'
    * compatibilitylib = '../libs/compatibility-device-util-axt.jar'
* Android APK Build Configuration File Template
    * The template can be reused, you only need to change Project Variables
    * To learn more check out [The top-level build file](https://developer.android.com/studio/build#top-level)
#### Modify CTS Test Modules 
* Downloaded CtsSampleDeviceTestCases source from [Pi AOSP Git](https://android.googlesource.com/platform/cts/+/refs/heads/pie-cts-release/tests/sample/), click tgz and unzip to your workspace.
* Modify follows to be buildable in Android Studio.
    1. SampleDeviceResultTest.java
      * Change to use activityRule insdead of ```extends ActivityInstrumentationTestCase2```
      * Remove unnessasary dependencies, such as ```SampleDeviceResultTest()```
      * Add ```@Test``` anotations to test cases
    2. SampleDeviceTest.java, besides changes in 1.
      * Remove ```@Override```
      * For ```setUp()```, change to public, and anotate ```@Before```
      * For ```tearDown()```, change to public, and anotate ```@After```
    3. For SampleJUnit4DeviceTest.java and SampleDeviceReportLogTest.java, similar to 1.
    4. Refrence [JUnit4 rules](https://developer.android.com/training/testing/junit-rules).
### Libs
   * CTS module depends on compatibility-device-util-axt.jar
   * It is [built from CTS](https://source.android.com/compatibility/cts/development)
   * This [libary](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/developCTSTestModule/libs) can be used in case you can't build CTS.
