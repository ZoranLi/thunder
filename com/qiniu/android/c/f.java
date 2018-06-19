package com.qiniu.android.c;

import com.qiniu.android.http.h;
import com.qiniu.android.http.o;
import org.json.JSONObject;

/* compiled from: FormUploader */
final class f implements h {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    f(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    public final void a(o oVar, JSONObject jSONObject) {
        if (oVar.b()) {
            this.b.a.d.a(1.0d);
        } else if (oVar.d()) {
            String a = this.b.d.k.a(this.b.e.b, this.b.d.l, this.a);
            this.b.g.a(a, this.b.h, this.b.e, this.b.i, new g(this, a), this.b.a.e);
            return;
        }
        this.b.b.a(this.b.c, oVar, jSONObject);
    }
}
