# Android Bluetooth app
This is typically built within Android tree. Without a good IDE, it is difficult to develope. This shows you how to setup Android Studio project to help you write and debug the app.
## Folders 
### btProj
Open this folder by Android Studio
* You need Android Studio 4.0 or newer to open jniLibs.

### btSrc
This is souce code of Android Bluetooth app com.android.bluetooth
There are two ways to add source code.
1. Download Android Bluetooth app source from [AOSP](https://android.googlesource.com/platform/packages/apps/Bluetooth/+/refs/tags/android-vts-9.0_r10)
   * All value files are deleated besides the original one as it caused alot of errors

2. Link to your Android tree
   * ``` rm -rf ./bt/btSrc```
   * ``` ln -s /android/packages/apps/Bluetooth $PWD/bt/btSrc```
## Debug
1. Clone the project to your work space
2. Open build.gradle with Android Studio
3. After sync, you can explore the source code
4. Link to your Android tree 
   * You can edit source by Android Studio IDE
   * To biuld the device image within Andorid tree, e.g. [Building AVD images](https://source.android.com/setup/create/avd#building_avd_images) 
   * This app has a unit test, [BluetoothInstrumentationTests](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/bt/btSrc/tests/unit)
   * To build and run the test, use [Atest](https://source.android.com/compatibility/tests/development/atest) E.g. 
      * ```$ atest BluetoothInstrumentationTests```
5. [Manually run a test case to allow manually attatch debugger](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/CtsCarTestCases#manually-run-a-test-case-to-allow-manually-attatch-debugger)
   * Prepare a Device Under Test. E.g.
      * ```$ emulator&```
   * Install APK onto DUT
      * ```$ adb install -r $ANDROID_PRODUCT_OUT/testcases/BluetoothInstrumentationTests/x86_64/BluetoothInstrumentationTests.apk```
   * Run a test in concern
      * ```$ adb shell am instrument -w -r -e debug true -e class 'com.android.bluetooth.avrcpcontroller.AvrcpControllerServiceTest#testInitialize' com.android.bluetooth.tests/androidx.test.runner.AndroidJUnitRunner``` 
   * Create a debug configuration
      * ![Debug config](https://user-images.githubusercontent.com/22556115/82858920-15876a80-9eca-11ea-8b6d-86fa34ca2530.png)
   * Set breakpoints and [attatch the debugger](https://developer.android.com/studio/debug#attach-debugger) in Android Studio
     
    

## ToDo:
* Fix bugs, 100 in total
* Allow this to run with all the values files from download
