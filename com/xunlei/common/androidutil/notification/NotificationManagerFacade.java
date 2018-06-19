package com.xunlei.common.androidutil.notification;

import android.app.Notification;

public interface NotificationManagerFacade {
    void cancelAllNotifications();

    void cancelNotification(int i);

    void postNotification(int i, Notification notification);
}
