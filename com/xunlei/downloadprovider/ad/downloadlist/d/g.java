package com.xunlei.downloadprovider.ad.downloadlist.d;

import android.content.Context;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.c;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.d.e;
import com.xunlei.downloadprovider.download.tasklist.list.a;

/* compiled from: TaskAdCardViewHolder */
public final class g extends a {
    public g(View view, a aVar) {
        super(view, aVar);
    }

    public final void b(l lVar) {
        this.b.a(lVar, c(), this.c);
        this.f.setText(lVar.m());
        Context e = e();
        String k = lVar.k();
        c.b(e, k).placeholder(R.drawable.download_ad_background).error(R.drawable.download_ad_background).fallback(R.drawable.download_ad_background).listener(null).into(this.d);
        if (this.l != null) {
            this.l.setText(f.a(lVar, R.string.choiceness_ad_source_guanggao));
        }
        if (lVar.n() != 0) {
            this.i.setVisibility(0);
            CharSequence a = com.xunlei.downloadprovider.ad.downloadlist.a.a(lVar.n());
            if (a == null || !a.trim().equals("0")) {
                this.i.setText(a);
                this.h.setVisibility(0);
                if (lVar.q() == 0.0f) {
                    this.h.setRating(lVar.q());
                } else {
                    this.h.setRating(4.0f);
                }
                this.c.setOnClickListener(new h(this, lVar));
                if (e.a().e != null || e.a().e.c()) {
                    this.j.setVisibility(0);
                } else {
                    this.j.setVisibility(8);
                }
                this.j.setOnClickListener(new i(this, lVar));
                if (lVar.x() != null) {
                    if (lVar.x().trim().equals("")) {
                        this.k.setText(lVar.x().trim());
                        return;
                    }
                }
                if (lVar.w() != null) {
                    this.k.setText("打开");
                } else if (this.mAdapter.a() == 1) {
                    this.k.setText("安装");
                } else {
                    this.k.setText("下载");
                }
            }
        }
        this.i.setVisibility(8);
        this.h.setVisibility(0);
        if (lVar.q() == 0.0f) {
            this.h.setRating(4.0f);
        } else {
            this.h.setRating(lVar.q());
        }
        this.c.setOnClickListener(new h(this, lVar));
        if (e.a().e != null) {
        }
        this.j.setVisibility(0);
        this.j.setOnClickListener(new i(this, lVar));
        if (lVar.x() != null) {
            if (lVar.x().trim().equals("")) {
                this.k.setText(lVar.x().trim());
                return;
            }
        }
        if (lVar.w() != null) {
            this.k.setText("打开");
        } else if (this.mAdapter.a() == 1) {
            this.k.setText("下载");
        } else {
            this.k.setText("安装");
        }
    }

    public final void a() {
        this.c.setVisibility(8);
        this.d.setImageResource(R.drawable.download_ad_background);
    }
}
