package com.tencent.a.a.a.a;

import android.content.Context;
import com.tencent.wxop.stat.common.g;

public final class e extends f {
    public e(Context context) {
        super(context);
    }

    protected final void a(String str) {
        synchronized (this) {
            g.a(this.a).a(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }

    protected final boolean a() {
        return h.a(this.a, "android.permission.WRITE_SETTINGS");
    }

    protected final String b() {
        String a;
        synchronized (this) {
            a = g.a(this.a).a(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return a;
    }
}
