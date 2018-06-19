package com.xunlei.downloadprovider.ad.cache.b;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.LinkedList;
import java.util.List;

/* compiled from: BaiDuNetwork */
final class b implements a {
    final /* synthetic */ List a;
    final /* synthetic */ LinkedList b;
    final /* synthetic */ int c;
    final /* synthetic */ a d;
    final /* synthetic */ a e;

    b(a aVar, List list, LinkedList linkedList, int i, a aVar2) {
        this.e = aVar;
        this.a = list;
        this.b = linkedList;
        this.c = i;
        this.d = aVar2;
    }

    public final void a(List<l> list) {
        this.a.addAll(list);
        a.a(this.b, this.c, this.a, this.d);
    }

    public final void a(int i, String str) {
        a.a(this.b, this.c, this.a, this.d);
    }
}
