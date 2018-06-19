package okhttp3.internal.b;

import anet.channel.util.HttpConstant;
import com.umeng.message.util.HttpRequest;
import java.io.IOException;
import java.util.List;
import okhttp3.aa;
import okhttp3.af;
import okhttp3.ag;
import okhttp3.aj;
import okhttp3.internal.c;
import okhttp3.o;
import okhttp3.p;
import okhttp3.z;
import okio.k;
import okio.m;
import okio.v;

/* compiled from: BridgeInterceptor */
public final class a implements z {
    private final p a;

    public a(p pVar) {
        this.a = pVar;
    }

    public final aj a(okhttp3.z.a aVar) throws IOException {
        int i;
        af a = aVar.a();
        okhttp3.af.a a2 = a.a();
        ag agVar = a.d;
        if (agVar != null) {
            aa b = agVar.b();
            if (b != null) {
                a2.a("Content-Type", b.toString());
            }
            long a3 = agVar.a();
            if (a3 != -1) {
                a2.a("Content-Length", Long.toString(a3));
                a2.b("Transfer-Encoding");
            } else {
                a2.a("Transfer-Encoding", "chunked");
                a2.b("Content-Length");
            }
        }
        int i2 = 0;
        if (a.a(HttpConstant.HOST) == null) {
            a2.a(HttpConstant.HOST, c.a(a.a, false));
        }
        if (a.a(HttpConstant.CONNECTION) == null) {
            a2.a(HttpConstant.CONNECTION, "Keep-Alive");
        }
        if (a.a("Accept-Encoding") == null && a.a("Range") == null) {
            a2.a("Accept-Encoding", "gzip");
            i = 1;
        } else {
            i = 0;
        }
        List b2 = this.a.b();
        if (!b2.isEmpty()) {
            String str = HttpConstant.COOKIE;
            StringBuilder stringBuilder = new StringBuilder();
            int size = b2.size();
            while (i2 < size) {
                if (i2 > 0) {
                    stringBuilder.append("; ");
                }
                o oVar = (o) b2.get(i2);
                stringBuilder.append(oVar.a);
                stringBuilder.append('=');
                stringBuilder.append(oVar.b);
                i2++;
            }
            a2.a(str, stringBuilder.toString());
        }
        if (a.a(HttpRequest.HEADER_USER_AGENT) == null) {
            a2.a(HttpRequest.HEADER_USER_AGENT, "okhttp/3.8.1");
        }
        aVar = aVar.a(a2.a());
        f.a(this.a, a.a, aVar.f);
        okhttp3.aj.a a4 = aVar.a();
        a4.a = a;
        if (i != 0 && "gzip".equalsIgnoreCase(aVar.a("Content-Encoding")) && f.b(aVar)) {
            v kVar = new k(aVar.g.c());
            aVar = aVar.f.a().a("Content-Encoding").a("Content-Length").a();
            a4.a(aVar);
            a4.g = new i(aVar, m.a(kVar));
        }
        return a4.a();
    }
}
