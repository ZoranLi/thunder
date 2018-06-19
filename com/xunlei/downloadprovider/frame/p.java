package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.message.ad;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j;
import com.xunlei.downloadprovider.personal.message.data.s;

/* compiled from: MainTabActivity */
final class p implements ad {
    final /* synthetic */ MainTabActivity a;

    public final void a() {
    }

    p(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void a(s sVar) {
        MainTabActivity.k(this.a);
        if (l.c()) {
            j b = j.b();
            s sVar2 = b.e() ? new s() : s.a(b.a, b.c.a.b());
            int i = sVar2.a;
            int i2 = sVar2.b;
            int i3 = sVar2.c;
            int i4 = sVar2.e;
            StringBuilder stringBuilder = new StringBuilder("commentUnreadCount, followUnreadCount, startUnreadCount, chatUnreadCount = ");
            stringBuilder.append(i);
            stringBuilder.append(", ");
            stringBuilder.append(i2);
            stringBuilder.append(", ");
            stringBuilder.append(i3);
            stringBuilder.append(", ");
            stringBuilder.append(i4);
            MainTabActivity.b(this.a, ((sVar.a + sVar.b) + sVar.c) + sVar.e);
            if (i <= 0 && i2 <= 0 && i3 <= 0) {
                if (i4 <= 0) {
                    this.a.a(false, null);
                    return;
                }
            }
            this.a.a(true, MainTabActivity.l(this.a) > 99 ? "99+" : String.valueOf(MainTabActivity.l(this.a)));
        }
    }
}
