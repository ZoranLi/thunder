package com.xunlei.downloadprovider.vod.dlna;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DLNAListDialog */
final class p extends BroadcastReceiver {
    final /* synthetic */ b a;

    p(b bVar) {
        this.a = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        context = intent.getIntExtra("Flag", -1);
        if (this.a.b == null && context == 2) {
            this.a.e();
        }
    }
}
