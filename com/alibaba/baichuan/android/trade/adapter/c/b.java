package com.alibaba.baichuan.android.trade.adapter.c;

import com.alibaba.baichuan.android.trade.adapter.ut.e;
import com.alibaba.baichuan.android.trade.callback.AlibcLoginCallback;

public final class b implements com.ali.auth.third.core.b.b {
    final /* synthetic */ AlibcLoginCallback a;
    final /* synthetic */ a b;

    public b(a aVar, AlibcLoginCallback alibcLoginCallback) {
        this.b = aVar;
        this.a = alibcLoginCallback;
    }

    public final void a(String str) {
        StringBuilder stringBuilder = new StringBuilder("code = 0 ,msg=");
        stringBuilder.append(str);
        e.b("Login", stringBuilder.toString(), "140101");
        this.a.onFailure(0, str);
    }
}
