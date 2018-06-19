package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: FollowActivity */
final class q extends BroadcastReceiver {
    final /* synthetic */ FollowActivity a;

    q(FollowActivity followActivity) {
        this.a = followActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("following_id_list_loaded".equals(intent.getAction()) != null && this.a.c != null) {
            this.a.c.h();
        }
    }
}
