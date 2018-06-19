package com.xunlei.downloadprovider.launch;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NotificationDialogActivity */
final class c implements OnClickListener {
    final /* synthetic */ NotificationDialogActivity a;

    c(NotificationDialogActivity notificationDialogActivity) {
        this.a = notificationDialogActivity;
    }

    public final void onClick(View view) {
        this.a.finish();
    }
}
