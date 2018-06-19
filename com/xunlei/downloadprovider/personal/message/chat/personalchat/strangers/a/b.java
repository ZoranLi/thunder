package com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.aa;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;
import java.util.List;

/* compiled from: PersonalChatDialogListModel */
public class b implements a {
    public final void a(i iVar, c<g> cVar) {
        ((aa) p.a(aa.class)).c(iVar, cVar);
    }

    public final void c(i iVar, c<g> cVar) {
        IChatDialog iChatDialog;
        List b = f.a().b(iVar.a);
        int size = b.size();
        if (!b.isEmpty()) {
            for (size--; size >= 0; size--) {
                com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar = (com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b) b.get(size);
                if (bVar instanceof IChatDialog) {
                    iChatDialog = (IChatDialog) bVar;
                    break;
                }
            }
        }
        iChatDialog = null;
        iVar.c = iChatDialog != null ? iChatDialog.lastMessage().createdAt() : 0;
        ((aa) p.a(aa.class)).b(iVar, cVar);
    }

    public final void b(c<Integer> cVar) {
        ((aa) p.a(aa.class)).a(cVar);
    }

    public final void b(i iVar, c<g> cVar) {
        IChatDialog c = f.a().c(3);
        IChatDialog c2 = f.a().c(2);
        int i = 0;
        int createdAt = (c == null || c.lastServerMessage() == null) ? 0 : c.lastServerMessage().createdAt();
        if (c2 != null) {
            if (c2.lastServerMessage() != null) {
                i = c2.lastServerMessage().createdAt();
            }
            createdAt = Math.max(createdAt, i);
        }
        iVar.b = createdAt;
        ((aa) p.a(aa.class)).a(iVar, cVar);
    }
}
