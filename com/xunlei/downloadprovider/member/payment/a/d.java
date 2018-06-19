package com.xunlei.downloadprovider.member.payment.a;

import android.os.Handler;
import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.downloadprovider.member.e;
import com.xunlei.downloadprovider.member.e.a;

/* compiled from: ActivationBox */
public final class d implements Runnable {
    final /* synthetic */ Handler a;
    final /* synthetic */ a b;

    public d(a aVar, Handler handler) {
        this.b = aVar;
        this.a = handler;
    }

    public final void run() {
        this.b.a = true;
        a a = new e().a();
        this.b.a = false;
        Message obtainMessage = this.a.obtainMessage(SecExceptionCode.SEC_ERROR_UMID_NETWORK_ERROR);
        obtainMessage.obj = a;
        obtainMessage.sendToTarget();
    }
}
