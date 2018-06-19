package com.xunlei.downloadprovider.member.payment.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ActivationActivity */
final class c implements OnClickListener {
    final /* synthetic */ ActivationActivity a;

    c(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    public final void onClick(View view) {
        this.a.c.setText("");
        this.a.c.requestFocus();
    }
}
