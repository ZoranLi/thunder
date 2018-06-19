package com.xunlei.downloadprovider.member.register.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: VerifyCodeDialog */
final class f implements OnClickListener {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            this.a.a.a();
            this.a.g.setVisibility(0);
        }
    }
}
