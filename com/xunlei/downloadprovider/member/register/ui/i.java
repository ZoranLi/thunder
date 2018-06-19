package com.xunlei.downloadprovider.member.register.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: AuthMobileActivity */
final class i implements TextWatcher {
    final /* synthetic */ AuthMobileActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    i(AuthMobileActivity authMobileActivity) {
        this.a = authMobileActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AuthMobileActivity.c(this.a);
    }
}
