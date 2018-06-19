package com.xunlei.downloadprovider.member.payment.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.xunlei.downloadprovider.member.payment.d;

/* compiled from: BasePayActivity */
final class n implements OnCancelListener {
    final /* synthetic */ BasePayActivity a;

    n(BasePayActivity basePayActivity) {
        this.a = basePayActivity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        d.b(this.a.a, false);
        this.a.e = null;
    }
}
