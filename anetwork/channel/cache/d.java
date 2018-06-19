package anetwork.channel.cache;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: Taobao */
public final class d {
    private static final TimeZone a = TimeZone.getTimeZone("GMT");
    private static final DateFormat b;

    static {
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        b = simpleDateFormat;
        simpleDateFormat.setTimeZone(a);
    }

    public static String a(long j) {
        return b.format(new Date(j));
    }

    private static long a(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r5.length();
        r1 = 0;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r0 = new java.text.ParsePosition;	 Catch:{ Exception -> 0x0024 }
        r3 = 0;	 Catch:{ Exception -> 0x0024 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0024 }
        r3 = b;	 Catch:{ Exception -> 0x0024 }
        r3 = r3.parse(r5, r0);	 Catch:{ Exception -> 0x0024 }
        r0 = r0.getIndex();	 Catch:{ Exception -> 0x0024 }
        r5 = r5.length();	 Catch:{ Exception -> 0x0024 }
        if (r0 != r5) goto L_0x0024;	 Catch:{ Exception -> 0x0024 }
    L_0x001f:
        r3 = r3.getTime();	 Catch:{ Exception -> 0x0024 }
        return r3;
    L_0x0024:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.cache.d.a(java.lang.String):long");
    }

    public static anetwork.channel.cache.Cache.Entry a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = java.lang.System.currentTimeMillis();
        r2 = "Cache-Control";
        r2 = anet.channel.util.a.b(r14, r2);
        r3 = 0;
        r4 = 0;
        if (r2 == 0) goto L_0x004a;
    L_0x000f:
        r6 = ",";
        r2 = r2.split(r6);
        r6 = r4;
    L_0x0016:
        r8 = r2.length;
        if (r3 >= r8) goto L_0x0048;
    L_0x0019:
        r8 = r2[r3];
        r8 = r8.trim();
        r9 = "no-cache";
        r9 = r8.equals(r9);
        if (r9 != 0) goto L_0x0046;
    L_0x0027:
        r9 = "no-store";
        r9 = r8.equals(r9);
        if (r9 == 0) goto L_0x0030;
    L_0x002f:
        goto L_0x0046;
    L_0x0030:
        r9 = "max-age=";
        r9 = r8.startsWith(r9);
        if (r9 == 0) goto L_0x0043;
    L_0x0038:
        r9 = 8;
        r8 = r8.substring(r9);	 Catch:{ Exception -> 0x0043 }
        r8 = java.lang.Long.parseLong(r8);	 Catch:{ Exception -> 0x0043 }
        r6 = r8;
    L_0x0043:
        r3 = r3 + 1;
        goto L_0x0016;
    L_0x0046:
        r14 = 0;
        return r14;
    L_0x0048:
        r3 = 1;
        goto L_0x004b;
    L_0x004a:
        r6 = r4;
    L_0x004b:
        r2 = "Date";
        r2 = anet.channel.util.a.b(r14, r2);
        if (r2 == 0) goto L_0x0058;
    L_0x0053:
        r8 = a(r2);
        goto L_0x0059;
    L_0x0058:
        r8 = r4;
    L_0x0059:
        r2 = "Expires";
        r2 = anet.channel.util.a.b(r14, r2);
        if (r2 == 0) goto L_0x0066;
    L_0x0061:
        r10 = a(r2);
        goto L_0x0067;
    L_0x0066:
        r10 = r4;
    L_0x0067:
        r2 = "Last-Modified";
        r2 = anet.channel.util.a.b(r14, r2);
        if (r2 == 0) goto L_0x0074;
    L_0x006f:
        r12 = a(r2);
        goto L_0x0075;
    L_0x0074:
        r12 = r4;
    L_0x0075:
        r2 = "ETag";
        r2 = anet.channel.util.a.b(r14, r2);
        if (r3 == 0) goto L_0x0083;
    L_0x007d:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 * r3;
        r4 = r0 + r6;
        goto L_0x0090;
    L_0x0083:
        r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r3 <= 0) goto L_0x0090;
    L_0x0087:
        r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r3 < 0) goto L_0x0090;
    L_0x008b:
        r3 = r10 - r8;
        r5 = r0 + r3;
        r4 = r5;
    L_0x0090:
        r0 = new anetwork.channel.cache.Cache$Entry;
        r0.<init>();
        r0.etag = r2;
        r0.ttl = r4;
        r0.serverDate = r8;
        r0.lastModified = r12;
        r0.responseHeaders = r14;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.cache.d.a(java.util.Map):anetwork.channel.cache.Cache$Entry");
    }
}
