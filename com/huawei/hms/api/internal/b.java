package com.huawei.hms.api.internal;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.support.log.a;

/* compiled from: BindingFailedResolution */
class b implements Callback {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public boolean handleMessage(Message message) {
        if (message != null) {
            if (message.what == 2) {
                a.d("BindingFailedResolution", "In connect, bind core try timeout");
                this.a.b(false);
                return true;
            }
        }
        return false;
    }
}
