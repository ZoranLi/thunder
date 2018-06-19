package com.xunlei.downloadprovider.member.payment.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.member.payment.d;

/* compiled from: BasePayActivity */
final class o implements OnClickListener {
    final /* synthetic */ BasePayActivity a;

    o(BasePayActivity basePayActivity) {
        this.a = basePayActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a(this.a.e);
        d.b(this.a.a, 1);
    }
}
