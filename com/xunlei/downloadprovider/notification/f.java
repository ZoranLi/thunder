package com.xunlei.downloadprovider.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.umeng.message.entity.UMessage;
import com.xunlei.common.androidutil.notification.NotificationManagerFacade;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: DownloadNotificationManager */
final class f implements NotificationManagerFacade {
    private static f a;
    private final String b = "DownloadNotification";
    private NotificationManager c;
    private HashSet<Integer> d = new HashSet(20);

    private f(Context context) {
        this.c = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
    }

    public static synchronized f a(Context context) {
        synchronized (f.class) {
            if (a == null) {
                a = new f(context);
            }
            context = a;
        }
        return context;
    }

    public final void postNotification(int i, Notification notification) {
        this.c.notify("DownloadNotification", i, notification);
        this.d.add(Integer.valueOf(i));
    }

    public final void cancelNotification(int i) {
        this.c.cancel("DownloadNotification", i);
        this.d.remove(Integer.valueOf(i));
    }

    public final void cancelAllNotifications() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            this.c.cancel("DownloadNotification", ((Integer) it.next()).intValue());
        }
        this.d.clear();
    }
}
