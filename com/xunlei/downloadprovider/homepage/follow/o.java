package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: FollowManager */
public final class o implements c<Boolean> {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    public o(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        this.a.onSuccess((Boolean) obj);
    }

    public final void onFail(String str) {
        this.a.onFail(str);
    }
}
