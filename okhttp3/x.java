package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Handshake */
public final class x {
    public final i a;
    public final List<Certificate> b;
    private final TlsVersion c;
    private final List<Certificate> d;

    private x(TlsVersion tlsVersion, i iVar, List<Certificate> list, List<Certificate> list2) {
        this.c = tlsVersion;
        this.a = iVar;
        this.b = list;
        this.d = list2;
    }

    public static okhttp3.x a(javax.net.ssl.SSLSession r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.getCipherSuite();
        if (r0 != 0) goto L_0x000e;
    L_0x0006:
        r4 = new java.lang.IllegalStateException;
        r0 = "cipherSuite == null";
        r4.<init>(r0);
        throw r4;
    L_0x000e:
        r0 = okhttp3.i.a(r0);
        r1 = r4.getProtocol();
        if (r1 != 0) goto L_0x0020;
    L_0x0018:
        r4 = new java.lang.IllegalStateException;
        r0 = "tlsVersion == null";
        r4.<init>(r0);
        throw r4;
    L_0x0020:
        r1 = okhttp3.TlsVersion.forJavaName(r1);
        r2 = r4.getPeerCertificates();	 Catch:{ SSLPeerUnverifiedException -> 0x0029 }
        goto L_0x002a;
    L_0x0029:
        r2 = 0;
    L_0x002a:
        if (r2 == 0) goto L_0x0031;
    L_0x002c:
        r2 = okhttp3.internal.c.a(r2);
        goto L_0x0035;
    L_0x0031:
        r2 = java.util.Collections.emptyList();
    L_0x0035:
        r4 = r4.getLocalCertificates();
        if (r4 == 0) goto L_0x0040;
    L_0x003b:
        r4 = okhttp3.internal.c.a(r4);
        goto L_0x0044;
    L_0x0040:
        r4 = java.util.Collections.emptyList();
    L_0x0044:
        r3 = new okhttp3.x;
        r3.<init>(r1, r0, r2, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.x.a(javax.net.ssl.SSLSession):okhttp3.x");
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.c.equals(xVar.c) && this.a.equals(xVar.a) && this.b.equals(xVar.b) && this.d.equals(xVar.d) != null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (31 * (((((527 + this.c.hashCode()) * 31) + this.a.hashCode()) * 31) + this.b.hashCode())) + this.d.hashCode();
    }
}
