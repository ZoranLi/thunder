package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    protected TypeToken() {
        this.type = getSuperclassTypeParameter(getClass());
        this.rawType = C$Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    TypeToken(Type type) {
        this.type = C$Gson$Types.canonicalize((Type) C$Gson$Preconditions.checkNotNull(type));
        this.rawType = C$Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    static Type getSuperclassTypeParameter(Class<?> cls) {
        cls = cls.getGenericSuperclass();
        if (!(cls instanceof Class)) {
            return C$Gson$Types.canonicalize(((ParameterizedType) cls).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals(type)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(type));
        }
        if (this.type instanceof ParameterizedType) {
            return isAssignableFrom(type, (ParameterizedType) this.type, new HashMap());
        }
        if (this.type instanceof GenericArrayType) {
            return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(type)) && isAssignableFrom(type, (GenericArrayType) this.type) != null;
        } else {
            throw buildUnexpectedTypeError(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
        }
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    private static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType) {
        genericArrayType = genericArrayType.getGenericComponentType();
        if (!(genericArrayType instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            type = ((GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof Class) {
            type = (Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return isAssignableFrom(type, (ParameterizedType) genericArrayType, new HashMap());
    }

    private static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        while (true) {
            int i = 0;
            if (type == null) {
                return false;
            }
            if (parameterizedType.equals(type)) {
                return true;
            }
            Class rawType = C$Gson$Types.getRawType(type);
            ParameterizedType parameterizedType2 = null;
            if (type instanceof ParameterizedType) {
                parameterizedType2 = (ParameterizedType) type;
            }
            if (parameterizedType2 != null) {
                type = parameterizedType2.getActualTypeArguments();
                TypeVariable[] typeParameters = rawType.getTypeParameters();
                for (int i2 = 0; i2 < type.length; i2++) {
                    Object obj = type[i2];
                    TypeVariable typeVariable = typeParameters[i2];
                    while (obj instanceof TypeVariable) {
                        Type type2 = (Type) map.get(((TypeVariable) obj).getName());
                    }
                    map.put(typeVariable.getName(), obj);
                }
                if (typeEquals(parameterizedType2, parameterizedType, map) != null) {
                    return true;
                }
            }
            type = rawType.getGenericInterfaces();
            int length = type.length;
            while (i < length) {
                if (isAssignableFrom(type[i], parameterizedType, new HashMap(map))) {
                    return true;
                }
                i++;
            }
            type = rawType.getGenericSuperclass();
            Object hashMap = new HashMap(map);
        }
    }

    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        parameterizedType = parameterizedType.getActualTypeArguments();
        parameterizedType2 = parameterizedType2.getActualTypeArguments();
        for (int i = 0; i < parameterizedType.length; i++) {
            if (!matches(parameterizedType[i], parameterizedType2[i], map)) {
                return false;
            }
        }
        return true;
    }

    private static AssertionError buildUnexpectedTypeError(Type type, Class<?>... clsArr) {
        StringBuilder stringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class name : clsArr) {
            stringBuilder.append(name.getName());
            stringBuilder.append(", ");
        }
        stringBuilder.append("but got: ");
        stringBuilder.append(type.getClass().getName());
        stringBuilder.append(", for type token: ");
        stringBuilder.append(type.toString());
        stringBuilder.append('.');
        return new AssertionError(stringBuilder.toString());
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map) {
        if (!type2.equals(type)) {
            if (!(type instanceof TypeVariable) || type2.equals(map.get(((TypeVariable) type).getName())) == null) {
                return null;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof TypeToken) || C$Gson$Types.equals(this.type, ((TypeToken) obj).type) == null) ? null : true;
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken(type);
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken(cls);
    }

    public static TypeToken<?> getParameterized(Type type, Type... typeArr) {
        return new TypeToken(C$Gson$Types.newParameterizedTypeWithOwner(null, type, typeArr));
    }

    public static TypeToken<?> getArray(Type type) {
        return new TypeToken(C$Gson$Types.arrayOf(type));
    }
}
