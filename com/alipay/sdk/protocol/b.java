package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.alipay.sdk.util.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class b {
    public a a;
    public String[] b;
    private String c;

    private b(String str) {
        this.c = str;
    }

    private b(String str, a aVar) {
        this.c = str;
        this.a = aVar;
    }

    private static void a(com.alipay.sdk.protocol.b r5) {
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
        r5 = r5.b;
        r0 = 3;
        r1 = r5.length;
        if (r1 == r0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = "tid";
        r1 = 0;
        r1 = r5[r1];
        r0 = android.text.TextUtils.equals(r0, r1);
        if (r0 == 0) goto L_0x0061;
    L_0x0012:
        r0 = com.alipay.sdk.sys.b.a();
        r0 = r0.a;
        r1 = com.alipay.sdk.tid.b.a();
        r2 = 1;
        r3 = r5[r2];
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0060;
    L_0x0025:
        r3 = 2;
        r4 = r5[r3];
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0060;
    L_0x002f:
        r2 = r5[r2];
        r1.a = r2;
        r5 = r5[r3];
        r1.b = r5;
        r5 = new com.alipay.sdk.tid.a;
        r5.<init>(r0);
        r2 = com.alipay.sdk.util.a.a(r0);	 Catch:{ Exception -> 0x005c, all -> 0x0057 }
        r2 = r2.a();	 Catch:{ Exception -> 0x005c, all -> 0x0057 }
        r0 = com.alipay.sdk.util.a.a(r0);	 Catch:{ Exception -> 0x005c, all -> 0x0057 }
        r0 = r0.b();	 Catch:{ Exception -> 0x005c, all -> 0x0057 }
        r3 = r1.a;	 Catch:{ Exception -> 0x005c, all -> 0x0057 }
        r1 = r1.b;	 Catch:{ Exception -> 0x005c, all -> 0x0057 }
        r5.a(r2, r0, r3, r1);	 Catch:{ Exception -> 0x005c, all -> 0x0057 }
        r5.close();
        return;
    L_0x0057:
        r0 = move-exception;
        r5.close();
        throw r0;
    L_0x005c:
        r5.close();
        return;
    L_0x0060:
        return;
    L_0x0061:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.protocol.b.a(com.alipay.sdk.protocol.b):void");
    }

    public static List<b> a(JSONObject jSONObject) {
        List<b> arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        jSONObject = jSONObject.optString(c.e, "");
        String[] strArr = null;
        if (!TextUtils.isEmpty(jSONObject)) {
            strArr = jSONObject.split(h.b);
        }
        for (jSONObject = null; jSONObject < strArr.length; jSONObject++) {
            a a = a.a(strArr[jSONObject]);
            if (a != a.None) {
                b bVar = new b(strArr[jSONObject], a);
                bVar.b = a(strArr[jSONObject]);
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private static String[] a(String str) {
        List arrayList = new ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (!(indexOf == -1 || lastIndexOf == -1)) {
            if (lastIndexOf > indexOf) {
                str = str.substring(indexOf + 1, lastIndexOf).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (str != null) {
                    for (lastIndexOf = 0; lastIndexOf < str.length; lastIndexOf++) {
                        if (!TextUtils.isEmpty(str[lastIndexOf])) {
                            arrayList.add(str[lastIndexOf].trim().replaceAll("'", "").replaceAll("\"", ""));
                        }
                    }
                }
                return (String[]) arrayList.toArray(new String[0]);
            }
        }
        return null;
    }

    private static String[] b(String str) {
        return !TextUtils.isEmpty(str) ? str.split(h.b) : null;
    }

    private String a() {
        return this.c;
    }

    private a b() {
        return this.a;
    }

    private String[] c() {
        return this.b;
    }
}
