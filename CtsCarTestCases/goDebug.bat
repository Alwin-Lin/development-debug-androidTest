echo "start an AVD with Android 10 X86_64 image"
adb get shell getprop
echo "Check if it is userdebug build, in [ro.vendor.build.fingerprint] "
adb install -g C:\Users\alwin\ws\android-cts-9.0_r10-linux_x86-x86\android-cts\testcases\CtsCarTestCases.apk
echo "Set breakpoint and attatch debugger "
adb shell am instrument -w -r -e debug true -e class 'android.car.cts.CarTest' android.car.cts/androidx.test.runner.AndroidJUnitRunner
