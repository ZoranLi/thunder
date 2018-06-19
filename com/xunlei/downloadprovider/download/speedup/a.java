package com.xunlei.downloadprovider.download.speedup;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

/* compiled from: AnimationDrawableWrapper */
public final class a {
    public Handler a;
    int b;
    int c;
    public AnimationDrawable d;
    long e;
    public Runnable f;
    a g;

    /* compiled from: AnimationDrawableWrapper */
    public interface a {
        void a();
    }

    public a(@NonNull AnimationDrawable animationDrawable, int i, long j) {
        this.c = 1;
        this.f = new b(this);
        this.d = animationDrawable;
        this.a = new Handler(Looper.getMainLooper());
        int i2 = 0;
        this.b = 0;
        if (i > 0) {
            this.c = i;
        }
        i = 0;
        while (i2 < animationDrawable.getNumberOfFrames()) {
            i += animationDrawable.getDuration(i2);
            i2++;
        }
        this.e = j + ((long) i);
    }

    public a(@NonNull AnimationDrawable animationDrawable) {
        this(animationDrawable, 2, 0);
    }

    public final void a() {
        if (!this.d.isRunning()) {
            this.b++;
            this.a.removeCallbacks(this.f);
            this.a.postDelayed(this.f, 1000);
        }
    }
}
