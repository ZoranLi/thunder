package com.xunlei.downloadprovider.ad.home.a;

import com.xunlei.downloadprovider.ad.common.adget.j;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.n;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.b;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import org.json.JSONObject;

/* compiled from: HomeAdReloadController */
final class c implements n<JSONObject> {
    final /* synthetic */ b a;
    final /* synthetic */ b b;

    c(b bVar, b bVar2) {
        this.b = bVar;
        this.a = bVar2;
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        String str = "tryReloadAd. onSuccess";
        if (b.a(this.b, str, this.a)) {
            l a = f.a(BrothersApplication.getApplicationInstance()).a(f.b, j.a(f.b, jSONObject));
            StringBuilder stringBuilder = new StringBuilder("tryReloadAd. tryChangeChoicenessAdInfo. resId: ");
            stringBuilder.append(this.a.b());
            stringBuilder.append(" adInfo: ");
            stringBuilder.append(a);
            if (a == null) {
                b.a(this.b, str, this.a, "onSuccess. adInfo is null");
                return;
            }
            f a2 = f.a(BrothersApplication.getApplicationInstance());
            e eVar = this.a;
            boolean z = false;
            if (a2.d != null) {
                eVar.a = jSONObject;
                f.a(false, eVar, a, f.b);
                a.b("home_reload");
                a2.c.a(eVar.b(), a);
                obj = a2.c.c;
                if (obj != null) {
                    obj.remove(eVar.b());
                }
                a2.d.a(eVar);
                z = true;
            }
            if (z) {
                b.a(this.b, this.a);
                if (b.a(this.b) != null) {
                    b.b(this.b);
                }
            } else {
                b.a(this.b, str, this.a, "changeChoicenessAdInfo fail");
            }
        }
    }

    public final void a(int i, String str) {
        b bVar = this.a;
        StringBuilder stringBuilder = new StringBuilder("onFail. errorCode: ");
        stringBuilder.append(i);
        stringBuilder.append(" errorInfo: ");
        stringBuilder.append(str);
        b.a(this.b, "tryReload. onFail", bVar, stringBuilder.toString());
    }
}
