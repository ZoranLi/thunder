package com.xunlei.downloadprovider.download.center;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.xunlei.downloadprovider.b.a;

class DownloadCenterActivity$b extends BroadcastReceiver {
    final /* synthetic */ DownloadCenterActivity a;

    private DownloadCenterActivity$b(DownloadCenterActivity downloadCenterActivity) {
        this.a = downloadCenterActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        context = intent.getAction();
        if (!(context == null || "ACTION_EXIT_PLAYER".equals(context) == null || this.a.isFinishing() != null)) {
            if (VERSION.SDK_INT < 17 || this.a.isDestroyed() == null) {
                a.a(this.a, intent.getLongExtra("EXTRA_STAY_TIME", 0));
            }
        }
    }
}
