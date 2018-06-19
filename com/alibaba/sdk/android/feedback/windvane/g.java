package com.alibaba.sdk.android.feedback.windvane;

import com.alibaba.sdk.android.feedback.xblink.webview.v;

class g implements Runnable {
    final /* synthetic */ v a;
    final /* synthetic */ f b;

    g(f fVar, v vVar) {
        this.b = fVar;
        this.a = vVar;
    }

    public void run() {
        this.a.e();
    }
}
