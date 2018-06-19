package com.xunlei.downloadprovider.homepage.follow.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: FollowFragment */
final class f extends BroadcastReceiver {
    final /* synthetic */ FollowFragment a;

    f(FollowFragment followFragment) {
        this.a = followFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("user_logout".equals(intent.getAction()) != null) {
            this.a.e.b();
        }
    }
}
