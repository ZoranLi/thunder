package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.a;
import java.util.List;

/* compiled from: PointKeyframeAnimation */
public final class j extends f<PointF> {
    private final PointF d = new PointF();

    public j(List<a<PointF>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f) {
        if (aVar.a != null) {
            if (aVar.b != null) {
                PointF pointF = (PointF) aVar.a;
                PointF pointF2 = (PointF) aVar.b;
                this.d.set(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + (f * (pointF2.y - pointF.y)));
                return this.d;
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
