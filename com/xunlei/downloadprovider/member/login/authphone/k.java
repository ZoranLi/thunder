package com.xunlei.downloadprovider.member.login.authphone;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: AuthDlgActivity */
final class k implements TextWatcher {
    final /* synthetic */ AuthDlgActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    k(AuthDlgActivity authDlgActivity) {
        this.a = authDlgActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() <= null) {
            this.a.k.setVisibility(4);
        } else {
            this.a.k.setVisibility(0);
        }
        this.a.h();
    }
}
