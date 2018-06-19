package okhttp3.internal.b;

import java.io.IOException;
import java.util.List;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.f;
import okhttp3.k;
import okhttp3.z;
import okhttp3.z.a;

/* compiled from: RealInterceptorChain */
public final class h implements a {
    public final f a;
    final c b;
    final c c;
    public final af d;
    private final List<z> e;
    private final int f;
    private int g;

    public h(List<z> list, f fVar, c cVar, c cVar2, int i, af afVar) {
        this.e = list;
        this.c = cVar2;
        this.a = fVar;
        this.b = cVar;
        this.f = i;
        this.d = afVar;
    }

    public final k b() {
        return this.c;
    }

    public final af a() {
        return this.d;
    }

    public final aj a(af afVar) throws IOException {
        return a(afVar, this.a, this.b, this.c);
    }

    public final aj a(af afVar, f fVar, c cVar, c cVar2) throws IOException {
        if (this.f >= this.e.size()) {
            throw new AssertionError();
        }
        this.g++;
        if (this.b != null && !this.c.a(afVar.a)) {
            fVar = new StringBuilder("network interceptor ");
            fVar.append(this.e.get(this.f - 1));
            fVar.append(" must retain the same host and port");
            throw new IllegalStateException(fVar.toString());
        } else if (this.b == null || this.g <= 1) {
            h hVar = new h(this.e, fVar, cVar, cVar2, this.f + 1, afVar);
            z zVar = (z) this.e.get(this.f);
            fVar = zVar.a(hVar);
            if (cVar != null && this.f + 1 < this.e.size() && hVar.g != 1) {
                cVar = new StringBuilder("network interceptor ");
                cVar.append(zVar);
                cVar.append(" must call proceed() exactly once");
                throw new IllegalStateException(cVar.toString());
            } else if (fVar != null) {
                return fVar;
            } else {
                cVar = new StringBuilder("interceptor ");
                cVar.append(zVar);
                cVar.append(" returned null");
                throw new NullPointerException(cVar.toString());
            }
        } else {
            fVar = new StringBuilder("network interceptor ");
            fVar.append(this.e.get(this.f - 1));
            fVar.append(" must call proceed() exactly once");
            throw new IllegalStateException(fVar.toString());
        }
    }
}
