package com.qiniu.android.b;

import com.qiniu.android.b.d.a;
import com.qiniu.android.http.h;
import com.qiniu.android.http.o;
import org.json.JSONObject;

/* compiled from: AutoZone */
final class b implements h {
    final /* synthetic */ a a;
    final /* synthetic */ a b;
    final /* synthetic */ a c;

    b(a aVar, a aVar2, a aVar3) {
        this.c = aVar;
        this.a = aVar2;
        this.b = aVar3;
    }

    public final void a(o oVar, JSONObject jSONObject) {
        if (!oVar.b() || jSONObject == null) {
            this.b.a(oVar.a);
            return;
        }
        try {
            this.c.c.put(this.a, e.a(jSONObject));
            this.b.a();
        } catch (o oVar2) {
            oVar2.printStackTrace();
            this.b.a(-1);
        }
    }
}
