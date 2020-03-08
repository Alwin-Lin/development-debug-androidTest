# Intorduction
Tools to accelerate Android device test development and debug.
# Problems
- Android device [CTS test](https://source.android.com/compatibility/cts)  is hard.
- Developing Android device test takes a long time.
# Tips
## Debug CTS test APK with [Android Studio](https://developer.android.com/studio)
After uppacking the targeted APK, Android studio will promt that you add in the java libaries
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
