package com.airbnb.lottie.a.b;

import com.airbnb.lottie.a.a;
import java.util.List;

/* compiled from: ScaleKeyframeAnimation */
public final class k extends f<com.airbnb.lottie.model.k> {
    public k(List<a<com.airbnb.lottie.model.k>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f) {
        if (aVar.a != null) {
            if (aVar.b != null) {
                com.airbnb.lottie.model.k kVar = (com.airbnb.lottie.model.k) aVar.a;
                com.airbnb.lottie.model.k kVar2 = (com.airbnb.lottie.model.k) aVar.b;
                float f2 = kVar.a;
                f2 += (kVar2.a - f2) * f;
                float f3 = kVar.b;
                return new com.airbnb.lottie.model.k(f2, f3 + (f * (kVar2.b - f3)));
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
