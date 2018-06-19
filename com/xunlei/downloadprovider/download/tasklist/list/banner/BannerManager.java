package com.xunlei.downloadprovider.download.tasklist.list.banner;

import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadlib.android.XLUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.c.a;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.tasklist.list.banner.a.i;
import com.xunlei.downloadprovider.download.tasklist.list.banner.d.d;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class BannerManager {
    private static BannerManager c;
    public a a = null;
    private List<Long> b = new ArrayList();

    private BannerManager() {
    }

    public static BannerManager a() {
        if (c == null) {
            synchronized (BannerManager.class) {
                if (c == null) {
                    c = new BannerManager();
                }
            }
        }
        return c;
    }

    public final void a(boolean z, BannerType bannerType, long j, p pVar) {
        if (z) {
            if (this.a) {
                this.a.a();
            } else {
                this.a = new a(this);
            }
            z = this.a;
            z.a = bannerType;
            z.b = j;
            z.c = pVar;
            if (j >= false && !this.b.contains(Long.valueOf(j))) {
                this.b.add(Long.valueOf(j));
            }
            return;
        }
        if (this.a && this.a.a == bannerType && this.a.b == j) {
            this.a.a();
        }
    }

    public static boolean a(DownloadTaskInfo downloadTaskInfo) {
        if (downloadTaskInfo.mFreeTrialTimes <= 0 || downloadTaskInfo.mFileSize < 209715200) {
            return true;
        }
        if ((downloadTaskInfo.mFileSize > 0 && (((float) downloadTaskInfo.mDownloadedSize) * 1.0f) / ((float) downloadTaskInfo.mFileSize) > 0.7f) || !a.a().e(downloadTaskInfo.getTaskId()) || LoginHelper.a().g.g()) {
            return true;
        }
        LoginHelper.a();
        boolean z = ((l.b() && LoginHelper.a().l()) || a.a().b(downloadTaskInfo.getTaskId())) ? false : true;
        if (!z) {
            return true;
        }
        long j = a.a().e;
        if (downloadTaskInfo.getTaskId() == j || j == -1) {
            return a.a().a(downloadTaskInfo.getTaskId()) != null ? false : false;
        } else {
            return true;
        }
    }

    public final boolean a(BannerType bannerType, long j) {
        if (this.a != null) {
            boolean z;
            a aVar = this.a;
            if (aVar.b != -1) {
                if (aVar.a != null) {
                    z = false;
                    if (z) {
                        if (bannerType != this.a.a && j == this.a.b) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            z = true;
            if (z) {
                if (bannerType != this.a.a) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final void a(TaskInfo taskInfo) {
        if (this.a != null) {
            if (taskInfo != null) {
                if (this.a.b == taskInfo.getTaskId()) {
                    this.a.a();
                }
                if (taskInfo.mHasShowRedEnvelopeBanner) {
                    com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                    com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a(taskInfo);
                }
            }
        }
    }

    public final void b() {
        this.b.clear();
        com.xunlei.downloadprovider.download.tasklist.list.banner.e.a.a().a = false;
        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a().d = false;
        a a = a.a();
        if (a.h != null) {
            a.h.clear();
        }
        d a2 = d.a();
        if (a2.d != null) {
            a2.d.clear();
        }
        if (a2.e != null) {
            a2.e.clear();
        }
        if (this.a != null && this.a.c != null) {
            this.a.c.b();
        }
    }

    public static void a(JSONObject jSONObject) {
        new PreferenceHelper(BrothersApplication.getApplicationInstance(), "redEnvelopeSP").putString("redEnvelopeJson", jSONObject.toString());
        i.a();
    }

    public static void a(DownloadTaskInfo downloadTaskInfo, RedPacketConditionsInfo redPacketConditionsInfo, com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a aVar) {
        a.a(downloadTaskInfo, redPacketConditionsInfo, 0, true, aVar);
    }

    public static List<RedPacketConditionsInfo> d() {
        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
        return com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.c();
    }

    public static String f() {
        return XLUtil.getPeerid(BrothersApplication.getApplicationInstance());
    }

    public static void c() {
        XLThreadPool.execute(new b());
    }

    public static void a(RedPacketConditionsInfo redPacketConditionsInfo, DownloadTaskInfo downloadTaskInfo, com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a aVar) {
        if (downloadTaskInfo != null) {
            if (redPacketConditionsInfo != null) {
                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a().c = true;
                XLThreadPool.execute(new e(downloadTaskInfo, redPacketConditionsInfo, aVar));
                return;
            }
        }
        aVar.a();
    }

    public static void e() {
        XLThreadPool.execute(new j());
    }

    public static void g() {
        XLThreadPool.execute(new m());
    }
}
