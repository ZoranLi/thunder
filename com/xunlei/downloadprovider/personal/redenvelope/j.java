package com.xunlei.downloadprovider.personal.redenvelope;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: RedPacketOpenHelper */
final class j implements a {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.a.a();
        new StringBuilder("getZhiboRoomInfo  onErrorResponse").append(volleyError.toString());
    }
}
