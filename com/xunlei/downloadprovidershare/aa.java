package com.xunlei.downloadprovidershare;

import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovidershare.z.a;
import org.json.JSONObject;

/* compiled from: ShareWechatReportHelper */
final class aa implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ a b;

    aa(JSONObject jSONObject, a aVar) {
        this.a = jSONObject;
        this.b = aVar;
    }

    public final void run() {
        VolleyRequestManager.getMainThreadRequestQueue().a(new SigJsonObjectRequest(1, "http://api-shoulei-ssl.xunlei.com/remotestorage/wechart_set", this.a, new ab(this), new ac(this)));
    }
}
