package com.xunlei.downloadprovider.homepage.choiceness.ui;

import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.a.a;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.downloadprovider.homepage.choiceness.a.t;

/* compiled from: HomeChoicenessFragment */
final class r implements a {
    final /* synthetic */ HomeChoicenessFragment a;

    r(HomeChoicenessFragment homeChoicenessFragment) {
        this.a = homeChoicenessFragment;
    }

    public final void a() {
        this.a.a(ChoicenessReporter$RefreshType.auto_pull);
    }

    public final long b() {
        return t.a().a.getLong("ChoicenessLastRefreshTime", 0);
    }

    public final void c() {
        t.a().a(System.currentTimeMillis());
    }

    public final int d() {
        return d.a().b.j();
    }
}
