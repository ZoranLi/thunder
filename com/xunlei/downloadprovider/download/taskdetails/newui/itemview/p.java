package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: DetailShareBarViewHolder_New */
final class p implements k {
    final /* synthetic */ n a;

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
    }

    p(n nVar) {
        this.a = nVar;
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        if (this.a.a != null) {
            a.a(shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), fVar.j, this.a.a.mGCID, this.a.a.mTitle, this.a.a.getTaskDownloadUrl());
        }
    }
}
