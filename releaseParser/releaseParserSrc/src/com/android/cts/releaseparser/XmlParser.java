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
 * limitations under the License.
 */

package com.android.cts.releaseparser;

import com.android.cts.releaseparser.ReleaseProto.*;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.logging.Logger;

public class XmlParser extends com.android.cts.releaseparser.FileParser {
    private com.android.cts.releaseparser.XmlHandler mHandler;
    private HashMap<String, PermissionList> mPermissions;

    public XmlParser(File file) {
        super(file);
    }

    @Override
    public long getFileSize() {
        return mFile.length();
    }

    @Override
    public String getFileContentId() {
        if (NO_ID.equals(mContentId)) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                FileInputStream fis = new FileInputStream(mFile);
                DataInputStream in = new DataInputStream(
                        new BufferedInputStream(fis));
                byte[] dataBytes = new byte[READ_BLOCK_SIZE];
                int nread = 0;
                String line;
                while ((line = in.readLine()) != null) {
                    line = line + '\n';
                    dataBytes = line.getBytes();
                    nread = line.length();
                    md.update(dataBytes, 0, nread);
                }
                // Converts to Base64 String
                mContentId = Base64.getEncoder().encodeToString(md.digest());
            } catch (IOException e) {
                System.err.println("IOException:" + e.getMessage());
            } catch (NoSuchAlgorithmException e) {
                System.err.println("NoSuchAlgorithmException:" + e.getMessage());
            }
        }
        return mContentId;
    }


    @Override
    public Entry.EntryType getType() {
        return Entry.EntryType.XML;
    }

    @Override
    public void setAdditionalInfo() {
        HashMap<String, PermissionList> permissions = getPermissions();
        if (permissions != null) {
            getFileEntryBuilder().putAllDevicePermissions(permissions);
        }
    }

    public HashMap<String, PermissionList> getPermissions() {
        if (mPermissions == null) {
            parse();
        }
        return mPermissions;
    }

    // Todo readPermissions() from frameworks/base/core/java/com/android/server/SystemConfig.java
    // for Feature set
    private void parse() {
        try {
            mHandler = new com.android.cts.releaseparser.XmlHandler(getFileName());
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(mHandler);
            FileReader fileReader = new FileReader(getFile());
            xmlReader.parse(new InputSource(fileReader));
            mPermissions = mHandler.getPermissions();
            fileReader.close();
        } catch (Exception e) {
            // file is not a Test Module Config
            System.err.println("Fail to parse:" + getFileName() + "\n" + e.getMessage());
        }
    }

    private static final String USAGE_MESSAGE =
            "Usage: java -jar releaseparser.jar "
                    + XmlParser.class.getCanonicalName()
                    + " [-options <parameter>]...\n"
                    + "           to prase platform permissions xml file meta data\n"
                    + "Options:\n"
                    + "\t-i PATH\t The file path of the file to be parsed.\n"
                    + "\t-of PATH\t The file path of the output file instead of printing to System.out.\n";

    public static void main(String[] args) {
        try {
            com.android.cts.releaseparser.ArgumentParser argParser = new com.android.cts.releaseparser.ArgumentParser(args);
            String fileName = argParser.getParameterElement("i", 0);
            String outputFileName = argParser.getParameterElement("of", 0);

            File aFile = new File(fileName);
            XmlParser aParser = new XmlParser(aFile);
            Entry.Builder fileEntryBuilder = aParser.getFileEntryBuilder();
            writeTextFormatMessage(outputFileName, fileEntryBuilder.build());
        } catch (Exception ex) {
            System.out.println(USAGE_MESSAGE);
            ex.printStackTrace();
        }
    }

    private static Logger getLogger() {
        return Logger.getLogger(XmlParser.class.getSimpleName());
    }
}
