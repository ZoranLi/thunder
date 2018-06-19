package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.widget.ListView;
import java.util.List;

/* compiled from: MultiSearchDetailCtr */
public final class af implements a {
    public boolean a;
    o b;
    public List<a> c;
    public ListView d;
    public View e;
    public ab f;
    String g;
    int h = 2;

    public final void b() {
    }

    public final void c() {
        this.a = false;
        g.b = false;
        this.c = null;
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.b = null;
        this.h = 2;
    }

    public final void a() {
        if (this.a && this.d != null) {
            this.h++;
            this.b.a(this.c, this.f.c);
            this.b.notifyDataSetChanged();
        }
    }
}
