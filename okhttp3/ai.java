package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.f;
import okio.m;

/* compiled from: RequestBody */
final class ai extends ag {
    final /* synthetic */ aa a;
    final /* synthetic */ File b;

    ai(aa aaVar, File file) {
        this.a = aaVar;
        this.b = file;
    }

    @Nullable
    public final aa b() {
        return this.a;
    }

    public final long a() {
        return this.b.length();
    }

    public final void a(f fVar) throws IOException {
        Closeable closeable = null;
        try {
            Closeable a = m.a(this.b);
            try {
                fVar.a(a);
                c.a(a);
            } catch (Throwable th) {
                fVar = th;
                closeable = a;
                c.a(closeable);
                throw fVar;
            }
        } catch (Throwable th2) {
            fVar = th2;
            c.a(closeable);
            throw fVar;
        }
    }
}
