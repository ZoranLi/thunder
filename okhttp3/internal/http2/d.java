package okhttp3.internal.http2;

import anet.channel.util.HttpConstant;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.ac;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.ak;
import okhttp3.internal.b.c;
import okhttp3.internal.b.j;
import okhttp3.internal.b.l;
import okhttp3.internal.connection.f;
import okhttp3.y;
import okhttp3.y$a;
import okio.ByteString;
import okio.i;
import okio.m;
import okio.u;
import okio.v;

/* compiled from: Http2Codec */
public final class d implements c {
    private static final ByteString b = ByteString.encodeUtf8("connection");
    private static final ByteString c = ByteString.encodeUtf8("host");
    private static final ByteString d = ByteString.encodeUtf8("keep-alive");
    private static final ByteString e = ByteString.encodeUtf8("proxy-connection");
    private static final ByteString f = ByteString.encodeUtf8("transfer-encoding");
    private static final ByteString g = ByteString.encodeUtf8("te");
    private static final ByteString h = ByteString.encodeUtf8("encoding");
    private static final ByteString i = ByteString.encodeUtf8("upgrade");
    private static final List<ByteString> j = okhttp3.internal.c.a(b, c, d, e, g, f, h, i, a.c, a.d, a.e, a.f);
    private static final List<ByteString> k = okhttp3.internal.c.a(b, c, d, e, g, f, h, i);
    final f a;
    private final ac l;
    private final e m;
    private r n;

    /* compiled from: Http2Codec */
    class a extends i {
        final /* synthetic */ d a;

        a(d dVar, v vVar) {
            this.a = dVar;
            super(vVar);
        }

        public final void close() throws IOException {
            this.a.a.a(false, this.a);
            super.close();
        }
    }

    public d(ac acVar, f fVar, e eVar) {
        this.l = acVar;
        this.a = fVar;
        this.m = eVar;
    }

    public final u a(af afVar, long j) {
        return this.n.d();
    }

    public final void a(af afVar) throws IOException {
        if (this.n == null) {
            int i = 0;
            boolean z = afVar.d != null;
            y yVar = afVar.c;
            List arrayList = new ArrayList((yVar.a.length / 2) + 4);
            arrayList.add(new a(a.c, afVar.b));
            arrayList.add(new a(a.d, j.a(afVar.a)));
            String a = afVar.a(HttpConstant.HOST);
            if (a != null) {
                arrayList.add(new a(a.f, a));
            }
            arrayList.add(new a(a.e, afVar.a.a));
            afVar = yVar.a.length / 2;
            while (i < afVar) {
                ByteString encodeUtf8 = ByteString.encodeUtf8(yVar.a(i).toLowerCase(Locale.US));
                if (!j.contains(encodeUtf8)) {
                    arrayList.add(new a(encodeUtf8, yVar.b(i)));
                }
                i++;
            }
            this.n = this.m.a(arrayList, z);
            this.n.i.a((long) this.l.A, TimeUnit.MILLISECONDS);
            this.n.j.a((long) this.l.B, TimeUnit.MILLISECONDS);
        }
    }

    public final void a() throws IOException {
        this.m.q.b();
    }

    public final void b() throws IOException {
        this.n.d().close();
    }

    public final okhttp3.aj.a a(boolean z) throws IOException {
        List c = this.n.c();
        y$a okhttp3_y_a = new y$a();
        int size = c.size();
        y$a okhttp3_y_a2 = okhttp3_y_a;
        l lVar = null;
        for (int i = 0; i < size; i++) {
            a aVar = (a) c.get(i);
            if (aVar != null) {
                ByteString byteString = aVar.g;
                String utf8 = aVar.h.utf8();
                if (byteString.equals(a.b)) {
                    StringBuilder stringBuilder = new StringBuilder("HTTP/1.1 ");
                    stringBuilder.append(utf8);
                    lVar = l.a(stringBuilder.toString());
                } else if (!k.contains(byteString)) {
                    okhttp3.internal.a.a.a(okhttp3_y_a2, byteString.utf8(), utf8);
                }
            } else if (lVar != null && lVar.b == 100) {
                okhttp3_y_a2 = new y$a();
                lVar = null;
            }
        }
        if (lVar == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        okhttp3.aj.a aVar2 = new okhttp3.aj.a();
        aVar2.b = Protocol.HTTP_2;
        aVar2.c = lVar.b;
        aVar2.d = lVar.c;
        aVar2 = aVar2.a(okhttp3_y_a2.a());
        if (z && okhttp3.internal.a.a.a(aVar2)) {
            return null;
        }
        return aVar2;
    }

    public final ak a(aj ajVar) throws IOException {
        return new okhttp3.internal.b.i(ajVar.f, m.a(new a(this, this.n.g)));
    }
}
