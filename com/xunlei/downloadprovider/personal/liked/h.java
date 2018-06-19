package com.xunlei.downloadprovider.personal.liked;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: LikeContentActivity */
final class h implements OnClickListener {
    final /* synthetic */ LikeContentActivity a;

    h(LikeContentActivity likeContentActivity) {
        this.a = likeContentActivity;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            if (this.a.c == 1 && this.a.l != null) {
                this.a.l.a();
            } else if (this.a.d == 1 && this.a.m != null) {
                this.a.m.a();
            }
        }
    }
}
