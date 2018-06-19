package com.xunlei.downloadprovider.homepage.cinecism;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: CinecismDetailActivity */
final class s implements OnClickListener {
    final /* synthetic */ CinecismDetailActivity a;

    s(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            if ((this.a.f == null || this.a.g == null) && this.a.t == 1) {
                this.a.b(this.a.e);
            }
            if (TextUtils.isEmpty(this.a.q) == null && this.a.s == 1 && this.a.p != null) {
                this.a.o.show();
                this.a.r = false;
                this.a.p.a(this.a.q);
                this.a.s = 0;
            }
        }
    }
}
