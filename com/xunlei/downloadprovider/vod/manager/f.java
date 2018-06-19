package com.xunlei.downloadprovider.vod.manager;

import android.text.TextUtils;
import com.android.volley.n.b;

/* compiled from: MCPRequestManager */
final class f implements b<String> {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String str = (String) obj;
        c.a;
        if (TextUtils.isEmpty(str)) {
            if (this.a.b != null) {
                this.a.b.onFail("sendRequestToMCP onResponse error : resp is empty");
            }
        } else if (this.a.b != null) {
            this.a.b.onSuccess(str);
        }
    }
}
