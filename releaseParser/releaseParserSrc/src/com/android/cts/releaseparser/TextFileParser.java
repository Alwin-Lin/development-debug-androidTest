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

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

// TextFileParser can handle text file with different newline control characters in Windows and Linux.
// This converts to \n, Linux.
public class TextFileParser extends FileParser {
    protected static final int INVALID_SIZE = -1;
    protected static final char NEWLINE_CONTROL_CHAR = '\n';
    protected int mFileSize;


    public TextFileParser(File file) {
        super(file);
        mFileSize = INVALID_SIZE;
    }

    @Override
    public long getFileSize() {
        if (INVALID_SIZE == mFileSize) {
            getFileContentId();
        }
        return mFileSize;
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
                int fileSize = 0;
                while ((line = in.readLine()) != null) {
                    line = line + NEWLINE_CONTROL_CHAR;
                    dataBytes = line.getBytes();
                    nread = line.length();
                    md.update(dataBytes, 0, nread);
                    fileSize = fileSize + nread;
                }
                mFileSize = fileSize;
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
}