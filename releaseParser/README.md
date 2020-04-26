# Get [the source](https://android.googlesource.com/platform/cts/+/refs/heads/master/tools/release-parser/) from Android.
* Put it at [releaseParserSrc](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/releaseParser/releaseParserSrc) folder

# Create a new Android Studio project at [releaseParserProj](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/releaseParser/releaseParserProj)
* Create [build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/releaseParser/releaseParserProj/build.gradle), which can be opened by Android Studio File> Open ...
* To build, click on the green triangle next to ```jar {``` in build.gradle
	* Output can be found under releaseParserProj/build/libs
## Run the program
* In comand line ```java -jar .\releaseParserProj\build\libs\releaseParserProj.jar```
