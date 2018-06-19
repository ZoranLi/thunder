package okhttp3.internal.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: OptionalMethod */
final class d<T> {
    private final Class<?> a;
    private final String b;
    private final Class[] c;

    d(Class<?> cls, String str, Class... clsArr) {
        this.a = cls;
        this.b = str;
        this.c = clsArr;
    }

    public final boolean a(T t) {
        return a(t.getClass()) != null ? true : null;
    }

    private java.lang.Object c(T r3, java.lang.Object... r4) throws java.lang.reflect.InvocationTargetException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r3.getClass();
        r0 = r2.a(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r3 = r0.invoke(r3, r4);	 Catch:{ IllegalAccessException -> 0x0011 }
        return r3;
    L_0x0011:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.d.c(java.lang.Object, java.lang.Object[]):java.lang.Object");
    }

    public final Object a(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (T t2) {
            t2 = t2.getTargetException();
            if ((t2 instanceof RuntimeException) != null) {
                throw ((RuntimeException) t2);
            }
            objArr = new AssertionError("Unexpected exception");
            objArr.initCause(t2);
            throw objArr;
        }
    }

    private Object d(T t, Object... objArr) throws InvocationTargetException {
        Method a = a(t.getClass());
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder("Method ");
            stringBuilder.append(this.b);
            stringBuilder.append(" not supported for object ");
            stringBuilder.append(t);
            throw new AssertionError(stringBuilder.toString());
        }
        try {
            return a.invoke(t, objArr);
        } catch (T t2) {
            StringBuilder stringBuilder2 = new StringBuilder("Unexpectedly could not call: ");
            stringBuilder2.append(a);
            objArr = new AssertionError(stringBuilder2.toString());
            objArr.initCause(t2);
            throw objArr;
        }
    }

    public final Object b(T t, Object... objArr) {
        try {
            return d(t, objArr);
        } catch (T t2) {
            t2 = t2.getTargetException();
            if ((t2 instanceof RuntimeException) != null) {
                throw ((RuntimeException) t2);
            }
            objArr = new AssertionError("Unexpected exception");
            objArr.initCause(t2);
            throw objArr;
        }
    }

    private Method a(Class<?> cls) {
        if (this.b == null) {
            return null;
        }
        cls = a(cls, this.b, this.c);
        if (cls == null || this.a == null || this.a.isAssignableFrom(cls.getReturnType())) {
            return cls;
        }
        return null;
    }

    private static java.lang.reflect.Method a(java.lang.Class<?> r1, java.lang.String r2, java.lang.Class[] r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r1.getMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x000d }
        r2 = r1.getModifiers();	 Catch:{ NoSuchMethodException -> 0x000e }
        r2 = r2 & 1;
        if (r2 != 0) goto L_0x000e;
    L_0x000d:
        r1 = r0;
    L_0x000e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.d.a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }
}
