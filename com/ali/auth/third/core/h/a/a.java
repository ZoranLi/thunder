package com.ali.auth.third.core.h.a;

import android.text.TextUtils;
import com.ali.auth.third.core.f.f;
import com.ali.auth.third.core.j.c;
import com.ali.auth.third.core.j.d;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import org.json.JSONObject;

public class a implements com.ali.auth.third.core.h.a {
    public static final a c = new a();
    private static final String d = "a";
    public String a = "internal_session";
    public volatile com.ali.auth.third.core.f.a b;

    private static Object b(String str) {
        try {
            return d.a(str);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean a() {
        return (this.b == null || this.b.c == 0 || this.b.b == 0 || System.currentTimeMillis() / 1000 >= this.b.b) ? false : true;
    }

    public a() {
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
        r5 = this;
        r5.<init>();
        r0 = "internal_session";
        r5.a = r0;
        r0 = com.ali.auth.third.core.c.a.d;
        if (r0 != 0) goto L_0x0043;
    L_0x000b:
        r0 = com.ali.auth.third.core.c.a.h;
        r1 = 1;
        r2 = 0;
        r3 = "com.ali.auth.third.b.a";	 Catch:{ Throwable -> 0x001e }
        java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x001e }
        com.ali.auth.third.core.c.a.a = r2;	 Catch:{ Throwable -> 0x001a }
        r3 = "a_1.0.0-std";	 Catch:{ Throwable -> 0x001a }
        com.ali.auth.third.core.c.a.b = r3;	 Catch:{ Throwable -> 0x001a }
    L_0x001a:
        r3 = r1;
        goto L_0x001f;
    L_0x001c:
        r0 = move-exception;
        goto L_0x0040;
    L_0x001e:
        r3 = r2;
    L_0x001f:
        if (r3 == 0) goto L_0x0028;
    L_0x0021:
        r3 = "com.ali.auth.third.b.a";	 Catch:{ NoSuchMethodError -> 0x001c }
    L_0x0023:
        r3 = b(r3);	 Catch:{ NoSuchMethodError -> 0x001c }
        goto L_0x002b;	 Catch:{ NoSuchMethodError -> 0x001c }
    L_0x0028:
        r3 = "com.ali.auth.third.core.storage.CommonStorageServiceImpl";	 Catch:{ NoSuchMethodError -> 0x001c }
        goto L_0x0023;	 Catch:{ NoSuchMethodError -> 0x001c }
    L_0x002b:
        r1 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodError -> 0x001c }
        r4 = com.ali.auth.third.core.h.d.class;	 Catch:{ NoSuchMethodError -> 0x001c }
        r1[r2] = r4;	 Catch:{ NoSuchMethodError -> 0x001c }
        r0.a(r1, r3);	 Catch:{ NoSuchMethodError -> 0x001c }
        r1 = com.ali.auth.third.core.h.d.class;	 Catch:{ NoSuchMethodError -> 0x001c }
        r2 = 0;	 Catch:{ NoSuchMethodError -> 0x001c }
        r0 = r0.a(r1, r2);	 Catch:{ NoSuchMethodError -> 0x001c }
        r0 = (com.ali.auth.third.core.h.d) r0;	 Catch:{ NoSuchMethodError -> 0x001c }
        com.ali.auth.third.core.c.a.d = r0;	 Catch:{ NoSuchMethodError -> 0x001c }
        goto L_0x0043;
    L_0x0040:
        r0.printStackTrace();
    L_0x0043:
        r0 = com.ali.auth.third.core.c.a.d;
        r1 = "loginEnvironmentIndex";
        r0 = r0.a(r1);
        r1 = com.ali.auth.third.core.c.a.b();
        r1 = r1.ordinal();
        r1 = java.lang.String.valueOf(r1);
        if (r0 == 0) goto L_0x007e;
    L_0x0059:
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x007e;
    L_0x005f:
        r0 = com.ali.auth.third.core.c.a.d;
        r2 = "loginEnvironmentIndex";
        r0.a(r2, r1);
        r0 = com.ali.auth.third.core.c.a.d;
        r1 = r5.a;
        r0.b(r1);
        r0 = new com.ali.auth.third.core.f.a;
        r0.<init>();
        r5.b = r0;
        r0 = r5.b;
        r1 = new com.ali.auth.third.core.f.f;
        r1.<init>();
        r0.g = r1;
        return;
    L_0x007e:
        r0 = com.ali.auth.third.core.c.a.d;
        r1 = r5.a;
        r0 = r0.a(r1);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x0094;
    L_0x008c:
        r0 = com.ali.auth.third.core.c.a.d;
        r1 = r5.a;
        r0 = r0.a(r1);
    L_0x0094:
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x00a1;
    L_0x009a:
        r0 = a(r0);
        r5.b = r0;
        return;
    L_0x00a1:
        r0 = new com.ali.auth.third.core.f.a;
        r0.<init>();
        r5.b = r0;
        r0 = r5.b;
        r1 = new com.ali.auth.third.core.f.f;
        r1.<init>();
        r0.g = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.h.a.a.<init>():void");
    }

    private static com.ali.auth.third.core.f.a a(String str) {
        com.ali.auth.third.core.f.a aVar = new com.ali.auth.third.core.f.a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.a = c.a(jSONObject, "sid");
            str = "expireIn";
            Long l = null;
            aVar.b = (long) (jSONObject.has(str) ? Integer.valueOf(jSONObject.optInt(str)) : null).intValue();
            str = new f();
            JSONObject optJSONObject = jSONObject.optJSONObject(MessageInfo.USER);
            if (optJSONObject != null) {
                str.c = optJSONObject.optString("avatarUrl");
                str.a = optJSONObject.optString("userId");
                str.b = optJSONObject.optString("nick");
                str.f = optJSONObject.optString("openId");
                str.g = optJSONObject.optString("openSid");
                str.d = optJSONObject.optString("deviceTokenKey");
                str.e = optJSONObject.optString("deviceTokenSalt");
                if (!(TextUtils.isEmpty(aVar.a) || TextUtils.isEmpty(str.a))) {
                    com.ali.auth.third.core.c.a.a(com.ali.auth.third.core.h.c.class);
                }
            }
            aVar.g = str;
            str = "loginTime";
            if (jSONObject.has(str)) {
                l = Long.valueOf(jSONObject.optLong(str));
            }
            aVar.c = l.longValue();
            aVar.d = c.a(jSONObject, "mobile");
            aVar.e = c.a(jSONObject, "loginId");
            aVar.f = c.a(jSONObject, "autoLoginToken");
            aVar.h = c.a(jSONObject.optJSONObject("otherInfo"));
        } catch (String str2) {
            str2.getMessage();
            str2 = com.ali.auth.third.core.config.a.a;
        }
        return aVar;
    }
}
