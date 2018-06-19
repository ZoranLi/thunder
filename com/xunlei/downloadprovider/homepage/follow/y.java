package com.xunlei.downloadprovider.homepage.follow;

import java.util.Set;

/* compiled from: FollowManager */
final class y implements Runnable {
    final /* synthetic */ Set a;
    final /* synthetic */ x b;

    y(x xVar, Set set) {
        this.b = xVar;
        this.a = set;
    }

    public final void run() {
        this.b.b.e.getWritableDatabase().delete("following_id_list", null, null);
        this.b.b.e.a(this.a);
    }
}
