package com.alibaba.baichuan.android.a.a;

import com.alibaba.baichuan.android.a.e;
import com.alibaba.baichuan.android.trade.adapter.mtop.NetworkResponse;
import com.alibaba.baichuan.android.trade.adapter.mtop.b.a;
import com.alibaba.baichuan.android.trade.utils.b;
import java.util.Map;

final class d implements a {
    final /* synthetic */ com.alibaba.baichuan.android.a.d a;
    final /* synthetic */ c b;

    d(c cVar, com.alibaba.baichuan.android.a.d dVar) {
        this.b = cVar;
        this.a = dVar;
    }

    public final void a(NetworkResponse networkResponse) {
        e eVar = new e();
        Map map = networkResponse.data;
        for (String str : map.keySet()) {
            eVar.a(str, b.c(map.get(str)));
        }
        eVar.a();
        this.a.a(eVar);
    }

    public final void b(NetworkResponse networkResponse) {
        e eVar = new e();
        eVar.a(networkResponse.errorCode);
        eVar.g = networkResponse.errorMsg;
        networkResponse = networkResponse.data;
        for (String str : networkResponse.keySet()) {
            eVar.a(str, b.c(networkResponse.get(str)));
        }
        this.a.b(eVar);
    }
}
