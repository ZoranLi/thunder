package com.xunlei.downloadprovidershare;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ShareWechatReportHelper */
final class ac implements a {
    final /* synthetic */ aa a;

    ac(aa aaVar) {
        this.a = aaVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a.b != null) {
            this.a.b.a(null);
        }
    }
}
