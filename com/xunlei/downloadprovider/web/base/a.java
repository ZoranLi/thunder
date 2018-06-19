package com.xunlei.downloadprovider.web.base;

import android.text.TextUtils;
import com.xunlei.downloadprovider.web.base.core.MethodName;
import com.xunlei.downloadprovider.web.base.core.ag;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CustomWebViewActivity */
final class a extends ag {
    final /* synthetic */ CustomWebViewActivity a;

    a(CustomWebViewActivity customWebViewActivity) {
        this.a = customWebViewActivity;
    }

    protected final boolean a(MethodName methodName, JSONObject jSONObject, String str) throws JSONException {
        switch (d.a[methodName.ordinal()]) {
            case 1:
            case 2:
                methodName = "";
                if (jSONObject != null) {
                    methodName = jSONObject.optString("msg");
                }
                if (TextUtils.isEmpty(methodName) == null) {
                    this.a.a(methodName);
                }
                this.a.g();
                return true;
            default:
                return null;
        }
    }
}
