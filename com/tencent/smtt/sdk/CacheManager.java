package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.v;
import java.io.File;
import java.io.InputStream;

public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        Object a;
        bk b = bk.b();
        if (b == null || !b.c()) {
            a = v.a("android.webkit.CacheManager", "cacheDisabled");
            if (a == null) {
                return false;
            }
        }
        a = b.d().c();
        return ((Boolean) a).booleanValue();
    }

    public static InputStream getCacheFile(String str, boolean z) {
        bk b = bk.b();
        return (b == null || !b.c()) ? null : b.d().a(str, z);
    }

    public static java.lang.Object getCacheFile(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.smtt.sdk.bk.b();
        if (r0 == 0) goto L_0x0015;
    L_0x0006:
        r1 = r0.c();
        if (r1 == 0) goto L_0x0015;
    L_0x000c:
        r7 = r0.d();
        r7 = r7.g();
        return r7;
    L_0x0015:
        r0 = "android.webkit.CacheManager";	 Catch:{ Exception -> 0x0035 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0035 }
        r1 = "getCacheFile";	 Catch:{ Exception -> 0x0035 }
        r2 = 2;	 Catch:{ Exception -> 0x0035 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0035 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0035 }
        r5 = 0;	 Catch:{ Exception -> 0x0035 }
        r3[r5] = r4;	 Catch:{ Exception -> 0x0035 }
        r4 = java.util.Map.class;	 Catch:{ Exception -> 0x0035 }
        r6 = 1;	 Catch:{ Exception -> 0x0035 }
        r3[r6] = r4;	 Catch:{ Exception -> 0x0035 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0035 }
        r2[r5] = r7;	 Catch:{ Exception -> 0x0035 }
        r2[r6] = r8;	 Catch:{ Exception -> 0x0035 }
        r7 = com.tencent.smtt.utils.v.a(r0, r1, r3, r2);	 Catch:{ Exception -> 0x0035 }
        return r7;
    L_0x0035:
        r7 = 0;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.CacheManager.getCacheFile(java.lang.String, java.util.Map):java.lang.Object");
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        bk b = bk.b();
        Object a = (b == null || !b.c()) ? v.a("android.webkit.CacheManager", "getCacheFileBaseDir") : b.d().g();
        return (File) a;
    }
}
