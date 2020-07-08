package com.alwin.asap;
import android.annotation.Nullable;

import com.intellij.openapi.ui.DialogWrapper;

import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewProjectDialogBox extends DialogWrapper {
    private JTextField mAppSourcePath;
    private JTextField mProjectPath;
    private String mDefaultSourcePath;
    private String mDefaultProjectPath;
    public NewProjectDialogBox(String defaultSourcePath, String defaultProjectPath) {
        super(true); // use current window as parent
        init();
        setTitle("Source and output");
        mDefaultProjectPath = defaultProjectPath;
        mDefaultSourcePath = defaultSourcePath;
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new GridBagLayout());

        JLabel app_source_path = new JLabel("App source path",JLabel.TRAILING);
        dialogPanel.add(app_source_path);
        mAppSourcePath = new JTextField(mDefaultSourcePath,50);
        app_source_path.setLabelFor(mAppSourcePath);
        dialogPanel.add(mAppSourcePath);

        JLabel project_path = new JLabel("Project path",JLabel.TRAILING);
        dialogPanel.add(project_path);
        mProjectPath = new JTextField(mDefaultProjectPath, 50);
        project_path.setLabelFor(mProjectPath);
        dialogPanel.add(mProjectPath);

        return dialogPanel;
    }


    public String getAppSourcePath(){
        return mAppSourcePath.getText();
    }
    public String getOutputPath(){
        return mProjectPath.getText();
    }


}
