package com.xunlei.downloadprovider.contentpublish.website;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: WebsiteEditActivity */
final class aq implements TextWatcher {
    final /* synthetic */ WebsiteEditActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    aq(WebsiteEditActivity websiteEditActivity) {
        this.a = websiteEditActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.a.d != null) {
            this.a.d = false;
            if (i == 0) {
                bf.b(this.a.g, "clear", "");
            }
        }
        this.a.d();
        WebsiteEditActivity.c();
    }
}
