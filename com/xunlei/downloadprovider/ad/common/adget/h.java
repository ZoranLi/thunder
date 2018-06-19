package com.xunlei.downloadprovider.ad.common.adget;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.c.b$a;
import com.xunlei.downloadprovider.ad.common.n;
import com.xunlei.downloadprovider.ad.common.report.e;
import org.json.JSONObject;

/* compiled from: AgGet */
final class h implements b<String> {
    final /* synthetic */ n a;
    final /* synthetic */ b$a b;
    final /* synthetic */ e c;

    h(e eVar, n nVar, b$a com_xunlei_downloadprovider_ad_common_c_b_a) {
        this.c = eVar;
        this.a = nVar;
        this.b = com_xunlei_downloadprovider_ad_common_c_b_a;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        Object jSONObject;
        try {
            jSONObject = new JSONObject((String) obj);
        } catch (Object obj2) {
            obj2.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            this.a.a(jSONObject);
            return;
        }
        this.b.a();
        e a = e.a(-5, "jsonObject parse error");
        k.a("adv_request_fail", k.a((THUNDER_AD_INFO) this.c.b.get(0), null, "xunlei", a), this.b);
        this.a.a(a.a, a.b);
    }
}
