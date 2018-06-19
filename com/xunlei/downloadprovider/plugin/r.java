package com.xunlei.downloadprovider.plugin;

import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.Map;

/* compiled from: XLPluginManager */
final class r implements c<Map<String, p>> {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ q c;

    r(q qVar, String str, c cVar) {
        this.c = qVar;
        this.a = str;
        this.b = cVar;
    }

    public final void onFail(String str) {
        this.b.onFail("2");
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        obj = q.a().a(this.a);
        if (obj == null) {
            this.b.onFail("3");
        } else {
            this.b.onSuccess(obj);
        }
    }
}
