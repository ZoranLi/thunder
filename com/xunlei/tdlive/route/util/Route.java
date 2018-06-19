package com.xunlei.tdlive.route.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;

public class Route {
    private HashMap<String, IRoute> a;

    public interface IRoute {
        public static final int ROUTE_RET_INTERRUPT = 0;
        public static final int ROUTE_RET_NEXT = 1;

        int action(Context context, String str, Uri uri);
    }

    public void register(String str, IRoute iRoute) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        if (!TextUtils.isEmpty(str)) {
            if (iRoute != null) {
                this.a.put(str, iRoute);
            }
        }
    }

    public void unregister(String str) {
        if (this.a != null) {
            this.a.remove(str);
        }
    }

    public boolean doRoute(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = android.net.Uri.parse(r8);	 Catch:{ Throwable -> 0x0042 }
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r2 = r5.a;
        if (r2 == 0) goto L_0x0041;
    L_0x000c:
        r2 = r5.a;
        r2 = r2.entrySet();
        r2 = r2.iterator();
    L_0x0016:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x0041;
    L_0x001c:
        r3 = r2.next();
        r3 = (java.util.Map.Entry) r3;
        r4 = r3.getKey();
        r4 = (java.lang.String) r4;
        r4 = r8.startsWith(r4);
        if (r4 == 0) goto L_0x0016;
    L_0x002e:
        r3 = r3.getValue();	 Catch:{ Throwable -> 0x003c }
        r3 = (com.xunlei.tdlive.route.util.Route.IRoute) r3;	 Catch:{ Throwable -> 0x003c }
        r3 = r3.action(r6, r7, r1);	 Catch:{ Throwable -> 0x003c }
        if (r3 != 0) goto L_0x0016;
    L_0x003a:
        r6 = 1;
        return r6;
    L_0x003c:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x0016;
    L_0x0041:
        return r0;
    L_0x0042:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.route.util.Route.doRoute(android.content.Context, java.lang.String, java.lang.String):boolean");
    }
}
