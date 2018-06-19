package com.qiniu.android.c;

import com.qiniu.android.d.a;
import com.qiniu.android.http.h;
import com.qiniu.android.http.o;
import org.json.JSONObject;

/* compiled from: ResumeUploader */
final class m implements h {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ k d;

    m(k kVar, int i, String str, long j) {
        this.d = kVar;
        this.a = i;
        this.b = str;
        this.c = j;
    }

    public final void a(o oVar, JSONObject jSONObject) {
        if (oVar.c() && !a.a()) {
            this.d.d.f.a();
            if (!a.a()) {
                this.d.c.a(this.d.b, oVar, jSONObject);
                return;
            }
        }
        if (oVar.b()) {
            k.e(this.d);
            this.d.d.d.a(1.0d);
            this.d.c.a(this.d.b, oVar, jSONObject);
            return;
        }
        if (oVar.d() && this.a < this.d.f.h + 1) {
            String a = this.d.f.k.a(this.d.o.b, this.d.f.l, this.b);
            if (a != null) {
                this.d.a(this.c, this.a + 1, a);
                return;
            }
        }
        this.d.c.a(this.d.b, oVar, jSONObject);
    }
}
