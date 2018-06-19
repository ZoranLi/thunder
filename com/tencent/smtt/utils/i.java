package com.tencent.smtt.utils;

import android.widget.Toast;

class i implements Runnable {
    final /* synthetic */ f a;

    i(f fVar) {
        this.a = fVar;
    }

    public void run() {
        Toast.makeText(this.a.b, "下载失败，请检查网络", 0).show();
    }
}
