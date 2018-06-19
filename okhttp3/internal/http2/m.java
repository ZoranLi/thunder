package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.http2.e.b;

/* compiled from: Http2Connection */
final class m extends b {
    m() {
    }

    public final void a(r rVar) throws IOException {
        rVar.a(ErrorCode.REFUSED_STREAM);
    }
}
