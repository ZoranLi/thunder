package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ChatDialogService */
final class d implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ c b;
    final /* synthetic */ b c;

    d(b bVar, i iVar, c cVar) {
        this.c = bVar;
        this.a = iVar;
        this.b = cVar;
    }

    public final void run() {
        new StringBuilder("initDialogs. queryParams: ").append(this.a);
        i iVar = new i();
        iVar.a = 3;
        List b = this.c.a(false, iVar, null).b();
        new StringBuilder("initDialogs databaseAcquaintanceChatDialogs.size: ").append(b.size());
        i iVar2 = new i();
        iVar2.a = 2;
        List c = this.c.a(false, iVar2, null).c();
        new StringBuilder("initDialogs databaseStrangerChatDialogs.size: ").append(c.size());
        Collections.sort(b);
        Collections.sort(c);
        int c2 = !b.isEmpty() ? a.c((IChatDialog) b.get(0)) : 0;
        if (!c.isEmpty()) {
            c2 = Math.max(c2, a.c((IChatDialog) c.get(0)));
        }
        i iVar3 = new i();
        iVar3.a = 1;
        iVar3.b = c2;
        iVar3.e = 200;
        this.c.a(false, iVar3, new ArrayList(), new e(this, b, c));
    }
}
