Download location: https://android.googlesource.com/platform/cts/+/refs/heads/master/tools/release-parser/
This is the master branch, always use this
Make a gradle file that builds jar:
1. buildscript reposetory and dependencies
	 * Under reposetory
		```mavenCentral()```
	 * Under dependencies, including the one in allprojects 
		``` classpath 'com.android.tools.build:gradle:4.0.0-beta05'
        // https://github.com/google/protobuf-gradle-plugin
        classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.12' ```
2. Plugins
	 * apply plugin: 'java'
	 * apply plugin: 'java-library'
	 * apply plugin: 'com.google.protobuf'
3. Java Version
	 * ```sourceCompatibility = JavaVersion.VERSION_1_8```
     * ```targetCompatibility = JavaVersion.VERSION_1_8```
	 
4. Changeable paths, don't touch this unless nessesary
	 * ``` def srcRoot = '../releaseParserSrc'
	 def javSrc = srcRoot + '/src/com/android/cts/releaseparser'
	 def protoSrc = srcRoot + '/proto'
	 def libRoot = '../libs' ```
5. Add protobuf to ```sourceSets```
	 * ```srcDir protoSrc```
6. Add in protobuf
	 *```protobuf {
        // Configure the protoc executable
        protoc {
            // Download from repositories
            artifact = 'com.google.protobuf:protoc:3.11.0'
        }
    }```
7. Dependecies
	 *  ```compile 'com.google.protobuf:protobuf-java:3.11.0'
        compile fileTree(dir: libRoot, include: ["*.jar"])```