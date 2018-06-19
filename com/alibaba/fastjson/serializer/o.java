package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: CharArrayCodec */
public final class o implements r, ao {
    public static o a = new o();

    public final int e_() {
        return 4;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        if (obj != null) {
            afVar.b(new String((char[]) obj));
        } else if (afVar.b(SerializerFeature.WriteNullListAsEmpty) != null) {
            afVar.write("[]");
        } else {
            afVar.write("null");
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        type = aVar.e;
        if (type.a() == 4) {
            aVar = type.l();
            type.a(16);
            return aVar.toCharArray();
        } else if (type.a() == 2) {
            aVar = type.j();
            type.a(16);
            return aVar.toString().toCharArray();
        } else {
            aVar = aVar.a(null);
            if (aVar == null) {
                return null;
            }
            return com.alibaba.fastjson.a.toJSONString(aVar).toCharArray();
        }
    }
}
