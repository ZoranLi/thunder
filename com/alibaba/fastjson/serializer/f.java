package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import com.xiaomi.push.service.av;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: AtomicCodec */
public final class f implements r, ao {
    public static final f a = new f();

    public final int e_() {
        return 14;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        if ((obj instanceof AtomicInteger) != null) {
            afVar.a(((AtomicInteger) obj).get());
        } else if ((obj instanceof AtomicLong) != null) {
            afVar.a(((AtomicLong) obj).get());
        } else if ((obj instanceof AtomicBoolean) != null) {
            afVar.a(((AtomicBoolean) obj).get() != null ? "true" : av.b);
        } else if (obj != null) {
            int i2 = 0;
            if ((obj instanceof AtomicIntegerArray) != null) {
                AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                obj2 = atomicIntegerArray.length();
                afVar.write(91);
                while (i2 < obj2) {
                    int i3 = atomicIntegerArray.get(i2);
                    if (i2 != 0) {
                        afVar.write(44);
                    }
                    afVar.a(i3);
                    i2++;
                }
                afVar.write(93);
                return;
            }
            AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
            obj2 = atomicLongArray.length();
            afVar.write(91);
            while (i2 < obj2) {
                long j = atomicLongArray.get(i2);
                if (i2 != 0) {
                    afVar.write(44);
                }
                afVar.a(j);
                i2++;
            }
            afVar.write(93);
        } else if (afVar.b(SerializerFeature.WriteNullListAsEmpty) != null) {
            afVar.write("[]");
        } else {
            afVar.write("null");
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        if (aVar.e.a() == 8) {
            aVar.e.a(16);
            return null;
        }
        Collection jSONArray = new JSONArray();
        aVar.b(jSONArray);
        int i = 0;
        if (type == AtomicIntegerArray.class) {
            aVar = new AtomicIntegerArray(jSONArray.size());
            while (i < jSONArray.size()) {
                aVar.set(i, jSONArray.getInteger(i).intValue());
                i++;
            }
            return aVar;
        }
        aVar = new AtomicLongArray(jSONArray.size());
        while (i < jSONArray.size()) {
            aVar.set(i, jSONArray.getLong(i).longValue());
            i++;
        }
        return aVar;
    }
}
