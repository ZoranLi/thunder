package com.xunlei.downloadprovider.download.tasklist.list.feed.b;

import android.content.Context;
import android.os.Handler;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import java.util.concurrent.TimeUnit;

/* compiled from: HomeDownloadCenterFeedRefreshController */
public final class c {
    public static final long a;
    private static boolean d = true;
    private Handler b = new Handler(new d(this));
    private Context c = null;
    private boolean e = false;
    private boolean f = false;
    private a g = null;

    public c(Context context, a aVar) {
        this.c = context;
        this.g = aVar;
    }

    public final void a(boolean z) {
        if (b.c()) {
            if (d.a().d.j()) {
                if (this.f != z) {
                    this.f = z;
                    if (this.f) {
                        if (d) {
                            d = false;
                        } else if (this.e) {
                            this.g.g.c();
                        }
                        this.b.removeMessages(1000);
                        this.e = false;
                        return;
                    }
                    this.b.sendEmptyMessageDelayed(1000, a);
                }
            }
        }
    }

    static {
        int k = d.a().d.k();
        if (k == 0) {
            k = 5;
        }
        a = TimeUnit.MINUTES.toMillis((long) k);
    }
}
