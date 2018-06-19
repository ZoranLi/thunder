package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.d;
import java.lang.reflect.Type;

/* compiled from: AbstractDateDeserializer */
public abstract class c implements r {
    public abstract <T> T b(a aVar, Type type, Object obj);

    public final <T> T a(a aVar, Type type, Object obj) {
        obj = aVar.e;
        Object obj2 = null;
        if (obj.a() == 2) {
            obj2 = Long.valueOf(obj.s());
            obj.a(16);
        } else if (obj.a() == 4) {
            String l = obj.l();
            obj.a(16);
            if (obj.a(Feature.AllowISO8601DateFormat) != null) {
                obj = new d(l);
                if (obj.D()) {
                    l = obj.C().getTime();
                }
                obj.close();
            }
            obj2 = l;
        } else if (obj.a() == 8) {
            obj.d();
        } else if (obj.a() == 12) {
            obj.d();
            if (obj.a() == 4) {
                if (com.alibaba.fastjson.a.DEFAULT_TYPE_KEY.equals(obj.l())) {
                    obj.d();
                    aVar.a(17);
                    Class a = j.a(obj.l(), aVar.b().b());
                    if (a != null) {
                        type = a;
                    }
                    aVar.a(4);
                    aVar.a(16);
                }
                obj.p();
                if (obj.a() == 2) {
                    long s = obj.s();
                    obj.d();
                    obj2 = Long.valueOf(s);
                    aVar.a(13);
                } else {
                    type = new StringBuilder("syntax error : ");
                    type.append(obj.b());
                    throw new JSONException(type.toString());
                }
            }
            throw new JSONException("syntax error");
        } else if (aVar.g == 2) {
            aVar.g = 0;
            aVar.a(16);
            if (obj.a() != 4) {
                throw new JSONException("syntax error");
            } else if ("val".equals(obj.l())) {
                obj.d();
                aVar.a(17);
                obj2 = aVar.a(null);
                aVar.a(13);
            } else {
                throw new JSONException("syntax error");
            }
        } else {
            obj2 = aVar.a(null);
        }
        return b(aVar, type, obj2);
    }
}
