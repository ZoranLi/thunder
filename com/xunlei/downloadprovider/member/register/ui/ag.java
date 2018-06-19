package com.xunlei.downloadprovider.member.register.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: MobileSetupActivity */
final class ag implements TextWatcher {
    final /* synthetic */ MobileSetupActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    ag(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() <= null) {
            this.a.m.setVisibility(4);
        } else {
            this.a.m.setVisibility(0);
        }
        this.a.n();
    }
}
