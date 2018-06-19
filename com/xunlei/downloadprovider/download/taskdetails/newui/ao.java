package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.util.k;

/* compiled from: DownloadDetailsActivityFragment */
final class ao extends BroadcastReceiver {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    ao(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if (!(intent == null || "DownloadVodPlayerController.ACTION_PLAY_COMPLETION".equals(intent.getAction()) == null)) {
            DownloadDetailsActivityFragment.q;
            context = d.a().d.t();
            intent = null;
            if (!(this.a.A == null || this.a.A.g() == null)) {
                intent = this.a.A.g().n;
            }
            if (context != null && this.a.i.m_() == null && r3 == null) {
                if (k.e(this.a.f) != null) {
                    DownloadDetailsActivityFragment.l(this.a);
                    return;
                }
                this.a.g();
            }
        }
    }
}
