package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: RequestRedPacketProfit */
final class n implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ m b;

    n(m mVar, JSONObject jSONObject) {
        this.b = mVar;
        this.a = jSONObject;
    }

    public final void run() {
        c cVar = this.b.a.a;
        JSONObject jSONObject = this.a;
        c cVar2 = new c();
        if (jSONObject != null) {
            if (ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
                JSONObject optJSONObject = jSONObject.optJSONObject("balance_info");
                if (optJSONObject != null) {
                    cVar2.a = optJSONObject.optInt("cash");
                }
                jSONObject = jSONObject.optJSONObject("operation_info");
                if (jSONObject != null) {
                    cVar2.a = jSONObject.optInt("amount");
                }
            } else {
                cVar2.b = jSONObject.optInt("error_code");
            }
        }
        cVar.onSuccess(cVar2);
    }
}
