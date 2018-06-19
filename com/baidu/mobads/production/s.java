package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;

class s extends TimerTask {
    final /* synthetic */ IXAdPackageUtils a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ Timer d;
    final /* synthetic */ q e;

    s(q qVar, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer) {
        this.e = qVar;
        this.a = iXAdPackageUtils;
        this.b = context;
        this.c = str;
        this.d = timer;
    }

    public void run() {
        if (this.e.j >= this.e.k) {
            if (this.e.j >= this.e.l) {
                this.d.cancel();
                this.a.sendDialerIsSuccess(this.b, true, 0, this.c);
            } else if (!this.a.isForeground(this.b, this.c) && this.a.isForeground(this.b, this.b.getPackageName())) {
                this.d.cancel();
                this.a.sendDialerIsSuccess(this.b, false, this.e.j, this.c);
            }
        }
        this.e.j = this.e.j + 1;
    }
}
