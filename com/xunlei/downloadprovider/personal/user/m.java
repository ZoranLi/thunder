package com.xunlei.downloadprovider.personal.user;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ReportActivity */
final class m implements TextWatcher {
    final /* synthetic */ ReportActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    m(ReportActivity reportActivity) {
        this.a = reportActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ReportActivity.c(this.a);
    }
}
