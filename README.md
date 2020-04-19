# Intorduction
Android device [CTS test](https://source.android.com/compatibility/cts)  is hard. Developing Android device test takes a long time. Here are some tools and instructions to accelerate Android device test development and debug.

# Problems
1. Cannot run CTS on Windows 10. Try this [script](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/debugCTSTestAPK/android-cts/tools/README.md)
2. No good IDE for CTS test module, and build CTS takes long time. Create an Android Studio project for a CTS test module, e.g. [CtsSampleDeviceTestCases](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases) to develop build and debug.
3. Some CTS tests have a short run time, makeing manualy atatching debugger impossible. We can [manual run test and attatch debugger](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases) using command lines
4. CTS Verifiers needs manual debugging and cannot be triggered by command line. We will provide it with the nessesary source code and set breakpoints in Java code.
# Debug CTS test APK with [Android Studio](https://developer.android.com/studio)
1. [Debug with the APK directly.](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/CtsCarTestCases/README.md)
2. [Create and debug the Android Studio project.](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/CtsCarTestCases/README.md)
3. [Build and debug the Android Studio project.](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsSampleDeviceTestCases)
4. [Manually run a test case to allow manually attatch debugger.](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/CtsCarTestCases/README.md)
## Debug with the APK directly 
Android Studio allows debuging an APK without the building. Before you start, make sure you have Setup CTS to run. 

Open Android Studio, File> Profile or debug APK. Pick an APK form the testcases folder, and let Android Studio do it's work. After that is done, go to the activity that you want to debug and click on the atatch java/kolin source

![atatch java](https://user-images.githubusercontent.com/22556115/79084016-70804c00-7ce6-11ea-90f0-55470c1a78eb.png)

After that is done, you should be able to set a breakpoint and debug the Java code like such.

![Debug Java](https://user-images.githubusercontent.com/22556115/79084017-7118e280-7ce6-11ea-9e03-eab803d36aad.png)

## Create and debug the Android Studio project
It is easier to develope and debug with Android Studio. [CTS](https://cs.android.com/android/platform/superproject/+/master:cts/;l=1?q=cts) is open source, it is possible to do so. However, CTS uses [a different build system](https://source.android.com/setup/build). You can create Android Studio [Build configuration file](https://developer.android.com/studio/build#build-files) to develope and debug the test module.

Examples:
1. [CTS Verifier](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/ctsVerifier)
2. [CtsCarTestCase](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases)

Here is what it looks like after it's built
![Image of source](https://user-images.githubusercontent.com/22556115/79082733-9fde8b00-7cdd-11ea-8375-c484732a313b.png)

# Get CTS source
Here are links to downloading source files in this project. The following are all CTS 9.0_R11
* [CtsDeviceTestCase](https://android.googlesource.com/platform/cts/+/refs/tags/android-cts-9.0_r11/tests/sample/)
* [CtsVerifier](https://android.googlesource.com/platform/cts/+/refs/heads/pie-cts-release/apps/CtsVerifier/)
* [CtsCarTestCase](https://android.googlesource.com/platform/cts/+/refs/tags/android-cts-9.0_r11/tests/tests/car/)

To download, click tgz and unzip to your workspace
## Side notes, branch and tags
The following is a visualisation of a project
* Master
   * Branch for 1.0
     * Tag 1.0.1
     * Tag 1.0.3
     * Tag 1.0.4
   * Branch for 2.0
     * Tag 2.0.1 ...
 If one just clones the release files, they could end up with a different tag, leading to more problems
