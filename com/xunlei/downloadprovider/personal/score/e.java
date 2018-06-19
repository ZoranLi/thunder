package com.xunlei.downloadprovider.personal.score;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.user.f;

/* compiled from: UserScoreCenterActivity */
final class e implements OnClickListener {
    final /* synthetic */ p a;
    final /* synthetic */ int b;
    final /* synthetic */ UserScoreCenterActivity c;

    e(UserScoreCenterActivity userScoreCenterActivity, p pVar, int i) {
        this.c = userScoreCenterActivity;
        this.a = pVar;
        this.b = i;
    }

    public final void onClick(View view) {
        this.a.dismiss();
        f.b(String.valueOf(this.b));
    }
}
