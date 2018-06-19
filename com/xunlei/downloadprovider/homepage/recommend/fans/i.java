package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: FansActivity */
final class i extends BroadcastReceiver {
    final /* synthetic */ FansActivity a;

    i(FansActivity fansActivity) {
        this.a = fansActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("following_id_list_loaded".equals(intent.getAction()) != null && this.a.c != null) {
            this.a.c.h();
        }
    }
}
