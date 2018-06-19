package com.xunlei.downloadprovider.d;

import com.xunlei.downloadprovider.d.i.a;
import com.xunlei.xllib.b.d;
import java.util.Iterator;

/* compiled from: RedPointCloudConfigure */
final class j implements Runnable {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void run() {
        if (!d.a(this.a.d)) {
            Iterator it = this.a.d.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(this.a);
            }
        }
    }
}
