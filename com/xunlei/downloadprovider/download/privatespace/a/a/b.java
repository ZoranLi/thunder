package com.xunlei.downloadprovider.download.privatespace.a.a;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.d;
import org.json.JSONObject;

/* compiled from: BindVerifyBusiness */
public final class b implements d {
    final /* synthetic */ h a;
    final /* synthetic */ a b;

    public b(a aVar, h hVar) {
        this.b = aVar;
        this.a = hVar;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        obj = jSONObject.optString("token");
        jSONObject = jSONObject.optString("sign");
        if (!TextUtils.isEmpty(obj)) {
            if (!TextUtils.isEmpty(jSONObject)) {
                this.b.b = new g();
                this.b.b.a = obj;
                this.b.b.b = jSONObject;
                if (this.a != null) {
                    this.a.a();
                }
                return;
            }
        }
        a(-20000, f.a(-20000));
    }

    public final void a(int i, String str) {
        if (this.a != null) {
            this.a.a(i, str);
        }
    }
}
