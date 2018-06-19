package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: ArraySerializer */
public final class e implements ao {
    private final Class<?> a;
    private final ao b;

    public e(Class<?> cls, ao aoVar) {
        this.a = cls;
        this.b = aoVar;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        type = afVar.a;
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            at atVar = afVar.m;
            afVar.a(atVar, obj, obj2);
            try {
                type.write(91);
                for (obj = null; obj < length; obj++) {
                    if (obj != null) {
                        type.write(44);
                    }
                    Object obj3 = objArr[obj];
                    if (obj3 == null) {
                        type.a((CharSequence) "null");
                    } else if (obj3.getClass() == this.a) {
                        this.b.a(afVar, obj3, Integer.valueOf(obj), null, 0);
                    } else {
                        afVar.a(obj3.getClass()).a(afVar, obj3, Integer.valueOf(obj), null, 0);
                    }
                }
                type.write(93);
            } finally {
                afVar.m = atVar;
            }
        } else if (type.b(SerializerFeature.WriteNullListAsEmpty) != null) {
            type.write("[]");
        } else {
            type.write("null");
        }
    }
}
