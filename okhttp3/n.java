package okhttp3;

import com.umeng.message.proguard.k;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.c;

/* compiled from: ConnectionSpec */
public final class n {
    public static final n a;
    public static final n b = new a(a).a(TlsVersion.TLS_1_0).a().b();
    public static final n c = new a(false).b();
    private static final i[] h = new i[]{i.aX, i.bb, i.aY, i.bc, i.bi, i.bh, i.ay, i.aI, i.az, i.aJ, i.ag, i.ah, i.E, i.I, i.i};
    final boolean d;
    public final boolean e;
    @Nullable
    final String[] f;
    @Nullable
    final String[] g;

    /* compiled from: ConnectionSpec */
    public static final class a {
        boolean a;
        @Nullable
        String[] b;
        @Nullable
        String[] c;
        boolean d;

        a(boolean z) {
            this.a = z;
        }

        public a(n nVar) {
            this.a = nVar.d;
            this.b = nVar.f;
            this.c = nVar.g;
            this.d = nVar.e;
        }

        public final a a(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            } else {
                this.b = (String[]) strArr.clone();
                return this;
            }
        }

        public final a a(TlsVersion... tlsVersionArr) {
            if (this.a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                return b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public final a b(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            } else {
                this.c = (String[]) strArr.clone();
                return this;
            }
        }

        public final a a() {
            if (this.a) {
                this.d = true;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public final n b() {
            return new n(this);
        }
    }

    static {
        a aVar = new a(true);
        i[] iVarArr = h;
        if (aVar.a) {
            String[] strArr = new String[iVarArr.length];
            for (int i = 0; i < iVarArr.length; i++) {
                strArr[i] = iVarArr[i].bj;
            }
            a = aVar.a(strArr).a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).a().b();
            return;
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }

    n(a aVar) {
        this.d = aVar.a;
        this.f = aVar.b;
        this.g = aVar.c;
        this.e = aVar.d;
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (!this.d) {
            return false;
        }
        if (this.g != null && !c.b(c.g, this.g, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f == null || c.b(i.a, this.f, sSLSocket.getEnabledCipherSuites()) != null) {
            return true;
        }
        return false;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        n nVar = (n) obj;
        if (this.d != nVar.d) {
            return false;
        }
        return !this.d || (Arrays.equals(this.f, nVar.f) && Arrays.equals(this.g, nVar.g) && this.e == nVar.e);
    }

    public final int hashCode() {
        return this.d ? (31 * (((527 + Arrays.hashCode(this.f)) * 31) + Arrays.hashCode(this.g))) + (this.e ^ 1) : 17;
    }

    public final String toString() {
        if (!this.d) {
            return "ConnectionSpec()";
        }
        String obj;
        String obj2;
        Object obj3 = null;
        if (this.f != null) {
            obj = (this.f != null ? i.a(this.f) : null).toString();
        } else {
            obj = "[all enabled]";
        }
        if (this.g != null) {
            if (this.g != null) {
                obj3 = TlsVersion.forJavaNames(this.g);
            }
            obj2 = obj3.toString();
        } else {
            obj2 = "[all enabled]";
        }
        StringBuilder stringBuilder = new StringBuilder("ConnectionSpec(cipherSuites=");
        stringBuilder.append(obj);
        stringBuilder.append(", tlsVersions=");
        stringBuilder.append(obj2);
        stringBuilder.append(", supportsTlsExtensions=");
        stringBuilder.append(this.e);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
