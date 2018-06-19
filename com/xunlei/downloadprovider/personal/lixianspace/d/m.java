package com.xunlei.downloadprovider.personal.lixianspace.d;

import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;
import com.xunlei.downloadprovider.member.payment.network.d;

/* compiled from: GetLXTaskListRequest */
public final class m extends a {
    public m(Object obj) {
        super(obj, IMethod.POST, "http://download.lixian.vip.xunlei.com/task/list");
    }

    public final void a(int i, d dVar) {
        a("page", String.valueOf(i)).a("pagesize", "20");
        a(0, dVar);
    }
}
