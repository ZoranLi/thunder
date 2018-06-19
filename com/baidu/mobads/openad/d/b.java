package com.baidu.mobads.openad.d;

import com.baidu.mobads.utils.l;

class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run() {
        try {
            if (this.a.f != null && this.a.d.getAndSet(false)) {
                this.a.f.disconnect();
                this.a.f = null;
            }
        } catch (Throwable e) {
            l.a().e(e);
        }
    }
}
