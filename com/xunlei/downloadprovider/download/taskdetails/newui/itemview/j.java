package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.control.p;
import com.xunlei.downloadprovider.download.downloadvod.a;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;

/* compiled from: DetailBtSubTaskViewHolder */
final class j implements OnClickListener {
    final /* synthetic */ DownloadTaskInfo a;
    final /* synthetic */ BTSubTaskItem b;
    final /* synthetic */ g c;

    j(g gVar, DownloadTaskInfo downloadTaskInfo, BTSubTaskItem bTSubTaskItem) {
        this.c = gVar;
        this.a = downloadTaskInfo;
        this.b = bTSubTaskItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.setDownloadVodAllowMobileNetwork(this.a.getTaskId());
        p.a().a(this.a, true);
        if (this.c.a(this.b) == null) {
            m.a(this.c.d.getTaskId(), this.b.mBTSubIndex, false);
            VodPlayerActivityNew.a(this.c.c(), this.c.d, this.b, "download_detail_new");
        }
    }
}
