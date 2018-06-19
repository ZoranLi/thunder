package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a;

import android.content.Context;
import android.view.View;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent.IChatTextMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.i;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.c;

/* compiled from: ReceivedTextMessageHolder */
public class h extends i<IChatMessage, IChatTextMessageContent> {
    public final /* synthetic */ void a(IChatMessageContent iChatMessageContent) {
        IChatTextMessageContent iChatTextMessageContent = (IChatTextMessageContent) iChatMessageContent;
        super.a((IChatMessageContent) iChatTextMessageContent);
        if (this.f != null && this.i != null) {
            this.i.setText(iChatTextMessageContent.text());
            a(this.i, new c(this.a, this.f));
        }
    }

    public h(Context context, View view) {
        super(context, view);
    }

    public final void a(IChatMessage iChatMessage) {
        super.a(iChatMessage);
    }
}
