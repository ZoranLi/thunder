package com.xunlei.downloadprovider.vod.floatwindow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: VodPlayerFloatWindow */
final class e extends BroadcastReceiver {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("other_player_open_action".equals(intent.getAction()) != null) {
            a.v;
            a.a(this.a, context);
        }
    }
}
