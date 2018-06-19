package com.xunlei.downloadprovider.download.tasklist.list.banner.f;

import android.os.Handler;
import com.xunlei.downloadprovider.download.util.i;

/* compiled from: VoucherPacketHelper */
public final class p extends i {
    final /* synthetic */ f a;

    public p(f fVar, Handler handler) {
        this.a = fVar;
        super(handler);
    }

    public final void a() {
        if (this.a.o != null) {
            this.a.h = this.a.h - 1;
            this.a.k();
            this.a.o.a();
            if (this.a.h <= 0) {
                this.a.l();
            }
        }
    }
}
