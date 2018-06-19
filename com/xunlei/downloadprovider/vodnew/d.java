package com.xunlei.downloadprovider.vodnew;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.download.util.k;

/* compiled from: VodPlayerActivityFragment */
final class d extends BroadcastReceiver {
    final /* synthetic */ VodPlayerActivityFragment a;

    d(VodPlayerActivityFragment vodPlayerActivityFragment) {
        this.a = vodPlayerActivityFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if (!(intent == null || "DownloadVodPlayerController.ACTION_PLAY_COMPLETION".equals(intent.getAction()) == null)) {
            VodPlayerActivityFragment.a();
            context = com.xunlei.downloadprovider.d.d.a().d.t();
            boolean z = false;
            if (VodPlayerActivityFragment.c(this.a) != null) {
                intent = VodPlayerActivityFragment.c(this.a).f() != null ? VodPlayerActivityFragment.c(this.a).f().m_() : null;
                if (VodPlayerActivityFragment.c(this.a).g() != null) {
                    z = VodPlayerActivityFragment.c(this.a).g().n;
                }
            } else {
                intent = null;
            }
            if (context == null || r4 != null || r0) {
                VodPlayerActivityFragment.b();
            } else if (VodPlayerActivityFragment.d(this.a) != null) {
                context = VodPlayerActivityFragment.d(this.a).a;
                if (context == null) {
                    VodPlayerActivityFragment.b();
                } else if (k.e(context) != null) {
                    VodPlayerActivityFragment.a(this.a, context);
                } else {
                    VodPlayerActivityFragment.b(this.a, context);
                }
            }
        }
    }
}
