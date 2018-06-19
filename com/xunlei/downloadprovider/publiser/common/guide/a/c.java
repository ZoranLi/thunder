package com.xunlei.downloadprovider.publiser.common.guide.a;

import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.publiser.common.guide.a.a.a;
import java.util.LinkedList;

/* compiled from: BusinessGroup */
final class c implements a {
    final /* synthetic */ i a;
    final /* synthetic */ LinkedList b;
    final /* synthetic */ a c;
    final /* synthetic */ b d;

    c(b bVar, i iVar, LinkedList linkedList, a aVar) {
        this.d = bVar;
        this.a = iVar;
        this.b = linkedList;
        this.c = aVar;
    }

    public final void a() {
        if (!this.a.c) {
            this.b.pop();
            if (this.b.isEmpty()) {
                this.a.d.cancel();
                if (this.c != null) {
                    this.c.a();
                }
            }
        }
    }
}
