package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.p;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.layer.a;

/* compiled from: Repeater */
public final class g implements b {
    public final String a;
    public final b b;
    public final b c;
    public final l d;

    g(String str, b bVar, b bVar2, l lVar) {
        this.a = str;
        this.b = bVar;
        this.c = bVar2;
        this.d = lVar;
    }

    @Nullable
    public final com.airbnb.lottie.a.a.b a(j jVar, a aVar) {
        return new p(jVar, aVar, this);
    }
}
