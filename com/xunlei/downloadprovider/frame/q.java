package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.f;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.h.a;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

/* compiled from: MainTabActivity */
final class q implements a {
    final /* synthetic */ MainTabActivity a;

    q(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void a(f fVar) {
        MainTabActivity.b(this.a, MainTabActivity.l(this.a) + fVar.a());
        if (MainTabActivity.l(this.a) > null && MessageInfo.USER.equals(MainTabActivity.b(this.a).getCurrentTag()) == null) {
            this.a.a(true, MainTabActivity.l(this.a) > 99 ? "99+" : String.valueOf(MainTabActivity.l(this.a)));
        }
    }
}
