package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import java.util.List;

/* compiled from: EllipseContent */
public final class e implements l, a {
    private final Path a = new Path();
    private final String b;
    private final j c;
    private final com.airbnb.lottie.a.b.a<?, PointF> d;
    private final com.airbnb.lottie.a.b.a<?, PointF> e;
    private final com.airbnb.lottie.model.content.a f;
    @Nullable
    private s g;
    private boolean h;

    public e(j jVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.b = aVar2.a;
        this.c = jVar;
        this.d = aVar2.c.a();
        this.e = aVar2.b.a();
        this.f = aVar2;
        aVar.a(this.d);
        aVar.a(this.e);
        this.d.a((a) this);
        this.e.a((a) this);
    }

    public final void a(List<b> list, List<b> list2) {
        for (list2 = null; list2 < list.size(); list2++) {
            b bVar = (b) list.get(list2);
            if (bVar instanceof s) {
                s sVar = (s) bVar;
                if (sVar.a == Type.Simultaneously) {
                    this.g = sVar;
                    this.g.a(this);
                }
            }
        }
    }

    public final String b() {
        return this.b;
    }

    public final Path e() {
        if (this.h) {
            return r0.a;
        }
        r0.a.reset();
        PointF pointF = (PointF) r0.d.a();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        r0.a.reset();
        float f5;
        if (r0.f.d) {
            float f6 = -f2;
            r0.a.moveTo(0.0f, f6);
            float f7 = 0.0f - f3;
            float f8 = -f;
            float f9 = 0.0f - f4;
            r0.a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            f4 += 0.0f;
            f5 = f6;
            r0.a.cubicTo(f8, f4, f7, f2, 0.0f, f2);
            f3 += 0.0f;
            r0.a.cubicTo(f3, f2, f, f4, f, 0.0f);
            r0.a.cubicTo(f, f9, f3, f5, 0.0f, f5);
        } else {
            float f10 = -f2;
            r0.a.moveTo(0.0f, f10);
            f5 = 0.0f + f3;
            float f11 = 0.0f - f4;
            r0.a.cubicTo(f5, f10, f, f11, f, 0.0f);
            f4 += 0.0f;
            r0.a.cubicTo(f, f4, f5, f2, 0.0f, f2);
            f3 = 0.0f - f3;
            float f12 = -f;
            r0.a.cubicTo(f3, f2, f12, f4, f12, 0.0f);
            f2 = f10;
            r0.a.cubicTo(f12, f11, f3, f2, 0.0f, f2);
        }
        pointF = (PointF) r0.e.a();
        r0.a.offset(pointF.x, pointF.y);
        r0.a.close();
        g.a(r0.a, r0.g);
        r0.h = true;
        return r0.a;
    }

    public final void a() {
        this.h = false;
        this.c.invalidateSelf();
    }
}
