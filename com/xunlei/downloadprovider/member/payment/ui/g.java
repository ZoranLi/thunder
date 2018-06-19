package com.xunlei.downloadprovider.member.payment.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: ActivationActivity */
final class g implements OnFocusChangeListener {
    final /* synthetic */ ActivationActivity a;

    g(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            if (TextUtils.isEmpty(this.a.d.getText().toString().trim()) == null) {
                this.a.h.setVisibility(0);
            } else {
                this.a.h.setVisibility(4);
            }
            this.a.g.setVisibility(4);
        }
    }
}
