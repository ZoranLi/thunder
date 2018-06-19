package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;

class r extends TimerTask {
    final /* synthetic */ IXAdPackageUtils a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ Timer d;
    final /* synthetic */ String e;
    final /* synthetic */ q f;

    r(q qVar, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer, String str2) {
        this.f = qVar;
        this.a = iXAdPackageUtils;
        this.b = context;
        this.c = str;
        this.d = timer;
        this.e = str2;
    }

    public void run() {
        if (this.f.g >= this.f.h) {
            if (this.f.g >= this.f.i) {
                this.d.cancel();
                this.a.sendAPOIsSuccess(this.b, true, 0, this.e, this.c);
            } else if (!this.a.isForeground(this.b, this.c)) {
                this.d.cancel();
                this.a.sendAPOIsSuccess(this.b, false, this.f.g, this.e, this.c);
            }
        }
        this.f.g = this.f.g + 1;
    }
}
