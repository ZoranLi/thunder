package com.xunlei.downloadprovider.download.privatespace;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.home.a.f;

/* compiled from: ClosePrivateSpaceTipDialog */
final class e implements v$a {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void a() {
        an.a("", "s", "close", "top_act_btn");
        this.a.a.a.dismiss();
        this.a.a.a();
        PrivateSpaceMgr.a().a(false);
        this.a.a.dismiss();
        XLToast.showToast(this.a.a.getContext(), this.a.a.getContext().getString(R.string.tip_private_space_is_close));
    }

    public final void a(int i, String str) {
        an.a(String.valueOf(i), f.a, "close", "top_act_btn");
        this.a.a.a.dismiss();
        XLToast.showToast(this.a.a.getContext(), str);
    }
}
