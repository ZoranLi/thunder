package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.sql.Clob;

/* compiled from: ClobSeriliazer */
public final class r implements ao {
    public static final r a = new r();

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            try {
                afVar.a.write("null");
                return;
            } catch (af afVar2) {
                throw new IOException("write clob error", afVar2);
            }
        }
        obj = ((Clob) obj).getCharacterStream();
        obj2 = new StringWriter();
        type = new char[1024];
        while (true) {
            i = obj.read(type);
            if (i != -1) {
                obj2.write(type, 0, i);
            } else {
                obj.close();
                afVar2.a(obj2.toString());
                return;
            }
        }
    }
}
