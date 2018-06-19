package com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.b;

import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.aa;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ab;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.u;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.g;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.i;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a.b;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: PersonalChatStrangersPresenter */
public final class a implements i, com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a.a {
    int a;
    b b = null;
    boolean c = false;
    private com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a.a d = null;
    private boolean e = false;

    public a(b bVar, com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a.a aVar) {
        this.b = bVar;
        this.d = aVar;
        this.a = 2;
    }

    public final void b() {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar;
        this.c = false;
        MessageType messageType = MessageType.STRANGERS;
        f a = f.a();
        switch (g.a[MessageType.STRANGERS.ordinal()]) {
            case 1:
                bVar = a.d;
                break;
            case 2:
                bVar = a.c;
                break;
            case 3:
                bVar = a.e;
                break;
            case 4:
                bVar = a.b;
                break;
            case 5:
                bVar = a.a;
                break;
            default:
                bVar = null;
                break;
        }
        q.a(messageType, (long) bVar.getUnreadCount());
        f.a().registerObserver(this);
        this.d.a(new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i(), new b(this));
        com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b().e();
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar) {
        if (bVar.getItemType() == 100) {
            this.b.a((IChatDialog) bVar, "personal_community_stranger");
        }
    }

    public final void b(com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar) {
        if (bVar.getItemType() == 100) {
            this.b.a((IChatDialog) bVar);
        }
    }

    public final void a(IChatDialog iChatDialog) {
        ((aa) p.a(aa.class)).c(iChatDialog, new c(this, iChatDialog));
    }

    public final void c() {
        u.a();
        if (((ab) u.a(ab.class)).b()) {
            this.b.b();
        } else {
            this.d.b(new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i(), new d(this));
        }
    }

    public final void d() {
        com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i iVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i();
        iVar.a = this.a;
        this.d.c(iVar, new e(this));
    }

    public final void e() {
        this.e = false;
        h();
        a();
    }

    public final void f() {
        this.e = true;
    }

    public final void g() {
        try {
            f.a().unregisterObserver(this);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.b.d();
        com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b().f();
        this.c = true;
    }

    public final void a(int i) {
        if (i == this.a) {
            h();
            a();
        }
    }

    private void a() {
        if (!this.e && !this.c) {
            this.b.o_();
        }
    }

    private void h() {
        if (f.a().b(this.a).isEmpty()) {
            this.b.f();
        } else {
            this.b.i();
        }
    }
}
