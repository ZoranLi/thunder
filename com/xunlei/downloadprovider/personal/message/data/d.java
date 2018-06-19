package com.xunlei.downloadprovider.personal.message.data;

import android.content.Context;
import com.xunlei.downloadprovider.personal.message.ad;
import com.xunlei.xllib.android.b;

/* compiled from: MessageDataHelper */
public class d {
    private static d a;
    private final g b = new g();
    private final Context c;

    private d(Context context) {
        this.c = context;
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    public final void a(long j, ad adVar) {
        if (b.a(this.c)) {
            this.b.a(j, new e(this, adVar));
        }
    }
}
