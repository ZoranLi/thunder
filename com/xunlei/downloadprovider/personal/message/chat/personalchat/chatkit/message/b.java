package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.d;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.j;

/* compiled from: MessageContentChecker */
public final class b implements d<IChatMessage> {
    public final boolean a(IChatMessage iChatMessage, int i) {
        return (j.a(iChatMessage) != i || iChatMessage.messageContent().checkMyself().a == null) ? null : true;
    }
}
