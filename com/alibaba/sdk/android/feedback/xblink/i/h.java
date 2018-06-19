package com.alibaba.sdk.android.feedback.xblink.i;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class h {
    private static Map a = new HashMap();

    static {
        for (e eVar : e.a()) {
            a.put(eVar.b(), eVar.c());
        }
    }

    public static String a(String str, String str2, String str3) {
        if (str != null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            Uri parse = Uri.parse(str);
            if (parse.getQueryParameter(str2) != null) {
                return str;
            }
            Builder buildUpon = parse.buildUpon();
            buildUpon.appendQueryParameter(str2, str3);
            str = buildUpon.toString();
        }
        return str;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://"));
    }

    public static java.lang.String b(java.lang.String r2) {
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
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r2 = android.net.Uri.parse(r2);	 Catch:{ Exception -> 0x0028 }
        r1 = r2.getScheme();	 Catch:{ Exception -> 0x0028 }
        r0.append(r1);	 Catch:{ Exception -> 0x0028 }
        r1 = "://";	 Catch:{ Exception -> 0x0028 }
        r0.append(r1);	 Catch:{ Exception -> 0x0028 }
        r1 = r2.getHost();	 Catch:{ Exception -> 0x0028 }
        r0.append(r1);	 Catch:{ Exception -> 0x0028 }
        r2 = r2.getPath();	 Catch:{ Exception -> 0x0028 }
        r0.append(r2);	 Catch:{ Exception -> 0x0028 }
        r2 = r0.toString();
        return r2;
    L_0x0028:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.i.h.b(java.lang.String):java.lang.String");
    }
}
