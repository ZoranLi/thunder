package com.xunlei.downloadprovider.download.privatespace;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.home.a.f;

/* compiled from: OpenPrivateSpaceTipDialog */
final class q implements v$a {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public final void a() {
        an.a("", "s", "open", this.a.a);
        this.a.b.c.dismiss();
        this.a.b.b.a();
        this.a.b.b.dismiss();
        PrivateSpaceMgr.a().a(true);
        if (this.a.b.a != null) {
            this.a.b.a.a();
        } else {
            XLToast.showToast(this.a.b.getContext(), this.a.b.getContext().getString(R.string.set_password_success));
        }
        this.a.b.dismiss();
    }

    public final void a(int i, String str) {
        an.a(String.valueOf(i), f.a, "open", this.a.a);
        this.a.b.c.dismiss();
        XLToast.showToast(this.a.b.getContext(), str);
    }
}
