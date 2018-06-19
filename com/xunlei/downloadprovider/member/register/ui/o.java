package com.xunlei.downloadprovider.member.register.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: AuthMobileActivity */
final class o extends Handler {
    final /* synthetic */ a a;
    final /* synthetic */ AuthMobileActivity$a b;

    o(AuthMobileActivity$a authMobileActivity$a, Looper looper, a aVar) {
        this.b = authMobileActivity$a;
        this.a = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.a != null) {
            this.a.a(message.what);
        }
    }
}
