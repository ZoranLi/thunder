package com.xunlei.downloadprovider.member.payment.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.member.payment.d;

/* compiled from: BasePayActivity */
final class p implements OnClickListener {
    final /* synthetic */ BasePayActivity a;

    p(BasePayActivity basePayActivity) {
        this.a = basePayActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.b(this.a.a, 0);
        this.a.e = null;
    }
}
