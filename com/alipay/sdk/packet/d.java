package com.alipay.sdk.packet;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.net.a;
import com.alipay.sdk.util.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d {
    public static final String a = "msp-gzip";
    public static final String b = "Msp-Param";
    public static final String c = "Operation-Type";
    public static final String d = "content-type";
    public static final String e = "Version";
    public static final String f = "AppId";
    public static final String g = "des-mode";
    public static final String h = "namespace";
    public static final String i = "api_name";
    public static final String j = "api_version";
    public static final String k = "data";
    public static final String l = "params";
    public static final String m = "public_key";
    public static final String n = "device";
    public static final String o = "action";
    public static final String p = "type";
    public static final String q = "method";
    private static a t;
    protected boolean r = true;
    protected boolean s = true;

    public abstract JSONObject a() throws JSONException;

    public String b() {
        return "4.9.0";
    }

    public List<Header> a(boolean z, String str) {
        List<Header> arrayList = new ArrayList();
        arrayList.add(new BasicHeader(a, String.valueOf(z)));
        arrayList.add(new BasicHeader(c, "alipay.msp.cashier.dispatch.bytes"));
        arrayList.add(new BasicHeader(d, "application/octet-stream"));
        arrayList.add(new BasicHeader(e, "2.0"));
        arrayList.add(new BasicHeader(f, "TAOBAO"));
        arrayList.add(new BasicHeader(b, a.a(str)));
        arrayList.add(new BasicHeader(g, "CBC"));
        return arrayList;
    }

    public String c() throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put(n, Build.MODEL);
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put(i, "com.alipay.mcpay");
        hashMap.put(j, b());
        return a(hashMap, new HashMap());
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public java.lang.String a(java.lang.String r23, org.json.JSONObject r24) {
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
        r22 = this;
        r0 = com.alipay.sdk.sys.b.a();
        r1 = com.alipay.sdk.tid.b.a();
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = r24;
        r2 = com.alipay.sdk.util.b.a(r2, r3);
        r3 = "tid";	 Catch:{ Throwable -> 0x029f }
        r4 = r1.a;	 Catch:{ Throwable -> 0x029f }
        r2.put(r3, r4);	 Catch:{ Throwable -> 0x029f }
        r3 = "user_agent";	 Catch:{ Throwable -> 0x029f }
        r4 = com.alipay.sdk.data.c.a();	 Catch:{ Throwable -> 0x029f }
        r5 = com.alipay.sdk.sys.b.a();	 Catch:{ Throwable -> 0x029f }
        r5 = r5.a;	 Catch:{ Throwable -> 0x029f }
        r6 = com.alipay.sdk.util.a.a(r5);	 Catch:{ Throwable -> 0x029f }
        r7 = r4.a;	 Catch:{ Throwable -> 0x029f }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Throwable -> 0x029f }
        r8 = 0;	 Catch:{ Throwable -> 0x029f }
        if (r7 == 0) goto L_0x009e;	 Catch:{ Throwable -> 0x029f }
    L_0x0033:
        r7 = "Msp/15.2.0";	 Catch:{ Throwable -> 0x029f }
        r9 = com.alipay.sdk.util.k.a();	 Catch:{ Throwable -> 0x029f }
        r10 = com.alipay.sdk.util.k.b();	 Catch:{ Throwable -> 0x029f }
        r11 = com.alipay.sdk.util.k.e(r5);	 Catch:{ Throwable -> 0x029f }
        r12 = com.alipay.sdk.util.j.a(r5);	 Catch:{ Throwable -> 0x029f }
        r13 = "://";	 Catch:{ Throwable -> 0x029f }
        r13 = r12.indexOf(r13);	 Catch:{ Throwable -> 0x029f }
        r12 = r12.substring(r8, r13);	 Catch:{ Throwable -> 0x029f }
        r13 = com.alipay.sdk.util.k.f(r5);	 Catch:{ Throwable -> 0x029f }
        r14 = new android.widget.TextView;	 Catch:{ Throwable -> 0x029f }
        r14.<init>(r5);	 Catch:{ Throwable -> 0x029f }
        r14 = r14.getTextSize();	 Catch:{ Throwable -> 0x029f }
        r14 = java.lang.Float.toString(r14);	 Catch:{ Throwable -> 0x029f }
        r15 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x029f }
        r15.<init>();	 Catch:{ Throwable -> 0x029f }
        r15.append(r7);	 Catch:{ Throwable -> 0x029f }
        r7 = " (";	 Catch:{ Throwable -> 0x029f }
        r15.append(r7);	 Catch:{ Throwable -> 0x029f }
        r15.append(r9);	 Catch:{ Throwable -> 0x029f }
        r7 = ";";	 Catch:{ Throwable -> 0x029f }
        r15.append(r7);	 Catch:{ Throwable -> 0x029f }
        r15.append(r10);	 Catch:{ Throwable -> 0x029f }
        r7 = ";";	 Catch:{ Throwable -> 0x029f }
        r15.append(r7);	 Catch:{ Throwable -> 0x029f }
        r15.append(r11);	 Catch:{ Throwable -> 0x029f }
        r7 = ";";	 Catch:{ Throwable -> 0x029f }
        r15.append(r7);	 Catch:{ Throwable -> 0x029f }
        r15.append(r12);	 Catch:{ Throwable -> 0x029f }
        r7 = ";";	 Catch:{ Throwable -> 0x029f }
        r15.append(r7);	 Catch:{ Throwable -> 0x029f }
        r15.append(r13);	 Catch:{ Throwable -> 0x029f }
        r7 = ";";	 Catch:{ Throwable -> 0x029f }
        r15.append(r7);	 Catch:{ Throwable -> 0x029f }
        r15.append(r14);	 Catch:{ Throwable -> 0x029f }
        r7 = r15.toString();	 Catch:{ Throwable -> 0x029f }
        r4.a = r7;	 Catch:{ Throwable -> 0x029f }
    L_0x009e:
        r7 = com.alipay.sdk.util.a.b(r5);	 Catch:{ Throwable -> 0x029f }
        r7 = r7.p;	 Catch:{ Throwable -> 0x029f }
        r9 = "-1;-1";	 Catch:{ Throwable -> 0x029f }
        r10 = "1";	 Catch:{ Throwable -> 0x029f }
        r11 = r6.a();	 Catch:{ Throwable -> 0x029f }
        r12 = r6.b();	 Catch:{ Throwable -> 0x029f }
        r13 = com.alipay.sdk.sys.b.a();	 Catch:{ Throwable -> 0x029f }
        r13 = r13.a;	 Catch:{ Throwable -> 0x029f }
        r14 = "virtualImeiAndImsi";	 Catch:{ Throwable -> 0x029f }
        r14 = r13.getSharedPreferences(r14, r8);	 Catch:{ Throwable -> 0x029f }
        r15 = "virtual_imsi";	 Catch:{ Throwable -> 0x029f }
        r8 = 0;	 Catch:{ Throwable -> 0x029f }
        r15 = r14.getString(r15, r8);	 Catch:{ Throwable -> 0x029f }
        r16 = android.text.TextUtils.isEmpty(r15);	 Catch:{ Throwable -> 0x029f }
        if (r16 == 0) goto L_0x0107;	 Catch:{ Throwable -> 0x029f }
    L_0x00c9:
        r15 = com.alipay.sdk.tid.b.a();	 Catch:{ Throwable -> 0x029f }
        r15 = r15.a;	 Catch:{ Throwable -> 0x029f }
        r15 = android.text.TextUtils.isEmpty(r15);	 Catch:{ Throwable -> 0x029f }
        if (r15 == 0) goto L_0x00f1;	 Catch:{ Throwable -> 0x029f }
    L_0x00d5:
        r13 = com.alipay.sdk.sys.b.a();	 Catch:{ Throwable -> 0x029f }
        r13 = r13.c();	 Catch:{ Throwable -> 0x029f }
        r15 = android.text.TextUtils.isEmpty(r13);	 Catch:{ Throwable -> 0x029f }
        if (r15 == 0) goto L_0x00e9;	 Catch:{ Throwable -> 0x029f }
    L_0x00e3:
        r13 = com.alipay.sdk.data.c.b();	 Catch:{ Throwable -> 0x029f }
        r15 = r13;	 Catch:{ Throwable -> 0x029f }
        goto L_0x00fa;	 Catch:{ Throwable -> 0x029f }
    L_0x00e9:
        r15 = 3;	 Catch:{ Throwable -> 0x029f }
        r8 = 18;	 Catch:{ Throwable -> 0x029f }
        r8 = r13.substring(r15, r8);	 Catch:{ Throwable -> 0x029f }
        goto L_0x00f9;	 Catch:{ Throwable -> 0x029f }
    L_0x00f1:
        r8 = com.alipay.sdk.util.a.a(r13);	 Catch:{ Throwable -> 0x029f }
        r8 = r8.a();	 Catch:{ Throwable -> 0x029f }
    L_0x00f9:
        r15 = r8;	 Catch:{ Throwable -> 0x029f }
    L_0x00fa:
        r8 = r14.edit();	 Catch:{ Throwable -> 0x029f }
        r13 = "virtual_imsi";	 Catch:{ Throwable -> 0x029f }
        r8 = r8.putString(r13, r15);	 Catch:{ Throwable -> 0x029f }
        r8.commit();	 Catch:{ Throwable -> 0x029f }
    L_0x0107:
        r8 = com.alipay.sdk.sys.b.a();	 Catch:{ Throwable -> 0x029f }
        r8 = r8.a;	 Catch:{ Throwable -> 0x029f }
        r13 = "virtualImeiAndImsi";	 Catch:{ Throwable -> 0x029f }
        r14 = 0;	 Catch:{ Throwable -> 0x029f }
        r13 = r8.getSharedPreferences(r13, r14);	 Catch:{ Throwable -> 0x029f }
        r14 = "virtual_imei";	 Catch:{ Throwable -> 0x029f }
        r17 = r0;	 Catch:{ Throwable -> 0x029f }
        r0 = 0;	 Catch:{ Throwable -> 0x029f }
        r0 = r13.getString(r14, r0);	 Catch:{ Throwable -> 0x029f }
        r14 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x029f }
        if (r14 == 0) goto L_0x0149;	 Catch:{ Throwable -> 0x029f }
    L_0x0123:
        r0 = com.alipay.sdk.tid.b.a();	 Catch:{ Throwable -> 0x029f }
        r0 = r0.a;	 Catch:{ Throwable -> 0x029f }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x029f }
        if (r0 == 0) goto L_0x0134;	 Catch:{ Throwable -> 0x029f }
    L_0x012f:
        r0 = com.alipay.sdk.data.c.b();	 Catch:{ Throwable -> 0x029f }
        goto L_0x013c;	 Catch:{ Throwable -> 0x029f }
    L_0x0134:
        r0 = com.alipay.sdk.util.a.a(r8);	 Catch:{ Throwable -> 0x029f }
        r0 = r0.b();	 Catch:{ Throwable -> 0x029f }
    L_0x013c:
        r8 = r13.edit();	 Catch:{ Throwable -> 0x029f }
        r13 = "virtual_imei";	 Catch:{ Throwable -> 0x029f }
        r8 = r8.putString(r13, r0);	 Catch:{ Throwable -> 0x029f }
        r8.commit();	 Catch:{ Throwable -> 0x029f }
    L_0x0149:
        if (r1 == 0) goto L_0x014f;	 Catch:{ Throwable -> 0x029f }
    L_0x014b:
        r8 = r1.b;	 Catch:{ Throwable -> 0x029f }
        r4.c = r8;	 Catch:{ Throwable -> 0x029f }
    L_0x014f:
        r8 = android.os.Build.MANUFACTURER;	 Catch:{ Throwable -> 0x029f }
        r13 = ";";	 Catch:{ Throwable -> 0x029f }
        r14 = " ";	 Catch:{ Throwable -> 0x029f }
        r8 = r8.replace(r13, r14);	 Catch:{ Throwable -> 0x029f }
        r13 = android.os.Build.MODEL;	 Catch:{ Throwable -> 0x029f }
        r14 = ";";	 Catch:{ Throwable -> 0x029f }
        r18 = r2;
        r2 = " ";	 Catch:{ Throwable -> 0x029c }
        r2 = r13.replace(r14, r2);	 Catch:{ Throwable -> 0x029c }
        r13 = com.alipay.sdk.sys.b.b();	 Catch:{ Throwable -> 0x029c }
        r6 = r6.a;	 Catch:{ Throwable -> 0x029c }
        r14 = "wifi";	 Catch:{ Throwable -> 0x029c }
        r14 = r5.getSystemService(r14);	 Catch:{ Throwable -> 0x029c }
        r14 = (android.net.wifi.WifiManager) r14;	 Catch:{ Throwable -> 0x029c }
        r14 = r14.getConnectionInfo();	 Catch:{ Throwable -> 0x029c }
        if (r14 == 0) goto L_0x017e;	 Catch:{ Throwable -> 0x029c }
    L_0x0179:
        r14 = r14.getSSID();	 Catch:{ Throwable -> 0x029c }
        goto L_0x0180;	 Catch:{ Throwable -> 0x029c }
    L_0x017e:
        r14 = "-1";	 Catch:{ Throwable -> 0x029c }
    L_0x0180:
        r19 = r3;	 Catch:{ Throwable -> 0x029c }
        r3 = "wifi";	 Catch:{ Throwable -> 0x029c }
        r3 = r5.getSystemService(r3);	 Catch:{ Throwable -> 0x029c }
        r3 = (android.net.wifi.WifiManager) r3;	 Catch:{ Throwable -> 0x029c }
        r3 = r3.getConnectionInfo();	 Catch:{ Throwable -> 0x029c }
        if (r3 == 0) goto L_0x0195;	 Catch:{ Throwable -> 0x029c }
    L_0x0190:
        r3 = r3.getBSSID();	 Catch:{ Throwable -> 0x029c }
        goto L_0x0197;	 Catch:{ Throwable -> 0x029c }
    L_0x0195:
        r3 = "00";	 Catch:{ Throwable -> 0x029c }
    L_0x0197:
        r20 = r5;	 Catch:{ Throwable -> 0x029c }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x029c }
        r5.<init>();	 Catch:{ Throwable -> 0x029c }
        r21 = r1;	 Catch:{ Throwable -> 0x029c }
        r1 = r4.a;	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r7);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r9);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r10);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r11);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r12);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r1 = r4.c;	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r8);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r2);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r13);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r6);	 Catch:{ Throwable -> 0x029c }
        r1 = ";-1;-1;";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r1 = r4.b;	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r15);	 Catch:{ Throwable -> 0x029c }
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r0);	 Catch:{ Throwable -> 0x029c }
        r0 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r0);	 Catch:{ Throwable -> 0x029c }
        r5.append(r14);	 Catch:{ Throwable -> 0x029c }
        r0 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r0);	 Catch:{ Throwable -> 0x029c }
        r5.append(r3);	 Catch:{ Throwable -> 0x029c }
        if (r21 == 0) goto L_0x0253;	 Catch:{ Throwable -> 0x029c }
    L_0x0223:
        r0 = new java.util.HashMap;	 Catch:{ Throwable -> 0x029c }
        r0.<init>();	 Catch:{ Throwable -> 0x029c }
        r1 = "tid";	 Catch:{ Throwable -> 0x029c }
        r2 = r21;	 Catch:{ Throwable -> 0x029c }
        r3 = r2.a;	 Catch:{ Throwable -> 0x029c }
        r0.put(r1, r3);	 Catch:{ Throwable -> 0x029c }
        r1 = "utdid";	 Catch:{ Throwable -> 0x029c }
        r3 = com.alipay.sdk.sys.b.a();	 Catch:{ Throwable -> 0x029c }
        r3 = r3.c();	 Catch:{ Throwable -> 0x029c }
        r0.put(r1, r3);	 Catch:{ Throwable -> 0x029c }
        r1 = r20;	 Catch:{ Throwable -> 0x029c }
        r0 = r4.b(r1, r0);	 Catch:{ Throwable -> 0x029c }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x029c }
        if (r1 != 0) goto L_0x0255;	 Catch:{ Throwable -> 0x029c }
    L_0x024a:
        r1 = ";";	 Catch:{ Throwable -> 0x029c }
        r5.append(r1);	 Catch:{ Throwable -> 0x029c }
        r5.append(r0);	 Catch:{ Throwable -> 0x029c }
        goto L_0x0255;	 Catch:{ Throwable -> 0x029c }
    L_0x0253:
        r2 = r21;	 Catch:{ Throwable -> 0x029c }
    L_0x0255:
        r0 = ")";	 Catch:{ Throwable -> 0x029c }
        r5.append(r0);	 Catch:{ Throwable -> 0x029c }
        r0 = r5.toString();	 Catch:{ Throwable -> 0x029c }
        r1 = r18;
        r3 = r19;
        r1.put(r3, r0);	 Catch:{ Throwable -> 0x02a0 }
        r0 = "has_alipay";	 Catch:{ Throwable -> 0x02a0 }
        r3 = r17;	 Catch:{ Throwable -> 0x02a0 }
        r4 = r3.a;	 Catch:{ Throwable -> 0x02a0 }
        r4 = com.alipay.sdk.util.k.b(r4);	 Catch:{ Throwable -> 0x02a0 }
        r1.put(r0, r4);	 Catch:{ Throwable -> 0x02a0 }
        r0 = "has_msp_app";	 Catch:{ Throwable -> 0x02a0 }
        r4 = r3.a;	 Catch:{ Throwable -> 0x02a0 }
        r4 = com.alipay.sdk.util.k.a(r4);	 Catch:{ Throwable -> 0x02a0 }
        r1.put(r0, r4);	 Catch:{ Throwable -> 0x02a0 }
        r0 = "external_info";	 Catch:{ Throwable -> 0x02a0 }
        r4 = r23;	 Catch:{ Throwable -> 0x02a0 }
        r1.put(r0, r4);	 Catch:{ Throwable -> 0x02a0 }
        r0 = "app_key";	 Catch:{ Throwable -> 0x02a0 }
        r4 = "2014052600006128";	 Catch:{ Throwable -> 0x02a0 }
        r1.put(r0, r4);	 Catch:{ Throwable -> 0x02a0 }
        r0 = "utdid";	 Catch:{ Throwable -> 0x02a0 }
        r3 = r3.c();	 Catch:{ Throwable -> 0x02a0 }
        r1.put(r0, r3);	 Catch:{ Throwable -> 0x02a0 }
        r0 = "new_client_key";	 Catch:{ Throwable -> 0x02a0 }
        r2 = r2.b;	 Catch:{ Throwable -> 0x02a0 }
        r1.put(r0, r2);	 Catch:{ Throwable -> 0x02a0 }
        goto L_0x02a0;
    L_0x029c:
        r1 = r18;
        goto L_0x02a0;
    L_0x029f:
        r1 = r2;
    L_0x02a0:
        r0 = r1.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.d.a(java.lang.String, org.json.JSONObject):java.lang.String");
    }

    private static boolean a(HttpResponse httpResponse) {
        String str = a;
        String str2 = null;
        if (httpResponse != null) {
            httpResponse = httpResponse.getAllHeaders();
            if (httpResponse != null && httpResponse.length > 0) {
                for (Header header : httpResponse) {
                    if (header != null) {
                        String name = header.getName();
                        if (name != null && name.equalsIgnoreCase(str)) {
                            str2 = header.getValue();
                            break;
                        }
                    }
                }
            }
        }
        return Boolean.valueOf(str2).booleanValue();
    }

    private static String a(HttpResponse httpResponse, String str) {
        String str2 = null;
        if (httpResponse == null) {
            return null;
        }
        httpResponse = httpResponse.getAllHeaders();
        if (httpResponse != null && httpResponse.length > 0) {
            for (Header header : httpResponse) {
                if (header != null) {
                    String name = header.getName();
                    if (name != null && name.equalsIgnoreCase(str)) {
                        str2 = header.getValue();
                        break;
                    }
                }
            }
        }
        return str2;
    }

    public static String a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        hashMap = hashMap.entrySet().iterator();
        while (hashMap.hasNext()) {
            Entry entry = (Entry) hashMap.next();
            jSONObject2.put((String) entry.getKey(), entry.getValue());
        }
        hashMap = new JSONObject();
        hashMap2 = hashMap2.entrySet().iterator();
        while (hashMap2.hasNext()) {
            entry = (Entry) hashMap2.next();
            hashMap.put((String) entry.getKey(), entry.getValue());
        }
        jSONObject2.put("params", hashMap);
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    private static boolean a(java.lang.String r3) {
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
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x003b }
        r0.<init>(r3);	 Catch:{ JSONException -> 0x003b }
        r3 = "data";	 Catch:{ JSONException -> 0x003b }
        r3 = r0.getJSONObject(r3);	 Catch:{ JSONException -> 0x003b }
        r0 = "params";	 Catch:{ JSONException -> 0x003b }
        r0 = r3.has(r0);	 Catch:{ JSONException -> 0x003b }
        if (r0 != 0) goto L_0x001c;	 Catch:{ JSONException -> 0x003b }
    L_0x001b:
        return r1;	 Catch:{ JSONException -> 0x003b }
    L_0x001c:
        r0 = "params";	 Catch:{ JSONException -> 0x003b }
        r3 = r3.getJSONObject(r0);	 Catch:{ JSONException -> 0x003b }
        r0 = "public_key";	 Catch:{ JSONException -> 0x003b }
        r2 = 0;	 Catch:{ JSONException -> 0x003b }
        r3 = r3.optString(r0, r2);	 Catch:{ JSONException -> 0x003b }
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ JSONException -> 0x003b }
        if (r0 != 0) goto L_0x003b;	 Catch:{ JSONException -> 0x003b }
    L_0x002f:
        com.alipay.sdk.sys.b.a();	 Catch:{ JSONException -> 0x003b }
        r0 = com.alipay.sdk.data.c.a();	 Catch:{ JSONException -> 0x003b }
        r0.a(r3);	 Catch:{ JSONException -> 0x003b }
        r3 = 1;
        r1 = r3;
    L_0x003b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.d.a(java.lang.String):boolean");
    }

    private static a b(Context context, String str) {
        if (t == null) {
            t = new a(context, str);
        } else if (TextUtils.equals(str, t.b) == null) {
            t.b = str;
        }
        return t;
    }

    private b a(Context context) throws Throwable {
        return a(context, "", j.a(context), true);
    }

    public b a(Context context, String str) throws Throwable {
        return a(context, str, j.a(context), true);
    }

    private b a(Context context, String str, String str2) throws Throwable {
        return a(context, str, str2, true);
    }

    public final b a(Context context, String str, String str2, boolean z) throws Throwable {
        e eVar = new e(this.s);
        c a = eVar.a(new b(c(), a(str, a())), this.r);
        if (t == null) {
            t = new a(context, str2);
        } else if (!TextUtils.equals(str2, t.b)) {
            t.b = str2;
        }
        HttpResponse a2 = t.a(a.b, a(a.a, str));
        String str3 = a;
        String str4 = null;
        if (a2 != null) {
            Header[] allHeaders = a2.getAllHeaders();
            if (allHeaders != null && allHeaders.length > 0) {
                for (Header header : allHeaders) {
                    if (header != null) {
                        String name = header.getName();
                        if (name != null && name.equalsIgnoreCase(str3)) {
                            str4 = header.getValue();
                            break;
                        }
                    }
                }
            }
        }
        b a3 = eVar.a(new c(Boolean.valueOf(str4).booleanValue(), b(a2)));
        return (a3 != null && a(a3.a) && z) ? a(context, str, str2, false) : a3;
    }

    private static byte[] b(org.apache.http.HttpResponse r4) throws java.lang.IllegalStateException, java.io.IOException {
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
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];
        r1 = 0;
        r4 = r4.getEntity();	 Catch:{ all -> 0x0030 }
        r4 = r4.getContent();	 Catch:{ all -> 0x0030 }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x002e }
        r2.<init>();	 Catch:{ all -> 0x002e }
    L_0x0012:
        r1 = r4.read(r0);	 Catch:{ all -> 0x002b }
        r3 = -1;	 Catch:{ all -> 0x002b }
        if (r1 == r3) goto L_0x001e;	 Catch:{ all -> 0x002b }
    L_0x0019:
        r3 = 0;	 Catch:{ all -> 0x002b }
        r2.write(r0, r3, r1);	 Catch:{ all -> 0x002b }
        goto L_0x0012;	 Catch:{ all -> 0x002b }
    L_0x001e:
        r0 = r2.toByteArray();	 Catch:{ all -> 0x002b }
        if (r4 == 0) goto L_0x0027;
    L_0x0024:
        r4.close();	 Catch:{ Exception -> 0x0027 }
    L_0x0027:
        r2.close();	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        return r0;
    L_0x002b:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0032;
    L_0x002e:
        r0 = move-exception;
        goto L_0x0032;
    L_0x0030:
        r0 = move-exception;
        r4 = r1;
    L_0x0032:
        if (r4 == 0) goto L_0x0037;
    L_0x0034:
        r4.close();	 Catch:{ Exception -> 0x0037 }
    L_0x0037:
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.close();	 Catch:{ Exception -> 0x003c }
    L_0x003c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.d.b(org.apache.http.HttpResponse):byte[]");
    }
}
