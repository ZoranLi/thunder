package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: ResolveFieldDeserializer */
public final class u extends k {
    private final int c;
    private final List d;
    private final a e;
    private final Object f;
    private final Map g;
    private final Collection h;

    public final void a(a aVar, Object obj, Type type, Map<String, Object> map) {
    }

    public u(a aVar, List list, int i) {
        super(null, null);
        this.e = aVar;
        this.c = i;
        this.d = list;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public u(Map map, Object obj) {
        super(null, null);
        this.e = null;
        this.c = -1;
        this.d = null;
        this.f = obj;
        this.g = map;
        this.h = null;
    }

    public u(Collection collection) {
        super(null, null);
        this.e = null;
        this.c = -1;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = collection;
    }

    public final void a(Object obj, Object obj2) {
        if (this.g != null) {
            this.g.put(this.f, obj2);
        } else if (this.h != null) {
            this.h.add(obj2);
        } else {
            this.d.set(this.c, obj2);
            if ((this.d instanceof JSONArray) != null) {
                JSONArray jSONArray = (JSONArray) this.d;
                Object relatedArray = jSONArray.getRelatedArray();
                if (relatedArray != null && Array.getLength(relatedArray) > this.c) {
                    if (jSONArray.getComponentType() != null) {
                        obj2 = j.a(obj2, jSONArray.getComponentType(), this.e.b());
                    }
                    Array.set(relatedArray, this.c, obj2);
                }
            }
        }
    }
}
