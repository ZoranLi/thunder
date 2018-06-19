package com.alipay.a.a;

import com.alipay.a.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.alipay.b;

public final class f {
    private static List<j> a;

    static {
        List arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new l());
        a.add(new d());
        a.add(new c());
        a.add(new h());
        a.add(new b());
        a.add(new a());
        a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        obj = b(obj);
        if (a.a(obj.getClass())) {
            return b.c(obj.toString());
        }
        if (Collection.class.isAssignableFrom(obj.getClass())) {
            return new org.json.alipay.a((List) obj).toString();
        }
        if (Map.class.isAssignableFrom(obj.getClass())) {
            return new b((Map) obj).toString();
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported Class : ");
        stringBuilder.append(obj.getClass());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static Object b(Object obj) {
        if (obj == null) {
            return null;
        }
        for (j jVar : a) {
            if (jVar.a(obj.getClass())) {
                Object a = jVar.a(obj);
                if (a != null) {
                    return a;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported Class : ");
        stringBuilder.append(obj.getClass());
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
