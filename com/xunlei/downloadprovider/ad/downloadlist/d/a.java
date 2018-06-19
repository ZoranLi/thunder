package com.xunlei.downloadprovider.ad.downloadlist.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.a.h;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.downloadlist.a.b;
import com.xunlei.downloadprovider.ad.downloadlist.a.d;
import com.xunlei.downloadprovider.ad.downloadlist.c;
import com.xunlei.downloadprovider.ad.downloadlist.c.f;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment.LOAD_TAG;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;

/* compiled from: BaseTaskAdCardViewHolder */
public abstract class a extends com.xunlei.downloadprovider.download.tasklist.list.a.a {
    protected e a;
    protected c b = null;

    public abstract void b(l lVar);

    public static a a(Context context, ViewGroup viewGroup, com.xunlei.downloadprovider.download.tasklist.list.a aVar) {
        if (h.b() == 3) {
            return new d(LayoutInflater.from(context).inflate(R.layout.layout_task_card_template_right_image_ad_card, viewGroup, false), aVar);
        }
        if (h.b() == 1) {
            return new d(LayoutInflater.from(context).inflate(R.layout.layout_task_card_template_image_ad_card, viewGroup, false), aVar);
        }
        return new g(LayoutInflater.from(context).inflate(R.layout.layout_task_card_template_basic_ad_card, viewGroup, false), aVar);
    }

    public a(View view, com.xunlei.downloadprovider.download.tasklist.list.a aVar) {
        super(view);
        this.mAdapter = aVar;
        this.b = new c(aVar, this);
    }

    public void fillData(e eVar) {
        super.fillData(eVar);
        this.a = eVar;
        this.b.a = eVar;
        c.a();
        if (com.xunlei.downloadprovider.ad.downloadlist.b.a.a().b.contains(com.xunlei.downloadprovider.ad.downloadlist.a.a((com.xunlei.downloadprovider.ad.downloadlist.c.a) this)) == null) {
            if (com.xunlei.downloadprovider.ad.downloadlist.a.b(b()) != null) {
                eVar = com.xunlei.downloadprovider.ad.downloadlist.b.a.a().a(b());
                eVar = eVar != null ? (l) eVar.get(com.xunlei.downloadprovider.ad.downloadlist.a.a((com.xunlei.downloadprovider.ad.downloadlist.c.a) this)) : null;
                if (eVar != null) {
                    a(eVar);
                    return;
                } else if (com.xunlei.downloadprovider.ad.downloadlist.a.a[b()] != null) {
                    d();
                    return;
                } else {
                    a();
                    eVar = com.xunlei.downloadprovider.ad.downloadlist.b.a.a().a;
                    if (!eVar.contains(com.xunlei.downloadprovider.ad.downloadlist.a.a((com.xunlei.downloadprovider.ad.downloadlist.c.a) this))) {
                        eVar.add(com.xunlei.downloadprovider.ad.downloadlist.a.a((com.xunlei.downloadprovider.ad.downloadlist.c.a) this));
                        f.a().a(new com.xunlei.downloadprovider.ad.downloadlist.c.c(this));
                        eVar = new d(this);
                        b bVar = new b(this);
                        bVar.a(eVar);
                        bVar.a();
                    }
                    return;
                }
            }
        }
        d();
    }

    public final int b() {
        return this.mAdapter.a();
    }

    public final int c() {
        if (this.a == null || !(this.a.c instanceof Integer)) {
            return 1;
        }
        return ((Integer) this.a.c).intValue() + 1;
    }

    @TargetApi(17)
    public final void a(l lVar) {
        if (e() != null) {
            if ((VERSION.SDK_INT < 17 || !e().isDestroyed()) && !e().isFinishing() && lVar != null) {
                b(lVar);
                this.c.setVisibility(0);
            }
        }
    }

    public final void d() {
        this.mAdapter.g.f.remove(LOAD_TAG.LOAD_LIST_AD);
        this.c.post(new b(this));
    }
}
