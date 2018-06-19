package com.xunlei.downloadprovider.plugin;

import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.Map;

/* compiled from: XLPluginManager */
final class s implements c<Map<String, p>> {
    final /* synthetic */ c a;
    final /* synthetic */ q b;

    s(q qVar, c cVar) {
        this.b = qVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Map map = (Map) obj;
        q.b;
        this.b.d = map;
        if (this.a != null) {
            this.a.onSuccess(map);
        }
    }

    public final void onFail(String str) {
        q.b;
        if (this.a != null) {
            this.a.onFail(str);
        }
    }
}
