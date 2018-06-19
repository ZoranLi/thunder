package com.xunlei.downloadprovider.vod.recordpublish;

import android.text.Editable;
import android.text.TextWatcher;
import com.xunlei.common.commonview.XLToast;

/* compiled from: VodPlayerPublishActivity */
final class m implements TextWatcher {
    final /* synthetic */ VodPlayerPublishActivity a;
    private String b = "";

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    m(VodPlayerPublishActivity vodPlayerPublishActivity) {
        this.a = vodPlayerPublishActivity;
    }

    public final void afterTextChanged(Editable editable) {
        editable = this.a.d.getText().toString().trim();
        if (editable.contains("#")) {
            this.a.d.setText(this.b);
            editable = editable.indexOf("#");
            if (editable > this.b.length() || editable == -1) {
                this.a.d.setSelection(this.b.length());
            } else {
                this.a.d.setSelection(editable);
            }
            XLToast.showToast(this.a, "不可输入#", 1);
        }
        this.a.l = this.a.d.getText().toString();
        this.b = this.a.d.getText().toString();
    }
}
