package com.xunlei.downloadprovider.download.downloadvod;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.b;
import com.xunlei.downloadprovider.download.engine.task.m;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.x.a;
import com.xunlei.xllib.b.k;
import java.io.File;

/* compiled from: DownloadVodImpl */
class a$b extends a$a {
    public String c;
    public String d;
    public String e;
    public long f = 0;
    public String g;
    boolean h = false;
    int i = -1;
    volatile DownloadVodInfo j = new DownloadVodInfo();
    g k;
    @NonNull
    a l;
    private String m;

    public a$b(@NonNull a aVar, String str, String str2, String str3, long j, String str4, String str5, g gVar) {
        this.l = aVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = j;
        this.g = str4;
        this.m = str5;
        this.k = gVar;
        this.a = false;
    }

    private String c() {
        String str = "";
        if (this.m == null) {
            return str;
        }
        str = this.m;
        Object obj = -1;
        if (str.hashCode() == -1102370341) {
            if (str.equals("lixian")) {
                obj = null;
            }
        }
        return obj != null ? "bxbb/bxbb" : "space/space_lixian_bxbb";
    }

    final void b() {
        new StringBuilder("request url = ").append(this.c);
        this.i = 0;
        String str = this.c;
        if (TextUtils.isEmpty(str)) {
            this.i = -1;
            d();
            return;
        }
        this.j.mSourceUrl = str;
        this.j.mPlayUrl = str;
        if (str.contains("://127.0.0.1")) {
            d();
        } else if (str.startsWith("/")) {
            this.j.mIsLocalPlay = true;
            n.a();
            b i = n.i(str);
            if (i != null && i.a() > 0) {
                this.j.mTaskId = i.a();
                this.j.mBtSubIndex = i.b();
                n.a();
                TaskInfo f = n.f(i.a());
                if (f == null || f.getTaskStatus() != 8) {
                    this.j.mIsLocalPlay = false;
                    a(f, i.d());
                    return;
                }
            }
            d();
        } else {
            if (this.c.startsWith("bt://")) {
                str = com.xunlei.downloadprovider.download.engine.util.b.a(this.d, this.f, this.e, this.g);
                this.j.mSourceUrl = str;
            }
            String str2 = str;
            n.a();
            long e = n.e(str2);
            if (e > 0) {
                this.j.mTaskId = e;
                n.a();
                a(n.f(e), null);
                return;
            }
            this.i = -1;
            a dVar = new d(this);
            str = this.g;
            long j = this.f;
            m mVar = new m(dVar);
            if (!TextUtils.isEmpty(str2)) {
                String stringBuilder;
                if (!(TextUtils.isEmpty(str) || str.contains("."))) {
                    String d = k.d(str2);
                    if (!TextUtils.isEmpty(d) && d.contains(".")) {
                        d = d.substring(d.lastIndexOf("."));
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str);
                        stringBuilder2.append(d);
                        stringBuilder = stringBuilder2.toString();
                        mVar.a(str2, stringBuilder, j, c());
                    }
                }
                stringBuilder = str;
                mVar.a(str2, stringBuilder, j, c());
            }
            com.xunlei.downloadprovider.download.engine.report.a.a(c());
            n.a().a(mVar, new f(this));
        }
    }

    public final void a() {
        this.a = true;
        this.k = null;
        new StringBuilder("cancel request url = ").append(this.c);
    }

    private void d() {
        if (!this.a) {
            this.l.a(new c(this));
        }
    }

    final void a(@Nullable TaskInfo taskInfo, @Nullable BTSubTaskInfo bTSubTaskInfo) {
        this.i = -1;
        if (taskInfo != null) {
            if (!this.a) {
                if (bTSubTaskInfo != null) {
                    n.a();
                    bTSubTaskInfo = n.c(bTSubTaskInfo.mLocalFileName);
                } else {
                    n.a();
                    bTSubTaskInfo = n.c(taskInfo.mLocalFileName);
                }
                boolean z = this.h;
                if (z) {
                    a.setDownloadVodAllowMobileNetwork(taskInfo.getTaskId());
                }
                if (TextUtils.isEmpty(bTSubTaskInfo)) {
                    if (TextUtils.isEmpty(taskInfo.mLocalFileName) != null) {
                        n.a().c(taskInfo.getTaskId());
                        try {
                            Thread.sleep(1000);
                        } catch (BTSubTaskInfo bTSubTaskInfo2) {
                            bTSubTaskInfo2.printStackTrace();
                        }
                    } else {
                        if (taskInfo.getTaskStatus() != 4) {
                            if (taskInfo.getTaskStatus() != 16) {
                                if (taskInfo.getTaskStatus() == 8) {
                                    try {
                                        if (new File(taskInfo.mLocalFileName).exists() == null) {
                                            n.a();
                                            n.a(z, new long[]{taskInfo.getTaskId()});
                                        }
                                    } catch (BTSubTaskInfo bTSubTaskInfo22) {
                                        bTSubTaskInfo22.printStackTrace();
                                    }
                                }
                            }
                        }
                        n.a();
                        n.b(z, new long[]{taskInfo.getTaskId()});
                    }
                    if (this.a == null) {
                        n.a().c(taskInfo.getTaskId());
                        bTSubTaskInfo22 = null;
                        while (bTSubTaskInfo22 < 15) {
                            bTSubTaskInfo22++;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (!this.a) {
                                n.a();
                                Object c = n.c(taskInfo.mLocalFileName);
                                if (!TextUtils.isEmpty(c)) {
                                    this.i = 0;
                                    this.j.mPlayUrl = c;
                                    this.j.mTaskId = taskInfo.getTaskId();
                                    this.j.mCID = taskInfo.mCID;
                                    this.j.mGCID = taskInfo.mGCID;
                                    this.j.mFileSize = taskInfo.mFileSize;
                                    n.a().c(-1);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    return;
                }
                this.i = 0;
                this.j.mPlayUrl = bTSubTaskInfo22;
                d();
                return;
            }
        }
        d();
    }
}
