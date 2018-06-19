package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.j;

/* compiled from: NullLayer */
public final class g extends a {
    final void b(Canvas canvas, Matrix matrix, int i) {
    }

    g(j jVar, Layer layer) {
        super(jVar, layer);
    }

    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
