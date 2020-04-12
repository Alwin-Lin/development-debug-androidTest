# Createing An Android Studio Project
A [build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/CtsSampleDeviceTestCases/ctsDeviceTestCaseProject/build.gradle) file is the easiest way to create Android Studio project, because Android Studio will generate all nessasary files acordingly. 

To create a project, open build.gradle using android studio

## Build Configuration File - build.gradle 
This is an template and can be reused, you only need to change the Project variables. To learn more check out [The top-level build file](https://developer.android.com/studio/build#top-level)

 Unless you are using this for a different project, you don't need to change anyhting

* Project Variables and their curent value.
    * ```appID``` = 'android.sample.cts'
    * ```srcRoot``` = '../ctsSource/tests/sample'
    * ```appSrc``` = srcRoot + '/src/android/sample'
    * ```testSrc``` = srcRoot + '/src/android/sample/cts'
    * ```compatibilitylib``` = '../libs/compatibility-device-util-axt.jar'
