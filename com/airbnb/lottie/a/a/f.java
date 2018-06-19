package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.d;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent */
public final class f implements d, a {
    private final Path a = new Path();
    private final Paint b = new Paint(1);
    private final String c;
    private final List<l> d = new ArrayList();
    private final com.airbnb.lottie.a.b.a<Integer, Integer> e;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> f;
    private final j g;

    public f(j jVar, com.airbnb.lottie.model.layer.a aVar, i iVar) {
        this.c = iVar.b;
        this.g = jVar;
        if (iVar.c != null) {
            if (iVar.d != null) {
                this.a.setFillType(iVar.a);
                this.e = iVar.c.a();
                this.e.a((a) this);
                aVar.a(this.e);
                this.f = iVar.d.a();
                this.f.a((a) this);
                aVar.a(this.f);
                return;
            }
        }
        this.e = null;
        this.f = null;
    }

    public final void a() {
        this.g.invalidateSelf();
    }

    public final void a(List<b> list, List<b> list2) {
        for (list = null; list < list2.size(); list++) {
            b bVar = (b) list2.get(list);
            if (bVar instanceof l) {
                this.d.add((l) bVar);
            }
        }
    }

    public final String b() {
        return this.c;
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        d.a("FillContent#draw");
        this.b.setColor(((Integer) this.e.a()).intValue());
        this.b.setAlpha((int) ((((((float) i) / 1132396544) * ((float) ((Integer) this.f.a()).intValue())) / 1120403456) * 1132396544));
        this.a.reset();
        for (i = 0; i < this.d.size(); i++) {
            this.a.addPath(((l) this.d.get(i)).e(), matrix);
        }
        canvas.drawPath(this.a, this.b);
        d.b("FillContent#draw");
    }

    public final void a(RectF rectF, Matrix matrix) {
        this.a.reset();
        for (int i = 0; i < this.d.size(); i++) {
            this.a.addPath(((l) this.d.get(i)).e(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1065353216, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
