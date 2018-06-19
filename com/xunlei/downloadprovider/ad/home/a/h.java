package com.xunlei.downloadprovider.ad.home.a;

import android.text.TextUtils;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.choiceness.a.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import java.util.Iterator;

/* compiled from: LoadADClient */
public final class h implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ f b;

    public h(f fVar, e eVar) {
        this.b = fVar;
        this.a = eVar;
    }

    public final void run() {
        a a = a.a(BrothersApplication.getApplicationInstance());
        Object b = this.a.b();
        if (!TextUtils.isEmpty(b)) {
            Iterator it = a.d.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (b.equals(eVar.b())) {
                    a.d.remove(eVar);
                    break;
                }
            }
            a.b();
        }
        if (f.b(this.b) != null) {
            f.b(this.b).b(this.a.b());
        }
    }
}
