package com.baidu.mobads.production;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;

class l extends Handler {
    final /* synthetic */ IXAdInstanceInfo a;
    final /* synthetic */ b b;

    l(b bVar, Looper looper, IXAdInstanceInfo iXAdInstanceInfo) {
        this.b = bVar;
        this.a = iXAdInstanceInfo;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == 0) {
            try {
                this.b.a(message, this.a);
            } catch (Throwable e) {
                com.baidu.mobads.utils.l.a().e(e);
            }
        }
    }
}
