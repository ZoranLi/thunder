package com.xunlei.download.proguard;

import android.content.Context;
import com.xunlei.download.DownloadManager;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.parameter.TorrentInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.vip_channel_v2.VipChannelV2Manager;

/* compiled from: Vip2TransBase */
public abstract class v {
    static final String h = "Vip2TransBase";
    protected Context i;
    protected d j;
    protected com.xunlei.download.proguard.z.a k;
    protected VipChannelV2Manager l;
    protected XLDownloadManager m;
    protected DownloadManager n;
    protected TorrentInfo o;
    protected int p;
    protected long q;
    protected long r;
    protected long s;
    protected int t = 0;
    protected String u = "";
    protected a v = a.Init;
    protected boolean w = false;
    b x;
    c y;

    /* compiled from: Vip2TransBase */
    enum a {
        Init,
        Requested,
        HasResulted,
        Error,
        Finish,
        Failure
    }

    /* compiled from: Vip2TransBase */
    public interface b {
        void a(int i, String str, String str2);

        void a(c cVar, int i);

        void a(c cVar, int i, int i2, int i3, int i4);
    }

    /* compiled from: Vip2TransBase */
    public enum c {
        TrialQuery,
        TrialCommit,
        TransResQuery,
        TransOffline
    }

    protected abstract int a(XLTaskInfo xLTaskInfo, int i, String str, String str2);

    protected void a(XLTaskInfo xLTaskInfo, int i) {
    }

    protected abstract int b();

    protected abstract int b(XLTaskInfo xLTaskInfo, int i, String str, String str2);

    public v(b bVar, c cVar) {
        this.x = bVar;
        this.y = cVar;
    }

    public void a(Context context, d dVar, com.xunlei.download.proguard.z.a aVar, TorrentInfo torrentInfo, VipChannelV2Manager vipChannelV2Manager, XLDownloadManager xLDownloadManager, DownloadManager downloadManager) {
        this.i = context;
        this.j = dVar;
        this.k = aVar;
        this.o = torrentInfo;
        this.l = vipChannelV2Manager;
        this.m = xLDownloadManager;
        this.n = downloadManager;
    }

    public void d() {
        if (a.Finish != this.v && a.Failure != this.v) {
            String str = h;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            stringBuilder.append("outter end transaction");
            an.a(str, stringBuilder.toString());
            this.p = 491;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.v = a.Error;
            b();
        }
    }

    public int c(XLTaskInfo xLTaskInfo, int i, String str, String str2) {
        if (a.Finish == this.v) {
            a(xLTaskInfo, i);
            return 200;
        } else if (a.Failure == this.v) {
            return this.p;
        } else {
            if (a.Init == this.v) {
                if (System.currentTimeMillis() < this.q) {
                    return 190;
                }
                this.u = String.format("RecId:%d,task[%d:%d] ", new Object[]{Long.valueOf(this.j.c), Long.valueOf(xLTaskInfo.mTaskId), Integer.valueOf(i)});
                String str3 = h;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.u);
                stringBuilder.append(String.format("init gcid:%s, cid:%s", new Object[]{str, str2}));
                an.a(str3, stringBuilder.toString());
                a();
                return a(xLTaskInfo, i, str, str2);
            } else if (a.Requested == this.v) {
                return b(xLTaskInfo, i, str, str2);
            } else {
                return b();
            }
        }
    }

    protected void a() {
        this.p = 200;
        this.q = 0;
        this.r = System.currentTimeMillis();
        this.s = this.r + 60000;
    }

    protected boolean d(XLTaskInfo xLTaskInfo, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.s) {
            return false;
        }
        xLTaskInfo = h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.u);
        stringBuilder.append("DetectResultTimeoutRetry");
        an.d(xLTaskInfo, stringBuilder.toString());
        this.v = a.Error;
        this.p = 491;
        this.x.a(this.y, i, 7104, -1, -1);
        this.q = null;
        if (this.t < 3) {
            this.t += 1;
            this.q = currentTimeMillis + 60000;
            xLTaskInfo = h;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.u);
            stringBuilder2.append(String.format("DetectResultTimeoutRetry: RetryTime:%d, request:%d/%d", new Object[]{Long.valueOf(this.q), Integer.valueOf(this.t), Integer.valueOf(3)}));
            an.a(xLTaskInfo, stringBuilder2.toString());
        }
        return true;
    }
}
