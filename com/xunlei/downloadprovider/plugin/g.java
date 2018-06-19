package com.xunlei.downloadprovider.plugin;

import android.content.Context;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.Map;

/* compiled from: XLPluginDownloadManager */
final class g implements c<Map<String, p>> {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;

    g(a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    public final void onFail(String str) {
        a.a();
        new StringBuilder("XLPluginInfo 获取失败 ").append(a.e(this.b));
        a.c(this.b, 2);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        obj = q.a().a(a.e(this.b));
        if (obj == null) {
            a.a();
            new StringBuilder("XLPluginInfo 获取为空 ").append(a.e(this.b));
            a.c(this.b, 3);
            return;
        }
        a.a(this.b, this.a, obj);
    }
}
