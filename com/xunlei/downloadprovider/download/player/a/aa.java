package com.xunlei.downloadprovider.download.player.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;

/* compiled from: DownloadVodPlayerController */
final class aa implements OnClickListener {
    final /* synthetic */ long a;
    final /* synthetic */ int b;
    final /* synthetic */ Context c;
    final /* synthetic */ TaskInfo d;
    final /* synthetic */ BTSubTaskInfo e;
    final /* synthetic */ String f;

    aa(long j, int i, Context context, TaskInfo taskInfo, BTSubTaskInfo bTSubTaskInfo, String str) {
        this.a = j;
        this.b = i;
        this.c = context;
        this.d = taskInfo;
        this.e = bTSubTaskInfo;
        this.f = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (m.P() != null) {
            m.a(this.a, this.b, true);
            VodPlayerActivityNew.a(this.c, this.d, this.e, this.f);
            m.P().dismiss();
            m.Q();
        }
    }
}
