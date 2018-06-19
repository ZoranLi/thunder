package com.alibaba.sdk.android.feedback.util;

class g implements Runnable {
    final /* synthetic */ c a;

    g(c cVar) {
        this.a = cVar;
    }

    public void run() {
        this.a.e.removeCallbacks(this.a.i);
        if (this.a.c) {
            if (this.a.b != null) {
                try {
                    this.a.b.stop();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
                this.a.b.release();
                this.a.b = null;
            }
            this.a.c = false;
            this.a.f();
        }
    }
}
