package com.xunlei.downloadprovider.download.b;

import android.content.Context;
import com.umeng.message.proguard.k;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.h.f;

/* compiled from: DownloadCenterConfig */
public class b {
    private static volatile b a;
    private a b = new a();
    private boolean c = false;

    private b() {
        i();
        h();
    }

    private static b g() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public static void a() {
        g().i();
    }

    public static void b() {
        b g = g();
        int f = d.a().d.f();
        f.a(BrothersApplication.getApplicationInstance(), "download_tab_card_style_new", f);
        StringBuilder stringBuilder = new StringBuilder("Config: CardStyle = ");
        stringBuilder.append(g.b.b);
        stringBuilder.append(" (set ");
        stringBuilder.append(f);
        stringBuilder.append(k.t);
    }

    public static boolean c() {
        return d();
    }

    public static boolean d() {
        return g().b.a;
    }

    public static boolean e() {
        return d.a().d.q();
    }

    public static int f() {
        return g().b.b;
    }

    private void h() {
        a aVar = this.b;
        boolean z = this.b.a;
        aVar.a = f.b(BrothersApplication.getApplicationInstance(), "is_destination_downloadtab", z);
        aVar = this.b;
        int i = this.b.b;
        aVar.a(f.b(BrothersApplication.getApplicationInstance(), "download_tab_card_style", i));
    }

    private synchronized void i() {
        if (!this.c) {
            this.c = true;
            h();
            new StringBuilder("Config Old = ").append(this.b);
            String str = "is_destination_downloadtab";
            boolean b = f.b(BrothersApplication.getApplicationInstance(), str, this.b.a);
            Context applicationInstance = BrothersApplication.getApplicationInstance();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_new");
            boolean b2 = f.b(applicationInstance, stringBuilder.toString(), b);
            f.a(BrothersApplication.getApplicationInstance(), "is_destination_downloadtab", b2);
            this.b.a = b2;
            str = "download_tab_card_style";
            int b3 = f.b(BrothersApplication.getApplicationInstance(), str, this.b.b);
            applicationInstance = BrothersApplication.getApplicationInstance();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_new");
            int b4 = f.b(applicationInstance, stringBuilder.toString(), b3);
            f.a(BrothersApplication.getApplicationInstance(), "download_tab_card_style", b4);
            this.b.a(b4);
            new StringBuilder("Config Load = ").append(this.b);
        }
    }
}
