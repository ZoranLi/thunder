package com.xunlei.downloadprovider.download.tasklist.list.banner.f;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.g;

/* compiled from: VoucherPacketBanner */
final class e implements g {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void onLogout() {
        LoginHelper.a().b(this.a.e);
        f.a().m();
    }
}
