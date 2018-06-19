package com.xunlei.downloadprovider.ad.a.a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.c.a;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;

/* compiled from: FeedLargeImgHolder */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.mAdapter.g != null) {
            this.a.mAdapter.g.k = false;
        }
        if (this.a.d != null && this.a.a != null) {
            this.a.d.onClick(this.a.a);
            if (this.a.d.w() != null) {
                view = this.a.d.s();
                if (!TextUtils.isEmpty(view)) {
                    TaskStatInfo taskStatInfo = new TaskStatInfo(a.a(this.a.d), view, null);
                    DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                    downloadAdditionInfo.b = this.a.d.p();
                    downloadAdditionInfo.a = this.a.d.o();
                    downloadAdditionInfo.f = true;
                    g.a();
                    g.a(view, this.a.d.o(), taskStatInfo, downloadAdditionInfo);
                }
            }
            String z = this.a.d.z();
            view = new StringBuilder();
            view.append(this.a.mAdapter.b(this.a.e));
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.b(this.a.d.u, this.a.mAdapter.a(), "ad", "", z, view.toString(), this.a.d.e(), this.a.d.y(), this.a.d.a(), this.a.d.A(), "1", this.a.d.H);
        }
    }
}
