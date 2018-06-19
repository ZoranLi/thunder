package com.xunlei.downloadprovider.pushmessage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;

/* compiled from: PushNotificationHandler */
final class g implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;
    final /* synthetic */ BasePushBiz c;
    final /* synthetic */ f d;

    g(f fVar, Context context, Intent intent, BasePushBiz basePushBiz) {
        this.d = fVar;
        this.a = context;
        this.b = intent;
        this.c = basePushBiz;
    }

    public final void run() {
        try {
            this.a.startActivity(this.b);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
        this.c.onClick(this.a);
    }
}
