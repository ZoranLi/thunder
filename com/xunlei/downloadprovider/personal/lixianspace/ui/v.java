package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: LXSpaceCreateUrlTaskActivity */
final class v implements OnEditorActionListener {
    final /* synthetic */ LXSpaceCreateUrlTaskActivity a;

    v(LXSpaceCreateUrlTaskActivity lXSpaceCreateUrlTaskActivity) {
        this.a = lXSpaceCreateUrlTaskActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return null;
        }
        LXSpaceCreateUrlTaskActivity.a(this.a);
        return true;
    }
}
