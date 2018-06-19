package com.xunlei.downloadprovider.download.privatespace.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: PrivateSpaceFindPwdActivity */
final class q implements TextWatcher {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    q(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void afterTextChanged(Editable editable) {
        PrivateSpaceFindPwdActivity.d(this.a);
    }
}
