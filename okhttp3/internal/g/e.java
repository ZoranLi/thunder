package okhttp3.internal.g;

import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* compiled from: TrustRootIndex */
public abstract class e {

    /* compiled from: TrustRootIndex */
    static final class a extends e {
        private final X509TrustManager a;
        private final Method b;

        a(X509TrustManager x509TrustManager, Method method) {
            this.b = method;
            this.a = x509TrustManager;
        }

        public final java.security.cert.X509Certificate a(java.security.cert.X509Certificate r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = 0;
            r1 = r5.b;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r2 = r5.a;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r3 = 1;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r3 = new java.lang.Object[r3];	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r4 = 0;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r3[r4] = r6;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r6 = r1.invoke(r2, r3);	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r6 = (java.security.cert.TrustAnchor) r6;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            if (r6 == 0) goto L_0x0018;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
        L_0x0013:
            r6 = r6.getTrustedCert();	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            return r6;
        L_0x0018:
            return r0;
        L_0x0019:
            return r0;
        L_0x001a:
            r6 = new java.lang.AssertionError;
            r6.<init>();
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.g.e.a.a(java.security.cert.X509Certificate):java.security.cert.X509Certificate");
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a.equals(aVar.a) && this.b.equals(aVar.b) != null;
        }

        public final int hashCode() {
            return this.a.hashCode() + (31 * this.b.hashCode());
        }
    }

    /* compiled from: TrustRootIndex */
    static final class b extends e {
        private final Map<X500Principal, Set<X509Certificate>> a = new LinkedHashMap();

        b(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                Set set = (Set) this.a.get(subjectX500Principal);
                if (set == null) {
                    set = new LinkedHashSet(1);
                    this.a.put(subjectX500Principal, set);
                }
                set.add(x509Certificate);
            }
        }

        public final java.security.cert.X509Certificate a(java.security.cert.X509Certificate r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r5.getIssuerX500Principal();
            r1 = r4.a;
            r0 = r1.get(r0);
            r0 = (java.util.Set) r0;
            r1 = 0;
            if (r0 != 0) goto L_0x0010;
        L_0x000f:
            return r1;
        L_0x0010:
            r0 = r0.iterator();
        L_0x0014:
            r2 = r0.hasNext();
            if (r2 == 0) goto L_0x0028;
        L_0x001a:
            r2 = r0.next();
            r2 = (java.security.cert.X509Certificate) r2;
            r3 = r2.getPublicKey();
            r5.verify(r3);	 Catch:{ Exception -> 0x0014 }
            return r2;
        L_0x0028:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.g.e.b.a(java.security.cert.X509Certificate):java.security.cert.X509Certificate");
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b) || ((b) obj).a.equals(this.a) == null) {
                return null;
            }
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }
    }

    public abstract X509Certificate a(X509Certificate x509Certificate);

    public static okhttp3.internal.g.e a(javax.net.ssl.X509TrustManager r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r6.getClass();	 Catch:{ NoSuchMethodException -> 0x001b }
        r1 = "findTrustAnchorByIssuerAndSignature";	 Catch:{ NoSuchMethodException -> 0x001b }
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x001b }
        r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001b }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x001b }
        r5 = java.security.cert.X509Certificate.class;	 Catch:{ NoSuchMethodException -> 0x001b }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x001b }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x001b }
        r0.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x001b }
        r1 = new okhttp3.internal.g.e$a;	 Catch:{ NoSuchMethodException -> 0x001b }
        r1.<init>(r6, r0);	 Catch:{ NoSuchMethodException -> 0x001b }
        return r1;
    L_0x001b:
        r6 = r6.getAcceptedIssuers();
        r0 = new okhttp3.internal.g.e$b;
        r0.<init>(r6);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.g.e.a(javax.net.ssl.X509TrustManager):okhttp3.internal.g.e");
    }
}
