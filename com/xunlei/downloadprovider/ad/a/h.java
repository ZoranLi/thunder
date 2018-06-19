package com.xunlei.downloadprovider.ad.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.xunlei.downloadprovider.ad.recommend.view.c;
import com.xunlei.downloadprovider.d.e;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import java.util.concurrent.TimeUnit;

/* compiled from: HomeDownloadCenterADLoadController */
public final class h {
    public static final long a;
    private static boolean d = true;
    private Handler b = new Handler(new i(this));
    private Context c = null;
    private boolean e = false;
    private boolean f = false;
    private a g = null;

    public h(Context context, a aVar) {
        this.c = context;
        this.g = aVar;
    }

    public static boolean a() {
        return b.c();
    }

    public static int b() {
        return b.f();
    }

    private void c() {
        if (c.h() && (this.c instanceof Activity)) {
            com.xunlei.downloadprovider.ad.recommend.a.h.a().a(new int[]{0});
        }
    }

    public final void a(boolean z) {
        if (b.c() && this.f != z) {
            this.f = z;
            if (this.f) {
                if (d) {
                    d = false;
                    a.a().a(0);
                    c();
                } else if (this.e) {
                    this.g.i();
                    this.g.j();
                    a.a().a(0);
                    c();
                }
                this.b.removeMessages(1000);
                this.e = false;
                return;
            }
            this.b.sendEmptyMessageDelayed(1000, a);
        }
    }

    static {
        e.a aVar = e.a().e;
        int i = 0;
        if (aVar.a != null) {
            i = aVar.a.optInt("ad_downloadlist_refresh_tick", 0);
        }
        if (i == 0) {
            i = 5;
        }
        a = TimeUnit.MINUTES.toMillis((long) i);
    }
}
