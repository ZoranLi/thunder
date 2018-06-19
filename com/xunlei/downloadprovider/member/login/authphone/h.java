package com.xunlei.downloadprovider.member.login.authphone;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: AuthDlgActivity */
final class h implements TextWatcher {
    final /* synthetic */ AuthDlgActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    h(AuthDlgActivity authDlgActivity) {
        this.a = authDlgActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.h();
    }
}
