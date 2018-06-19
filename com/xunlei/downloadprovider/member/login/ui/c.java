package com.xunlei.downloadprovider.member.login.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: LoginActivity */
final class c implements OnEditorActionListener {
    final /* synthetic */ LoginActivity a;

    c(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            if (i != 0) {
                return null;
            }
        }
        this.a.a();
        return true;
    }
}
