package com.alibaba.baichuan.android.trade.c.a.b;

import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.c.a.a.b.b;
import com.alibaba.baichuan.android.trade.c.a.a.b.c;
import com.alibaba.baichuan.android.trade.d.d;
import com.alibaba.baichuan.android.trade.e.a;
import com.alibaba.baichuan.android.trade.model.ApplinkOpenType;
import com.igexin.sdk.PushConsts;

public final class i implements b {
    public final boolean a(c cVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AlibcContext.c());
        stringBuilder.append(".nativeTaobao");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder("alisdk://");
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("/handleraction");
        String stringBuilder4 = stringBuilder3.toString();
        return d.a(cVar.d, ApplinkOpenType.SHOWSHOP, null, cVar.b("shop_id"), a.g().f(), cVar.b(PushConsts.KEY_SERVICE_PIT), stringBuilder4, null);
    }
}
