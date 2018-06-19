package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.b;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import com.xunlei.downloadprovider.personal.message.ad;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.aa;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ab;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ac;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.r;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.u;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.h;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.i;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.e.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.info.MessageCenterDispatchInfo;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j;
import com.xunlei.downloadprovider.personal.message.d;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.s;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* compiled from: MessageCenterPresenter */
public final class b implements r, i, a, d.a, Observer {
    private int a;
    private com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.e.b b = null;
    private c c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private String g;
    private Handler h = new Handler(Looper.getMainLooper());
    private ab.a i = null;
    private h.a j = null;

    public final void a() {
    }

    public b(com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.e.b bVar, c cVar) {
        this.b = bVar;
        this.c = cVar;
        this.a = 3;
    }

    public final void b() {
        this.e = false;
        com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.h.b();
        this.c.a((i) this);
        this.c.a();
        j.b().addObserver(this);
        d.a().a(this);
        a(new c(this));
        i();
        if (com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c()) {
            ((ac) p.a(ac.class)).a(this);
            u.a();
            ab abVar = (ab) u.a(ab.class);
            if (abVar.b()) {
                this.i = new f(this);
                abVar.a(this.i);
            } else {
                h();
            }
            this.j = new d(this);
            com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b().a(this.j);
            com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b().e();
        }
        com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.h.a();
        j.b().b.b = true;
    }

    private void h() {
        this.f = false;
        this.c.a(new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i(), new g(this));
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar) {
        int itemType = bVar.getItemType();
        if (itemType != 100) {
            switch (itemType) {
                case 1:
                    q.b("discuss_list");
                    this.b.a(MessageType.COMMENT, "per_cl_message_center");
                    return;
                case 2:
                    q.b("stranger_list");
                    this.b.f();
                    return;
                case 3:
                    q.b("zan_list");
                    this.b.a(MessageType.STAR, "per_cl_message_center");
                    break;
                case 4:
                    q.b("follow_list");
                    this.b.a(MessageType.FOLLOW, "per_cl_message_center");
                    return;
                case 5:
                    q.b("visit_list");
                    this.b.a(MessageType.VISIT, "per_cl_message_center");
                    f.a().d.a = 0;
                    return;
                default:
                    break;
            }
            return;
        }
        this.b.a((IChatDialog) bVar, "personal_community_friend");
    }

    public final void b(com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar) {
        if (bVar.getItemType() == 100) {
            this.b.a((IChatDialog) bVar);
        }
    }

    public final void a(IChatDialog iChatDialog) {
        ((aa) p.a(aa.class)).c(iChatDialog, new h(this, iChatDialog));
    }

    public final void a(Intent intent) {
        if (intent != null) {
            intent = intent.getSerializableExtra("message_center_dispatch_info");
            if (intent instanceof MessageCenterDispatchInfo) {
                this.g = ((MessageCenterDispatchInfo) intent).getFrom();
            }
            if (TextUtils.isEmpty(this.g) != null) {
                this.g = "unknown";
            }
            new StringBuilder("from: ").append(this.g);
        }
    }

    public final void c() {
        u.a();
        if (!((ab) u.a(ab.class)).b()) {
            if (this.f) {
                this.c.b(new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i(), new i(this));
                return;
            }
        }
        this.b.b();
    }

    public final void d() {
        com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i iVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i();
        iVar.a = this.a;
        this.c.c(iVar, new j(this));
    }

    public final void e() {
        this.d = false;
        k();
        j();
    }

    public final void f() {
        this.d = true;
    }

    public final void g() {
        this.e = true;
        com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.h.c();
        this.h.removeCallbacksAndMessages(null);
        this.c.b(this);
        d.a().b(this);
        if (com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c()) {
            ((ac) p.a(ac.class)).b(this);
            ((ab) p.a(ab.class)).b(this.i);
            com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b().b(this.j);
            com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b().f();
        }
        j.b().deleteObserver(this);
        if (!com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.h.d()) {
            f.c();
        }
        this.b.d();
    }

    public final void a(List<IChatMessage> list) {
        f.a().a((List) list);
    }

    public final void b(List<IChatMessage> list) {
        f.a().a((List) list);
    }

    public final void a(Object obj) {
        LoginHelper.a();
        if (l.c() != null) {
            a((ad) null);
            i();
        }
    }

    private void a(@Nullable ad adVar) {
        this.c.a(new k(this, adVar));
    }

    private void i() {
        this.c.a(new l(this));
    }

    private void j() {
        if (com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c()) {
            this.c.b(new e(this));
        }
    }

    public final void a(int i) {
        if (i == this.a) {
            k();
        }
    }

    private void k() {
        if (!this.d && !this.e) {
            this.b.o_();
        }
    }

    private void a(s sVar) {
        new StringBuilder("onMessageCenterUnreadCountUpdate. model: ").append(sVar.toString());
        f.a().d.a = sVar.d;
        f.a().c.a = sVar.a;
        f.a().b.a = sVar.b;
        f.a().e.a = sVar.c;
        k();
    }

    public final void update(Observable observable, Object obj) {
        if (!(this.e || (observable instanceof j) == null)) {
            a((s) obj);
        }
    }

    static /* synthetic */ void e(b bVar) {
        bVar.f = true;
        bVar.h.postDelayed(new m(bVar), 500);
    }

    static /* synthetic */ void a(b bVar, boolean z, int i) {
        if (!bVar.e) {
            if (z) {
                z = f.a().a;
                z.a += i;
            } else {
                f.a().a.a = i;
            }
            bVar.k();
        }
    }
}
