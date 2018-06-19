package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.k;
import com.airbnb.lottie.model.layer.a;

/* compiled from: TransformKeyframeAnimation */
public final class p {
    public final a<Integer, Integer> a;
    @Nullable
    public final a<?, Float> b;
    @Nullable
    public final a<?, Float> c;
    private final Matrix d = new Matrix();
    private final a<PointF, PointF> e;
    private final a<?, PointF> f;
    private final a<k, k> g;
    private final a<Float, Float> h;

    public p(l lVar) {
        this.e = lVar.a.a();
        this.f = lVar.b.a();
        this.g = lVar.c.a();
        this.h = lVar.d.a();
        this.a = lVar.e.a();
        if (lVar.f != null) {
            this.b = lVar.f.a();
        } else {
            this.b = null;
        }
        if (lVar.g != null) {
            this.c = lVar.g.a();
        } else {
            this.c = null;
        }
    }

    public final void a(a aVar) {
        aVar.a(this.e);
        aVar.a(this.f);
        aVar.a(this.g);
        aVar.a(this.h);
        aVar.a(this.a);
        if (this.b != null) {
            aVar.a(this.b);
        }
        if (this.c != null) {
            aVar.a(this.c);
        }
    }

    public final void a(a.a aVar) {
        this.e.a(aVar);
        this.f.a(aVar);
        this.g.a(aVar);
        this.h.a(aVar);
        this.a.a(aVar);
        if (this.b != null) {
            this.b.a(aVar);
        }
        if (this.c != null) {
            this.c.a(aVar);
        }
    }

    public final Matrix a() {
        this.d.reset();
        PointF pointF = (PointF) this.f.a();
        if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
            this.d.preTranslate(pointF.x, pointF.y);
        }
        float floatValue = ((Float) this.h.a()).floatValue();
        if (floatValue != 0.0f) {
            this.d.preRotate(floatValue);
        }
        k kVar = (k) this.g.a();
        if (!(kVar.a == 1.0f && kVar.b == 1.0f)) {
            this.d.preScale(kVar.a, kVar.b);
        }
        pointF = (PointF) this.e.a();
        if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
            this.d.preTranslate(-pointF.x, -pointF.y);
        }
        return this.d;
    }

    public final Matrix a(float f) {
        PointF pointF = (PointF) this.f.a();
        PointF pointF2 = (PointF) this.e.a();
        k kVar = (k) this.g.a();
        float floatValue = ((Float) this.h.a()).floatValue();
        this.d.reset();
        this.d.preTranslate(pointF.x * f, pointF.y * f);
        double d = (double) f;
        this.d.preScale((float) Math.pow((double) kVar.a, d), (float) Math.pow((double) kVar.b, d));
        this.d.preRotate(floatValue * f, pointF2.x, pointF2.y);
        return this.d;
    }
}
