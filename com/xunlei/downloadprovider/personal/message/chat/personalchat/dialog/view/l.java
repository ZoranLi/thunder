package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.k.a;

/* compiled from: DialogContentFragment */
final class l implements a<IChatMessage> {
    final /* synthetic */ DialogContentFragment a;

    l(DialogContentFragment dialogContentFragment) {
        this.a = dialogContentFragment;
    }

    public final void onClick(int i, IChatMessage iChatMessage) {
        this.a.a.a(i, iChatMessage);
    }

    public final void a(IChatMessage iChatMessage) {
        this.a.a.b(iChatMessage);
    }
}
