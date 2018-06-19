package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.ac;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.internal.b.h;
import okhttp3.z;

/* compiled from: ConnectInterceptor */
public final class a implements z {
    public final ac a;

    public a(ac acVar) {
        this.a = acVar;
    }

    public final aj a(okhttp3.z.a aVar) throws IOException {
        h hVar = (h) aVar;
        af afVar = hVar.d;
        f fVar = hVar.a;
        return hVar.a(afVar, fVar, fVar.a(this.a, afVar.b.equals("GET") ^ 1), fVar.b());
    }
}
