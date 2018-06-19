package com.xunlei.downloadprovider.homepage.youliao;

import com.xunlei.downloadprovider.homepage.youliao.flow.a;
import com.xunlei.downloadprovider.search.b.b;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;

/* compiled from: YouliaoVideoFragment */
final class i implements b<ArrayList<a>> {
    final /* synthetic */ YouliaoVideoFragment a;

    i(YouliaoVideoFragment youliaoVideoFragment) {
        this.a = youliaoVideoFragment;
    }

    public final /* synthetic */ void a(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        if (d.a(arrayList) || this.a.d == null || this.a.e == null) {
            obj = this.a;
            this.a.j;
            obj.f.a(new h(obj), null);
            return;
        }
        this.a.d.post(new j(this, arrayList));
    }
}
