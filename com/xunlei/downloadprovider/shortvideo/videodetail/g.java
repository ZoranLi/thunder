package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

/* compiled from: CommentDialog */
final class g implements TextWatcher {
    final /* synthetic */ a a;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    g(a aVar) {
        this.a = aVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        i = this.a.n;
        i2 = new StringBuilder();
        i2.append(charSequence.length());
        i2.append("/100");
        i.setText(i2.toString());
    }

    public final void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable.toString().trim()) != null) {
            if (this.a.m.isEnabled() != null) {
                this.a.m.setEnabled(false);
            }
        } else if (this.a.m.isEnabled() == null) {
            this.a.m.setEnabled(true);
        }
    }
}
