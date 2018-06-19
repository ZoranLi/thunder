package com.xunlei.downloadprovider.vod.manager;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: MCPRequestManager */
final class g implements a {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        c.a;
        new StringBuilder("onResponse : ").append(volleyError.toString());
        if (this.a.b != null) {
            if (volleyError.networkResponse != null) {
                c cVar = this.a.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(volleyError.networkResponse.a);
                cVar.onFail(stringBuilder.toString());
                return;
            }
            this.a.b.onFail(RePlugin.PROCESS_UI);
        }
    }
}
