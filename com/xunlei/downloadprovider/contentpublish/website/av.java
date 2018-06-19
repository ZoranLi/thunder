package com.xunlei.downloadprovider.contentpublish.website;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: WebsitePublishActivity */
final class av implements TextWatcher {
    final /* synthetic */ WebsitePublishActivity a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    av(WebsitePublishActivity websitePublishActivity) {
        this.a = websitePublishActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.c.d = WebsitePublishActivity.a(this.a);
    }
}
