package com.xunlei.downloadprovider.member.login.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: LoginActivity */
final class aa implements TextWatcher {
    final /* synthetic */ LoginActivity a;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    aa(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        LoginActivity.j(this.a);
    }

    public final void afterTextChanged(Editable editable) {
        int i = 8;
        LoginActivity.g(this.a).setVisibility(LoginActivity.d(this.a).length() > 0 ? 0 : 8);
        editable = LoginActivity.h(this.a);
        if (LoginActivity.d(this.a).length() <= 0) {
            i = 0;
        }
        editable.setVisibility(i);
    }
}
