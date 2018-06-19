package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.homepage.follow.r;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FollowTabFragment */
final class q implements aa {
    final /* synthetic */ FollowTabFragment a;

    q(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final void a(boolean z, List<String> list) {
        if (z) {
            z = this.a.k;
            list = b.a();
            Iterator it = z.g.iterator();
            while (it.hasNext()) {
                ap apVar = (ap) it.next();
                if (apVar.a == 5 && !list.b(((d) apVar.b).a())) {
                    it.remove();
                }
            }
            int i = 2;
            int i2 = 0;
            if (z.g.isEmpty()) {
                z.a = 3;
                list.c();
                i2 = 1;
            } else {
                list.l = ((d) ((ap) z.g.get(0)).b).a;
                list.m = ((d) ((ap) z.g.get(z.g.size() - 1)).b).a;
                int min = Math.min(z.g.size(), 8);
                List arrayList = new ArrayList();
                for (int i3 = 0; i3 < min; i3++) {
                    arrayList.add((d) ((ap) z.g.get(i3)).b);
                }
                if (arrayList.size() < true) {
                    arrayList.clear();
                }
                b.a(new r(list, arrayList));
            }
            if (i2 != 0) {
                z = this.a;
                if (b.a().g.isEmpty() == null) {
                    i = 3;
                }
                z.a(i);
            }
        }
        this.a.e.c();
    }
}
