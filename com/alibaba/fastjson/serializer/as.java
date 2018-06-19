package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReferenceCodec */
public final class as implements r, ao {
    public static final as a = new as();

    public final int e_() {
        return 12;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        if ((obj instanceof AtomicReference) != null) {
            obj = ((AtomicReference) obj).get();
        } else {
            obj = ((Reference) obj).get();
        }
        afVar.c(obj);
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        aVar = aVar.a(parameterizedType.getActualTypeArguments()[0], null);
        type = parameterizedType.getRawType();
        if (type == AtomicReference.class) {
            return new AtomicReference(aVar);
        }
        if (type == WeakReference.class) {
            return new WeakReference(aVar);
        }
        if (type == SoftReference.class) {
            return new SoftReference(aVar);
        }
        throw new UnsupportedOperationException(type.toString());
    }
}
