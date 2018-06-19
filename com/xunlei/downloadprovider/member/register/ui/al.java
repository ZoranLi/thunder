package com.xunlei.downloadprovider.member.register.ui;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: RegisterSuccessActivity */
final class al implements MessageListener {
    final /* synthetic */ RegisterSuccessActivity a;

    al(RegisterSuccessActivity registerSuccessActivity) {
        this.a = registerSuccessActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 109) {
            this.a.u.a(this.a.e.e(), this.a.j, false);
        }
    }
}
