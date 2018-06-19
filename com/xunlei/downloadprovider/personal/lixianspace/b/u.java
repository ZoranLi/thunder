package com.xunlei.downloadprovider.personal.lixianspace.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.b;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo.a;
import com.xunlei.downloadprovider.personal.lixianspace.d.h;
import com.xunlei.downloadprovider.personal.lixianspace.d.p;
import com.xunlei.xllib.b.d;

/* compiled from: LXSpaceRequestMgr */
public final class u implements b {
    final /* synthetic */ LXTaskInfo a;

    public u(LXTaskInfo lXTaskInfo) {
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
        if (d.a(this.a.h) == null) {
            obj = new long[this.a.h.size()];
            int size = this.a.h.size();
            for (int i = 0; i < size; i++) {
                obj[i] = ((a) this.a.h.get(i)).c;
            }
        } else {
            obj = null;
        }
        h.a aVar = new h.a(this.a.b);
        aVar.b = this.a.g;
        aVar.a = this.a.f;
        if (obj != null) {
            aVar.c = obj;
        }
        l.a("lx_tag:default", aVar);
    }
}
