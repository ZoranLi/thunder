package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.r;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.u;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: ChatUserService */
public final class v implements ad {
    private static v a;

    private v() {
    }

    public static v a() {
        if (a == null) {
            a = new v();
        }
        return a;
    }

    public final void a(IChatDialog iChatDialog, c<Boolean> cVar) {
        r.a().a(iChatDialog.targetUser().userId(), 1, new w(this, iChatDialog, cVar));
    }

    public final void b(IChatDialog iChatDialog, c<Boolean> cVar) {
        q.a().execute(new u(r.a(), iChatDialog.targetUser().userId(), new x(this, iChatDialog, cVar)));
    }

    public final void c(IChatDialog iChatDialog, c<Boolean> cVar) {
        r.a().a(iChatDialog.targetUser().userId(), 2, new y(this, iChatDialog, cVar));
    }

    public final void d(IChatDialog iChatDialog, c<Boolean> cVar) {
        b.a().a(iChatDialog.targetUser().userId(), null, new z(this, iChatDialog, cVar));
    }
}
