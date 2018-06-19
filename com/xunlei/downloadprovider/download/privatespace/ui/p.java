package com.xunlei.downloadprovider.download.privatespace.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: PrivateSpaceFindPwdActivity */
final class p implements OnFocusChangeListener {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    p(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        this.a.h.setImageDrawable(this.a.getResources().getDrawable(z ? true : true));
    }
}
