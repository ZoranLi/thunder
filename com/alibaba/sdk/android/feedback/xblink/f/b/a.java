package com.alibaba.sdk.android.feedback.xblink.f.b;

import android.content.Intent;
import com.alibaba.sdk.android.feedback.xblink.f.b;
import com.alibaba.sdk.android.feedback.xblink.f.m;

public class a extends com.alibaba.sdk.android.feedback.xblink.f.a {
    public static int d = 4001;
    public static int e = 4002;
    private b f = null;

    private void a(com.alibaba.sdk.android.feedback.xblink.f.b r10, java.lang.String r11) {
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
        r9 = this;
        r9.f = r10;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00b0 }
        r0.<init>(r11);	 Catch:{ JSONException -> 0x00b0 }
        r11 = "url";	 Catch:{ JSONException -> 0x00b0 }
        r11 = r0.has(r11);	 Catch:{ JSONException -> 0x00b0 }
        if (r11 == 0) goto L_0x0016;	 Catch:{ JSONException -> 0x00b0 }
    L_0x000f:
        r11 = "url";	 Catch:{ JSONException -> 0x00b0 }
        r11 = r0.getString(r11);	 Catch:{ JSONException -> 0x00b0 }
        goto L_0x0017;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0016:
        r11 = 0;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0017:
        r1 = "nav";	 Catch:{ JSONException -> 0x00b0 }
        r1 = r0.has(r1);	 Catch:{ JSONException -> 0x00b0 }
        r2 = 0;	 Catch:{ JSONException -> 0x00b0 }
        if (r1 == 0) goto L_0x0027;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0020:
        r1 = "nav";	 Catch:{ JSONException -> 0x00b0 }
        r1 = r0.getBoolean(r1);	 Catch:{ JSONException -> 0x00b0 }
        goto L_0x0028;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0027:
        r1 = r2;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0028:
        r3 = "login";	 Catch:{ JSONException -> 0x00b0 }
        r3 = r0.has(r3);	 Catch:{ JSONException -> 0x00b0 }
        r4 = 1;	 Catch:{ JSONException -> 0x00b0 }
        if (r3 == 0) goto L_0x0038;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0031:
        r3 = "login";	 Catch:{ JSONException -> 0x00b0 }
        r3 = r0.getBoolean(r3);	 Catch:{ JSONException -> 0x00b0 }
        goto L_0x0039;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0038:
        r3 = r4;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0039:
        r5 = "external";	 Catch:{ JSONException -> 0x00b0 }
        r5 = r0.has(r5);	 Catch:{ JSONException -> 0x00b0 }
        if (r5 == 0) goto L_0x0048;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0041:
        r5 = "external";	 Catch:{ JSONException -> 0x00b0 }
        r5 = r0.getBoolean(r5);	 Catch:{ JSONException -> 0x00b0 }
        goto L_0x0049;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0048:
        r5 = r2;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0049:
        r6 = "fullScreen";	 Catch:{ JSONException -> 0x00b0 }
        r6 = r0.has(r6);	 Catch:{ JSONException -> 0x00b0 }
        if (r6 == 0) goto L_0x0058;	 Catch:{ JSONException -> 0x00b0 }
    L_0x0051:
        r6 = "fullScreen";	 Catch:{ JSONException -> 0x00b0 }
        r0 = r0.getInt(r6);	 Catch:{ JSONException -> 0x00b0 }
        goto L_0x0059;
    L_0x0058:
        r0 = r2;
    L_0x0059:
        r6 = new android.content.Intent;
        r6.<init>();
        r7 = r9.a;	 Catch:{  }
        r8 = com.alibaba.sdk.android.feedback.windvane.CustomHybirdActivity.class;	 Catch:{  }
        r6.setClass(r7, r8);	 Catch:{  }
        r7 = "needLogin";
        r6.putExtra(r7, r3);
        if (r0 != 0) goto L_0x0072;
    L_0x006c:
        r0 = "hideTitle";
        r6.putExtra(r0, r2);
        goto L_0x0077;
    L_0x0072:
        r0 = "hideTitle";
        r6.putExtra(r0, r4);
    L_0x0077:
        r0 = "external";
        r6.putExtra(r0, r5);
        r0 = "need_show_nav";
        r6.putExtra(r0, r1);
        r0 = "URL";
        r6.putExtra(r0, r11);
        if (r10 == 0) goto L_0x00a1;
    L_0x0088:
        r11 = r10.a();
        if (r11 == 0) goto L_0x00a1;
    L_0x008e:
        r10 = r10.a();
        r10 = r10.getAppkey();
        r11 = android.text.TextUtils.isEmpty(r10);
        if (r11 != 0) goto L_0x00a1;
    L_0x009c:
        r11 = "APPKEY";
        r6.putExtra(r11, r10);
    L_0x00a1:
        r10 = r9.a;
        r10 = r10 instanceof android.app.Activity;
        if (r10 == 0) goto L_0x00b0;
    L_0x00a7:
        r10 = r9.a;
        r10 = (android.app.Activity) r10;
        r11 = d;
        r10.startActivityForResult(r6, r11);
    L_0x00b0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.b.a.a(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    public void a(int i, int i2, Intent intent) {
        m mVar = new m();
        if (i == d && i2 == e) {
            mVar.a("url", intent.getStringExtra("url"));
            mVar.a();
            if (this.f != null) {
                this.f.a(mVar);
            }
        }
    }

    public boolean a(String str, String str2, b bVar) {
        if ("createNewPage".equals(str)) {
            a(bVar, str2);
        }
        return false;
    }
}
