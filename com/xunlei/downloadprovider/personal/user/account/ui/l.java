package com.xunlei.downloadprovider.personal.user.account.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: UserAccountEditActivity */
final class l implements TextWatcher {
    final /* synthetic */ UserAccountEditActivity a;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    l(UserAccountEditActivity userAccountEditActivity) {
        this.a = userAccountEditActivity;
    }

    public final void afterTextChanged(Editable editable) {
        if (this.a.d == 1) {
            UserAccountEditActivity.a(this.a, this.a.e, editable);
            return;
        }
        if (this.a.d == 2) {
            UserAccountEditActivity.a(this.a, this.a.f, editable);
        }
    }
}
