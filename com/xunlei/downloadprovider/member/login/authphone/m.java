package com.xunlei.downloadprovider.member.login.authphone;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: AuthDlgActivity */
final class m extends Handler {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    m(a aVar, Looper looper, a aVar2) {
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
