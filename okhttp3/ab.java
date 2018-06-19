package okhttp3;

import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.ByteString;
import okio.e;
import okio.f;

/* compiled from: MultipartBody */
public final class ab extends ag {
    public static final aa a = aa.a("multipart/mixed");
    public static final aa b = aa.a("multipart/alternative");
    public static final aa c = aa.a("multipart/digest");
    public static final aa d = aa.a("multipart/parallel");
    public static final aa e = aa.a("multipart/form-data");
    private static final byte[] f = new byte[]{(byte) 58, (byte) 32};
    private static final byte[] g = new byte[]{(byte) 13, (byte) 10};
    private static final byte[] h = new byte[]{(byte) 45, (byte) 45};
    private final ByteString i;
    private final aa j;
    private final aa k;
    private final List<b> l;
    private long m = -1;

    /* compiled from: MultipartBody */
    public static final class b {
        @Nullable
        final y a;
        final ag b;

        public static b a(String str, @Nullable String str2, ag agVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder stringBuilder = new StringBuilder("form-data; name=");
            ab.a(stringBuilder, str);
            if (str2 != null) {
                stringBuilder.append("; filename=");
                ab.a(stringBuilder, str2);
            }
            str = y.a("Content-Disposition", stringBuilder.toString());
            if (agVar == null) {
                throw new NullPointerException("body == null");
            } else if (str.a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (str.a("Content-Length") == null) {
                return new b(str, agVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        private b(@Nullable y yVar, ag agVar) {
            this.a = yVar;
            this.b = agVar;
        }
    }

    public ab(ByteString byteString, aa aaVar, List<b> list) {
        this.i = byteString;
        this.j = aaVar;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aaVar);
        stringBuilder.append("; boundary=");
        stringBuilder.append(byteString.utf8());
        this.k = aa.a(stringBuilder.toString());
        this.l = c.a(list);
    }

    public final aa b() {
        return this.k;
    }

    public final long a() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        j = a(null, true);
        this.m = j;
        return j;
    }

    public final void a(f fVar) throws IOException {
        a(fVar, false);
    }

    private long a(@Nullable f fVar, boolean z) throws IOException {
        e eVar;
        long j;
        if (z) {
            fVar = new e();
            eVar = fVar;
        } else {
            eVar = null;
        }
        int size = this.l.size();
        long j2 = 0;
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.l.get(i);
            y yVar = bVar.a;
            ag agVar = bVar.b;
            fVar.c(h);
            fVar.b(this.i);
            fVar.c(g);
            if (yVar != null) {
                int length = yVar.a.length / 2;
                for (int i2 = 0; i2 < length; i2++) {
                    fVar.b(yVar.a(i2)).c(f).b(yVar.b(i2)).c(g);
                }
            }
            aa b = agVar.b();
            if (b != null) {
                fVar.b("Content-Type: ").b(b.toString()).c(g);
            }
            long a = agVar.a();
            if (a != -1) {
                fVar.b("Content-Length: ").j(a).c(g);
            } else if (z) {
                eVar.n();
                return -1;
            }
            fVar.c(g);
            if (z) {
                j2 += a;
            } else {
                agVar.a(fVar);
            }
            fVar.c(g);
        }
        fVar.c(h);
        fVar.b(this.i);
        fVar.c(h);
        fVar.c(g);
        if (z) {
            j = j2 + eVar.b;
            eVar.n();
        } else {
            j = j2;
        }
        return j;
    }

    static StringBuilder a(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                stringBuilder.append("%0A");
            } else if (charAt == '\r') {
                stringBuilder.append("%0D");
            } else if (charAt != '\"') {
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append("%22");
            }
        }
        stringBuilder.append('\"');
        return stringBuilder;
    }
}
