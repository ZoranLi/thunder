package com.alipay.a.a;

import com.alipay.a.b.a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.alipay.b;

public final class h implements i, j {
    private static Map<Object, Object> a(Type type) {
        Class rawType;
        while (rawType != Properties.class) {
            if (rawType == Hashtable.class) {
                return new Hashtable();
            }
            if (rawType == IdentityHashMap.class) {
                return new IdentityHashMap();
            }
            if (rawType != SortedMap.class) {
                if (rawType != TreeMap.class) {
                    if (rawType != ConcurrentMap.class) {
                        if (rawType != ConcurrentHashMap.class) {
                            if (rawType != Map.class) {
                                if (rawType != HashMap.class) {
                                    if (rawType == LinkedHashMap.class) {
                                        return new LinkedHashMap();
                                    }
                                    if (rawType instanceof ParameterizedType) {
                                        rawType = ((ParameterizedType) rawType).getRawType();
                                    } else {
                                        Class cls = rawType;
                                        if (cls.isInterface()) {
                                            StringBuilder stringBuilder = new StringBuilder("unsupport type ");
                                            stringBuilder.append(rawType);
                                            throw new IllegalArgumentException(stringBuilder.toString());
                                        }
                                        try {
                                            return (Map) cls.newInstance();
                                        } catch (Throwable e) {
                                            StringBuilder stringBuilder2 = new StringBuilder("unsupport type ");
                                            stringBuilder2.append(rawType);
                                            throw new IllegalArgumentException(stringBuilder2.toString(), e);
                                        }
                                    }
                                }
                            }
                            return new HashMap();
                        }
                    }
                    return new ConcurrentHashMap();
                }
            }
            return new TreeMap();
        }
        return new Properties();
    }

    public final Object a(Object obj) {
        Map treeMap = new TreeMap();
        for (Entry entry : ((Map) obj).entrySet()) {
            if (entry.getKey() instanceof String) {
                treeMap.put((String) entry.getKey(), f.b(entry.getValue()));
            } else {
                throw new IllegalArgumentException("Map key must be String!");
            }
        }
        return treeMap;
    }

    public final Object a(Object obj, Type type) {
        if (!obj.getClass().equals(b.class)) {
            return null;
        }
        b bVar = (b) obj;
        Map a = a(type);
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = parameterizedType.getActualTypeArguments()[0];
            type = parameterizedType.getActualTypeArguments()[1];
            if (String.class == cls) {
                Iterator a2 = bVar.a();
                while (a2.hasNext()) {
                    String str = (String) a2.next();
                    a.put(str, a.a((Class) type) ? bVar.a(str) : e.a(bVar.a(str), type));
                }
                return a;
            }
            throw new IllegalArgumentException("Deserialize Map Key must be String.class");
        }
        throw new IllegalArgumentException("Deserialize Map must be Generics!");
    }

    public final boolean a(Class<?> cls) {
        return Map.class.isAssignableFrom(cls);
    }
}
