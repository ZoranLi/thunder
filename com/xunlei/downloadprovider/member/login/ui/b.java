package com.xunlei.downloadprovider.member.login.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: LoginActivity */
final class b implements OnEditorActionListener {
    final /* synthetic */ LoginActivity a;

    b(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            if (i != 0) {
                return null;
            }
        }
        LoginActivity.d(this.a).requestFocus();
        return true;
    }
}
