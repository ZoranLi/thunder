package okhttp3.internal.e;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* compiled from: JdkWithJettyBootPlatform */
final class c extends e {
    private final Method a;
    private final Method b;
    private final Method d;
    private final Class<?> e;
    private final Class<?> f;

    /* compiled from: JdkWithJettyBootPlatform */
    private static class a implements InvocationHandler {
        boolean a;
        String b;
        private final List<String> c;

        a(List<String> list) {
            this.c = list;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            obj = method.getName();
            Class returnType = method.getReturnType();
            if (objArr == null) {
                objArr = okhttp3.internal.c.b;
            }
            if (obj.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (obj.equals("unsupported") && Void.TYPE == returnType) {
                this.a = true;
                return null;
            } else if (obj.equals("protocols") && objArr.length == 0) {
                return this.c;
            } else {
                if ((obj.equals("selectProtocol") || obj.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    String str;
                    List list = (List) objArr[0];
                    method = list.size();
                    for (objArr = null; objArr < method; objArr++) {
                        if (this.c.contains(list.get(objArr))) {
                            str = (String) list.get(objArr);
                            this.b = str;
                            return str;
                        }
                    }
                    str = (String) this.c.get(0);
                    this.b = str;
                    return str;
                } else if ((!obj.equals("protocolSelected") && obj.equals("selected") == null) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.b = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    private c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.a = method;
        this.b = method2;
        this.d = method3;
        this.e = cls;
        this.f = cls2;
    }

    public final void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        str = e.a((List) list);
        try {
            str = Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.e, this.f}, new a(str));
            this.a.invoke(null, new Object[]{sSLSocket, str});
        } catch (SSLSocket sSLSocket2) {
            throw new AssertionError(sSLSocket2);
        }
    }

    public final void b(javax.net.ssl.SSLSocket r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.d;	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r1 = 0;	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r2 = 1;	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r3 = 0;	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r2[r3] = r5;	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r0.invoke(r1, r2);	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        return;
    L_0x000d:
        r5 = new java.lang.AssertionError;
        r5.<init>();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.c.b(javax.net.ssl.SSLSocket):void");
    }

    public final java.lang.String a(javax.net.ssl.SSLSocket r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.b;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r1 = 1;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r1 = new java.lang.Object[r1];	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r2 = 0;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r1[r2] = r4;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r4 = 0;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r0 = r0.invoke(r4, r1);	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r0 = java.lang.reflect.Proxy.getInvocationHandler(r0);	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r0 = (okhttp3.internal.e.c.a) r0;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r1 = r0.a;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        if (r1 != 0) goto L_0x0024;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
    L_0x0017:
        r1 = r0.b;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        if (r1 != 0) goto L_0x0024;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
    L_0x001b:
        r0 = okhttp3.internal.e.e.c;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r1 = 4;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r2 = "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?";	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        r0.a(r1, r2, r4);	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        return r4;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
    L_0x0024:
        r1 = r0.a;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        if (r1 == 0) goto L_0x0029;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
    L_0x0028:
        return r4;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
    L_0x0029:
        r4 = r0.b;	 Catch:{ InvocationTargetException -> 0x002c, InvocationTargetException -> 0x002c }
        return r4;
    L_0x002c:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.c.a(javax.net.ssl.SSLSocket):java.lang.String");
    }

    public static okhttp3.internal.e.e a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "org.eclipse.jetty.alpn.ALPN";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r1 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = "$Provider";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2.append(r3);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.<init>();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.append(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4 = "$ClientProvider";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.append(r4);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r8 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.<init>();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.append(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r0 = "$ServerProvider";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.append(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r0 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r9 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r0 = "put";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = 2;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4 = javax.net.ssl.SSLSocket.class;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r5 = 0;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3[r5] = r4;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4 = 1;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3[r4] = r2;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r0 = r1.getMethod(r0, r3);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2 = "get";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r6 = javax.net.ssl.SSLSocket.class;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r6 = r1.getMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2 = "remove";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4 = javax.net.ssl.SSLSocket.class;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3[r5] = r4;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r7 = r1.getMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r1 = new okhttp3.internal.e.c;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4 = r1;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r5 = r0;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4.<init>(r5, r6, r7, r8, r9);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        return r1;
    L_0x0076:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.c.a():okhttp3.internal.e.e");
    }
}
