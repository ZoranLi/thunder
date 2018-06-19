package com.igexin.push.core;

import android.os.Looper;

public class h extends Thread {
    public void run() {
        Thread.currentThread().setName("CoreThread");
        Looper.prepare();
        if (f.a() != null) {
            f.a().a(new e());
        }
        f.a().b();
        Looper.loop();
    }
}
