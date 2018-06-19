package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;

/* compiled from: LottieValueAnimator */
public final class c extends ValueAnimator {
    public boolean a = false;
    public long b;
    public float c = 1.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    public float d = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    public float e = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    public float f = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new d(this));
        b();
    }

    public final void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        f = f.a(f, this.e, this.f);
        this.d = f;
        float abs = (a() ? this.f - f : f - this.e) / Math.abs(this.f - this.e);
        if (getDuration() > 0) {
            setCurrentPlayTime((long) (((float) getDuration()) * abs));
        }
    }

    public final boolean a() {
        return this.c < 0.0f;
    }

    public final void b() {
        setDuration((long) ((((float) this.b) * (this.f - this.e)) / Math.abs(this.c)));
        float[] fArr = new float[2];
        fArr[0] = this.c < 0.0f ? this.f : this.e;
        fArr[1] = this.c < 0.0f ? this.e : this.f;
        setFloatValues(fArr);
        a(this.d);
    }
}
