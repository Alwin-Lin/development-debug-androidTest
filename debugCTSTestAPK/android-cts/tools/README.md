# Run CTS in MS Windows 10
The offical CTS [Desk Machine Setup](https://source.android.com/compatibility/cts/setup#desktop_setup) is Linux and Mac specific. With additional steps, it is possible to run CTS on Windows.
The script includes the steps to run CTS on Windwos 10.
1. Install [Android Studio](https://developer.android.com/studio)
2. Download and unpack [CTS](https://source.android.com/compatibility/cts/downloads)
   * The version used is Android 9.0
3. Change [CTS.bat](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/debugCTSTestAPK/android-cts/tools/CTS.bat) to adapt to your enviroment
   1. Specify SDK and CTS paths.   
      * ```SDK_ROOT``` : The location of Android SDK
      * ```CTS_Root``` : The location of unpacked CTS
   2. Add CTS to path in windows.
      * Windows key> "config" > Control panle > System > Advance System Setting > Enviroment Variables
      * Under Path, add in the following
         * ```C:\Users\[User_ID]\AppData\Local\Android\Sdk\build-tools\28.0.2```
         * ```D:\Google cloud SDK\google-cloud-sdk\bin```
   3. Check if all those work with by launching CTS.bat.
