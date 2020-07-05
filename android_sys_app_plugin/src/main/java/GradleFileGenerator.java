package com.alwin.asap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GradleFileGenerator {
    private String mSourcePath;
    private String mOutputPath;
    private String mGradleFileTemplate;
    private String mAppName;
    private String mPackageName;
    private String mBuildFileName;

    public GradleFileGenerator(String sourcePath, String outputPath, String gradleFileTemplate) {
        mSourcePath = sourcePath;
        mOutputPath = outputPath;
        mGradleFileTemplate = gradleFileTemplate;
        mBuildFileName = "build.gradle";
    }

    public String getPackageName() {
        if ( mPackageName == null) {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(
                        mSourcePath + "/AndroidManifest.xml"));
                String line = reader.readLine();
                while (line != null) {
                    // Look for "package ="
                    //    package="android.car.cts">
                    Pattern pattern = Pattern.compile("\\s*package=\"(.*)\"");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find())
                    {
                        mPackageName = matcher.group(1);
                        break;
                    }
                    // read next line
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mPackageName;
    }

    public String getSourceCodePath() {
        return mSourcePath;
    }

    public static InputStream openResourceAsStream(Class clazz, String fileName) {
        InputStream input = clazz.getResourceAsStream("/" + fileName);
        return input;
    }

    public static InputStreamReader openResourceAsStreamReader(Class clazz, String fileName) {
        return new InputStreamReader(
                openResourceAsStream(clazz, fileName), Charset.forName("UTF-8"));
    }

    // Generate a build.gradle file to mOutputPath, with correct AppPackageName and SourceCodePath
    public void createBuildGradleFile() {

        // Looks for build.gradle in resource
        File gradleFileTemplate = new File(getClass().getClassLoader().getResource(mBuildFileName).getFile());
        File appGradleFile = new File(mOutputPath + "/" + mBuildFileName);
        String line = null;

        InputStreamReader buildFileInputStringReadre = openResourceAsStreamReader(getClass(), mBuildFileName);
        BufferedReader buildFileBufferReader = new BufferedReader(buildFileInputStringReadre);
        StringBuilder outputStringBuilder = new StringBuilder();
        try{
            while ((line = buildFileBufferReader.readLine()) != null) {
                // Finds [APP.PACKAGE.NAME] and replaces it with mPackageName
                String textToEdit1 = "APP_PACKAGE_NAME";
                String newLine = line.replaceFirst(textToEdit1, getPackageName());

                // Finds [PATH/TO/SOURCE] and replaces it with mInputPath
                String textToEdit2 = "PATH_TO_SOURCE";
                newLine = newLine.replaceFirst(textToEdit2, getSourceCodePath());

                outputStringBuilder.append(newLine + System.lineSeparator());
            }

            // Writes outputStringBuilder content to build.gradle
            FileWriter fstream = new FileWriter(appGradleFile);
            BufferedWriter outobj = new BufferedWriter(fstream);
            outobj.write(outputStringBuilder.toString());
            outobj.close();

        // Prints error if exist
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}

