package com.alibaba.baichuan.android.trade.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.baichuan.android.trade.AlibcContext;

final class k extends Handler {
    final /* synthetic */ i a;

    k(i iVar, Looper looper) {
        this.a = iVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Message message2) {
            message2.getMessage();
            AlibcContext.b();
        }
    }
}
