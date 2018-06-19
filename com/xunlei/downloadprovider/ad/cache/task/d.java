package com.xunlei.downloadprovider.ad.cache.task;

import android.os.Handler;
import android.os.HandlerThread;
import com.xunlei.downloadprovider.ad.cache.a.b;
import com.xunlei.downloadprovider.ad.cache.task.a.a;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;

/* compiled from: ExpireTask */
public final class d extends b implements a {
    private HandlerThread e = null;
    private Handler f = null;

    public d(b bVar) {
        super(bVar);
    }

    protected final void c(STYLES_INFO styles_info, int i) {
        super.c(styles_info, i);
        if (this.f != 0) {
            i = this.f.obtainMessage(1000);
            i.obj = styles_info;
            this.f.sendMessageDelayed(i, this.b.b());
        }
    }

    public final void c() {
        super.c();
        this.e = new HandlerThread("expired task");
        this.e.start();
        this.f = new Handler(this.e.getLooper(), new e(this));
        StringBuilder stringBuilder = new StringBuilder("expiredTime : ");
        stringBuilder.append(this.b.b());
        stringBuilder.append(" adType: ");
        stringBuilder.append(this.b.a());
        d();
        a.a().a(this);
    }

    public final void a() {
        d();
        for (STYLES_INFO styles_info : this.c) {
            new StringBuilder("onForeground trimCache stylesInfo: ").append(styles_info.name());
            this.b.a(styles_info);
        }
    }

    public final void b() {
        e();
        this.f.removeMessages(1000);
    }

    private void d() {
        e();
        this.f.sendEmptyMessageDelayed(1001, this.b.b());
    }

    private void e() {
        this.f.removeMessages(1001);
    }
}
