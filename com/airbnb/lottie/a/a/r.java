package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.ShapeStroke;

/* compiled from: StrokeContent */
public final class r extends a {
    private final String b;
    private final a<Integer, Integer> c;

    public final void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        this.a.setColor(((Integer) this.c.a()).intValue());
        super.a(canvas, matrix, i);
    }

    public final String b() {
        return this.b;
    }

    public r(j jVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(jVar, aVar, shapeStroke.g.toPaintCap(), shapeStroke.h.toPaintJoin(), shapeStroke.e, shapeStroke.f, shapeStroke.c, shapeStroke.b);
        this.b = shapeStroke.a;
        this.c = shapeStroke.d.a();
        this.c.a((a.a) this);
        aVar.a(this.c);
    }
}
