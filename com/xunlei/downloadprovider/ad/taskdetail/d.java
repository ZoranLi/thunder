package com.xunlei.downloadprovider.ad.taskdetail;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.adget.r;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TaskDetailAdModel */
public final class d {
    private static d b;
    List<l> a;

    public static d a() {
        if (b == null) {
            b = new d();
        }
        return b;
    }

    private d() {
        this.a = null;
        this.a = new ArrayList();
    }

    public final void b() {
        new r().a(THUNDER_AD_INFO.TASK_DETAIL, new f(this), false);
    }
}
