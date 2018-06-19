package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b;

import android.os.Bundle;
import android.os.Message;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.aa;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatTextMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.h;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a.d;

/* compiled from: DialogTransmitterPresenter */
public final class f implements c {
    d a = null;
    String b;
    boolean c = false;
    private e d = null;
    private IChatDialog e = null;

    public f(d dVar, e eVar) {
        this.a = dVar;
        this.d = eVar;
        this.a.a(this);
        this.d.a((c) this);
    }

    public final void b() {
        this.c = false;
        if (!b.d()) {
            this.a.b();
            this.a.a();
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            int i = bundle.getInt("chat_dialog_id");
            this.b = bundle.getString("chat_dialog_from");
            this.e = ((aa) p.a(aa.class)).a(i);
        }
    }

    public final boolean a(IChatMessage iChatMessage) {
        b(iChatMessage);
        return true;
    }

    public final boolean a(String str) {
        h.a();
        IChatMessage a = h.a(false);
        a.setMessageContent(new ChatTextMessageContent(str));
        str = a.messageContent().checkMyself();
        if (str.a) {
            str = 1;
        } else {
            this.a.a(str.b);
            str = null;
        }
        if (str == null) {
            return false;
        }
        str = com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b.a();
        IChatUser targetUser = this.e.targetUser();
        Integer num = (Integer) str.e.get(Long.valueOf(targetUser.userId()));
        int intValue = num != null ? num.intValue() : 0;
        StringBuilder stringBuilder = new StringBuilder("preMessageSend chatUser. userId: ");
        stringBuilder.append(targetUser.userId());
        stringBuilder.append(" messageSentCount: ");
        stringBuilder.append(intValue);
        if (intValue >= 10) {
            Message obtainMessage = str.g.obtainMessage(1001);
            obtainMessage.obj = Long.valueOf(targetUser.userId());
            str.g.sendMessageDelayed(obtainMessage, com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b.c);
            str.f.add(Long.valueOf(targetUser.userId()));
        }
        if (b.d() == null) {
            this.a.a((int) R.string.personal_chat_disabled);
        } else if (com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b.a().a(this.e.targetUser().userId()) != null) {
            this.a.a((int) R.string.personal_chat_dialog_message_send_frequently);
        } else {
            str = 1;
            if (str == null) {
                return false;
            }
            com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.e, this.b, "send");
            b(a);
            return true;
        }
        str = null;
        if (str == null) {
            return false;
        }
        com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.e, this.b, "send");
        b(a);
        return true;
    }

    private void b(IChatMessage iChatMessage) {
        iChatMessage.sendTo(this.e, new g(this, iChatMessage));
    }

    public final void a() {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.e, this.b, "input");
        if (!b.d()) {
            this.a.a((int) R.string.personal_chat_disabled);
        }
    }

    public final void c() {
        this.a.c();
    }

    public final void d() {
        this.c = true;
    }
}
