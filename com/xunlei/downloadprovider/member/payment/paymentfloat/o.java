package com.xunlei.downloadprovider.member.payment.paymentfloat;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.payment.external.l.b;
import com.xunlei.downloadprovider.member.payment.external.l.c;

/* compiled from: MemberPriceHelper */
final class o extends b {
    final /* synthetic */ m a;

    o(m mVar) {
        this.a = mVar;
    }

    public final void onGetPrice(int i, String str, Object obj, int i2, String str2) {
        if (obj != null && (obj instanceof c) != 0) {
            XLThreadPool.execute(new p(this, obj, str2));
        }
    }
}
