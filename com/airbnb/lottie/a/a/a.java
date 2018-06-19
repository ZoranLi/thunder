package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent */
public abstract class a implements d, com.airbnb.lottie.a.b.a.a {
    final Paint a = new Paint(1);
    private final PathMeasure b = new PathMeasure();
    private final Path c = new Path();
    private final Path d = new Path();
    private final RectF e = new RectF();
    private final j f;
    private final List<a> g = new ArrayList();
    private final float[] h;
    private final com.airbnb.lottie.a.b.a<?, Float> i;
    private final com.airbnb.lottie.a.b.a<?, Integer> j;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> k;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> l;

    /* compiled from: BaseStrokeContent */
    private static final class a {
        final List<l> a;
        @Nullable
        final s b;

        private a(@Nullable s sVar) {
            this.a = new ArrayList();
            this.b = sVar;
        }
    }

    a(j jVar, com.airbnb.lottie.model.layer.a aVar, Cap cap, Join join, d dVar, b bVar, List<b> list, b bVar2) {
        Enum enumR;
        this.f = jVar;
        this.a.setStyle(Style.STROKE);
        this.a.setStrokeCap(cap);
        this.a.setStrokeJoin(join);
        this.j = dVar.a();
        this.i = bVar.a();
        if (bVar2 == null) {
            this.l = null;
        } else {
            this.l = bVar2.a();
        }
        this.k = new ArrayList(list.size());
        this.h = new float[list.size()];
        jVar = null;
        for (enumR = null; enumR < list.size(); enumR++) {
            this.k.add(((b) list.get(enumR)).a());
        }
        aVar.a(this.j);
        aVar.a(this.i);
        for (enumR = null; enumR < this.k.size(); enumR++) {
            aVar.a((com.airbnb.lottie.a.b.a) this.k.get(enumR));
        }
        if (this.l != null) {
            aVar.a(this.l);
        }
        this.j.a((com.airbnb.lottie.a.b.a.a) this);
        this.i.a((com.airbnb.lottie.a.b.a.a) this);
        while (jVar < list.size()) {
            ((com.airbnb.lottie.a.b.a) this.k.get(jVar)).a((com.airbnb.lottie.a.b.a.a) this);
            jVar++;
        }
        if (this.l != null) {
            this.l.a((com.airbnb.lottie.a.b.a.a) this);
        }
    }

    public final void a() {
        this.f.invalidateSelf();
    }

