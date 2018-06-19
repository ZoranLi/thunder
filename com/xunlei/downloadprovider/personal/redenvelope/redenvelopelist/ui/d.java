package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import android.text.TextUtils;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e;

/* compiled from: RedEnvelopesActivity */
final class d implements c {
    final /* synthetic */ RedEnvelopesActivity a;

    d(RedEnvelopesActivity redEnvelopesActivity) {
        this.a = redEnvelopesActivity;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        if (taskInfo != null && i == -2) {
            taskInfo = this.a.h.a(taskInfo.getTaskDownloadUrl());
            e eVar = (e) this.a.h.c(taskInfo);
            if (eVar != null && TextUtils.isEmpty(eVar.j) == 0) {
                eVar.e = 2;
                this.a.h.notifyItemChanged(taskInfo);
                RedEnvelopesActivity.a(this.a, eVar);
            }
        }
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        if (taskInfo != null) {
            taskInfo = this.a.h.a(taskInfo.getTaskDownloadUrl());
            e eVar = (e) this.a.h.c(taskInfo);
            if (eVar != null && TextUtils.isEmpty(eVar.j) == 0) {
                eVar.e = 2;
                this.a.h.notifyItemChanged(taskInfo);
                RedEnvelopesActivity.a(this.a, eVar);
            }
        }
    }
}
