package com.xunlei.downloadprovider.personal.lixianspace.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.b;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.d.p;

/* compiled from: LXSpaceRequestMgr */
public final class o implements b {
    final /* synthetic */ LXTaskInfo a;

    public o(LXTaskInfo lXTaskInfo) {
        this.a = lXTaskInfo;
    }

    public final void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = p.a(i);
        }
        a.a.a(i, str, this.a.a);
    }

    public final void a(Object obj) {
        a.a.a(0, "", this.a.a);
        l.a(obj);
    }
}
