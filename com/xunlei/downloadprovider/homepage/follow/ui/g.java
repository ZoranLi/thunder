package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ap;
import java.util.Collections;
import java.util.List;

/* compiled from: FollowFragment */
final class g implements aa {
    final /* synthetic */ FollowFragment a;

    g(FollowFragment followFragment) {
        this.a = followFragment;
    }

    public final void a(boolean z, List<String> list) {
        if (z) {
            for (String str : list) {
                ab j = this.a.i;
                long longValue = Long.valueOf(str).longValue();
                list = j.c.iterator();
                while (list.hasNext()) {
                    ap apVar = (ap) list.next();
                    if ((apVar.a == 1 || apVar.a == 2) && ((a) apVar.b).b == longValue) {
                        list.remove();
                        break;
                    }
                }
            }
            if (this.a.i.c.size() <= true) {
                this.a.a(this.a.g);
            }
            if (!this.a.e.f) {
                this.a.i.a = 3;
            }
            if (this.a.b) {
                this.a.b.a();
            }
            return;
        }
        for (String valueOf : list) {
            a c = this.a.e.c(Long.valueOf(valueOf).longValue());
            ab j2 = this.a.i;
            j2.a = 1;
            if ("rad".equals(c.c)) {
                j2.c.add(0, new ap(2, c));
            } else {
                j2.c.add(0, new ap(1, c));
            }
        }
        if (Collections.unmodifiableList(this.a.e.h).size() == list.size()) {
            this.a.b.a(list.size());
            this.a.b.notifyItemRemoved(1 + list.size());
        } else {
            this.a.b.a(list.size());
        }
        this.a.b.notifyItemChanged(0);
    }
}
