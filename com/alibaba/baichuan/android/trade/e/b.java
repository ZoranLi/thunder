package com.alibaba.baichuan.android.trade.e;

import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.utils.b.a;
import com.alibaba.baichuan.android.trade.utils.i;

final class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (this.a.h != null) {
            c a = this.a.h;
            AlibcContext.b();
            if (a.a(a.b)) {
                i iVar = AlibcContext.b;
                iVar.a.postDelayed(new d(a), 2000);
            } else {
                AlibcContext.b();
            }
        }
        this.a.n.postDelayed(this.a.e, 1800000);
    }
}
