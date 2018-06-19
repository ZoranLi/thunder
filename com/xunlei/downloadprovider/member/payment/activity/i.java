package com.xunlei.downloadprovider.member.payment.activity;

import org.json.JSONObject;

/* compiled from: IActivityConfigImpl */
final class i implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ h b;

    i(h hVar, JSONObject jSONObject) {
        this.b = hVar;
        this.a = jSONObject;
    }

    public final void run() {
        try {
            String jSONObject = this.a.toString();
            this.b.a.d(jSONObject);
            g.b(this.b.a, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
