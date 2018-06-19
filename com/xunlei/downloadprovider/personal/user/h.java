package com.xunlei.downloadprovider.personal.user;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;

/* compiled from: ReportActivity */
final class h implements a {
    final /* synthetic */ XLWaitingDialog a;
    final /* synthetic */ ReportActivity b;

    h(ReportActivity reportActivity, XLWaitingDialog xLWaitingDialog) {
        this.b = reportActivity;
        this.a = xLWaitingDialog;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("onErrorResponse").append(volleyError.toString());
        this.b.a(this.a);
    }
}
