package com.xunlei.downloadprovider.homepage.youliao.data;

import com.xunlei.downloadprovider.homepage.youliao.data.i.a;
import com.xunlei.downloadprovider.search.b.b;

/* compiled from: YouliaoVideoManager */
final class j implements b<c> {
    final /* synthetic */ a a;
    final /* synthetic */ Object b = null;
    final /* synthetic */ boolean c;
    final /* synthetic */ i d;

    j(i iVar, a aVar, boolean z) {
        this.d = iVar;
        this.a = aVar;
        this.c = z;
    }

    public final /* synthetic */ void a(Object obj) {
        obj = i.a(((c) obj).b);
        if (!obj.isEmpty()) {
            i.b = System.currentTimeMillis();
        }
        if (this.a != null) {
            this.a.a(obj, this.c);
        }
    }
}
