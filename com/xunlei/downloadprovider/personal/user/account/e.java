package com.xunlei.downloadprovider.personal.user.account;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.user.account.a.b;

/* compiled from: ActionSheetHelper */
final class e implements OnClickListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ b b;

    e(Dialog dialog, b bVar) {
        this.a = dialog;
        this.b = bVar;
    }

    public final void onClick(View view) {
        this.a.dismiss();
        this.b.a(2);
    }
}
