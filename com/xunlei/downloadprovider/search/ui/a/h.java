package com.xunlei.downloadprovider.search.ui.a;

import android.util.SparseArray;
import android.view.View;

/* compiled from: ViewHolder */
public final class h {
    View a;
    private SparseArray<View> b = new SparseArray();
    private int c;
    private a d;

    /* compiled from: ViewHolder */
    public interface a {
    }

    public h(a aVar, View view, int i) {
        this.c = i;
        this.d = aVar;
        this.a = view;
        this.a.setTag(this);
    }
}
