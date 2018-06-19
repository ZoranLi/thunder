package com.airbnb.lottie.a.b;

import com.airbnb.lottie.a.a;
import java.util.List;

/* compiled from: FloatKeyframeAnimation */
public final class c extends f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    final /* synthetic */ Object a(a aVar, float f) {
        if (aVar.a != null) {
            if (aVar.b != null) {
                float floatValue = ((Float) aVar.a).floatValue();
                return Float.valueOf(floatValue + (f * (((Float) aVar.b).floatValue() - floatValue)));
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
