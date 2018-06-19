package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/* compiled from: LXSpaceCreateUrlTaskActivity */
final class w implements TextWatcher {
    final /* synthetic */ View a;
    final /* synthetic */ LXSpaceCreateUrlTaskActivity b;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    w(LXSpaceCreateUrlTaskActivity lXSpaceCreateUrlTaskActivity, View view) {
        this.b = lXSpaceCreateUrlTaskActivity;
        this.a = view;
    }

    public final void afterTextChanged(Editable editable) {
        this.b.d.setEnabled(true);
        int i = 8;
        this.b.c.setVisibility(8);
        View view = this.a;
        if (editable.length() != null) {
            i = 0;
        }
        view.setVisibility(i);
    }
}
