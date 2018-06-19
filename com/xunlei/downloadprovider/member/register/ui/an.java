package com.xunlei.downloadprovider.member.register.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: RegisterSuccessActivity */
final class an implements TextWatcher {
    final /* synthetic */ RegisterSuccessActivity a;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    an(RegisterSuccessActivity registerSuccessActivity) {
        this.a = registerSuccessActivity;
    }

    public final void afterTextChanged(Editable editable) {
        this.a.m.setVisibility(editable.length() > 0 ? 0 : 8);
        this.a.r = editable.toString().trim();
        boolean z = true;
        this.a.s = this.a.r.length() > 0;
        editable = this.a.p;
        if (!this.a.s || !RegisterSuccessActivity.f(this.a)) {
            z = false;
        }
        editable.setEnabled(z);
    }
}
