package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;

class c implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ b d;

    c(b bVar, Context context, String str, boolean z) {
        this.d = bVar;
        this.a = context;
        this.b = str;
        this.c = z;
    }

    public void run() {
        try {
            this.d.a(this.a, this.b, this.c);
            this.d.a();
        } catch (SecException e) {
            e.printStackTrace();
            this.d.b();
        }
    }
}
