package com.qiniu.android.c;

import com.qiniu.android.http.h;
import com.qiniu.android.http.o;
import org.json.JSONObject;

/* compiled from: FormUploader */
final class g implements h {
    final /* synthetic */ String a;
    final /* synthetic */ f b;

    g(f fVar, String str) {
        this.b = fVar;
        this.a = str;
    }

    public final void a(o oVar, JSONObject jSONObject) {
        if (oVar.b()) {
            this.b.b.a.d.a(1.0d);
        } else if (oVar.d()) {
            this.b.b.d.k.a(this.a);
        }
        this.b.b.b.a(this.b.b.c, oVar, jSONObject);
    }
}
