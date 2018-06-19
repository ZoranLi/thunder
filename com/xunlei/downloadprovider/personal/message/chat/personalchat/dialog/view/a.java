package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: ChatDialogFollowAlertView */
final class a implements Callback {
    final /* synthetic */ ChatDialogFollowAlertView a;

    a(ChatDialogFollowAlertView chatDialogFollowAlertView) {
        this.a = chatDialogFollowAlertView;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1000) {
            this.a.b.performClick();
        }
        return true;
    }
}
