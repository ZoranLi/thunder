package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.b;
import com.alibaba.fastjson.parser.e;
import com.alibaba.fastjson.parser.f;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: ArrayListTypeFieldDeserializer */
public final class d extends k {
    private final Type c;
    private int d;
    private r e;

    public d(Class<?> cls, com.alibaba.fastjson.c.d dVar) {
        super(cls, dVar);
        if ((dVar.e instanceof ParameterizedType) != null) {
            this.c = ((ParameterizedType) dVar.e).getActualTypeArguments()[null];
        } else {
            this.c = Object.class;
        }
    }

    public final void a(a aVar, Object obj, Type type, Map<String, Object> map) {
        if (aVar.e.a() == 8) {
            a(obj, null);
            return;
        }
        Collection arrayList = new ArrayList();
        f c = aVar.c();
        aVar.a(c, obj, this.a.a);
        a(aVar, type, arrayList);
        aVar.a(c);
        if (obj == null) {
            map.put(this.a.a, arrayList);
        } else {
            a(obj, arrayList);
        }
    }

    private void a(a aVar, Type type, Collection collection) {
        Type type2 = this.c;
        r rVar = this.e;
        int i = 0;
        if ((type2 instanceof TypeVariable) && (type instanceof ParameterizedType)) {
            int i2;
            TypeVariable typeVariable = (TypeVariable) type2;
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = null;
            if (parameterizedType.getRawType() instanceof Class) {
                cls = (Class) parameterizedType.getRawType();
            }
            if (cls != null) {
                int length = cls.getTypeParameters().length;
                i2 = 0;
                while (i2 < length) {
                    if (cls.getTypeParameters()[i2].getName().equals(typeVariable.getName())) {
                        break;
                    }
                    i2++;
                }
            }
            i2 = -1;
            if (i2 != -1) {
                type2 = parameterizedType.getActualTypeArguments()[i2];
                if (!type2.equals(this.c)) {
                    rVar = aVar.b().a(type2);
                }
            }
        }
        b bVar = aVar.e;
        if (bVar.a() != 14) {
            aVar = new StringBuilder("exepct '[', but ");
            aVar.append(e.a(bVar.a()));
            aVar = aVar.toString();
            if (type != null) {
                collection = new StringBuilder();
                collection.append(aVar);
                collection.append(", type : ");
                collection.append(type);
                aVar = collection.toString();
            }
            throw new JSONException(aVar);
        }
        if (rVar == null) {
            rVar = aVar.b().a(type2);
            this.e = rVar;
            this.d = this.e.e_();
        }
        bVar.a(this.d);
        while (true) {
            if (bVar.a(Feature.AllowArbitraryCommas) != null) {
                while (bVar.a() == 16) {
                    bVar.d();
                }
            }
            if (bVar.a() != 15) {
                collection.add(rVar.a(aVar, type2, Integer.valueOf(i)));
                aVar.a(collection);
                if (bVar.a() == 16) {
                    bVar.a(this.d);
                }
                i++;
            } else {
                bVar.a(16);
                return;
            }
        }
    }
}
