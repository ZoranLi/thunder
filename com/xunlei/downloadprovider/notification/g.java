package com.xunlei.downloadprovider.notification;

/* compiled from: NotificationADNotification */
public final class g {
    private static int a;

    public static int a() {
        int i = a + 1;
        a = i;
        if (i >= Integer.MAX_VALUE) {
            a = 1;
        }
        return a;
    }
}
