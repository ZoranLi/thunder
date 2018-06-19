package com.xunlei.downloadprovider.personal.a.c;

import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.message.ad;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j;
import com.xunlei.downloadprovider.personal.message.data.s;

/* compiled from: UserInfoViewHolder */
final class ah implements ad {
    final /* synthetic */ s a;

    public final void a() {
    }

    ah(s sVar) {
        this.a = sVar;
    }

    public final void a(s sVar) {
        this.a.W;
        if (l.c() != null) {
            sVar = j.b().b;
            if (sVar.b) {
                sVar.a.a(j.b().c());
                sVar.a(j.b().c());
                sVar.b = false;
            }
            sVar = j.b().c;
            sVar.a.a(j.b().c());
            sVar.a(j.b().c());
            this.a.j();
            this.a.i();
            ((MainTabActivity) this.a.X).h = j.b().d();
        }
    }
}
