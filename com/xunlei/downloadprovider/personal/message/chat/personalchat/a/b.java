package com.xunlei.downloadprovider.personal.message.chat.personalchat.a;

import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.m;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.n;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.o;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.PersonalChatDialogActivity;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: PersonalChatManager */
public final class b {
    private static b c;
    public IChatDialog a = null;
    public String b = null;
    private AtomicInteger d = new AtomicInteger();
    private a e = null;
    private h f = null;

    private b() {
        if (d.b()) {
            this.e = new a();
            this.f = new h();
            LoginHelper.a();
            if (l.c()) {
                a(true);
                this.f.a();
            }
            LoginHelper.a().a(new c(this));
            LoginHelper.a().a(new d(this));
            LoginHelper.a().a(new e(this));
        }
    }

    public static void a() {
        b();
    }

    public static b b() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    public static boolean c() {
        return d.b();
    }

    public static boolean d() {
        return d.c();
    }

    public static void a(boolean z) {
        a i = i();
        com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a aVar = (com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a) p.a(com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a.class);
        StringBuilder stringBuilder = new StringBuilder("login. isAutoLogin: ");
        stringBuilder.append(z);
        stringBuilder.append(" isLogin: ");
        stringBuilder.append(aVar.b);
        if (!aVar.b) {
            ChatUser chatUser = new ChatUser();
            com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a.a(i, chatUser);
            aVar.a = chatUser;
            aVar.b = true;
            o a = o.a();
            a.a = new ArrayList();
            com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.l lVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.l(a);
            m mVar = new m(a);
            com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.p pVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.p(a);
            n nVar = new n(a);
            a.a.add(lVar);
            a.a.add(mVar);
            a.a.add(pVar);
            a.a.add(nVar);
            if (z) {
                z = com.xunlei.downloadprovider.pushmessage.b.b.a();
                if (z.a == null) {
                    z = false;
                } else {
                    z = z.a.getBoolean("has_init_chat_data", false);
                }
                if (z) {
                    return;
                }
            }
            z = com.xunlei.downloadprovider.personal.message.chat.chatengine.b.b.a();
            com.xunlei.downloadprovider.personal.message.chat.chatengine.b.n.a().a = true;
            i iVar = new i();
            iVar.a = 1;
            iVar.b = 0;
            iVar.c = 0;
            iVar.d = 0;
            iVar.e = 200;
            new StringBuilder("loadAllDialogsFromServer queryParams: ").append(iVar.toString());
            z.a(true, iVar, new ArrayList(), new com.xunlei.downloadprovider.personal.message.chat.chatengine.b.i(z));
        }
    }

    private static a i() {
        a aVar = new a();
        aVar.a = LoginHelper.a().g.c();
        aVar.b = LoginHelper.a().e();
        aVar.c = LoginHelper.a().g.d();
        switch (g.a[LoginHelper.a().g().ordinal()]) {
            case 1:
                aVar.d = IChatUser.GENDER_FEMALE;
                break;
            case 2:
                break;
            default:
                break;
        }
        aVar.d = IChatUser.GENDER_MALE;
        aVar.d = "unknown";
        aVar.e = "per";
        return aVar;
    }

    public static boolean a(Context context, IChatDialog iChatDialog, String str) {
        Intent intent = new Intent();
        if (d.b() && iChatDialog != null) {
            if (iChatDialog.dialogId() != 0) {
                return a(context, intent, iChatDialog.dialogId(), str);
            }
        }
        return false;
    }

    public static boolean a(Context context, int i, String str) {
        return a(context, new Intent(), i, str);
    }

    public final void a(IChatDialog iChatDialog, int i, String str) {
        if (i == 1) {
            this.b = str;
            this.a = iChatDialog;
            return;
        }
        if (i == 2 && this.a == iChatDialog) {
            this.b = "unknown";
            this.a = null;
        }
    }

    private static boolean a(Context context, Intent intent, int i, String str) {
        if (!d.b()) {
            return false;
        }
        try {
            PersonalChatDialogActivity.a(context, intent, i, str);
            return true;
        } catch (Context context2) {
            context2.getLocalizedMessage();
            return false;
        }
    }

    public final void e() {
        if (d.b()) {
            this.d.incrementAndGet();
            new StringBuilder("enterPersonalChatRelativeInterface mOpenCounter: ").append(this.d.get());
            return;
        }
        throw new RuntimeException("私信开关已经关闭，为什么还调用进入私信相关页面的方法");
    }

    public final void f() {
        if (d.b()) {
            this.d.decrementAndGet();
            new StringBuilder("exitPersonalChatRelativeInterface mOpenCounter: ").append(this.d.get());
            return;
        }
        throw new RuntimeException("私信开关已经关闭，为什么还调用退出私信相关页面的方法");
    }

    public final boolean g() {
        return d.b() && this.d.get() != 0;
    }

    public final void a(h.a aVar) {
        if (d.b()) {
            h hVar = this.f;
            if (hVar.a.contains(aVar)) {
                hVar.a(aVar);
            }
            hVar.a.add(aVar);
        }
    }

    public final void b(h.a aVar) {
        if (d.b()) {
            this.f.a(aVar);
        }
    }
}
