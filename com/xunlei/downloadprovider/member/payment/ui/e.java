package com.xunlei.downloadprovider.member.payment.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: ActivationActivity */
final class e implements OnFocusChangeListener {
    final /* synthetic */ ActivationActivity a;

    e(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            if (TextUtils.isEmpty(this.a.c.getText().toString().trim()) == null) {
                this.a.g.setVisibility(0);
            } else {
                this.a.g.setVisibility(4);
            }
            this.a.h.setVisibility(4);
        }
    }
}
