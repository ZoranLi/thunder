package com.xunlei.downloadprovider.pushmessage.xiaomi;

import com.xiaomi.mipush.sdk.MiPushClient;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.pushmessage.b.b;
import com.xunlei.downloadprovider.pushmessage.e;
import java.util.List;

/* compiled from: XiaoMiPushManager */
final class c implements Runnable {
    final /* synthetic */ String[] a;
    final /* synthetic */ a b;

    c(a aVar, String[] strArr) {
        this.b = aVar;
        this.a = strArr;
    }

    public final void run() {
        List allTopic = MiPushClient.getAllTopic(BrothersApplication.getApplicationInstance());
        String str = e.a;
        new StringBuilder("originalTags.size: ").append(allTopic == null ? 0 : allTopic.size());
        str = e.a;
        new StringBuilder("originalTags =").append(allTopic);
        a.a(allTopic, this.a);
        a.b(allTopic, this.a);
        b.a().a(System.currentTimeMillis());
    }
}
