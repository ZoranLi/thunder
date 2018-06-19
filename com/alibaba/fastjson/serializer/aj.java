package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: LongCodec */
public final class aj implements r, ao {
    public static aj a = new aj();

    public final int e_() {
        return 2;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        if (obj != null) {
            long longValue = ((Long) obj).longValue();
            afVar.a(longValue);
            if (afVar.m != 0 && longValue <= 2147483647L && longValue >= -2147483648L && type != Long.class) {
                afVar.write(76);
            }
        } else if (afVar.b(SerializerFeature.WriteNullNumberAsZero) != null) {
            afVar.write(48);
        } else {
            afVar.write("null");
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        obj = aVar.e;
        if (obj.a() == 2) {
            long s = obj.s();
            obj.a(16);
            aVar = Long.valueOf(s);
        } else {
            aVar = aVar.a(null);
            if (aVar == null) {
                return null;
            }
            aVar = j.l(aVar);
        }
        return type == AtomicLong.class ? new AtomicLong(aVar.longValue()) : aVar;
    }
}
