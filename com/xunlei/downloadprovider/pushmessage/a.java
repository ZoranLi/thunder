package com.xunlei.downloadprovider.pushmessage;

import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b;

/* compiled from: ChatSubject */
public class a extends o {
    private static a b;

    public interface a extends c {
    }

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public final void a(Object obj) {
        for (c a : this.a) {
            a.a(obj);
        }
    }

    public static boolean a(IChatMessage iChatMessage) {
        return ((AppStatusChgObserver.b().a && b.b().g()) || com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a.a(iChatMessage.chatDialog()) == null) ? null : true;
    }
}
