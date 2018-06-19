package com.android.volley;

import com.android.volley.n.a;

/* compiled from: BaseRequest */
public abstract class r<T> extends Request<T> {
    private l a;

    public r(int i, String str, a aVar) {
        super(i, str, aVar);
    }

    public Request<?> setRequestQueue(l lVar) {
        this.a = lVar;
        super.setRequestQueue(lVar);
        return this;
    }

    public void addMarker(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        super.addMarker(r1);	 Catch:{ Throwable -> 0x0004 }
        return;
    L_0x0004:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.r.addMarker(java.lang.String):void");
    }

    void finish(String str) {
        if (this.a != null) {
            this.a.b(this);
        }
    }
}
