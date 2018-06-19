package com.igexin.push.core.c;

import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.g;
import com.igexin.push.d.c.a;
import java.util.Timer;
import java.util.TimerTask;

class d extends TimerTask {
    final /* synthetic */ PushTaskBean a;
    final /* synthetic */ a b;
    final /* synthetic */ b c;

    d(b bVar, PushTaskBean pushTaskBean, a aVar) {
        this.c = bVar;
        this.a = pushTaskBean;
        this.b = aVar;
    }

    public void run() {
        if (g.ak.containsKey(this.a.getTaskId())) {
            ((Timer) g.ak.get(this.a.getTaskId())).cancel();
            g.ak.remove(this.a.getTaskId());
        }
        this.c.a(this.a, this.b);
        this.b.b(this.b.c() + 1);
    }
}
