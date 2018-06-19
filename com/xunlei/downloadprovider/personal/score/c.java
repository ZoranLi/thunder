package com.xunlei.downloadprovider.personal.score;

import android.os.Bundle;
import android.os.Message;
import com.xunlei.downloadprovider.personal.score.h.a;

/* compiled from: UserScoreCenterActivity */
final class c implements a {
    final /* synthetic */ UserScoreCenterActivity a;

    c(UserScoreCenterActivity userScoreCenterActivity) {
        this.a = userScoreCenterActivity;
    }

    public final void a(o oVar) {
        Message obtain = Message.obtain();
        obtain.what = 101;
        Bundle bundle = new Bundle(2);
        bundle.putInt("extra_signed", oVar.a);
        bundle.putInt("extra_continues_sign", oVar.b);
        obtain.setData(bundle);
        this.a.h.sendMessage(obtain);
    }

    public final void a() {
        this.a.h.sendEmptyMessage(102);
    }
}
