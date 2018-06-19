package com.xunlei.downloadprovider.vod.dlna;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DLNAListDialog */
final class l extends BroadcastReceiver {
    final /* synthetic */ b a;

    l(b bVar) {
        this.a = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.b == null) {
            b.a(this.a, intent.getIntExtra("DeviceId", -1));
        }
    }
}
