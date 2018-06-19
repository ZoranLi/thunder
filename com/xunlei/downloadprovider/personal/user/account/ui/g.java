package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.inputmethod.InputMethodManager;
import java.util.TimerTask;

/* compiled from: UserAccountEditActivity */
final class g extends TimerTask {
    final /* synthetic */ UserAccountEditActivity a;

    g(UserAccountEditActivity userAccountEditActivity) {
        this.a = userAccountEditActivity;
    }

    public final void run() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.a.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
    }
}
