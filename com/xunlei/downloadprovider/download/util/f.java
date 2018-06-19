package com.xunlei.downloadprovider.download.util;

import java.util.regex.Pattern;

/* compiled from: EpisodeUtil */
final class f extends a {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public final Pattern a() {
        if (this.b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.a[0]);
            stringBuilder.append("|");
            stringBuilder.append(b.a[1]);
            stringBuilder.append("|");
            stringBuilder.append(b.a[2]);
            stringBuilder.append("|");
            stringBuilder.append(b.a[3]);
            this.b = Pattern.compile(stringBuilder.toString(), 2);
        }
        return this.b;
    }

    protected final com.xunlei.downloadprovider.download.util.e.a a(java.lang.String r8, java.util.regex.Matcher r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = new com.xunlei.downloadprovider.download.util.e$a;
        r0.<init>();
        r1 = r9.find();
        if (r1 == 0) goto L_0x006f;
    L_0x000b:
        r9 = r9.toMatchResult();
        r1 = -1;
        r2 = 1;
        r4 = r1;
        r3 = r2;
    L_0x0013:
        r5 = r9.groupCount();
        if (r3 >= r5) goto L_0x004f;
    L_0x0019:
        r5 = r9.start(r3);
        r6 = r9.end(r3);
        if (r5 > r6) goto L_0x003b;
    L_0x0023:
        r5 = r9.start(r3);
        if (r5 < 0) goto L_0x003b;
    L_0x0029:
        r4 = r9.start(r3);
        r5 = r9.end(r3);
        r4 = r8.substring(r4, r5);
        r4 = com.xunlei.downloadprovider.download.util.e.b.a(r4);	 Catch:{ NumberFormatException -> 0x003a }
        goto L_0x003b;
    L_0x003a:
        r4 = r1;
    L_0x003b:
        if (r3 != r2) goto L_0x004c;
    L_0x003d:
        r5 = r9.end();
        r5 = r5 - r2;
        r6 = r9.end();
        r5 = r8.substring(r5, r6);
        r0.c = r5;
    L_0x004c:
        r3 = r3 + 1;
        goto L_0x0013;
    L_0x004f:
        r0.b = r4;
        r9 = "第(.+)(?:季|部)";
        r9 = java.util.regex.Pattern.compile(r9);
        r9 = r9.matcher(r8);
        r1 = r9.find();
        if (r1 == 0) goto L_0x006f;
    L_0x0061:
        r1 = r9.start();
        r9 = r9.end();
        r8 = r8.substring(r1, r9);
        r0.d = r8;
    L_0x006f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.util.f.a(java.lang.String, java.util.regex.Matcher):com.xunlei.downloadprovider.download.util.e$a");
    }
}
