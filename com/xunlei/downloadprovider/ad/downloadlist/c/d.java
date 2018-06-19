package com.xunlei.downloadprovider.ad.downloadlist.c;

import android.view.View;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: CommendShowReporter */
public final class d extends b {
    private int b;
    private View c;
    private String d;

    public d(l lVar, int i, String str, View view) {
        super(lVar);
        this.b = i;
        this.d = str;
        this.c = view;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        return !this.d.equals("1");
    }

    public final void c() {
        if (this.a != null) {
            this.a.a(this.c);
        }
    }
}
