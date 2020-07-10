package com.alwin.asap;
import android.annotation.Nullable;

import com.intellij.openapi.ui.DialogWrapper;


import org.jetbrains.annotations.NotNull;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class NewProjectDialogBox extends DialogWrapper {
    private com.alwin.asap.FilePicker mAppSourceDirPicker;
    private com.alwin.asap.FilePicker mOutputDirPicker;
    private String mDefaultSourcePath;
    private String mDefaultProjectPath;
    public NewProjectDialogBox(String defaultSourcePath, String defaultProjectPath) {
        super(true);
        // From OASAP.java, defaultProjectPath & defaultSourcePath = C:\\
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
        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.PAGE_AXIS));
        mAppSourceDirPicker = new com.alwin.asap.FilePicker("Source dir", "Browse...");
        mAppSourceDirPicker.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        mAppSourceDirPicker.setMode(com.alwin.asap.FilePicker.MODE_OPEN);
        mAppSourceDirPicker.setFilePath(mDefaultSourcePath);
        dialogPanel.add(mAppSourceDirPicker);

        mOutputDirPicker = new com.alwin.asap.FilePicker("Project dir", "Browse...");
        mOutputDirPicker.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        mOutputDirPicker.setMode(com.alwin.asap.FilePicker.MODE_OPEN);
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
