package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatDialogs */
public final class b implements g {
    public List<IChatDialog> a;
    public List<IChatDialog> b;
    public List<IChatDialog> c;
    private int d;

    public b() {
        this.d = 0;
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final List<IChatDialog> a() {
        return this.a;
    }

    public final List<IChatDialog> b() {
        return this.b;
    }

    public final List<IChatDialog> c() {
        return this.c;
    }

    public final List<IChatDialog> a(int i) {
        switch (i) {
            case 1:
                return this.a;
            case 2:
                return this.c;
            case 3:
                return this.b;
            default:
                return 0;
        }
    }
}
