package com.xunlei.downloadprovider.member.register.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: AuthMobileActivity */
final class c implements OnClickListener {
    final /* synthetic */ AuthMobileActivity a;

    c(AuthMobileActivity authMobileActivity) {
        this.a = authMobileActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        k.c((boolean) null);
    }
}
