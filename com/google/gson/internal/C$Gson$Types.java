package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class C$Gson$Types {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    /* compiled from: $Gson$Types */
    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = C$Gson$Types.canonicalize(type);
        }

        public final Type getGenericComponentType() {
            return this.componentType;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof GenericArrayType) || C$Gson$Types.equals(this, (GenericArrayType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return this.componentType.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C$Gson$Types.typeToString(this.componentType));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: $Gson$Types */
    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            int i = 0;
            if (type2 instanceof Class) {
                int i2;
                Class cls = (Class) type2;
                boolean z = true;
                if (!Modifier.isStatic(cls.getModifiers())) {
                    if (cls.getEnclosingClass() != null) {
                        i2 = 0;
                        if (type == null) {
                            if (i2 != 0) {
                                z = false;
                            }
                        }
                        C$Gson$Preconditions.checkArgument(z);
                    }
                }
                i2 = true;
                if (type == null) {
                    if (i2 != 0) {
                        z = false;
                    }
                }
                C$Gson$Preconditions.checkArgument(z);
            }
            if (type == null) {
                type = null;
            } else {
                type = C$Gson$Types.canonicalize(type);
            }
            this.ownerType = type;
            this.rawType = C$Gson$Types.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            type = this.typeArguments.length;
            while (i < type) {
                C$Gson$Preconditions.checkNotNull(this.typeArguments[i]);
                C$Gson$Types.checkNotPrimitive(this.typeArguments[i]);
                this.typeArguments[i] = C$Gson$Types.canonicalize(this.typeArguments[i]);
                i++;
            }
        }

        public final Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public final Type getRawType() {
            return this.rawType;
        }

        public final Type getOwnerType() {
            return this.ownerType;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof ParameterizedType) || C$Gson$Types.equals(this, (ParameterizedType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ C$Gson$Types.hashCodeOrZero(this.ownerType);
        }

        public final String toString() {
            int length = this.typeArguments.length;
            if (length == 0) {
                return C$Gson$Types.typeToString(this.rawType);
            }
            StringBuilder stringBuilder = new StringBuilder(30 * (length + 1));
            stringBuilder.append(C$Gson$Types.typeToString(this.rawType));
            stringBuilder.append("<");
            stringBuilder.append(C$Gson$Types.typeToString(this.typeArguments[0]));
            for (int i = 1; i < length; i++) {
                stringBuilder.append(", ");
                stringBuilder.append(C$Gson$Types.typeToString(this.typeArguments[i]));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    /* compiled from: $Gson$Types */
    private static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            C$Gson$Preconditions.checkArgument(typeArr2.length <= 1);
            C$Gson$Preconditions.checkArgument(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.checkNotNull(typeArr2[0]);
                C$Gson$Types.checkNotPrimitive(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    z = false;
                }
                C$Gson$Preconditions.checkArgument(z);
                this.lowerBound = C$Gson$Types.canonicalize(typeArr2[0]);
                this.upperBound = Object.class;
                return;
            }
            C$Gson$Preconditions.checkNotNull(typeArr[0]);
            C$Gson$Types.checkNotPrimitive(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = C$Gson$Types.canonicalize(typeArr[0]);
        }

        public final Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public final Type[] getLowerBounds() {
            if (this.lowerBound == null) {
                return C$Gson$Types.EMPTY_TYPE_ARRAY;
            }
            return new Type[]{this.lowerBound};
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof WildcardType) || C$Gson$Types.equals(this, (WildcardType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return (this.lowerBound != null ? this.lowerBound.hashCode() + 31 : 1) ^ (31 + this.upperBound.hashCode());
        }

        public final String toString() {
            StringBuilder stringBuilder;
            if (this.lowerBound != null) {
                stringBuilder = new StringBuilder("? super ");
                stringBuilder.append(C$Gson$Types.typeToString(this.lowerBound));
                return stringBuilder.toString();
            } else if (this.upperBound == Object.class) {
                return "?";
            } else {
                stringBuilder = new StringBuilder("? extends ");
                stringBuilder.append(C$Gson$Types.typeToString(this.upperBound));
                return stringBuilder.toString();
            }
        }
    }

    private C$Gson$Types() {
        throw new UnsupportedOperationException();
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        return new ParameterizedTypeImpl(type, type2, typeArr);
    }

    public static GenericArrayType arrayOf(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    public static WildcardType subtypeOf(Type type) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds();
        } else {
            type = new Type[]{type};
        }
        return new WildcardTypeImpl(type, EMPTY_TYPE_ARRAY);
    }

    public static WildcardType supertypeOf(Type type) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getLowerBounds();
        } else {
            type = new Type[]{type};
        }
        return new WildcardTypeImpl(new Type[]{Object.class}, type);
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            type = (Class) type;
            if (type.isArray()) {
                type = new GenericArrayTypeImpl(C$Gson$Types.canonicalize(type.getComponentType()));
            }
            return type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Class<?> getRawType(Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
                C$Gson$Preconditions.checkArgument(type instanceof Class);
                return (Class) type;
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(C$Gson$Types.getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            } else {
                if (type instanceof TypeVariable) {
                    return Object.class;
                }
                if (type instanceof WildcardType) {
                    type = ((WildcardType) type).getUpperBounds()[0];
                } else {
                    String str;
                    if (type == null) {
                        str = "null";
                    } else {
                        str = type.getClass().getName();
                    }
                    StringBuilder stringBuilder = new StringBuilder("Expected a Class, ParameterizedType, or GenericArrayType, but <");
                    stringBuilder.append(type);
                    stringBuilder.append("> is of type ");
                    stringBuilder.append(str);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        return (Class) type;
    }

    static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean equals(Type type, Type type2) {
        while (type != type2) {
            if (type instanceof Class) {
                return type.equals(type2);
            }
            if (type instanceof ParameterizedType) {
                if (!(type2 instanceof ParameterizedType)) {
                    return false;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                if (C$Gson$Types.equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments()) != null) {
                    return true;
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                if (!(type2 instanceof GenericArrayType)) {
                    return false;
                }
                GenericArrayType genericArrayType = (GenericArrayType) type2;
                type = ((GenericArrayType) type).getGenericComponentType();
                type2 = genericArrayType.getGenericComponentType();
            } else if (type instanceof WildcardType) {
                if (!(type2 instanceof WildcardType)) {
                    return false;
                }
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()) == null) {
                    return false;
                }
                return true;
            } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) type;
                TypeVariable typeVariable2 = (TypeVariable) type2;
                if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || typeVariable.getName().equals(typeVariable2.getName()) == null) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    static int hashCodeOrZero(Object obj) {
        return obj != null ? obj.hashCode() : null;
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        while (cls2 != cls) {
            if (cls2.isInterface() != null) {
                type = cls.getInterfaces();
                int length = type.length;
                for (int i = 0; i < length; i++) {
                    if (type[i] == cls2) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(type[i])) {
                        cls = cls.getGenericInterfaces()[i];
                        type = type[i];
                        break;
                    }
                }
            }
            if (cls.isInterface() == null) {
                while (cls != Object.class) {
                    Class<?> superclass = cls.getSuperclass();
                    if (superclass == cls2) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        cls = cls.getGenericSuperclass();
                        Class<?> cls3 = cls;
                        Type type2 = type;
                        Object obj = cls3;
                    } else {
                        cls = superclass;
                    }
                }
            }
            return cls2;
        }
        return type;
    }

    static Type getSupertype(Type type, Class<?> cls, Class<?> cls2) {
        C$Gson$Preconditions.checkArgument(cls2.isAssignableFrom(cls));
        return C$Gson$Types.resolve(type, cls, C$Gson$Types.getGenericSupertype(type, cls, cls2));
    }

    public static Type getArrayComponentType(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type getCollectionElementType(Type type, Class<?> cls) {
        type = C$Gson$Types.getSupertype(type, cls, Collection.class);
        if ((type instanceof WildcardType) != null) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        if ((type instanceof ParameterizedType) != null) {
            return ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        type = C$Gson$Types.getSupertype(type, cls, Map.class);
        if ((type instanceof ParameterizedType) != null) {
            return ((ParameterizedType) type).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        return C$Gson$Types.resolve(type, cls, type2, new HashSet());
    }

    private static Type resolve(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        while (type2 instanceof TypeVariable) {
            Type type3 = (TypeVariable) type2;
            if (collection.contains(type3)) {
                return type2;
            }
            collection.add(type3);
            type2 = C$Gson$Types.resolveTypeVariable(type, cls, type3);
            if (type2 == type3) {
                return type2;
            }
        }
        if (type2 instanceof Class) {
            Class cls2 = (Class) type2;
            if (cls2.isArray()) {
                type2 = cls2.getComponentType();
                type = C$Gson$Types.resolve(type, cls, type2, collection);
                if (type2 == type) {
                    return cls2;
                }
                return C$Gson$Types.arrayOf(type);
            }
        }
        if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            type3 = genericArrayType.getGenericComponentType();
            type = C$Gson$Types.resolve(type, cls, type3, collection);
            if (type3 == type) {
                return genericArrayType;
            }
            return C$Gson$Types.arrayOf(type);
        }
        int i = 0;
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            type3 = parameterizedType.getOwnerType();
            Type resolve = C$Gson$Types.resolve(type, cls, type3, collection);
            int i2 = resolve != type3 ? 1 : 0;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i < length) {
                Type resolve2 = C$Gson$Types.resolve(type, cls, actualTypeArguments[i], collection);
                if (resolve2 != actualTypeArguments[i]) {
                    if (i2 == 0) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        i2 = 1;
                    }
                    actualTypeArguments[i] = resolve2;
                }
                i++;
            }
            return i2 != 0 ? C$Gson$Types.newParameterizedTypeWithOwner(resolve, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        } else if (!(type2 instanceof WildcardType)) {
            return type2;
        } else {
            WildcardType wildcardType = (WildcardType) type2;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                type = C$Gson$Types.resolve(type, cls, lowerBounds[0], collection);
                if (type != lowerBounds[0]) {
                    return C$Gson$Types.supertypeOf(type);
                }
            } else if (upperBounds.length == 1) {
                type = C$Gson$Types.resolve(type, cls, upperBounds[0], collection);
                if (type != upperBounds[0]) {
                    return C$Gson$Types.subtypeOf(type);
                }
            }
            return wildcardType;
        }
    }

    static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class declaringClassOf = C$Gson$Types.declaringClassOf(typeVariable);
        if (declaringClassOf == null) {
            return typeVariable;
        }
        type = C$Gson$Types.getGenericSupertype(type, cls, declaringClassOf);
        if ((type instanceof ParameterizedType) == null) {
            return typeVariable;
        }
        return ((ParameterizedType) type).getActualTypeArguments()[C$Gson$Types.indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
    }

    private static int indexOf(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        typeVariable = typeVariable.getGenericDeclaration();
        return typeVariable instanceof Class ? (Class) typeVariable : null;
    }

    static void checkNotPrimitive(Type type) {
        if (type instanceof Class) {
            if (((Class) type).isPrimitive() != null) {
                type = null;
                C$Gson$Preconditions.checkArgument(type);
            }
        }
        type = true;
        C$Gson$Preconditions.checkArgument(type);
    }
}
