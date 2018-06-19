package com.alibaba.fastjson.c;

import com.alibaba.fastjson.a.b;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: FieldInfo */
public final class d implements Comparable<d> {
    public final String a;
    public final Method b;
    public final Field c;
    public final Class<?> d;
    public final Type e;
    public final Class<?> f;
    public final boolean g;
    public final int h;
    public final String i;
    public final boolean j;
    public final boolean k;
    public final char[] l;
    public final boolean m;
    private int n = 0;
    private final b o;
    private final b p;

    public final /* synthetic */ int compareTo(Object obj) {
        return a((d) obj);
    }

    public d(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i, int i2) {
        this.a = str;
        this.f = cls;
        this.d = cls2;
        this.e = type;
        this.b = null;
        this.c = field;
        this.n = i;
        this.h = i2;
        this.m = cls2.isEnum();
        if (field != null) {
            cls = field.getModifiers();
            if ((cls & 1) == null) {
                if (this.b != null) {
                    cls2 = null;
                    this.j = cls2;
                    this.k = Modifier.isTransient(cls);
                }
            }
            cls2 = true;
            this.j = cls2;
            this.k = Modifier.isTransient(cls);
        } else {
            this.k = false;
            this.j = false;
        }
        this.l = d();
        if (field != null) {
            j.a((AccessibleObject) field);
        }
        this.i = "";
        this.o = null;
        this.p = null;
        this.g = false;
    }

