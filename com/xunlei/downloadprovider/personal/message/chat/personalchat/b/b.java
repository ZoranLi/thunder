package com.xunlei.downloadprovider.personal.message.chat.personalchat.b;

import com.xunlei.downloadprovider.member.login.c.h;
import com.xunlei.downloadprovider.personal.message.chat.c;

/* compiled from: ChatNewUserManager */
public final class b implements c<Boolean> {
    public final /* synthetic */ void a(Object obj) {
        Boolean bool = (Boolean) obj;
        new StringBuilder("reportChatNewUser. isSuccess: ").append(bool);
        if (bool.booleanValue() != null) {
            h.a().a.edit().putBoolean(h.c(), true).apply();
        }
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.b bVar) {
        new StringBuilder("reportChatNewUser. errorInfo: ").append(bVar);
    }
}
