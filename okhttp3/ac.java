package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.a.f;
import okhttp3.internal.c;
import okhttp3.internal.e.e;
import okhttp3.internal.g.b;
import okhttp3.internal.g.d;

/* compiled from: OkHttpClient */
public class ac implements Cloneable {
    static final List<Protocol> a = c.a(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
    static final List<n> b = c.a(new n[]{n.a, n.c});
    public final int A;
    public final int B;
    final int C;
    final r c;
    @Nullable
    public final Proxy d;
    public final List<Protocol> e;
    public final List<n> f;
    final List<z> g;
    final List<z> h;
    final okhttp3.u.a i;
    public final ProxySelector j;
    public final p k;
    @Nullable
    final d l;
    @Nullable
    final f m;
    public final SocketFactory n;
    @Nullable
    public final SSLSocketFactory o;
    @Nullable
    final b p;
    public final HostnameVerifier q;
    public final h r;
    public final b s;
    public final b t;
    public final l u;
    public final s v;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final int z;

    /* compiled from: OkHttpClient */
    public static final class a {
        int A = 0;
        r a = new r();
        @Nullable
        public Proxy b;
        List<Protocol> c = ac.a;
        List<n> d = ac.b;
        final List<z> e = new ArrayList();
        public final List<z> f = new ArrayList();
        okhttp3.u.a g = u.a(u.a);
        ProxySelector h = ProxySelector.getDefault();
        p i = p.a;
        @Nullable
        d j;
        @Nullable
        f k;
        SocketFactory l = SocketFactory.getDefault();
        @Nullable
        SSLSocketFactory m;
        @Nullable
        b n;
        HostnameVerifier o = d.a;
        h p = h.a;
        public b q = b.b;
        b r = b.b;
        l s = new l();
        public s t = s.c;
        boolean u = true;
        boolean v = true;
        boolean w = true;
        int x = 10000;
        int y = 10000;
        int z = 10000;

        public final a a(long j, TimeUnit timeUnit) {
            this.x = a(com.alipay.sdk.data.a.f, j, timeUnit);
            return this;
        }

        public final a b(long j, TimeUnit timeUnit) {
            this.y = a(com.alipay.sdk.data.a.f, j, timeUnit);
            return this;
        }

        public final a c(long j, TimeUnit timeUnit) {
            this.z = a(com.alipay.sdk.data.a.f, j, timeUnit);
            return this;
        }

        private static int a(String str, long j, TimeUnit timeUnit) {
            StringBuilder stringBuilder;
            if (j < 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" < 0");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(j);
                if (toMillis > 2147483647L) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(" too large.");
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (toMillis != 0 || j <= 0) {
                    return (int) toMillis;
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(" too small.");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }

        public final ac a() {
            return new ac(this);
        }
    }

    static {
        okhttp3.internal.a.a = new ad();
    }

    public ac() {
        this(new a());
    }

    ac(a aVar) {
        h hVar;
        b bVar;
        this.c = aVar.a;
        this.d = aVar.b;
        this.e = aVar.c;
        this.f = aVar.d;
        this.g = c.a(aVar.e);
        this.h = c.a(aVar.f);
        this.i = aVar.g;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        loop0:
        while (true) {
            Object obj = null;
            for (n nVar : this.f) {
                if (obj != null || nVar.d) {
                    obj = 1;
                }
            }
            break loop0;
        }
        if (aVar.m == null) {
            if (obj != null) {
                X509TrustManager a = a();
                this.o = a(a);
                this.p = e.b().a(a);
                this.q = aVar.o;
                hVar = aVar.p;
                bVar = this.p;
                if (c.a(hVar.c, bVar)) {
                    hVar = new h(hVar.b, bVar);
                }
                this.r = hVar;
                this.s = aVar.q;
                this.t = aVar.r;
                this.u = aVar.s;
                this.v = aVar.t;
                this.w = aVar.u;
                this.x = aVar.v;
                this.y = aVar.w;
                this.z = aVar.x;
                this.A = aVar.y;
                this.B = aVar.z;
                this.C = aVar.A;
            }
        }
        this.o = aVar.m;
        this.p = aVar.n;
        this.q = aVar.o;
        hVar = aVar.p;
        bVar = this.p;
        if (c.a(hVar.c, bVar)) {
            hVar = new h(hVar.b, bVar);
        }
        this.r = hVar;
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
    }

    private static javax.net.ssl.X509TrustManager a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm();	 Catch:{ GeneralSecurityException -> 0x0039 }
        r0 = javax.net.ssl.TrustManagerFactory.getInstance(r0);	 Catch:{ GeneralSecurityException -> 0x0039 }
        r1 = 0;	 Catch:{ GeneralSecurityException -> 0x0039 }
        r0.init(r1);	 Catch:{ GeneralSecurityException -> 0x0039 }
        r0 = r0.getTrustManagers();	 Catch:{ GeneralSecurityException -> 0x0039 }
        r1 = r0.length;	 Catch:{ GeneralSecurityException -> 0x0039 }
        r2 = 1;	 Catch:{ GeneralSecurityException -> 0x0039 }
        if (r1 != r2) goto L_0x0021;	 Catch:{ GeneralSecurityException -> 0x0039 }
    L_0x0014:
        r1 = 0;	 Catch:{ GeneralSecurityException -> 0x0039 }
        r2 = r0[r1];	 Catch:{ GeneralSecurityException -> 0x0039 }
        r2 = r2 instanceof javax.net.ssl.X509TrustManager;	 Catch:{ GeneralSecurityException -> 0x0039 }
        if (r2 != 0) goto L_0x001c;	 Catch:{ GeneralSecurityException -> 0x0039 }
    L_0x001b:
        goto L_0x0021;	 Catch:{ GeneralSecurityException -> 0x0039 }
    L_0x001c:
        r0 = r0[r1];	 Catch:{ GeneralSecurityException -> 0x0039 }
        r0 = (javax.net.ssl.X509TrustManager) r0;	 Catch:{ GeneralSecurityException -> 0x0039 }
        return r0;	 Catch:{ GeneralSecurityException -> 0x0039 }
    L_0x0021:
        r1 = new java.lang.IllegalStateException;	 Catch:{ GeneralSecurityException -> 0x0039 }
        r2 = new java.lang.StringBuilder;	 Catch:{ GeneralSecurityException -> 0x0039 }
        r3 = "Unexpected default trust managers:";	 Catch:{ GeneralSecurityException -> 0x0039 }
        r2.<init>(r3);	 Catch:{ GeneralSecurityException -> 0x0039 }
        r0 = java.util.Arrays.toString(r0);	 Catch:{ GeneralSecurityException -> 0x0039 }
        r2.append(r0);	 Catch:{ GeneralSecurityException -> 0x0039 }
        r0 = r2.toString();	 Catch:{ GeneralSecurityException -> 0x0039 }
        r1.<init>(r0);	 Catch:{ GeneralSecurityException -> 0x0039 }
        throw r1;	 Catch:{ GeneralSecurityException -> 0x0039 }
    L_0x0039:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.ac.a():javax.net.ssl.X509TrustManager");
    }

    private static javax.net.ssl.SSLSocketFactory a(javax.net.ssl.X509TrustManager r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "TLS";	 Catch:{ GeneralSecurityException -> 0x0015 }
        r0 = javax.net.ssl.SSLContext.getInstance(r0);	 Catch:{ GeneralSecurityException -> 0x0015 }
        r1 = 1;	 Catch:{ GeneralSecurityException -> 0x0015 }
        r1 = new javax.net.ssl.TrustManager[r1];	 Catch:{ GeneralSecurityException -> 0x0015 }
        r2 = 0;	 Catch:{ GeneralSecurityException -> 0x0015 }
        r1[r2] = r3;	 Catch:{ GeneralSecurityException -> 0x0015 }
        r3 = 0;	 Catch:{ GeneralSecurityException -> 0x0015 }
        r0.init(r3, r1, r3);	 Catch:{ GeneralSecurityException -> 0x0015 }
        r3 = r0.getSocketFactory();	 Catch:{ GeneralSecurityException -> 0x0015 }
        return r3;
    L_0x0015:
        r3 = new java.lang.AssertionError;
        r3.<init>();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.ac.a(javax.net.ssl.X509TrustManager):javax.net.ssl.SSLSocketFactory");
    }

    public final f a(af afVar) {
        return new ae(this, afVar, false);
    }
}
