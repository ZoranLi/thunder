package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.i;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.model.f;
import com.airbnb.lottie.model.g;
import com.airbnb.lottie.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer */
public final class j extends a {
    private final char[] g = new char[1];
    private final RectF h = new RectF();
    private final Matrix i = new Matrix();
    private final Paint j = new k(this);
    private final Paint k = new l(this);
    private final Map<g, List<c>> l = new HashMap();
    private final o m;
    private final com.airbnb.lottie.j n;
    private final i o;
    @Nullable
    private a<Integer, Integer> p;
    @Nullable
    private a<Integer, Integer> q;
    @Nullable
    private a<Float, Float> r;
    @Nullable
    private a<Float, Float> s;

    j(com.airbnb.lottie.j jVar, Layer layer) {
        super(jVar, layer);
        this.n = jVar;
        this.o = layer.b;
        this.m = layer.q.c();
        this.m.a((a.a) this);
        a((a) this.m);
        jVar = layer.r;
        if (!(jVar == null || jVar.a == null)) {
            this.p = jVar.a.a();
            this.p.a((a.a) this);
            a((a) this.p);
        }
        if (!(jVar == null || jVar.b == null)) {
            this.q = jVar.b.a();
            this.q.a((a.a) this);
            a((a) this.q);
        }
        if (!(jVar == null || jVar.c == null)) {
            this.r = jVar.c.a();
            this.r.a((a.a) this);
            a((a) this.r);
        }
        if (jVar != null && jVar.d != null) {
            this.s = jVar.d.a();
            this.s.a((a.a) this);
            a((a) this.s);
        }
    }

    final void b(Canvas canvas, Matrix matrix, int i) {
        Canvas canvas2 = canvas;
        Matrix matrix2 = matrix;
        canvas.save();
        if (!this.n.d()) {
            canvas.setMatrix(matrix);
        }
        d dVar = (d) r0.m.a();
        f fVar = (f) r0.o.c.get(dVar.b);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (r0.p != null) {
            r0.j.setColor(((Integer) r0.p.a()).intValue());
        } else {
            r0.j.setColor(dVar.g);
        }
        if (r0.q != null) {
            r0.k.setColor(((Integer) r0.q.a()).intValue());
        } else {
            r0.k.setColor(dVar.h);
        }
        int intValue = (((Integer) r0.f.a.a()).intValue() * 255) / 100;
        r0.j.setAlpha(intValue);
        r0.k.setAlpha(intValue);
        if (r0.r != null) {
            r0.k.setStrokeWidth(((Float) r0.r.a()).floatValue());
        } else {
            r0.k.setStrokeWidth((((float) dVar.i) * r0.o.k) * com.airbnb.lottie.c.g.a(matrix));
        }
        if (r0.n.d()) {
            float f = ((float) dVar.c) / 100.0f;
            float a = com.airbnb.lottie.c.g.a(matrix);
            String str = dVar.a;
            int i2 = 0;
            while (i2 < str.length()) {
                String str2;
                g gVar = (g) r0.o.d.get(g.a(str.charAt(i2), fVar.a, fVar.c));
                if (gVar != null) {
                    List list;
                    if (r0.l.containsKey(gVar)) {
                        list = (List) r0.l.get(gVar);
                        str2 = str;
                    } else {
                        list = gVar.a;
                        int size = list.size();
                        List arrayList = new ArrayList(size);
                        int i3 = 0;
                        while (i3 < size) {
                            str2 = str;
                            arrayList.add(new c(r0.n, r0, (com.airbnb.lottie.model.content.j) list.get(i3)));
                            i3++;
                            str = str2;
                        }
                        str2 = str;
                        r0.l.put(gVar, arrayList);
                        list = arrayList;
                    }
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        Path e = ((c) list.get(i4)).e();
                        e.computeBounds(r0.h, false);
                        r0.i.set(matrix2);
                        r0.i.preScale(f, f);
                        e.transform(r0.i);
                        if (dVar.j) {
                            a(e, r0.j, canvas2);
                            a(e, r0.k, canvas2);
                        } else {
                            a(e, r0.k, canvas2);
                            a(e, r0.j, canvas2);
                        }
                    }
                    float f2 = ((((float) gVar.b) * f) * r0.o.k) * a;
                    float f3 = ((float) dVar.e) / 10.0f;
                    if (r0.s != null) {
                        f3 += ((Float) r0.s.a()).floatValue();
                    }
                    canvas2.translate(f2 + (f3 * a), 0.0f);
                } else {
                    str2 = str;
                }
                i2++;
                str = str2;
            }
        } else {
            a(dVar, fVar, matrix2, canvas2);
        }
        canvas.restore();
    }

    private void a(d dVar, f fVar, Matrix matrix, Canvas canvas) {
        com.airbnb.lottie.b.a aVar;
        matrix = com.airbnb.lottie.c.g.a(matrix);
        com.airbnb.lottie.j jVar = this.n;
        String str = fVar.a;
        fVar = fVar.c;
        Typeface typeface = null;
        if (jVar.getCallback() == null) {
            aVar = null;
        } else {
            if (jVar.i == null) {
                jVar.i = new com.airbnb.lottie.b.a(jVar.getCallback(), jVar.j);
            }
            aVar = jVar.i;
        }
        if (aVar != null) {
            com.airbnb.lottie.model.i iVar = aVar.a;
            iVar.a = str;
            iVar.b = fVar;
            typeface = (Typeface) aVar.b.get(aVar.a);
            if (typeface == null) {
                typeface = (Typeface) aVar.c.get(str);
                if (typeface == null) {
                    StringBuilder stringBuilder = new StringBuilder("fonts/");
                    stringBuilder.append(str);
                    stringBuilder.append(aVar.f);
                    typeface = Typeface.createFromAsset(aVar.d, stringBuilder.toString());
                    aVar.c.put(str, typeface);
                }
                boolean contains = fVar.contains("Italic");
                fVar = fVar.contains("Bold");
                fVar = (!contains || fVar == null) ? contains ? 2 : fVar != null ? 1 : null : 3;
                if (typeface.getStyle() != fVar) {
                    typeface = Typeface.create(typeface, fVar);
                }
                aVar.b.put(aVar.a, typeface);
            }
        }
        if (typeface != null) {
            fVar = dVar.a;
            v vVar = this.n.k;
            if (vVar != null) {
                if (vVar.b && vVar.a.containsKey(fVar)) {
                    fVar = (String) vVar.a.get(fVar);
                } else if (vVar.b) {
                    vVar.a.put(fVar, fVar);
                }
            }
            this.j.setTypeface(typeface);
            this.j.setTextSize(((float) dVar.c) * this.o.k);
            this.k.setTypeface(this.j.getTypeface());
            this.k.setTextSize(this.j.getTextSize());
            for (int i = 0; i < fVar.length(); i++) {
                char charAt = fVar.charAt(i);
                this.g[0] = charAt;
                if (dVar.j) {
                    a(this.g, this.j, canvas);
                    a(this.g, this.k, canvas);
                } else {
                    a(this.g, this.k, canvas);
                    a(this.g, this.j, canvas);
                }
                this.g[0] = charAt;
                float measureText = this.j.measureText(this.g, 0, 1);
                float f = ((float) dVar.e) / 10.0f;
                if (this.s != null) {
                    f += ((Float) this.s.a()).floatValue();
                }
                canvas.translate(measureText + (f * matrix), 0.0f);
            }
        }
    }

    private static void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private static void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }
}
