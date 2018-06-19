package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.a;
import com.airbnb.lottie.c.f;
import com.airbnb.lottie.model.c;
import com.airbnb.lottie.model.content.h;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation */
public final class l extends a<h, Path> {
    private final h d = new h();
    private final Path e = new Path();

    public l(List<a<h>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f) {
        boolean z;
        int size;
        PointF pointF;
        PointF pointF2;
        float f2;
        float f3;
        h hVar = (h) aVar.a;
        h hVar2 = (h) aVar.b;
        h hVar3 = this.d;
        if (hVar3.b == null) {
            hVar3.b = new PointF();
        }
        if (!hVar.c) {
            if (!hVar2.c) {
                z = false;
                hVar3.c = z;
                if (!hVar3.a.isEmpty() || hVar3.a.size() == hVar.a.size() || hVar3.a.size() == hVar2.a.size()) {
                    if (hVar3.a.isEmpty()) {
                        for (size = hVar.a.size() - 1; size >= 0; size--) {
                            hVar3.a.add(new c());
                        }
                    }
                    pointF = hVar.b;
                    pointF2 = hVar2.b;
                    f2 = pointF.x;
                    f2 += (pointF2.x - f2) * f;
                    f3 = pointF.y;
                    f3 += (pointF2.y - f3) * f;
                    if (hVar3.b == null) {
                        hVar3.b = new PointF();
                    }
                    hVar3.b.set(f2, f3);
                    for (size = hVar3.a.size() - 1; size >= 0; size--) {
                        c cVar = (c) hVar.a.get(size);
                        c cVar2 = (c) hVar2.a.get(size);
                        PointF pointF3 = cVar.a;
                        PointF pointF4 = cVar.b;
                        PointF pointF5 = cVar.c;
                        PointF pointF6 = cVar2.a;
                        PointF pointF7 = cVar2.b;
                        pointF2 = cVar2.c;
                        c cVar3 = (c) hVar3.a.get(size);
                        float f4 = pointF3.x;
                        f4 += (pointF6.x - f4) * f;
                        f2 = pointF3.y;
                        cVar3.a.set(f4, f2 + ((pointF6.y - f2) * f));
                        c cVar4 = (c) hVar3.a.get(size);
                        float f5 = pointF4.x;
                        f5 += (pointF7.x - f5) * f;
                        float f6 = pointF4.y;
                        cVar4.b.set(f5, f6 + ((pointF7.y - f6) * f));
                        cVar4 = (c) hVar3.a.get(size);
                        f6 = pointF5.x;
                        f6 += (pointF2.x - f6) * f;
                        float f7 = pointF5.y;
                        cVar4.c.set(f6, f7 + ((pointF2.y - f7) * f));
                    }
                    f.a(this.d, this.e);
                    return this.e;
                }
                StringBuilder stringBuilder = new StringBuilder("Curves must have the same number of control points. This: ");
                stringBuilder.append(hVar3.a.size());
                stringBuilder.append("\tShape 1: ");
                stringBuilder.append(hVar.a.size());
                stringBuilder.append("\tShape 2: ");
                stringBuilder.append(hVar2.a.size());
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        z = true;
        hVar3.c = z;
        if (hVar3.a.isEmpty()) {
        }
        if (hVar3.a.isEmpty()) {
            for (size = hVar.a.size() - 1; size >= 0; size--) {
                hVar3.a.add(new c());
            }
        }
        pointF = hVar.b;
        pointF2 = hVar2.b;
        f2 = pointF.x;
        f2 += (pointF2.x - f2) * f;
        f3 = pointF.y;
        f3 += (pointF2.y - f3) * f;
        if (hVar3.b == null) {
            hVar3.b = new PointF();
        }
        hVar3.b.set(f2, f3);
        for (size = hVar3.a.size() - 1; size >= 0; size--) {
            c cVar5 = (c) hVar.a.get(size);
            c cVar22 = (c) hVar2.a.get(size);
            PointF pointF32 = cVar5.a;
            PointF pointF42 = cVar5.b;
            PointF pointF52 = cVar5.c;
            PointF pointF62 = cVar22.a;
            PointF pointF72 = cVar22.b;
            pointF2 = cVar22.c;
            c cVar32 = (c) hVar3.a.get(size);
            float f42 = pointF32.x;
            f42 += (pointF62.x - f42) * f;
            f2 = pointF32.y;
            cVar32.a.set(f42, f2 + ((pointF62.y - f2) * f));
            c cVar42 = (c) hVar3.a.get(size);
            float f52 = pointF42.x;
            f52 += (pointF72.x - f52) * f;
            float f62 = pointF42.y;
            cVar42.b.set(f52, f62 + ((pointF72.y - f62) * f));
            cVar42 = (c) hVar3.a.get(size);
            f62 = pointF52.x;
            f62 += (pointF2.x - f62) * f;
            float f72 = pointF52.y;
            cVar42.c.set(f62, f72 + ((pointF2.y - f72) * f));
        }
        f.a(this.d, this.e);
        return this.e;
    }
}
