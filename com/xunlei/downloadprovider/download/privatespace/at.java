package com.xunlei.downloadprovider.download.privatespace;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.privatespace.ui.PrivateSpaceFindPwdActivity;

/* compiled from: VerifyPrivateSpaceDialog */
final class at implements OnClickListener {
    final /* synthetic */ ao a;

    at(ao aoVar) {
        this.a = aoVar;
    }

    public final void onClick(View view) {
        an.c("forget_password");
        PrivateSpaceFindPwdActivity.a(this.a.getContext());
    }
}
