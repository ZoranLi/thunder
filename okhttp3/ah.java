package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;
import okio.f;

/* compiled from: RequestBody */
final class ah extends ag {
    final /* synthetic */ aa a;
    final /* synthetic */ int b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ int d = null;

    ah(aa aaVar, int i, byte[] bArr) {
        this.a = aaVar;
        this.b = i;
        this.c = bArr;
    }

    @Nullable
    public final aa b() {
        return this.a;
    }

    public final long a() {
        return (long) this.b;
    }

    public final void a(f fVar) throws IOException {
        fVar.c(this.c, this.d, this.b);
    }
}
