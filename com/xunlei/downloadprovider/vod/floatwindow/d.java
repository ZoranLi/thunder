package com.xunlei.downloadprovider.vod.floatwindow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;

/* compiled from: VodPlayerFloatWindow */
final class d extends BroadcastReceiver {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        context = intent.getAction();
        if ("android.intent.action.SCREEN_ON".equals(context) != null) {
            a.v;
        } else if ("android.intent.action.SCREEN_OFF".equals(context) != null) {
            a.v;
            if (this.a.g == null || this.a.g.t() == null) {
                this.a.A = null;
                return;
            }
            this.a.A = true;
            this.a.c();
            this.a.f.a(true);
        } else {
            if (PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(context) != null) {
                a.v;
                if (this.a.A != null) {
                    this.a.b();
                }
            }
        }
    }
}
