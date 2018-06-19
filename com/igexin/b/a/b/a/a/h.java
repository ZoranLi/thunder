package com.igexin.b.a.b.a.a;

import java.util.Comparator;

class h implements Comparator<k> {
    final /* synthetic */ d a;

    h(d dVar) {
        this.a = dVar;
    }

    public int a(k kVar, k kVar2) {
        return kVar == null ? 1 : kVar2 == null ? -1 : ((long) kVar.y) + kVar.w > ((long) kVar2.y) + kVar2.w ? 1 : ((long) kVar.y) + kVar.w < ((long) kVar2.y) + kVar2.w ? -1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((k) obj, (k) obj2);
    }
}
