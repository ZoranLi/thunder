package com.xunlei.downloadprovider.xlui.recyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

/* compiled from: HeaderAndFooterAdapterWrapper */
final class c implements a {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final int a(GridLayoutManager gridLayoutManager, SpanSizeLookup spanSizeLookup, int i) {
        int itemViewType = this.a.getItemViewType(i);
        if (this.a.a.get(itemViewType) != null) {
            return gridLayoutManager.getSpanCount();
        }
        if (this.a.b.get(itemViewType) != null) {
            return gridLayoutManager.getSpanCount();
        }
        return spanSizeLookup != null ? spanSizeLookup.getSpanSize(i) : 1;
    }
}
