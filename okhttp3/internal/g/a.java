package okhttp3.internal.g;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: BasicCertificateChainCleaner */
public final class a extends b {
    private final e a;

    public a(e eVar) {
        this.a = eVar;
    }

    public final List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        str = new ArrayDeque(list);
        list = new ArrayList();
        list.add(str.removeFirst());
        int i = 0;
        int i2 = 0;
        while (i < 9) {
            X509Certificate x509Certificate = (X509Certificate) list.get(list.size() - 1);
            X509Certificate a = this.a.a(x509Certificate);
            if (a != null) {
                if (list.size() > 1 || !x509Certificate.equals(a)) {
                    list.add(a);
                }
                if (a(a, a)) {
                    return list;
                }
                i2 = 1;
            } else {
                Iterator it = str.iterator();
                while (it.hasNext()) {
                    a = (X509Certificate) it.next();
                    if (a(x509Certificate, a)) {
                        it.remove();
                        list.add(a);
                    }
                }
                if (i2 != 0) {
                    return list;
                }
                str = new StringBuilder("Failed to find a trusted cert that signed ");
                str.append(x509Certificate);
                throw new SSLPeerUnverifiedException(str.toString());
            }
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder("Certificate chain too long: ");
        stringBuilder.append(list);
        throw new SSLPeerUnverifiedException(stringBuilder.toString());
    }

    private static boolean a(java.security.cert.X509Certificate r2, java.security.cert.X509Certificate r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getIssuerDN();
        r1 = r3.getSubjectDN();
        r0 = r0.equals(r1);
        r1 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r3 = r3.getPublicKey();	 Catch:{ GeneralSecurityException -> 0x0019 }
        r2.verify(r3);	 Catch:{ GeneralSecurityException -> 0x0019 }
        r2 = 1;
        return r2;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.g.a.a(java.security.cert.X509Certificate, java.security.cert.X509Certificate):boolean");
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a) || ((a) obj).a.equals(this.a) == null) {
            return null;
        }
        return true;
    }
}
