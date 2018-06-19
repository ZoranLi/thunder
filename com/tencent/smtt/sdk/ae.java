package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ae extends Handler {
    final /* synthetic */ ad a;

    ae(ad adVar, Looper looper) {
        this.a = adVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == 150) {
            this.a.m();
        }
    }
}
