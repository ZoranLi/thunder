package com.alibaba.mtl.log.e;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.f.b;
import com.alibaba.mtl.log.f.c;
import com.alibaba.mtl.log.model.LogField;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* compiled from: UrlWrapper */
public class t {
    private static final String a = "t";

    public static java.lang.String a(java.lang.String r7, java.util.Map<java.lang.String, java.lang.Object> r8) throws java.lang.Exception {
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
        r0 = "";
        if (r8 == 0) goto L_0x0044;
    L_0x0004:
        r1 = r8.size();
        if (r1 <= 0) goto L_0x0044;
    L_0x000a:
        r1 = r8.keySet();
        r2 = r1.size();
        r2 = new java.lang.String[r2];
        r1.toArray(r2);
        r1 = com.alibaba.mtl.log.e.g.a();
        r1 = r1.a(r2);
        r2 = r1.length;
        r3 = 0;
    L_0x0021:
        if (r3 >= r2) goto L_0x0044;
    L_0x0023:
        r4 = r1[r3];
        r5 = r8.get(r4);
        r5 = (byte[]) r5;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6.append(r0);
        r6.append(r4);
        r0 = com.alibaba.mtl.log.e.j.b(r5);
        r6.append(r0);
        r0 = r6.toString();
        r3 = r3 + 1;
        goto L_0x0021;
    L_0x0044:
        r7 = a(r7, r0);	 Catch:{ Throwable -> 0x0049 }
        goto L_0x004f;
    L_0x0049:
        r7 = com.alibaba.mtl.log.a.a.b;
        r7 = a(r7, r0);
    L_0x004f:
        r8 = com.alibaba.mtl.log.a.a.d;
        r0 = android.text.TextUtils.isEmpty(r8);
        if (r0 != 0) goto L_0x0072;
    L_0x0057:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r7 = "&dk=";
        r0.append(r7);
        r7 = "UTF-8";
        r7 = java.net.URLEncoder.encode(r8, r7);
        r0.append(r7);
        r7 = r0.toString();
        return r7;
    L_0x0072:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.t.a(java.lang.String, java.util.Map):java.lang.String");
    }

    public static String b(String str, Map<String, Object> map) throws Exception {
        Context c = a.c();
        String f = b.f();
        String c2 = b.c();
        if (c2 == null) {
            c2 = "";
        }
        String str2 = (String) d.a(c).get(LogField.APPVERSION.toString());
        String str3 = (String) d.a(c).get(LogField.OS.toString());
        String str4 = "2.5.1_for_bc";
        String str5 = (String) d.a(c).get(LogField.UTDID.toString());
        String valueOf = String.valueOf(System.currentTimeMillis());
        b d = a.d();
        String str6 = "0";
        if (d instanceof c) {
            str6 = "1";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f);
        stringBuilder.append(str2);
        stringBuilder.append(c2);
        stringBuilder.append(str3);
        stringBuilder.append(str5);
        stringBuilder.append(str4);
        stringBuilder.append(valueOf);
        stringBuilder.append(str6);
        stringBuilder.append(map.get("_b01n15"));
        stringBuilder.append(map.get("_b01na"));
        str3 = d.a(j.b(stringBuilder.toString().getBytes()));
        StringBuilder stringBuilder2 = new StringBuilder(str);
        stringBuilder2.append("?");
        stringBuilder2.append("ak=");
        stringBuilder2.append(f);
        stringBuilder2.append("&av=");
        stringBuilder2.append(str2);
        stringBuilder2.append("&c=");
        stringBuilder2.append(URLEncoder.encode(c2));
        stringBuilder2.append("&d=");
        stringBuilder2.append(str5);
        stringBuilder2.append("&sv=");
        stringBuilder2.append(str4);
        stringBuilder2.append("&t=");
        stringBuilder2.append(valueOf);
        stringBuilder2.append("&is=");
        stringBuilder2.append(str6);
        stringBuilder2.append("&_b01n15=");
        stringBuilder2.append(map.get("_b01n15"));
        stringBuilder2.append("&_b01na=");
        stringBuilder2.append(map.get("_b01na"));
        stringBuilder2.append("&s=");
        stringBuilder2.append(str3);
        return stringBuilder2.toString();
    }

    private static String a(String str, String str2) throws Exception {
        Context c = a.c();
        String f = b.f();
        String c2 = b.c();
        if (c2 == null) {
            c2 = "";
        }
        String str3 = (String) d.a(c).get(LogField.APPVERSION.toString());
        String str4 = (String) d.a(c).get(LogField.OS.toString());
        String str5 = "2.5.1_for_bc";
        String str6 = (String) d.a(c).get(LogField.UTDID.toString());
        String str7 = "3.0";
        String valueOf = String.valueOf(System.currentTimeMillis());
        b d = a.d();
        String str8 = "1";
        String str9 = "0";
        if (d instanceof c) {
            str9 = "1";
            str8 = "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f);
        stringBuilder.append(c2);
        stringBuilder.append(str3);
        stringBuilder.append(str4);
        stringBuilder.append(str5);
        stringBuilder.append(str6);
        stringBuilder.append(valueOf);
        stringBuilder.append(str7);
        stringBuilder.append(str9);
        if (str2 == null) {
            str2 = "";
        }
        stringBuilder.append(str2);
        str2 = d.a(j.b(stringBuilder.toString().getBytes()));
        String str10 = "";
        if (!TextUtils.isEmpty(null)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(null);
            stringBuilder2.append("&");
            str10 = stringBuilder2.toString();
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s&k=%s", new Object[]{str, str10, a(f), a(str3), a(c2), a(str7), a(str2), a(str6), str5, str4, valueOf, "", str9, str8});
    }

    private static String a(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
