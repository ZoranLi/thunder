package com.xunlei.downloadprovider.personal.user;

import android.text.TextUtils;
import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import org.json.JSONObject;

/* compiled from: ReportActivity */
final class r implements b<JSONObject> {
    final /* synthetic */ XLWaitingDialog a;
    final /* synthetic */ ReportActivity b;

    r(ReportActivity reportActivity, XLWaitingDialog xLWaitingDialog) {
        this.b = reportActivity;
        this.a = xLWaitingDialog;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        obj = ((JSONObject) obj).optString("result");
        if (TextUtils.isEmpty(obj) || obj.equals(ITagManager.SUCCESS) == null) {
            this.b.a(this.a);
        } else {
            this.b.b(this.a);
        }
    }
}
