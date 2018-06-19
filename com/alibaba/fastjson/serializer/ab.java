package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import com.alibaba.fastjson.parser.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IntegerCodec */
public final class ab implements r, ao {
    public static ab a = new ab();

    public final int e_() {
        return 2;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        Number number = (Number) obj;
        if (number != null) {
            if ((obj instanceof Long) != null) {
                afVar.a(number.longValue());
            } else {
                afVar.a(number.intValue());
            }
            if (afVar.m != null) {
                obj = number.getClass();
                if (obj == Byte.class) {
                    afVar.write(66);
                } else if (obj == Short.class) {
                    afVar.write(83);
                }
            }
        } else if (afVar.b(SerializerFeature.WriteNullNumberAsZero) != null) {
            afVar.write(48);
        } else {
            afVar.write("null");
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        b bVar = aVar.e;
        if (bVar.a() == 8) {
            bVar.a(16);
            return null;
        }
        if (bVar.a() == 2) {
            try {
                aVar = bVar.n();
                bVar.a(16);
                aVar = Integer.valueOf(aVar);
            } catch (a aVar2) {
                StringBuilder stringBuilder = new StringBuilder("int value overflow, field : ");
                stringBuilder.append(obj);
                throw new JSONException(stringBuilder.toString(), aVar2);
            }
        } else if (bVar.a() == 3) {
            aVar2 = bVar.k();
            bVar.a(16);
            aVar2 = Integer.valueOf(aVar2.intValue());
        } else {
            aVar2 = j.m(aVar2.a(null));
        }
        return type == AtomicInteger.class ? new AtomicInteger(aVar2.intValue()) : aVar2;
    }
}
