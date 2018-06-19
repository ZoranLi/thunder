package com.xunlei.downloadprovider.cooperation;

import com.android.volley.AuthFailureError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.common.net.volley.BaseJsonObjectRequest;
import java.util.Map;

/* compiled from: CooperationLoader */
final class j extends BaseJsonObjectRequest {
    final /* synthetic */ g a;

    j(g gVar, String str, b bVar, a aVar) {
        this.a = gVar;
        super(0, str, null, bVar, aVar);
    }

    public final Map<String, String> getHeaders() throws AuthFailureError {
        return this.a.e;
    }
}
