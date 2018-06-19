package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: MessageCenterDataManager */
public final class f extends h {
    private static f g;
    public k a = null;
    public j b = null;
    public e c = null;
    public o d = null;
    public l e = null;
    public final List<b> f = new ArrayList();
    private final List<b> h = new ArrayList();

    private f() {
    }

    public static f a() {
        if (g == null) {
            g = new f();
        }
        return g;
    }

    public final void b() {
        this.f.clear();
        this.h.clear();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = null;
    }

    public static void c() {
        a().b();
        g = null;
    }

    public final void a(g gVar) {
        for (IChatDialog a : gVar.a()) {
            a(a, false);
        }
        a(2, gVar);
        a(3, gVar);
        a(3);
        a(2);
    }

    public final void b(g gVar) {
        for (IChatDialog a : gVar.a()) {
            a(a, false);
        }
        b(2, gVar);
        b(3, gVar);
        a(3);
        a(2);
    }

    private boolean a(boolean z) {
        boolean z2;
        if (this.h.isEmpty()) {
            this.f.remove(this.a);
            z2 = false;
        } else {
            if (!this.f.contains(this.a)) {
                this.f.add(this.a);
            }
            z2 = true;
        }
        if (z) {
            a((int) true);
        }
        return z2;
    }

    public final List<b> b(int i) {
        switch (i) {
            case 2:
                return this.h;
            case 3:
                return this.f;
            default:
                return 0;
        }
    }

    public final IChatDialog c(int i) {
        i = b(i);
        int size = i.size();
        if (!i.isEmpty()) {
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = (b) i.get(i2);
                if (bVar instanceof IChatDialog) {
                    return (IChatDialog) bVar;
                }
            }
        }
        return 0;
    }

    public final void a(IChatDialog iChatDialog) {
        if (a(iChatDialog, true)) {
            if (a.a(iChatDialog) && !b(3).contains(iChatDialog)) {
                a(3, iChatDialog);
            }
            if (a.b(iChatDialog) && !b(2).contains(iChatDialog)) {
                a(2, iChatDialog);
            }
        }
    }

    private boolean a(IChatDialog iChatDialog, boolean z) {
        if (a.a(iChatDialog)) {
            return a(2, iChatDialog, z);
        }
        return a.b(iChatDialog) ? a(3, iChatDialog, z) : null;
    }

    private void a(int i, g gVar) {
        a(i, gVar.a(i), false);
    }

    private void a(int i, List<IChatDialog> list, boolean z) {
        if (!list.isEmpty()) {
            a.a(i, b(i), list, true);
            if (z) {
                a(i);
            }
            if (i == 2) {
                a(z);
            }
        }
    }

    private void b(int i, g gVar) {
        a.a(i, b(i), gVar.a(i), false);
        if (i == 2) {
            a(false);
        }
    }

    public final boolean a(int i, IChatDialog iChatDialog, boolean z) {
        if (iChatDialog == null) {
            return false;
        }
        iChatDialog = b(i).remove(iChatDialog);
        if (iChatDialog != null) {
            if (z) {
                d(i);
            }
            if (i == 2) {
                a(z);
            }
        }
        return iChatDialog;
    }

    public final void a(List<IChatMessage> list) {
        g bVar = new b();
        if (list != null) {
            for (IChatMessage chatDialog : list) {
                a.a(bVar, chatDialog.chatDialog());
            }
        }
        a(bVar);
    }

    public final void a(int i) {
        Collections.sort(b(i));
        d(i);
    }

    private void a(int i, IChatDialog iChatDialog) {
        a(i, Collections.singletonList(iChatDialog), true);
    }
}
