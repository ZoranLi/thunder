package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.downloadprovider.cardslide.u;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: DefaultJsInterface */
final class p implements k {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ DefaultJsInterface f;

    p(DefaultJsInterface defaultJsInterface, String str, String str2, String str3, String str4, String str5) {
        this.f = defaultJsInterface;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        u.a(this.a, shareOperationType.getReportShareTo(), this.b, this.c, this.d);
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        this.f.callbackWithOneParam(this.e, "result", Integer.valueOf(i));
        u.a(this.a, shareOperationType.getReportShareTo(), i, i, this.b, this.c, this.d);
    }
}
