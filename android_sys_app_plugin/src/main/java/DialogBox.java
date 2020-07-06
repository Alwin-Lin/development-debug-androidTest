package com.alwin.asap;
import android.annotation.Nullable;

import com.intellij.openapi.ui.DialogWrapper;

import net.miginfocom.layout.Grid;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class DialogBox extends DialogWrapper {
    private JTextField mAppSourcePath;
    private JTextField mProjectPath;
    public DialogBox() {
        super(true); // use current window as parent
        init();
        setTitle("Source and output");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new GridBagLayout());

        JLabel app_source_path = new JLabel("App source path",JLabel.TRAILING);
        dialogPanel.add(app_source_path);
        mAppSourcePath = new JTextField(50);
        app_source_path.setLabelFor(mAppSourcePath);
        dialogPanel.add(mAppSourcePath);

        JLabel project_path = new JLabel("Project path",JLabel.TRAILING);
        dialogPanel.add(project_path);
        mProjectPath = new JTextField(50);
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
