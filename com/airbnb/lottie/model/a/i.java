package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.m;

/* compiled from: AnimatableSplitDimensionPathValue */
public final class i implements m<PointF, PointF> {
    private final b a;
    private final b b;

    i(b bVar, b bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    public final a<PointF, PointF> a() {
        return new m(this.a.a(), this.b.a());
    }
}
