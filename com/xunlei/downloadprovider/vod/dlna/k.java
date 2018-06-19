package com.xunlei.downloadprovider.vod.dlna;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;

/* compiled from: DLNAListDialog */
final class k extends BroadcastReceiver {
    final /* synthetic */ b a;

    k(b bVar) {
        this.a = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.b == null && this.a.o == null) {
            this.a.o = this.a.o ^ 1;
            this.a.v.obtainMessage(4, PushResult.OFFLINE_DOWNLOAD_DONE, 0).sendToTarget();
        }
    }
}
