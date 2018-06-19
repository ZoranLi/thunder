package com.xunlei.downloadprovider.personal.user.account.ui;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: UserAccountInfoActivity */
final class n implements MessageListener {
    final /* synthetic */ UserAccountInfoActivity a;

    n(UserAccountInfoActivity userAccountInfoActivity) {
        this.a = userAccountInfoActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 105) {
            UserAccountInfoActivity.o(this.a);
        }
    }
}
