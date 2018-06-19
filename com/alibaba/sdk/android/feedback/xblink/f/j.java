package com.alibaba.sdk.android.feedback.xblink.f;

import android.content.Context;
import android.content.Intent;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import java.util.HashMap;
import java.util.Map;

public class j {
    private Context a = null;
    private XBHybridWebView b = null;
    private Map c = new HashMap();

    public j(Context context, XBHybridWebView xBHybridWebView) {
        this.a = context;
        this.b = xBHybridWebView;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Object a(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.c;	 Catch:{ all -> 0x001c }
        r0 = r0.get(r4);	 Catch:{ all -> 0x001c }
        if (r0 != 0) goto L_0x001a;
    L_0x0009:
        r1 = r3.a;	 Catch:{ all -> 0x001c }
        r2 = r3.b;	 Catch:{ all -> 0x001c }
        r1 = com.alibaba.sdk.android.feedback.xblink.f.k.a(r4, r1, r2);	 Catch:{ all -> 0x001c }
        if (r1 == 0) goto L_0x001a;
    L_0x0013:
        r0 = r3.c;	 Catch:{ all -> 0x001c }
        r0.put(r4, r1);	 Catch:{ all -> 0x001c }
        monitor-exit(r3);
        return r1;
    L_0x001a:
        monitor-exit(r3);
        return r0;
    L_0x001c:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.j.a(java.lang.String):java.lang.Object");
    }

    public synchronized void a() {
        for (Object next : this.c.values()) {
            if (next instanceof a) {
                ((a) next).a();
            }
        }
    }

    public synchronized void a(int i, int i2, Intent intent) {
        for (Object next : this.c.values()) {
            if (next instanceof a) {
                ((a) next).a(i, i2, intent);
            }
        }
    }

    public synchronized void a(String str, Object obj) {
        this.c.put(str, obj);
    }

    public synchronized void b() {
        for (Object next : this.c.values()) {
            if (next instanceof a) {
                ((a) next).b();
            }
        }
    }

    public synchronized void c() {
        for (Object next : this.c.values()) {
            if (next instanceof a) {
                ((a) next).c();
            }
        }
    }
}
