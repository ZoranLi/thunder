package com.xunlei.downloadprovider.download.downloadvod.a;

import android.os.SystemClock;
import com.aplayer.aplayerandroid.APlayerAndroid.OnOpenCompleteListener;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: DownloadVodNotifyManager */
final class g implements OnOpenCompleteListener {
    final /* synthetic */ TaskInfo a;
    final /* synthetic */ boolean b;
    final /* synthetic */ d c;

    g(d dVar, TaskInfo taskInfo, boolean z) {
        this.c = dVar;
        this.a = taskInfo;
        this.b = z;
    }

    public final void onOpenComplete(boolean z) {
        d.d;
        StringBuilder stringBuilder = new StringBuilder("bxbb onSchedule player onOpenComplete ");
        stringBuilder.append(z);
        stringBuilder.append(" path = ");
        stringBuilder.append(this.a.mLocalFileName);
        this.c.e = false;
        this.a.mRunningInfo.e = SystemClock.elapsedRealtime();
        if (z) {
            this.a.setVodStatus(2);
            this.c.a(this.a);
        } else {
            this.a.setVodStatus(3);
        }
        if (this.b) {
            this.c.d();
        }
    }
}
