package com.xunlei.downloadprovider.plugin;

import com.qihoo360.replugin.RePlugin;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.io.File;

/* compiled from: XLPluginDownloadManager */
final class j implements a$a {
    final /* synthetic */ long a;
    final /* synthetic */ p b;
    final /* synthetic */ String c;
    final /* synthetic */ a d;

    j(a aVar, long j, p pVar, String str) {
        this.d = aVar;
        this.a = j;
        this.b = pVar;
        this.c = str;
    }

    public final void a() {
        a.f(this.d);
        long currentTimeMillis = (System.currentTimeMillis() - this.a) / 1000;
        a.a();
        StringBuilder stringBuilder = new StringBuilder("downloadPlugin success : ");
        stringBuilder.append(this.b.a);
        stringBuilder.append(" Download time cost ");
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append("s");
        String a = q.a(BrothersApplication.getApplicationInstance(), this.b.a);
        a.a();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.b.a);
        stringBuilder2.append(" file size : ");
        stringBuilder2.append(new File(a).length() / 1024);
        stringBuilder2.append(" Kb");
        w.a(this.b.a, this.b.b, RePlugin.isPluginInstalled(this.c) ? "update" : "new", true);
        if (a.g(this.d)) {
            a.a(this.d, 90);
            a.b(this.d, 90);
            a.b(this.d).removeCallbacks(a.c(this.d));
            a.b(this.d).postDelayed(a.c(this.d), 1000);
            a.b(this.d, this.b);
            return;
        }
        a.a(this.d, 100);
        a.b(this.d, 100);
        q.a().b(a.e(this.d));
        a.h(this.d);
    }

    public final void b() {
        a.a();
        new StringBuilder("downloadPlugin fail : ").append(this.b.a);
        a.f(this.d);
        w.a(this.b.a, this.b.b, RePlugin.isPluginInstalled(this.c) ? "update" : "new", false);
        a.c(this.d, 4);
    }

    public final void a(int i) {
        if (a.g(this.d)) {
            a.a(this.d, (int) ((((float) i) / 1120403456) * 1119092736));
        } else {
            a.a(this.d, i);
        }
        a.b(this.d, a.a(this.d));
    }
}
