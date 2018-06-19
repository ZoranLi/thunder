package com.xunlei.common.concurrent;

class XLCommand$1 implements Runnable {
    final /* synthetic */ XLCommand this$0;

    XLCommand$1(XLCommand xLCommand) {
        this.this$0 = xLCommand;
    }

    public void run() {
        this.this$0.onResponse();
    }
}
