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
    private String mPackageName;
    private String mBuildGradleTemplate;

    public GradleFileGenerator(String sourcePath, String outputPath, String buildGradleTemplate) {
        mSourcePath = sourcePath;
        mOutputPath = outputPath;
        mBuildGradleTemplate = buildGradleTemplate;
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


    // Generate a build.gradle file to mOutputPath, with correct AppPackageName and SourceCodePath
    public void createBuildGradleFile() {
        File appGradleFile = new File(mOutputPath + "/build.gradle");
        String newBuildGradle = mBuildGradleTemplate.replaceFirst("APP_PACKAGE_NAME", getPackageName());
        newBuildGradle =  newBuildGradle.replaceFirst("PATH_TO_SOURCE", getSourceCodePath());
        try{
            // Writes newBuildGradle content to build.gradle
            FileWriter fstream = new FileWriter(appGradleFile);
            BufferedWriter outobj = new BufferedWriter(fstream);
            outobj.write(newBuildGradle);
            outobj.close();
        // Prints error if exist
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}

