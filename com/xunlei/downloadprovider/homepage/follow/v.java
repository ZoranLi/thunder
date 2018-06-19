package com.xunlei.downloadprovider.homepage.follow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: FollowManager */
final class v implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ u b;

    v(u uVar, List list) {
        this.b = uVar;
        this.a = list;
    }

    public final void run() {
        Set hashSet = new HashSet();
        for (String valueOf : this.a) {
            hashSet.add(Long.valueOf(valueOf));
        }
        this.b.c.e.a(hashSet);
    }
}
