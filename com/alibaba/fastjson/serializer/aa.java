package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: FloatCodec */
public final class aa implements r, ao {
    public static aa a = new aa();

    public final int e_() {
        return 2;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        if (obj != null) {
            obj = ((Float) obj).floatValue();
            if (Float.isNaN(obj) == null) {
                if (Float.isInfinite(obj) == null) {
                    String f = Float.toString(obj);
                    if (f.endsWith(".0") != null) {
                        f = f.substring(null, f.length() - 2);
                    }
                    afVar.write(f);
                    if (afVar.b(SerializerFeature.WriteClassName) != null) {
                        afVar.write(70);
                    }
                    return;
                }
            }
            afVar.write("null");
        } else if (afVar.b(SerializerFeature.WriteNullNumberAsZero) != null) {
            afVar.write(48);
        } else {
            afVar.write("null");
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        type = aVar.e;
        if (type.a() == 2) {
            aVar = type.u();
            type.a(16);
            return Float.valueOf(Float.parseFloat(aVar));
        } else if (type.a() == 3) {
            aVar = type.w();
            type.a(16);
            return Float.valueOf(aVar);
        } else {
            Object a = aVar.a(null);
            if (a == null) {
                return null;
            }
            return j.g(a);
        }
    }
}
