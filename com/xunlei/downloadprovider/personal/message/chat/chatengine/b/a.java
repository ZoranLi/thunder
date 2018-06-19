package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatUser;

/* compiled from: ChatAuthService */
public class a {
    private static a c;
    public ChatUser a = null;
    public boolean b = false;

    /* compiled from: ChatAuthService */
    public static class a {
        public long a;
        public String b;
        public String c;
        public String d;
        public String e;
    }

    private a() {
    }

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public static void a(a aVar, ChatUser chatUser) {
        chatUser.setUserId(aVar.a);
        chatUser.setAvatarUrl(aVar.b);
        chatUser.setNickname(aVar.c);
        chatUser.setGender(aVar.d);
        chatUser.setKind(aVar.e);
    }
}
