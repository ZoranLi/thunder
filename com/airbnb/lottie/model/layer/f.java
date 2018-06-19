package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.airbnb.lottie.b.b;
import com.airbnb.lottie.j;

/* compiled from: ImageLayer */
public final class f extends a {
    private final Paint g = new Paint(3);
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private final float j;

    f(j jVar, Layer layer, float f) {
        super(jVar, layer);
        this.j = f;
    }

    public final void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap c = c();
        if (c != null) {
            this.g.setAlpha(i);
            canvas.save();
            canvas.concat(matrix);
            this.h.set(0, 0, c.getWidth(), c.getHeight());
            this.i.set(0, 0, (int) (((float) c.getWidth()) * this.j), (int) (((float) c.getHeight()) * this.j));
            canvas.drawBitmap(c, this.h, this.i, this.g);
            canvas.restore();
        }
    }

    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        matrix = c();
        if (matrix != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, (float) matrix.getWidth()), Math.min(rectF.bottom, (float) matrix.getHeight()));
            this.a.mapRect(rectF);
        }
    }

    @Nullable
    private Bitmap c() {
        b bVar;
        String str = this.c.g;
        j jVar = this.b;
        if (jVar.getCallback() == null) {
            bVar = null;
        } else {
            if (jVar.f != null) {
                b bVar2 = jVar.f;
                Callback callback = jVar.getCallback();
                Object context = (callback == null || !(callback instanceof View)) ? null : ((View) callback).getContext();
                Object obj = (!(context == null && bVar2.a == null) && (context == null || !bVar2.a.equals(context))) ? null : 1;
                if (obj == null) {
                    jVar.f.a();
                    jVar.f = null;
                }
            }
            if (jVar.f == null) {
                jVar.f = new b(jVar.getCallback(), jVar.g, jVar.h, jVar.a.b);
            }
            bVar = jVar.f;
        }
        if (bVar != null) {
            return bVar.a(str);
        }
        return null;
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }
}
