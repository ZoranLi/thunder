package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.airbnb.lottie.c.c;
import com.airbnb.lottie.model.a.e;
import com.airbnb.lottie.model.a.g;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer.LayerType;
import com.airbnb.lottie.model.layer.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: LottieDrawable */
public class j extends Drawable implements Callback {
    private static final String o = "j";
    public i a;
    public final c b = new c();
    float c = 1.0f;
    final Set<a> d = new HashSet();
    final ArrayList<b> e = new ArrayList();
    @Nullable
    public com.airbnb.lottie.b.b f;
    @Nullable
    public String g;
    @Nullable
    public c h;
    @Nullable
    public com.airbnb.lottie.b.a i;
    @Nullable
    public b j;
    @Nullable
    public v k;
    public boolean l;
    @Nullable
    d m;
    boolean n;
    private final Matrix p = new Matrix();
    private int q = 255;

    /* compiled from: LottieDrawable */
    private static class a {
        final String a = null;
        @Nullable
        final String b = null;
        @Nullable
        final ColorFilter c;

        a(@Nullable ColorFilter colorFilter) {
            this.c = colorFilter;
        }

        public final int hashCode() {
            int hashCode = this.a != null ? 527 * this.a.hashCode() : 17;
            return this.b != null ? (hashCode * 31) * this.b.hashCode() : hashCode;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return hashCode() == aVar.hashCode() && this.c == aVar.c;
        }
    }

    /* compiled from: LottieDrawable */
    private interface b {
        void a();
    }

    public int getOpacity() {
        return -3;
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public j() {
        this.b.addUpdateListener(new k(this));
    }

    public final void a() {
        if (this.f != null) {
            this.f.a();
        }
    }

    final void b() {
        i iVar = this.a;
        Rect rect = iVar.h;
        LayerType layerType = LayerType.PreComp;
        List emptyList = Collections.emptyList();
        e eVar = new e();
        e eVar2 = new e();
        g gVar = new g();
        e eVar3 = eVar;
        e eVar4 = eVar2;
        g gVar2 = gVar;
        Layer layer = r2;
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        com.airbnb.lottie.model.a.j jVar = null;
        k kVar = null;
        Layer layer2 = new Layer(Collections.emptyList(), iVar, "root", -1, layerType, -1, null, emptyList, new l(eVar3, eVar4, gVar2, com.airbnb.lottie.model.a.b.a.a(), new com.airbnb.lottie.model.a.d(), com.airbnb.lottie.model.a.b.a.a(), com.airbnb.lottie.model.a.b.a.a()), 0, i, i2, f, f2, rect.width(), rect.height(), jVar, kVar, Collections.emptyList(), MatteType.None, null);
        this.m = new d(this, layer, this.a.f, this.a);
    }

    public void invalidateSelf() {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.q = i;
    }

    public int getAlpha() {
        return this.q;
    }

    public void draw(@NonNull Canvas canvas) {
        d.a("Drawable#draw");
        if (this.m != null) {
            float f = this.c;
            float min = Math.min(((float) canvas.getWidth()) / ((float) this.a.h.width()), ((float) canvas.getHeight()) / ((float) this.a.h.height()));
            if (f > min) {
                f = this.c / min;
            } else {
                min = f;
                f = 1.0f;
            }
            if (f > 1.0f) {
                canvas.save();
                float width = ((float) this.a.h.width()) / 2.0f;
                float height = ((float) this.a.h.height()) / 2.0f;
                float f2 = width * min;
                float f3 = height * min;
                canvas.translate((this.c * width) - f2, (this.c * height) - f3);
                canvas.scale(f, f, f2, f3);
            }
            this.p.reset();
            this.p.preScale(min, min);
            this.m.a(canvas, this.p, this.q);
            d.b("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public final void c() {
        if (this.m == null) {
            this.e.add(new l(this));
            return;
        }
        c cVar = this.b;
        cVar.start();
        cVar.a(cVar.a() ? cVar.f : cVar.e);
    }

    public final void a(int i) {
        if (this.a == null) {
            this.e.add(new m(this, i));
        } else {
            a(((float) i) / this.a.b());
        }
    }

    public final void a(float f) {
        c cVar = this.b;
        if (f >= cVar.f) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        cVar.e = f;
        cVar.b();
    }

    public final void b(int i) {
        if (this.a == null) {
            this.e.add(new n(this, i));
        } else {
            b(((float) i) / this.a.b());
        }
    }

    public final void b(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        c cVar = this.b;
        if (f <= cVar.e) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        cVar.f = f;
        cVar.b();
    }

    public final void c(int i) {
        if (this.a == null) {
            this.e.add(new o(this, i));
        } else {
            c(((float) i) / this.a.b());
        }
    }

    public final void c(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.b.a(f);
        if (this.m != null) {
            this.m.a(f);
        }
    }

    public final void a(boolean z) {
        this.b.setRepeatCount(z ? true : false);
    }

    public final void d(float f) {
        this.c = f;
        e();
    }

    public final boolean d() {
        return this.k == null && this.a.d.size() > 0;
    }

    final void e() {
        if (this.a != null) {
            float f = this.c;
            setBounds(0, 0, (int) (((float) this.a.h.width()) * f), (int) (((float) this.a.h.height()) * f));
        }
    }

    public final void f() {
        this.e.clear();
        this.b.cancel();
    }

    public int getIntrinsicWidth() {
        if (this.a == null) {
            return -1;
        }
        return (int) (((float) this.a.h.width()) * this.c);
    }

    public int getIntrinsicHeight() {
        if (this.a == null) {
            return -1;
        }
        return (int) (((float) this.a.h.height()) * this.c);
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        drawable = getCallback();
        if (drawable != null) {
            drawable.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        drawable = getCallback();
        if (drawable != null) {
            drawable.scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        drawable = getCallback();
        if (drawable != null) {
            drawable.unscheduleDrawable(this, runnable);
        }
    }
}
