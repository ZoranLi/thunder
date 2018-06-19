package com.xunlei.downloadprovider.personal.lixianspace.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.d;
import org.json.JSONObject;

/* compiled from: LXSpaceRequestMgr */
public final class p implements d {
    public final void a(Object obj, JSONObject jSONObject) {
        l.a(new q(this, jSONObject, obj));
    }

    public final void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.xunlei.downloadprovider.personal.lixianspace.d.p.a(i);
        }
        a.a.a(null, i, str);
    }
}
