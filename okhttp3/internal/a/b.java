package okhttp3.internal.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.c;
import okio.e;
import okio.f;
import okio.g;
import okio.v;
import okio.w;

/* compiled from: CacheInterceptor */
final class b implements v {
    boolean a;
    final /* synthetic */ g b;
    final /* synthetic */ c c;
    final /* synthetic */ f d;
    final /* synthetic */ a e;

    b(a aVar, g gVar, c cVar, f fVar) {
        this.e = aVar;
        this.b = gVar;
        this.c = cVar;
        this.d = fVar;
    }

    public final long a(e eVar, long j) throws IOException {
        try {
            j = this.b.a(eVar, j);
            if (j == -1) {
                if (this.a == null) {
                    this.a = true;
                    this.d.close();
                }
                return -1;
            }
            eVar.a(this.d.b(), eVar.b - j, j);
            this.d.p();
            return j;
        } catch (e eVar2) {
            if (this.a == null) {
                this.a = true;
            }
            throw eVar2;
        }
    }

    public final w a() {
        return this.b.a();
    }

    public final void close() throws IOException {
        if (!(this.a || c.a((v) this, TimeUnit.MILLISECONDS))) {
            this.a = true;
        }
        this.b.close();
    }
}
