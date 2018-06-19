package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.downloadprovider.cardslide.u;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: DefaultJsInterface */
final class o implements k {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ DefaultJsInterface h;

    o(DefaultJsInterface defaultJsInterface, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.h = defaultJsInterface;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        if (shareOperationType == ShareOperationType.REPORT) {
            ReportActivity.a(this.h.getContext(), 1, this.a, this.b, this.c);
        }
        u.a(this.d, shareOperationType.getReportShareTo(), this.a, this.e, this.f);
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        this.h.callbackWithOneParam(this.g, "result", Integer.valueOf(i));
        u.a(this.d, shareOperationType.getReportShareTo(), i, i, this.a, this.e, this.f);
    }
}
