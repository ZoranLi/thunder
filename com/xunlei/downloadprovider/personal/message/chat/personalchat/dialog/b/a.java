package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.taobao.accs.utl.BaseMonitor;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.aa;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ac;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.r;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.b;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import java.util.List;

/* compiled from: DialogContentPresenter */
public final class a implements r, com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.a {
    b a = null;
    IChatDialog b = null;
    boolean c = false;
    private e d = null;
    private com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.b e = null;
    private String f;

    public a(com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.b bVar, b bVar2, e eVar) {
        this.d = eVar;
        this.e = bVar;
        this.a = bVar2;
        this.a.a(this);
        this.d.a((com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.a) this);
    }

    public final void b() {
        this.c = false;
        ((ac) p.a(ac.class)).a(this);
        this.a.a(this.b);
        this.a.a(false);
        this.e.a(this.b, null, new c(this));
        IChatDialog iChatDialog = this.b;
        String str = this.f;
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "chat_pannel_show");
        c.a(iChatDialog, str, build);
        ThunderReport.reportEvent(build);
        this.e.a(this.b, new b(this));
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            int i = bundle.getInt("chat_dialog_id");
            this.f = bundle.getString("chat_dialog_from");
            if (TextUtils.isEmpty(this.f) != null) {
                this.f = "unknown";
            }
            this.b = ((aa) p.a(aa.class)).a(i);
        }
    }

    public final void a() {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b().a(this.b, 1, this.f);
        e();
    }

    public final void c() {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b().a(this.b, 2, this.f);
    }

    public final void d() {
        this.c = true;
        com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b b = com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.b();
        b.b = "unknown";
        b.a = null;
        ((ac) p.a(ac.class)).b(this);
        this.a.c();
    }

    public final void e() {
        this.b.clearUnreadCount();
    }

    @SuppressLint({"SwitchIntDef"})
    public final void a(int i, IChatMessage iChatMessage) {
        if (i != 0) {
            switch (i) {
                case 2:
                    if (iChatMessage.messageStatus() == 4) {
                        this.a.c(iChatMessage);
                        break;
                    }
                    break;
                case 3:
                    c.a(iChatMessage.chatDialog(), this.f, "avatar");
                    this.a.a(com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a.a().a, From.PERSONAL_CHAT_DIALOG);
                    return;
                default:
                    break;
            }
            return;
        }
        c.a(iChatMessage.chatDialog(), this.f, "avatar");
        this.a.a(iChatMessage.chatDialog().targetUser(), From.PERSONAL_CHAT_DIALOG);
    }

    @SuppressLint({"SwitchIntDef"})
    public final void b(IChatMessage iChatMessage) {
        if (iChatMessage.messageContent().type() == 1) {
            c.a(this.b, this.f, "copy");
            this.a.a(iChatMessage.messageContent().previewText());
            this.a.e();
        }
    }

    public final void c(IChatMessage iChatMessage) {
        c.a(this.b, this.f, BaseMonitor.COUNT_POINT_RESEND);
        this.d.a(iChatMessage);
    }

    public final String f() {
        return this.f;
    }

    public final void g() {
        this.d.a();
    }

    public final void h() {
        c.a(this.b, this.f, "menu");
        this.a.c(this.b);
    }

    public final void a(List<IChatMessage> list) {
        IChatMessage iChatMessage;
        if (!list.isEmpty()) {
            iChatMessage = (IChatMessage) list.get(0);
            new StringBuilder("onMessageAdd: ").append(iChatMessage.toString());
            if (d(iChatMessage)) {
                this.a.a(iChatMessage);
                i();
            }
        }
        for (IChatMessage iChatMessage2 : list) {
            if (!e.a(iChatMessage2)) {
                com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b.a().a(iChatMessage2);
            }
        }
    }

    public final void b(List<IChatMessage> list) {
        if (!list.isEmpty()) {
            IChatMessage iChatMessage = (IChatMessage) list.get(0);
            new StringBuilder("onMessageChange: ").append(iChatMessage.toString());
            if (d(iChatMessage)) {
                this.a.b(iChatMessage);
                i();
            }
        }
    }

    private boolean d(IChatMessage iChatMessage) {
        return iChatMessage.chatDialog().dialogId() == this.b.dialogId() ? true : null;
    }

    public final void a(@Nullable IChatMessage iChatMessage) {
        this.e.a(this.b, iChatMessage, new d(this));
    }

    final void i() {
        if (this.a.h().getItemCount() == 0) {
            this.a.f();
        } else {
            this.a.g();
        }
    }
}
