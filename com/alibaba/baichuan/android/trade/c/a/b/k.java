package com.alibaba.baichuan.android.trade.c.a.b;

import android.content.Intent;
import android.net.Uri;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.b.a;
import com.alibaba.baichuan.android.trade.c.a.a.b.b;
import com.alibaba.baichuan.android.trade.c.a.a.b.c;
import com.taobao.applink.util.TBAppLinkUtil;

public final class k implements b {
    public final boolean a(c cVar) {
        cVar = cVar.e;
        if (cVar == null) {
            com.alibaba.baichuan.android.trade.utils.c.a("TbopenHandlerAction", "execute", "url is null");
            return false;
        }
        a.a();
        if (!a.a(TBAppLinkUtil.TAOBAO_SCHEME)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setData(Uri.parse(cVar));
        AlibcContext.a.startActivity(intent);
        return true;
    }
}
