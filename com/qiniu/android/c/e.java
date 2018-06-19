package com.qiniu.android.c;

import com.qiniu.android.http.a;
import com.qiniu.android.http.h;
import com.qiniu.android.http.k;
import com.qiniu.android.http.l;
import com.qiniu.android.http.o;
import org.json.JSONObject;

/* compiled from: FormUploader */
final class e implements h {
    final /* synthetic */ x a;
    final /* synthetic */ q b;
    final /* synthetic */ String c;
    final /* synthetic */ a d;
    final /* synthetic */ s e;
    final /* synthetic */ String f;
    final /* synthetic */ a g;
    final /* synthetic */ k h;
    final /* synthetic */ l i;

    e(x xVar, q qVar, String str, a aVar, s sVar, String str2, a aVar2, k kVar, l lVar) {
        this.a = xVar;
        this.b = qVar;
        this.c = str;
        this.d = aVar;
        this.e = sVar;
        this.f = str2;
        this.g = aVar2;
        this.h = kVar;
        this.i = lVar;
    }

    public final void a(o oVar, JSONObject jSONObject) {
        if (oVar.c() && !com.qiniu.android.d.a.a()) {
            this.a.f.a();
            if (!com.qiniu.android.d.a.a()) {
                this.b.a(this.c, oVar, jSONObject);
                return;
            }
        }
        if (oVar.b()) {
            this.a.d.a(1.0d);
        } else if (oVar.d()) {
            String a = this.d.k.a(this.e.b, this.d.l, this.f);
            this.g.a(a, this.h, this.e, this.i, new f(this, a), this.a.e);
            return;
        }
        this.b.a(this.c, oVar, jSONObject);
    }
}
