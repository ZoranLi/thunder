package com.xunlei.downloadprovider.homepage.redpacket;

import android.content.Context;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: RedPacketHelper */
final class m implements Runnable {
    final /* synthetic */ j a;

    m(j jVar) {
        this.a = jVar;
    }

    public final void run() {
        Context c = j.c();
        StringBuilder stringBuilder = new StringBuilder("key_first_share_time");
        stringBuilder.append(LoginHelper.a().g.c());
        if (!DateUtil.isTheSameDay(f.b(c, stringBuilder.toString(), 0), System.currentTimeMillis())) {
            c = j.c();
            stringBuilder = new StringBuilder("key_first_share_time");
            stringBuilder.append(LoginHelper.a().g.c());
            f.a(c, stringBuilder.toString(), System.currentTimeMillis());
        }
    }
}
