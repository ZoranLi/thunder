package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.a.a;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation */
public final class m extends a<PointF, PointF> {
    private final PointF d = new PointF();
    private final a<Float, Float> e;
    private final a<Float, Float> f;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.e = aVar;
        this.f = aVar2;
    }

    public final void a(float f) {
        this.e.a(f);
        this.f.a(f);
        this.d.set(((Float) this.e.a()).floatValue(), ((Float) this.f.a()).floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            ((a) this.a.get(i)).a();
        }
    }

    final /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.a.a aVar, float f) {
        return this.d;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return this.d;
    }
}
