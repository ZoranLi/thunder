package com.xunlei.common.new_ptl.member.task.helpertask;

final class UserAqWebViewTask$1 implements Runnable {
    private /* synthetic */ StringBuffer a;
    private /* synthetic */ UserAqWebViewTask b;

    UserAqWebViewTask$1(UserAqWebViewTask userAqWebViewTask, StringBuffer stringBuffer) {
        this.b = userAqWebViewTask;
        this.a = stringBuffer;
    }

    public final void run() {
        if (this.b.c != null) {
            this.b.c.loadUrl(this.a.toString());
        }
    }
}
