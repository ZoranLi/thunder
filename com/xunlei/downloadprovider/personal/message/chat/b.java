package com.xunlei.downloadprovider.personal.message.chat;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a;

/* compiled from: ErrorInfo */
public final class b {
    public int a;
    public int b;
    public String c;

    private b(int i, String str) {
        this.a = i;
        this.c = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("errorCode=");
        stringBuilder.append(this.a);
        stringBuilder.append(", errorMsg='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        return stringBuilder.toString();
    }

    public static b a(int i, String str) {
        return new b(i, str);
    }

    public static b a(int i, int i2, String str) {
        i = a(i, str);
        i.b = i2;
        return i;
    }

    public static b a(a aVar) {
        return a(aVar.b, aVar.d, aVar.c);
    }
}
