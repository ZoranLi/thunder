package com.xunlei.downloadprovider.member.register.ui;

/* compiled from: MobileSetupActivity */
final class aj implements Runnable {
    final /* synthetic */ a a;

    aj(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        int i = 60;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                if (!this.a.a) {
                    this.a.b.sendEmptyMessage(i2);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i = i2;
            } else {
                return;
            }
        }
    }
}
