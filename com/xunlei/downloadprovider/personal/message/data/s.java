package com.xunlei.downloadprovider.personal.message.data;

import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b;

/* compiled from: MessageUnreadModel */
public final class s {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    private static int a(int i, int i2) {
        i -= i2;
        return i >= 0 ? i : 0;
    }

    public static s a(s sVar, s sVar2) {
        s sVar3 = new s();
        sVar3.a = a(sVar.a, sVar2.a);
        sVar3.b = a(sVar.b, sVar2.b);
        sVar3.c = a(sVar.c, sVar2.c);
        sVar3.d = a(sVar.d, sVar2.d);
        sVar3.a(a(sVar.e, sVar2.e));
        return sVar3;
    }

    public final void a() {
        a(0, 0, 0, 0, 0);
    }

    public final s b() {
        s sVar = new s();
        sVar.a(this);
        return sVar;
    }

    public final void a(int i) {
        if (b.c()) {
            this.e = i;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MessageUnreadModel{mUnCommentRead=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mUnFollowRead=");
        stringBuilder.append(this.b);
        stringBuilder.append(", mUnStarRead=");
        stringBuilder.append(this.c);
        stringBuilder.append(", mUnVisitorRead=");
        stringBuilder.append(this.d);
        stringBuilder.append(", mUnChatRead=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final void a(s sVar) {
        if (sVar != null) {
            a(sVar.a, sVar.b, sVar.c, sVar.d, sVar.e);
        }
    }

    private void a(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        a(i5);
    }
}
