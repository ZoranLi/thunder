package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class g implements OnClickListener {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.cancel();
        this.a.b.a.g = 0;
        dialogInterface = new StringBuilder();
        dialogInterface.append(this.a.b.a.d);
        dialogInterface.append("?resultCode=150");
        h.a(this.a.b.a, dialogInterface.toString());
        this.a.b.a.finish();
    }
}
