package com.xunlei.downloadprovider.download.privatespace.ui;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.downloadprovider.download.privatespace.a.a.i;
import com.xunlei.downloadprovider.member.e.a;

/* compiled from: PrivateSpaceFindPwdActivity */
final class h implements MessageListener {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    h(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 4097) {
            a aVar = (a) message.obj;
            PrivateSpaceFindPwdActivity.t(this.a);
            if (aVar == null) {
                PrivateSpaceFindPwdActivity.u(this.a);
                return;
            }
            this.a.p = new i();
            this.a.p.a = aVar.b;
            this.a.p.b = "SEA";
            this.a.o.a(aVar.a);
            this.a.o.a(true);
        }
    }
}
