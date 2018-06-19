package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.layer.a;

public final class PolystarShape implements b {
    public final String a;
    public final Type b;
    public final b c;
    public final m<PointF, PointF> d;
    public final b e;
    public final b f;
    public final b g;
    public final b h;
    public final b i;

    public enum Type {
        Star(1),
        Polygon(2);
        
        private final int value;

        private Type(int i) {
            this.value = i;
        }

        static Type forValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return 0;
        }
    }

    private PolystarShape(String str, Type type, b bVar, m<PointF, PointF> mVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6) {
        this.a = str;
        this.b = type;
        this.c = bVar;
        this.d = mVar;
        this.e = bVar2;
        this.f = bVar3;
        this.g = bVar4;
        this.h = bVar5;
        this.i = bVar6;
    }

    public final com.airbnb.lottie.a.a.b a(j jVar, a aVar) {
        return new com.airbnb.lottie.a.a.m(jVar, aVar, this);
    }
}
