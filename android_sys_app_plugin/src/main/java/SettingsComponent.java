// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.alwin.asap;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Supports creating and managing a JPanel for the Settings Dialog.
 */
public class SettingsComponent {
    private final JPanel myMainPanel;
    private final JBTextField mSourcePath = new JBTextField();
    private final JBTextField mProjectPath = new JBTextField();

    public SettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Source Path: "), mSourcePath, 1, false)
                .addLabeledComponent(new JBLabel("Project Path: "), mProjectPath, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return mSourcePath;
    }

    @NotNull
    public String getSourcePath() {
        return mSourcePath.getText();
    }

    public void setSourcePath(@NotNull String newSourcePath) {
        mSourcePath.setText(newSourcePath);
    }

    public String getProjectPath() {
        return mProjectPath.getText();
    }

    public void setProjectPath(@NotNull String newProjectPath) {
        mProjectPath.setText(newProjectPath);
    }

}
