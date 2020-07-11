// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.alwin.asap;

import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.editor.*;

import javax.swing.*;

/**
 * Supports creating and managing a JPanel for the Settings Dialog.
 */
public class SettingsComponent {
    private final JPanel myMainPanel;
    private final JBTextField mSourcePath = new JBTextField();
    private final JBTextField mProjectPath = new JBTextField();
    private final Editor mBuildGradleEditor;
    private long myLastDocumentModificationStamp;

    public SettingsComponent() {
        mBuildGradleEditor = createEditor();
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Source Path: "), mSourcePath, 1, false)
                .addLabeledComponent(new JBLabel("Project Path: "), mProjectPath, 1, false)
                .addComponent(new JBLabel("Build.Gradle template: "))
                .addComponent(mBuildGradleEditor.getComponent())
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    // Editor cannot process Windows lineSeperator
    public String getStringForEditor(String inputString) {
        return inputString.replaceAll("\r\n","\n");
    }

    @Nullable
    private Editor createEditor() {
        com.alwin.asap.SettingState settings = com.alwin.asap.SettingState.getInstance();
        EditorFactory editorFactory = EditorFactory.getInstance();
        Document editorDocument = editorFactory.createDocument(getStringForEditor(settings.buildGradleTemplate));
        EditorEx editor = (EditorEx)editorFactory.createEditor(editorDocument);
        fillEditorSettings(editor.getSettings());
        myLastDocumentModificationStamp = editor.getDocument().getModificationStamp();
        return editor;
    }

    private static void fillEditorSettings(final EditorSettings editorSettings) {
        editorSettings.setWhitespacesShown(true);
        editorSettings.setLineMarkerAreaShown(false);
        editorSettings.setIndentGuidesShown(false);
        editorSettings.setLineNumbersShown(false);
        editorSettings.setFoldingOutlineShown(false);
        editorSettings.setAdditionalColumnsCount(0);
        editorSettings.setAdditionalLinesCount(1);
        editorSettings.setUseSoftWraps(false);
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

    public String getBuildGradleTemplate() {
        return mBuildGradleEditor.getDocument().getText();
    }

//    public void setBuildGradleTemplate(@NotNull String buildGradleTemplate) {
//        mBuildGradleEditor.getDocument().setText(buildGradleTemplate);
//    }

}
