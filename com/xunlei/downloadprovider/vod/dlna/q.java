package com.xunlei.downloadprovider.vod.dlna;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DLNAListDialog */
final class q extends BroadcastReceiver {
    final /* synthetic */ b a;

    q(b bVar) {
        this.a = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.b == null) {
            this.a.v.sendMessageDelayed(this.a.v.obtainMessage(5, 3001, 0), 1000);
        }
    }
}
