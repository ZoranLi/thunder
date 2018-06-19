package okhttp3;

import okio.ByteString;

/* compiled from: CertificatePinner */
final class h$b {
    final String a;
    final String b;
    final String c;
    final ByteString d;

    public final boolean equals(Object obj) {
        if (obj instanceof h$b) {
            h$b okhttp3_h_b = (h$b) obj;
            if (this.a.equals(okhttp3_h_b.a) && this.c.equals(okhttp3_h_b.c) && this.d.equals(okhttp3_h_b.d) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        return (31 * (((527 + this.a.hashCode()) * 31) + this.c.hashCode())) + this.d.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(this.d.base64());
        return stringBuilder.toString();
    }
}
