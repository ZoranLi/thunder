package com.xunlei.downloadprovider.homepage.cinecism.ui;

import android.text.TextUtils.EllipsizeCallback;

/* compiled from: CinecismCardView */
final class d implements EllipsizeCallback {
    final /* synthetic */ int[] a;
    final /* synthetic */ a b;

    d(a aVar, int[] iArr) {
        this.b = aVar;
        this.a = iArr;
    }

    public final void ellipsized(int i, int i2) {
        this.a[0] = i;
    }
}
