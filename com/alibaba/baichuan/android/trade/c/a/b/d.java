package com.alibaba.baichuan.android.trade.c.a.b;

import com.alibaba.baichuan.android.trade.c.a.a.b.b;
import com.alibaba.baichuan.android.trade.c.a.a.b.c;
import com.alibaba.baichuan.android.trade.callback.AlibcLoginCallback;
import com.alibaba.baichuan.android.trade.e.a;

public final class d implements b {
    public final boolean a(c cVar) {
        if (a.g().c()) {
            return false;
        }
        com.alibaba.baichuan.android.trade.adapter.c.a aVar = com.alibaba.baichuan.android.trade.adapter.c.a.a;
        cVar.a.getContext();
        AlibcLoginCallback eVar = new e(this, cVar);
        aVar.b();
        if (aVar.b == null) {
            eVar.onFailure(0, "login服务为null");
        } else {
            cVar = new com.alibaba.baichuan.android.trade.adapter.c.b(aVar, eVar);
        }
        return true;
    }
}
