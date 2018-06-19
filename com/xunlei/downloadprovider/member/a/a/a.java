package com.xunlei.downloadprovider.member.a.a;

import com.android.volley.VolleyError;
import com.android.volley.n.b;

/* compiled from: HighSpeedClient */
public final class a implements com.android.volley.n.a, b<String> {
    b a;

    public final /* synthetic */ void onResponse(Object obj) {
        try {
            c.a("", (String) obj);
            c.a();
            if (this.a != null) {
                this.a.b();
            }
        } catch (Object obj2) {
            obj2.printStackTrace();
            a();
        }
    }

    public a(b bVar) {
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.getMessage();
        a();
    }

    private void a() {
        if (this.a != null) {
            b bVar = this.a;
            if (bVar.a != null) {
                bVar.a.b();
            }
        }
    }
}
