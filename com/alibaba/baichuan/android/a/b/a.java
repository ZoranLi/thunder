package com.alibaba.baichuan.android.a.b;

import android.content.Context;
import com.alibaba.baichuan.android.trade.c.b.d;

public abstract class a {
    protected Context b;
    protected d c;
    public Object d;
    protected boolean e = true;

    public final void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public final void a(Context context, d dVar, Object obj) {
        this.b = context;
        this.c = dVar;
        this.d = obj;
    }

    public abstract boolean a(String str, String str2, com.alibaba.baichuan.android.a.d dVar);
}
