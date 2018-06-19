package com.xunlei.downloadprovider.ad.a;

import android.os.Handler;
import com.xunlei.downloadprovider.ad.recommend.a.h;
import com.xunlei.downloadprovider.ad.recommend.view.c;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

/* compiled from: DownloadCenterADLoadController */
public final class e {
    public static final long a;
    private static e h;
    public Map<Integer, a> b;
    public int c;
    private Handler d;
    private boolean e;
    private boolean f;
    private boolean g;

    private e() {
        this.d = new Handler(new f(this));
        this.e = true;
        this.f = false;
        this.g = false;
        this.b = null;
        this.c = 0;
        this.b = new HashMap(3);
    }

    public static e a() {
        if (h == null) {
            h = new e();
        }
        return h;
    }

    public static void b() {
        a().d.removeCallbacksAndMessages(null);
        h = null;
    }

    public final void a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("setOnUserVisible. visible: ");
        stringBuilder.append(z);
        stringBuilder.append(" mCurrentIndex: ");
        stringBuilder.append(this.c);
        if (this.g != z) {
            this.g = z;
            if (this.g) {
                int i = this.c;
                if (this.e) {
                    this.e = false;
                } else if (this.f) {
                    c();
                    a(i);
                }
                this.d.removeMessages(1000);
                this.f = false;
                return;
            }
            this.d.sendEmptyMessageDelayed(1000, a);
        }
    }

    public static void a(int i) {
        if (d.a(i)) {
            i = d.b(i);
            if (c.h()) {
                h.a().a(new int[]{i});
            }
            a.a().a(i);
        }
    }

    private void c() {
        for (Entry value : this.b.entrySet()) {
            a aVar = (a) value.getValue();
            aVar.i();
            aVar.j();
        }
    }

    static /* synthetic */ void c(e eVar) {
        for (Entry value : eVar.b.entrySet()) {
            a aVar = (a) value.getValue();
            aVar.c();
            aVar.d();
        }
    }

    static {
        com.xunlei.downloadprovider.d.e.a aVar = com.xunlei.downloadprovider.d.e.a().e;
        int i = 0;
        if (aVar.a != null) {
            i = aVar.a.optInt("ad_download_center_refresh_tick", 0);
        }
        if (i == 0) {
            i = 5;
        }
        a = TimeUnit.MINUTES.toMillis((long) i);
    }
}
