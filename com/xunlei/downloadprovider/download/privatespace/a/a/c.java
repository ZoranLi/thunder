package com.xunlei.downloadprovider.download.privatespace.a.a;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.d;
import org.json.JSONObject;

/* compiled from: BindVerifyBusiness */
public final class c implements d {
    final /* synthetic */ h a;
    final /* synthetic */ a b;

    public c(a aVar, h hVar) {
        this.b = aVar;
        this.a = hVar;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        this.b.b = null;
        obj = jSONObject.optString("sign");
        if (TextUtils.isEmpty(obj) != null) {
            a(-20000, f.a(-20000));
            return;
        }
        this.b.c = new g();
        this.b.c.b = obj;
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void a(int i, String str) {
        if (this.a != null) {
            this.a.a(i, str);
        }
    }
}
