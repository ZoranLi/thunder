package com.xunlei.downloadprovider.download.tasklist.list.banner.f;

import com.xunlei.downloadprovider.h.e;
import java.io.File;

/* compiled from: VoucherPacketHelper */
public final class k implements Runnable {
    final /* synthetic */ f a;

    public k(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        try {
            File file = new File(f.t(), f.b());
            if (!file.exists()) {
                e.b(file.getPath());
                file.createNewFile();
            }
        } catch (Exception e) {
            new StringBuilder("[saveRecord] local failed=").append(e.toString());
        }
    }
}
