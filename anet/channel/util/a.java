package anet.channel.util;

import android.text.TextUtils;
import anet.channel.request.Request;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class a {
    static final Pattern a = Pattern.compile("^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");

    public static Map<String, List<String>> a(Map<String, List<String>> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        Map hashMap = new HashMap(map.size());
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            hashMap.put(entry.getKey(), new ArrayList((Collection) entry.getValue()));
        }
        return hashMap;
    }

    public static List<String> a(Map<String, List<String>> map, String str) {
        if (!(map == null || map.isEmpty())) {
            if (!TextUtils.isEmpty(str)) {
                map = map.entrySet().iterator();
                while (map.hasNext()) {
                    Entry entry = (Entry) map.next();
                    if (str.equalsIgnoreCase((String) entry.getKey())) {
                        return (List) entry.getValue();
                    }
                }
                return null;
            }
        }
        return null;
    }

    public static String b(Map<String, List<String>> map, String str) {
        map = a((Map) map, str);
        if (map != null) {
            if (map.isEmpty() == null) {
                return (String) map.get(null);
            }
        }
        return null;
    }

    public static void c(Map<String, List<String>> map, String str) {
        if (str != null) {
            for (String equalsIgnoreCase : map.keySet()) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    break;
                }
            }
            str = null;
            if (str != null) {
                map.remove(str);
            }
        }
    }

    public static boolean a(Request request, int i) {
        return (!request.isRedirectEnable() || i < 300 || i >= 400 || i == 304 || request.getRedirectTimes() >= 10) ? null : true;
    }

    public static boolean b(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r1) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "Content-Encoding";	 Catch:{ Exception -> 0x0010 }
        r1 = b(r1, r0);	 Catch:{ Exception -> 0x0010 }
        r0 = "gzip";	 Catch:{ Exception -> 0x0010 }
        r1 = r0.equalsIgnoreCase(r1);	 Catch:{ Exception -> 0x0010 }
        if (r1 == 0) goto L_0x0010;
    L_0x000e:
        r1 = 1;
        return r1;
    L_0x0010:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.a.b(java.util.Map):boolean");
    }

    public static int c(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r1) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "Content-Length";	 Catch:{ Exception -> 0x000b }
        r1 = b(r1, r0);	 Catch:{ Exception -> 0x000b }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x000b }
        goto L_0x000c;
    L_0x000b:
        r1 = 0;
    L_0x000c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.a.c(java.util.Map):int");
    }

    public static java.lang.String a(java.lang.String r6) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r6.length();	 Catch:{ Exception -> 0x002d }
        r2 = 1;	 Catch:{ Exception -> 0x002d }
        if (r1 > r2) goto L_0x000c;	 Catch:{ Exception -> 0x002d }
    L_0x000b:
        return r0;	 Catch:{ Exception -> 0x002d }
    L_0x000c:
        r3 = 47;	 Catch:{ Exception -> 0x002d }
        r3 = r6.lastIndexOf(r3);	 Catch:{ Exception -> 0x002d }
        r4 = -1;	 Catch:{ Exception -> 0x002d }
        if (r3 == r4) goto L_0x002c;	 Catch:{ Exception -> 0x002d }
    L_0x0015:
        r5 = r1 + -1;	 Catch:{ Exception -> 0x002d }
        if (r3 != r5) goto L_0x001a;	 Catch:{ Exception -> 0x002d }
    L_0x0019:
        goto L_0x002c;	 Catch:{ Exception -> 0x002d }
    L_0x001a:
        r5 = 46;	 Catch:{ Exception -> 0x002d }
        r5 = r6.lastIndexOf(r5);	 Catch:{ Exception -> 0x002d }
        if (r5 == r4) goto L_0x002b;	 Catch:{ Exception -> 0x002d }
    L_0x0022:
        if (r5 > r3) goto L_0x0025;	 Catch:{ Exception -> 0x002d }
    L_0x0024:
        goto L_0x002b;	 Catch:{ Exception -> 0x002d }
    L_0x0025:
        r5 = r5 + r2;	 Catch:{ Exception -> 0x002d }
        r6 = r6.substring(r5, r1);	 Catch:{ Exception -> 0x002d }
        goto L_0x002e;
    L_0x002b:
        return r0;
    L_0x002c:
        return r0;
    L_0x002d:
        r6 = r0;
    L_0x002e:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.a.a(java.lang.String):java.lang.String");
    }

    @Deprecated
    public static String a(URL url) {
        return a(url.getPath());
    }
}
