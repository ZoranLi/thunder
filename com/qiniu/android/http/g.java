package com.qiniu.android.http;

import com.qiniu.android.d.e.a;
import okhttp3.ab$a;
import okhttp3.ab.b;
import okhttp3.ag;
import okhttp3.internal.c;

/* compiled from: Client */
final class g implements a {
    final /* synthetic */ ab$a a;
    final /* synthetic */ a b;

    g(a aVar, ab$a okhttp3_ab_a) {
        this.b = aVar;
        this.a = okhttp3_ab_a;
    }

    public final void a(String str, Object obj) {
        ab$a okhttp3_ab_a = this.a;
        obj = obj.toString().getBytes(c.e);
        okhttp3_ab_a.a(b.a(str, null, ag.a(null, obj, obj.length)));
    }
}
