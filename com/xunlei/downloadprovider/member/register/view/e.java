package com.xunlei.downloadprovider.member.register.view;

import android.os.Handler;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;

/* compiled from: VerifyCodeDialog */
final class e extends Handler {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 100000) {
            this.a.b.requestFocus();
            ((InputMethodManager) this.a.i.getSystemService("input_method")).showSoftInput(this.a.b, 0);
        }
    }
}
