package com.airbnb.lottie;

import com.airbnb.lottie.LottieAnimationView.CacheStrategy;
import java.lang.ref.WeakReference;

/* compiled from: LottieAnimationView */
final class g implements q {
    final /* synthetic */ CacheStrategy a;
    final /* synthetic */ String b;
    final /* synthetic */ LottieAnimationView c;

    g(LottieAnimationView lottieAnimationView, CacheStrategy cacheStrategy, String str) {
        this.c = lottieAnimationView;
        this.a = cacheStrategy;
        this.b = str;
    }

    public final void a(i iVar) {
        if (this.a == CacheStrategy.Strong) {
            LottieAnimationView.e.put(this.b, iVar);
        } else if (this.a == CacheStrategy.Weak) {
            LottieAnimationView.f.put(this.b, new WeakReference(iVar));
        }
        this.c.setComposition(iVar);
    }
}
