# Get [the source](https://android.googlesource.com/platform/cts/+/refs/heads/master/tools/release-parser/) from Android.
* Put it at [releaseParserSrc](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/releaseParser/releaseParserSrc) folder

## Configuring build.gradle
* ```javSrc```  is set to ```'../releaseParserSrc/src'```, if altered the project will not reconize some packages in the source.
	* Set only to ```/src``` instead of ```com/android/cts/releaseparser```, com/android... is a part of the package name, don't set it as src root.
* ```testExecutePath``` is set to ```java_home + '/bin/java'```, for this to work you must have JAVA_HOME setup as an environmetal variable.
	* Here is how to [setup JAVA_HOME](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html)

# Create a new Android Studio project at [releaseParserProj](https://github.com/Alwin-Lin/development-debug-androidTest/tree/master/releaseParser/releaseParserProj)
* Create [build.gradle](https://github.com/Alwin-Lin/development-debug-androidTest/blob/master/releaseParser/releaseParserProj/build.gradle), which can be opened by Android Studio File> Open ...
* To build, click on the green triangle next to ```jar {``` in build.gradle
	* Output can be found under releaseParserProj/build/libs
* In Android Studio Add Configuration> Gradle> Gradle Project> releaseParserProj. Under Task> Run. Then apply
	* To run, Run> Run...
## Run the program
* In comand line ```java -jar .\releaseParserProj\build\libs\releaseParserProj.jar```
## Run/Debug test
### Run a single test, class, or package.
* Install Java 9
* Select and run a single test by clicking on the green triangle found next to a package, class or test case, e.g. testSoApk
* Open Edit Run/Debug configuration dialoge> Edit configuration... e.g. ApkParserTest.testSoApk
* Set JRE to Java 9 e.g. C:\Program Files\Java\jdk-14.0.1
* Run the test again
### Run and debug test from build.gradle
In build.gradle
* Set ```testExecutePath``` to your JRE, e.g. C:\Program Files\Java\jdk-14.0.1\bin\java.exe
* Click on the green triangle next to test

# Google Cloud Build
This peoject can be adapted for Google Cloud Build with the following steps:
* Clone the project onto Google Cloud Shell
* Create JRE container immages with [Google Cloud Build community images](https://github.com/Alwin-Lin/cloud-builders-community)
	* ``` gcloud builds submit --config=cloudbuild-ndk-jre11.yaml --substitutions=_ANDROID_VERSION=29``` 
	* Builds image with cloudbuild-ndk-jre11.yaml
* Setup buckets
* Build ```gcloud builds submit --config=cloudbuild-ndk-jre11.yaml --substitutions=_ANDROID_VERSION=29```
	* ```./testCloudBuildLocal.sh``` does the same thing.
## interacting with images in GCP
Here are some command lines that can be used for testing docker image
* docker image inspect <ID>
	* Inspects the image
	* Used for chekcing if the paths inside are setup correctly
* docker run -t -d --rm --name sdk <ID> bash
	* Runs <ID> docker immage
* docker exec -ti sdk sh -c "<COMMAND_PROMP>"
	* Executes <COMMAND_PROMP> on the running docker image
* docker stop <CONTAINER_ID>
	* Stops the running docker
* docker ps
	* Checks the running docker status 