    public final void a(List<b> list, List<b> list2) {
        Object obj = null;
        s sVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            s sVar2;
            b bVar = (b) list.get(size);
            if (bVar instanceof s) {
                sVar2 = (s) bVar;
                if (sVar2.a == Type.Individually) {
                    sVar = sVar2;
                }
            }
        }
        if (sVar != null) {
            sVar.a(this);
        }
        for (list = list2.size() - 1; list >= null; list--) {
            b bVar2 = (b) list2.get(list);
            if (bVar2 instanceof s) {
                sVar2 = (s) bVar2;
                if (sVar2.a == Type.Individually) {
                    if (obj != null) {
                        this.g.add(obj);
                    }
                    a aVar = new a(sVar2);
                    sVar2.a(this);
                    obj = aVar;
                }
            }
            if (bVar2 instanceof l) {
                if (obj == null) {
                    obj = new a(sVar);
                }
                obj.a.add((l) bVar2);
            }
        }
        if (obj != null) {
            this.g.add(obj);
        }
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.a("StrokeContent#draw");
        this.a.setAlpha((int) ((((((float) i) / 1132396544) * ((float) ((Integer) this.j.a()).intValue())) / 1120403456) * 1132396544));
        this.a.setStrokeWidth(((Float) this.i.a()).floatValue() * g.a(matrix));
        float f = 0.0f;
        if (this.a.getStrokeWidth() <= 0) {
            com.airbnb.lottie.d.b("StrokeContent#draw");
            return;
        }
        com.airbnb.lottie.d.a("StrokeContent#applyDashPattern");
        int i2 = 0;
        if (this.k.isEmpty() != 0) {
            com.airbnb.lottie.d.b("StrokeContent#applyDashPattern");
        } else {
            i = g.a(matrix);
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                this.h[i3] = ((Float) ((com.airbnb.lottie.a.b.a) this.k.get(i3)).a()).floatValue();
                if (i3 % 2 == 0) {
                    if (this.h[i3] < 1.0f) {
                        this.h[i3] = 1.0f;
                    }
                } else if (this.h[i3] < 0.1f) {
                    this.h[i3] = 0.1f;
                }
                float[] fArr = this.h;
                fArr[i3] = fArr[i3] * i;
            }
            if (this.l != 0) {
                f = ((Float) this.l.a()).floatValue();
            }
            this.a.setPathEffect(new DashPathEffect(this.h, f));
            com.airbnb.lottie.d.b("StrokeContent#applyDashPattern");
        }
        while (i2 < this.g.size()) {
            a aVar = (a) this.g.get(i2);
            if (aVar.b != null) {
                a(canvas, aVar, matrix);
            } else {
                com.airbnb.lottie.d.a("StrokeContent#buildPath");
                this.c.reset();
                for (int size = aVar.a.size() - 1; size >= 0; size--) {
                    this.c.addPath(((l) aVar.a.get(size)).e(), matrix);
                }
                com.airbnb.lottie.d.b("StrokeContent#buildPath");
                com.airbnb.lottie.d.a("StrokeContent#drawPath");
                canvas.drawPath(this.c, this.a);
                com.airbnb.lottie.d.b("StrokeContent#drawPath");
            }
            i2++;
        }
        com.airbnb.lottie.d.b("StrokeContent#draw");
    }

    private void a(Canvas canvas, a aVar, Matrix matrix) {
        com.airbnb.lottie.d.a("StrokeContent#applyTrimPath");
        if (aVar.b == null) {
            com.airbnb.lottie.d.b("StrokeContent#applyTrimPath");
            return;
        }
        this.c.reset();
        for (int size = aVar.a.size() - 1; size >= 0; size--) {
            this.c.addPath(((l) aVar.a.get(size)).e(), matrix);
        }
        this.b.setPath(this.c, false);
        float length = this.b.getLength();
        while (this.b.nextContour()) {
            length += this.b.getLength();
        }
        float floatValue = (((Float) aVar.b.d.a()).floatValue() * length) / 360.0f;
        float floatValue2 = ((((Float) aVar.b.b.a()).floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((((Float) aVar.b.c.a()).floatValue() * length) / 100.0f) + floatValue;
        float f = 0.0f;
        for (int size2 = aVar.a.size() - 1; size2 >= 0; size2--) {
            float f2;
            this.d.set(((l) aVar.a.get(size2)).e());
            this.d.transform(matrix);
            this.b.setPath(this.d, false);
            float length2 = this.b.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                f2 = floatValue3 - length;
                if (f2 < f + length2 && f < f2) {
                    float f4 = floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f;
                    f3 = Math.min(f2 / length2, 1.0f);
                    g.a(this.d, f4, f3, 0.0f);
                    canvas.drawPath(this.d, this.a);
                    f += length2;
                }
            }
            f2 = f + length2;
            if (f2 >= floatValue2 && f <= floatValue3) {
                if (f2 > floatValue3 || floatValue2 >= f) {
                    f4 = floatValue2 < f ? 0.0f : (floatValue2 - f) / length2;
                    if (floatValue3 <= f2) {
                        f3 = (floatValue3 - f) / length2;
                    }
                    g.a(this.d, f4, f3, 0.0f);
                    canvas.drawPath(this.d, this.a);
                } else {
                    canvas.drawPath(this.d, this.a);
                }
            }
            f += length2;
        }
        com.airbnb.lottie.d.b("StrokeContent#applyTrimPath");
    }

    public final void a(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.d.a("StrokeContent#getBounds");
        this.c.reset();
        for (int i = 0; i < this.g.size(); i++) {
            a aVar = (a) this.g.get(i);
            for (int i2 = 0; i2 < aVar.a.size(); i2++) {
                this.c.addPath(((l) aVar.a.get(i2)).e(), matrix);
            }
        }
        this.c.computeBounds(this.e, false);
        matrix = ((Float) this.i.a()).floatValue() / 2.0f;
        this.e.set(this.e.left - matrix, this.e.top - matrix, this.e.right + matrix, this.e.bottom + matrix);
        rectF.set(this.e);
        rectF.set(rectF.left - 1065353216, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.b("StrokeContent#getBounds");
    }
}
