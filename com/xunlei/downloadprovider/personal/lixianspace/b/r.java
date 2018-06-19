package com.xunlei.downloadprovider.personal.lixianspace.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.d;
import com.xunlei.downloadprovider.personal.lixianspace.d.p;
import org.json.JSONObject;

/* compiled from: LXSpaceRequestMgr */
final class r implements d {
    r() {
    }

    public final void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = p.a(i);
        }
        a.a.a(i, str);
    }

    public final void a(Object obj, JSONObject jSONObject) {
        a.a.a(jSONObject);
    }
}
