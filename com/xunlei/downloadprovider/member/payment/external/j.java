package com.xunlei.downloadprovider.member.payment.external;

import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: PayUtil */
final class j implements Runnable {
    j() {
    }

    public final void run() {
        for (int i = 0; i < 3; i++) {
            LoginHelper.a().b();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
