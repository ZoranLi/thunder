package com.xunlei.downloadprovider.personal.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: MessageItemFragment */
final class v implements OnClickListener {
    final /* synthetic */ MessageItemFragment a;

    v(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.d();
        }
    }
}
