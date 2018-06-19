package com.xunlei.downloadprovider.download.util;

import java.util.regex.Pattern;

/* compiled from: EpisodeUtil */
final class g extends a {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public final Pattern a() {
        if (this.b == null) {
            this.b = Pattern.compile(b.b[0], 2);
        }
        return this.b;
    }

    protected final com.xunlei.downloadprovider.download.util.e.a a(java.lang.String r6, java.util.regex.Matcher r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new com.xunlei.downloadprovider.download.util.e$a;
        r0.<init>();
        r1 = r7.find();
        if (r1 == 0) goto L_0x005c;
    L_0x000b:
        r7 = r7.toMatchResult();
        r1 = 1;
        r2 = r7.start(r1);
        r3 = r7.end(r1);
        r4 = -1;
        if (r2 > r3) goto L_0x0036;
    L_0x001b:
        r2 = r7.start(r1);
        if (r2 < 0) goto L_0x0036;
    L_0x0021:
        r2 = r7.start(r1);
        r1 = r7.end(r1);
        r1 = r6.substring(r2, r1);
        r1 = com.xunlei.downloadprovider.download.util.e.b.a(r1);	 Catch:{ NumberFormatException -> 0x0034 }
        r0.a = r1;	 Catch:{ NumberFormatException -> 0x0034 }
        goto L_0x0036;
    L_0x0034:
        r0.a = r4;
    L_0x0036:
        r1 = 2;
        r2 = r7.start(r1);
        r3 = r7.end(r1);
        if (r2 > r3) goto L_0x005c;
    L_0x0041:
        r2 = r7.start(r1);
        if (r2 < 0) goto L_0x005c;
    L_0x0047:
        r2 = r7.start(r1);
        r7 = r7.end(r1);
        r6 = r6.substring(r2, r7);
        r6 = com.xunlei.downloadprovider.download.util.e.b.a(r6);	 Catch:{ NumberFormatException -> 0x005a }
        r0.b = r6;	 Catch:{ NumberFormatException -> 0x005a }
        goto L_0x005c;
    L_0x005a:
        r0.b = r4;
    L_0x005c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.util.g.a(java.lang.String, java.util.regex.Matcher):com.xunlei.downloadprovider.download.util.e$a");
    }
}
