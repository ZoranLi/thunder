package com.xunlei.downloadprovider.homepage.photoarticle;

import android.os.Build.VERSION;

/* compiled from: PhotoArticleDetailActivity */
final class p implements Runnable {
    final /* synthetic */ PhotoArticleDetailActivity a;

    p(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void run() {
        if (!((VERSION.SDK_INT >= 17 && this.a.isDestroyed()) || this.a.isFinishing() || this.a.j == null)) {
            if (this.a.i != null) {
                this.a.a();
            }
        }
    }
}
