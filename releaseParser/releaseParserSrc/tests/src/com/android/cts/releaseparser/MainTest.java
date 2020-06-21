/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.cts.releaseparser;

import com.android.cts.releaseparser.ReleaseProto.Entry;
import com.google.protobuf.TextFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.apache.commons.io.FileUtils;

import java.io.File;

import static org.junit.Assert.assertTrue;

/** Unit tests for {@link ApkParser} */
@RunWith(JUnit4.class)
public class MainTest {
    private static final String PB_TXT = ".pb.txt";
    // HelloActivity.apk's source code: android/cts/tests/tests/jni/AndroidManifest.xml
    private static final String TEST_SIMPLE_APK = "HelloActivity.apk";

    // Shell.apk's source code:
    // android/frameworks/base/packages/Shell/AndroidManifest.xml
    private static final String TEST_SYS_APK = "Shell.apk";

    // CtsJniTestCases.apk's source code:
    // android/development/samples/HelloActivity/AndroidManifest.xml
    private static final String TEST_SO_APK = "CtsJniTestCases.apk";

    private static final String EXPECTED_MAIN_TEST_APK_CVS = "ExpectedMainTestApk.csv";



    @Test
    // ToDo: Validate testReleaseParserReport
    public void testReleaseParser() throws Exception {
        // Prepare a test folder
        String resourceDirPATH = ClassUtils.getResrouceDir(getClass());
        String outputFilePATH = ClassUtils.getTempDir(getClass(), "testReleaseParserReport");
        // Parse the test folder
        // java -jar releaseparser.jar -i resourceDirPATH -o testReleaseParserReport
        // E.g. java -jar releaseparser.jar -i [Temp/dir]/MainTest -o [Temp/dir]/testReleaseParserReport
        String [] argArr ={"-i",resourceDirPATH, "-o", outputFilePATH};
        Main.main(argArr);
        // Validate the parsed result and expected result.
        String expectedCvsString = ClassUtils.getResrouceContentString(getClass(), EXPECTED_MAIN_TEST_APK_CVS);
        String parsedCvsString = ClassUtils.getFileContentString(getClass(), outputFilePATH + "/MainTest---Apk.csv");
        File parseCvsFile = new File(outputFilePATH + "/MainTest---Apk.csv");
        boolean isTwoEqual = expectedCvsString.equals(parsedCvsString);
        assertTrue(
                String.format(
                        "Expected %s\n" +
                                "Parsed %s.\n",
                        expectedCvsString, parsedCvsString),
                isTwoEqual);
    }
}