package okhttp3.internal.b;

import anet.channel.util.HttpConstant;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.f;
import okhttp3.z;
import okhttp3.z.a;
import okio.m;

/* compiled from: CallServerInterceptor */
public final class b implements z {
    private final boolean a;

    public b(boolean z) {
        this.a = z;
    }

    public final aj a(a aVar) throws IOException {
        aj.a aVar2;
        h hVar = (h) aVar;
        c cVar = hVar.b;
        f fVar = hVar.a;
        c cVar2 = hVar.c;
        af afVar = hVar.d;
        long currentTimeMillis = System.currentTimeMillis();
        cVar.a(afVar);
        if (!g.b(afVar.b) || afVar.d == null) {
            aVar2 = null;
        } else {
            if ("100-continue".equalsIgnoreCase(afVar.a("Expect"))) {
                cVar.a();
                aVar2 = cVar.a(true);
            } else {
                aVar2 = null;
            }
            if (aVar2 == null) {
                okio.f a = m.a(cVar.a(afVar, afVar.d.a()));
                afVar.d.a(a);
                a.close();
            } else if (!cVar2.c()) {
                fVar.d();
            }
        }
        cVar.b();
        if (aVar2 == null) {
            aVar2 = cVar.a(false);
        }
        aVar2.a = afVar;
        aVar2.e = fVar.b().c;
        aVar2.k = currentTimeMillis;
        aVar2.l = System.currentTimeMillis();
        aj a2 = aVar2.a();
        int i = a2.c;
        if (this.a && i == 101) {
            aVar = a2.a();
            aVar.g = okhttp3.internal.c.c;
            aVar = aVar.a();
        } else {
            aj.a a3 = a2.a();
            a3.g = cVar.a(a2);
            aVar = a3.a();
        }
        if ("close".equalsIgnoreCase(aVar.a.a(HttpConstant.CONNECTION)) || "close".equalsIgnoreCase(aVar.a(HttpConstant.CONNECTION, null))) {
            fVar.d();
        }
        if ((i != 204 && i != 205) || aVar.g.b() <= 0) {
            return aVar;
        }
        StringBuilder stringBuilder = new StringBuilder("HTTP ");
        stringBuilder.append(i);
        stringBuilder.append(" had non-zero Content-Length: ");
        stringBuilder.append(aVar.g.b());
        throw new ProtocolException(stringBuilder.toString());
    }
}
