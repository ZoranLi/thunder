package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.a.a;
import java.util.List;

/* compiled from: PathKeyframeAnimation */
public final class i extends f<PointF> {
    private final PointF d = new PointF();
    private final float[] e = new float[2];
    private h f;
    private PathMeasure g;

    public i(List<? extends a<PointF>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f) {
        a aVar2 = (h) aVar;
        Path path = aVar2.f;
        if (path == null) {
            return (PointF) aVar.a;
        }
        if (this.f != aVar2) {
            this.g = new PathMeasure(path, false);
            this.f = aVar2;
        }
        this.g.getPosTan(f * this.g.getLength(), this.e, null);
        this.d.set(this.e[0], this.e[1]);
        return this.d;
    }
}
