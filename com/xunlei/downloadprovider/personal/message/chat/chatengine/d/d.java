package com.xunlei.downloadprovider.personal.message.chat.chatengine.d;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;

/* compiled from: ChatMessageHelper */
public final class d {
    public static boolean a(IChatMessage iChatMessage) {
        return (iChatMessage == null || iChatMessage.creatorType() == 3 || iChatMessage.messageStatus() != 2) ? null : true;
    }
}
