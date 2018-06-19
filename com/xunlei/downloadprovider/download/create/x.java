package com.xunlei.downloadprovider.download.create;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CreateUrlTaskActivity */
final class x implements TextWatcher {
    final /* synthetic */ CreateUrlTaskActivity a;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    x(CreateUrlTaskActivity createUrlTaskActivity) {
        this.a = createUrlTaskActivity;
    }

    public final void afterTextChanged(Editable editable) {
        this.a.a = false;
        if (editable.length() == null) {
            this.a.g.setVisibility(8);
        } else {
            this.a.g.setVisibility(0);
        }
    }
}
