package okhttp3.internal.b;

import okhttp3.aa;
import okhttp3.ak;
import okhttp3.y;
import okio.g;

/* compiled from: RealResponseBody */
public final class i extends ak {
    private final y a;
    private final g b;

    public i(y yVar, g gVar) {
        this.a = yVar;
        this.b = gVar;
    }

    public final aa a() {
        String a = this.a.a("Content-Type");
        return a != null ? aa.a(a) : null;
    }

    public final long b() {
        return f.a(this.a);
    }

    public final g c() {
        return this.b;
    }
}
