package com.xunlei.downloadprovider.personal.user;

import android.text.TextUtils;
import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import org.json.JSONObject;

/* compiled from: ReportActivity */
final class i implements b<JSONObject> {
    final /* synthetic */ XLWaitingDialog a;
    final /* synthetic */ ReportActivity b;

    i(ReportActivity reportActivity, XLWaitingDialog xLWaitingDialog) {
        this.b = reportActivity;
        this.a = xLWaitingDialog;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("onResponse").append(jSONObject.toString());
        obj = jSONObject.optString("result");
        if (TextUtils.isEmpty(obj) || obj.equals(ITagManager.SUCCESS) == null) {
            this.b.a(this.a);
        } else {
            this.b.b(this.a);
        }
    }
}
