package com.xunlei.downloadprovider.download.center;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: DownloadCenterActivity */
final class a extends BroadcastReceiver {
    final /* synthetic */ DownloadCenterActivity a;

    a(DownloadCenterActivity downloadCenterActivity) {
        this.a = downloadCenterActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("ACTION_EXIT_PLAYER".equals(intent.getAction()) != null && this.a.isFinishing() == null) {
            if (VERSION.SDK_INT < 17 || this.a.isDestroyed() == null) {
                com.xunlei.downloadprovider.b.a.a(this.a, intent.getLongExtra("EXTRA_STAY_TIME", 0));
            }
        }
    }
}
