package com.alwin.asap;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

import javax.swing.JButton;

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
    public void actionPerformed(AnActionEvent e) {
        notify(e.getProject(), "todo Action");
        com.alwin.asap.DialogBox dlg = new com.alwin.asap.DialogBox();
        dlg.show();
        if (dlg.isOK()){
            String outputPath = dlg.getOutputPath();
            String appSourcePath = dlg.getAppSourcePath();
            com.alwin.asap.GradleFileGenerator gradleFileGenerator = new com.alwin.asap.GradleFileGenerator(appSourcePath, outputPath, "build.gradle");
            gradleFileGenerator.createBuildGradleFile();
        }
    }
}