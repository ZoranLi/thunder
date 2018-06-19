package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.i;
import com.airbnb.lottie.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompositionLayer */
public final class d extends a {
    @Nullable
    private final a<Float, Float> g;
    private final List<a> h = new ArrayList();
    private final RectF i = new RectF();
    private final RectF j = new RectF();

    public d(j jVar, Layer layer, List<Layer> list, i iVar) {
        super(jVar, layer);
        layer = layer.s;
        if (layer != null) {
            this.g = layer.a();
            a((a) this.g);
            this.g.a((a.a) this);
        } else {
            this.g = null;
        }
        layer = new LongSparseArray(iVar.f.size());
        int size = list.size() - 1;
        a aVar = null;
        while (true) {
            int i = 0;
            if (size >= 0) {
                a hVar;
                Layer layer2 = (Layer) list.get(size);
                switch (c.a[layer2.e.ordinal()]) {
                    case 1:
                        hVar = new h(jVar, layer2);
                        break;
                    case 2:
                        hVar = new d(jVar, layer2, (List) iVar.a.get(layer2.g), iVar);
                        break;
                    case 3:
                        hVar = new i(jVar, layer2);
                        break;
                    case 4:
                        hVar = new f(jVar, layer2, iVar.k);
                        break;
                    case 5:
                        hVar = new g(jVar, layer2);
                        break;
                    case 6:
                        hVar = new j(jVar, layer2);
                        break;
                    default:
                        new StringBuilder("Unknown layer type ").append(layer2.e);
                        hVar = null;
                        break;
                }
                if (hVar != null) {
                    layer.put(hVar.c.d, hVar);
                    if (aVar == null) {
                        this.h.add(0, hVar);
                        switch (e.a[layer2.u.ordinal()]) {
                            case 1:
                            case 2:
                                aVar = hVar;
                                break;
                            default:
                                break;
                        }
                    }
                    aVar.d = hVar;
                    aVar = null;
                }
                size--;
            } else {
                while (i < layer.size()) {
                    a aVar2 = (a) layer.get(layer.keyAt(i));
                    a aVar3 = (a) layer.get(aVar2.c.f);
                    if (aVar3 != null) {
                        aVar2.e = aVar3;
                    }
                    i++;
                }
                return;
            }
        }
    }

    final void b(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.a("CompositionLayer#draw");
        canvas.save();
        this.j.set(0.0f, 0.0f, (float) this.c.o, (float) this.c.p);
        matrix.mapRect(this.j);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            if (!this.j.isEmpty() ? canvas.clipRect(this.j) : true) {
                ((a) this.h.get(size)).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.airbnb.lottie.d.b("CompositionLayer#draw");
    }

    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (matrix = this.h.size() - 1; matrix >= null; matrix--) {
            ((a) this.h.get(matrix)).a(this.i, this.a);
            if (rectF.isEmpty()) {
                rectF.set(this.i);
            } else {
                rectF.set(Math.min(rectF.left, this.i.left), Math.min(rectF.top, this.i.top), Math.max(rectF.right, this.i.right), Math.max(rectF.bottom, this.i.bottom));
            }
        }
    }

    public final void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.a(f);
        if (this.g != null) {
            f = ((float) ((long) (((Float) this.g.a()).floatValue() * 1000.0f))) / ((float) this.b.a.a());
        }
        if (this.c.m != 0.0f) {
            f /= this.c.m;
        }
        f -= this.c.n;
        for (int size = this.h.size() - 1; size >= 0; size--) {
            ((a) this.h.get(size)).a(f);
        }
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        for (int i = 0; i < this.h.size(); i++) {
            a aVar = (a) this.h.get(i);
            String str3 = aVar.c.c;
            if (str == null) {
                aVar.a(null, null, colorFilter);
            } else if (str3.equals(str)) {
                aVar.a(str, str2, colorFilter);
            }
        }
    }
}
