set SDK_ROOT=C:\Users\alwin\AppData\Local\Android\Sdk
set CTS_ROOT=D:\cts
set JAR_DIR=%CTS_ROOT%\android-cts\tools
set JAR_PATH=%JAR_DIR%\tradefed.jar;%JAR_DIR%\loganalysis.jar;%JAR_DIR%\hosttestlib.jar;%JAR_DIR%\compatibility-common-util-tests.jar;%JAR_DIR%\compatibility-common-util-tests.jar;%JAR_DIR%\cts-tradefed.jar;%JAR_DIR%\cts-tradefed-tests.jar;%JAR_DIR%\compatibility-host-util.jar;%JAR_DIR%\compatibility-tradefed-tests.jar;%JAR_DIR%\host-libprotobuf-java-full.jar
echo  java -Xmx1024M -XX:+HeapDumpOnOutOfMemoryError -cp %JAR_PATH% -DCTS_ROOT=%CTS_ROOT% com.android.compatibility.common.tradefed.command.CompatibilityConsole 

 java -Xmx1024M -XX:+HeapDumpOnOutOfMemoryError -cp %JAR_PATH% -DCTS_ROOT=%CTS_ROOT% com.android.compatibility.common.tradefed.command.CompatibilityConsole

