package com.xunlei.downloadprovider.personal.user.account;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ActionSheetHelper */
public final class b implements OnClickListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ com.xunlei.downloadprovider.personal.user.account.a.b b;

    public b(Dialog dialog, com.xunlei.downloadprovider.personal.user.account.a.b bVar) {
        this.a = dialog;
        this.b = bVar;
    }

    public final void onClick(View view) {
        this.a.dismiss();
        this.b.a(2);
    }
}
