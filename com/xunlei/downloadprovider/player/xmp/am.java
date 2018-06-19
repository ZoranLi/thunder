package com.xunlei.downloadprovider.player.xmp;

import android.content.Context;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.homepage.recommend.WifiPopWindowReporter;
import com.xunlei.downloadprovider.homepage.recommend.WifiPopWindowReporter.PageFrom;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.xllib.android.b;

/* compiled from: XmpPlayerManager */
final class am extends a {
    final /* synthetic */ a a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ ak d;

    am(ak akVar, a aVar, Context context, String str) {
        this.d = akVar;
        this.a = aVar;
        this.b = context;
        this.c = str;
    }

    public final void b() {
        this.d.g = false;
        this.a.b();
        if (this.b instanceof ShortMovieDetailActivity) {
            WifiPopWindowReporter.a(PageFrom.VIDEO_DEITAIL, b.c(BrothersApplication.getApplicationInstance()), this.c, 0);
            return;
        }
        if (this.b instanceof MainTabActivity) {
            WifiPopWindowReporter.a(PageFrom.FEED_FLOW, b.c(BrothersApplication.getApplicationInstance()), this.c, 0);
        }
    }

    public final void a() {
        if (b.d(this.b)) {
            this.d.g = true;
        }
        this.a.a();
        if (this.b instanceof ShortMovieDetailActivity) {
            WifiPopWindowReporter.a(PageFrom.VIDEO_DEITAIL, b.c(BrothersApplication.getApplicationInstance()), this.c, 1);
            return;
        }
        if (this.b instanceof MainTabActivity) {
            WifiPopWindowReporter.a(PageFrom.FEED_FLOW, b.c(BrothersApplication.getApplicationInstance()), this.c, 1);
        }
    }
}
