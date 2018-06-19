package com.alibaba.mtl.log.d;

import com.alibaba.mtl.log.b.a;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import com.xunlei.androidvip.XLAndroidVipManager;

/* compiled from: UploadEngine */
final class b extends c {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        if (this.a.d) {
            a.k();
            this.a.d();
            i.a("UploadTask", "mPeriod:", Long.valueOf(this.a.b));
            if (r.a().b(2)) {
                r.a().a(2);
            }
            if (!c.b) {
                r.a().a(2, this, this.a.b);
            }
        }
    }

    public final void b() {
        a aVar = this.a;
        if (aVar.c == 0) {
            aVar.c = XLAndroidVipManager.XL_JNI_ERROR;
        } else {
            aVar.c = 0;
        }
    }
}
