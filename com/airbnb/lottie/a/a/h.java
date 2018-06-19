package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.c;
import com.airbnb.lottie.model.content.e;

/* compiled from: GradientStrokeContent */
public final class h extends a {
    private final String b;
    private final LongSparseArray<LinearGradient> c = new LongSparseArray();
    private final LongSparseArray<RadialGradient> d = new LongSparseArray();
    private final RectF e = new RectF();
    private final GradientType f;
    private final int g;
    private final a<c, c> h;
    private final a<PointF, PointF> i;
    private final a<PointF, PointF> j;

    public final void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        a(this.e, matrix);
        Paint paint;
        long c;
        Shader shader;
        PointF pointF;
        PointF pointF2;
        c cVar;
        Shader linearGradient;
        if (this.f == GradientType.Linear) {
            paint = r0.a;
            c = (long) c();
            shader = (LinearGradient) r0.c.get(c);
            if (shader == null) {
                pointF = (PointF) r0.i.a();
                pointF2 = (PointF) r0.j.a();
                cVar = (c) r0.h.a();
                linearGradient = new LinearGradient((float) ((int) ((r0.e.left + (r0.e.width() / 2.0f)) + pointF.x)), (float) ((int) ((r0.e.top + (r0.e.height() / 2.0f)) + pointF.y)), (float) ((int) ((r0.e.left + (r0.e.width() / 2.0f)) + pointF2.x)), (float) ((int) ((r0.e.top + (r0.e.height() / 2.0f)) + pointF2.y)), cVar.b, cVar.a, TileMode.CLAMP);
                r0.c.put(c, linearGradient);
                shader = linearGradient;
            }
            paint.setShader(shader);
        } else {
            paint = r0.a;
            c = (long) c();
            shader = (RadialGradient) r0.d.get(c);
            if (shader == null) {
                pointF = (PointF) r0.i.a();
                pointF2 = (PointF) r0.j.a();
                cVar = (c) r0.h.a();
                int[] iArr = cVar.b;
                float[] fArr = cVar.a;
                int width = (int) ((r0.e.left + (r0.e.width() / 2.0f)) + pointF.x);
                int height = (int) ((r0.e.top + (r0.e.height() / 2.0f)) + pointF.y);
                float f = (float) width;
                float f2 = (float) height;
                linearGradient = new RadialGradient(f, f2, (float) Math.hypot((double) (((int) ((r0.e.left + (r0.e.width() / 2.0f)) + pointF2.x)) - width), (double) (((int) ((r0.e.top + (r0.e.height() / 2.0f)) + pointF2.y)) - height)), iArr, fArr, TileMode.CLAMP);
                r0.d.put(c, linearGradient);
                shader = linearGradient;
            }
            paint.setShader(shader);
        }
        super.a(canvas, matrix, i);
    }

    public final String b() {
        return this.b;
    }

    private int c() {
        int round = Math.round(this.i.c * ((float) this.g));
        int round2 = Math.round(this.j.c * ((float) this.g));
        int round3 = Math.round(this.h.c * ((float) this.g));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = (i * 31) * round2;
        }
        return round3 != 0 ? (i * 31) * round3 : i;
    }

    public h(j jVar, com.airbnb.lottie.model.layer.a aVar, e eVar) {
        super(jVar, aVar, eVar.h.toPaintCap(), eVar.i.toPaintJoin(), eVar.d, eVar.g, eVar.j, eVar.k);
        this.b = eVar.a;
        this.f = eVar.b;
        this.g = (int) (jVar.a.a() / 32);
        this.h = eVar.c.a();
        this.h.a((a.a) this);
        aVar.a(this.h);
        this.i = eVar.e.a();
        this.i.a((a.a) this);
        aVar.a(this.i);
        this.j = eVar.f.a();
        this.j.a((a.a) this);
        aVar.a(this.j);
    }
}
