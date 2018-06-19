package com.xunlei.downloadprovider.ad.downloadlist.d;

import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.c;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.d.e;
import com.xunlei.downloadprovider.download.tasklist.list.a;

/* compiled from: TaskAdCardImageViewHolder */
public final class d extends a {
    public d(View view, a aVar) {
        super(view, aVar);
    }

    public final void b(l lVar) {
        this.b.a(lVar, c(), this.c);
        if (this.f != null) {
            this.f.setText(lVar.m());
        }
        if (this.g != null) {
            this.g.setText(lVar.j());
        }
        if (this.d != null) {
            c.b(e(), lVar.k(), this.d);
        }
        if (this.e != null) {
            c.b(e(), lVar.l(), this.e);
        }
        if (this.l != null) {
            this.l.setText(f.a(lVar, R.string.choiceness_ad_source_guanggao));
        }
        if (this.i != null) {
            this.i.setVisibility(8);
        }
        if (this.h != null) {
            this.h.setVisibility(0);
            if (lVar.q() != 0.0f) {
                this.h.setRating(lVar.q());
            } else {
                this.h.setRating(4.0f);
            }
        }
        this.c.setOnClickListener(new e(this, lVar));
        if (this.j != null) {
            if (e.a().e == null || e.a().e.c()) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            this.j.setOnClickListener(new f(this, lVar));
        }
        if (this.k != null) {
            if (lVar.x() != null) {
                if (!lVar.x().trim().equals("")) {
                    this.k.setText(lVar.x().trim());
                }
            }
            if (lVar.u() != 2) {
                this.k.setText("打开");
            } else if (this.mAdapter.a() != 1) {
                this.k.setText("安装");
            } else {
                this.k.setText("下载");
            }
        }
    }

    public final void a() {
        this.c.setVisibility(8);
        if (this.d != null) {
            this.d.setImageResource(R.drawable.download_ad_background);
        }
        if (this.e != null) {
            this.e.setImageResource(R.drawable.download_ad_background);
        }
    }
}
