package com.xunlei.downloadprovider.vod.recordpublish;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.xunlei.common.commonview.XLToast;

/* compiled from: VodPlayerTopicSelectActivity */
final class t implements TextWatcher {
    final /* synthetic */ VodPlayerTopicSelectActivity a;
    private String b = "";
    private boolean c = true;
    private Runnable d = new u(this);

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    t(VodPlayerTopicSelectActivity vodPlayerTopicSelectActivity) {
        this.a = vodPlayerTopicSelectActivity;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.c != null) {
            this.c = null;
            this.b = this.a.d.getText().toString();
        }
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
        this.b = this.a.d.getText().toString();
        if (TextUtils.isEmpty(this.a.c) != null || this.a.c.equals(this.b) == null) {
            this.a.c = this.b;
            this.a.u.removeCallbacks(this.d);
            this.a.u.postDelayed(this.d, 1000);
        }
        if (TextUtils.isEmpty(this.b) != null) {
            this.a.h.setVisibility(0);
            this.a.f.setVisibility(8);
            return;
        }
        this.a.h.setVisibility(8);
        this.a.f.setVisibility(0);
    }
}
