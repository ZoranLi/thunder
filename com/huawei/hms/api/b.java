package com.huawei.hms.api;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.support.log.a;

/* compiled from: HuaweiApiClientImpl */
class b implements Callback {
    final /* synthetic */ HuaweiApiClientImpl a;

    b(HuaweiApiClientImpl huaweiApiClientImpl) {
        this.a = huaweiApiClientImpl;
    }

    public boolean handleMessage(Message message) {
        if (message != null) {
            if (message.what == 2) {
                a.d("HuaweiApiClientImpl", "In connect, bind core service time out");
                if (this.a.f.get() == 5) {
                    this.a.a(1);
                    if (this.a.l != null) {
                        this.a.l.onConnectionFailed(new ConnectionResult(6));
                    }
                }
                return true;
            }
        }
        return null;
    }
}
