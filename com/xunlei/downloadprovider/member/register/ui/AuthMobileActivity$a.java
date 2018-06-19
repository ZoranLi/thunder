package com.xunlei.downloadprovider.member.register.ui;

import android.os.Handler;
import android.os.Looper;

class AuthMobileActivity$a {
    volatile boolean a = false;
    Handler b;
    Thread c;

    interface a {
        void a(int i);
    }

    AuthMobileActivity$a(a aVar) {
        this.b = new o(this, Looper.getMainLooper(), aVar);
        this.c = new Thread(new p(this));
    }
}