    public d(String str, Method method, Field field, Class<?> cls, Type type, int i, int i2, b bVar, b bVar2, String str2) {
        AccessibleObject accessibleObject;
        boolean z = false;
        if (field != null) {
            String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        this.a = str;
        this.b = method;
        this.c = field;
        this.n = i;
        this.h = i2;
        this.o = bVar;
        this.p = bVar2;
        if (field != null) {
            i = field.getModifiers();
            if ((i & 1) == 0) {
                if (method != null) {
                    i2 = 0;
                    this.j = i2;
                    this.k = Modifier.isTransient(i);
                }
            }
            i2 = 1;
            this.j = i2;
            this.k = Modifier.isTransient(i);
        } else {
            this.j = false;
            this.k = false;
        }
        if (str2 == null || str2.length() <= 0) {
            this.i = "";
        } else {
            this.i = str2;
        }
        this.l = d();
        if (method != null) {
            j.a((AccessibleObject) method);
        }
        if (field != null) {
            j.a((AccessibleObject) field);
        }
        if (method != null) {
            AccessibleObject accessibleObject2;
            field = method.getParameterTypes();
            if (field.length == 1) {
                str = field[0];
                accessibleObject2 = method.getGenericParameterTypes()[0];
            } else {
                z = true;
                str = method.getReturnType();
                accessibleObject2 = method.getGenericReturnType();
            }
            this.f = method.getDeclaringClass();
            accessibleObject = accessibleObject2;
        } else {
            str = field.getType();
            accessibleObject = field.getGenericType();
            this.f = field.getDeclaringClass();
        }
        this.g = z;
        if (!(cls == null || str != Object.class || (accessibleObject instanceof TypeVariable) == null)) {
            Type a = a(cls, (TypeVariable) accessibleObject);
            if (a != null) {
                this.d = j.e(a);
                this.e = a;
                this.m = str.isEnum();
                return;
            }
        }
        if ((accessibleObject instanceof Class) == null) {
            field = a(cls, type, accessibleObject);
            if (field != accessibleObject) {
                if ((field instanceof ParameterizedType) != null) {
                    str = j.e((Type) field);
                } else if ((field instanceof Class) != null) {
                    str = j.e((Type) field);
                }
            }
        } else {
            field = accessibleObject;
        }
        this.e = field;
        this.d = str;
        this.m = str.isEnum();
    }

    private char[] d() {
        int length = this.a.length();
        char[] cArr = new char[(length + 3)];
        this.a.getChars(0, this.a.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    private static Type a(Class<?> cls, Type type, Type type2) {
        if (cls != null) {
            if (type != null) {
                Type genericComponentType;
                if (type2 instanceof GenericArrayType) {
                    genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                    Type a = a(cls, type, genericComponentType);
                    return genericComponentType != a ? Array.newInstance(j.e(a), 0).getClass() : type2;
                } else if (!j.a(type)) {
                    return type2;
                } else {
                    int i;
                    if (type2 instanceof TypeVariable) {
                        genericComponentType = (ParameterizedType) j.b(type);
                        TypeVariable typeVariable = (TypeVariable) type2;
                        TypeVariable[] typeParameters = j.e(genericComponentType).getTypeParameters();
                        for (i = 0; i < typeParameters.length; i++) {
                            if (typeParameters[i].getName().equals(typeVariable.getName())) {
                                return genericComponentType.getActualTypeArguments()[i];
                            }
                        }
                    }
                    if (type2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type2;
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        i = 0;
                        TypeVariable[] typeVariableArr = null;
                        TypeVariable[] typeVariableArr2 = typeVariableArr;
                        for (int i2 = i; i2 < actualTypeArguments.length; i2++) {
                            Type type3 = actualTypeArguments[i2];
                            if (type3 instanceof TypeVariable) {
                                TypeVariable typeVariable2 = (TypeVariable) type3;
                                if (type instanceof ParameterizedType) {
                                    if (typeVariableArr == null) {
                                        typeVariableArr = cls.getTypeParameters();
                                    }
                                    Type[] typeArr = typeVariableArr2;
                                    int i3 = i;
                                    for (i = 0; i < typeVariableArr.length; i++) {
                                        if (typeVariableArr[i].getName().equals(typeVariable2.getName())) {
                                            if (typeArr == null) {
                                                typeArr = ((ParameterizedType) type).getActualTypeArguments();
                                            }
                                            actualTypeArguments[i2] = typeArr[i];
                                            i3 = 1;
                                        }
                                    }
                                    i = i3;
                                    typeVariableArr2 = typeArr;
                                }
                            }
                        }
                        if (i != 0) {
                            return new h(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                        }
                    }
                    return type2;
                }
            }
        }
        return type2;
    }

    private static Type a(Class<?> cls, TypeVariable<?> typeVariable) {
        ParameterizedType parameterizedType;
        Type genericDeclaration = typeVariable.getGenericDeclaration();
        while (true) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass == null) {
                return null;
            }
            if (genericSuperclass instanceof ParameterizedType) {
                parameterizedType = (ParameterizedType) genericSuperclass;
                if (parameterizedType.getRawType() == genericDeclaration) {
                    break;
                }
            }
            Class<?> e = j.e(genericSuperclass);
            if (genericSuperclass == null) {
                return null;
            }
            cls = e;
        }
        cls = genericDeclaration.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < cls.length; i++) {
            if (cls[i] == typeVariable) {
                return actualTypeArguments[i];
            }
        }
        return null;
    }

    public final String toString() {
        return this.a;
    }

    public final Member a() {
        if (this.b != null) {
            return this.b;
        }
        return this.c;
    }

    private Class<?> e() {
        if (this.b != null) {
            return this.b.getDeclaringClass();
        }
        return this.c != null ? this.c.getDeclaringClass() : null;
    }

    public final int a(d dVar) {
        if (this.n < dVar.n) {
            return -1;
        }
        if (this.n > dVar.n) {
            return 1;
        }
        int compareTo = this.a.compareTo(dVar.a);
        if (compareTo != 0) {
            return compareTo;
        }
        Class e = e();
        Class e2 = dVar.e();
        if (!(e == null || e2 == null || e == e2)) {
            if (e.isAssignableFrom(e2)) {
                return -1;
            }
            if (e2.isAssignableFrom(e)) {
                return 1;
            }
        }
        int i = 0;
        compareTo = (this.c == null || this.c.getType() != this.d) ? 0 : 1;
        if (dVar.c != null && dVar.c.getType() == dVar.d) {
            i = 1;
        }
        if (compareTo != 0 && i == 0) {
            return 1;
        }
        if (i != 0 && compareTo == 0) {
            return -1;
        }
        if (dVar.d.isPrimitive() && !this.d.isPrimitive()) {
            return 1;
        }
        if (this.d.isPrimitive() && !dVar.d.isPrimitive()) {
            return -1;
        }
        if (dVar.d.getName().startsWith("java.") && !this.d.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.d.getName().startsWith("java.") || dVar.d.getName().startsWith("java.")) {
            return this.d.getName().compareTo(dVar.d.getName());
        }
        return -1;
    }

    public final b b() {
        if (this.o != null) {
            return this.o;
        }
        return this.p;
    }

    public final String c() {
        b b = b();
        if (b == null) {
            return null;
        }
        String c = b.c();
        if (c.trim().length() == 0) {
            return null;
        }
        return c;
    }

    public final Object a(Object obj) throws IllegalAccessException, InvocationTargetException {
        if (this.b != null) {
            return this.b.invoke(obj, new Object[0]);
        }
        return this.c.get(obj);
    }
}
