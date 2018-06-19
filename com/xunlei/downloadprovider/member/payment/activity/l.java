package com.xunlei.downloadprovider.member.payment.activity;

import java.util.Comparator;

/* compiled from: IActivityConfigImpl */
final class l implements Comparator<a> {
    final /* synthetic */ g a;

    l(g gVar) {
        this.a = gVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        a aVar = (a) obj2;
        obj = ((a) obj).b;
        obj2 = aVar.b;
        if (obj > obj2) {
            return 1;
        }
        return obj < obj2 ? -1 : null;
    }
}
