package com.xunlei.downloadprovider.ad.taskdetailnew.banner;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.a;
import android.arch.lifecycle.g;
import android.view.View;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.report.c;
import com.xunlei.downloadprovider.ad.common.report.e;
import com.xunlei.downloadprovider.ad.taskdetailnew.b;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.player.a.f;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import java.util.concurrent.TimeUnit;

public class TaskDetailNewBannerAdController extends f implements a {
    private static final long g = TimeUnit.SECONDS.toMillis(6);
    public f a = new f();
    public a b = null;
    public boolean c = false;
    public c<Boolean> d;
    private com.xunlei.downloadprovider.ad.splash.a h = new a(this, g, g);
    private boolean i = false;
    private boolean j = false;
    private final g k = new g();

    public final void d() {
    }

    @g(a = Event.ON_CREATE)
    public void onCreate() {
    }

    public TaskDetailNewBannerAdController(com.xunlei.downloadprovider.download.player.a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        super(aVar, downloadVodPlayerView);
    }

    public final void a(DownloadTaskInfo downloadTaskInfo) {
        this.a.d = downloadTaskInfo;
        if (this.c == null) {
            this.c = true;
            TaskInfo taskInfo = this.a.d;
            if (taskInfo == null) {
                downloadTaskInfo = new c(Boolean.valueOf(false), e.a(-1, "taskInfo is empty"));
            } else {
                if (k.d(taskInfo)) {
                    if (!b.f()) {
                        downloadTaskInfo = new c(Boolean.valueOf(false), e.a(-1, "downloaded task's ad disabled"));
                    }
                } else if (!b.e()) {
                    downloadTaskInfo = new c(Boolean.valueOf(false), e.a(-1, "undownload task's ad disabled"));
                }
                downloadTaskInfo = new c(Boolean.valueOf(true), null);
            }
            this.d = downloadTaskInfo;
        }
        this.a.c = com.xunlei.downloadprovider.ad.taskdetailnew.c.a().a(THUNDER_AD_INFO.TASK_DETAIL_NEW_BANNER);
    }

    public final void h_() {
        f fVar = this.a;
        fVar.c = null;
        fVar.d = null;
        fVar.a = false;
        fVar.b = false;
        this.i = false;
        this.j = false;
        this.h.b();
        this.k.a.clear();
        this.c = false;
        this.d = null;
    }

    public final void i_() {
        if (!this.j) {
            this.j = true;
            a(new b(this));
        }
    }

    public final void a(String str) {
        if (!this.j) {
            this.j = true;
            a(new c(this, str));
        }
    }

    public final void a(e eVar) {
        if (!this.i) {
            this.i = true;
            new StringBuilder("noShow. errorInfo: ").append(eVar);
            a(new d(this, eVar));
        }
    }

    public final void a(View view) {
        if (!this.i && this.a.c != null) {
            this.i = true;
            a(new e(this, view));
            this.h.c();
        }
    }

    public final void j_() {
        if (this.b != null) {
            this.b.a();
        }
    }

    public final void a(boolean z) {
        super.a(z);
        if (!z) {
            z = this.k.a.iterator();
            while (z.hasNext()) {
                ((g.a) z.next()).a();
                z.remove();
            }
        }
    }

    private void a(g.a aVar) {
        new StringBuilder("handleReport. mIsFullScreen: ").append(this.f);
        if (this.f) {
            this.k.a.add(aVar);
        } else {
            aVar.a();
        }
    }

    @g(a = Event.ON_DESTROY)
    public void onDestroy() {
        h_();
    }
}
