package com.alwin.asap;

import android.annotation.Nullable;

import com.intellij.openapi.ui.DialogWrapper;

import java.awt.FlowLayout;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class NewProjectDialogBox extends DialogWrapper {
    private com.alwin.asap.JFilePicker mAppSourceDirPicker;
    private com.alwin.asap.JFilePicker mOutputDirPicker;
    private String mDefaultSourcePath;
    private String mDefaultProjectPath;
    public NewProjectDialogBox(String defaultSourcePath, String defaultProjectPath) {
        super(true); // use current window as parent
        mDefaultProjectPath = defaultProjectPath;
        mDefaultSourcePath = defaultSourcePath;
        mAppSourceDirPicker = null;
        mOutputDirPicker = null;
        init();
        setTitle("Source and output");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new FlowLayout());
        mAppSourceDirPicker = new com.alwin.asap.JFilePicker("Pick the source dir", "Browse...");
        mAppSourceDirPicker.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        mAppSourceDirPicker.setMode(com.alwin.asap.JFilePicker.MODE_SAVE);
        mAppSourceDirPicker.setFilePath(mDefaultSourcePath);
        dialogPanel.add(mAppSourceDirPicker);

        mOutputDirPicker = new com.alwin.asap.JFilePicker("Pick the output dir", "Browse...");
        mOutputDirPicker.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        mOutputDirPicker.setMode(com.alwin.asap.JFilePicker.MODE_SAVE);
        mOutputDirPicker.setFilePath(mDefaultProjectPath);
        dialogPanel.add(mOutputDirPicker);

        dialogPanel.setSize(520, 200);
        return dialogPanel;
    }

    public String getAppSourcePath(){
        return mAppSourceDirPicker.getFilePath();
    }

    public String getOutputPath(){
        return mOutputDirPicker.getFilePath();
    }
}
