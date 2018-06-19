package com.xunlei.downloadprovider.member.register.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: MobileSetupActivity */
final class ad implements TextWatcher {
    final /* synthetic */ MobileSetupActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    ad(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.n();
    }
}
