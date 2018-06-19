package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.a.b;
import com.xunlei.downloadprovider.a.g;

/* compiled from: MainTabActivity */
final class h implements Runnable {
    final /* synthetic */ g a;
    final /* synthetic */ MainTabActivity b;

    h(MainTabActivity mainTabActivity, g gVar) {
        this.b = mainTabActivity;
        this.a = gVar;
    }

    public final void run() {
        new b(this.b, this.a).show();
    }
}
