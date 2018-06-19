package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation */
public abstract class a<K, A> {
    final List<a> a = new ArrayList();
    public boolean b = false;
    public float c = 0.0f;
    private final List<? extends com.airbnb.lottie.a.a<K>> d;
    @Nullable
    private com.airbnb.lottie.a.a<K> e;

    /* compiled from: BaseKeyframeAnimation */
    public interface a {
        void a();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.d = list;
    }

    public void a(a aVar) {
        this.a.add(aVar);
    }

    private com.airbnb.lottie.a.a<K> b() {
        if (this.d.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        } else if (this.e != null && this.e.a(this.c)) {
            return this.e;
        } else {
            com.airbnb.lottie.a.a<K> aVar = (com.airbnb.lottie.a.a) this.d.get(this.d.size() - 1);
            if (this.c < aVar.a()) {
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    aVar = (com.airbnb.lottie.a.a) this.d.get(size);
                    if (aVar.a(this.c)) {
                        break;
                    }
                }
            }
            this.e = aVar;
            return aVar;
        }
    }

    public A a() {
        com.airbnb.lottie.a.a b = b();
        float f = 0.0f;
        if (!this.b) {
            com.airbnb.lottie.a.a b2 = b();
            if ((b2.c == null ? 1 : null) == null) {
                f = b2.c.getInterpolation((this.c - b2.a()) / (b2.b() - b2.a()));
            }
        }
        return a(b, f);
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        int i = 0;
        if (f < (this.d.isEmpty() ? 0.0f : ((com.airbnb.lottie.a.a) this.d.get(0)).a())) {
            f = 0.0f;
        } else {
            if (f > (this.d.isEmpty() ? 1.0f : ((com.airbnb.lottie.a.a) this.d.get(this.d.size() - 1)).b())) {
                f = 1.0f;
            }
        }
        if (f != this.c) {
            this.c = f;
            while (i < this.a.size()) {
                ((a) this.a.get(i)).a();
                i++;
            }
        }
    }
}
