# BlueTooth

## Contents 
btProj
* Open this folder by Android Studio

btSrc

There are two ways to add source code.
1. Download Android Bluetooth app source from [AOSP](https://android.googlesource.com/platform/packages/apps/Bluetooth/+/refs/tags/android-vts-9.0_r10)
   * All value files are deleated besides the original one as it caused alot of errors

2. Link to your Android tree
   * ``` rm -rf ./bt/btSrc```
   * ``` ln -s /android/packages/apps/Bluetooth $PWD/bt/btSrc```
## Steps
1. Clone to work space
2. Open build.gradle with Android Studio
3. Sync and build

## ToDo:
* Fix bugs, 100 in total
* Allow this to run with all the values files from download
