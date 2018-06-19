package com.xunlei.downloadprovider.member.payment.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.member.payment.d;

/* compiled from: BasePayPageFragment */
final class aa implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ BasePayPageFragment b;

    aa(BasePayPageFragment basePayPageFragment, String str) {
        this.b = basePayPageFragment;
        this.a = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        ((PayActivity) this.b.getActivity()).finish();
        d.a(this.a, (boolean) 1);
    }
}
