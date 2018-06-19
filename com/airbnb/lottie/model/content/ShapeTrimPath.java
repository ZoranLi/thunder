package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.s;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.layer.a;
import com.alipay.sdk.util.h;

public final class ShapeTrimPath implements b {
    public final String a;
    public final Type b;
    public final b c;
    public final b d;
    public final b e;

    public enum Type {
        Simultaneously,
        Individually;

        static Type forId(int i) {
            switch (i) {
                case 1:
                    return Simultaneously;
                case 2:
                    return Individually;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unknown trim path type ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    private ShapeTrimPath(String str, Type type, b bVar, b bVar2, b bVar3) {
        this.a = str;
        this.b = type;
        this.c = bVar;
        this.d = bVar2;
        this.e = bVar3;
    }

    public final com.airbnb.lottie.a.a.b a(j jVar, a aVar) {
        return new s(aVar, this);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Trim Path: {start: ");
        stringBuilder.append(this.c);
        stringBuilder.append(", end: ");
        stringBuilder.append(this.d);
        stringBuilder.append(", offset: ");
        stringBuilder.append(this.e);
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }
}
