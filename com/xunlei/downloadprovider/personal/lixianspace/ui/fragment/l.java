package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import android.text.TextUtils;
import com.xunlei.downloadprovider.web.base.core.MethodName;
import com.xunlei.downloadprovider.web.base.core.ag;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PullToRefreshWebFragment */
final class l extends ag {
    final /* synthetic */ PullToRefreshWebFragment a;

    l(PullToRefreshWebFragment pullToRefreshWebFragment) {
        this.a = pullToRefreshWebFragment;
    }

    protected final boolean a(MethodName methodName, JSONObject jSONObject, String str) throws JSONException {
        switch (m.a[methodName.ordinal()]) {
            case 2:
            case 3:
                String str2 = "";
                if (jSONObject != null) {
                    str2 = jSONObject.optString("msg");
                }
                if (TextUtils.isEmpty(str2) == null && this.a.i == null) {
                    this.a.a(str2);
                }
                this.a.i = false;
                this.a.c();
                return true;
            default:
                return null;
        }
    }
}
