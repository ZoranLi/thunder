package com.xunlei.downloadprovider.pushmessage.umeng;

import com.umeng.message.PushAgent;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: UmengPushManager */
final class c implements Runnable {
    final /* synthetic */ String[] a;
    final /* synthetic */ a b;

    c(a aVar, String[] strArr) {
        this.b = aVar;
        this.a = strArr;
    }

    public final void run() {
        PushAgent.getInstance(BrothersApplication.getApplicationInstance()).getTagManager().list(new d(this));
        PushAgent.getInstance(BrothersApplication.getApplicationInstance()).getTagManager().update(new e(this), this.a);
    }
}
