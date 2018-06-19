package com.xunlei.downloadprovider.contentpublish.website.view;

import android.view.View;
import com.xunlei.downloadprovider.homepage.recommend.a.a;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: WebsiteCardView */
final class j implements k {
    final /* synthetic */ View a;
    final /* synthetic */ i b;

    j(i iVar, View view) {
        this.b = iVar;
        this.a = view;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        fVar = shareOperationType.getReportShareTo();
        if (shareOperationType == ShareOperationType.REPORT) {
            ReportActivity.a(this.b.a.getContext(), 5, this.b.a.v.a, this.b.a.v.a, this.b.a.r.i());
        } else if (shareOperationType == ShareOperationType.DELETE) {
            this.b.a.t.onClick(this.a);
        }
        this.b.a.r.a(shareOperationType, this.b.a.v.a, fVar);
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        if (i == 0) {
            a.a().a(this.b.a.v.a, 5, "", "share_success");
            a.h(this.b.a);
        }
        this.b.a.r.a(i, shareOperationType);
    }
}
