package com.xunlei.downloadprovider.download.util;

import java.util.regex.Pattern;

/* compiled from: EpisodeUtil */
final class h extends a {
    final /* synthetic */ b a;

    h(b bVar) {
        this.a = bVar;
    }

    public final Pattern a() {
        if (this.b == null) {
            this.b = Pattern.compile(b.c[0]);
        }
        return this.b;
    }

    protected final com.xunlei.downloadprovider.download.util.e.a a(java.lang.String r5, java.util.regex.Matcher r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new com.xunlei.downloadprovider.download.util.e$a;
        r0.<init>();
        r1 = r6.find();
        if (r1 == 0) goto L_0x004f;
    L_0x000b:
        r1 = 2;
        r2 = r6.start(r1);
        r3 = r6.end(r1);
        if (r2 > r3) goto L_0x004f;
    L_0x0016:
        r2 = r6.start(r1);
        if (r2 < 0) goto L_0x004f;
    L_0x001c:
        r2 = r6.start(r1);
        r1 = r6.end(r1);
        r1 = r5.substring(r2, r1);	 Catch:{ NumberFormatException -> 0x004c }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ NumberFormatException -> 0x004c }
        r1 = r1.intValue();	 Catch:{ NumberFormatException -> 0x004c }
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;	 Catch:{ NumberFormatException -> 0x004c }
        if (r1 >= r2) goto L_0x004f;	 Catch:{ NumberFormatException -> 0x004c }
    L_0x0034:
        r2 = 1;	 Catch:{ NumberFormatException -> 0x004c }
        r3 = r6.start(r2);	 Catch:{ NumberFormatException -> 0x004c }
        r6 = r6.end(r2);	 Catch:{ NumberFormatException -> 0x004c }
        r5 = r5.substring(r3, r6);	 Catch:{ NumberFormatException -> 0x004c }
        r6 = "豆瓣";	 Catch:{ NumberFormatException -> 0x004c }
        r5 = r5.contains(r6);	 Catch:{ NumberFormatException -> 0x004c }
        if (r5 != 0) goto L_0x004f;	 Catch:{ NumberFormatException -> 0x004c }
    L_0x0049:
        r0.b = r1;	 Catch:{ NumberFormatException -> 0x004c }
        goto L_0x004f;
    L_0x004c:
        r5 = -1;
        r0.b = r5;
    L_0x004f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.util.h.a(java.lang.String, java.util.regex.Matcher):com.xunlei.downloadprovider.download.util.e$a");
    }
}
