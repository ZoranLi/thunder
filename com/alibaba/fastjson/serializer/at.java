package com.alibaba.fastjson.serializer;

/* compiled from: SerialContext */
public class at {
    public final at a;
    public final Object b;
    public final Object c;
    public final int d;

    public at(at atVar, Object obj, Object obj2, int i) {
        this.a = atVar;
        this.b = obj;
        this.c = obj2;
        this.d = i;
    }

    public String toString() {
        if (this.a == null) {
            return "$";
        }
        if (this.c instanceof Integer) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.toString());
            stringBuilder.append("[");
            stringBuilder.append(this.c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.toString());
        stringBuilder.append(".");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }
}
