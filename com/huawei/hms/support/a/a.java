package com.huawei.hms.support.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: GenericTypeReflector */
public final class a {
    public static Class<?> a(Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                return (Class) ((ParameterizedType) type).getRawType();
            }
            if (type instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type;
                if (typeVariable.getBounds().length == 0) {
                    return Object.class;
                }
                type = typeVariable.getBounds()[0];
            } else {
                StringBuilder stringBuilder = new StringBuilder("not supported: ");
                stringBuilder.append(type.getClass());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (Class) type;
    }
}
