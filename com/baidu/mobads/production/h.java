package com.baidu.mobads.production;

import android.content.Context;

class h implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    h(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    public void run() {
        new Thread(new i(this)).start();
    }
}
