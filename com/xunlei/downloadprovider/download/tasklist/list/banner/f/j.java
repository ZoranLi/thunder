package com.xunlei.downloadprovider.download.tasklist.list.banner.f;

import com.xunlei.downloadprovider.h.e;
import java.io.File;

/* compiled from: VoucherPacketHelper */
final class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ f b;

    j(f fVar, String str) {
        this.b = fVar;
        this.a = str;
    }

    public final void run() {
        try {
            e.b(new File(f.t(), f.u()).getPath(), this.a);
        } catch (Exception e) {
            new StringBuilder("[saveRecord] local failed=").append(e.toString());
        }
    }
}
