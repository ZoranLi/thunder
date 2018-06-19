package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

/* compiled from: ParseContext */
public class f {
    public Object a;
    public final f b;
    public final Object c;
    public Type d;

    public f(f fVar, Object obj, Object obj2) {
        this.b = fVar;
        this.a = obj;
        this.c = obj2;
    }

    public String toString() {
        if (this.b == null) {
            return "$";
        }
        if (this.c instanceof Integer) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.toString());
            stringBuilder.append("[");
            stringBuilder.append(this.c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.toString());
        stringBuilder.append(".");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }
}
