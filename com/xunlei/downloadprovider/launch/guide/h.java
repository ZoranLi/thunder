package com.xunlei.downloadprovider.launch.guide;

/* compiled from: GuideLoginHelper */
final class h implements com.xunlei.downloadprovider.member.login.b.h {
    final /* synthetic */ d a;

    h(d dVar) {
        this.a = dVar;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        d.e;
        z = new StringBuilder("OnRefreshUserInfoCompleted mNeedHandleBindMobileBiz: ");
        z.append(this.a.f);
        z.append(" errCode: ");
        z.append(i);
        this.a.b();
        if (this.a.f) {
            this.a.f = false;
            if (i == 0) {
                d.c(this.a);
            } else {
                this.a.a.f();
            }
        }
        this.a.a;
        m.m();
    }
}
