package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class t extends Handler {
    final /* synthetic */ s a;

    t(s sVar, Looper looper) {
        this.a = sVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            Object[] objArr;
            switch (message.what) {
                case 0:
                    objArr = (Object[]) message.obj;
                    s.b((Context) objArr[0], (String) objArr[1]);
                    break;
                case 1:
                    this.a.c((Context) ((Object[]) message.obj)[0]);
                    break;
                case 2:
                    objArr = (Object[]) message.obj;
                    this.a.e((Context) objArr[0], (String) objArr[1]);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.handleMessage(message);
    }
}
