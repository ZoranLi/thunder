package com.airbnb.lottie.a.b;

import com.airbnb.lottie.a.a;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation */
public final class e extends f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    final /* synthetic */ Object a(a aVar, float f) {
        if (aVar.a != null) {
            if (aVar.b != null) {
                int intValue = ((Integer) aVar.a).intValue();
                return Integer.valueOf((int) (((float) intValue) + (f * ((float) (((Integer) aVar.b).intValue() - intValue)))));
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
