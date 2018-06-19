package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.c.d;
import com.alibaba.fastjson.parser.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FieldDeserializer */
public abstract class k {
    public final d a;
    protected final Class<?> b;

    public abstract void a(a aVar, Object obj, Type type, Map<String, Object> map);

    public k(Class<?> cls, d dVar) {
        this.b = cls;
        this.a = dVar;
    }

    public void a(Object obj, Object obj2) {
        if (obj2 == null) {
            Class cls = this.a.d;
            if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE || cls == Boolean.TYPE || cls == Character.TYPE) {
                return;
            }
        }
        Method method = this.a.b;
        if (method != null) {
            try {
                if (this.a.g) {
                    if (this.a.d == AtomicInteger.class) {
                        AtomicInteger atomicInteger = (AtomicInteger) method.invoke(obj, new Object[0]);
                        if (atomicInteger != null) {
                            atomicInteger.set(((AtomicInteger) obj2).get());
                        }
                        return;
                    } else if (this.a.d == AtomicLong.class) {
                        AtomicLong atomicLong = (AtomicLong) method.invoke(obj, new Object[0]);
                        if (atomicLong != null) {
                            atomicLong.set(((AtomicLong) obj2).get());
                        }
                        return;
                    } else if (this.a.d == AtomicBoolean.class) {
                        AtomicBoolean atomicBoolean = (AtomicBoolean) method.invoke(obj, new Object[0]);
                        if (atomicBoolean != null) {
                            atomicBoolean.set(((AtomicBoolean) obj2).get());
                        }
                        return;
                    } else if (Map.class.isAssignableFrom(method.getReturnType())) {
                        Map map = (Map) method.invoke(obj, new Object[0]);
                        if (map != null) {
                            map.putAll((Map) obj2);
                        }
                        return;
                    } else {
                        Collection collection = (Collection) method.invoke(obj, new Object[0]);
                        if (collection != null) {
                            collection.addAll((Collection) obj2);
                        }
                        return;
                    }
                } else if (obj2 != null || !this.a.d.isPrimitive()) {
                    method.invoke(obj, new Object[]{obj2});
                    return;
                } else {
                    return;
                }
            } catch (Object obj3) {
                StringBuilder stringBuilder = new StringBuilder("set property error, ");
                stringBuilder.append(this.a.a);
                throw new JSONException(stringBuilder.toString(), obj3);
            }
        }
        Field field = this.a.c;
        if (field != null) {
            try {
                field.set(obj3, obj2);
            } catch (Object obj32) {
                stringBuilder = new StringBuilder("set property error, ");
                stringBuilder.append(this.a.a);
                throw new JSONException(stringBuilder.toString(), obj32);
            }
        }
    }
}
