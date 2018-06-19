package com.tencent.smtt.utils;

import android.widget.Toast;

class g implements Runnable {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void run() {
        Toast.makeText(this.a.b, "下载成功", 0).show();
        this.a.c.setVisibility(4);
        this.a.f.a(this.a.d, this.a.a, this.a.b, e.c);
    }
}
