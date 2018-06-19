package com.alibaba.sdk.android.feedback.util;

class h implements Runnable {
    final /* synthetic */ c a;

    h(c cVar) {
        this.a = cVar;
    }

    public void run() {
        if (this.a.e != null) {
            this.a.e.getLooper().quit();
            this.a.e = null;
        }
    }
}
