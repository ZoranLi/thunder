package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message;

import android.content.Context;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.ChatHyperLinkHelper.b;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.a;

/* compiled from: OnTextMessageLinkClickListener */
public final class c implements b {
    private Context a;
    private IChatMessage b;

    public c(Context context, @NonNull IChatMessage iChatMessage) {
        this.a = context;
        this.b = iChatMessage;
    }

    public final void onClick(String str) {
        IChatMessage iChatMessage = this.b;
        this.b.messageContent();
        com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(iChatMessage, "message", true);
        a.a();
        a.a(this.a, str, true, BrowserFrom.CHAT_MESSAGE_LINK);
    }
}
