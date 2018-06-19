package com.xunlei.downloadprovider.pushmessage;

/* compiled from: NotificationService */
final class b implements Runnable {
    final /* synthetic */ NotificationService a;

    b(NotificationService notificationService) {
        this.a = notificationService;
    }

    public final void run() {
        this.a.stopForeground(false);
    }
}
