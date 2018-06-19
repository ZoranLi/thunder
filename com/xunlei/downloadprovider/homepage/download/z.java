package com.xunlei.downloadprovider.homepage.download;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: DownloadTabFragment */
final class z implements Runnable {
    final /* synthetic */ y a;

    z(y yVar) {
        this.a = yVar;
    }

    public final void run() {
        LoginHelper.a();
        boolean z = l.b() && LoginHelper.a().l();
        this.a.a.e.a(true, z);
        this.a.a.e.b();
    }
}
