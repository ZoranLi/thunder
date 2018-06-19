package com.xunlei.downloadprovider.download.taskdetails.newui;

import com.xunlei.downloadprovider.download.center.widget.DownloadCenterSelectFileTitleView.b;

/* compiled from: TaskDetailEditController */
final class ba implements b {
    final /* synthetic */ aw a;

    ba(aw awVar) {
        this.a = awVar;
    }

    public final void a(boolean z) {
        if (this.a.a != null) {
            this.a.a.a(z);
        }
        if (this.a.b) {
            this.a.b.notifyDataSetChanged();
            z = this.a.b;
            if (z.m != null) {
                z.m.a();
            }
        }
    }
}
