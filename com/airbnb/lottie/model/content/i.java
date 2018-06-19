package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.f;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.a;
import com.airbnb.lottie.model.a.d;

/* compiled from: ShapeFill */
public final class i implements b {
    public final FillType a;
    public final String b;
    @Nullable
    public final a c;
    @Nullable
    public final d d;
    private final boolean e;

    private i(String str, boolean z, FillType fillType, @Nullable a aVar, @Nullable d dVar) {
        this.b = str;
        this.e = z;
        this.a = fillType;
        this.c = aVar;
        this.d = dVar;
    }

    public final b a(j jVar, com.airbnb.lottie.model.layer.a aVar) {
        return new f(jVar, aVar, this);
    }

    public final String toString() {
        String str;
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("ShapeFill{color=");
        if (this.c == null) {
            str = "null";
        } else {
            str = Integer.toHexString(((Integer) this.c.b()).intValue());
        }
        stringBuilder.append(str);
        stringBuilder.append(", fillEnabled=");
        stringBuilder.append(this.e);
        stringBuilder.append(", opacity=");
        if (this.d == null) {
            obj = "null";
        } else {
            obj = (Integer) this.d.b;
        }
        stringBuilder.append(obj);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
