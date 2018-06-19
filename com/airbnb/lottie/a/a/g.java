package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.c;
import com.airbnb.lottie.model.content.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent */
public final class g implements d, a {
    private final String a;
    private final LongSparseArray<LinearGradient> b = new LongSparseArray();
    private final LongSparseArray<RadialGradient> c = new LongSparseArray();
    private final Matrix d = new Matrix();
    private final Path e = new Path();
    private final Paint f = new Paint(1);
    private final RectF g = new RectF();
    private final List<l> h = new ArrayList();
    private final GradientType i;
    private final com.airbnb.lottie.a.b.a<c, c> j;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> k;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> l;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> m;
    private final j n;
    private final int o;

    public final void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    public g(j jVar, com.airbnb.lottie.model.layer.a aVar, d dVar) {
        this.a = dVar.g;
        this.n = jVar;
        this.i = dVar.a;
        this.e.setFillType(dVar.b);
        this.o = (int) (jVar.a.a() / 32);
        this.j = dVar.c.a();
        this.j.a((a) this);
        aVar.a(this.j);
        this.k = dVar.d.a();
        this.k.a((a) this);
        aVar.a(this.k);
        this.l = dVar.e.a();
        this.l.a((a) this);
        aVar.a(this.l);
        this.m = dVar.f.a();
        this.m.a((a) this);
        aVar.a(this.m);
    }

    public final void a() {
        this.n.invalidateSelf();
    }

    public final void a(List<b> list, List<b> list2) {
        for (list = null; list < list2.size(); list++) {
            b bVar = (b) list2.get(list);
            if (bVar instanceof l) {
                this.h.add((l) bVar);
            }
        }
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        Matrix matrix2 = matrix;
        com.airbnb.lottie.d.a("GradientFillContent#draw");
        this.e.reset();
        for (int i2 = 0; i2 < r0.h.size(); i2++) {
            r0.e.addPath(((l) r0.h.get(i2)).e(), matrix2);
        }
        r0.e.computeBounds(r0.g, false);
        long c;
        PointF pointF;
        PointF pointF2;
        c cVar;
        Shader linearGradient;
        if (r0.i == GradientType.Linear) {
            c = (long) c();
            shader = (LinearGradient) r0.b.get(c);
            if (shader == null) {
                pointF = (PointF) r0.l.a();
                pointF2 = (PointF) r0.m.a();
                cVar = (c) r0.j.a();
                linearGradient = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, cVar.b, cVar.a, TileMode.CLAMP);
                r0.b.put(c, linearGradient);
                shader = linearGradient;
            }
        } else {
            c = (long) c();
            shader = (RadialGradient) r0.c.get(c);
            if (shader == null) {
                pointF = (PointF) r0.l.a();
                pointF2 = (PointF) r0.m.a();
                cVar = (c) r0.j.a();
                int[] iArr = cVar.b;
                float[] fArr = cVar.a;
                float f = pointF.x;
                float f2 = pointF.y;
                linearGradient = new RadialGradient(f, f2, (float) Math.hypot((double) (pointF2.x - f), (double) (pointF2.y - f2)), iArr, fArr, TileMode.CLAMP);
                r0.c.put(c, linearGradient);
            }
        }
        r0.d.set(matrix2);
        shader.setLocalMatrix(r0.d);
        r0.f.setShader(shader);
        r0.f.setAlpha((int) ((((((float) i) / 255.0f) * ((float) ((Integer) r0.k.a()).intValue())) / 100.0f) * 255.0f));
        canvas.drawPath(r0.e, r0.f);
        com.airbnb.lottie.d.b("GradientFillContent#draw");
    }

    public final void a(RectF rectF, Matrix matrix) {
        this.e.reset();
        for (int i = 0; i < this.h.size(); i++) {
            this.e.addPath(((l) this.h.get(i)).e(), matrix);
        }
        this.e.computeBounds(rectF, false);
        rectF.set(rectF.left - 1065353216, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final String b() {
        return this.a;
    }

    private int c() {
        int round = Math.round(this.l.c * ((float) this.o));
        int round2 = Math.round(this.m.c * ((float) this.o));
        int round3 = Math.round(this.j.c * ((float) this.o));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = (i * 31) * round2;
        }
        return round3 != 0 ? (i * 31) * round3 : i;
    }
}
