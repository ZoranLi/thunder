package com.alibaba.sdk.android.feedback.util.a;

import com.alibaba.sdk.android.feedback.util.IWxCallback;

public abstract class a implements Runnable {
    protected IWxCallback a;
    protected String b;

    protected a(IWxCallback iWxCallback, String str) {
        this.a = iWxCallback;
        this.b = str;
    }

    protected abstract byte[] a();

    public void run() {
        if (this.a != null) {
            this.a.onProgress(0);
        }
        a();
    }
}
