package com.igexin.push.c;

import java.util.Comparator;

class b implements Comparator<j> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public int a(j jVar, j jVar2) {
        return (int) (jVar.e() - jVar2.e());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((j) obj, (j) obj2);
    }
}
