package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.c.a;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.taskdetailnew.banner.TaskDetailNewBannerAdController;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;

/* compiled from: DetailBannerAdViewHolder */
final class c implements OnClickListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        TaskDetailNewBannerAdController taskDetailNewBannerAdController = this.a.a;
        this.a.itemView.getContext();
        if (taskDetailNewBannerAdController.a.c != null) {
            taskDetailNewBannerAdController.a.c.onClick(view);
            if (f.a(taskDetailNewBannerAdController.a.c) != null && taskDetailNewBannerAdController.a.c.u() == 2) {
                view = taskDetailNewBannerAdController.a.c;
                if (!TextUtils.isEmpty(view.s())) {
                    String s = view.s();
                    TaskStatInfo taskStatInfo = new TaskStatInfo(s, null);
                    taskStatInfo.a = a.a(view);
                    DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                    downloadAdditionInfo.b = view.p();
                    downloadAdditionInfo.a = view.o();
                    downloadAdditionInfo.f = true;
                    g.a();
                    g.a(s, view.o(), taskStatInfo, downloadAdditionInfo);
                }
            }
        }
    }
}
