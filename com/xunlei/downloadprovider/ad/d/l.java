package com.xunlei.downloadprovider.ad.d;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.home.a;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;

/* compiled from: ShortMoviePlayCompleteADCtr */
final class l implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ i b;

    l(i iVar, View view) {
        this.b = iVar;
        this.a = view;
    }

    public final void onClick(View view) {
        if (this.b.c == null) {
            a.a(this.b.a, "video_detail_player_button");
        }
        this.b.a.onClick(this.a);
        if (this.b.c == null) {
            this.b.a("adv_bigvideo_detail_click");
        }
        if (this.b.a.w() != null) {
            view = this.b.a.s();
            if (!TextUtils.isEmpty(view)) {
                DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                downloadAdditionInfo.b = this.b.a.p();
                downloadAdditionInfo.a = this.b.a.o();
                downloadAdditionInfo.f = true;
                TaskStatInfo taskStatInfo = new TaskStatInfo(view, null);
                taskStatInfo.a = com.xunlei.downloadprovider.ad.common.c.a.a(this.b.a);
                g.a();
                g.a(view, this.b.a.o(), taskStatInfo, downloadAdditionInfo);
            }
        }
    }
}
