package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;

import android.app.Activity;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.banner.p;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.b;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: RedEnvelopeBannerPresenter */
final class d implements Runnable {
    final /* synthetic */ DownloadTaskInfo a;
    final /* synthetic */ RedPacketConditionsInfo b;
    final /* synthetic */ long c;
    final /* synthetic */ a d;

    d(a aVar, DownloadTaskInfo downloadTaskInfo, RedPacketConditionsInfo redPacketConditionsInfo, long j) {
        this.d = aVar;
        this.a = downloadTaskInfo;
        this.b = redPacketConditionsInfo;
        this.c = j;
    }

    public final void run() {
        a.a().c = false;
        if (this.d.a == null) {
            this.d.b();
        } else if (f.a((Activity) this.d.a.b())) {
            this.d.b();
        } else {
            a.a();
            if (a.b(this.a)) {
                this.d.b();
                return;
            }
            p pVar = this.d;
            DownloadTaskInfo downloadTaskInfo = this.a;
            RedPacketConditionsInfo redPacketConditionsInfo = this.b;
            long j = this.c;
            if (pVar.a != null) {
                long parseLong = Long.parseLong(redPacketConditionsInfo.count_down);
                pVar.a.a(0);
                downloadTaskInfo.mRemainderSeconds = parseLong;
                pVar.a.d();
                downloadTaskInfo.mHasShowRedEnvelopeBanner = true;
                a.a();
                a.a(true, downloadTaskInfo.getTaskId(), pVar);
                if (!(redPacketConditionsInfo == null || pVar.c)) {
                    com.xunlei.downloadprovider.download.report.a.i(redPacketConditionsInfo.user_type);
                    pVar.c = true;
                }
                a a = a.a();
                if (downloadTaskInfo != null) {
                    if (downloadTaskInfo.getTaskId() >= 0) {
                        PreferenceHelper preferenceHelper = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "red_envelope_first_count_down");
                        parseLong = System.currentTimeMillis();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(downloadTaskInfo.getTaskId());
                        preferenceHelper.putLong(stringBuilder.toString(), parseLong);
                    }
                }
                XLThreadPool.execute(new b(a, downloadTaskInfo, j));
            }
        }
    }
}
