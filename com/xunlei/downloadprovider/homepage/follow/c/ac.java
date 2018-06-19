package com.xunlei.downloadprovider.homepage.follow.c;

/* compiled from: FollowNetworkHelper */
final class ac implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ aa b;

    ac(aa aaVar, String str) {
        this.b = aaVar;
        this.a = str;
    }

    public final void run() {
        this.b.a.a.onFail(this.a);
    }
}
