package com.alibaba.baichuan.android.trade.adapter.c;

import com.ali.auth.third.a.b;

public final class a {
    public static final a a = new a();
    public b b;

    private static class a {
        public static a a = new a();
    }

    private a() {
    }

    public static a a() {
        return a.a;
    }

    public final synchronized void b() {
        if (this.b == null) {
            this.b = (b) com.ali.auth.third.core.a.a(b.class);
        }
    }
}
