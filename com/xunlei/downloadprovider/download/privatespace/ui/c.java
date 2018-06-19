package com.xunlei.downloadprovider.download.privatespace.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PrivateSpaceFindPwdActivity */
final class c implements OnClickListener {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    c(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
