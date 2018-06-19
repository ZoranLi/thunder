package com.xunlei.downloadprovider.member.register.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xunlei.downloadprovider.member.register.ui.MobileSetupActivity.a.a;

/* compiled from: MobileSetupActivity */
final class ai extends Handler {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    ai(a aVar, Looper looper, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.a != null) {
            this.a.a(message.what);
        }
    }
}
