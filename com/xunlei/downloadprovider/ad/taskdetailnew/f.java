package com.xunlei.downloadprovider.ad.taskdetailnew;

import android.text.TextUtils;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.report.c;
import com.xunlei.downloadprovider.ad.common.report.d;
import com.xunlei.downloadprovider.ad.common.report.e;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: TaskDetailNewImageAdController */
public final class f {
    private static final long c = TimeUnit.SECONDS.toMillis(2);
    public b a = null;
    public int b = 0;
    private i d;
    private l e = null;
    private com.xunlei.downloadprovider.ad.splash.a f;

    /* compiled from: TaskDetailNewImageAdController */
    public interface b {
        void a(boolean z);
    }

    /* compiled from: TaskDetailNewImageAdController */
    private class a extends com.xunlei.downloadprovider.ad.splash.a {
        final /* synthetic */ f f;

        public a(f fVar, long j, long j2) {
            this.f = fVar;
            super(j, j2);
        }

        public final void c() {
            super.c();
        }

        public final void d() {
            super.d();
        }

        public final void a(long j) {
            CharSequence string;
            if (j > f.c) {
                string = BrothersApplication.getApplicationInstance().getResources().getString(R.string.task_detail_new_ad_closer_close_tips);
                this.f.d.b(false);
            } else {
                string = BrothersApplication.getApplicationInstance().getResources().getString(R.string.task_detail_new_ad_closer_close_tips);
                this.f.d.b(true);
            }
            this.f.d.e.setText(string);
            i b = this.f.d;
            j = ((int) TimeUnit.MILLISECONDS.toSeconds(j)) - 1;
            if (j >= null && j < i.a.length) {
                b.f.setImageResource(i.a[j]);
            }
        }

        public final void a() {
            this.f.a(false);
        }
    }

    public f(i iVar) {
        this.d = iVar;
        this.d.b(false);
        iVar = this.d;
        iVar.c.setOnClickListener(new g(this));
        iVar = this.d;
        iVar.d.setOnClickListener(new h(this));
        this.f = new a(this, TimeUnit.SECONDS.toMillis(6), TimeUnit.SECONDS.toMillis(1));
    }

    public final boolean a(DownloadTaskInfo downloadTaskInfo) {
        this.b++;
        com.xunlei.downloadprovider.ad.common.report.b bVar = new com.xunlei.downloadprovider.ad.common.report.b(THUNDER_AD_INFO.TASK_DETAIL_NEW_IMAGE.mPositionId);
        bVar.putExtra("rn", String.valueOf(this.b));
        downloadTaskInfo = b(downloadTaskInfo);
        if (((Boolean) downloadTaskInfo.a).booleanValue()) {
            d.a(bVar);
            downloadTaskInfo = c.a().a(THUNDER_AD_INFO.TASK_DETAIL_NEW_IMAGE);
            new StringBuilder("showAd. adInfo != null: ").append(downloadTaskInfo != null);
            if (downloadTaskInfo == null) {
                return false;
            }
            this.e = downloadTaskInfo;
            this.d.c.setImageBitmap(downloadTaskInfo.t);
            this.d.a(false);
            a(0);
            downloadTaskInfo = this.e;
            Map hashMap = new HashMap();
            hashMap.put("rn", String.valueOf(this.b));
            downloadTaskInfo.E = hashMap;
            this.e.a(this.d.b);
            this.f.b();
            this.f.c();
            return true;
        }
        d.a(bVar, downloadTaskInfo.b.b);
        return false;
    }

    public final void a(boolean z) {
        l lVar = this.e;
        this.e = null;
        this.f.d();
        if (z && lVar != null) {
            b(lVar);
            lVar.a(new com.xunlei.downloadprovider.ad.common.b.a("manual"));
        }
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public final void a(int i) {
        this.d.b.setVisibility(i);
    }

    protected static void a(l lVar) {
        if (!TextUtils.isEmpty(lVar.s())) {
            String s = lVar.s();
            TaskStatInfo taskStatInfo = new TaskStatInfo(s, null);
            taskStatInfo.a = com.xunlei.downloadprovider.ad.common.c.a.a(lVar);
            DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
            downloadAdditionInfo.b = lVar.p();
            downloadAdditionInfo.a = lVar.o();
            downloadAdditionInfo.f = true;
            g.a();
            g.a(s, lVar.o(), taskStatInfo, downloadAdditionInfo);
        }
    }

    private void b(l lVar) {
        Map hashMap = new HashMap();
        hashMap.put("show_time", String.valueOf(System.currentTimeMillis() - this.f.d));
        hashMap.put("rn", String.valueOf(this.b));
        lVar.G = hashMap;
        lVar.F = hashMap;
    }

    public static c<Boolean> b(DownloadTaskInfo downloadTaskInfo) {
        if (downloadTaskInfo == null) {
            return new c(Boolean.valueOf(false), e.a(-1, "taskInfo is empty"));
        }
        if (k.d(downloadTaskInfo) != null) {
            if (b.c() == null) {
                return new c(Boolean.valueOf(false), e.a(-1, "downloaded task's ad disabled"));
            }
        } else if (b.b() == null) {
            return new c(Boolean.valueOf(false), e.a(-1, "undownload task's ad disabled"));
        }
        return new c(Boolean.valueOf(true), null);
    }
}
