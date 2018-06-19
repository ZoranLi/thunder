package com.xunlei.downloadprovider.cooperation.ui;

import android.content.Context;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;

/* compiled from: CooperationController */
public final class f implements Runnable {
    final /* synthetic */ b a;

    public f(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        n.a();
        if (n.c()) {
            Context c = AppStatusChgObserver.b().c();
            if (c != null) {
                new StringBuilder("showRemainStorageCooperationSceneDialog: ").append(c);
                b bVar = this.a;
                if ((c instanceof ShortMovieDetailActivity) && !bVar.c) {
                    return;
                }
                if (bVar.e) {
                    if (q.a(c)) {
                        bVar.e = false;
                    }
                } else if (!q.a(c)) {
                    bVar.a(c, 1001);
                }
            }
        }
    }
}
