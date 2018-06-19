package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import com.xiaomi.push.service.av;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: BooleanCodec */
public final class m implements r, ao {
    public static final m a = new m();

    public final int e_() {
        return 6;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if (afVar.b(SerializerFeature.WriteNullBooleanAsFalse) != null) {
                afVar.write(av.b);
            } else {
                afVar.write("null");
            }
        } else if (bool.booleanValue() != null) {
            afVar.write("true");
        } else {
            afVar.write(av.b);
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        obj = aVar.e;
        if (obj.a() == 6) {
            obj.a(16);
            aVar = Boolean.TRUE;
        } else if (obj.a() == 7) {
            obj.a(16);
            aVar = Boolean.FALSE;
        } else if (obj.a() == 2) {
            aVar = obj.n();
            obj.a(16);
            if (aVar == 1) {
                aVar = Boolean.TRUE;
            } else {
                aVar = Boolean.FALSE;
            }
        } else {
            aVar = aVar.a(null);
            if (aVar == null) {
                return null;
            }
            aVar = j.o(aVar);
        }
        return type == AtomicBoolean.class ? new AtomicBoolean(aVar.booleanValue()) : aVar;
    }
}
