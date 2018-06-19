package com.xunlei.downloadprovider.ad.common.adget;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j.a;
import com.xunlei.downloadprovider.ad.common.c.b$a;
import com.xunlei.downloadprovider.ad.common.n;
import com.xunlei.downloadprovider.ad.common.report.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AgGet */
final class f implements n<JSONObject> {
    final /* synthetic */ b$a a;
    final /* synthetic */ b b;
    final /* synthetic */ v c;
    final /* synthetic */ e d;

    f(e eVar, b$a com_xunlei_downloadprovider_ad_common_c_b_a, b bVar, v vVar) {
        this.d = eVar;
        this.a = com_xunlei_downloadprovider_ad_common_c_b_a;
        this.b = bVar;
        this.c = vVar;
    }

    public final /* synthetic */ void a(Object obj) {
        a a = j.a((THUNDER_AD_INFO) this.d.b.get(0), (JSONObject) obj);
        if (a == null) {
            this.a.a();
            k.a("adv_request_fail", k.a((THUNDER_AD_INFO) this.d.b.get(0), null, this.d.a, e.a(-5, "parse error")), this.a);
            this.b.a();
            return;
        }
        this.a.a();
        k.a("adv_request_success", k.a(this.d.a, a), this.a);
        if (a.b != null && a.b.i()) {
            this.c.c = a.b;
        }
        this.c.d = a.f;
        this.c.e = a;
        if (a.a != (byte) 0) {
            this.b.a(a);
        } else if (a.b != null) {
            a.b.v = a.h;
            b bVar = this.b;
            obj = a.b;
            List arrayList = new ArrayList();
            arrayList.add(obj);
            bVar.a(arrayList);
        } else {
            this.a.a();
            k.a("adv_request_fail", k.a((THUNDER_AD_INFO) this.d.b.get(0), null, "xunlei", e.a(-5, "parse error")), this.a);
            this.b.a();
        }
    }

    public final void a(int i, String str) {
        this.b.a();
    }
}
