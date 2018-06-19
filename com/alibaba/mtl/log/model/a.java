package com.alibaba.mtl.log.model;

import android.text.TextUtils;
import com.alibaba.mtl.log.e.c;
import com.alibaba.mtl.log.e.h;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.n;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Log */
public final class a {
    public int a;
    public String b;
    public String c = "3";
    public String d;
    public String e = null;
    public String f = "";
    private String g;
    private String h;
    private String i;
    private String j;
    private Map<String, String> k;

    public a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        this.b = str2;
        this.g = str;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = map;
        this.e = String.valueOf(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.e) != null) {
            this.e = String.valueOf(System.currentTimeMillis());
        }
        str = this.g;
        str2 = this.b;
        str3 = this.h;
        str4 = this.i;
        str5 = this.j;
        map = this.k;
        CharSequence charSequence = this.f;
        CharSequence charSequence2 = this.e;
        Map hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (TextUtils.isEmpty(str) == null) {
            hashMap.put(LogField.PAGE.toString(), str);
        }
        hashMap.put(LogField.EVENTID.toString(), str2);
        if (TextUtils.isEmpty(str3) == null) {
            hashMap.put(LogField.ARG1.toString(), str3);
        }
        if (TextUtils.isEmpty(str4) == null) {
            hashMap.put(LogField.ARG2.toString(), str4);
        }
        if (TextUtils.isEmpty(str5) == null) {
            hashMap.put(LogField.ARG3.toString(), str5);
        }
        if (TextUtils.isEmpty(charSequence2) == null) {
            hashMap.put(LogField.RECORD_TIMESTAMP.toString(), charSequence2);
        }
        if (TextUtils.isEmpty(charSequence) == null) {
            hashMap.put(LogField.RESERVE3.toString(), charSequence);
        }
        str = h.a(hashMap);
        i.a("UTLog", this, str);
        if (str != null) {
            try {
                this.d = new String(c.c(n.a(str.getBytes(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")), "UTF-8");
            } catch (String str6) {
                str6.printStackTrace();
            }
        }
    }

    public final java.lang.String a() {
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
        r3 = this;
        r0 = 0;
        r1 = r3.d;	 Catch:{ Exception -> 0x001b }
        r2 = "UTF-8";	 Catch:{ Exception -> 0x001b }
        r1 = r1.getBytes(r2);	 Catch:{ Exception -> 0x001b }
        r1 = com.alibaba.mtl.log.e.c.a(r1);	 Catch:{ Exception -> 0x001b }
        if (r1 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x001b }
    L_0x000f:
        r2 = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK";	 Catch:{ Exception -> 0x001b }
        r1 = com.alibaba.mtl.log.e.n.a(r1, r2);	 Catch:{ Exception -> 0x001b }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x001b }
        r2.<init>(r1);	 Catch:{ Exception -> 0x001b }
        r0 = r2;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.model.a.a():java.lang.String");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Log [id=");
        stringBuilder.append(this.a);
        stringBuilder.append(", eventId=");
        stringBuilder.append(this.b);
        stringBuilder.append(", index=");
        stringBuilder.append(this.f);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
