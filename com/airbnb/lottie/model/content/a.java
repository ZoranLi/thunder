package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.e;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.a.m;

/* compiled from: CircleShape */
public final class a implements b {
    public final String a;
    public final m<PointF, PointF> b;
    public final f c;
    public final boolean d;

    private a(String str, m<PointF, PointF> mVar, f fVar, boolean z) {
        this.a = str;
        this.b = mVar;
        this.c = fVar;
        this.d = z;
    }

    public final b a(j jVar, com.airbnb.lottie.model.layer.a aVar) {
        return new e(jVar, aVar, this);
    }
}
