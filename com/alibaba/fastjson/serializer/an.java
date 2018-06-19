package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import com.alibaba.fastjson.parser.b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

/* compiled from: ObjectArrayCodec */
public final class an implements r, ao {
    public static final an a = new an();

    public final int e_() {
        return 14;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        Throwable th;
        af afVar2 = afVar;
        Object obj3 = obj;
        ax axVar = afVar2.a;
        Object[] objArr = (Object[]) obj3;
        if (obj3 != null) {
            int length = objArr.length;
            int i2 = length - 1;
            if (i2 == -1) {
                axVar.a((CharSequence) "[]");
                return;
            }
            at atVar = afVar2.m;
            afVar2.a(atVar, obj3, obj2);
            axVar.write(91);
            int i3 = 0;
            if (axVar.b(SerializerFeature.PrettyFormat)) {
                afVar.d();
                afVar.f();
                while (i3 < length) {
                    if (i3 != 0) {
                        axVar.write(44);
                        afVar.f();
                    }
                    afVar2.c(objArr[i3]);
                    i3++;
                }
                afVar.e();
                afVar.f();
                axVar.write(93);
                afVar2.m = atVar;
                return;
            }
            Object obj4;
            Class cls = null;
            ao aoVar = cls;
            int i4 = 0;
            while (i4 < i2) {
                try {
                    obj4 = objArr[i4];
                    if (obj4 == null) {
                        axVar.a((CharSequence) "null,");
                    } else {
                        if (afVar2.a(obj4)) {
                            afVar2.b(obj4);
                        } else {
                            Class cls2 = obj4.getClass();
                            if (cls2 == cls) {
                                aoVar.a(afVar2, obj4, null, null, 0);
                            } else {
                                ao a = afVar2.a(cls2);
                                Class cls3 = cls2;
                                a.a(afVar2, obj4, null, null, 0);
                                aoVar = a;
                                cls = cls3;
                            }
                        }
                        axVar.write(44);
                    }
                    i4++;
                } catch (Throwable e) {
                    th = e;
                    throw new JSONException(th.getMessage(), th);
                } catch (Throwable e2) {
                    th = e2;
                    afVar2.m = atVar;
                }
            }
            obj4 = objArr[i2];
            if (obj4 == null) {
                axVar.a((CharSequence) "null]");
            } else {
                if (afVar2.a(obj4)) {
                    afVar2.b(obj4);
                } else {
                    Integer valueOf = Integer.valueOf(i2);
                    if (obj4 == null) {
                        afVar2.a.write("null");
                    } else {
                        afVar2.a(obj4.getClass()).a(afVar2, obj4, valueOf, null, 0);
                    }
                }
                axVar.write(93);
            }
            afVar2.m = atVar;
        } else if (axVar.b(SerializerFeature.WriteNullListAsEmpty)) {
            axVar.write("[]");
        } else {
            axVar.write("null");
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        b bVar = aVar.e;
        T t = null;
        if (bVar.a() == 8) {
            bVar.a(16);
            return null;
        } else if (bVar.a() == 4) {
            aVar = bVar.v();
            bVar.a(16);
            return aVar;
        } else {
            Class cls;
            if (type instanceof GenericArrayType) {
                type = ((GenericArrayType) type).getGenericComponentType();
                if (type instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type;
                    Type type2 = aVar.c().d;
                    int i = 0;
                    if (type2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type2;
                        Type rawType = parameterizedType.getRawType();
                        if (rawType instanceof Class) {
                            TypeVariable[] typeParameters = ((Class) rawType).getTypeParameters();
                            while (i < typeParameters.length) {
                                if (typeParameters[i].getName().equals(typeVariable.getName())) {
                                    t = parameterizedType.getActualTypeArguments()[i];
                                }
                                i++;
                            }
                        }
                        if ((t instanceof Class) != null) {
                            cls = (Class) t;
                        } else {
                            cls = Object.class;
                        }
                    } else {
                        cls = j.e(typeVariable.getBounds()[0]);
                    }
                } else {
                    cls = j.e(type);
                }
            } else {
                cls = ((Class) type).getComponentType();
            }
            JSONArray jSONArray = new JSONArray();
            aVar.a((Type) cls, (Collection) jSONArray, obj);
            return a(aVar, cls, jSONArray);
        }
    }

    private <T> T a(a aVar, Class<?> cls, JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T newInstance = Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Object obj = jSONArray.get(i);
            if (obj == jSONArray) {
                Array.set(newInstance, i, newInstance);
            } else if (cls.isArray()) {
                if (!cls.isInstance(obj)) {
                    obj = a(aVar, (Class) cls, (JSONArray) obj);
                }
                Array.set(newInstance, i, obj);
            } else {
                Object toArray;
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    int size2 = jSONArray2.size();
                    int i2 = 0;
                    int i3 = i2;
                    while (i2 < size2) {
                        if (jSONArray2.get(i2) == jSONArray) {
                            jSONArray2.set(i, newInstance);
                            i3 = 1;
                        }
                        i2++;
                    }
                    if (i3 != 0) {
                        toArray = jSONArray2.toArray();
                        if (toArray == null) {
                            toArray = j.a(obj, (Class) cls, aVar.b());
                        }
                        Array.set(newInstance, i, toArray);
                    }
                }
                toArray = null;
                if (toArray == null) {
                    toArray = j.a(obj, (Class) cls, aVar.b());
                }
                Array.set(newInstance, i, toArray);
            }
        }
        jSONArray.setRelatedArray(newInstance);
        jSONArray.setComponentType(cls);
        return newInstance;
    }
}
