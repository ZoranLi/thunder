package com.huawei.hms.update.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.c.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CheckParams */
class a {
    private final Context a;
    private final String b = Build.MODEL;
    private final String c = Build.DISPLAY;
    private final String d = Build.HARDWARE;
    private final String e = Build.FINGERPRINT;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final int k;
    private final String l;
    private final String m;
    private final String n;

    public a(Context context) {
        com.huawei.hms.c.a.a(context, "context must not be null.");
        this.a = context;
        e eVar = new e(context);
        StringBuilder stringBuilder = new StringBuilder("Android ");
        stringBuilder.append(VERSION.RELEASE);
        this.f = stringBuilder.toString();
        this.g = com.huawei.hms.update.f.a.a(this.a);
        this.h = String.valueOf(com.huawei.hms.a.a.a.a);
        this.i = "full";
        this.j = HuaweiApiAvailability.SERVICES_PACKAGE;
        this.m = eVar.d(HuaweiApiAvailability.SERVICES_PACKAGE);
        this.n = com.huawei.hms.update.f.a.b(context);
        context = new o(this.a);
        this.k = context.a();
        this.l = context.b();
    }

    public java.lang.String toString() {
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
        r2 = this;
        r0 = r2.a();	 Catch:{ JSONException -> 0x000a }
        r1 = 2;	 Catch:{ JSONException -> 0x000a }
        r0 = r0.toString(r1);	 Catch:{ JSONException -> 0x000a }
        return r0;
    L_0x000a:
        r0 = super.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.a.a.toString():java.lang.String");
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("DeviceName", this.b);
            jSONObject.put("Firmware", this.c);
            jSONObject.put("Hardware", this.d);
            jSONObject.put("FingerPrint", this.e);
            jSONObject.put("Language", this.g);
            jSONObject.put("OS", this.f);
            jSONObject.put("EmotionUI", this.h);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PackageType", this.i);
            jSONObject2.put("PackageName", this.j);
            jSONObject2.put("PackageVersionCode", String.valueOf(this.k));
            jSONObject2.put("PackageVersionName", this.l);
            jSONObject2.put("PackageFingerprint", this.m);
            jSONObject2.put("SystemRegion", this.n);
            return new JSONObject().put("rules", jSONObject).put("components", new JSONArray().put(jSONObject2));
        } catch (JSONException e) {
            StringBuilder stringBuilder = new StringBuilder("In toJSON, Failed to build json for check-update request.");
            stringBuilder.append(e.getMessage());
            com.huawei.hms.support.log.a.d("CheckParams", stringBuilder.toString());
            return new JSONObject();
        }
    }
}
