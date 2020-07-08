package com.alwin.asap;

import com.android.tools.idea.gradle.project.importing.GradleProjectImporter;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ex.ProjectManagerEx;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.File;

public class MyAction extends AnAction {
    private final NotificationGroup NOTIFICATION_GROUP = new NotificationGroup("android_sys_app_plugin", NotificationDisplayType.BALLOON, true);

    public Notification notify(Project project, String content) {
        final Notification notification = NOTIFICATION_GROUP.createNotification(content, NotificationType.INFORMATION);
        notification.notify(project);
        return notification;
    }

    @Override
    public void update(AnActionEvent e) {
        // Using the event, evaluate the context, and enable or disable the action.
    }

    @Override
    public void actionPerformed(AnActionEvent actionEvent) {
        com.alwin.asap.NewProjectDialogBox dlg = new com.alwin.asap.NewProjectDialogBox("C:\\Users\\alwin\\ws\\20200708\\development-debug-androidTest\\CtsCarTestCases\\ctsSource", "C:\\Users\\alwin\\ws\\20200708\\development-debug-androidTest\\android_sys_app_plugin\\testing");
        dlg.show();
        if (dlg.isOK()){
            // Edit input file path
            String outputPath = dlg.getOutputPath().replaceAll("\\\\", "/");
            String appSourcePath = dlg.getAppSourcePath().replaceAll("\\\\", "/");
            // Create output directory if not exist
            File outputDir = new File(outputPath);
            if (! outputDir.exists()){
                outputDir.mkdirs();
            }
            com.alwin.asap.GradleFileGenerator gradleFileGenerator = new com.alwin.asap.GradleFileGenerator(appSourcePath, outputPath, "build.gradle");
            gradleFileGenerator.createBuildGradleFile();
            // Open the built project
            try{
                ProjectManagerEx pm = ProjectManagerEx.getInstanceEx();
                Project project = pm.loadProject(outputPath);
                File buildGradleFile = new File(outputPath + "/build.gradle");
                VirtualFile projectFile = LocalFileSystem.getInstance().findFileByIoFile(buildGradleFile);
                // Build.gradle in outputPath, want project
                GradleProjectImporter gradleImporter = GradleProjectImporter.getInstance();
                gradleImporter.importProjectCore(projectFile,project);
            } catch (Exception excp) {
                notify(actionEvent.getProject(), "Fail to open project" + excp.getMessage());
            }
        }
    }
}