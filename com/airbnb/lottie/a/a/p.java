package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent */
public final class p implements d, i, l, a {
    private final Matrix a = new Matrix();
    private final Path b = new Path();
    private final j c;
    private final com.airbnb.lottie.model.layer.a d;
    private final String e;
    private final com.airbnb.lottie.a.b.a<Float, Float> f;
    private final com.airbnb.lottie.a.b.a<Float, Float> g;
    private final com.airbnb.lottie.a.b.p h;
    private c i;

    public p(j jVar, com.airbnb.lottie.model.layer.a aVar, g gVar) {
        this.c = jVar;
        this.d = aVar;
        this.e = gVar.a;
        this.f = gVar.b.a();
        aVar.a(this.f);
        this.f.a((a) this);
        this.g = gVar.c.a();
        aVar.a(this.g);
        this.g.a((a) this);
        this.h = gVar.d.a();
        this.h.a(aVar);
        this.h.a((a) this);
    }

    public final void a(ListIterator<b> listIterator) {
        if (this.i == null) {
            while (listIterator.hasPrevious()) {
                if (listIterator.previous() == this) {
                    break;
                }
            }
            List arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.i = new c(this.c, this.d, "Repeater", arrayList, null);
        }
    }

    public final String b() {
        return this.e;
    }

    public final void a(List<b> list, List<b> list2) {
        this.i.a((List) list, (List) list2);
    }

    public final Path e() {
        Path e = this.i.e();
        this.b.reset();
        float floatValue = ((Float) this.f.a()).floatValue();
        float floatValue2 = ((Float) this.g.a()).floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.a.set(this.h.a(((float) i) + floatValue2));
            this.b.addPath(e, this.a);
        }
        return this.b;
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = ((Float) this.f.a()).floatValue();
        float floatValue2 = ((Float) this.g.a()).floatValue();
        float floatValue3 = ((Float) this.h.b.a()).floatValue() / 100.0f;
        float floatValue4 = ((Float) this.h.c.a()).floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f = (float) i2;
            this.a.preConcat(this.h.a(f + floatValue2));
            this.i.a(canvas, this.a, (int) (((float) i) * (((f / floatValue) * (floatValue4 - floatValue3)) + floatValue3)));
        }
    }

    public final void a(RectF rectF, Matrix matrix) {
        this.i.a(rectF, matrix);
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.i.a(str, str2, colorFilter);
    }

    public final void a() {
        this.c.invalidateSelf();
    }
}
