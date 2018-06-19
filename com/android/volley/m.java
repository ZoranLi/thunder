package com.android.volley;

import com.android.volley.l.a;

/* compiled from: RequestQueue */
final class m implements a {
    final /* synthetic */ Object a;
    final /* synthetic */ l b;

    m(l lVar, Object obj) {
        this.b = lVar;
        this.a = obj;
    }

    public final boolean a(Request<?> request) {
        return request.getTag() == this.a ? true : null;
    }
}
