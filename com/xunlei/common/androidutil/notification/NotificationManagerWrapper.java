package com.xunlei.common.androidutil.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.umeng.message.entity.UMessage;

public class NotificationManagerWrapper implements NotificationManagerFacade {
    private static NotificationManagerWrapper mInstance;
    private Context mContext;
    private NotificationManager mNotificationManager = ((NotificationManager) this.mContext.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION));

    private NotificationManagerWrapper(Context context) {
        this.mContext = context;
    }

    public static synchronized NotificationManagerWrapper getInstance(Context context) {
        synchronized (NotificationManagerWrapper.class) {
            if (mInstance == null) {
                mInstance = new NotificationManagerWrapper(context);
            }
            context = mInstance;
        }
        return context;
    }

    public void postNotification(int i, Notification notification) {
        this.mNotificationManager.notify(i, notification);
    }

    public void cancelNotification(int i) {
        this.mNotificationManager.cancel(i);
    }

    public void cancelAllNotifications() {
        this.mNotificationManager.cancelAll();
    }
}
