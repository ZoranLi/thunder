package com.xunlei.downloadprovider.personal.score;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.xllib.android.b;

/* compiled from: UserScoreCenterActivity */
final class g implements OnClickListener {
    final /* synthetic */ UserScoreCenterActivity a;

    g(UserScoreCenterActivity userScoreCenterActivity) {
        this.a = userScoreCenterActivity;
    }

    public final void onClick(View view) {
        if (b.a(this.a.getApplicationContext()) == null) {
            XLToast.showToast(this.a.getApplicationContext(), "无网络连接");
            return;
        }
        this.a.e.setVisibility(8);
        this.a.d.show();
        if (this.a.g != null) {
            this.a.d();
        } else if (this.a.f != null) {
            this.a.b();
        } else {
            this.a.a();
        }
    }
}
