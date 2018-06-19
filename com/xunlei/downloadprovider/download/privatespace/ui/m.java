package com.xunlei.downloadprovider.download.privatespace.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: PrivateSpaceFindPwdActivity */
final class m implements OnFocusChangeListener {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    m(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        this.a.f.setImageDrawable(this.a.getResources().getDrawable(z ? true : true));
    }
}
