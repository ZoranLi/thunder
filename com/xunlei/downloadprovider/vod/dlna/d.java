package com.xunlei.downloadprovider.vod.dlna;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DLNAListDialog */
final class d extends BroadcastReceiver {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.b == null) {
            this.a.v.obtainMessage(5, 3000, 0).sendToTarget();
        }
    }
}
