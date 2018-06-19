package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.f;
import java.util.Random;

/* compiled from: MessageBuilder */
public final class h {
    private static h a;

    private h() {
    }

    public static h a() {
        if (a == null) {
            a = new h();
        }
        return a;
    }

    public static ChatMessage a(boolean z) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setCreateAt(f.a());
        chatMessage.setLocalMessageId(System.currentTimeMillis() + new Random().nextLong());
        if (z) {
            chatMessage.setCreatorType(true);
            chatMessage.setSender(ChatSystem.getInstance());
        } else {
            chatMessage.setCreatorType(true);
            chatMessage.setSender(a.a().a);
        }
        return chatMessage;
    }
}
