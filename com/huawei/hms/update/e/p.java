package com.huawei.hms.update.e;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* compiled from: SilentUpdateWizard */
class p extends Handler {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public void handleMessage(Message message) {
        Bundle bundle = (Bundle) message.obj;
        switch (message.what) {
            case 101:
                this.a.a(bundle);
                return;
            case 102:
                this.a.b(bundle);
                return;
            case 103:
                this.a.c(bundle);
                break;
            default:
                break;
        }
    }
}
