package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a;

import android.content.Context;
import android.view.View;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent.IChatTextMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.j;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.c;

/* compiled from: SentTextMessageHolder */
public class l extends j<IChatMessage, IChatTextMessageContent> {
    public final /* synthetic */ void a(IChatMessageContent iChatMessageContent) {
        IChatTextMessageContent iChatTextMessageContent = (IChatTextMessageContent) iChatMessageContent;
        super.a((IChatMessageContent) iChatTextMessageContent);
        if (this.f != null && this.j != null) {
            this.j.setText(iChatTextMessageContent.text());
            a(this.j, new c(this.a, this.f));
        }
    }

    public l(Context context, View view) {
        super(context, view);
    }

    public final void a(IChatMessage iChatMessage) {
        super.a(iChatMessage);
    }
}
