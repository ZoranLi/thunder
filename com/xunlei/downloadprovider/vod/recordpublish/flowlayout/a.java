package com.xunlei.downloadprovider.vod.recordpublish.flowlayout;

import android.view.View;
import com.xunlei.downloadprovider.vod.recordpublish.flowlayout.FlowLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LineDefinition */
final class a {
    final List<View> a = new ArrayList();
    final LayoutConfiguration b;
    final int c;
    int d;
    int e;
    int f;
    int g;
    int h = 0;
    int i = 0;

    public a(int i, LayoutConfiguration layoutConfiguration) {
        this.c = i;
        this.b = layoutConfiguration;
    }

    public final void a(int i, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        this.a.add(i, view);
        this.d = this.f + layoutParams.g;
        this.f = this.d + layoutParams.d;
        this.g = Math.max(this.g, layoutParams.h + layoutParams.e);
        this.e = Math.max(this.e, layoutParams.h);
    }

    public final void a(int i) {
        this.h += i;
    }
}
