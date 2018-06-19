package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.b;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: JSONAwareSerializer */
public final class ac implements ao {
    public static ac a = new ac();

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar.a.write(((b) obj).toJSONString());
    }
}
