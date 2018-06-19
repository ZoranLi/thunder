package com.xunlei.downloadprovider.member.payment.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.member.payment.d;

/* compiled from: BasePayPageFragment */
final class z implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ BasePayPageFragment b;

    z(BasePayPageFragment basePayPageFragment, String str) {
        this.b = basePayPageFragment;
        this.a = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        d.a(this.a, (boolean) 0);
    }
}
