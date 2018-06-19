package com.igexin.push.core.c;

import com.igexin.push.core.a.f;
import java.util.TimerTask;

class c extends TimerTask {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run() {
        f.a().a(this.a.g, this.a.h, this.a.i);
        this.a.h.a(this.a.h.a() + 1);
    }
}
