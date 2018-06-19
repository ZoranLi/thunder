package com.xunlei.downloadprovider.ad.c.d;

import android.os.Handler;
import android.os.Message;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.ad.c.a.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ReportInstalledAppsManager */
class f$a extends Handler {
    public final void handleMessage(Message message) {
        message = new c();
        List arrayList = new ArrayList(2);
        arrayList.add(new l());
        arrayList.add(new m());
        LoginHelper.a();
        if (l.c()) {
            arrayList.add(new i());
        }
        message.a(arrayList);
        XLThreadPool.execute(new g(message));
    }
}
