package com.xunlei.common.new_ptl.pay.c;

import com.alipay.sdk.app.PayTask;
import com.xunlei.common.new_ptl.pay.a.g;

/* compiled from: XLAlipayTask */
final class a$2 implements Runnable {
    final /* synthetic */ a a;

    a$2(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        final g gVar = new g(new PayTask(a.a(this.a).mActivity).pay(a.b(this.a), a.a(this.a).mNeedLoading != 0));
        a.e().c().post(new Runnable(this) {
            private /* synthetic */ a$2 b;

            public final void run() {
                a.a(this.b.a, gVar);
            }
        });
    }
}
