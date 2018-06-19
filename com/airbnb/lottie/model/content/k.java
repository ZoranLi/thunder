package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.q;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.h;
import com.airbnb.lottie.model.layer.a;

/* compiled from: ShapePath */
public final class k implements b {
    public final String a;
    public final h b;
    private final int c;

    private k(String str, int i, h hVar) {
        this.a = str;
        this.c = i;
        this.b = hVar;
    }

    public final b a(j jVar, a aVar) {
        return new q(jVar, aVar, this);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ShapePath{name=");
        stringBuilder.append(this.a);
        stringBuilder.append(", index=");
        stringBuilder.append(this.c);
        stringBuilder.append(", hasAnimation=");
        stringBuilder.append(this.b.d());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
