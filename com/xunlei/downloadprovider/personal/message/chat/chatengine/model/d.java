package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a;

/* compiled from: ChatMessageContentParser */
public final class d {
    private static d b;
    public a a;

    private d() {
        this.a = null;
        this.a = new a();
    }

    public static d a() {
        if (b == null) {
            b = new d();
        }
        return b;
    }

    public final IChatMessageContent a(IChatUser iChatUser, IChatUser iChatUser2, int i, String str) {
        if (i >= 1000) {
            throw new IllegalArgumentException("can not parse local message content");
        }
        if (i == 1) {
            iChatUser = new ChatTextMessageContent(str);
        } else if (i != 3) {
            iChatUser = new ChatNonsupportMessageContent();
        } else if (this.a != null) {
            iChatUser = this.a.a(iChatUser, iChatUser2, str);
        } else {
            iChatUser = new ChatNonsupportMessageContent();
        }
        if (iChatUser != null) {
            return iChatUser;
        }
        iChatUser2 = new StringBuilder("ChatMessageContent parse fail. messageContentType: ");
        iChatUser2.append(i);
        iChatUser2.append(" messageContentText: ");
        iChatUser2.append(str);
        throw new NullPointerException(iChatUser2.toString());
    }

    public static IChatMessageContent b() {
        return new ChatNonsupportMessageContent();
    }

    public static IChatMessageContent c() {
        return new ChatErrorMessageContent();
    }
}
