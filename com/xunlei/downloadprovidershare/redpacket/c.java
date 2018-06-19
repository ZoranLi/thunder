package com.xunlei.downloadprovidershare.redpacket;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.downloadprovidershare.redpacket.b.a;

/* compiled from: RedPacketCashRequestManager */
final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ b e;

    c(b bVar, String str, a aVar, String str2, String str3) {
        this.e = bVar;
        this.a = str;
        this.b = aVar;
        this.c = str2;
        this.d = str3;
    }

    public final void run() {
        Request fVar = new f(this, this.a, new d(this), new e(this));
        fVar.setShouldCache(false).setRetryPolicy(new d(2000, 1, 1.0f));
        this.e.b.a(fVar);
    }
}
