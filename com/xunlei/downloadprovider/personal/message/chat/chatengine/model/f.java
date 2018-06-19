package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

/* compiled from: ChatUnreadCountInfo */
public final class f {
    public int a = 0;
    private int b = 0;

    public final int a() {
        return this.b + this.a;
    }

    public final void a(int i, int i2) {
        switch (i) {
            case 2:
                this.a = i2;
                break;
            case 3:
                this.b = i2;
                return;
            default:
                break;
        }
    }
}
