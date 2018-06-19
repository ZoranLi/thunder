package com.xunlei.downloadprovider.personal.a.b;

import com.xunlei.downloadprovider.database.b.a;
import com.xunlei.downloadprovider.personal.a.b.b.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UserGridDataManager */
final class f implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ a b;

    f(a aVar, ArrayList arrayList) {
        this.b = aVar;
        this.a = arrayList;
    }

    public final void run() {
        List<h> list = this.a;
        if (list != null) {
            try {
                a.a().b().getUserGridDataInfoDao().deleteAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (h hVar : list) {
                b bVar = new b();
                bVar.b = Integer.valueOf(hVar.b);
                bVar.c = hVar.c;
                bVar.d = hVar.d;
                bVar.e = hVar.e;
                bVar.f = hVar.f;
                bVar.g = hVar.g;
                bVar.h = hVar.h;
                bVar.i = hVar.i;
                bVar.j = Integer.valueOf(hVar.j);
                bVar.k = Integer.valueOf(hVar.k);
                bVar.l = hVar.l;
                bVar.m = hVar.m;
                com.xunlei.downloadprovider.personal.a.b.b.a.a(bVar);
            }
        }
    }
}
