package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MessageCenterActivity */
final class h implements OnClickListener {
    final /* synthetic */ MessageCenterActivity a;

    h(MessageCenterActivity messageCenterActivity) {
        this.a = messageCenterActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
