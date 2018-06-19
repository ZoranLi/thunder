package com.xunlei.downloadprovider.member.payment.paymentfloat;

import com.xunlei.downloadprovider.member.payment.bean.OpenPriceParam;
import com.xunlei.xllib.b.d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MemberPriceHelper */
final class s implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ r b;

    s(r rVar, JSONObject jSONObject) {
        this.b = rVar;
        this.a = jSONObject;
    }

    public final void run() {
        synchronized (this.b.a.f) {
            try {
                JSONObject jSONObject = this.a.getJSONObject("3");
                JSONObject jSONObject2 = this.a.getJSONObject("5");
                JSONObject jSONObject3 = this.a.getJSONObject("204");
                if (!(jSONObject == null || jSONObject2 == null)) {
                    if (jSONObject3 != null) {
                        m.a(this.b.a, jSONObject, 3);
                        m.a(this.b.a, jSONObject2, 5);
                        m.a(this.b.a, jSONObject3, 204);
                        if (!d.a(this.b.a.h)) {
                            for (Integer intValue : this.b.a.h) {
                                int intValue2 = intValue.intValue();
                                if (this.b.a.g.size() <= 0) {
                                    new StringBuilder("getPriceFromVipBusiness suc but response parse faild=").append(this.a.toString());
                                    m.c(this.b.a, intValue2);
                                } else {
                                    this.b.a.a(intValue2, (OpenPriceParam) this.b.a.g.get(intValue2));
                                }
                            }
                            this.b.a.h.clear();
                        }
                    }
                }
                throw new JSONException("no this vastype");
            } catch (Exception e) {
                e.printStackTrace();
                this.b.a.g.clear();
            }
        }
    }
}
