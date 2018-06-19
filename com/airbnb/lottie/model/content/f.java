package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.layer.a;

/* compiled from: RectangleShape */
public final class f implements b {
    public final String a;
    public final m<PointF, PointF> b;
    public final com.airbnb.lottie.model.a.f c;
    public final b d;

    private f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, b bVar) {
        this.a = str;
        this.b = mVar;
        this.c = fVar;
        this.d = bVar;
    }

    public final com.airbnb.lottie.a.a.b a(j jVar, a aVar) {
        return new o(jVar, aVar, this);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RectangleShape{cornerRadius=");
        stringBuilder.append((Float) this.d.b);
        stringBuilder.append(", position=");
        stringBuilder.append(this.b);
        stringBuilder.append(", size=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
