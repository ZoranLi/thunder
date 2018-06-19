package com.xunlei.downloadprovider.personal.message;

import com.xunlei.downloadprovider.personal.message.data.s;

/* compiled from: MessageActivty */
final class b implements ad {
    final /* synthetic */ MessageActivty a;

    public final void a() {
    }

    b(MessageActivty messageActivty) {
        this.a = messageActivty;
    }

    public final void a(s sVar) {
        MessageActivty.a;
        StringBuilder stringBuilder = new StringBuilder("unCommentRead =");
        stringBuilder.append(sVar.a);
        stringBuilder.append(",unFollowRead = ");
        stringBuilder.append(sVar.b);
        stringBuilder.append("，unStarRead =");
        stringBuilder.append(sVar.c);
        MessageActivty.a(this.a, this.a.l, (long) sVar.a, 0);
        MessageActivty.a(this.a, this.a.m, (long) sVar.c, 1);
        MessageActivty.a(this.a, this.a.n, (long) sVar.b, 2);
    }
}
