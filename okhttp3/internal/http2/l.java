package okhttp3.internal.http2;

import okhttp3.internal.b;

/* compiled from: Http2Connection */
final class l extends b {
    final /* synthetic */ int a;
    final /* synthetic */ ErrorCode c;
    final /* synthetic */ e d;

    l(e eVar, String str, Object[] objArr, int i, ErrorCode errorCode) {
        this.d = eVar;
        this.a = i;
        this.c = errorCode;
        super(str, objArr);
    }

    public final void b() {
        this.d.j.c();
        synchronized (this.d) {
            this.d.s.remove(Integer.valueOf(this.a));
        }
    }
}
