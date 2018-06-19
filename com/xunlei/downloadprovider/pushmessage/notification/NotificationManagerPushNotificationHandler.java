package com.xunlei.downloadprovider.pushmessage.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.umeng.message.entity.UMessage;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;

public abstract class NotificationManagerPushNotificationHandler<INFO extends BasePushMessageInfo> implements IPushNotificationHandler<INFO> {
    public void showNotification(Context context, String str, int i, Notification notification, BasePushBiz basePushBiz) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.notify(str, i, notification);
        } else {
            basePushBiz.onError(context, "displayNotification, but notificationManager is null");
        }
    }
}
