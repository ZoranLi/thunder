package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/* compiled from: CharsetCodec */
public final class q implements r, ao {
    public static final q a = new q();

    public final int e_() {
        return 4;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            afVar.a.write("null");
        } else {
            afVar.a(((Charset) obj).toString());
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        aVar = aVar.a(null);
        if (aVar == null) {
            return null;
        }
        return Charset.forName((String) aVar);
    }
}
