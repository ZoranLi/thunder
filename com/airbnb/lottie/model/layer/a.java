package com.airbnb.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.d;
import com.airbnb.lottie.a.b.c;
import com.airbnb.lottie.a.b.g;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseLayer */
public abstract class a implements d, com.airbnb.lottie.a.b.a.a {
    final Matrix a;
    final j b;
    final Layer c;
    @Nullable
    a d;
    @Nullable
    a e;
    final p f;
    private final Path g = new Path();
    private final Matrix h = new Matrix();
    private final Paint i;
    private final Paint j;
    private final Paint k;
    private final Paint l;
    private final RectF m;
    private final RectF n;
    private final RectF o;
    private final RectF p;
    private final String q;
    @Nullable
    private g r;
    private List<a> s;
    private final List<com.airbnb.lottie.a.b.a<?, ?>> t;
    private boolean u;

    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    public final void a(List<b> list, List<b> list2) {
    }

    abstract void b(Canvas canvas, Matrix matrix, int i);

    a(j jVar, Layer layer) {
        boolean z = true;
        this.i = new Paint(1);
        this.j = new Paint(1);
        this.k = new Paint(1);
        this.l = new Paint();
        this.m = new RectF();
        this.n = new RectF();
        this.o = new RectF();
        this.p = new RectF();
        this.a = new Matrix();
        this.t = new ArrayList();
        this.u = true;
        this.b = jVar;
        this.c = layer;
        jVar = new StringBuilder();
        jVar.append(layer.c);
        jVar.append("#draw");
        this.q = jVar.toString();
        this.l.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.j.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        if (layer.u == MatteType.Invert) {
            this.k.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        } else {
            this.k.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        }
        this.f = layer.i.a();
        this.f.a((com.airbnb.lottie.a.b.a.a) this);
        this.f.a(this);
        if (layer.h != null && layer.h.isEmpty() == null) {
            this.r = new g(layer.h);
            for (com.airbnb.lottie.a.b.a aVar : this.r.a) {
                a(aVar);
                aVar.a((com.airbnb.lottie.a.b.a.a) this);
            }
            for (com.airbnb.lottie.a.b.a aVar2 : this.r.b) {
                a(aVar2);
                aVar2.a((com.airbnb.lottie.a.b.a.a) this);
            }
        }
        if (this.c.t.isEmpty() == null) {
            com.airbnb.lottie.a.b.a cVar = new c(this.c.t);
            cVar.b = true;
            cVar.a((com.airbnb.lottie.a.b.a.a) new b(this, cVar));
            if (((Float) cVar.a()).floatValue() != 1.0f) {
                z = false;
            }
            a(z);
            a(cVar);
            return;
        }
        a(true);
    }

    private boolean c() {
        return this.d != null;
    }

