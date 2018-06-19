package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import com.alibaba.fastjson.parser.b;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: StringCodec */
public final class ay implements r, ao {
    public static ay a = new ay();

    public final int e_() {
        return 4;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        a(afVar, (String) obj);
    }

    public static void a(af afVar, String str) {
        afVar = afVar.a;
        if (str != null) {
            afVar.b(str);
        } else if (afVar.b(SerializerFeature.WriteNullStringAsEmpty) != null) {
            afVar.b("");
        } else {
            afVar.write("null");
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        if (type == StringBuffer.class) {
            type = aVar.e;
            if (type.a() == 4) {
                aVar = type.l();
                type.a(16);
                return new StringBuffer(aVar);
            }
            aVar = aVar.a(null);
            if (aVar == null) {
                return null;
            }
            return new StringBuffer(aVar.toString());
        } else if (type != StringBuilder.class) {
            return a(aVar);
        } else {
            type = aVar.e;
            if (type.a() == 4) {
                aVar = type.l();
                type.a(16);
                return new StringBuilder(aVar);
            }
            aVar = aVar.a(null);
            if (aVar == null) {
                return null;
            }
            return new StringBuilder(aVar.toString());
        }
    }

    public static <T> T a(a aVar) {
        b bVar = aVar.e;
        if (bVar.a() == 4) {
            aVar = bVar.l();
            bVar.a(16);
            return aVar;
        } else if (bVar.a() == 2) {
            aVar = bVar.u();
            bVar.a(16);
            return aVar;
        } else {
            aVar = aVar.a(null);
            if (aVar == null) {
                return null;
            }
            return aVar.toString();
        }
    }
}
