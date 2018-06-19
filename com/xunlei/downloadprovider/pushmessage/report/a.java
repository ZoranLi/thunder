package com.xunlei.downloadprovider.pushmessage.report;

import android.content.Context;
import com.xunlei.xllib.android.b;

/* compiled from: PushDataHelper */
public class a {
    private static a c;
    public final b a = new b();
    public final Context b;

    private a(Context context) {
        this.b = context;
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    public final void a() {
        if (b.a(this.b)) {
            this.a.a(true);
        }
    }
}
