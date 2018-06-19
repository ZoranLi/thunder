package com.getui.gtc.b;

import com.getui.gtc.entity.d;

public final class a {
    String a;
    String b;
    a c;

    public interface a {
        void a(d dVar, int i, String str);
    }

    private a() {
    }

    public static a a() {
        a aVar = new a();
        try {
            aVar.a = com.getui.gtc.a.a.c;
            aVar.b = com.getui.gtc.a.a.b;
            return aVar;
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            return aVar;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.getui.gtc.entity.d r6, com.getui.gtc.entity.a.a r7) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r7.i;	 Catch:{ all -> 0x003c }
        r1 = r7.c;	 Catch:{ all -> 0x003c }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x003c }
        if (r1 != 0) goto L_0x003a;
    L_0x000b:
        r1 = android.webkit.URLUtil.isNetworkUrl(r0);	 Catch:{ all -> 0x003c }
        if (r1 != 0) goto L_0x0012;
    L_0x0011:
        goto L_0x003a;
    L_0x0012:
        r1 = r7.c;	 Catch:{ Throwable -> 0x002d }
        r2 = 0;
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x002d }
        r4 = r5.a;	 Catch:{ Throwable -> 0x002d }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x002d }
        r1 = java.io.File.createTempFile(r1, r2, r3);	 Catch:{ Throwable -> 0x002d }
        r2 = new com.getui.gtc.b.b;	 Catch:{ Throwable -> 0x002d }
        r2.<init>(r5, r7, r1, r6);	 Catch:{ Throwable -> 0x002d }
        com.getui.gtc.c.c.a();	 Catch:{ Throwable -> 0x002d }
        com.getui.gtc.c.c.a(r0, r1, r2);	 Catch:{ Throwable -> 0x002d }
        monitor-exit(r5);
        return;
    L_0x002d:
        r6 = move-exception;
        r7 = 1;
        r7 = new java.lang.String[r7];	 Catch:{ all -> 0x003c }
        r0 = 0;
        r6 = r6.toString();	 Catch:{ all -> 0x003c }
        r7[r0] = r6;	 Catch:{ all -> 0x003c }
        monitor-exit(r5);
        return;
    L_0x003a:
        monitor-exit(r5);
        return;
    L_0x003c:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.b.a.a(com.getui.gtc.entity.d, com.getui.gtc.entity.a$a):void");
    }
}
