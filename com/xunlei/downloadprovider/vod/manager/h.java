package com.xunlei.downloadprovider.vod.manager;

import com.android.volley.AuthFailureError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.toolbox.aa;
import java.util.Map;

/* compiled from: MCPRequestManager */
final class h extends aa {
    final /* synthetic */ e a;

    h(e eVar, String str, b bVar, a aVar) {
        this.a = eVar;
        super(1, str, bVar, aVar);
    }

    protected final Map<String, String> getParams() throws AuthFailureError {
        return this.a.c;
    }
}
