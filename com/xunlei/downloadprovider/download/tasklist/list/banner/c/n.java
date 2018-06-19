package com.xunlei.downloadprovider.download.tasklist.list.banner.c;

import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.member.payment.external.a;
import java.io.File;

/* compiled from: FreeTrialRedPacketHelper */
final class n implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ f b;

    n(f fVar, String str) {
        this.b = fVar;
        this.a = str;
    }

    public final void run() {
        try {
            File j = f.j();
            e.b(j.getPath(), a.a("FreeTrial6", this.a));
        } catch (Exception e) {
            new StringBuilder("[saveSateToLocal] local failed=").append(e.toString());
        }
    }
}
