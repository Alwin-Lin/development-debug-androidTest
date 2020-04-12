# Modified CTS Test Modules 
The files under [cts](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases/ctsSource/tests/sample/src/android/sample/cts) folder has been modified. Without these changes, we can not build in Android Studio.
* Downloaded CtsSampleDeviceTestCases source from [Pi AOSP Git](https://android.googlesource.com/platform/cts/+/refs/heads/pie-cts-release/tests/sample/), click tgz and unzip to your workspace.
* Modified files are as follows :
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
