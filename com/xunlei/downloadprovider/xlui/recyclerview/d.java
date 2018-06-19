package com.xunlei.downloadprovider.xlui.recyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

/* compiled from: HeaderAndFooterAdapterWrapper */
final class d extends SpanSizeLookup {
    final /* synthetic */ a a;
    final /* synthetic */ GridLayoutManager b;
    final /* synthetic */ SpanSizeLookup c;

    d(a aVar, GridLayoutManager gridLayoutManager, SpanSizeLookup spanSizeLookup) {
        this.a = aVar;
        this.b = gridLayoutManager;
        this.c = spanSizeLookup;
    }

    public final int getSpanSize(int i) {
        return this.a.a(this.b, this.c, i);
    }
}
