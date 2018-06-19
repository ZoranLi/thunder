package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: EnumSerializer */
public final class x implements ao {
    public static final x a = new x();

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        obj2 = afVar.a;
        if (obj == null) {
            obj2.write("null");
            return;
        }
        Enum enumR = (Enum) obj;
        if (obj2.s != null && obj2.t == null) {
            afVar.a(enumR.name());
        } else if (obj2.t != null) {
            afVar.a(enumR.toString());
        } else {
            obj2.a(enumR.ordinal());
        }
    }
}
