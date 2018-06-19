package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.member.payment.d;

/* compiled from: FloatActivity */
final class b implements OnClickListener {
    final /* synthetic */ FloatActivity a;

    b(FloatActivity floatActivity) {
        this.a = floatActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        d.a(this.a.a, (boolean) 0);
    }
}
