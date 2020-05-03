# Get [the source](https://android.googlesource.com/platform/cts/+/refs/heads/master/tools/release-parser/) from Android.
* Put it at [releaseParserSrc](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/releaseParser/releaseParserSrc) folder

# Create a new Android Studio project at [releaseParserProj](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/releaseParser/releaseParserProj)
* Create [build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/releaseParser/releaseParserProj/build.gradle), which can be opened by Android Studio File> Open ...
* To build, click on the green triangle next to ```jar {``` in build.gradle
	* Output can be found under releaseParserProj/build/libs
* In Android Studio Add Configuration> Gradle> Gradle Project> releaseParserProj. Under Task> Run. Then apply
	* To run, Run> Run...
## Run the program
* In comand line ```java -jar .\releaseParserProj\build\libs\releaseParserProj.jar```
## Run/Debug a single test
* Install Java 9
* Select and run a single test by clicking on the green triangle found next to a test case, e.g. testSoApk
* Open Edit Run/Debug configuration dialoge> Edit configuration... e.g. ApkParserTest.testSoApk
* Set JRE to Java 9 e.g. C:\Program Files\Java\jdk-14.0.1
* Run the test again
# ToDo
* Fix error: java.util.regex.PatternSyntaxException: Unexpected internal error near index 1
* Set releaseParserProj test run config to Java 9
	* Right click on com.android.cts.releaseparser> Run
