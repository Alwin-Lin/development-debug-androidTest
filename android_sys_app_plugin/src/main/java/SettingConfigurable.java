// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.alwin.asap;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Provides controller functionality for application settings.
 */
public class SettingConfigurable implements Configurable {
    private com.alwin.asap.SettingsComponent mySettingsComponent;

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP

    @Override
    public String getDisplayName() {
        return "ASAP: Android system plugin";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return mySettingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mySettingsComponent = new com.alwin.asap.SettingsComponent();
        return mySettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        com.alwin.asap.SettingState settings = com.alwin.asap.SettingState.getInstance();
        boolean modified = !mySettingsComponent.getSourcePath().equals(settings.sorucePath);
        modified |= !mySettingsComponent.getProjectPath().equals(settings.projectPath);
        modified |= !mySettingsComponent.getBuildGradleTemplate().equals(settings.buildGradleTemplate);
        return modified;
    }

    @Override
    public void apply() throws ConfigurationException {
        com.alwin.asap.SettingState settings = com.alwin.asap.SettingState.getInstance();
        settings.sorucePath = mySettingsComponent.getSourcePath();
        settings.projectPath = mySettingsComponent.getProjectPath();
        settings.buildGradleTemplate = mySettingsComponent.getBuildGradleTemplate();
    }

    @Override
    public void reset() {
        com.alwin.asap.SettingState settings = com.alwin.asap.SettingState.getInstance();
        mySettingsComponent.setSourcePath(settings.sorucePath);
        mySettingsComponent.setProjectPath(settings.projectPath);
//        mySettingsComponent.setBuildGradleTemplate(settings.buildGradleTemplate);
    }

    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }

}
