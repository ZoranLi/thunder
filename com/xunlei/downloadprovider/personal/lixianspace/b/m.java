package com.xunlei.downloadprovider.personal.lixianspace.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.d;
import com.xunlei.downloadprovider.personal.lixianspace.d.p;
import org.json.JSONObject;

/* compiled from: LXSpaceRequestMgr */
final class m implements d {
    m() {
    }

    public final void a(Object obj, JSONObject jSONObject) {
        l.a(new n(this, jSONObject, obj));
    }

    public final void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = p.a(i);
        }
        a.a.a(null, i, str);
    }
}
