package com.xunlei.downloadprovider.pushmessage.notification;

import android.app.Notification;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NotificationServicePushNotificationCache */
public final class b {
    private static Map<String, Notification> a = new HashMap();

    public static void a(String str, int i, Notification notification) {
        a.put(b(str, i), notification);
    }

    public static Notification a(String str, int i) {
        a.get(b(str, i));
        return (Notification) a.remove(b(str, i));
    }

    private static String b(String str, int i) {
        if (str == null) {
            str = "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }
}
