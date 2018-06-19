package com.xunlei.downloadprovider.shortvideo.ui;

import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView.a;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: PlayerUgcView */
final class k implements a {
    final /* synthetic */ a a;

    k(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        this.a.n();
        a aVar = this.a;
        int b = (aVar.getPlayer() == null || aVar.getPlayer().i == null) ? 0 : aVar.getPlayer().i.b();
        aVar.d.a("success", "", b);
    }

    public final void a(String str) {
        a aVar = this.a;
        int b = (aVar.getPlayer() == null || aVar.getPlayer().i == null) ? 0 : aVar.getPlayer().i.b();
        aVar.d.a("fail", str, b);
    }

    public final void a(boolean z) {
        r rVar = this.a.d;
        a aVar = this.a;
        int i = 0;
        boolean z2 = aVar.b.C != null && aVar.b.C.getVisibility() == 0;
        rVar.a(z2);
        if (!z) {
            if (this.a.getPlayer() && this.a.getPlayer().i) {
                i = this.a.getPlayer().i.b();
            }
            this.a.d.a("skip_login", "", i);
        }
    }

    public final LoginFrom b() {
        return this.a.d.i();
    }
}
