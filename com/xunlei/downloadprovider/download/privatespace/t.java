package com.xunlei.downloadprovider.download.privatespace;

import android.text.Editable;
import android.text.TextWatcher;
import com.xunlei.downloadprovider.R;

/* compiled from: PrivateSpaceDialog */
final class t implements TextWatcher {
    final /* synthetic */ s a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    t(s sVar) {
        this.a = sVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.a.k.getVisibility() == 0) {
            if (charSequence.length() < 6 || this.a.g.getText().length() < 6) {
                this.a.j.setEnabled(false);
                this.a.j.setTextColor(this.a.getContext().getResources().getColor(R.color.button_text_gray));
                return;
            }
            this.a.j.setTextColor(this.a.getContext().getResources().getColor(R.color.global_text_color_4));
            this.a.j.setEnabled(true);
        } else if (charSequence.length() >= 6) {
            this.a.j.setEnabled(true);
            this.a.j.setTextColor(this.a.getContext().getResources().getColor(R.color.global_text_color_4));
        } else {
            this.a.j.setEnabled(false);
            this.a.j.setTextColor(this.a.getContext().getResources().getColor(R.color.button_text_gray));
        }
    }
}
