package com.xunlei.downloadprovider.member.login.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: LoginDlgActivity */
final class ab extends BroadcastReceiver {
    final /* synthetic */ LoginDlgActivity a;

    ab(LoginDlgActivity loginDlgActivity) {
        this.a = loginDlgActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if (TextUtils.equals("action_finish_login_dialog", intent.getAction()) != null) {
            this.a.finish();
        }
    }
}
