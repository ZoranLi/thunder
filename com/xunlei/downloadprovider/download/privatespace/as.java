package com.xunlei.downloadprovider.download.privatespace;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.ad.home.a.f;

/* compiled from: VerifyPrivateSpaceDialog */
final class as implements v$a {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    public final void a() {
        an.b("s", "");
        this.a.a.a.dismiss();
        this.a.a.a();
        v.a().a(false);
        PrivateSpaceMgr.a().d();
        if (this.a.a.c != null) {
            this.a.a.c.a();
        }
        this.a.a.dismiss();
    }

    public final void a(int i, String str) {
        an.b(f.a, String.valueOf(i));
        this.a.a.a.dismiss();
        XLToast.showToast(this.a.a.getContext(), str);
    }
}
