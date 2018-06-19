package com.xunlei.downloadprovider.vod.manager;

import com.android.volley.AuthFailureError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.toolbox.aa;
import java.util.Map;

/* compiled from: MCPRequestManager */
final class d extends aa {
    final /* synthetic */ Map a;
    final /* synthetic */ c b;

    d(c cVar, String str, b bVar, a aVar, Map map) {
        this.b = cVar;
        this.a = map;
        super(1, str, bVar, aVar);
    }

    protected final Map<String, String> getParams() throws AuthFailureError {
        return this.a;
    }
}
