package com.xunlei.downloadprovider.download.privatespace.ui;

import android.text.TextUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.download.privatespace.a.a.a;
import com.xunlei.downloadprovider.download.privatespace.a.a.d;
import com.xunlei.downloadprovider.download.privatespace.a.a.h;
import com.xunlei.downloadprovider.member.payment.network.b;

/* compiled from: PrivateSpaceFindPwdActivity */
final class e implements h {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    e(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void a() {
        this.a.s = true;
        this.a.h();
        if (!a.a()) {
            a o = this.a.l;
            Object n = this.a.b();
            if (!a.a() && !TextUtils.isEmpty(n) && o.c != null) {
                String str = o.c.b;
                o.c = null;
                com.xunlei.downloadprovider.download.privatespace.a.b.a hVar = new com.xunlei.downloadprovider.download.privatespace.a.b.h(a.a, n, str);
                b dVar = new d(o);
                hVar.a(null, new com.xunlei.downloadprovider.download.privatespace.a.b.d(hVar, dVar), new com.xunlei.downloadprovider.download.privatespace.a.b.e(hVar, dVar));
            }
        }
    }

    public final void a(int i, String str) {
        this.a.i();
        this.a.d.setText("");
        XLToast.showToast(this.a, str);
    }
}
