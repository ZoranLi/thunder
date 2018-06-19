package com.xunlei.downloadprovider.contentpublish.website;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: WebsiteEditActivity */
final class ap implements OnEditorActionListener {
    final /* synthetic */ WebsiteEditActivity a;

    ap(WebsiteEditActivity websiteEditActivity) {
        this.a = websiteEditActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            if (i != 0) {
                return null;
            }
        }
        ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.a.getWindowToken(), 0);
        return true;
    }
}
