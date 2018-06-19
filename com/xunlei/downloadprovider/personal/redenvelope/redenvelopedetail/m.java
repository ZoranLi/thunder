package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: RedWebTitleBar */
final class m implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ RedWebTitleBar b;

    m(RedWebTitleBar redWebTitleBar, Context context) {
        this.b = redWebTitleBar;
        this.a = context;
    }

    public final void onClick(View view) {
        if (this.b.d != null) {
            this.b.d;
        }
        ((Activity) this.a).finish();
    }
}
