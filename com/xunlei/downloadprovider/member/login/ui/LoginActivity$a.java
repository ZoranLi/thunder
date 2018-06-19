package com.xunlei.downloadprovider.member.login.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

class LoginActivity$a implements TextWatcher {
    View a;
    final /* synthetic */ LoginActivity b;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    LoginActivity$a(LoginActivity loginActivity, View view) {
        this.b = loginActivity;
        this.a = view;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence) == 0 && charSequence.length() > 1) {
            LoginActivity.d(this.b, charSequence.toString());
        }
        LoginActivity.j(this.b);
    }

    public final void afterTextChanged(Editable editable) {
        this.a.setVisibility(editable.length() > null ? null : 4);
    }
}
