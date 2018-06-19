package com.qiniu.android.c;

import com.qiniu.android.a.b;
import com.qiniu.android.http.o;
import org.json.JSONObject;

/* compiled from: UploadManager */
public final class t {
    public final a a;
    final com.qiniu.android.http.a b;

    /* compiled from: UploadManager */
    private static class a implements q {
        final q a;
        final long b = System.currentTimeMillis();
        final long c;

        a(q qVar, long j) {
            this.a = qVar;
            this.c = j;
        }

        public final void a(String str, o oVar, JSONObject jSONObject) {
            if (com.qiniu.android.a.a.a) {
                b.b(oVar.n, new v(this, oVar, System.currentTimeMillis()));
            }
            com.qiniu.android.d.b.a(new w(this, str, oVar, jSONObject));
        }
    }

    public t() {
        this(new com.qiniu.android.c.a.a().a());
    }

    public t(a aVar) {
        this.a = aVar;
        this.b = new com.qiniu.android.http.a(aVar.c, aVar.f, aVar.g, aVar.i, aVar.j);
    }
}
