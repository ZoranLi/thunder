package com.xunlei.downloadprovider.pushmessage.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.pushmessage.NotificationService;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;

public abstract class NotificationServicePushNotificationHandler<INFO extends BasePushMessageInfo> extends NotificationManagerPushNotificationHandler<INFO> {
    public void onClick(Context context, INFO info) {
        if (NotificationService.a() != null) {
            stopNotificationService(context);
        }
    }

    public void onDismiss(Context context, INFO info) {
        if (NotificationService.a() != null) {
            stopNotificationService(context);
        }
    }

    public void showNotification(Context context, String str, int i, Notification notification, BasePushBiz basePushBiz) {
        if (NotificationService.a()) {
            basePushBiz = new Intent(context, NotificationService.class);
            basePushBiz.putExtra("notification_tag", str);
            basePushBiz.putExtra(PushResult.NOTIFICATION_ID, i);
            b.a(str, i, notification);
            context.startService(basePushBiz);
            return;
        }
        super.showNotification(context, str, i, notification, basePushBiz);
    }

    private void stopNotificationService(Context context) {
        context.stopService(new Intent(context, NotificationService.class));
    }
}
