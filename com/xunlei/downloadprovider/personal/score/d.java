package com.xunlei.downloadprovider.personal.score;

import android.os.Bundle;
import android.os.Message;
import com.xunlei.downloadprovider.personal.score.h.b;

/* compiled from: UserScoreCenterActivity */
final class d implements b {
    final /* synthetic */ UserScoreCenterActivity a;

    d(UserScoreCenterActivity userScoreCenterActivity) {
        this.a = userScoreCenterActivity;
    }

    public final void a(String str, String str2) {
        Message obtain = Message.obtain();
        obtain.what = 103;
        Bundle bundle = new Bundle(2);
        bundle.putString("extra_dui_ba_url", str);
        bundle.putString("extra_dui_ba_result", str2);
        obtain.setData(bundle);
        this.a.h.sendMessage(obtain);
    }

    public final void a() {
        this.a.h.sendEmptyMessage(104);
    }
}
