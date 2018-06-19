package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.dialog.quit.QuitAppDialogFragment.b;
import com.xunlei.downloadprovider.download.engine.task.n;

/* compiled from: MainTabActivity */
final class k implements b {
    final /* synthetic */ MainTabActivity a;

    k(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void a() {
        String str = MainTabActivity.a;
        this.a.a(false);
    }

    public final void b() {
        String str = MainTabActivity.a;
        if (d.a().b.x()) {
            n.a();
            n.f();
            this.a.a(true);
            return;
        }
        MainTabActivity.g(this.a);
    }

    public final void c() {
        MainTabActivity.h(this.a);
    }
}