    public final void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.t.add(aVar);
        }
    }

    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.a.set(matrix);
        this.a.preConcat(this.f.a());
    }

    @SuppressLint({"WrongConstant"})
    public final void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.a(this.q);
        if (this.u) {
            if (this.s == null) {
                if (this.e == null) {
                    this.s = Collections.emptyList();
                } else {
                    this.s = new ArrayList();
                    for (a aVar = this.e; aVar != null; aVar = aVar.e) {
                        this.s.add(aVar);
                    }
                }
            }
            com.airbnb.lottie.d.a("Layer#parentMatrix");
            this.h.reset();
            this.h.set(matrix);
            for (int size = this.s.size() - 1; size >= 0; size--) {
                this.h.preConcat(((a) this.s.get(size)).f.a());
            }
            com.airbnb.lottie.d.b("Layer#parentMatrix");
            i = (int) ((((((float) i) / 1132396544) * ((float) ((Integer) this.f.a.a()).intValue())) / 1120403456) * 1132396544);
            if (c() || d()) {
                com.airbnb.lottie.d.a("Layer#computeBounds");
                this.m.set(0.0f, 0.0f, 0.0f, 0.0f);
                a(this.m, this.h);
                RectF rectF = this.m;
                Matrix matrix2 = this.h;
                if (c() && this.c.u != MatteType.Invert) {
                    this.d.a(this.o, matrix2);
                    rectF.set(Math.max(rectF.left, this.o.left), Math.max(rectF.top, this.o.top), Math.min(rectF.right, this.o.right), Math.min(rectF.bottom, this.o.bottom));
                }
                this.h.preConcat(this.f.a());
                b(this.m, this.h);
                this.m.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
                com.airbnb.lottie.d.b("Layer#computeBounds");
                com.airbnb.lottie.d.a("Layer#saveLayer");
                canvas.saveLayer(this.m, this.i, 31);
                com.airbnb.lottie.d.b("Layer#saveLayer");
                a(canvas);
                com.airbnb.lottie.d.a("Layer#drawLayer");
                b(canvas, this.h, i);
                com.airbnb.lottie.d.b("Layer#drawLayer");
                if (d()) {
                    a(canvas, this.h);
                }
                if (c()) {
                    com.airbnb.lottie.d.a("Layer#drawMatte");
                    com.airbnb.lottie.d.a("Layer#saveLayer");
                    canvas.saveLayer(this.m, this.k, 19);
                    com.airbnb.lottie.d.b("Layer#saveLayer");
                    a(canvas);
                    this.d.a(canvas, matrix, i);
                    com.airbnb.lottie.d.a("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.d.b("Layer#restoreLayer");
                    com.airbnb.lottie.d.b("Layer#drawMatte");
                }
                com.airbnb.lottie.d.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.d.b("Layer#restoreLayer");
                b(com.airbnb.lottie.d.b(this.q));
                return;
            }
            this.h.preConcat(this.f.a());
            com.airbnb.lottie.d.a("Layer#drawLayer");
            b(canvas, this.h, i);
            com.airbnb.lottie.d.b("Layer#drawLayer");
            b(com.airbnb.lottie.d.b(this.q));
            return;
        }
        com.airbnb.lottie.d.b(this.q);
    }

    private void b(float f) {
        s sVar = this.b.a.g;
        String str = this.c.c;
        if (sVar.a) {
            e eVar = (e) sVar.c.get(str);
            if (eVar == null) {
                eVar = new e();
                sVar.c.put(str, eVar);
            }
            eVar.a += f;
            eVar.b++;
            if (eVar.b == Integer.MAX_VALUE) {
                eVar.a /= 2.0f;
                eVar.b /= 2;
            }
            if (str.equals("root") != null) {
                f = sVar.b.iterator();
                while (f.hasNext()) {
                    f.next();
                }
            }
        }
    }

    private void a(Canvas canvas) {
        com.airbnb.lottie.d.a("Layer#clearLayer");
        canvas.drawRect(this.m.left - 1.0f, this.m.top - 1.0f, this.m.right + 1.0f, this.m.bottom + 1.0f, this.l);
        com.airbnb.lottie.d.b("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.n.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (d()) {
            int size = this.r.c.size();
            int i = 0;
            while (i < size) {
                Mask mask = (Mask) this.r.c.get(i);
                this.g.set((Path) ((com.airbnb.lottie.a.b.a) this.r.a.get(i)).a());
                this.g.transform(matrix);
                switch (c.b[mask.a.ordinal()]) {
                    case 1:
                        return;
                    case 2:
                        return;
                    case 3:
                        return;
                    default:
                        this.g.computeBounds(this.p, false);
                        if (i == 0) {
                            this.n.set(this.p);
                        } else {
                            this.n.set(Math.min(this.n.left, this.p.left), Math.min(this.n.top, this.p.top), Math.max(this.n.right, this.p.right), Math.max(this.n.bottom, this.p.bottom));
                        }
                        i++;
                }
            }
            rectF.set(Math.max(rectF.left, this.n.left), Math.max(rectF.top, this.n.top), Math.min(rectF.right, this.n.right), Math.min(rectF.bottom, this.n.bottom));
        }
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.d.a("Layer#drawMask");
        com.airbnb.lottie.d.a("Layer#saveLayer");
        canvas.saveLayer(this.m, this.j, 19);
        com.airbnb.lottie.d.b("Layer#saveLayer");
        a(canvas);
        int size = this.r.c.size();
        for (int i = 0; i < size; i++) {
            Mask mask = (Mask) this.r.c.get(i);
            this.g.set((Path) ((com.airbnb.lottie.a.b.a) this.r.a.get(i)).a());
            this.g.transform(matrix);
            if (c.b[mask.a.ordinal()] != 1) {
                this.g.setFillType(FillType.WINDING);
            } else {
                this.g.setFillType(FillType.INVERSE_WINDING);
            }
            com.airbnb.lottie.a.b.a aVar = (com.airbnb.lottie.a.b.a) this.r.b.get(i);
            int alpha = this.i.getAlpha();
            this.i.setAlpha((int) (((float) ((Integer) aVar.a()).intValue()) * 2.55f));
            canvas.drawPath(this.g, this.i);
            this.i.setAlpha(alpha);
        }
        com.airbnb.lottie.d.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.b("Layer#restoreLayer");
        com.airbnb.lottie.d.b("Layer#drawMask");
    }

    private boolean d() {
        return (this.r == null || this.r.a.isEmpty()) ? false : true;
    }

    final void a(boolean z) {
        if (z != this.u) {
            this.u = z;
            this.b.invalidateSelf();
        }
    }

    void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.c.m != 0.0f) {
            f /= this.c.m;
        }
        if (this.d != null) {
            this.d.a(this.d.c.m * f);
        }
        for (int i = 0; i < this.t.size(); i++) {
            ((com.airbnb.lottie.a.b.a) this.t.get(i)).a(f);
        }
    }

    public final String b() {
        return this.c.c;
    }

    public final void a() {
        this.b.invalidateSelf();
    }
}
