package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;

import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: RedEnvelopeBannerPresenter */
final class f extends c {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (z && "RedEnvelopeBannerPresenter".equals(obj)) {
            z = this.a;
            z.b();
            if (z.a != 0) {
                a.a();
                a.a(z.a.a());
                RedPacketConditionsInfo e = z.a.e();
                if (e != 0) {
                    DownloadTaskInfo a = z.a.a();
                    if (a != null) {
                        if (e.redpack_type.contains("7")) {
                            a.a();
                            a.a(a, e, z.d);
                            return;
                        }
                        z.a.c();
                    }
                }
            }
        }
    }
}
