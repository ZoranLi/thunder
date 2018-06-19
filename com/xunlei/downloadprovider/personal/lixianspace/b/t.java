package com.xunlei.downloadprovider.personal.lixianspace.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.d;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.d.p;
import org.json.JSONObject;

/* compiled from: LXSpaceRequestMgr */
public final class t implements d {
    final /* synthetic */ String a;

    public t(String str) {
        this.a = str;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        obj = LXTaskInfo.a(jSONObject);
        if (obj != null) {
            a.a.a(this.a, 0, "", obj);
        } else {
            a(-20000, p.a(-20000));
        }
    }

    public final void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = p.a(i);
        }
        a.a.a(this.a, i, str, null);
    }
}
