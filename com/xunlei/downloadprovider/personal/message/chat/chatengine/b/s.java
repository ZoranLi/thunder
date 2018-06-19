package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.j;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.o;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.SingleChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;
import com.xunlei.downloadprovider.pushmessage.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: ChatMessageService */
public final class s implements ac, a {
    private static s a;
    private Set<r> b;

    public final /* synthetic */ void a(Object obj) {
        IChatMessage a = a((String) obj);
        new StringBuilder("onPushMessageReceived pushMessage: ").append(a == null ? "null" : a.toString());
        if (a != null) {
            a(a);
        }
    }

    private s() {
        this.b = null;
        this.b = new HashSet();
        com.xunlei.downloadprovider.pushmessage.a.a().a(this);
    }

    public static s a() {
        if (a == null) {
            a = new s();
        }
        return a;
    }

    public final void a(r rVar) {
        this.b.add(rVar);
    }

    public final void b(r rVar) {
        this.b.remove(rVar);
    }

    public final void a(IChatMessage iChatMessage) {
        List<IChatMessage> singletonList = Collections.singletonList(iChatMessage);
        for (IChatMessage iChatMessage2 : singletonList) {
            c(iChatMessage2);
            d(iChatMessage2);
        }
        for (r a : this.b) {
            a.a(singletonList);
        }
        b.a().a((List) singletonList);
    }

    public final void b(IChatMessage iChatMessage) {
        IChatMessage<IChatMessage> singletonList = Collections.singletonList(iChatMessage);
        for (IChatMessage iChatMessage2 : singletonList) {
            c(iChatMessage2);
            d(iChatMessage2);
        }
        for (r b : this.b) {
            b.b(singletonList);
        }
        q.a().execute(new j(b.a(), new ArrayList(singletonList)));
    }

    public final IChatMessage a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (String str2) {
            str2.printStackTrace();
            jSONObject = null;
        }
        str2 = o.a.a(true, jSONObject);
        if (com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a(str2)) {
            return (IChatMessage) str2.a;
        }
        StringBuilder stringBuilder = new StringBuilder("parse push message error. errorCode: ");
        stringBuilder.append(str2.b);
        stringBuilder.append(" errorMsg: ");
        stringBuilder.append(str2.c);
        return null;
    }

    private static void c(IChatMessage iChatMessage) {
        if (iChatMessage.chatDialog() instanceof SingleChatDialog) {
            ((SingleChatDialog) iChatMessage.chatDialog()).tryUpdateAllLastMessage(iChatMessage);
        }
    }

    private static void d(IChatMessage iChatMessage) {
        if (!e.a(iChatMessage) && (iChatMessage.chatDialog() instanceof SingleChatDialog)) {
            SingleChatDialog singleChatDialog = (SingleChatDialog) iChatMessage.chatDialog();
            switch (iChatMessage.messageStatus()) {
                case 2:
                    singleChatDialog.increaseUnreadCount(1);
                    break;
                case 3:
                    singleChatDialog.decreaseUnreadCount(1);
                    return;
                default:
                    break;
            }
        }
    }

    public final void a(IChatDialog iChatDialog, i iVar, c<List<IChatMessage>> cVar) {
        o a = o.a();
        c tVar = new t(this, cVar);
        if (!((iChatDialog instanceof SingleChatDialog) == null || iChatDialog.targetUser() == null)) {
            if (iChatDialog.targetUser().userId() != 0) {
                q.a().execute(new p(a, iChatDialog, iVar, tVar));
                return;
            }
        }
        tVar.a(com.xunlei.downloadprovider.personal.message.chat.b.a(-1000, "args error"));
    }
}
