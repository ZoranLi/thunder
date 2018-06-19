package com.baidu.mobads;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdSettings {
    private static HashSet<String> a = new HashSet();
    private static JSONArray b = new JSONArray();
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static HashSet<String> k = new HashSet();
    private static JSONArray l = new JSONArray();
    private static JSONObject m = new JSONObject();

    @Deprecated
    public enum a {
        PRIMARY(0),
        JUNIOR(1),
        SENIOR(2),
        SPECIALTY(3),
        BACHELOR(4),
        MASTER(5),
        DOCTOR(6);
        
        private int h;

        private a(int i) {
            this.h = i;
        }

        public final int a() {
            return this.h;
        }
    }

    @Deprecated
    public enum b {
        UNKNOWN_PROTOCOL_TYPE(0),
        HTTP_PROTOCOL_TYPE(1),
        HTTPS_PROTOCOL_TYPE(2);
        
        private int d;

        private b(int i) {
            this.d = i;
        }

        public final String a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.d);
            return stringBuilder.toString();
        }
    }

    @Deprecated
    public enum c {
        F0T1k(0),
        F1kT2k(1),
        F2kT3k(2),
        F3kT4k(3),
        F4kT5k(4),
        F5kT6k(5),
        F6kT7k(6),
        F7kT8k(7),
        F8kT9k(8),
        F9kT10k(9),
        F10kT15k(10),
        F15kT20k(11),
        F20(12);
        
        private int n;

        private c(int i) {
            this.n = i;
        }

        public final int a() {
            return this.n;
        }
    }

    @Deprecated
    public enum d {
        MALE(0),
        FEMALE(1);
        
        private int c;

        private d(int i) {
            this.c = i;
        }

        public final int a() {
            return this.c;
        }
    }

    public static void setSupportHttps(boolean z) {
        if (z) {
            z = new StringBuilder();
            z.append(b.HTTPS_PROTOCOL_TYPE.a());
            j = z.toString();
            return;
        }
        z = new StringBuilder();
        z.append(b.HTTP_PROTOCOL_TYPE.a());
        j = z.toString();
    }

    public static String getSupportHttps() {
        return j;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.HTTP_PROTOCOL_TYPE.a());
        j = stringBuilder.toString();
    }

    public static org.json.JSONObject getAttr() {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = a;
        r1 = r1.iterator();
        r2 = new org.json.JSONArray;
        r2.<init>();
        b = r2;
    L_0x0012:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0022;
    L_0x0018:
        r2 = b;
        r3 = r1.next();
        r2.put(r3);
        goto L_0x0012;
    L_0x0022:
        r1 = "KEY";	 Catch:{ Exception -> 0x0030 }
        r2 = b;	 Catch:{ Exception -> 0x0030 }
        r0.putOpt(r1, r2);	 Catch:{ Exception -> 0x0030 }
        r1 = "RPT";	 Catch:{ Exception -> 0x0030 }
        r2 = j;	 Catch:{ Exception -> 0x0030 }
        r0.putOpt(r1, r2);	 Catch:{ Exception -> 0x0030 }
    L_0x0030:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.AdSettings.getAttr():org.json.JSONObject");
    }

    @Deprecated
    public static void setKey(String[] strArr) {
        for (Object add : strArr) {
            a.add(add);
        }
    }

    @Deprecated
    public static void setKey(List<String> list) {
        a.addAll(list);
    }

    @Deprecated
    public static void setSex(d dVar) {
        if (dVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(dVar.a());
            c = stringBuilder.toString();
        }
    }

    @Deprecated
    public static void setBirthday(Calendar calendar) {
        if (calendar != null) {
            int i = calendar.get(1);
            int i2 = calendar.get(2) + 1;
            calendar = calendar.get(5);
            d = String.valueOf(i);
            StringBuilder stringBuilder;
            if (i2 <= 0 || i2 >= 10) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(d);
                stringBuilder.append(i2);
                d = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(d);
                stringBuilder.append("0");
                stringBuilder.append(i2);
                d = stringBuilder.toString();
            }
            StringBuilder stringBuilder2;
            if (calendar <= null || calendar >= 10) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(d);
                stringBuilder2.append(calendar);
                d = stringBuilder2.toString();
                return;
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(d);
            stringBuilder2.append("0");
            stringBuilder2.append(calendar);
            d = stringBuilder2.toString();
        }
    }

    @Deprecated
    public static void setCity(String str) {
        e = str;
    }

    @Deprecated
    public static void setZip(String str) {
        f = str;
    }

    @Deprecated
    public static void setJob(String str) {
        g = str;
    }

    @Deprecated
    public static void setEducation(a aVar) {
        if (aVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(aVar.a());
            h = stringBuilder.toString();
        }
    }

    @Deprecated
    public static void setSalary(c cVar) {
        if (cVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cVar.a());
            i = stringBuilder.toString();
        }
    }

    @Deprecated
    public static void setHob(String[] strArr) {
        for (Object add : strArr) {
            k.add(add);
        }
    }

    @Deprecated
    public static void setHob(List<String> list) {
        k.addAll(list);
    }

    @java.lang.Deprecated
    public static void setUserAttr(java.lang.String r1, java.lang.String r2) {
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
        r0 = m;	 Catch:{ JSONException -> 0x0006 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.AdSettings.setUserAttr(java.lang.String, java.lang.String):void");
    }
}
