package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.member.payment.d;

/* compiled from: FloatActivity */
final class a implements OnClickListener {
    final /* synthetic */ FloatActivity a;

    a(FloatActivity floatActivity) {
        this.a = floatActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.n();
        d.a(this.a.a, (boolean) 1);
    }
}
