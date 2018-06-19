package okhttp3.internal.e;

import android.util.Log;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.baidu.android.common.security.RSAUtil;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.c;
import okio.e;

/* compiled from: AndroidPlatform */
final class a extends e {
    private final Class<?> a;
    private final d<Socket> b;
    private final d<Socket> d;
    private final d<Socket> e;
    private final d<Socket> f;
    private final b g = b.a();

    /* compiled from: AndroidPlatform */
    static final class b {
        private final Method a;
        private final Method b;
        private final Method c;

        private b(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }

        final java.lang.Object a(java.lang.String r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = r5.a;
            r1 = 0;
            if (r0 == 0) goto L_0x0019;
        L_0x0005:
            r0 = r5.a;	 Catch:{ Exception -> 0x0019 }
            r2 = 0;	 Catch:{ Exception -> 0x0019 }
            r3 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0019 }
            r0 = r0.invoke(r1, r3);	 Catch:{ Exception -> 0x0019 }
            r3 = r5.b;	 Catch:{ Exception -> 0x0019 }
            r4 = 1;	 Catch:{ Exception -> 0x0019 }
            r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0019 }
            r4[r2] = r6;	 Catch:{ Exception -> 0x0019 }
            r3.invoke(r0, r4);	 Catch:{ Exception -> 0x0019 }
            return r0;
        L_0x0019:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.a.b.a(java.lang.String):java.lang.Object");
        }

        final boolean a(java.lang.Object r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = 0;
            if (r4 == 0) goto L_0x000b;
        L_0x0003:
            r1 = r3.c;	 Catch:{ Exception -> 0x000b }
            r2 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x000b }
            r1.invoke(r4, r2);	 Catch:{ Exception -> 0x000b }
            r0 = 1;
        L_0x000b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.a.b.a(java.lang.Object):boolean");
        }

        static okhttp3.internal.e.a.b a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = 0;
            r1 = "dalvik.system.CloseGuard";	 Catch:{ Exception -> 0x0027 }
            r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0027 }
            r2 = "get";	 Catch:{ Exception -> 0x0027 }
            r3 = 0;	 Catch:{ Exception -> 0x0027 }
            r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0027 }
            r2 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x0027 }
            r4 = "open";	 Catch:{ Exception -> 0x0027 }
            r5 = 1;	 Catch:{ Exception -> 0x0027 }
            r5 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x0027 }
            r6 = java.lang.String.class;	 Catch:{ Exception -> 0x0027 }
            r5[r3] = r6;	 Catch:{ Exception -> 0x0027 }
            r4 = r1.getMethod(r4, r5);	 Catch:{ Exception -> 0x0027 }
            r5 = "warnIfOpen";	 Catch:{ Exception -> 0x0027 }
            r3 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0027 }
            r1 = r1.getMethod(r5, r3);	 Catch:{ Exception -> 0x0027 }
            r0 = r2;
            goto L_0x0029;
        L_0x0027:
            r1 = r0;
            r4 = r1;
        L_0x0029:
            r2 = new okhttp3.internal.e.a$b;
            r2.<init>(r0, r4, r1);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.a.b.a():okhttp3.internal.e.a$b");
        }
    }

    /* compiled from: AndroidPlatform */
    static final class a extends okhttp3.internal.g.b {
        private final Object a;
        private final Method b;

        public final int hashCode() {
            return 0;
        }

        a(Object obj, Method method) {
            this.a = obj;
            this.b = method;
        }

        public final List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.b.invoke(this.a, new Object[]{x509CertificateArr, RSAUtil.ALGORITHM_RSA, str});
            } catch (List<Certificate> list2) {
                str = new SSLPeerUnverifiedException(list2.getMessage());
                str.initCause(list2);
                throw str;
            } catch (List<Certificate> list22) {
                throw new AssertionError(list22);
            }
        }

        public final boolean equals(Object obj) {
            return obj instanceof a;
        }
    }

    private a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.a = cls;
        this.b = dVar;
        this.d = dVar2;
        this.e = dVar3;
        this.f = dVar4;
    }

    public final void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (c.a(e) != null) {
                throw new IOException(e);
            }
            throw e;
        } catch (Socket socket2) {
            inetSocketAddress = new IOException("Exception in connect");
            inetSocketAddress.initCause(socket2);
            throw inetSocketAddress;
        }
    }

    public final void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.b.a(sSLSocket, Boolean.valueOf(true));
            this.d.a(sSLSocket, str);
        }
        if (this.f != null && this.f.a((Object) sSLSocket) != null) {
            str = new Object[1];
            e eVar = new e();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = (Protocol) list.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    eVar.b(protocol.toString().length());
                    eVar.a(protocol.toString());
                }
            }
            str[0] = eVar.m();
            this.f.b(sSLSocket, str);
        }
    }

    public final String a(SSLSocket sSLSocket) {
        if (this.e == null || !this.e.a((Object) sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.e.b(sSLSocket, new Object[0]);
        if (bArr != null) {
            return new String(bArr, c.e);
        }
        return null;
    }

    public final void a(int i, String str, Throwable th) {
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append('\n');
            stringBuilder.append(Log.getStackTraceString(th));
            str = stringBuilder.toString();
        }
        th = null;
        int length = str.length();
        while (th < length) {
            int min;
            int indexOf = str.indexOf(10, th);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, th + CONFIGID.RECORD_BIT);
                Log.println(i2, "OkHttp", str.substring(th, min));
                if (min >= indexOf) {
                    break;
                }
                th = min;
            }
            th = min + 1;
        }
    }

    public final Object a(String str) {
        return this.g.a(str);
    }

    public final void a(String str, Object obj) {
        if (this.g.a(obj) == null) {
            a(5, str, null);
        }
    }

    public final boolean b(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = "android.security.NetworkSecurityPolicy";	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r1 = "getInstance";	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r2 = 0;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r3 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r1 = r0.getMethod(r1, r3);	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r3 = 0;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r4 = new java.lang.Object[r2];	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r1 = r1.invoke(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r3 = "isCleartextTrafficPermitted";	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r4 = 1;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r5 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r6 = java.lang.String.class;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r5[r2] = r6;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r0 = r0.getMethod(r3, r5);	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r3 = new java.lang.Object[r4];	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r3[r2] = r8;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r0 = r0.invoke(r1, r3);	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        r0 = r0.booleanValue();	 Catch:{ ClassNotFoundException -> 0x0038, ClassNotFoundException -> 0x0038, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032, IllegalAccessException -> 0x0032 }
        return r0;
    L_0x0032:
        r8 = new java.lang.AssertionError;
        r8.<init>();
        throw r8;
    L_0x0038:
        r8 = super.b(r8);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.a.b(java.lang.String):boolean");
    }

    public final okhttp3.internal.g.b a(javax.net.ssl.X509TrustManager r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = "android.net.http.X509TrustManagerExtensions";	 Catch:{ Exception -> 0x0036 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0036 }
        r1 = 1;	 Catch:{ Exception -> 0x0036 }
        r2 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0036 }
        r3 = javax.net.ssl.X509TrustManager.class;	 Catch:{ Exception -> 0x0036 }
        r4 = 0;	 Catch:{ Exception -> 0x0036 }
        r2[r4] = r3;	 Catch:{ Exception -> 0x0036 }
        r2 = r0.getConstructor(r2);	 Catch:{ Exception -> 0x0036 }
        r3 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0036 }
        r3[r4] = r8;	 Catch:{ Exception -> 0x0036 }
        r2 = r2.newInstance(r3);	 Catch:{ Exception -> 0x0036 }
        r3 = "checkServerTrusted";	 Catch:{ Exception -> 0x0036 }
        r5 = 3;	 Catch:{ Exception -> 0x0036 }
        r5 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x0036 }
        r6 = java.security.cert.X509Certificate[].class;	 Catch:{ Exception -> 0x0036 }
        r5[r4] = r6;	 Catch:{ Exception -> 0x0036 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0036 }
        r5[r1] = r4;	 Catch:{ Exception -> 0x0036 }
        r1 = 2;	 Catch:{ Exception -> 0x0036 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0036 }
        r5[r1] = r4;	 Catch:{ Exception -> 0x0036 }
        r0 = r0.getMethod(r3, r5);	 Catch:{ Exception -> 0x0036 }
        r1 = new okhttp3.internal.e.a$a;	 Catch:{ Exception -> 0x0036 }
        r1.<init>(r2, r0);	 Catch:{ Exception -> 0x0036 }
        return r1;
    L_0x0036:
        r8 = super.a(r8);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.a.a(javax.net.ssl.X509TrustManager):okhttp3.internal.g.b");
    }

    public static okhttp3.internal.e.e a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "com.android.org.conscrypt.SSLParametersImpl";	 Catch:{ ClassNotFoundException -> 0x0009 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0009 }
    L_0x0007:
        r3 = r1;
        goto L_0x0010;
    L_0x0009:
        r1 = "org.apache.harmony.xnet.provider.jsse.SSLParametersImpl";	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0055 }
        goto L_0x0007;	 Catch:{ ClassNotFoundException -> 0x0055 }
    L_0x0010:
        r4 = new okhttp3.internal.e.d;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = "setUseSessionTickets";	 Catch:{ ClassNotFoundException -> 0x0055 }
        r2 = 1;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r5 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0055 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r7 = 0;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r5[r7] = r6;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r4.<init>(r0, r1, r5);	 Catch:{ ClassNotFoundException -> 0x0055 }
        r5 = new okhttp3.internal.e.d;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = "setHostname";	 Catch:{ ClassNotFoundException -> 0x0055 }
        r6 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0055 }
        r8 = java.lang.String.class;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r6[r7] = r8;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r5.<init>(r0, r1, r6);	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = "android.net.Network";	 Catch:{ ClassNotFoundException -> 0x004b }
        java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x004b }
        r1 = new okhttp3.internal.e.d;	 Catch:{ ClassNotFoundException -> 0x004b }
        r6 = byte[].class;	 Catch:{ ClassNotFoundException -> 0x004b }
        r8 = "getAlpnSelectedProtocol";	 Catch:{ ClassNotFoundException -> 0x004b }
        r9 = new java.lang.Class[r7];	 Catch:{ ClassNotFoundException -> 0x004b }
        r1.<init>(r6, r8, r9);	 Catch:{ ClassNotFoundException -> 0x004b }
        r6 = new okhttp3.internal.e.d;	 Catch:{ ClassNotFoundException -> 0x004c }
        r8 = "setAlpnProtocols";	 Catch:{ ClassNotFoundException -> 0x004c }
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x004c }
        r9 = byte[].class;	 Catch:{ ClassNotFoundException -> 0x004c }
        r2[r7] = r9;	 Catch:{ ClassNotFoundException -> 0x004c }
        r6.<init>(r0, r8, r2);	 Catch:{ ClassNotFoundException -> 0x004c }
        r7 = r6;
        goto L_0x004d;
    L_0x004b:
        r1 = r0;
    L_0x004c:
        r7 = r0;
    L_0x004d:
        r6 = r1;
        r1 = new okhttp3.internal.e.a;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r2 = r1;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ ClassNotFoundException -> 0x0055 }
        return r1;
    L_0x0055:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.a.a():okhttp3.internal.e.e");
    }
}
