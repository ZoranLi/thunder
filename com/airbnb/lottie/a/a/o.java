package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.content.f;
import java.util.List;

/* compiled from: RectangleContent */
public final class o implements l, a {
    private final Path a = new Path();
    private final RectF b = new RectF();
    private final String c;
    private final j d;
    private final com.airbnb.lottie.a.b.a<?, PointF> e;
    private final com.airbnb.lottie.a.b.a<?, PointF> f;
    private final com.airbnb.lottie.a.b.a<?, Float> g;
    @Nullable
    private s h;
    private boolean i;

    public o(j jVar, com.airbnb.lottie.model.layer.a aVar, f fVar) {
        this.c = fVar.a;
        this.d = jVar;
        this.e = fVar.b.a();
        this.f = fVar.c.a();
        this.g = fVar.d.a();
        aVar.a(this.e);
        aVar.a(this.f);
        aVar.a(this.g);
        this.e.a((a) this);
        this.f.a((a) this);
        this.g.a((a) this);
    }

    public final String b() {
        return this.c;
    }

    public final void a(List<b> list, List<b> list2) {
        for (list2 = null; list2 < list.size(); list2++) {
            b bVar = (b) list.get(list2);
            if (bVar instanceof s) {
                s sVar = (s) bVar;
                if (sVar.a == Type.Simultaneously) {
                    this.h = sVar;
                    this.h.a(this);
                }
            }
        }
    }

    public final Path e() {
        if (this.i) {
            return this.a;
        }
        this.a.reset();
        PointF pointF = (PointF) this.f.a();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float floatValue = this.g == null ? 0.0f : ((Float) this.g.a()).floatValue();
        float min = Math.min(f, f2);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF pointF2 = (PointF) this.e.a();
        this.a.moveTo(pointF2.x + f, (pointF2.y - f2) + floatValue);
        this.a.lineTo(pointF2.x + f, (pointF2.y + f2) - floatValue);
        if (floatValue > 0.0f) {
            float f3 = 2.0f * floatValue;
            this.b.set((pointF2.x + f) - f3, (pointF2.y + f2) - f3, pointF2.x + f, pointF2.y + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointF2.x - f) + floatValue, pointF2.y + f2);
        if (floatValue > 0.0f) {
            float f4 = 2.0f * floatValue;
            this.b.set(pointF2.x - f, (pointF2.y + f2) - f4, (pointF2.x - f) + f4, pointF2.y + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointF2.x - f, (pointF2.y - f2) + floatValue);
        if (floatValue > 0.0f) {
            float f5 = 2.0f * floatValue;
            this.b.set(pointF2.x - f, pointF2.y - f2, (pointF2.x - f) + f5, (pointF2.y - f2) + f5);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointF2.x + f) - floatValue, pointF2.y - f2);
        if (floatValue > 0.0f) {
            float f6 = 2.0f * floatValue;
            this.b.set((pointF2.x + f) - f6, pointF2.y - f2, pointF2.x + f, (pointF2.y - f2) + f6);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        g.a(this.a, this.h);
        this.i = true;
        return this.a;
    }

    public final void a() {
        this.i = false;
        this.d.invalidateSelf();
    }
}
