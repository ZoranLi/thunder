package com.xunlei.downloadprovider.publiser.campaign.a;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.publiser.campaign.m;
import org.json.JSONObject;

/* compiled from: TopicNetWork */
final class f implements b<JSONObject> {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ boolean c;
    final /* synthetic */ m d;
    final /* synthetic */ e e;

    f(e eVar, String str, c cVar, boolean z, m mVar) {
        this.e = eVar;
        this.a = str;
        this.b = cVar;
        this.c = z;
        this.d = mVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        e.a;
        new StringBuilder("getHotCampaignList jsonObject=").append(jSONObject);
        b a = b.a(jSONObject);
        if (a.a) {
            e.a;
            new StringBuilder("getHotCampaignList size =").append(a.d.size());
            e.a;
            new StringBuilder("getHotCampaignList isMore =").append(a.b);
            if (this.b != null) {
                this.b.a(a);
            }
            if (this.c && this.d != null) {
                this.d.a(a);
                return;
            }
        }
        if (this.b != null) {
            this.b.k();
        }
        if (!(this.c == null || this.d == null)) {
            this.d.a(true);
        }
    }
}
