package com.igexin.push.core.a;

import com.igexin.push.core.bean.n;
import java.util.Comparator;

class h implements Comparator<n> {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public int a(n nVar, n nVar2) {
        return !nVar.d().equals(nVar2.d()) ? nVar.d().compareTo(nVar2.d()) : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((n) obj, (n) obj2);
    }
}
