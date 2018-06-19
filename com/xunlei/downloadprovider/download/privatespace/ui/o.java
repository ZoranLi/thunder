package com.xunlei.downloadprovider.download.privatespace.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: PrivateSpaceFindPwdActivity */
final class o implements TextWatcher {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    o(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() <= null) {
            this.a.j.setVisibility(4);
        } else {
            this.a.j.setVisibility(0);
        }
        PrivateSpaceFindPwdActivity.d(this.a);
        this.a.s = false;
    }
}
