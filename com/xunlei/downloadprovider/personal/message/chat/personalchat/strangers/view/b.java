package com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PersonalChatStrangersActivity */
final class b implements OnClickListener {
    final /* synthetic */ PersonalChatStrangersActivity a;

    b(PersonalChatStrangersActivity personalChatStrangersActivity) {
        this.a = personalChatStrangersActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
