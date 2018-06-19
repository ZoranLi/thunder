package com.xunlei.downloadprovider.personal.message.data;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.message.ad;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j;

/* compiled from: MessageDataHelper */
final class e implements ad {
    final /* synthetic */ ad a;
    final /* synthetic */ d b;

    e(d dVar, ad adVar) {
        this.b = dVar;
        this.a = adVar;
    }

    public final void a(s sVar) {
        LoginHelper.a();
        if (l.c()) {
            j.b().a(sVar);
        }
        if (this.a != null) {
            this.a.a(sVar);
        }
    }

    public final void a() {
        if (this.a != null) {
            this.a.a();
        }
    }
}
