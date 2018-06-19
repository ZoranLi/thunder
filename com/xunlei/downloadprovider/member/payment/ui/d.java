package com.xunlei.downloadprovider.member.payment.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ActivationActivity */
final class d implements OnClickListener {
    final /* synthetic */ ActivationActivity a;

    d(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    public final void onClick(View view) {
        this.a.d.setText("");
        this.a.d.requestFocus();
    }
}
