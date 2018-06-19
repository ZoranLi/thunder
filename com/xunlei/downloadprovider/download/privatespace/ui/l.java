package com.xunlei.downloadprovider.download.privatespace.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: PrivateSpaceFindPwdActivity */
final class l implements TextWatcher {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    l(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        PrivateSpaceFindPwdActivity.d(this.a);
    }
}
