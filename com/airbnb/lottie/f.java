package com.airbnb.lottie;

import com.airbnb.lottie.LottieAnimationView.CacheStrategy;
import java.lang.ref.WeakReference;

/* compiled from: LottieAnimationView */
final class f implements q {
    final /* synthetic */ CacheStrategy a;
    final /* synthetic */ int b;
    final /* synthetic */ LottieAnimationView c;

    f(LottieAnimationView lottieAnimationView, CacheStrategy cacheStrategy, int i) {
        this.c = lottieAnimationView;
        this.a = cacheStrategy;
        this.b = i;
    }

    public final void a(i iVar) {
        if (this.a == CacheStrategy.Strong) {
            LottieAnimationView.c.put(this.b, iVar);
        } else if (this.a == CacheStrategy.Weak) {
            LottieAnimationView.d.put(this.b, new WeakReference(iVar));
        }
        this.c.setComposition(iVar);
    }
}
