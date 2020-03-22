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
### Straight up debugging in Android studio ###
Android Studio allows debuging without source or libaries. Before you start, make sure you have CTS downloaded. Since 

Open up Android Studio, top left corner, File> Profile or debug APK. Pick an APK form the testcases folder, and let Android Studio do it's work. After that is done, you should be able to manually atatch a debugger onto the java code, if you provided the java libaries it required.
## Develop CTS test model by Android Studio
### Gradle ###
* Project Root
    * This is where the project is located
    * Source and targeted Java version
* Source sets
    * Points to your manifest
    * Points to your Java source
    * This points to the targeted test that is going to be debug
* Depenencies
    * api files('C:/Users/your-user-name/where-you-stored-it/compatibility-device-util-axt.jar')
    * androidTestImplementation 'androidx.test:<no emoji>runner:1.2.0'
    * androidTestImplementation 'androidx.test:rules:1.2.0'
### Java Codes ###
Follow the template for [JUnit4 rules](https://developer.android.com/training/testing/junit-rules)
* Here is the template
    * ``` 
       @RunWith(AndroidJUnit4.class)
       @LargeTest
        public class MyClassTest {
            @Rule
            public ActivityTestRule<MyClass> activityRule =
                    new ActivityTestRule(MyClass.class);

            @Test
            public void myClassMethod_ReturnsTrue() { ... }}
     * @RunWith is required only if you use a mix of JUnit3 and JUnit4
     * Most of the test classes are originaly private, remember to change that
     * If the test you have contains `setUp()` and `tearDown`
        * Remove the `@Override` and replace with `@Before` and `After`
