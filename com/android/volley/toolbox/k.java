package com.android.volley.toolbox;

import com.alipay.sdk.util.h;
import com.android.volley.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

/* compiled from: HttpHeaderParser */
public final class k {
    public static com.android.volley.a.a a(com.android.volley.j r19) {
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
        r0 = r19;
        r1 = java.lang.System.currentTimeMillis();
        r3 = r0.c;
        r4 = "Date";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x0017;
    L_0x0012:
        r7 = a(r4);
        goto L_0x0019;
    L_0x0017:
        r7 = 0;
    L_0x0019:
        r4 = "Cache-Control";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        r10 = 0;
        if (r4 == 0) goto L_0x008a;
    L_0x0024:
        r11 = ",";
        r4 = r4.split(r11);
        r13 = r10;
        r11 = 0;
        r14 = 0;
    L_0x002f:
        r9 = r4.length;
        if (r10 >= r9) goto L_0x0087;
    L_0x0032:
        r9 = r4[r10];
        r9 = r9.trim();
        r5 = "no-cache";
        r5 = r9.equals(r5);
        if (r5 != 0) goto L_0x0085;
    L_0x0040:
        r5 = "no-store";
        r5 = r9.equals(r5);
        if (r5 == 0) goto L_0x0049;
    L_0x0048:
        goto L_0x0085;
    L_0x0049:
        r5 = "max-age=";
        r5 = r9.startsWith(r5);
        if (r5 == 0) goto L_0x005d;
    L_0x0051:
        r5 = 8;
        r5 = r9.substring(r5);	 Catch:{ Exception -> 0x0082 }
        r5 = java.lang.Long.parseLong(r5);	 Catch:{ Exception -> 0x0082 }
        r11 = r5;
        goto L_0x0082;
    L_0x005d:
        r5 = "stale-while-revalidate=";
        r5 = r9.startsWith(r5);
        if (r5 == 0) goto L_0x0071;
    L_0x0065:
        r5 = 23;
        r5 = r9.substring(r5);	 Catch:{ Exception -> 0x0082 }
        r5 = java.lang.Long.parseLong(r5);	 Catch:{ Exception -> 0x0082 }
        r14 = r5;
        goto L_0x0082;
    L_0x0071:
        r5 = "must-revalidate";
        r5 = r9.equals(r5);
        if (r5 != 0) goto L_0x0081;
    L_0x0079:
        r5 = "proxy-revalidate";
        r5 = r9.equals(r5);
        if (r5 == 0) goto L_0x0082;
    L_0x0081:
        r13 = 1;
    L_0x0082:
        r10 = r10 + 1;
        goto L_0x002f;
    L_0x0085:
        r0 = 0;
        return r0;
    L_0x0087:
        r16 = 1;
        goto L_0x0091;
    L_0x008a:
        r13 = r10;
        r16 = r13;
        r11 = 0;
        r14 = 0;
    L_0x0091:
        r4 = "Expires";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x00a0;
    L_0x009b:
        r5 = a(r4);
        goto L_0x00a2;
    L_0x00a0:
        r5 = 0;
    L_0x00a2:
        r4 = "Last-Modified";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x00b1;
    L_0x00ac:
        r9 = a(r4);
        goto L_0x00b3;
    L_0x00b1:
        r9 = 0;
    L_0x00b3:
        r4 = "ETag";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r16 == 0) goto L_0x00cf;
    L_0x00bd:
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = r11 * r5;
        r16 = r1 + r11;
        if (r13 == 0) goto L_0x00c7;
    L_0x00c4:
        r5 = r16;
        goto L_0x00cb;
    L_0x00c7:
        r14 = r14 * r5;
        r1 = r16 + r14;
        r5 = r1;
    L_0x00cb:
        r1 = r5;
        r5 = r16;
        goto L_0x00e2;
    L_0x00cf:
        r16 = 0;
        r11 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1));
        if (r11 <= 0) goto L_0x00df;
    L_0x00d5:
        r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r11 < 0) goto L_0x00df;
    L_0x00d9:
        r11 = r5 - r7;
        r5 = r1 + r11;
        r1 = r5;
        goto L_0x00e2;
    L_0x00df:
        r1 = r16;
        r5 = r1;
    L_0x00e2:
        r11 = new com.android.volley.a$a;
        r11.<init>();
        r12 = r0.b;
        r11.a = r12;
        r11.b = r4;
        r11.f = r5;
        r11.e = r1;
        r11.c = r7;
        r11.d = r9;
        r11.g = r3;
        r0 = r0.d;
        r11.h = r0;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.k.a(com.android.volley.j):com.android.volley.a$a");
    }

    private static long a(java.lang.String r3) {
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
        r0 = a();	 Catch:{ ParseException -> 0x000d }
        r0 = r0.parse(r3);	 Catch:{ ParseException -> 0x000d }
        r0 = r0.getTime();	 Catch:{ ParseException -> 0x000d }
        return r0;
    L_0x000d:
        r0 = "Unable to parse dateStr: %s, falling back to 0";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r1[r2] = r3;
        com.android.volley.q.d(r0, r1);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.k.a(java.lang.String):long");
    }

    static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = (String) map.get("Content-Type");
        if (str2 != null) {
            map = str2.split(h.b);
            for (int i = 1; i < map.length; i++) {
                String[] split = map[i].trim().split("=");
                if (split.length == 2 && split[0].equals("charset")) {
                    return split[1];
                }
            }
        }
        return str;
    }

    public static String a(Map<String, String> map) {
        return a(map, "ISO-8859-1");
    }

    static Map<String, String> a(List<g> list) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (g gVar : list) {
            treeMap.put(gVar.a, gVar.b);
        }
        return treeMap;
    }

    static List<g> b(Map<String, String> map) {
        List<g> arrayList = new ArrayList(map.size());
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            arrayList.add(new g((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }
}
