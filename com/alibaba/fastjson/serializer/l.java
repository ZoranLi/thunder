package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

/* compiled from: BigIntegerCodec */
public final class l implements r, ao {
    public static final l a = new l();

    public final int e_() {
        return 2;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        if (obj != null) {
            afVar.write(((BigInteger) obj).toString());
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
            return new BigInteger(aVar);
        }
        Object a = aVar.a(null);
        if (a == null) {
            return null;
        }
        return j.f(a);
    }
}
