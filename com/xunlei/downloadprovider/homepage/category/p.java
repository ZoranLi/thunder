package com.xunlei.downloadprovider.homepage.category;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: ShortVideoCategoryActivity */
final class p extends BroadcastReceiver {
    final /* synthetic */ ShortVideoCategoryActivity a;

    p(ShortVideoCategoryActivity shortVideoCategoryActivity) {
        this.a = shortVideoCategoryActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("following_id_list_loaded".equals(intent.getAction()) != null) {
            if (this.a.i != null) {
                this.a.i.c();
            }
        } else if (!("user_logout".equals(intent.getAction()) == null || this.a.i == null)) {
            this.a.i.c();
        }
    }
}
