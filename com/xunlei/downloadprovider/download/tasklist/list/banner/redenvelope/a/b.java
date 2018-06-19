package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;

import android.os.Handler;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.i;

/* compiled from: RedEnvelopeBannerPresenter */
final class b extends i {
    final /* synthetic */ a a;

    b(a aVar, Handler handler) {
        this.a = aVar;
        super(handler);
    }

    public final void a() {
        a aVar = this.a;
        if (aVar.a != null) {
            if (aVar.a.a() != null) {
                DownloadTaskInfo a = aVar.a.a();
                a.mRemainderSeconds--;
                long j = a.mRemainderSeconds;
                aVar.a.a(aVar.a(j));
                if (j <= -1) {
                    aVar.b();
                    a.a();
                    a.a(aVar.a.a());
                }
            }
        }
    }
}
