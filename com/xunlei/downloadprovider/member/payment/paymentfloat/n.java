package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xunlei.downloadprovider.member.payment.bean.OpenPriceParam;

/* compiled from: MemberPriceHelper */
final class n extends Handler {
    final /* synthetic */ m a;

    n(m mVar, Looper looper) {
        this.a = mVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 4097) {
            if (message.obj != null && (message.obj instanceof OpenPriceParam)) {
                m.a(this.a, message.arg1, (OpenPriceParam) message.obj);
            }
        }
    }
}
