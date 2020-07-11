// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.alwin.asap;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Supports storing the application settings in a persistent way.
 * The State and Storage annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(
        name = "org.intellij.sdk.settings.SettingState",
        storages = {@Storage("SdkSettingsPlugin.xml")}
)
public class SettingState implements PersistentStateComponent<SettingState> {

    public String sorucePath = "";
    public String projectPath = "";
    public String buildGradleTemplate = "";

    public static SettingState getInstance() {
        return ServiceManager.getService(SettingState.class);
    }

    @Nullable
    @Override
    public SettingState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull SettingState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

}