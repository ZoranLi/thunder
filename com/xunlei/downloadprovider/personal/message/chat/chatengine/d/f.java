package com.xunlei.downloadprovider.personal.message.chat.chatengine.d;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import java.util.Date;

/* compiled from: TimeUtil */
public final class f {
    public static int a() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static Date a(int i) {
        return new Date(((long) i) * 1000);
    }

    public static Date a(IChatMessage iChatMessage) {
        if (iChatMessage == null) {
            return new Date();
        }
        return a(iChatMessage.createdAt());
    }
}
