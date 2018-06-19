package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.j;
import java.util.Collections;

/* compiled from: ShapeLayer */
public final class h extends a {
    private final c g;

    h(j jVar, Layer layer) {
        super(jVar, layer);
        this.g = new c(jVar, this, new com.airbnb.lottie.model.content.j(layer.c, layer.a));
        this.g.a(Collections.emptyList(), Collections.emptyList());
    }

    final void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.g.a(canvas, matrix, i);
    }

    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.g.a(rectF, this.a);
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.g.a(str, str2, colorFilter);
    }
}
