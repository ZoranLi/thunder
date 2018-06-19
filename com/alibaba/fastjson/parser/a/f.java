package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.c.d;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.g;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: DefaultFieldDeserializer */
public final class f extends k {
    private r c;

    public f(Class<?> cls, d dVar) {
        super(cls, dVar);
    }

    public final void a(a aVar, Object obj, Type type, Map<String, Object> map) {
        if (this.c == null) {
            g b = aVar.b();
            d dVar = this.a;
            this.c = b.a(dVar.d, dVar.e);
        }
        if (type instanceof ParameterizedType) {
            aVar.c().d = type;
        }
        type = this.c.a(aVar, this.a.e, this.a.a);
        if (aVar.g == 1) {
            obj = aVar.d();
            obj.a = this;
            obj.b = aVar.c();
            aVar.g = null;
        } else if (obj == null) {
            map.put(this.a.a, type);
        } else {
            a(obj, type);
        }
    }
}
