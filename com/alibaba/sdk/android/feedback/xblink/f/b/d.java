package com.alibaba.sdk.android.feedback.xblink.f.b;

import android.content.BroadcastReceiver;
import android.content.Intent;
import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;

public class d extends a {
    private b d;
    private boolean e = false;
    private List f = new ArrayList();
    private BroadcastReceiver g = new e(this);

    private java.lang.String a(java.lang.String r6, java.lang.String r7) {
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
        r0 = new java.lang.StringBuffer;	 Catch:{ JSONException -> 0x004c }
        r0.<init>(r6);	 Catch:{ JSONException -> 0x004c }
        if (r7 != 0) goto L_0x000c;	 Catch:{ JSONException -> 0x004c }
    L_0x0007:
        r6 = r0.toString();	 Catch:{ JSONException -> 0x004c }
        return r6;	 Catch:{ JSONException -> 0x004c }
    L_0x000c:
        r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x004c }
        r6.<init>(r7);	 Catch:{ JSONException -> 0x004c }
        r7 = r6.keys();	 Catch:{ JSONException -> 0x004c }
        r1 = 0;	 Catch:{ JSONException -> 0x004c }
    L_0x0016:
        r2 = r7.hasNext();	 Catch:{ JSONException -> 0x004c }
        if (r2 == 0) goto L_0x0047;	 Catch:{ JSONException -> 0x004c }
    L_0x001c:
        r2 = r7.next();	 Catch:{ JSONException -> 0x004c }
        r2 = (java.lang.String) r2;	 Catch:{ JSONException -> 0x004c }
        r3 = r6.getString(r2);	 Catch:{ JSONException -> 0x004c }
        if (r1 != 0) goto L_0x0039;	 Catch:{ JSONException -> 0x004c }
    L_0x0028:
        r4 = "?";	 Catch:{ JSONException -> 0x004c }
        r0.append(r4);	 Catch:{ JSONException -> 0x004c }
        r0.append(r2);	 Catch:{ JSONException -> 0x004c }
        r2 = "=";	 Catch:{ JSONException -> 0x004c }
    L_0x0032:
        r0.append(r2);	 Catch:{ JSONException -> 0x004c }
        r0.append(r3);	 Catch:{ JSONException -> 0x004c }
        goto L_0x0044;	 Catch:{ JSONException -> 0x004c }
    L_0x0039:
        r4 = "&";	 Catch:{ JSONException -> 0x004c }
        r0.append(r4);	 Catch:{ JSONException -> 0x004c }
        r0.append(r2);	 Catch:{ JSONException -> 0x004c }
        r2 = "=";	 Catch:{ JSONException -> 0x004c }
        goto L_0x0032;	 Catch:{ JSONException -> 0x004c }
    L_0x0044:
        r1 = r1 + 1;	 Catch:{ JSONException -> 0x004c }
        goto L_0x0016;	 Catch:{ JSONException -> 0x004c }
    L_0x0047:
        r6 = r0.toString();	 Catch:{ JSONException -> 0x004c }
        return r6;
    L_0x004c:
        r6 = 0;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.b.d.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private void a(com.alibaba.sdk.android.feedback.xblink.f.b r5, java.lang.String r6) {
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
        r4 = this;
        r0 = new com.alibaba.sdk.android.feedback.xblink.f.m;
        r0.<init>();
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x002f }
        r1.<init>(r6);	 Catch:{ JSONException -> 0x002f }
        r6 = "event";	 Catch:{ JSONException -> 0x002f }
        r6 = r1.has(r6);	 Catch:{ JSONException -> 0x002f }
        r2 = 0;	 Catch:{ JSONException -> 0x002f }
        if (r6 == 0) goto L_0x001a;	 Catch:{ JSONException -> 0x002f }
    L_0x0013:
        r6 = "event";	 Catch:{ JSONException -> 0x002f }
        r6 = r1.getString(r6);	 Catch:{ JSONException -> 0x002f }
        goto L_0x001b;	 Catch:{ JSONException -> 0x002f }
    L_0x001a:
        r6 = r2;	 Catch:{ JSONException -> 0x002f }
    L_0x001b:
        r3 = "data";	 Catch:{ JSONException -> 0x002f }
        r3 = r1.has(r3);	 Catch:{ JSONException -> 0x002f }
        if (r3 == 0) goto L_0x0029;	 Catch:{ JSONException -> 0x002f }
    L_0x0023:
        r2 = "data";	 Catch:{ JSONException -> 0x002f }
        r2 = r1.getString(r2);	 Catch:{ JSONException -> 0x002f }
    L_0x0029:
        r1 = android.text.TextUtils.isEmpty(r6);
        if (r1 == 0) goto L_0x0038;
    L_0x002f:
        r6 = "HY_PARAM_ERR";
        r0.a(r6);
        r5.b(r0);
        return;
    L_0x0038:
        r6 = r4.a(r6, r2);
        r6 = android.text.TextUtils.isEmpty(r6);
        if (r6 == 0) goto L_0x0045;
    L_0x0042:
        r5.b(r0);
    L_0x0045:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.b.d.a(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    private void a(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
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
        r2 = this;
        r0 = new com.alibaba.sdk.android.feedback.xblink.f.m;
        r0.<init>();
        r0.a();
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000e }
        r1.<init>(r5);	 Catch:{ JSONException -> 0x000e }
        goto L_0x000f;
    L_0x000e:
        r1 = 0;
    L_0x000f:
        if (r1 == 0) goto L_0x0017;
    L_0x0011:
        r5 = "data";
        r0.a(r5, r1);
        goto L_0x001c;
    L_0x0017:
        r1 = "data";
        r0.a(r1, r5);
    L_0x001c:
        r5 = "sourceId";
        r0.a(r5, r3);
        r3 = android.text.TextUtils.isEmpty(r4);
        if (r3 != 0) goto L_0x002c;
    L_0x0027:
        r3 = "fromId";
        r0.a(r3, r4);
    L_0x002c:
        r3 = r2.d;
        if (r3 == 0) goto L_0x003b;
    L_0x0030:
        r3 = r2.d;
        r4 = "WXCommunication.onNotify";
        r5 = r0.b();
        com.alibaba.sdk.android.feedback.xblink.f.c.a(r3, r4, r5);
    L_0x003b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.b.d.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private void b(b bVar, String str) {
    }

    private void c(b bVar, String str) {
    }

    private void d(b bVar, String str) {
    }

    private void e(com.alibaba.sdk.android.feedback.xblink.f.b r4, java.lang.String r5) {
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
        r0 = r3.a;
        r1 = "clipboard";
        r0 = r0.getSystemService(r1);
        r0 = (android.text.ClipboardManager) r0;
        r1 = new com.alibaba.sdk.android.feedback.xblink.f.m;
        r1.<init>();
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0034 }
        r2.<init>(r5);	 Catch:{ JSONException -> 0x0034 }
        r5 = "text";	 Catch:{ JSONException -> 0x0034 }
        r5 = r2.has(r5);	 Catch:{ JSONException -> 0x0034 }
        if (r5 == 0) goto L_0x0023;	 Catch:{ JSONException -> 0x0034 }
    L_0x001c:
        r5 = "text";	 Catch:{ JSONException -> 0x0034 }
        r5 = r2.getString(r5);	 Catch:{ JSONException -> 0x0034 }
        goto L_0x0024;
    L_0x0023:
        r5 = 0;
    L_0x0024:
        r2 = android.text.TextUtils.isEmpty(r5);
        if (r2 != 0) goto L_0x002d;
    L_0x002a:
        r0.setText(r5);
    L_0x002d:
        r1.a();
        r4.a(r1);
        return;
    L_0x0034:
        r5 = "HY_PARAM_ERR";
        r1.a(r5);
        r4.b(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.b.d.e(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    public void a() {
        super.a();
    }

    public void a(int i, int i2, Intent intent) {
    }

    public boolean a(String str, String str2, b bVar) {
        if ("sendBroadcast".equals(str)) {
            b(bVar, str2);
        } else if ("callAction".equals(str)) {
            a(bVar, str2);
        } else if ("setNotifySourceId".equals(str)) {
            c(bVar, str2);
        } else if (AgooConstants.MESSAGE_NOTIFICATION.equals(str)) {
            d(bVar, str2);
        } else if (!"copyToPasteboard".equals(str)) {
            return false;
        } else {
            e(bVar, str2);
        }
        return true;
    }
}
