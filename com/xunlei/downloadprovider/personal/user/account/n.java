package com.xunlei.downloadprovider.personal.user.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.h.l;

/* compiled from: UserAccountUtil */
final class n implements OnClickListener {
    final /* synthetic */ Context a;

    n(Context context) {
        this.a = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        l.a(this.a);
    }
}
