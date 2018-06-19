package com.baidu.mobads.production;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.command.c.a;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class q implements IXAdContainerEventListener {
    private Context a;
    private final b b;
    private AtomicBoolean c;
    private AtomicBoolean d;
    private AtomicBoolean e;
    private AtomicBoolean f;
    private int g = 0;
    private int h = 2;
    private int i = 15;
    private int j = 0;
    private int k = 2;
    private int l = 15;

    public q(Context context, b bVar) {
        this.a = context;
        this.b = bVar;
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
    }

    private void a(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
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
        r0 = 0;
        r9.g = r0;	 Catch:{ Exception -> 0x0025 }
        r0 = new java.util.Timer;	 Catch:{ Exception -> 0x0025 }
        r0.<init>();	 Catch:{ Exception -> 0x0025 }
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0025 }
        r3 = r1.getPackageUtils();	 Catch:{ Exception -> 0x0025 }
        r8 = new com.baidu.mobads.production.r;	 Catch:{ Exception -> 0x0025 }
        r1 = r8;	 Catch:{ Exception -> 0x0025 }
        r2 = r9;	 Catch:{ Exception -> 0x0025 }
        r4 = r10;	 Catch:{ Exception -> 0x0025 }
        r5 = r12;	 Catch:{ Exception -> 0x0025 }
        r6 = r0;	 Catch:{ Exception -> 0x0025 }
        r7 = r11;	 Catch:{ Exception -> 0x0025 }
        r1.<init>(r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0025 }
        r3 = 0;	 Catch:{ Exception -> 0x0025 }
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x0025 }
        r1 = r0;	 Catch:{ Exception -> 0x0025 }
        r2 = r8;	 Catch:{ Exception -> 0x0025 }
        r1.schedule(r2, r3, r5);	 Catch:{ Exception -> 0x0025 }
        return;
    L_0x0025:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.q.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    private void a(android.content.Context r9, java.lang.String r10) {
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
        r8 = this;
        r0 = 0;
        r8.j = r0;	 Catch:{ Exception -> 0x0024 }
        r0 = new java.util.Timer;	 Catch:{ Exception -> 0x0024 }
        r0.<init>();	 Catch:{ Exception -> 0x0024 }
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0024 }
        r3 = r1.getPackageUtils();	 Catch:{ Exception -> 0x0024 }
        r7 = new com.baidu.mobads.production.s;	 Catch:{ Exception -> 0x0024 }
        r1 = r7;	 Catch:{ Exception -> 0x0024 }
        r2 = r8;	 Catch:{ Exception -> 0x0024 }
        r4 = r9;	 Catch:{ Exception -> 0x0024 }
        r5 = r10;	 Catch:{ Exception -> 0x0024 }
        r6 = r0;	 Catch:{ Exception -> 0x0024 }
        r1.<init>(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0024 }
        r3 = 0;	 Catch:{ Exception -> 0x0024 }
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x0024 }
        r1 = r0;	 Catch:{ Exception -> 0x0024 }
        r2 = r7;	 Catch:{ Exception -> 0x0024 }
        r1.schedule(r2, r3, r5);	 Catch:{ Exception -> 0x0024 }
        return;
    L_0x0024:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.q.a(android.content.Context, java.lang.String):void");
    }

    public void onAdClicked(com.baidu.mobads.interfaces.IXAdContainer r26, com.baidu.mobads.interfaces.IXAdInstanceInfo r27, java.lang.Boolean r28, java.util.HashMap<java.lang.String, java.lang.Object> r29) {
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
        r25 = this;
        r0 = r25;
        r1 = r26;
        r2 = r27;
        r3 = r28;
        r4 = r29;
        r5 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r6 = r5.getCommonUtils();
        r5 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r5 = r5.getSystemUtils();
        r5 = (com.baidu.mobads.utils.o) r5;
        r7 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r7 = r7.getAdConstants();
        r8 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r9 = r8.getPackageUtils();
        r8 = r0.b;
        r10 = r26.getAdContainerContext();
        r15 = r10.getAdResource();
        r14 = 0;
        r10 = java.lang.Boolean.valueOf(r14);
        r11 = r27.getClickThroughUrl();
        r12 = r27.getActionType();
        r13 = new java.util.ArrayList;
        r13.<init>();
        r14 = r27.getThirdClickTrackingUrls();
        r18 = r10;
        r19 = r15;
        r10 = 0;
    L_0x0051:
        r15 = r14.size();
        if (r10 >= r15) goto L_0x007e;
    L_0x0057:
        r15 = r14.get(r10);
        r15 = (java.lang.String) r15;
        r20 = r14;
        r14 = "\\$\\{PROGRESS\\}";
        r22 = r5;
        r21 = r6;
        r5 = r26.getPlayheadTime();
        r5 = (int) r5;
        r5 = java.lang.String.valueOf(r5);
        r5 = r15.replaceAll(r14, r5);
        r13.add(r5);
        r10 = r10 + 1;
        r14 = r20;
        r6 = r21;
        r5 = r22;
        goto L_0x0051;
    L_0x007e:
        r22 = r5;
        r21 = r6;
        r5 = new java.util.HashSet;
        r5.<init>();
        r5.addAll(r13);
        r0.a(r5);
        r5 = r7.getActTypeOpenExternalApp();
        r6 = 1;
        if (r12 != r5) goto L_0x0187;
    L_0x0094:
        r5 = java.lang.Boolean.valueOf(r6);
        r10 = new org.json.JSONObject;	 Catch:{ Exception -> 0x009f }
        r10.<init>(r11);	 Catch:{ Exception -> 0x009f }
    L_0x009d:
        r15 = r10;
        goto L_0x00be;
    L_0x009f:
        r10 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0186 }
        r12 = r27.getAppOpenStrs();	 Catch:{ Exception -> 0x0186 }
        r10.<init>(r12);	 Catch:{ Exception -> 0x0186 }
        r12 = new com.baidu.mobads.openad.d.a;	 Catch:{ Exception -> 0x0186 }
        r12.<init>();	 Catch:{ Exception -> 0x0186 }
        r13 = new com.baidu.mobads.openad.d.c;	 Catch:{ Exception -> 0x0186 }
        r14 = "";	 Catch:{ Exception -> 0x0186 }
        r13.<init>(r11, r14);	 Catch:{ Exception -> 0x0186 }
        r13.e = r6;	 Catch:{ Exception -> 0x0186 }
        r11 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x0186 }
        r12.a(r13, r11);	 Catch:{ Exception -> 0x0186 }
        goto L_0x009d;
    L_0x00be:
        r10 = "page";
        r11 = "";
        r14 = r15.optString(r10, r11);
        r10 = r8.getApplicationContext();
        r12 = r27.getAppPackageName();
        r13 = 366; // 0x16e float:5.13E-43 double:1.81E-321;
        r11 = "fb_act";
        r6 = 0;
        r16 = r15.optInt(r11, r6);
        r11 = "version";
        r17 = r15.optInt(r11, r6);
        r11 = r14;
        r6 = r14;
        r14 = r16;
        r23 = r5;
        r0 = r15;
        r5 = r19;
        r15 = r17;
        r9 = r9.sendAPOInfo(r10, r11, r12, r13, r14, r15);
        if (r9 == 0) goto L_0x0100;
    L_0x00ee:
        r0 = r28.booleanValue();
        if (r0 == 0) goto L_0x00fc;
    L_0x00f4:
        r0 = new com.baidu.mobads.command.b.a;
        r0.<init>(r8, r2, r5, r6);
        r0.a();
    L_0x00fc:
        r0 = r25;
        goto L_0x0177;
    L_0x0100:
        r5 = "fb_act";
        r9 = 0;
        r5 = r0.optInt(r5, r9);
        r9 = new org.json.JSONObject;
        r9.<init>();
        r10 = new com.baidu.mobads.vo.XAdInstanceInfo;
        r10.<init>(r9);
        r9 = r7.getActTypeLandingPage();
        if (r5 != r9) goto L_0x013a;
    L_0x0117:
        r5 = r7.getActTypeLandingPage();
        r10.setActionType(r5);
        r5 = "fallback";
        r7 = "";
        r0 = r0.optString(r5, r7);
        r10.setClickThroughUrl(r0);
        r0 = r27.getTitle();
        r10.setTitle(r0);
        r0 = 1;
        r10.setInapp(r0);
        r0 = r25;
        r0.onAdClicked(r1, r10, r3, r4);
        goto L_0x0177;
    L_0x013a:
        r9 = r0;
        r0 = r25;
        r11 = r7.getActTypeDownload();
        if (r5 != r11) goto L_0x0177;
    L_0x0143:
        r5 = r7.getActTypeDownload();
        r10.setActionType(r5);
        r5 = "fallback";
        r7 = "";
        r5 = r9.optString(r5, r7);
        r10.setClickThroughUrl(r5);
        r5 = r27.getTitle();
        r10.setTitle(r5);
        r5 = r27.getQueryKey();
        r10.setQueryKey(r5);
        r5 = 1;
        r10.setInapp(r5);
        r10.setAPOOpen(r5);
        r10.setPage(r6);
        r5 = r27.getAppPackageName();
        r10.setAppPackageName(r5);
        r0.onAdClicked(r1, r10, r3, r4);
    L_0x0177:
        r1 = r8.getApplicationContext();
        r2 = r27.getAppPackageName();
        r0.a(r1, r6, r2);
        r10 = r23;
        goto L_0x02d5;
    L_0x0186:
        return;
    L_0x0187:
        r5 = r19;
        r9 = 0;
        r6 = r7.getActTypeDownload();
        if (r12 != r6) goto L_0x01e2;
    L_0x0190:
        r1 = r0.a(r4, r8, r5, r2);
        if (r1 != 0) goto L_0x020e;
    L_0x0196:
        r1 = java.lang.Boolean.valueOf(r9);
        r3 = r28.booleanValue();
        if (r3 == 0) goto L_0x01df;
    L_0x01a0:
        r7 = r8.getApplicationContext();
        r3 = 525; // 0x20d float:7.36E-43 double:2.594E-321;
        r9 = "click";
        r4 = r8.getProdInfo();
        r10 = r4.getProdType();
        r11 = r27.getAppPackageName();
        r4 = r8.getApplicationContext();
        r6 = r21;
        r12 = r6.getAppId(r4);
        r4 = r8.getProdInfo();
        r13 = r4.getAdPlacementId();
        r4 = r22;
        r14 = r4.getPhoneOSBrand();
        r15 = android.os.Build.MODEL;
        r16 = android.os.Build.VERSION.RELEASE;
        r17 = android.os.Build.VERSION.SDK_INT;
        r4 = r8;
        r8 = r3;
        r6.sendDownloadAdLog(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        r3 = new com.baidu.mobads.command.a.a;
        r3.<init>(r4, r2, r5);
        r3.a();
    L_0x01df:
        r10 = r1;
        goto L_0x02d5;
    L_0x01e2:
        r6 = r21;
        r10 = r7.getActTypeLandingPage();
        if (r12 == r10) goto L_0x0283;
    L_0x01ea:
        r10 = r7.getActTypeOpenMap();
        if (r12 != r10) goto L_0x01f2;
    L_0x01f0:
        goto L_0x0283;
    L_0x01f2:
        r1 = r7.getActTypeMakeCall();
        if (r12 == r1) goto L_0x0212;
    L_0x01f8:
        r1 = r7.getActTypeSendSMS();
        if (r12 == r1) goto L_0x0212;
    L_0x01fe:
        r1 = r7.getActTypeSendMail();
        if (r12 != r1) goto L_0x0205;
    L_0x0204:
        goto L_0x0212;
    L_0x0205:
        r1 = r7.getActTypeNothing2Do();
        if (r12 == r1) goto L_0x020e;
    L_0x020b:
        r7.getActTypeRichMedia();
    L_0x020e:
        r10 = r18;
        goto L_0x02d5;
    L_0x0212:
        r1 = 1;
        r10 = java.lang.Boolean.valueOf(r1);
        r1 = r28.booleanValue();
        if (r1 == 0) goto L_0x0225;
    L_0x021d:
        r1 = new com.baidu.mobads.command.b.a;
        r1.<init>(r8, r2, r5, r11);
        r1.a();
    L_0x0225:
        r1 = r7.getActTypeMakeCall();
        if (r12 != r1) goto L_0x02d5;
    L_0x022b:
        r1 = r8.getApplicationContext();
        r1 = r1.getPackageManager();
        r2 = new android.content.Intent;
        r3 = "android.intent.action.VIEW";
        r2.<init>(r3);
        r3 = android.net.Uri.parse(r11);
        r2.setData(r3);
        r3 = 64;
        r1 = r1.queryIntentActivities(r2, r3);
        if (r1 == 0) goto L_0x02d5;
    L_0x0249:
        r2 = r1.size();
        if (r2 <= 0) goto L_0x02d5;
    L_0x024f:
        r2 = 0;
        r3 = r2;
        r2 = r9;
    L_0x0252:
        r4 = r1.size();
        if (r2 >= r4) goto L_0x0278;
    L_0x0258:
        if (r2 <= 0) goto L_0x026b;
    L_0x025a:
        r4 = r1.get(r2);
        r4 = (android.content.pm.ResolveInfo) r4;
        r4 = r4.activityInfo;
        r4 = r4.processName;
        r4 = r3.equals(r4);
        if (r4 != 0) goto L_0x026b;
    L_0x026a:
        goto L_0x0279;
    L_0x026b:
        r3 = r1.get(r2);
        r3 = (android.content.pm.ResolveInfo) r3;
        r3 = r3.activityInfo;
        r3 = r3.processName;
        r2 = r2 + 1;
        goto L_0x0252;
    L_0x0278:
        r9 = 1;
    L_0x0279:
        if (r9 == 0) goto L_0x02d5;
    L_0x027b:
        r1 = r8.getApplicationContext();
        r0.a(r1, r3);
        goto L_0x02d5;
    L_0x0283:
        r9 = r0.b;
        r9 = r9.getProdInfo();
        r9 = r9.getProdType();
        r7 = r7.getProductionTypeSplash();
        if (r9 == r7) goto L_0x0299;
    L_0x0293:
        r7 = 1;
        r10 = java.lang.Boolean.valueOf(r7);
        goto L_0x029b;
    L_0x0299:
        r10 = r18;
    L_0x029b:
        r3 = r28.booleanValue();
        if (r3 == 0) goto L_0x02d5;
    L_0x02a1:
        r3 = r27.isInapp();
        if (r3 == 0) goto L_0x02ca;
    L_0x02a7:
        r1 = r0.a(r4, r8, r5, r2);
        if (r1 != 0) goto L_0x02d5;
    L_0x02ad:
        r1 = new com.baidu.mobads.command.c.a;
        r1.<init>(r8, r2, r5, r11);
        if (r4 == 0) goto L_0x02c6;
    L_0x02b4:
        r2 = "lpShoubaiStyle";
        r2 = r4.containsKey(r2);
        if (r2 == 0) goto L_0x02c6;
    L_0x02bc:
        r2 = "lpShoubaiStyle";
        r2 = r4.get(r2);
        r2 = (java.lang.String) r2;
        r1.f = r2;
    L_0x02c6:
        r1.a();
        goto L_0x02d5;
    L_0x02ca:
        r1 = r26.getAdContainerContext();
        r1 = r1.getApplicationContext();
        r6.browserOutside(r1, r11);
    L_0x02d5:
        r1 = r10.booleanValue();
        if (r1 == 0) goto L_0x02e7;
    L_0x02db:
        r1 = r0.b;
        r2 = new com.baidu.mobads.f.a;
        r3 = "AdClickThru";
        r2.<init>(r3);
        r1.dispatchEvent(r2);
    L_0x02e7:
        r1 = r0.b;
        r2 = new com.baidu.mobads.f.a;
        r3 = "AdUserClick";
        r2.<init>(r3);
        r1.dispatchEvent(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.q.onAdClicked(com.baidu.mobads.interfaces.IXAdContainer, com.baidu.mobads.interfaces.IXAdInstanceInfo, java.lang.Boolean, java.util.HashMap):void");
    }

    public boolean a(HashMap<String, Object> hashMap, IXNonLinearAdSlot iXNonLinearAdSlot, IXAdResource iXAdResource, IXAdInstanceInfo iXAdInstanceInfo) {
        if (hashMap == null || !hashMap.containsKey("lpShoubaiStyle") || !hashMap.get("lpShoubaiStyle").equals("video_and_web")) {
            return null;
        }
        a aVar = new a(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource, iXAdInstanceInfo.getWebUrl());
        aVar.f = (String) hashMap.get("lpShoubaiStyle");
        aVar.g = (String) hashMap.get("lpMurlStyle");
        aVar.a();
        return true;
    }

    public void onAdLoaded(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.b.a(iXAdContainer, (HashMap) hashMap);
        } else {
            new Handler(this.a.getMainLooper()).post(new t(this, iXAdContainer, hashMap));
        }
    }

    public void onAdStarted(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.b.b(iXAdContainer, (HashMap) hashMap);
        } else {
            new Handler(this.a.getMainLooper()).post(new u(this, iXAdContainer, hashMap));
        }
    }

    public void onAdImpression(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        a(iXAdInstanceInfo.getImpressionUrls());
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_IMPRESSION));
    }

    public void onAdStoped(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, Boolean bool2, HashMap<String, Object> hashMap) {
        if (iXAdInstanceInfo != null) {
            Set hashSet = new HashSet();
            hashSet.addAll(iXAdInstanceInfo.getCloseTrackers());
            a(hashSet);
        }
        if (bool2.booleanValue() != null) {
            iXAdContainer = iXAdContainer.getAdContainerContext();
            this.b.a(iXAdContainer.getAdResponseInfo(), iXAdContainer.getAdInstanceInfo());
            return;
        }
        this.b.e(iXAdContainer, hashMap);
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_STOPPED));
    }

    public void onAdError(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
            if (hashMap != null) {
                iXAdContainer = XAdSDKFoundationFacade.getInstance().getAdConstants();
                iXAdInstanceInfo = new StringBuilder();
                iXAdInstanceInfo.append(hashMap.get(iXAdContainer.getInfoKeyErrorCode()));
                iXAdInstanceInfo.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                iXAdInstanceInfo.append(hashMap.get(iXAdContainer.getInfoKeyErrorMessage()));
                iXAdInstanceInfo.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                iXAdInstanceInfo.append(hashMap.get(iXAdContainer.getInfoKeyErrorModule()));
                com.baidu.mobads.c.a.a().a(iXAdInstanceInfo.toString());
            }
            this.e.set(true);
            this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_ERROR, hashMap));
        }
    }

    public void onAdPlaying(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_PLAYING));
    }

    public void onAdPaused(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_PAUSED));
    }

    public void onAdLinearChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdExpandedChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdUserClosed(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_USER_CLOSE));
    }

    public void onAdDurationChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdRemainingTimeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdVolumeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdSizeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdSkippableStateChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdSkipped(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdInteraction(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdUserAcceptInvitation(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdUserMinimize(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdVideoStart(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdVideoFirstQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdVideoMidpoint(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdVideoThirdQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdVideoComplete(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    public void onAdCustomEvent(String str, IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.e.get() == null) {
        }
    }

    private void a(Set<String> set) {
        com.baidu.mobads.openad.d.a aVar = new com.baidu.mobads.openad.d.a();
        for (String cVar : set) {
            c cVar2 = new c(cVar, "");
            cVar2.e = 1;
            aVar.a(cVar2, Boolean.valueOf(true));
        }
    }
}
