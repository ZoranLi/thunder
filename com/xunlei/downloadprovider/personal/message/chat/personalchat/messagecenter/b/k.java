package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.b;

import com.xunlei.downloadprovider.personal.message.ad;
import com.xunlei.downloadprovider.personal.message.data.s;

/* compiled from: MessageCenterPresenter */
final class k implements ad {
    final /* synthetic */ ad a;
    final /* synthetic */ b b;

    k(b bVar, ad adVar) {
        this.b = bVar;
        this.a = adVar;
    }

    public final void a(s sVar) {
        if (this.a != null) {
            this.a.a(sVar);
        }
        if (!this.b.e) {
            this.b.a(sVar);
        }
    }

    public final void a() {
        if (this.a != null) {
            this.a.a();
        }
        if (!this.b.e) {
        }
    }
}
