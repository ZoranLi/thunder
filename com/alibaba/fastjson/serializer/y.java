package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* compiled from: EnumerationSerializer */
public final class y implements ao {
    public static y a = new y();

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        i = afVar.a;
        if (obj != null) {
            Type type2 = null;
            int i2 = 0;
            if (i.b(SerializerFeature.WriteClassName) && (type instanceof ParameterizedType)) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Enumeration enumeration = (Enumeration) obj;
            at atVar = afVar.m;
            afVar.a(atVar, obj, obj2);
            try {
                i.write(91);
                while (enumeration.hasMoreElements() != null) {
                    Object nextElement = enumeration.nextElement();
                    obj = i2 + 1;
                    if (i2 != 0) {
                        i.write(44);
                    }
                    if (nextElement == null) {
                        i.write("null");
                    } else {
                        afVar.a(nextElement.getClass()).a(afVar, nextElement, Integer.valueOf(obj - 1), type2, 0);
                    }
                    i2 = obj;
                }
                i.write(93);
            } finally {
                afVar.m = atVar;
            }
        } else if (i.b(SerializerFeature.WriteNullListAsEmpty) != null) {
            i.write("[]");
        } else {
            i.write("null");
        }
    }
}
