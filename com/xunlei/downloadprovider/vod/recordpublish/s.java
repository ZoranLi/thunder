package com.xunlei.downloadprovider.vod.recordpublish;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: VodPlayerTopicSelectActivity */
final class s implements OnEditorActionListener {
    final /* synthetic */ VodPlayerTopicSelectActivity a;

    s(VodPlayerTopicSelectActivity vodPlayerTopicSelectActivity) {
        this.a = vodPlayerTopicSelectActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        textView = textView.getText().toString().trim();
        if (TextUtils.isEmpty(textView.trim()) == 0) {
            this.a.a();
            VodPlayerTopicSelectActivity.c(textView.trim());
            this.a.a((String) this.a.d.getText().toString(), 0);
        }
        return true;
    }
}
