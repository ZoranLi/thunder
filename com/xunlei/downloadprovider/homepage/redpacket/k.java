package com.xunlei.downloadprovider.homepage.redpacket;

import android.content.Context;
import android.os.Looper;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: RedPacketHelper */
final class k implements c<com.xunlei.downloadprovider.homepage.redpacket.a.c> {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ j c;

    k(j jVar, Context context, String str) {
        this.c = jVar;
        this.a = context;
        this.b = str;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        com.xunlei.downloadprovider.homepage.redpacket.a.c cVar = (com.xunlei.downloadprovider.homepage.redpacket.a.c) obj;
        if (cVar.b == 101301) {
            j.a(this.c);
        }
        obj = cVar.a;
        if (obj > null) {
            new r(this.a, obj, this.b).show();
        }
        j.b(this.c);
    }

    public final void onFail(String str) {
        Looper.getMainLooper().getThread();
        Thread.currentThread();
        j.b();
    }
}
