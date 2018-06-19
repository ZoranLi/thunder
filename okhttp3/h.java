package okhttp3;

import com.xiaomi.mipush.sdk.Constants;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.c;
import okhttp3.internal.g.b;
import okio.ByteString;

/* compiled from: CertificatePinner */
public final class h {
    public static final h a = new h(new LinkedHashSet(new a().a), null);
    final Set<b> b;
    @Nullable
    final b c;

    h(Set<b> set, @Nullable b bVar) {
        this.b = set;
        this.c = bVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (c.a(this.c, hVar.c) && this.b.equals(hVar.b) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        return (31 * (this.c != null ? this.c.hashCode() : 0)) + this.b.hashCode();
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder stringBuilder = new StringBuilder("sha256/");
            stringBuilder.append(a((X509Certificate) certificate).base64());
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    private static ByteString a(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public final void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List emptyList = Collections.emptyList();
        for (b bVar : this.b) {
            boolean regionMatches;
            if (bVar.a.startsWith("*.")) {
                regionMatches = str.regionMatches(false, str.indexOf(46) + 1, bVar.b, 0, bVar.b.length());
            } else {
                regionMatches = str.equals(bVar.b);
            }
            if (regionMatches) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(bVar);
            }
        }
        if (!emptyList.isEmpty()) {
            int i;
            if (this.c != null) {
                list = this.c.a(list, str);
            }
            int size = list.size();
            int i2 = 0;
            for (i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = emptyList.size();
                Object obj = null;
                Object obj2 = obj;
                for (int i3 = 0; i3 < size2; i3++) {
                    b bVar2 = (b) emptyList.get(i3);
                    if (bVar2.c.equals("sha256/")) {
                        if (obj == null) {
                            obj = a(x509Certificate);
                        }
                        if (bVar2.d.equals(obj)) {
                            return;
                        }
                    } else if (bVar2.c.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
                        }
                        if (bVar2.d.equals(obj2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            i = list.size();
            for (int i4 = 0; i4 < i; i4++) {
                Certificate certificate = (X509Certificate) list.get(i4);
                stringBuilder.append("\n    ");
                stringBuilder.append(a(certificate));
                stringBuilder.append(": ");
                stringBuilder.append(certificate.getSubjectDN().getName());
            }
            stringBuilder.append("\n  Pinned certificates for ");
            stringBuilder.append(str);
            stringBuilder.append(Constants.COLON_SEPARATOR);
            str = emptyList.size();
            while (i2 < str) {
                b bVar3 = (b) emptyList.get(i2);
                stringBuilder.append("\n    ");
                stringBuilder.append(bVar3);
                i2++;
            }
            throw new SSLPeerUnverifiedException(stringBuilder.toString());
        }
    }
}
