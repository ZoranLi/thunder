package com.xunlei.downloadprovider.search.ui.search;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.d.b.p.a;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.search.b.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiSearchAdapter */
final class p implements OnClickListener {
    final /* synthetic */ n a;
    final /* synthetic */ o b;

    p(o oVar, n nVar) {
        this.b = oVar;
        this.a = nVar;
    }

    public final void onClick(View view) {
        view = this.b.d;
        int i = this.a.b;
        if (view.f != null) {
            g.a = false;
            view.a = true;
            view.d.setVisibility(0);
            view.e.setVisibility(8);
            view.c = new ArrayList();
            if (i != 0) {
                switch (i) {
                    case 4:
                        view.c.addAll(view.f.h);
                        view.g = "site";
                        break;
                    case 5:
                        view.c.addAll(view.f.i);
                        view.g = "pub";
                        break;
                    case 6:
                        view.c.addAll(view.f.j);
                        view.g = "video";
                        break;
                    default:
                        view.c.addAll(view.f.g);
                        break;
                }
            }
            view.c.addAll(view.f.g);
            view.g = "";
            List list = d.a().m.a;
            Object obj = null;
            for (int i2 = 0; i2 < list.size(); i2++) {
                a aVar = (a) list.get(i2);
                if (aVar != null && aVar.a == i) {
                    obj = aVar.c;
                }
            }
            if (!TextUtils.isEmpty(obj)) {
                view.c.add(0, new f(obj));
            }
            if (i == 0) {
                view.d.setOnScrollListener(null);
            } else {
                view.d.setOnScrollListener(new ag(view));
            }
            view.b = new o(view.e.getContext());
            view.b.a(view.c, view.f.c);
            view.d.setAdapter(view.b);
        }
        com.xunlei.downloadprovider.search.c.a.a(this.a.b);
        i.a().a(this.b.c, 1);
    }
}
