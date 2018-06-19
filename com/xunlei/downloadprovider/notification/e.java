package com.xunlei.downloadprovider.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadNotification */
final class e extends BroadcastReceiver {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("accelerate_this_time".equals(intent.getAction()) != null) {
            new StringBuilder("DownloadNotification---onClickReceiver---").append(Thread.currentThread().getId());
            if (intent.hasExtra("bar_or_button") != null) {
                a.a("download_in", "in_vip_speedup");
            }
            this.a.e = true;
            try {
                n.a();
                n.g();
                if (!(c.j() == null || this.a.i == null)) {
                    this.a.i.startActivity(c.b(this.a.i));
                }
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
    }
}
