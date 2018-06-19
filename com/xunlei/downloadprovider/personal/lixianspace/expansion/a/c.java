package com.xunlei.downloadprovider.personal.lixianspace.expansion.a;

import com.xunlei.downloadprovider.member.payment.network.d;
import org.json.JSONObject;

/* compiled from: LXSpaceDownloadConfig */
final class c implements d {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        b.a;
        if (jSONObject != null) {
            jSONObject.toString();
        }
        if (jSONObject != null) {
            try {
                obj = jSONObject.getJSONObject("table");
                if (obj != null) {
                    String jSONObject2 = obj.toString();
                    if (this.a.d == null) {
                        a.a(jSONObject2);
                        this.a.a(true);
                    }
                    b.a(jSONObject2);
                    obj = a.a;
                    long currentTimeMillis = System.currentTimeMillis();
                    obj.a.putLong("LX_SP_KEY_DOWNLOAD_CONFIG_TIME", currentTimeMillis);
                    obj.b = currentTimeMillis;
                }
            } catch (Object obj2) {
                obj2.printStackTrace();
            }
        }
    }

    public final void a(int i, String str) {
        b.a;
    }
}
