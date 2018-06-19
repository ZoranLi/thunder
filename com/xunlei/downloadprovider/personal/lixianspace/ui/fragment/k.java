package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.downloadprovider.web.base.core.MethodName;
import com.xunlei.downloadprovider.web.base.core.ag;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PullToRefreshWebFragment */
final class k extends ag {
    final /* synthetic */ PullToRefreshWebFragment a;

    k(PullToRefreshWebFragment pullToRefreshWebFragment) {
        this.a = pullToRefreshWebFragment;
    }

    protected final boolean a(MethodName methodName, JSONObject jSONObject, String str) throws JSONException {
        if (m.a[methodName.ordinal()] != 1) {
            return false;
        }
        methodName = jSONObject.optBoolean("enable", false);
        if (this.a.a != null) {
            if (methodName != null) {
                this.a.a.setMode(Mode.PULL_FROM_START);
            } else {
                this.a.a.setMode(Mode.DISABLED);
            }
        }
        return true;
    }
}
