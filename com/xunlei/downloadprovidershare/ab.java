package com.xunlei.downloadprovidershare;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: ShareWechatReportHelper */
final class ab implements b<JSONObject> {
    final /* synthetic */ aa a;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        obj = ((JSONObject) obj).optString("storid");
        if (this.a.b != null) {
            this.a.b.a(obj);
        }
    }
}
