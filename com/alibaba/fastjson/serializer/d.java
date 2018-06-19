package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: AppendableSerializer */
public final class d implements ao {
    public static final d a = new d();

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            afVar = afVar.a;
            if (afVar.b(SerializerFeature.WriteNullStringAsEmpty) != null) {
                afVar.b("");
                return;
            } else {
                afVar.write("null");
                return;
            }
        }
        afVar.a(obj.toString());
    }
}
