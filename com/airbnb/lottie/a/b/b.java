package com.airbnb.lottie.a.b;

import com.airbnb.lottie.a.a;
import java.util.List;

/* compiled from: ColorKeyframeAnimation */
public final class b extends f<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f) {
        if (aVar.a != null) {
            if (aVar.b != null) {
                return Integer.valueOf(com.airbnb.lottie.c.a.a(f, ((Integer) aVar.a).intValue(), ((Integer) aVar.b).intValue()));
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
