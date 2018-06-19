package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* compiled from: BigDecimalCodec */
public final class k implements r, ao {
    public static final k a = new k();

    public final int e_() {
        return 2;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        if (obj != null) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            afVar.write(bigDecimal.toString());
            if (!(afVar.b(SerializerFeature.WriteClassName) == null || type == BigDecimal.class || bigDecimal.scale() != null)) {
                afVar.write(46);
            }
        } else if (afVar.b(SerializerFeature.WriteNullNumberAsZero) != null) {
            afVar.write(48);
        } else {
            afVar.write("null");
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        type = aVar.e;
        if (type.a() == 2) {
            aVar = type.k();
            type.a(16);
            return aVar;
        } else if (type.a() == 3) {
            aVar = type.k();
            type.a(16);
            return aVar;
        } else {
            Object a = aVar.a(null);
            if (a == null) {
                return null;
            }
            return j.e(a);
        }
    }
}
