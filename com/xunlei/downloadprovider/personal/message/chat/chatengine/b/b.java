package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.d;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.k;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.m;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatDialogService */
public final class b implements aa {
    private static b a;

    private b() {
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public final void a(i iVar, c<g> cVar) {
        new StringBuilder("updateDialogs. queryParams: ").append(iVar);
        a(true, iVar, new ArrayList(), new c(this, cVar));
    }

    public final void b(i iVar, c<g> cVar) {
        new StringBuilder("loadDialogs. queryParams: ").append(iVar);
        a(true, iVar, cVar);
    }

    public final void c(i iVar, c<g> cVar) {
        q.a().execute(new d(this, iVar, cVar));
    }

    public final g a(boolean z, i iVar, @Nullable c<g> cVar) {
        if (z) {
            q.a().execute(new f(this, iVar, cVar));
            return false;
        }
        com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b.a();
        Object a = com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b.a(iVar);
        if (cVar != null) {
            cVar.a(a);
        }
        return a;
    }

    public final void a(boolean z, i iVar, List<IChatDialog> list, c<List<IChatDialog>> cVar) {
        iVar.e = 500;
        new StringBuilder("loadRemainDialogsFromServer queryParams: ").append(iVar.toString());
        c jVar = new j(this, list, iVar, cVar);
        iVar.b = Math.max(1506268800, iVar.b);
        list = d.a();
        c hVar = new h(this, jVar);
        if (z) {
            q.a().execute(new k(list, iVar, hVar));
        } else {
            list.a(iVar, hVar);
        }
    }

    @Nullable
    public final IChatDialog a(int i) {
        return u.a().c().a(i);
    }

    public final void a(long j, c<IChatDialog> cVar) {
        d.a().a(j, new k(this, cVar));
    }

    public final void a(IChatDialog iChatDialog, c<IChatDialog> cVar) {
        d.a().a(iChatDialog.targetUser().userId(), new l(this, cVar));
    }

    public static void b(IChatDialog iChatDialog, c<Boolean> cVar) {
        q.a().execute(new m(d.a(), iChatDialog, cVar));
    }

    public final void c(IChatDialog iChatDialog, c<Boolean> cVar) {
        q.a().execute(new com.xunlei.downloadprovider.personal.message.chat.chatengine.c.i(d.a(), iChatDialog.dialogId(), new m(this, cVar, iChatDialog)));
    }

    public final void a(c<Integer> cVar) {
        q.a().execute(new e(com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b.a(), cVar));
    }
}
