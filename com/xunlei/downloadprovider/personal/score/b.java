package com.xunlei.downloadprovider.personal.score;

import com.xunlei.downloadprovider.personal.score.h.a;

/* compiled from: UserScoreCenterActivity */
final class b implements a {
    final /* synthetic */ UserScoreCenterActivity a;

    b(UserScoreCenterActivity userScoreCenterActivity) {
        this.a = userScoreCenterActivity;
    }

    public final void a(o oVar) {
        UserScoreCenterActivity userScoreCenterActivity = this.a;
        boolean z = true;
        if (oVar.a != 1) {
            z = false;
        }
        userScoreCenterActivity.g = z;
        this.a.h.sendEmptyMessage(105);
    }

    public final void a() {
        this.a.h.sendEmptyMessage(106);
    }
}
