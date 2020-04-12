# CtsSampleDeviceTestCases   
CtsSampleDeviceTestCases is a CTS sample test. To make it work on Android Studio, there are three parts in [CtsSampleDeviceTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases): 
* [ctsDeviceTestCaseProject](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases/ctsDeviceTestCaseProject) 
    * This is Android Studio project folder. 
    * Contains : build.gradle
* [ctsSource/tests/sample](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases/ctsSource/tests/sample)
    * This is modified CTS test module source code.
    * Contains : test files
* [libs](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases/libs)
    * Additional libaries that CTS requires
## Steps: 
 1. Clone this project to your workspace
 2. Open ctsDeviceTestCaseProject with Android Studio
 3. You should be able to build and debug the test module in Android Studio 
 
 # Createing An Android Studio Project
A [build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/CtsSampleDeviceTestCases/ctsDeviceTestCaseProject/build.gradle) file is the easiest way to create Android Studio project, because Android Studio will generate all nessasary files acordingly. 

To create a project, open build.gradle using android studio

## Build Configuration File - build.gradle 
This is an template and can be reused, you only need to change the Project variables. To learn more check out [The top-level build file](https://developer.android.com/studio/build#top-level)

 Unless you are using this for a different project, you don't need to change anyhting

* Project Variables and their current value.
    * ```appID``` = 'android.sample.cts'
    * ```srcRoot``` = '../ctsSource/tests/sample'
    * ```appSrc``` = srcRoot + '/src/android/sample'
    * ```testSrc``` = srcRoot + '/src/android/sample/cts'
    * ```compatibilitylib``` = '../libs/compatibility-device-util-axt.jar'
 
 # Modified CTS Test Modules 
The files under [cts](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases/ctsSource/tests/sample/src/android/sample/cts) folder has been modified. Without these changes, we can not build in Android Studio.
1. Download CtsSampleDeviceTestCases source from [Pi AOSP Git](https://android.googlesource.com/platform/cts/+/refs/heads/pie-cts-release/tests/sample/), click tgz and unzip to your workspace.
2. Modify files as follows :
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
 # Libs
   * CTS module depends on compatibility-device-util-axt.jar
   * It is [built from CTS](https://source.android.com/compatibility/cts/development)
   * This [libary](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/developCTSTestModule/libs) can be used in case you can't build CTS.

