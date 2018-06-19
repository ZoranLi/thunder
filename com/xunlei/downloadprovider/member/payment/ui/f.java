package com.xunlei.downloadprovider.member.payment.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ActivationActivity */
final class f implements TextWatcher {
    final /* synthetic */ ActivationActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    f(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if ("".equals(this.a.c.getText().toString().trim()) != null) {
            this.a.g.setVisibility(4);
        } else {
            this.a.g.setVisibility(0);
        }
    }
}
