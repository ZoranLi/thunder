package com.xunlei.downloadprovider.member.login.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: LoginActivity */
final class f implements TextWatcher {
    final /* synthetic */ LoginActivity a;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    f(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void afterTextChanged(Editable editable) {
        LoginActivity.j(this.a);
    }
}
