package com.xunlei.downloadprovider.download.privatespace;

import android.text.Editable;
import android.text.TextWatcher;
import com.xunlei.downloadprovider.R;

/* compiled from: PrivateSpaceDialog */
final class u implements TextWatcher {
    final /* synthetic */ s a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    u(s sVar) {
        this.a = sVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() < 6 || this.a.e.getText().length() < 6) {
            this.a.j.setEnabled(0);
            this.a.j.setTextColor(this.a.getContext().getResources().getColor(R.color.button_text_gray));
            return;
        }
        this.a.j.setEnabled(1);
        this.a.j.setTextColor(this.a.getContext().getResources().getColor(R.color.global_text_color_4));
    }
}
