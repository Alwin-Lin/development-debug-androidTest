# Intorduction
Tools to accelerate Android device test development and debug.
# Problems
1. Cannot run CTS on Windows 10. Try this [script](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/debugCTSTestAPK/android-cts/tools/README.md)
- Android device [CTS test](https://source.android.com/compatibility/cts)  is hard.
- Developing Android device test takes a long time.
# Tips
## Debug CTS test APK with [Android Studio](https://developer.android.com/studio)
### Debugging in Android studio without source 
Android Studio allows debuging an APK without the source. Before you start, make sure you have Setup CTS to run. 

Open Android Studio, File> Profile or debug APK. Pick an APK form the testcases folder, and let Android Studio do it's work. After that is done, you should be able to manually atatch a debugger onto the java code.

Debugging with built
![Image of source](https://user-images.githubusercontent.com/22556115/79082733-9fde8b00-7cdd-11ea-8375-c484732a313b.png)

Since some test does have relativly short run time, it is possible that you might not be able to atatch debugger in time. You could try a test that takes more time to run, or build CTS in Android Studio

## Develop a CTS test module in Android Studio
It is easier to develope and debug with Android Studio. [CTS](https://cs.android.com/android/platform/superproject/+/master:cts/;l=1?q=cts) is open source, it is possible to do so. However, CTS uses [a different build system](https://source.android.com/setup/build). You can create Android Studio [Build configuration file](https://developer.android.com/studio/build#build-files) to develope and debug the test module.

## Other examples
 * [CtsCarTestCase](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases)
