package com.xunlei.downloadprovider.ad.common.adget;

import com.android.volley.AuthFailureError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.common.net.volley.BaseStringRequest;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AgGet */
public class e$c extends BaseStringRequest {
    private final HashMap<String, String> a = new AgGet$ReportRequest$1();

    public e$c(String str, b<String> bVar, a aVar) {
        super(0, str, bVar, aVar);
    }

    public final Map<String, String> getHeaders() throws AuthFailureError {
        return this.a;
    }
}
