package com.xunlei.downloadprovider.launch;

import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: NotificationDialogActivity */
final class d implements Runnable {
    final /* synthetic */ NotificationDialogActivity a;

    d(NotificationDialogActivity notificationDialogActivity) {
        this.a = notificationDialogActivity;
    }

    public final void run() {
        NotificationDialogActivity.a(BrothersApplication.getApplicationInstance(), 0);
    }
}
