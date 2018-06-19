package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MessageCenterStableActivity */
final class p implements OnClickListener {
    final /* synthetic */ MessageCenterStableActivity a;

    p(MessageCenterStableActivity messageCenterStableActivity) {
        this.a = messageCenterStableActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
