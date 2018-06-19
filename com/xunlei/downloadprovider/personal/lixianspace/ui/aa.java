package com.xunlei.downloadprovider.personal.lixianspace.ui;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.downloadprovider.web.base.core.MethodName;
import com.xunlei.downloadprovider.web.base.core.ag;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LixianSpaceH5Activity */
final class aa extends ag {
    final /* synthetic */ LixianSpaceH5Activity a;

    aa(LixianSpaceH5Activity lixianSpaceH5Activity) {
        this.a = lixianSpaceH5Activity;
    }

    protected final boolean a(MethodName methodName, JSONObject jSONObject, String str) throws JSONException {
        if (ab.a[methodName.ordinal()] != 1) {
            return false;
        }
        methodName = jSONObject.optBoolean("enable", false);
        if (this.a.c != null) {
            if (methodName != null) {
                this.a.c.setMode(Mode.PULL_FROM_START);
            } else {
                this.a.c.setMode(Mode.DISABLED);
            }
        }
        return true;
    }
}
