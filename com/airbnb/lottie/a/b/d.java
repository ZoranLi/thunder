package com.airbnb.lottie.a.b;

import com.airbnb.lottie.a.a;
import com.airbnb.lottie.model.content.c;
import com.umeng.message.proguard.k;
import java.util.List;

/* compiled from: GradientColorKeyframeAnimation */
public final class d extends f<c> {
    private final c d;

    public d(List<? extends a<c>> list) {
        super(list);
        int i = 0;
        c cVar = (c) ((a) list.get(0)).a;
        if (cVar != null) {
            i = cVar.b.length;
        }
        this.d = new c(new float[i], new int[i]);
    }

    final /* synthetic */ Object a(a aVar, float f) {
        c cVar = this.d;
        c cVar2 = (c) aVar.a;
        c cVar3 = (c) aVar.b;
        if (cVar2.b.length != cVar3.b.length) {
            StringBuilder stringBuilder = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
            stringBuilder.append(cVar2.b.length);
            stringBuilder.append(" vs ");
            stringBuilder.append(cVar3.b.length);
            stringBuilder.append(k.t);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        for (int i = 0; i < cVar2.b.length; i++) {
            float[] fArr = cVar.a;
            float f2 = cVar2.a[i];
            fArr[i] = f2 + ((cVar3.a[i] - f2) * f);
            cVar.b[i] = com.airbnb.lottie.c.a.a(f, cVar2.b[i], cVar3.b[i]);
        }
        return this.d;
    }
}
