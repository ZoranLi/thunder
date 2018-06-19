package com.xunlei.downloadprovider.member.register.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: AuthMobileActivity */
final class l implements TextWatcher {
    final /* synthetic */ AuthMobileActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    l(AuthMobileActivity authMobileActivity) {
        this.a = authMobileActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() <= null) {
            AuthMobileActivity.e(this.a).setVisibility(4);
        } else {
            AuthMobileActivity.e(this.a).setVisibility(0);
        }
        AuthMobileActivity.c(this.a);
    }
}
