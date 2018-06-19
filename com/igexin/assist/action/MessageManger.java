package com.igexin.assist.action;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.a;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageManger {
    private ExecutorService a;
    private String b;

    private MessageManger() {
        this.a = Executors.newSingleThreadExecutor();
    }

    private PushTaskBean a(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(dVar.e());
        pushTaskBean.setMessageId(dVar.d());
        pushTaskBean.setTaskId(dVar.c());
        pushTaskBean.setId(String.valueOf(currentTimeMillis));
        pushTaskBean.setAppKey(g.b);
        pushTaskBean.setCurrentActionid(1);
        return pushTaskBean;
    }

    private java.lang.Class a(android.content.Context r3) {
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
        r0 = "uis";	 Catch:{ Throwable -> 0x0015 }
        r1 = "";	 Catch:{ Throwable -> 0x0015 }
        r3 = com.igexin.push.util.p.b(r3, r0, r1);	 Catch:{ Throwable -> 0x0015 }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x0015 }
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0015 }
        if (r0 != 0) goto L_0x0015;	 Catch:{ Throwable -> 0x0015 }
    L_0x0010:
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0015 }
        return r3;
    L_0x0015:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.action.MessageManger.a(android.content.Context):java.lang.Class");
    }

    private void a(com.igexin.assist.action.d r9, android.content.Context r10) {
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
        r8 = this;
        if (r9 == 0) goto L_0x0120;
    L_0x0002:
        if (r10 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = new com.igexin.push.core.b.c;	 Catch:{ Throwable -> 0x0120 }
        r0.<init>(r10);	 Catch:{ Throwable -> 0x0120 }
        r1 = r9.c();	 Catch:{ Throwable -> 0x0120 }
        r1 = r0.a(r1);	 Catch:{ Throwable -> 0x0120 }
        if (r1 != 0) goto L_0x0108;	 Catch:{ Throwable -> 0x0120 }
    L_0x0014:
        r1 = r9.c();	 Catch:{ Throwable -> 0x0120 }
        r0.b(r1);	 Catch:{ Throwable -> 0x0120 }
        r0 = r8.a(r10);	 Catch:{ Throwable -> 0x0120 }
        r1 = 10001; // 0x2711 float:1.4014E-41 double:4.941E-320;	 Catch:{ Throwable -> 0x0120 }
        if (r0 == 0) goto L_0x006c;	 Catch:{ Throwable -> 0x0120 }
    L_0x0023:
        r2 = new android.content.Intent;	 Catch:{ Throwable -> 0x0120 }
        r2.<init>(r10, r0);	 Catch:{ Throwable -> 0x0120 }
        r0 = new android.os.Bundle;	 Catch:{ Throwable -> 0x0120 }
        r0.<init>();	 Catch:{ Throwable -> 0x0120 }
        r3 = "action";	 Catch:{ Throwable -> 0x0120 }
        r0.putInt(r3, r1);	 Catch:{ Throwable -> 0x0120 }
        r1 = "transmit_data";	 Catch:{ Throwable -> 0x0120 }
        r3 = new com.igexin.sdk.message.GTTransmitMessage;	 Catch:{ Throwable -> 0x0120 }
        r4 = r9.c();	 Catch:{ Throwable -> 0x0120 }
        r5 = r9.d();	 Catch:{ Throwable -> 0x0120 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0120 }
        r6.<init>();	 Catch:{ Throwable -> 0x0120 }
        r7 = r9.d();	 Catch:{ Throwable -> 0x0120 }
        r6.append(r7);	 Catch:{ Throwable -> 0x0120 }
        r7 = ":";	 Catch:{ Throwable -> 0x0120 }
        r6.append(r7);	 Catch:{ Throwable -> 0x0120 }
        r7 = r9.c();	 Catch:{ Throwable -> 0x0120 }
        r6.append(r7);	 Catch:{ Throwable -> 0x0120 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0120 }
        r7 = r9.b();	 Catch:{ Throwable -> 0x0120 }
        r3.<init>(r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0120 }
        r0.putSerializable(r1, r3);	 Catch:{ Throwable -> 0x0120 }
        r2.putExtras(r0);	 Catch:{ Throwable -> 0x0120 }
        r10.startService(r2);	 Catch:{ Throwable -> 0x0120 }
        goto L_0x00ef;	 Catch:{ Throwable -> 0x0120 }
    L_0x006c:
        r0 = new android.content.Intent;	 Catch:{ Throwable -> 0x0120 }
        r0.<init>();	 Catch:{ Throwable -> 0x0120 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0120 }
        r3 = 12;	 Catch:{ Throwable -> 0x0120 }
        if (r2 < r3) goto L_0x007c;	 Catch:{ Throwable -> 0x0120 }
    L_0x0077:
        r2 = 32;	 Catch:{ Throwable -> 0x0120 }
        r0.addFlags(r2);	 Catch:{ Throwable -> 0x0120 }
    L_0x007c:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0120 }
        r3 = "com.igexin.sdk.action.";	 Catch:{ Throwable -> 0x0120 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0120 }
        r3 = r9.e();	 Catch:{ Throwable -> 0x0120 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0120 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0120 }
        r0.setAction(r2);	 Catch:{ Throwable -> 0x0120 }
        r2 = new android.os.Bundle;	 Catch:{ Throwable -> 0x0120 }
        r2.<init>();	 Catch:{ Throwable -> 0x0120 }
        r3 = "action";	 Catch:{ Throwable -> 0x0120 }
        r2.putInt(r3, r1);	 Catch:{ Throwable -> 0x0120 }
        r1 = "taskid";	 Catch:{ Throwable -> 0x0120 }
        r3 = r9.c();	 Catch:{ Throwable -> 0x0120 }
        r2.putString(r1, r3);	 Catch:{ Throwable -> 0x0120 }
        r1 = "messageid";	 Catch:{ Throwable -> 0x0120 }
        r3 = r9.d();	 Catch:{ Throwable -> 0x0120 }
        r2.putString(r1, r3);	 Catch:{ Throwable -> 0x0120 }
        r1 = "appid";	 Catch:{ Throwable -> 0x0120 }
        r3 = r9.e();	 Catch:{ Throwable -> 0x0120 }
        r2.putString(r1, r3);	 Catch:{ Throwable -> 0x0120 }
        r1 = "payloadid";	 Catch:{ Throwable -> 0x0120 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0120 }
        r3.<init>();	 Catch:{ Throwable -> 0x0120 }
        r4 = r9.d();	 Catch:{ Throwable -> 0x0120 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0120 }
        r4 = ":";	 Catch:{ Throwable -> 0x0120 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0120 }
        r4 = r9.c();	 Catch:{ Throwable -> 0x0120 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0120 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0120 }
        r2.putString(r1, r3);	 Catch:{ Throwable -> 0x0120 }
        r1 = "packagename";	 Catch:{ Throwable -> 0x0120 }
        r3 = r9.g();	 Catch:{ Throwable -> 0x0120 }
        r2.putString(r1, r3);	 Catch:{ Throwable -> 0x0120 }
        r1 = "payload";	 Catch:{ Throwable -> 0x0120 }
        r3 = r9.b();	 Catch:{ Throwable -> 0x0120 }
        r2.putByteArray(r1, r3);	 Catch:{ Throwable -> 0x0120 }
        r0.putExtras(r2);	 Catch:{ Throwable -> 0x0120 }
        r10.sendBroadcast(r0);	 Catch:{ Throwable -> 0x0120 }
    L_0x00ef:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0120 }
        r0.<init>();	 Catch:{ Throwable -> 0x0120 }
        r1 = r8.getBrandCode(r10);	 Catch:{ Throwable -> 0x0120 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0120 }
        r1 = "0";	 Catch:{ Throwable -> 0x0120 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0120 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0120 }
        r8.feedbackPushMessage(r10, r9, r0);	 Catch:{ Throwable -> 0x0120 }
        return;	 Catch:{ Throwable -> 0x0120 }
    L_0x0108:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0120 }
        r0.<init>();	 Catch:{ Throwable -> 0x0120 }
        r1 = r8.getBrandCode(r10);	 Catch:{ Throwable -> 0x0120 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0120 }
        r1 = "1";	 Catch:{ Throwable -> 0x0120 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0120 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0120 }
        r8.feedbackPushMessage(r10, r9, r0);	 Catch:{ Throwable -> 0x0120 }
    L_0x0120:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.action.MessageManger.a(com.igexin.assist.action.d, android.content.Context):void");
    }

    private void a(java.lang.String r2) {
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
        r1 = this;
        r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0028 }
        if (r0 != 0) goto L_0x0028;	 Catch:{ Throwable -> 0x0028 }
    L_0x0006:
        r0 = com.igexin.push.core.g.g;	 Catch:{ Throwable -> 0x0028 }
        r0 = r0.get();	 Catch:{ Throwable -> 0x0028 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ Throwable -> 0x0028 }
    L_0x000e:
        r0 = com.igexin.push.core.g.z;	 Catch:{ Throwable -> 0x0028 }
        r0 = r2.equals(r0);	 Catch:{ Throwable -> 0x0028 }
        if (r0 != 0) goto L_0x0028;	 Catch:{ Throwable -> 0x0028 }
    L_0x0016:
        r0 = com.igexin.push.core.b.g.a();	 Catch:{ Throwable -> 0x0028 }
        r0.c(r2);	 Catch:{ Throwable -> 0x0028 }
        r2 = com.igexin.push.core.g.l;	 Catch:{ Throwable -> 0x0028 }
        if (r2 == 0) goto L_0x0028;	 Catch:{ Throwable -> 0x0028 }
    L_0x0021:
        r2 = com.igexin.push.core.a.f.a();	 Catch:{ Throwable -> 0x0028 }
        r2.j();	 Catch:{ Throwable -> 0x0028 }
    L_0x0028:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.action.MessageManger.a(java.lang.String):void");
    }

    public static MessageManger getInstance() {
        return c.a;
    }

    public void addMessage(MessageBean messageBean) {
        if (this.a != null) {
            this.a.execute(new b(this, messageBean));
        }
    }

    public void feedbackPushMessage(android.content.Context r5, com.igexin.assist.action.d r6, java.lang.String r7) {
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
        r4 = this;
        r0 = com.igexin.push.core.g.g;	 Catch:{ Throwable -> 0x0056 }
        r0 = r0.get();	 Catch:{ Throwable -> 0x0056 }
        if (r0 == 0) goto L_0x0014;	 Catch:{ Throwable -> 0x0056 }
    L_0x0008:
        r5 = com.igexin.push.core.a.f.a();	 Catch:{ Throwable -> 0x0056 }
        r6 = r4.a(r6);	 Catch:{ Throwable -> 0x0056 }
        r5.a(r6, r7);	 Catch:{ Throwable -> 0x0056 }
        return;	 Catch:{ Throwable -> 0x0056 }
    L_0x0014:
        r0 = new com.igexin.push.core.b.c;	 Catch:{ Throwable -> 0x0056 }
        r0.<init>(r5);	 Catch:{ Throwable -> 0x0056 }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0056 }
        r5 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0056 }
        r5.<init>();	 Catch:{ Throwable -> 0x0056 }
        r3 = "id";	 Catch:{ Throwable -> 0x0056 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x0056 }
        r5.put(r3, r1);	 Catch:{ Throwable -> 0x0056 }
        r1 = "messageid";	 Catch:{ Throwable -> 0x0056 }
        r2 = r6.d();	 Catch:{ Throwable -> 0x0056 }
        r5.put(r1, r2);	 Catch:{ Throwable -> 0x0056 }
        r1 = "taskid";	 Catch:{ Throwable -> 0x0056 }
        r2 = r6.c();	 Catch:{ Throwable -> 0x0056 }
        r5.put(r1, r2);	 Catch:{ Throwable -> 0x0056 }
        r1 = "multaid";	 Catch:{ Throwable -> 0x0056 }
        r5.put(r1, r7);	 Catch:{ Throwable -> 0x0056 }
        r7 = "timestamp";	 Catch:{ Throwable -> 0x0056 }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0056 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x0056 }
        r5.put(r7, r1);	 Catch:{ Throwable -> 0x0056 }
        r6 = r6.c();	 Catch:{ Throwable -> 0x0056 }
        r0.a(r6, r5);	 Catch:{ Throwable -> 0x0056 }
    L_0x0056:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.action.MessageManger.feedbackPushMessage(android.content.Context, com.igexin.assist.action.d, java.lang.String):void");
    }

    public String getBrandCode(Context context) {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        String str;
        if (a.d(context)) {
            str = "2";
        } else if (a.b(context)) {
            str = "3";
        } else {
            if (a.c(context)) {
                str = "4";
            }
            return this.b;
        }
        this.b = str;
        return this.b;
    }
}
