package com.getui.gtc.d.a;

import android.text.TextUtils;
import com.getui.gtc.a.h;
import com.getui.gtc.e.a.b;
import com.getui.gtc.e.a.c;
import com.getui.gtc.e.i;

final class e implements b {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void a(c cVar) {
        try {
            String str = cVar.a;
            if (!TextUtils.isEmpty(str)) {
                this.a.d = str;
                this.a.a(1, 3, i.a(str.getBytes(), h.b));
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }
}
