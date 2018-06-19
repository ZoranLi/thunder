package com.xunlei.downloadprovider.vod.dlna;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DLNAListDialog */
final class o extends BroadcastReceiver {
    final /* synthetic */ b a;

    o(b bVar) {
        this.a = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.b == null) {
            int intExtra = intent.getIntExtra("DeviceId", -1);
            intent = intent.getIntExtra("Flag", -1);
            b.b(this.a.e, intExtra);
            this.a.n.a(this.a.e);
            this.a.v.obtainMessage(5, 3002, intent).sendToTarget();
        }
    }
}
