package com.xunlei.downloadprovider.homepage.follow.c;

import java.util.Set;

/* compiled from: FollowNetworkHelper */
final class ab implements Runnable {
    final /* synthetic */ Set a;
    final /* synthetic */ aa b;

    ab(aa aaVar, Set set) {
        this.b = aaVar;
        this.a = set;
    }

    public final void run() {
        this.b.a.a.onSuccess(this.a);
    }
}
