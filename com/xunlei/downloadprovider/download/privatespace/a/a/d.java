package com.xunlei.downloadprovider.download.privatespace.a.a;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.payment.network.b;

/* compiled from: BindVerifyBusiness */
public final class d implements b {
    final /* synthetic */ h a = null;
    final /* synthetic */ a b;

    public d(a aVar) {
        this.b = aVar;
    }

    public final void a(Object obj) {
        XLThreadPool.execute(new e(this));
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void a(int i, String str) {
        if (this.a != null) {
            this.a.a(i, str);
        }
    }
}
