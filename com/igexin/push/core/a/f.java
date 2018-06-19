package com.igexin.push.core.a;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.m;
import com.igexin.push.core.a.a.a;
import com.igexin.push.core.a.a.b;
import com.igexin.push.core.a.a.c;
import com.igexin.push.core.a.a.d;
import com.igexin.push.core.a.a.e;
import com.igexin.push.core.a.a.g;
import com.igexin.push.core.a.a.h;
import com.igexin.push.core.a.a.i;
import com.igexin.push.core.a.a.j;
import com.igexin.push.core.a.a.l;
import com.igexin.push.core.b.af;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.n;
import com.igexin.push.d.c.o;
import com.igexin.push.e.k;
import com.igexin.push.extension.stub.IPushExtension;
import com.igexin.push.util.EncryptUtils;
import com.igexin.push.util.q;
import com.igexin.sdk.GTServiceManager;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.entity.UMessage;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class f extends a implements k {
    private static Map<Integer, a> a;
    private static Map<String, a> b;
    private static f c;
    private long d;

    private f() {
        Map hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Integer.valueOf(0), new k());
        a.put(Integer.valueOf(5), new m());
        a.put(Integer.valueOf(37), new q());
        a.put(Integer.valueOf(9), new u());
        a.put(Integer.valueOf(26), new j());
        a.put(Integer.valueOf(28), new e());
        a.put(Integer.valueOf(97), new l());
        hashMap = new HashMap();
        b = hashMap;
        hashMap.put("goto", new g());
        b.put(UMessage.DISPLAY_TYPE_NOTIFICATION, new h());
        b.put("startapp", new com.igexin.push.core.a.a.k());
        b.put("null", new com.igexin.push.core.a.a.f());
        b.put("wakeupsdk", new l());
        b.put("startweb", new j());
        b.put("checkapp", new b());
        b.put("cleanext", new c());
        b.put("enablelog", new e());
        b.put("disablelog", new d());
        b.put("reportext", new i());
    }

    private void C() {
        if (com.igexin.push.core.g.l) {
            com.igexin.push.core.g.l = false;
            com.igexin.b.a.c.a.b("CoreAction|broadcast online state = offline");
            l();
        }
        com.igexin.push.c.a e = com.igexin.push.c.i.a().e();
        com.igexin.push.core.i.a().a(com.igexin.push.core.k.c);
        e.i();
        com.igexin.b.a.c.a.b(B() ? "CoreAction|sdkOn = false or pushOn = false, disconect|user" : "CoreAction|disconnect|network");
        com.igexin.b.a.b.c.b().a(com.igexin.b.a.b.a.a.k.class);
    }

    private void D() {
        com.igexin.push.core.i.a().a(com.igexin.push.core.k.d);
        com.igexin.push.core.g.h = com.igexin.push.util.a.g();
        StringBuilder stringBuilder = new StringBuilder("CoreAction|network changed, available = ");
        stringBuilder.append(com.igexin.push.core.g.h);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        boolean z = false;
        if (com.igexin.push.core.g.l && com.igexin.push.core.g.h) {
            com.igexin.b.a.c.a.b("CoreAction|network changed, online = true, networkAvailable = true");
            if (System.currentTimeMillis() - com.igexin.push.core.g.Q > 5000) {
                com.igexin.b.a.c.a.b("CoreAction|network changed, online = true, networkAvailable = true, send heart beat ....");
                com.igexin.push.core.g.Q = System.currentTimeMillis();
                if (g() == -2) {
                    com.igexin.push.core.g.l = false;
                    l();
                }
            }
        } else {
            com.igexin.push.d.b.a().b();
            com.igexin.b.a.c.a.b("CoreAction|network changed, disconnect +++");
            com.igexin.push.core.f.a().i().f();
            if (com.igexin.push.core.g.h) {
                if (com.igexin.push.c.i.a().e().j()) {
                    z = com.igexin.push.c.i.a().f();
                } else {
                    com.igexin.b.a.c.a.b("CoreAction|network changed, domain = backup or trynormal");
                }
            }
            if (z) {
                com.igexin.b.a.c.a.b("CoreAction|detect result  = true, reconnect will run after detect");
            } else {
                com.igexin.b.a.b.a.a.d.a().a(true);
            }
        }
        if (t()) {
            com.igexin.b.a.c.a.b("CoreAction|network changed check condition status");
            s();
        }
    }

    @TargetApi(12)
    private Intent E() {
        Intent intent = new Intent();
        if (VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        StringBuilder stringBuilder = new StringBuilder("com.igexin.sdk.action.");
        stringBuilder.append(com.igexin.push.core.g.a);
        intent.setAction(stringBuilder.toString());
        return intent;
    }

    private boolean F() {
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
        r13 = this;
        r0 = com.igexin.push.core.g.ai;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0124;
    L_0x0008:
        r0 = com.igexin.push.core.g.n;
        if (r0 == 0) goto L_0x0124;
    L_0x000c:
        r0 = 0;
        r1 = com.igexin.push.core.f.a();	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r2 = r1.k();	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r3 = "message";	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r1 = 1;	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r4 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r5 = "status";	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r8 = 0;	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r4[r8] = r5;	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r5 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r6 = "0";	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r5[r8] = r6;	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r6 = 0;	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r7 = 0;	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        r2 = r2.a(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00ff, all -> 0x00fb }
        if (r2 == 0) goto L_0x00f6;
    L_0x002d:
        r0 = r2.moveToNext();	 Catch:{ Throwable -> 0x00f4 }
        if (r0 == 0) goto L_0x00f6;	 Catch:{ Throwable -> 0x00f4 }
    L_0x0033:
        r0 = "msgextra";	 Catch:{ Throwable -> 0x00f4 }
        r0 = r2.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00f4 }
        r0 = r2.getBlob(r0);	 Catch:{ Throwable -> 0x00f4 }
        r3 = "info";	 Catch:{ Throwable -> 0x00f4 }
        r3 = r2.getColumnIndex(r3);	 Catch:{ Throwable -> 0x00f4 }
        r3 = r2.getBlob(r3);	 Catch:{ Throwable -> 0x00f4 }
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x002d }
        r5 = new java.lang.String;	 Catch:{ JSONException -> 0x002d }
        r3 = com.igexin.b.b.a.c(r3);	 Catch:{ JSONException -> 0x002d }
        r5.<init>(r3);	 Catch:{ JSONException -> 0x002d }
        r4.<init>(r5);	 Catch:{ JSONException -> 0x002d }
        r3 = "id";	 Catch:{ JSONException -> 0x002d }
        r3 = r4.getString(r3);	 Catch:{ JSONException -> 0x002d }
        r5 = "appid";	 Catch:{ JSONException -> 0x002d }
        r5 = r4.getString(r5);	 Catch:{ JSONException -> 0x002d }
        r6 = "messageid";	 Catch:{ JSONException -> 0x002d }
        r6 = r4.getString(r6);	 Catch:{ JSONException -> 0x002d }
        r7 = "taskid";	 Catch:{ JSONException -> 0x002d }
        r7 = r4.getString(r7);	 Catch:{ JSONException -> 0x002d }
        r9 = "appkey";	 Catch:{ JSONException -> 0x002d }
        r9 = r4.getString(r9);	 Catch:{ JSONException -> 0x002d }
        r10 = "action_chains";	 Catch:{ JSONException -> 0x002d }
        r10 = r4.getJSONArray(r10);	 Catch:{ JSONException -> 0x002d }
        r11 = a();	 Catch:{ JSONException -> 0x002d }
        r11 = r11.f(r7, r6);	 Catch:{ JSONException -> 0x002d }
        r12 = new com.igexin.push.core.bean.PushTaskBean;	 Catch:{ JSONException -> 0x002d }
        r12.<init>();	 Catch:{ JSONException -> 0x002d }
        r12.setAppid(r5);	 Catch:{ JSONException -> 0x002d }
        r12.setMessageId(r6);	 Catch:{ JSONException -> 0x002d }
        r12.setTaskId(r7);	 Catch:{ JSONException -> 0x002d }
        r12.setId(r3);	 Catch:{ JSONException -> 0x002d }
        r12.setAppKey(r9);	 Catch:{ JSONException -> 0x002d }
        r12.setCurrentActionid(r1);	 Catch:{ JSONException -> 0x002d }
        r3 = "status";	 Catch:{ JSONException -> 0x002d }
        r3 = r2.getColumnIndex(r3);	 Catch:{ JSONException -> 0x002d }
        r3 = r2.getInt(r3);	 Catch:{ JSONException -> 0x002d }
        r12.setStatus(r3);	 Catch:{ JSONException -> 0x002d }
        if (r0 == 0) goto L_0x00aa;	 Catch:{ JSONException -> 0x002d }
    L_0x00a7:
        r12.setMsgExtra(r0);	 Catch:{ JSONException -> 0x002d }
    L_0x00aa:
        r0 = "cdnType";	 Catch:{ JSONException -> 0x002d }
        r0 = r4.has(r0);	 Catch:{ JSONException -> 0x002d }
        if (r0 == 0) goto L_0x00bb;	 Catch:{ JSONException -> 0x002d }
    L_0x00b2:
        r0 = "cdnType";	 Catch:{ JSONException -> 0x002d }
        r0 = r4.getBoolean(r0);	 Catch:{ JSONException -> 0x002d }
        r12.setCDNType(r0);	 Catch:{ JSONException -> 0x002d }
    L_0x00bb:
        r0 = "condition";	 Catch:{ JSONException -> 0x002d }
        r0 = r4.has(r0);	 Catch:{ JSONException -> 0x002d }
        if (r0 == 0) goto L_0x00c6;	 Catch:{ JSONException -> 0x002d }
    L_0x00c3:
        r13.b(r4, r12);	 Catch:{ JSONException -> 0x002d }
    L_0x00c6:
        if (r10 == 0) goto L_0x00ed;	 Catch:{ JSONException -> 0x002d }
    L_0x00c8:
        r0 = r10.length();	 Catch:{ JSONException -> 0x002d }
        if (r0 <= 0) goto L_0x00ed;	 Catch:{ JSONException -> 0x002d }
    L_0x00ce:
        r0 = a();	 Catch:{ JSONException -> 0x002d }
        r0 = r0.a(r4, r12);	 Catch:{ JSONException -> 0x002d }
        if (r0 != 0) goto L_0x00ed;	 Catch:{ JSONException -> 0x002d }
    L_0x00d8:
        r0 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x002d }
        r3 = "CoreAction|load task from db parseActionChains result = false ####### ";	 Catch:{ JSONException -> 0x002d }
        r0.<init>(r3);	 Catch:{ JSONException -> 0x002d }
        r3 = r4.toString();	 Catch:{ JSONException -> 0x002d }
        r0.append(r3);	 Catch:{ JSONException -> 0x002d }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x002d }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ JSONException -> 0x002d }
    L_0x00ed:
        r0 = com.igexin.push.core.g.ai;	 Catch:{ JSONException -> 0x002d }
        r0.put(r11, r12);	 Catch:{ JSONException -> 0x002d }
        goto L_0x002d;
    L_0x00f4:
        r0 = move-exception;
        goto L_0x0102;
    L_0x00f6:
        com.igexin.push.core.g.n = r8;	 Catch:{ Throwable -> 0x00f4 }
        if (r2 == 0) goto L_0x0124;
    L_0x00fa:
        goto L_0x0119;
    L_0x00fb:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x011e;
    L_0x00ff:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0102:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x011d }
        r3 = "CoreAction|checkPushMessageMapValue error:";	 Catch:{ all -> 0x011d }
        r1.<init>(r3);	 Catch:{ all -> 0x011d }
        r0 = r0.toString();	 Catch:{ all -> 0x011d }
        r1.append(r0);	 Catch:{ all -> 0x011d }
        r0 = r1.toString();	 Catch:{ all -> 0x011d }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ all -> 0x011d }
        if (r2 == 0) goto L_0x0124;
    L_0x0119:
        r2.close();
        goto L_0x0124;
    L_0x011d:
        r0 = move-exception;
    L_0x011e:
        if (r2 == 0) goto L_0x0123;
    L_0x0120:
        r2.close();
    L_0x0123:
        throw r0;
    L_0x0124:
        r0 = com.igexin.push.core.g.ai;
        r0 = r0.isEmpty();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.F():boolean");
    }

    public static f a() {
        if (c == null) {
            c = new f();
        }
        return c;
    }

    private void a(int i, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(i));
        com.igexin.push.core.f.a().k().a("message", contentValues, new String[]{"taskid"}, new String[]{str});
    }

    private void a(com.igexin.push.d.c.c cVar, PushTaskBean pushTaskBean, String str, String str2) {
        cVar.a(new com.igexin.push.f.b.b(pushTaskBean, str, q.a()));
        com.igexin.push.core.g.al.put(str2, cVar);
    }

    private void a(String str, String str2, String str3, byte[] bArr) {
        Intent intent = new Intent();
        if (VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        StringBuilder stringBuilder = new StringBuilder("com.igexin.sdk.action.");
        stringBuilder.append(str3);
        intent.setAction(stringBuilder.toString());
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10001);
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("appid", str3);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append(Constants.COLON_SEPARATOR);
        stringBuilder2.append(str);
        bundle.putString("payloadid", stringBuilder2.toString());
        bundle.putString("packagename", com.igexin.push.core.g.e);
        bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, bArr);
        intent.putExtras(bundle);
        com.igexin.push.core.g.f.sendBroadcast(intent);
    }

    private void a(java.util.List<com.igexin.push.core.bean.n> r9) {
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
        r0 = new com.igexin.push.core.a.h;
        r0.<init>(r8);
        r1 = com.igexin.push.core.g.f;
        r1 = r1.getPackageManager();
        r2 = 0;
        r3 = r1.getInstalledPackages(r2);
    L_0x0010:
        r4 = r3.size();
        if (r2 >= r4) goto L_0x004d;
    L_0x0016:
        r4 = r3.get(r2);	 Catch:{ Exception -> 0x004a }
        r4 = (android.content.pm.PackageInfo) r4;	 Catch:{ Exception -> 0x004a }
        r5 = r4.applicationInfo;	 Catch:{ Exception -> 0x004a }
        r6 = r5.flags;	 Catch:{ Exception -> 0x004a }
        r6 = r6 & 1;	 Catch:{ Exception -> 0x004a }
        if (r6 > 0) goto L_0x004a;	 Catch:{ Exception -> 0x004a }
    L_0x0024:
        r6 = new com.igexin.push.core.bean.n;	 Catch:{ Exception -> 0x004a }
        r6.<init>();	 Catch:{ Exception -> 0x004a }
        r7 = r5.loadLabel(r1);	 Catch:{ Exception -> 0x004a }
        r7 = r7.toString();	 Catch:{ Exception -> 0x004a }
        r6.b(r7);	 Catch:{ Exception -> 0x004a }
        r5 = r5.packageName;	 Catch:{ Exception -> 0x004a }
        r6.d(r5);	 Catch:{ Exception -> 0x004a }
        r5 = r4.versionCode;	 Catch:{ Exception -> 0x004a }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x004a }
        r6.c(r5);	 Catch:{ Exception -> 0x004a }
        r4 = r4.versionName;	 Catch:{ Exception -> 0x004a }
        r6.a(r4);	 Catch:{ Exception -> 0x004a }
        r9.add(r6);	 Catch:{ Exception -> 0x004a }
    L_0x004a:
        r2 = r2 + 1;
        goto L_0x0010;
    L_0x004d:
        java.util.Collections.sort(r9, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.a(java.util.List):void");
    }

    public static boolean a(long j) {
        Date date = new Date(j);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(11);
        int i2 = m.a + m.b;
        if (i2 >= 24) {
            i2 -= 24;
        }
        if (m.b == 0) {
            return false;
        }
        if (m.a < i2) {
            return i >= m.a && i < i2;
        } else {
            if (m.a > i2) {
                if (i >= 0 && i < i2) {
                    return true;
                }
                if (i >= m.a && i < 24) {
                    return true;
                }
            }
        }
    }

    private void b(org.json.JSONObject r6, com.igexin.push.core.bean.PushTaskBean r7) {
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
        r0 = "condition";	 Catch:{ Exception -> 0x00a2 }
        r6 = r6.getJSONObject(r0);	 Catch:{ Exception -> 0x00a2 }
        r0 = new java.util.HashMap;	 Catch:{ Exception -> 0x00a2 }
        r0.<init>();	 Catch:{ Exception -> 0x00a2 }
        r1 = "wifi";	 Catch:{ Exception -> 0x00a2 }
        r1 = r6.has(r1);	 Catch:{ Exception -> 0x00a2 }
        if (r1 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x00a2 }
    L_0x0013:
        r1 = "wifi";	 Catch:{ Exception -> 0x00a2 }
        r2 = "wifi";	 Catch:{ Exception -> 0x00a2 }
        r2 = r6.getString(r2);	 Catch:{ Exception -> 0x00a2 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
    L_0x001e:
        r1 = "screenOn";	 Catch:{ Exception -> 0x00a2 }
        r1 = r6.has(r1);	 Catch:{ Exception -> 0x00a2 }
        if (r1 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x00a2 }
    L_0x0026:
        r1 = "screenOn";	 Catch:{ Exception -> 0x00a2 }
        r2 = "screenOn";	 Catch:{ Exception -> 0x00a2 }
        r2 = r6.getString(r2);	 Catch:{ Exception -> 0x00a2 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
    L_0x0031:
        r1 = "ssid";	 Catch:{ Exception -> 0x00a2 }
        r1 = r6.has(r1);	 Catch:{ Exception -> 0x00a2 }
        if (r1 == 0) goto L_0x0057;	 Catch:{ Exception -> 0x00a2 }
    L_0x0039:
        r1 = "ssid";	 Catch:{ Exception -> 0x00a2 }
        r2 = "ssid";	 Catch:{ Exception -> 0x00a2 }
        r2 = r6.getString(r2);	 Catch:{ Exception -> 0x00a2 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
        r1 = "bssid";	 Catch:{ Exception -> 0x00a2 }
        r1 = r6.has(r1);	 Catch:{ Exception -> 0x00a2 }
        if (r1 == 0) goto L_0x0057;	 Catch:{ Exception -> 0x00a2 }
    L_0x004c:
        r1 = "bssid";	 Catch:{ Exception -> 0x00a2 }
        r2 = "bssid";	 Catch:{ Exception -> 0x00a2 }
        r2 = r6.getString(r2);	 Catch:{ Exception -> 0x00a2 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
    L_0x0057:
        r1 = "duration";	 Catch:{ Exception -> 0x00a2 }
        r1 = r6.has(r1);	 Catch:{ Exception -> 0x00a2 }
        if (r1 == 0) goto L_0x008c;	 Catch:{ Exception -> 0x00a2 }
    L_0x005f:
        r1 = "duration";	 Catch:{ Exception -> 0x00a2 }
        r1 = r6.getString(r1);	 Catch:{ Exception -> 0x00a2 }
        r2 = "-";	 Catch:{ Exception -> 0x00a2 }
        r2 = r1.contains(r2);	 Catch:{ Exception -> 0x00a2 }
        if (r2 == 0) goto L_0x008c;	 Catch:{ Exception -> 0x00a2 }
    L_0x006d:
        r2 = "-";	 Catch:{ Exception -> 0x00a2 }
        r2 = r1.indexOf(r2);	 Catch:{ Exception -> 0x00a2 }
        r3 = 0;	 Catch:{ Exception -> 0x00a2 }
        r3 = r1.substring(r3, r2);	 Catch:{ Exception -> 0x00a2 }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x00a2 }
        r4 = r1.length();	 Catch:{ Exception -> 0x00a2 }
        r1 = r1.substring(r2, r4);	 Catch:{ Exception -> 0x00a2 }
        r2 = "startTime";	 Catch:{ Exception -> 0x00a2 }
        r0.put(r2, r3);	 Catch:{ Exception -> 0x00a2 }
        r2 = "endTime";	 Catch:{ Exception -> 0x00a2 }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x00a2 }
    L_0x008c:
        r1 = "netConnected";	 Catch:{ Exception -> 0x00a2 }
        r1 = r6.has(r1);	 Catch:{ Exception -> 0x00a2 }
        if (r1 == 0) goto L_0x009f;	 Catch:{ Exception -> 0x00a2 }
    L_0x0094:
        r1 = "netConnected";	 Catch:{ Exception -> 0x00a2 }
        r2 = "netConnected";	 Catch:{ Exception -> 0x00a2 }
        r6 = r6.getString(r2);	 Catch:{ Exception -> 0x00a2 }
        r0.put(r1, r6);	 Catch:{ Exception -> 0x00a2 }
    L_0x009f:
        r7.setConditionMap(r0);	 Catch:{ Exception -> 0x00a2 }
    L_0x00a2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.b(org.json.JSONObject, com.igexin.push.core.bean.PushTaskBean):void");
    }

    private void d(String str) {
        if (str != null && str.startsWith("package:")) {
            str = str.substring(8);
            if (com.igexin.push.core.b.g.a().d().containsKey(str)) {
                com.igexin.push.core.b.g.a().d().remove(str);
            }
        }
    }

    private void e(java.lang.String r7) {
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
        r6 = this;
        r0 = android.text.TextUtils.isEmpty(r7);
        if (r0 != 0) goto L_0x0045;
    L_0x0006:
        r0 = "package:";
        r0 = r7.startsWith(r0);
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = 8;
        r7 = r7.substring(r0);	 Catch:{ Throwable -> 0x0045 }
        r0 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x0045 }
        r0 = r0.getPackageManager();	 Catch:{ Throwable -> 0x0045 }
        r1 = 4;	 Catch:{ Throwable -> 0x0045 }
        r0 = r0.getPackageInfo(r7, r1);	 Catch:{ Throwable -> 0x0045 }
        if (r0 == 0) goto L_0x0045;	 Catch:{ Throwable -> 0x0045 }
    L_0x0022:
        r1 = r0.services;	 Catch:{ Throwable -> 0x0045 }
        if (r1 == 0) goto L_0x0045;	 Catch:{ Throwable -> 0x0045 }
    L_0x0026:
        r1 = r0.services;	 Catch:{ Throwable -> 0x0045 }
        r2 = r1.length;	 Catch:{ Throwable -> 0x0045 }
        r3 = 0;	 Catch:{ Throwable -> 0x0045 }
    L_0x002a:
        if (r3 >= r2) goto L_0x0045;	 Catch:{ Throwable -> 0x0045 }
    L_0x002c:
        r4 = r1[r3];	 Catch:{ Throwable -> 0x0045 }
        r5 = com.igexin.push.util.a.a(r4, r0);	 Catch:{ Throwable -> 0x0045 }
        if (r5 == 0) goto L_0x0042;	 Catch:{ Throwable -> 0x0045 }
    L_0x0034:
        r0 = com.igexin.push.core.b.g.a();	 Catch:{ Throwable -> 0x0045 }
        r0 = r0.d();	 Catch:{ Throwable -> 0x0045 }
        r1 = r4.name;	 Catch:{ Throwable -> 0x0045 }
        r0.put(r7, r1);	 Catch:{ Throwable -> 0x0045 }
        return;
    L_0x0042:
        r3 = r3 + 1;
        goto L_0x002a;
    L_0x0045:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.e(java.lang.String):void");
    }

    private void f(Intent intent) {
        String stringExtra = intent.getStringExtra("taskid");
        String stringExtra2 = intent.getStringExtra("messageid");
        String stringExtra3 = intent.getStringExtra("actionid");
        String stringExtra4 = intent.getStringExtra("accesstoken");
        int intExtra = intent.getIntExtra("notifID", 0);
        NotificationManager notificationManager = (NotificationManager) com.igexin.push.core.g.f.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        if (intExtra == 0) {
            if (com.igexin.push.core.g.aj.get(stringExtra) != null) {
                intExtra = ((Integer) com.igexin.push.core.g.aj.get(stringExtra)).intValue();
            }
            if (stringExtra4.equals(com.igexin.push.core.g.au)) {
                b(stringExtra, stringExtra2, stringExtra3);
            }
        }
        notificationManager.cancel(intExtra);
        if (stringExtra4.equals(com.igexin.push.core.g.au)) {
            b(stringExtra, stringExtra2, stringExtra3);
        }
    }

    private void f(java.lang.String r4) {
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
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r2 = com.igexin.push.core.g.Z;	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r2 = r1.exists();	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        if (r2 != 0) goto L_0x002f;	 Catch:{ Exception -> 0x0051, all -> 0x004a }
    L_0x000e:
        r2 = r1.createNewFile();	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        if (r2 != 0) goto L_0x002f;	 Catch:{ Exception -> 0x0051, all -> 0x004a }
    L_0x0014:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r2 = "create file ";	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r4.append(r1);	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r1 = " failed######";	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r4.append(r1);	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        com.igexin.b.a.c.a.b(r4);	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        return;	 Catch:{ Exception -> 0x0051, all -> 0x004a }
    L_0x002f:
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r2 = com.igexin.push.core.g.Z;	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0051, all -> 0x004a }
        r4 = com.igexin.b.b.a.a(r4);	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r4 = r4.getBytes();	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r1.write(r4);	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r1.close();	 Catch:{ Exception -> 0x0044 }
    L_0x0044:
        return;
    L_0x0045:
        r4 = move-exception;
        r0 = r1;
        goto L_0x004b;
    L_0x0048:
        r0 = r1;
        goto L_0x0051;
    L_0x004a:
        r4 = move-exception;
    L_0x004b:
        if (r0 == 0) goto L_0x0050;
    L_0x004d:
        r0.close();	 Catch:{ Exception -> 0x0050 }
    L_0x0050:
        throw r4;
    L_0x0051:
        if (r0 == 0) goto L_0x0056;
    L_0x0053:
        r0.close();	 Catch:{ Exception -> 0x0056 }
    L_0x0056:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.f(java.lang.String):void");
    }

    private void f(boolean z) {
        com.igexin.push.d.a.b.b = -1;
        if (!EncryptUtils.isLoadSuccess()) {
            com.igexin.b.a.c.a.b("CoreAction|so error ++++++++");
        } else if (com.igexin.push.core.g.aB) {
            com.igexin.push.core.f.a().g().c(z);
        } else {
            com.igexin.b.a.c.a.b("CoreAction|autoReconnect CoreRuntimeInfo.initSuccess = false");
        }
    }

    private void g(Intent intent) {
        Throwable th;
        StringBuilder stringBuilder;
        String stringExtra = intent.getStringExtra("taskid");
        String stringExtra2 = intent.getStringExtra("messageid");
        String stringExtra3 = intent.getStringExtra("appid");
        String stringExtra4 = intent.getStringExtra("pkgname");
        com.igexin.b.a.c.a.b("CoreAction do processActionExecute");
        ContentValues contentValues = new ContentValues();
        StringBuilder stringBuilder2 = new StringBuilder("EXEC_");
        stringBuilder2.append(stringExtra);
        String stringBuilder3 = stringBuilder2.toString();
        contentValues.put("taskid", stringExtra);
        contentValues.put("appid", stringExtra3);
        contentValues.put("key", stringBuilder3);
        contentValues.put("createtime", Long.valueOf(System.currentTimeMillis()));
        Cursor cursor = null;
        try {
            Cursor a = com.igexin.push.core.f.a().k().a("message", new String[]{"key"}, new String[]{stringBuilder3}, null, null);
            if (a != null) {
                try {
                    if (a.getCount() == 0) {
                        a(contentValues);
                        if (stringExtra4.equals(com.igexin.push.core.g.e)) {
                            if (stringExtra2 != null) {
                                if (stringExtra != null) {
                                    if (com.igexin.push.core.f.a() != null && g(stringExtra, stringExtra2) == com.igexin.push.core.b.a) {
                                        a(stringExtra, stringExtra2, "1");
                                    }
                                }
                            }
                            if (a != null) {
                                a.close();
                            }
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = a;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Throwable th3) {
            th = th3;
            stringBuilder = new StringBuilder("CoreAction|");
            stringBuilder.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void h(String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setPackage(str);
            intent.setAction("com.igexin.sdk.action.service.message");
            if (com.igexin.push.util.a.a(intent, com.igexin.push.core.g.f)) {
                com.igexin.push.core.g.f.startService(intent);
                com.igexin.b.a.c.a.b("CoreAction|startService by action");
                return;
            }
            intent = new Intent();
            intent.setClassName(str, str2);
            com.igexin.push.core.g.f.startService(intent);
            com.igexin.b.a.c.a.b("CoreAction|startService by service name");
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("CoreAction|startService pkgName = ");
            stringBuilder.append(str);
            stringBuilder.append(" srvName = ");
            stringBuilder.append(str2);
            stringBuilder.append(", exception : ");
            stringBuilder.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
        }
    }

    public void A() {
        if (!com.igexin.push.core.g.af) {
            com.igexin.push.core.g.af = com.igexin.b.a.b.c.b().a(com.igexin.push.f.b.c.g(), false, true);
        }
        if (!com.igexin.push.core.g.ag) {
            com.igexin.push.core.g.ag = com.igexin.b.a.b.c.b().a(com.igexin.push.f.b.g.g(), true, true);
        }
        if (!com.igexin.push.core.g.ah) {
            com.igexin.push.core.f.a().c();
        }
    }

    public boolean B() {
        if (com.igexin.push.core.g.i) {
            if (com.igexin.push.core.g.j) {
                return false;
            }
        }
        return true;
    }

    public com.igexin.push.core.bean.g a(JSONObject jSONObject) {
        com.igexin.push.core.bean.g gVar = new com.igexin.push.core.bean.g();
        gVar.a(jSONObject.getString("version"));
        JSONArray jSONArray = jSONObject.getJSONArray("extensions");
        if (jSONArray == null || jSONArray.length() <= 0) {
            gVar.a(new HashMap());
            return gVar;
        }
        Map hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
            com.igexin.push.core.bean.f fVar = new com.igexin.push.core.bean.f();
            fVar.a(jSONObject2.getInt(AgooConstants.MESSAGE_ID));
            fVar.a(jSONObject2.getString("version"));
            fVar.b(jSONObject2.getString(com.alipay.sdk.cons.c.e));
            fVar.c(jSONObject2.getString("cls_name"));
            fVar.d(jSONObject2.getString("url"));
            fVar.e(jSONObject2.getString("checksum"));
            fVar.f(jSONObject2.getString("key"));
            if (jSONObject2.has("isdestroy")) {
                fVar.a(jSONObject2.getBoolean("isdestroy"));
            }
            if (jSONObject2.has("effective")) {
                String string = jSONObject2.getString("effective");
                long j = 0;
                if (string != null && string.length() <= 13) {
                    j = Long.parseLong(string);
                }
                fVar.a(j);
            }
            if (jSONObject2.has("loadTime")) {
                fVar.b(jSONObject2.getLong("loadTime"));
            }
            hashMap.put(Integer.valueOf(fVar.a()), fVar);
        }
        gVar.a(hashMap);
        return gVar;
    }

    public Class a(Context context) {
        return GTServiceManager.getInstance().getUserPushService(context);
    }

    public String a(com.igexin.push.core.bean.g gVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a = gVar.a();
            Map b = gVar.b();
            String str = "[]";
            if (a != null) {
                jSONObject.put("version", a);
            }
            if (b != null && b.size() > 0) {
                a = "[";
                for (Entry value : b.entrySet()) {
                    com.igexin.push.core.bean.f fVar = (com.igexin.push.core.bean.f) value.getValue();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(AgooConstants.MESSAGE_ID, fVar.a());
                    jSONObject2.put("version", fVar.b());
                    jSONObject2.put(com.alipay.sdk.cons.c.e, fVar.c());
                    jSONObject2.put("cls_name", fVar.d());
                    jSONObject2.put("url", fVar.e());
                    jSONObject2.put("checksum", fVar.f());
                    jSONObject2.put("isdestroy", fVar.g());
                    jSONObject2.put("effective", fVar.h());
                    jSONObject2.put("loadTime", fVar.i());
                    jSONObject2.put("key", fVar.j());
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a);
                    stringBuilder.append(jSONObject2.toString());
                    a = stringBuilder.toString();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(a);
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    a = stringBuilder.toString();
                }
                if (a.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    a = a.substring(0, a.length() - 1);
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a);
                stringBuilder2.append("]");
                str = stringBuilder2.toString();
            }
            jSONObject.put("extensions", new JSONArray(str));
            return jSONObject.toString();
        } catch (Exception e) {
            com.igexin.b.a.c.a.b(e.toString());
            return null;
        }
    }

    public java.lang.String a(boolean r12, int r13) {
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
        r11 = this;
        r0 = new java.text.SimpleDateFormat;
        r1 = "yyyy-MM-dd HH:mm:ss";
        r2 = java.util.Locale.getDefault();
        r0.<init>(r1, r2);
        r1 = new java.util.Date;
        r1.<init>();
        r0 = r0.format(r1);
        r1 = -1;
        r2 = 0;
        if (r13 != r1) goto L_0x003f;
    L_0x0018:
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.<init>();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = "|register|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = com.igexin.push.core.g.s;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x0034:
        r12 = r12.toString();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        goto L_0x032d;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x003a:
        r12 = move-exception;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = r12;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = r2;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        goto L_0x031e;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x003f:
        r1 = 1;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        if (r13 != 0) goto L_0x026e;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x0042:
        r13 = 0;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        if (r12 == 0) goto L_0x0067;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x0045:
        r12 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3 = r12.k();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r4 = "bi";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r5 = new java.lang.String[r1];	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = "type";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r5[r13] = r12;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = 2;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r6 = new java.lang.String[r12];	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = "1";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r6[r13] = r12;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = "2";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r6[r1] = r12;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x0060:
        r7 = 0;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r8 = 0;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = r3.a(r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        goto L_0x007e;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x0067:
        r12 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3 = r12.k();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r4 = "bi";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r5 = new java.lang.String[r1];	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = "type";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r5[r13] = r12;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r6 = new java.lang.String[r1];	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = "2";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r6[r13] = r12;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        goto L_0x0060;
    L_0x007e:
        if (r12 == 0) goto L_0x0269;
    L_0x0080:
        r13 = r12.moveToNext();	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        if (r13 == 0) goto L_0x0269;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
    L_0x0086:
        r13 = "start_service_count";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = r12.getColumnIndexOrThrow(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = r12.getInt(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r0 = "login_count";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r0 = r12.getColumnIndexOrThrow(r0);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r0 = r12.getInt(r0);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r1 = "loginerror_nonetwork_count";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r1 = r12.getColumnIndexOrThrow(r1);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r1 = r12.getInt(r1);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r3 = "loginerror_connecterror_count";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r3 = r12.getColumnIndexOrThrow(r3);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r3 = r12.getInt(r3);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r4 = "online_time";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r4 = r12.getColumnIndexOrThrow(r4);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r4 = r12.getInt(r4);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r5 = "network_time";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r5 = r12.getColumnIndexOrThrow(r5);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r5 = r12.getInt(r5);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r6 = "running_time";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r6 = r12.getColumnIndexOrThrow(r6);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r6 = r12.getInt(r6);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r7.<init>();	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8 = "create_time";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8 = r12.getColumnIndexOrThrow(r8);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8 = r12.getString(r8);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r7.append(r8);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8 = " 00:00:00";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r7.append(r8);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        if (r2 != 0) goto L_0x01a6;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
    L_0x00e9:
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.<init>();	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r9 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r9);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r9 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r9);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r9 = "|startservice|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r9);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|login|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r0);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|loginerror-nonetwork|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r1);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|loginerror-connecterror|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r3);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|online|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r4);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|network|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r5);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|running|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r6);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
    L_0x019f:
        r13 = r8.toString();	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r2 = r13;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        goto L_0x0080;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
    L_0x01a6:
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.<init>();	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r2);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r9 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r9);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r9 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r9);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r9 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r9);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r9 = "|startservice|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r9);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|login|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r0);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|loginerror-nonetwork|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r1);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|loginerror-connecterror|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r3);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|online|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r4);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|network|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r5);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "\n";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r7);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = com.igexin.push.core.g.B;	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r13 = "|running|";	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r13);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        r8.append(r6);	 Catch:{ Exception -> 0x0325, all -> 0x0266 }
        goto L_0x019f;
    L_0x0266:
        r13 = move-exception;
        goto L_0x031e;
    L_0x0269:
        r10 = r2;
        r2 = r12;
        r12 = r10;
        goto L_0x032d;
    L_0x026e:
        if (r13 != r1) goto L_0x02d7;
    L_0x0270:
        r12 = com.igexin.push.core.i.a();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = r12.a;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r1 = com.igexin.push.config.m.d;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        if (r1 <= 0) goto L_0x027f;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x027a:
        r12 = com.igexin.push.config.m.d;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = r12 * 1000;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = (long) r12;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x027f:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r1.<init>();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3 = com.igexin.push.config.m.a;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r1.append(r3);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3 = ",";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r1.append(r3);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3 = com.igexin.push.config.m.b;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r1.append(r3);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.<init>();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r0 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r0 = com.igexin.push.core.g.r;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r0 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r0 = com.igexin.push.core.g.a;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r0 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r0 = com.igexin.push.core.g.i;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r0 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r1);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r0 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r12);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r3.append(r12);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12 = r3.toString();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        goto L_0x032d;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x02d7:
        r12 = 4;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        if (r13 != r12) goto L_0x02fd;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x02da:
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.<init>();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = com.igexin.push.core.g.r;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = com.igexin.push.core.g.a;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        goto L_0x0034;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x02fd:
        r12 = 5;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        if (r13 != r12) goto L_0x032c;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
    L_0x0300:
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.<init>();	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r0);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = com.igexin.push.core.g.r;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = "|";	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r13 = com.igexin.push.core.g.a;	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        r12.append(r13);	 Catch:{ Exception -> 0x0324, all -> 0x003a }
        goto L_0x0034;
    L_0x031e:
        if (r12 == 0) goto L_0x0323;
    L_0x0320:
        r12.close();
    L_0x0323:
        throw r13;
    L_0x0324:
        r12 = r2;
    L_0x0325:
        if (r12 == 0) goto L_0x032a;
    L_0x0327:
        r12.close();
    L_0x032a:
        r12 = r2;
        return r12;
    L_0x032c:
        r12 = r2;
    L_0x032d:
        if (r2 == 0) goto L_0x0332;
    L_0x032f:
        r2.close();
    L_0x0332:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.a(boolean, int):java.lang.String");
    }

    public void a(int i) {
        if (com.igexin.push.core.g.f != null) {
            try {
                Class b = b(com.igexin.push.core.g.f);
                if (b != null) {
                    Intent intent = new Intent(com.igexin.push.core.g.f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 10008);
                    bundle.putInt(PushConsts.KEY_SERVICE_PIT, i);
                    intent.putExtras(bundle);
                    com.igexin.push.core.g.f.startService(intent);
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("CoreAction|");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
            Intent E = E();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("action", 10008);
            bundle2.putInt(PushConsts.KEY_SERVICE_PIT, i);
            E.putExtras(bundle2);
            com.igexin.push.core.g.f.sendBroadcast(E);
        }
    }

    public void a(int i, int i2, String str) {
        m.a = i;
        m.b = i2;
        com.igexin.push.config.a.a().b();
        com.igexin.push.a.a.c.c().d();
    }

    public void a(int i, String str) {
        m.d = i;
        com.igexin.push.config.a.a().c();
        if (com.igexin.push.core.g.l) {
            com.igexin.b.a.c.a.b("setHeartbeatInterval heartbeatReq");
            if (System.currentTimeMillis() - com.igexin.push.core.g.Q > 5000) {
                com.igexin.push.core.g.Q = System.currentTimeMillis();
                g();
            }
        }
    }

    public void a(android.content.ContentValues r5) {
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
        r0 = com.igexin.push.core.g.aD;	 Catch:{ Throwable -> 0x0073 }
        r1 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;	 Catch:{ Throwable -> 0x0073 }
        if (r0 >= r1) goto L_0x001d;	 Catch:{ Throwable -> 0x0073 }
    L_0x0006:
        r0 = com.igexin.push.core.f.a();	 Catch:{ Throwable -> 0x0073 }
        r0 = r0.k();	 Catch:{ Throwable -> 0x0073 }
        r1 = "message";	 Catch:{ Throwable -> 0x0073 }
        r5 = r0.a(r1, r5);	 Catch:{ Throwable -> 0x0073 }
        if (r5 == 0) goto L_0x0073;	 Catch:{ Throwable -> 0x0073 }
    L_0x0016:
        r5 = com.igexin.push.core.g.aD;	 Catch:{ Throwable -> 0x0073 }
        r5 = r5 + 1;	 Catch:{ Throwable -> 0x0073 }
        com.igexin.push.core.g.aD = r5;	 Catch:{ Throwable -> 0x0073 }
        return;	 Catch:{ Throwable -> 0x0073 }
    L_0x001d:
        r0 = "id IN (SELECT id from message where status IS NULL or status=1 or status=2 order by id asc limit 500)";	 Catch:{ Throwable -> 0x0073 }
        r1 = com.igexin.push.core.f.a();	 Catch:{ Throwable -> 0x0073 }
        r1 = r1.k();	 Catch:{ Throwable -> 0x0073 }
        r2 = "message";	 Catch:{ Throwable -> 0x0073 }
        r0 = r1.a(r2, r0);	 Catch:{ Throwable -> 0x0073 }
        r1 = com.igexin.push.core.g.aD;	 Catch:{ Throwable -> 0x0073 }
        r1 = r1 - r0;	 Catch:{ Throwable -> 0x0073 }
        com.igexin.push.core.g.aD = r1;	 Catch:{ Throwable -> 0x0073 }
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ Throwable -> 0x0073 }
        if (r0 >= r1) goto L_0x005d;	 Catch:{ Throwable -> 0x0073 }
    L_0x0036:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0073 }
        r3 = "id IN (SELECT id from message where status=0 order by id asc limit ";	 Catch:{ Throwable -> 0x0073 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0073 }
        r1 = r1 - r0;	 Catch:{ Throwable -> 0x0073 }
        r2.append(r1);	 Catch:{ Throwable -> 0x0073 }
        r0 = ")";	 Catch:{ Throwable -> 0x0073 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0073 }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x0073 }
        r1 = com.igexin.push.core.f.a();	 Catch:{ Throwable -> 0x0073 }
        r1 = r1.k();	 Catch:{ Throwable -> 0x0073 }
        r2 = "message";	 Catch:{ Throwable -> 0x0073 }
        r0 = r1.a(r2, r0);	 Catch:{ Throwable -> 0x0073 }
        r1 = com.igexin.push.core.g.aD;	 Catch:{ Throwable -> 0x0073 }
        r1 = r1 - r0;	 Catch:{ Throwable -> 0x0073 }
        com.igexin.push.core.g.aD = r1;	 Catch:{ Throwable -> 0x0073 }
    L_0x005d:
        r0 = com.igexin.push.core.f.a();	 Catch:{ Throwable -> 0x0073 }
        r0 = r0.k();	 Catch:{ Throwable -> 0x0073 }
        r1 = "message";	 Catch:{ Throwable -> 0x0073 }
        r5 = r0.a(r1, r5);	 Catch:{ Throwable -> 0x0073 }
        if (r5 == 0) goto L_0x0073;	 Catch:{ Throwable -> 0x0073 }
    L_0x006d:
        r5 = com.igexin.push.core.g.aD;	 Catch:{ Throwable -> 0x0073 }
        r5 = r5 + 1;	 Catch:{ Throwable -> 0x0073 }
        com.igexin.push.core.g.aD = r5;	 Catch:{ Throwable -> 0x0073 }
    L_0x0073:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.a(android.content.ContentValues):void");
    }

    public void a(Intent intent) {
        com.igexin.b.a.c.a.b("CoreAction|onServiceInitialize ##");
        if (intent != null) {
            com.igexin.push.core.f.a().a(false);
            com.igexin.push.core.g.D = intent.hasExtra("op_app") ? intent.getStringExtra("op_app") : "";
            com.igexin.push.core.g.m = false;
            if (com.igexin.push.core.g.l) {
                k();
                com.igexin.push.core.g.m = true;
            }
            if (GTServiceManager.getInstance().isUserPushServiceSet(com.igexin.push.core.g.f) && com.igexin.push.core.g.ad != null) {
                String name = GTServiceManager.getInstance().getUserPushService(com.igexin.push.core.g.f).getName();
                if (name != null && !name.equals(com.igexin.push.core.a.n)) {
                    byte[] b = com.igexin.b.b.a.b(name.getBytes());
                    if (b != null) {
                        com.igexin.push.util.e.a(b, com.igexin.push.core.g.ad, false);
                    }
                } else if (new File(com.igexin.push.core.g.ad).delete()) {
                    StringBuilder stringBuilder = new StringBuilder("del ");
                    stringBuilder.append(com.igexin.push.core.g.ad);
                    stringBuilder.append(" success ~~~");
                    com.igexin.b.a.c.a.b(stringBuilder.toString());
                }
            }
        }
    }

    public void a(Bundle bundle) {
        String string = bundle.getString("action");
        if (!TextUtils.isEmpty(string)) {
            if (string.equals("setTag")) {
                if (m.j) {
                    a(bundle.getString("tags"), bundle.getString("sn"));
                }
            } else if (string.equals("setSilentTime")) {
                if (m.k) {
                    int i = bundle.getInt("beginHour", 0);
                    int i2 = bundle.getInt(SocializeProtocolConstants.DURATION, 0);
                    a(i, i2, com.igexin.push.core.g.f.getPackageName());
                    AssistPushManager.getInstance().setSilentTime(com.igexin.push.core.g.f, i, i2);
                }
            } else if (string.equals("sendMessage")) {
                com.igexin.b.a.c.a.b("CoreAction onPushManagerMessage recevie action : sendMessage");
                if (m.i) {
                    string = bundle.getString("taskid");
                    byte[] byteArray = bundle.getByteArray("extraData");
                    StringBuilder stringBuilder = new StringBuilder("CoreAction receive broadcast msg data , task id : ");
                    stringBuilder.append(string);
                    stringBuilder.append(" ######@##@@@#");
                    com.igexin.b.a.c.a.b(stringBuilder.toString());
                    a(string, byteArray);
                }
            } else if (string.equals("stopService")) {
                com.igexin.push.core.f.a().a(com.igexin.push.core.g.f.getPackageName());
            } else if (string.equals("setHeartbeatInterval")) {
                if (m.l) {
                    a(bundle.getInt(MsgConstant.KEY_LOCATION_INTERVAL, 0), com.igexin.push.core.g.f.getPackageName());
                }
            } else if (string.equals("setSocketTimeout")) {
                if (m.m) {
                    b(bundle.getInt(com.alipay.sdk.data.a.f, 0), com.igexin.push.core.g.f.getPackageName());
                }
            } else if (string.equals("sendFeedbackMessage")) {
                if (m.r && com.igexin.push.core.g.an <= 200) {
                    string = bundle.getString("taskid");
                    r1 = bundle.getString("messageid");
                    r7 = bundle.getString("actionid");
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(string);
                    stringBuilder2.append(Constants.COLON_SEPARATOR);
                    stringBuilder2.append(r1);
                    stringBuilder2.append(Constants.COLON_SEPARATOR);
                    stringBuilder2.append(r7);
                    String stringBuilder3 = stringBuilder2.toString();
                    if (com.igexin.push.core.g.am.get(stringBuilder3) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setTaskId(string);
                        pushTaskBean.setMessageId(r1);
                        pushTaskBean.setAppid(com.igexin.push.core.g.a);
                        pushTaskBean.setAppKey(com.igexin.push.core.g.b);
                        b(pushTaskBean, r7);
                        com.igexin.push.core.g.an++;
                        com.igexin.push.core.g.am.put(stringBuilder3, Long.valueOf(currentTimeMillis));
                    }
                }
            } else if (string.equals("turnOffPush")) {
                com.igexin.push.core.f.a().b(com.igexin.push.core.g.f.getPackageName());
                AssistPushManager.getInstance().turnOffPush(com.igexin.push.core.g.f);
            } else if (string.equals("bindAlias")) {
                string = bundle.getString("alias");
                r7 = bundle.getString("sn");
                com.igexin.b.a.c.a.b("CoreAction|onPushManagerMessage bindAlias...");
                b(string, r7);
            } else if (string.equals("unbindAlias")) {
                string = bundle.getString("alias");
                r1 = bundle.getString("sn");
                boolean z = bundle.getBoolean("isSeft");
                com.igexin.b.a.c.a.b("CoreAction|onPushManagerMessage unbindAlias...");
                a(string, r1, z);
            }
        }
    }

    public void a(PushTaskBean pushTaskBean) {
        com.igexin.push.d.c.e cVar = new com.igexin.push.d.c.c();
        cVar.a();
        StringBuilder stringBuilder = new StringBuilder("RCV");
        stringBuilder.append(pushTaskBean.getMessageId());
        cVar.c = stringBuilder.toString();
        cVar.d = com.igexin.push.core.g.r;
        cVar.a = (int) System.currentTimeMillis();
        com.igexin.push.e.j g = com.igexin.push.core.f.a().g();
        StringBuilder stringBuilder2 = new StringBuilder("C-");
        stringBuilder2.append(com.igexin.push.core.g.r);
        g.a(stringBuilder2.toString(), cVar);
        StringBuilder stringBuilder3 = new StringBuilder("CoreAction|cdnreceive ");
        stringBuilder3.append(pushTaskBean.getTaskId());
        stringBuilder3.append("|");
        stringBuilder3.append(pushTaskBean.getMessageId());
        com.igexin.b.a.c.a.b(stringBuilder3.toString());
    }

    public void a(PushTaskBean pushTaskBean, String str) {
        StringBuilder stringBuilder = new StringBuilder(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE);
        stringBuilder.append(str);
        a(pushTaskBean, stringBuilder.toString(), ITagManager.SUCCESS);
    }

    public void a(com.igexin.push.core.bean.PushTaskBean r9, java.lang.String r10, java.lang.String r11) {
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
        r5 = java.lang.System.currentTimeMillis();
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "action";	 Catch:{ Exception -> 0x0054 }
        r2 = "pushmessage_feedback";	 Catch:{ Exception -> 0x0054 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0054 }
        r1 = "appid";	 Catch:{ Exception -> 0x0054 }
        r2 = r9.getAppid();	 Catch:{ Exception -> 0x0054 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0054 }
        r1 = "id";	 Catch:{ Exception -> 0x0054 }
        r2 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0054 }
        r1 = "appkey";	 Catch:{ Exception -> 0x0054 }
        r2 = r9.getAppKey();	 Catch:{ Exception -> 0x0054 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0054 }
        r1 = "messageid";	 Catch:{ Exception -> 0x0054 }
        r2 = r9.getMessageId();	 Catch:{ Exception -> 0x0054 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0054 }
        r1 = "taskid";	 Catch:{ Exception -> 0x0054 }
        r2 = r9.getTaskId();	 Catch:{ Exception -> 0x0054 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0054 }
        r1 = "actionid";	 Catch:{ Exception -> 0x0054 }
        r0.put(r1, r10);	 Catch:{ Exception -> 0x0054 }
        r1 = "result";	 Catch:{ Exception -> 0x0054 }
        r0.put(r1, r11);	 Catch:{ Exception -> 0x0054 }
        r11 = "timestamp";	 Catch:{ Exception -> 0x0054 }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0054 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x0054 }
        r0.put(r11, r1);	 Catch:{ Exception -> 0x0054 }
    L_0x0054:
        r3 = r0.toString();
        r11 = new com.igexin.push.d.c.d;
        r11.<init>();
        r11.a();
        r0 = (int) r5;
        r11.a = r0;
        r0 = "17258000";
        r11.d = r0;
        r11.e = r3;
        r0 = com.igexin.push.core.g.r;
        r11.g = r0;
        r0 = com.igexin.push.core.f.a();
        r0 = r0.g();
        if (r0 == 0) goto L_0x0092;
    L_0x0077:
        r0 = com.igexin.push.core.f.a();
        r0 = r0.g();
        r1 = new java.lang.StringBuilder;
        r2 = "C-";
        r1.<init>(r2);
        r2 = com.igexin.push.core.g.r;
        r1.append(r2);
        r1 = r1.toString();
        r0.a(r1, r11);
    L_0x0092:
        r11 = com.igexin.push.core.b.d.a();
        if (r11 == 0) goto L_0x00a3;
    L_0x0098:
        r7 = new com.igexin.push.core.bean.j;
        r4 = 3;
        r0 = r7;
        r1 = r5;
        r0.<init>(r1, r3, r4, r5);
        r11.a(r7);
    L_0x00a3:
        r11 = new java.lang.StringBuilder;
        r0 = "feedback|";
        r11.<init>(r0);
        r0 = r9.getTaskId();
        r11.append(r0);
        r0 = "|";
        r11.append(r0);
        r9 = r9.getMessageId();
        r11.append(r9);
        r9 = "|";
        r11.append(r9);
        r11.append(r10);
        r9 = r11.toString();
        com.igexin.b.a.c.a.b(r9);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.a(com.igexin.push.core.bean.PushTaskBean, java.lang.String, java.lang.String):void");
    }

    public void a(java.lang.String r4) {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "action";	 Catch:{ JSONException -> 0x0011 }
        r2 = "received";	 Catch:{ JSONException -> 0x0011 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0011 }
        r1 = "id";	 Catch:{ JSONException -> 0x0011 }
        r0.put(r1, r4);	 Catch:{ JSONException -> 0x0011 }
    L_0x0011:
        r4 = r0.toString();
        r0 = new com.igexin.push.d.c.d;
        r0.<init>();
        r0.a();
        r1 = java.lang.System.currentTimeMillis();
        r1 = (int) r1;
        r0.a = r1;
        r1 = "17258000";
        r0.d = r1;
        r0.e = r4;
        r4 = com.igexin.push.core.g.r;
        r0.g = r4;
        r4 = com.igexin.push.core.f.a();
        r4 = r4.g();
        r1 = new java.lang.StringBuilder;
        r2 = "C-";
        r1.<init>(r2);
        r2 = com.igexin.push.core.g.r;
        r1.append(r2);
        r1 = r1.toString();
        r4.a(r1, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.a(java.lang.String):void");
    }

    public void a(String str, com.igexin.push.d.c.a aVar, PushTaskBean pushTaskBean) {
        com.igexin.b.a.b.c.b().a(new com.igexin.push.f.a.a(new com.igexin.push.core.c.b(str, aVar, pushTaskBean)), false, true);
    }

    public void a(java.lang.String r17, java.lang.String r18) {
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
        r16 = this;
        r0 = com.igexin.push.core.g.r;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0082 }
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0082 }
        r0.<init>();	 Catch:{ Exception -> 0x0082 }
        r1 = "action";	 Catch:{ Exception -> 0x0044 }
        r2 = "set_tag";	 Catch:{ Exception -> 0x0044 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0044 }
        r1 = "id";	 Catch:{ Exception -> 0x0044 }
        r2 = java.lang.String.valueOf(r6);	 Catch:{ Exception -> 0x0044 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0044 }
        r1 = "cid";	 Catch:{ Exception -> 0x0044 }
        r2 = com.igexin.push.core.g.r;	 Catch:{ Exception -> 0x0044 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0044 }
        r1 = "appid";	 Catch:{ Exception -> 0x0044 }
        r2 = com.igexin.push.core.g.a;	 Catch:{ Exception -> 0x0044 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0044 }
        r1 = "tags";	 Catch:{ Exception -> 0x0044 }
        r2 = "utf-8";	 Catch:{ Exception -> 0x0044 }
        r3 = r17;	 Catch:{ Exception -> 0x0044 }
        r2 = java.net.URLEncoder.encode(r3, r2);	 Catch:{ Exception -> 0x0044 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0044 }
        r1 = "sn";	 Catch:{ Exception -> 0x0044 }
        r2 = r18;	 Catch:{ Exception -> 0x0044 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0044 }
    L_0x0044:
        r0 = r0.toString();	 Catch:{ Exception -> 0x0082 }
        r8 = com.igexin.push.core.b.d.a();	 Catch:{ Exception -> 0x0082 }
        if (r8 == 0) goto L_0x005a;	 Catch:{ Exception -> 0x0082 }
    L_0x004e:
        r9 = new com.igexin.push.core.bean.j;	 Catch:{ Exception -> 0x0082 }
        r5 = 2;	 Catch:{ Exception -> 0x0082 }
        r1 = r9;	 Catch:{ Exception -> 0x0082 }
        r2 = r6;	 Catch:{ Exception -> 0x0082 }
        r4 = r0;	 Catch:{ Exception -> 0x0082 }
        r1.<init>(r2, r4, r5, r6);	 Catch:{ Exception -> 0x0082 }
        r8.a(r9);	 Catch:{ Exception -> 0x0082 }
    L_0x005a:
        r14 = new com.igexin.push.d.c.d;	 Catch:{ Exception -> 0x0082 }
        r14.<init>();	 Catch:{ Exception -> 0x0082 }
        r14.a();	 Catch:{ Exception -> 0x0082 }
        r1 = "17258000";	 Catch:{ Exception -> 0x0082 }
        r14.d = r1;	 Catch:{ Exception -> 0x0082 }
        r14.e = r0;	 Catch:{ Exception -> 0x0082 }
        r10 = com.igexin.b.a.b.c.b();	 Catch:{ Exception -> 0x0082 }
        r11 = com.igexin.push.config.SDKUrlConfig.getCmAddress();	 Catch:{ Exception -> 0x0082 }
        r12 = 3;	 Catch:{ Exception -> 0x0082 }
        r0 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x0082 }
        r13 = r0.f();	 Catch:{ Exception -> 0x0082 }
        r15 = 0;	 Catch:{ Exception -> 0x0082 }
        r10.a(r11, r12, r13, r14, r15);	 Catch:{ Exception -> 0x0082 }
        r0 = "settag";	 Catch:{ Exception -> 0x0082 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.a(java.lang.String, java.lang.String):void");
    }

    @TargetApi(12)
    public void a(String str, String str2, String str3, String str4) {
        if (com.igexin.push.core.g.f != null) {
            com.igexin.b.a.c.a.b("startapp|broadcastPayload");
            byte[] bArr = null;
            if (str4 != null) {
                bArr = str4.getBytes();
            } else {
                PushTaskBean pushTaskBean = (PushTaskBean) com.igexin.push.core.g.ai.get(f(str, str2));
                if (pushTaskBean != null) {
                    bArr = pushTaskBean.getMsgExtra();
                }
            }
            if (bArr != null) {
                StringBuilder stringBuilder = new StringBuilder("startapp|broadcast|payload = ");
                stringBuilder.append(new String(bArr));
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                try {
                    Class b = b(com.igexin.push.core.g.f);
                    if (!(b == null || com.igexin.push.core.g.a == null || !com.igexin.push.core.g.a.equals(str3))) {
                        Intent intent = new Intent(com.igexin.push.core.g.f, b);
                        Bundle bundle = new Bundle();
                        bundle.putInt("action", 10001);
                        String str5 = PushConsts.KEY_MESSAGE_DATA;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str2);
                        stringBuilder2.append(Constants.COLON_SEPARATOR);
                        stringBuilder2.append(str);
                        bundle.putSerializable(str5, new GTTransmitMessage(str, str2, stringBuilder2.toString(), bArr));
                        intent.putExtras(bundle);
                        com.igexin.push.core.g.f.startService(intent);
                    }
                } catch (Throwable th) {
                    StringBuilder stringBuilder3 = new StringBuilder("CoreAction|");
                    stringBuilder3.append(th.toString());
                    com.igexin.b.a.c.a.b(stringBuilder3.toString());
                }
                a(str, str2, str3, bArr);
                return;
            }
            com.igexin.b.a.c.a.b("startapp|broadcast|payload is empty!");
        }
    }

    public void a(String str, String str2, String str3, String str4, long j) {
        Throwable th;
        Throwable th2;
        StringBuilder stringBuilder;
        Intent E;
        f fVar;
        Bundle bundle;
        String str5 = str;
        if (com.igexin.push.core.g.f != null) {
            try {
                try {
                    Class b = b(com.igexin.push.core.g.f);
                    if (!(b == null || com.igexin.push.core.g.a == null || !com.igexin.push.core.g.a.equals(str5))) {
                        Intent intent = new Intent(com.igexin.push.core.g.f, b);
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("action", 10010);
                        bundle2.putSerializable(PushConsts.KEY_CMD_MSG, new FeedbackCmdMessage(str2, str3, str4, j, 10006));
                        intent.putExtras(bundle2);
                        com.igexin.push.core.g.f.startService(intent);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    stringBuilder = new StringBuilder("CoreAction|");
                    stringBuilder.append(th2.toString());
                    com.igexin.b.a.c.a.b(stringBuilder.toString());
                    E = fVar.E();
                    bundle = new Bundle();
                    bundle.putInt("action", 10006);
                    bundle.putString("appid", str5);
                    bundle.putString("taskid", str2);
                    bundle.putString("actionid", str3);
                    bundle.putString("result", str4);
                    bundle.putLong("timestamp", j);
                    E.putExtras(bundle);
                    com.igexin.push.core.g.f.sendBroadcast(E);
                }
            } catch (Throwable th4) {
                th = th4;
                fVar = this;
                th2 = th;
                stringBuilder = new StringBuilder("CoreAction|");
                stringBuilder.append(th2.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                E = fVar.E();
                bundle = new Bundle();
                bundle.putInt("action", 10006);
                bundle.putString("appid", str5);
                bundle.putString("taskid", str2);
                bundle.putString("actionid", str3);
                bundle.putString("result", str4);
                bundle.putLong("timestamp", j);
                E.putExtras(bundle);
                com.igexin.push.core.g.f.sendBroadcast(E);
            }
            E = fVar.E();
            bundle = new Bundle();
            bundle.putInt("action", 10006);
            bundle.putString("appid", str5);
            bundle.putString("taskid", str2);
            bundle.putString("actionid", str3);
            bundle.putString("result", str4);
            bundle.putLong("timestamp", j);
            E.putExtras(bundle);
            com.igexin.push.core.g.f.sendBroadcast(E);
        }
    }

    public void a(String str, String str2, boolean z) {
        if (!z || !TextUtils.isEmpty(com.igexin.push.core.g.r)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - com.igexin.push.core.g.S > 5000) {
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
                if (!format.equals(com.igexin.push.core.g.R)) {
                    com.igexin.push.core.b.g.a().f(format);
                    com.igexin.push.core.b.g.a().a(0);
                }
                if (com.igexin.push.core.g.T < 100) {
                    com.igexin.b.a.c.a.b("start unbindAlias ###");
                    com.igexin.push.core.g.S = currentTimeMillis;
                    com.igexin.push.core.b.g.a().a(com.igexin.push.core.g.T + 1);
                    a(str, str2, true, z);
                    return;
                }
                com.igexin.b.a.c.a.b("CoreAction|unbindAlias times exceed");
                return;
            }
            com.igexin.b.a.c.a.b("CoreAction|unbindAlias frequently called");
        }
    }

    public void a(java.lang.String r18, java.lang.String r19, boolean r20, boolean r21) {
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
        r17 = this;
        r1 = com.igexin.push.core.g.r;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00a5 }
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00a5 }
        r1.<init>();	 Catch:{ Exception -> 0x00a5 }
        if (r20 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x00a5 }
    L_0x0014:
        r2 = "unbind_alias";	 Catch:{ Exception -> 0x00a5 }
        goto L_0x0019;	 Catch:{ Exception -> 0x00a5 }
    L_0x0017:
        r2 = "bind_alias";	 Catch:{ Exception -> 0x00a5 }
    L_0x0019:
        r9 = r2;
        if (r20 == 0) goto L_0x0020;
    L_0x001c:
        r2 = 8;
    L_0x001e:
        r6 = r2;
        goto L_0x0022;
    L_0x0020:
        r2 = 7;
        goto L_0x001e;
    L_0x0022:
        r2 = "action";	 Catch:{ Exception -> 0x0055 }
        r1.put(r2, r9);	 Catch:{ Exception -> 0x0055 }
        r2 = "id";	 Catch:{ Exception -> 0x0055 }
        r3 = java.lang.String.valueOf(r7);	 Catch:{ Exception -> 0x0055 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x0055 }
        r2 = "cid";	 Catch:{ Exception -> 0x0055 }
        r3 = com.igexin.push.core.g.r;	 Catch:{ Exception -> 0x0055 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x0055 }
        r2 = "appid";	 Catch:{ Exception -> 0x0055 }
        r3 = com.igexin.push.core.g.a;	 Catch:{ Exception -> 0x0055 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x0055 }
        r2 = "alias";	 Catch:{ Exception -> 0x0055 }
        r3 = r18;	 Catch:{ Exception -> 0x0055 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x0055 }
        r2 = "sn";	 Catch:{ Exception -> 0x0055 }
        r3 = r19;	 Catch:{ Exception -> 0x0055 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x0055 }
        if (r20 == 0) goto L_0x0055;	 Catch:{ Exception -> 0x0055 }
    L_0x004e:
        r0 = "is_self";	 Catch:{ Exception -> 0x0055 }
        r2 = r21;	 Catch:{ Exception -> 0x0055 }
        r1.put(r0, r2);	 Catch:{ Exception -> 0x0055 }
    L_0x0055:
        r0 = r1.toString();	 Catch:{ Exception -> 0x00a5 }
        r1 = com.igexin.push.core.b.d.a();	 Catch:{ Exception -> 0x00a5 }
        if (r1 == 0) goto L_0x006a;	 Catch:{ Exception -> 0x00a5 }
    L_0x005f:
        r10 = new com.igexin.push.core.bean.j;	 Catch:{ Exception -> 0x00a5 }
        r2 = r10;	 Catch:{ Exception -> 0x00a5 }
        r3 = r7;	 Catch:{ Exception -> 0x00a5 }
        r5 = r0;	 Catch:{ Exception -> 0x00a5 }
        r2.<init>(r3, r5, r6, r7);	 Catch:{ Exception -> 0x00a5 }
        r1.a(r10);	 Catch:{ Exception -> 0x00a5 }
    L_0x006a:
        r15 = new com.igexin.push.d.c.d;	 Catch:{ Exception -> 0x00a5 }
        r15.<init>();	 Catch:{ Exception -> 0x00a5 }
        r15.a();	 Catch:{ Exception -> 0x00a5 }
        r1 = "17258000";	 Catch:{ Exception -> 0x00a5 }
        r15.d = r1;	 Catch:{ Exception -> 0x00a5 }
        r15.e = r0;	 Catch:{ Exception -> 0x00a5 }
        r11 = com.igexin.b.a.b.c.b();	 Catch:{ Exception -> 0x00a5 }
        r12 = com.igexin.push.config.SDKUrlConfig.getCmAddress();	 Catch:{ Exception -> 0x00a5 }
        r13 = 3;	 Catch:{ Exception -> 0x00a5 }
        r1 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x00a5 }
        r14 = r1.f();	 Catch:{ Exception -> 0x00a5 }
        r16 = 0;	 Catch:{ Exception -> 0x00a5 }
        r11.a(r12, r13, r14, r15, r16);	 Catch:{ Exception -> 0x00a5 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a5 }
        r1.<init>();	 Catch:{ Exception -> 0x00a5 }
        r1.append(r9);	 Catch:{ Exception -> 0x00a5 }
        r2 = " = ";	 Catch:{ Exception -> 0x00a5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00a5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00a5 }
        r0 = r1.toString();	 Catch:{ Exception -> 0x00a5 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ Exception -> 0x00a5 }
    L_0x00a5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.a(java.lang.String, java.lang.String, boolean, boolean):void");
    }

    public void a(String str, byte[] bArr) {
        if (com.igexin.push.core.g.r != null) {
            JSONObject jSONObject = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject.put("action", "sendmessage");
                jSONObject.put(AgooConstants.MESSAGE_ID, String.valueOf(currentTimeMillis));
                jSONObject.put("cid", com.igexin.push.core.g.r);
                jSONObject.put("appid", com.igexin.push.core.g.a);
                jSONObject.put("taskid", str);
                jSONObject.put("extraData", com.igexin.push.util.h.b(bArr, 0));
                String jSONObject2 = jSONObject.toString();
                com.igexin.push.core.b.d.a().a(new com.igexin.push.core.bean.j(currentTimeMillis, jSONObject2, (byte) 6, currentTimeMillis));
                com.igexin.push.d.c.e dVar = new com.igexin.push.d.c.d();
                dVar.a();
                dVar.a = (int) currentTimeMillis;
                dVar.d = com.igexin.push.core.g.r;
                dVar.e = jSONObject2;
                dVar.f = bArr;
                dVar.g = com.igexin.push.core.g.r;
                com.igexin.push.e.j g = com.igexin.push.core.f.a().g();
                StringBuilder stringBuilder = new StringBuilder("C-");
                stringBuilder.append(com.igexin.push.core.g.r);
                g.a(stringBuilder.toString(), dVar);
                if (str != null && str.startsWith("4T5@S_")) {
                    StringBuilder stringBuilder2 = new StringBuilder("CoreAction sending lbs report message : ");
                    stringBuilder2.append(jSONObject2);
                    com.igexin.b.a.c.a.b(stringBuilder2.toString());
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder3 = new StringBuilder("CoreAction|");
                stringBuilder3.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder3.toString());
            }
        }
    }

    public void a(JSONObject jSONObject, String str) {
        try {
            PushTaskBean pushTaskBean = new PushTaskBean();
            pushTaskBean.parse(jSONObject);
            a(pushTaskBean, str);
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("CoreAction ");
            stringBuilder.append(e.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
        }
    }

    public void a(boolean z) {
    }

    public boolean a(com.igexin.b.a.d.e eVar) {
        return false;
    }

    public boolean a(com.igexin.push.d.c.e eVar) {
        if (eVar == null) {
            return false;
        }
        a aVar = (a) a.get(Integer.valueOf(eVar.i));
        if ((eVar instanceof com.igexin.push.d.c.j) || (eVar instanceof com.igexin.push.d.c.m) || (eVar instanceof o) || (eVar instanceof com.igexin.push.d.c.q) || (eVar instanceof com.igexin.push.d.c.h)) {
            StringBuilder stringBuilder = new StringBuilder("CoreAction|receive : ");
            stringBuilder.append(eVar.getClass().getName());
            stringBuilder.append(" resp ~~~~");
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            com.igexin.b.a.b.a.a.d.a().a(eVar.getClass().getName());
        }
        if ((eVar instanceof com.igexin.push.d.c.m) || (eVar instanceof o) || (eVar instanceof com.igexin.push.d.c.q)) {
            com.igexin.push.core.g.E = 0;
            com.igexin.push.c.i.a().e().b();
        }
        if (aVar != null) {
            aVar.a((Object) eVar);
        }
        com.igexin.push.f.b.c.g().h();
        return true;
    }

    public boolean a(Object obj) {
        com.igexin.push.e.j g = com.igexin.push.core.f.a().g();
        if ((obj instanceof com.igexin.push.d.c.e) && g != null) {
            g.a((com.igexin.push.d.c.e) obj);
            return false;
        } else if (obj instanceof com.igexin.push.d.b.a) {
            com.igexin.b.a.b.a.a.d.a().a(false);
            return false;
        } else if (obj instanceof com.igexin.push.d.b.b) {
            com.igexin.b.a.c.a.b("CoreAction|ReconnectCheckNotifyType ###");
            com.igexin.b.a.b.a.a.d.a().a(((com.igexin.push.d.b.b) obj).a());
            return false;
        } else if (obj instanceof com.igexin.push.d.b.d) {
            C();
            return false;
        } else {
            if (obj instanceof com.igexin.push.d.b.c) {
                com.igexin.b.a.c.a.b("CoreAction|ReconnectNotifyType ###");
                f(((com.igexin.push.d.b.c) obj).a());
            }
            return false;
        }
    }

    public boolean a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", str3);
        Message obtain = Message.obtain();
        obtain.what = com.igexin.push.core.a.g;
        obtain.obj = bundle;
        return com.igexin.push.core.f.a().a(obtain);
    }

    public boolean a(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        com.igexin.b.a.c.a.b("CoreAction------parse pushmessage actionchain json start-------");
        List arrayList = new ArrayList();
        try {
            int i;
            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            for (i = 0; i < jSONArray.length(); i++) {
                String string = ((JSONObject) jSONArray.get(i)).getString("type");
                if (string != null) {
                    boolean z;
                    for (IPushExtension isActionSupported : com.igexin.push.extension.a.a().c()) {
                        if (isActionSupported.isActionSupported(string)) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (z) {
                        continue;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("CoreAction|extension not suport type = ");
                        stringBuilder.append(string);
                        com.igexin.b.a.c.a.b(stringBuilder.toString());
                        if (b.get(string) == null) {
                            return false;
                        }
                    }
                }
            }
            for (i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                String string2 = jSONObject2.getString("type");
                if (string2 != null) {
                    Object obj = null;
                    for (IPushExtension parseAction : com.igexin.push.extension.a.a().c()) {
                        obj = parseAction.parseAction(jSONObject2);
                        if (obj != null) {
                            break;
                        }
                    }
                    if (obj == null) {
                        a aVar = (a) b.get(string2);
                        if (aVar != null) {
                            obj = aVar.a(jSONObject2);
                            if (obj != null) {
                                obj.setSupportExt(false);
                            }
                        }
                    }
                    if (obj == null) {
                        com.igexin.b.a.c.a.b("CoreAction|action chains can't parse, throw whole ++++++");
                        return false;
                    }
                    arrayList.add(obj);
                }
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("CoreAction|");
            stringBuilder2.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
        }
        pushTaskBean.setActionChains(arrayList);
        com.igexin.b.a.c.a.b("CoreAction------parse pushmessage actionchain json end-------");
        return true;
    }

    public boolean a(org.json.JSONObject r20, byte[] r21, boolean r22) {
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
        r19 = this;
        r1 = r19;
        r2 = r20;
        r3 = r21;
        r4 = r22;
        r5 = 1;
        r6 = "action";	 Catch:{ Exception -> 0x0202 }
        r6 = r2.has(r6);	 Catch:{ Exception -> 0x0202 }
        if (r6 == 0) goto L_0x0219;	 Catch:{ Exception -> 0x0202 }
    L_0x0011:
        r6 = "action";	 Catch:{ Exception -> 0x0202 }
        r6 = r2.getString(r6);	 Catch:{ Exception -> 0x0202 }
        r7 = "pushmessage";	 Catch:{ Exception -> 0x0202 }
        r6 = r6.equals(r7);	 Catch:{ Exception -> 0x0202 }
        if (r6 == 0) goto L_0x0219;	 Catch:{ Exception -> 0x0202 }
    L_0x001f:
        r6 = "id";	 Catch:{ Exception -> 0x0202 }
        r6 = r2.getString(r6);	 Catch:{ Exception -> 0x0202 }
        r7 = "appid";	 Catch:{ Exception -> 0x0202 }
        r7 = r2.getString(r7);	 Catch:{ Exception -> 0x0202 }
        r8 = "messageid";	 Catch:{ Exception -> 0x0202 }
        r8 = r2.getString(r8);	 Catch:{ Exception -> 0x0202 }
        r9 = "taskid";	 Catch:{ Exception -> 0x0202 }
        r9 = r2.getString(r9);	 Catch:{ Exception -> 0x0202 }
        r10 = "appkey";	 Catch:{ Exception -> 0x0202 }
        r10 = r2.getString(r10);	 Catch:{ Exception -> 0x0202 }
        r11 = "action_chains";	 Catch:{ Exception -> 0x0202 }
        r11 = r2.getJSONArray(r11);	 Catch:{ Exception -> 0x0202 }
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0202 }
        r13 = "pushmessage|";	 Catch:{ Exception -> 0x0202 }
        r12.<init>(r13);	 Catch:{ Exception -> 0x0202 }
        r12.append(r9);	 Catch:{ Exception -> 0x0202 }
        r13 = "|";	 Catch:{ Exception -> 0x0202 }
        r12.append(r13);	 Catch:{ Exception -> 0x0202 }
        r12.append(r8);	 Catch:{ Exception -> 0x0202 }
        r13 = "|";	 Catch:{ Exception -> 0x0202 }
        r12.append(r13);	 Catch:{ Exception -> 0x0202 }
        r12.append(r7);	 Catch:{ Exception -> 0x0202 }
        r13 = "|";	 Catch:{ Exception -> 0x0202 }
        r12.append(r13);	 Catch:{ Exception -> 0x0202 }
        r12.append(r4);	 Catch:{ Exception -> 0x0202 }
        r12 = r12.toString();	 Catch:{ Exception -> 0x0202 }
        com.igexin.b.a.c.a.b(r12);	 Catch:{ Exception -> 0x0202 }
        if (r7 == 0) goto L_0x01fc;	 Catch:{ Exception -> 0x0202 }
    L_0x006e:
        if (r6 == 0) goto L_0x01fc;	 Catch:{ Exception -> 0x0202 }
    L_0x0070:
        if (r8 == 0) goto L_0x01fc;	 Catch:{ Exception -> 0x0202 }
    L_0x0072:
        if (r9 == 0) goto L_0x01fc;	 Catch:{ Exception -> 0x0202 }
    L_0x0074:
        if (r11 == 0) goto L_0x01fc;	 Catch:{ Exception -> 0x0202 }
    L_0x0076:
        r12 = com.igexin.push.core.g.a;	 Catch:{ Exception -> 0x0202 }
        r12 = r7.equals(r12);	 Catch:{ Exception -> 0x0202 }
        if (r12 == 0) goto L_0x01fc;	 Catch:{ Exception -> 0x0202 }
    L_0x007e:
        r12 = new com.igexin.push.core.bean.PushTaskBean;	 Catch:{ Exception -> 0x0202 }
        r12.<init>();	 Catch:{ Exception -> 0x0202 }
        r12.setAppid(r7);	 Catch:{ Exception -> 0x0202 }
        r12.setMessageId(r8);	 Catch:{ Exception -> 0x0202 }
        r12.setTaskId(r9);	 Catch:{ Exception -> 0x0202 }
        r12.setId(r6);	 Catch:{ Exception -> 0x0202 }
        r12.setAppKey(r10);	 Catch:{ Exception -> 0x0202 }
        r12.setCurrentActionid(r5);	 Catch:{ Exception -> 0x0202 }
        r6 = "cdnType";	 Catch:{ Exception -> 0x0202 }
        r6 = r2.has(r6);	 Catch:{ Exception -> 0x0202 }
        if (r6 == 0) goto L_0x00a6;	 Catch:{ Exception -> 0x0202 }
    L_0x009d:
        r6 = "cdnType";	 Catch:{ Exception -> 0x0202 }
        r6 = r2.getBoolean(r6);	 Catch:{ Exception -> 0x0202 }
        r12.setCDNType(r6);	 Catch:{ Exception -> 0x0202 }
    L_0x00a6:
        r6 = a();	 Catch:{ Exception -> 0x0202 }
        r6 = r6.f(r9, r8);	 Catch:{ Exception -> 0x0202 }
        if (r4 == 0) goto L_0x00d0;	 Catch:{ Exception -> 0x0202 }
    L_0x00b0:
        r10 = a();	 Catch:{ Exception -> 0x0202 }
        r13 = "0";	 Catch:{ Exception -> 0x0202 }
        r10.b(r12, r13);	 Catch:{ Exception -> 0x0202 }
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0202 }
        r10 = com.igexin.push.util.a.a(r13);	 Catch:{ Exception -> 0x0202 }
        if (r10 == 0) goto L_0x00c4;	 Catch:{ Exception -> 0x0202 }
    L_0x00c3:
        return r5;	 Catch:{ Exception -> 0x0202 }
    L_0x00c4:
        r10 = com.igexin.push.util.a.a(r20);	 Catch:{ Exception -> 0x0202 }
        if (r10 == 0) goto L_0x00d0;	 Catch:{ Exception -> 0x0202 }
    L_0x00ca:
        r2 = "CoreAction|message have loop";	 Catch:{ Exception -> 0x0202 }
        com.igexin.b.a.c.a.b(r2);	 Catch:{ Exception -> 0x0202 }
        return r5;	 Catch:{ Exception -> 0x0202 }
    L_0x00d0:
        r10 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0202 }
        r10.<init>();	 Catch:{ Exception -> 0x0202 }
        r13 = "messageid";	 Catch:{ Exception -> 0x0202 }
        r10.put(r13, r8);	 Catch:{ Exception -> 0x0202 }
        r13 = "taskid";	 Catch:{ Exception -> 0x0202 }
        r10.put(r13, r9);	 Catch:{ Exception -> 0x0202 }
        r13 = "appid";	 Catch:{ Exception -> 0x0202 }
        r10.put(r13, r7);	 Catch:{ Exception -> 0x0202 }
        r7 = "key";	 Catch:{ Exception -> 0x0202 }
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0202 }
        r14 = "CACHE_";	 Catch:{ Exception -> 0x0202 }
        r13.<init>(r14);	 Catch:{ Exception -> 0x0202 }
        r13.append(r6);	 Catch:{ Exception -> 0x0202 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x0202 }
        r10.put(r7, r13);	 Catch:{ Exception -> 0x0202 }
        r7 = "info";	 Catch:{ Exception -> 0x0202 }
        r13 = r20.toString();	 Catch:{ Exception -> 0x0202 }
        r13 = r13.getBytes();	 Catch:{ Exception -> 0x0202 }
        r13 = com.igexin.b.b.a.b(r13);	 Catch:{ Exception -> 0x0202 }
        r10.put(r7, r13);	 Catch:{ Exception -> 0x0202 }
        r7 = "createtime";	 Catch:{ Exception -> 0x0202 }
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0202 }
        r13 = java.lang.Long.valueOf(r13);	 Catch:{ Exception -> 0x0202 }
        r10.put(r7, r13);	 Catch:{ Exception -> 0x0202 }
        if (r3 == 0) goto L_0x011f;	 Catch:{ Exception -> 0x0202 }
    L_0x0117:
        r7 = "msgextra";	 Catch:{ Exception -> 0x0202 }
        r10.put(r7, r3);	 Catch:{ Exception -> 0x0202 }
        r12.setMsgExtra(r3);	 Catch:{ Exception -> 0x0202 }
    L_0x011f:
        r3 = r11.length();	 Catch:{ Exception -> 0x0202 }
        if (r3 <= 0) goto L_0x0135;	 Catch:{ Exception -> 0x0202 }
    L_0x0125:
        r3 = a();	 Catch:{ Exception -> 0x0202 }
        r3 = r3.a(r2, r12);	 Catch:{ Exception -> 0x0202 }
        if (r3 != 0) goto L_0x0135;	 Catch:{ Exception -> 0x0202 }
    L_0x012f:
        r2 = "CoreAction parseActionChains result = false #######";	 Catch:{ Exception -> 0x0202 }
        com.igexin.b.a.c.a.b(r2);	 Catch:{ Exception -> 0x0202 }
        return r5;
    L_0x0135:
        if (r4 == 0) goto L_0x01e6;
    L_0x0137:
        r3 = 0;
        r4 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r13 = r4.k();	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r14 = "message";	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r15 = new java.lang.String[r5];	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r4 = "taskid";	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r7 = 0;	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r15[r7] = r4;	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r4 = new java.lang.String[r5];	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r4[r7] = r9;	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r17 = 0;	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r18 = 0;	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r16 = r4;	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        r4 = r13.a(r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x01e0, all -> 0x01d7 }
        if (r4 == 0) goto L_0x01d1;
    L_0x0159:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r7 = "CoreAction|taskid = ";	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3.<init>(r7);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3.append(r9);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r7 = ", db cnt = ";	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3.append(r7);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r7 = r4.getCount();	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3.append(r7);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3 = r3.toString();	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        com.igexin.b.a.c.a.b(r3);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3 = r4.getCount();	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        if (r3 != 0) goto L_0x01c6;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
    L_0x017c:
        r3 = "condition";	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3 = r2.has(r3);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        if (r3 == 0) goto L_0x0198;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
    L_0x0184:
        r1.b(r2, r12);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3 = com.igexin.push.core.a.k;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r12.setStatus(r3);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3 = "status";	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r7 = com.igexin.push.core.a.k;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
    L_0x0194:
        r10.put(r3, r7);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        goto L_0x01a6;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
    L_0x0198:
        r3 = com.igexin.push.core.a.l;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r12.setStatus(r3);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3 = "status";	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r7 = com.igexin.push.core.a.l;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        goto L_0x0194;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
    L_0x01a6:
        r1.a(r10);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3 = com.igexin.push.core.g.ai;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3.put(r6, r12);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3 = "condition";	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r2 = r2.has(r3);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        if (r2 == 0) goto L_0x01ba;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
    L_0x01b6:
        r19.s();	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        goto L_0x01d1;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
    L_0x01ba:
        r2 = a();	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r3 = com.igexin.push.core.g.a;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r6 = com.igexin.push.core.g.e;	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        r2.b(r9, r8, r3, r6);	 Catch:{ Exception -> 0x01cf, all -> 0x01cc }
        goto L_0x01d1;
    L_0x01c6:
        if (r4 == 0) goto L_0x01cb;
    L_0x01c8:
        r4.close();	 Catch:{ Exception -> 0x0202 }
    L_0x01cb:
        return r5;	 Catch:{ Exception -> 0x0202 }
    L_0x01cc:
        r0 = move-exception;	 Catch:{ Exception -> 0x0202 }
        r2 = r0;	 Catch:{ Exception -> 0x0202 }
        goto L_0x01da;	 Catch:{ Exception -> 0x0202 }
    L_0x01cf:
        r3 = r4;	 Catch:{ Exception -> 0x0202 }
        goto L_0x01e0;	 Catch:{ Exception -> 0x0202 }
    L_0x01d1:
        if (r4 == 0) goto L_0x0219;	 Catch:{ Exception -> 0x0202 }
    L_0x01d3:
        r4.close();	 Catch:{ Exception -> 0x0202 }
        return r5;	 Catch:{ Exception -> 0x0202 }
    L_0x01d7:
        r0 = move-exception;	 Catch:{ Exception -> 0x0202 }
        r2 = r0;	 Catch:{ Exception -> 0x0202 }
        r4 = r3;	 Catch:{ Exception -> 0x0202 }
    L_0x01da:
        if (r4 == 0) goto L_0x01df;	 Catch:{ Exception -> 0x0202 }
    L_0x01dc:
        r4.close();	 Catch:{ Exception -> 0x0202 }
    L_0x01df:
        throw r2;	 Catch:{ Exception -> 0x0202 }
    L_0x01e0:
        if (r3 == 0) goto L_0x0219;	 Catch:{ Exception -> 0x0202 }
    L_0x01e2:
        r3.close();	 Catch:{ Exception -> 0x0202 }
        return r5;	 Catch:{ Exception -> 0x0202 }
    L_0x01e6:
        r3 = "condition";	 Catch:{ Exception -> 0x0202 }
        r3 = r2.has(r3);	 Catch:{ Exception -> 0x0202 }
        if (r3 == 0) goto L_0x01f1;	 Catch:{ Exception -> 0x0202 }
    L_0x01ee:
        r1.b(r2, r12);	 Catch:{ Exception -> 0x0202 }
    L_0x01f1:
        r2 = com.igexin.push.core.a.l;	 Catch:{ Exception -> 0x0202 }
        r12.setStatus(r2);	 Catch:{ Exception -> 0x0202 }
        r2 = com.igexin.push.core.g.ai;	 Catch:{ Exception -> 0x0202 }
        r2.put(r6, r12);	 Catch:{ Exception -> 0x0202 }
        return r5;	 Catch:{ Exception -> 0x0202 }
    L_0x01fc:
        r2 = "CoreAction receieve error pushmessage +++++++++++++++++++";	 Catch:{ Exception -> 0x0202 }
        com.igexin.b.a.c.a.b(r2);	 Catch:{ Exception -> 0x0202 }
        return r5;
    L_0x0202:
        r0 = move-exception;
        r2 = r0;
        r3 = new java.lang.StringBuilder;
        r4 = "CoreAction ";
        r3.<init>(r4);
        r2 = r2.toString();
        r3.append(r2);
        r2 = r3.toString();
        com.igexin.b.a.c.a.b(r2);
    L_0x0219:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.a(org.json.JSONObject, byte[], boolean):boolean");
    }

    public Class b(Context context) {
        return GTServiceManager.getInstance().getUserIntentService(context);
    }

    public void b() {
        d();
    }

    public void b(int i, String str) {
        m.e = i;
        com.igexin.push.config.a.a().d();
    }

    public void b(Intent intent) {
        if (intent != null && intent.hasExtra("isSlave")) {
            boolean booleanExtra = intent.getBooleanExtra("isSlave", false);
            StringBuilder stringBuilder = new StringBuilder("CoreAction|onServiceInitializeForSlave isSlave =");
            stringBuilder.append(booleanExtra);
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            if (booleanExtra) {
                com.igexin.push.core.f.a().a(true);
                com.igexin.push.core.g.D = intent.hasExtra("op_app") ? intent.getStringExtra("op_app") : "";
                if (com.igexin.push.core.g.l) {
                    k();
                }
            }
        }
    }

    public void b(PushTaskBean pushTaskBean, String str) {
        if (pushTaskBean.isCDNType()) {
            c(pushTaskBean, str);
        } else {
            a(pushTaskBean, str, ITagManager.SUCCESS);
        }
    }

    public void b(String str) {
        String a = a(true, 4);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("2.11.1.0|sdkconfig-error|");
        a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(str);
        com.igexin.b.a.b.c.b().a(new com.igexin.push.f.a.c(new com.igexin.push.core.c.i(SDKUrlConfig.getBiUploadServiceUrl(), stringBuilder.toString().getBytes(), 0, true)), false, true);
    }

    public void b(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - com.igexin.push.core.g.S > 5000) {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
            if (!format.equals(com.igexin.push.core.g.R)) {
                com.igexin.push.core.b.g.a().f(format);
                com.igexin.push.core.b.g.a().a(0);
            }
            StringBuilder stringBuilder = new StringBuilder("-> CoreRuntimeInfo.opAliasTimes:");
            stringBuilder.append(com.igexin.push.core.g.T);
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            if (com.igexin.push.core.g.T < 100) {
                com.igexin.b.a.c.a.b("start bindAlias ###");
                com.igexin.push.core.g.S = currentTimeMillis;
                com.igexin.push.core.b.g.a().a(com.igexin.push.core.g.T + 1);
                a(str, str2, false, true);
                return;
            }
            com.igexin.b.a.c.a.b("CoreAction|bindAlias times exceed");
            return;
        }
        com.igexin.b.a.c.a.b("CoreAction|bindAlias frequently called");
    }

    public void b(String str, String str2, String str3, String str4) {
        com.igexin.b.a.c.a.b("CoreAction start broadcastExecute");
        if (com.igexin.push.core.g.f != null) {
            Intent intent = new Intent("com.igexin.sdk.action.execute");
            intent.putExtra("taskid", str);
            intent.putExtra("messageid", str2);
            intent.putExtra("appid", com.igexin.push.core.g.a);
            intent.putExtra("pkgname", com.igexin.push.core.g.e);
            com.igexin.push.core.g.f.sendBroadcast(intent);
        }
    }

    public void b(boolean z) {
        com.igexin.b.a.b.c.b().a((Object) new com.igexin.push.d.b.d());
        com.igexin.b.a.b.c.b().c();
        e(z);
    }

    public boolean b(String str, String str2, String str3) {
        Throwable th;
        StringBuilder stringBuilder;
        int executeTimes;
        BaseAction baseAction;
        a aVar;
        String f = f(str, str2);
        PushTaskBean pushTaskBean = (PushTaskBean) com.igexin.push.core.g.ai.get(f);
        if (pushTaskBean == null) {
            Cursor cursor = null;
            try {
                Cursor a = com.igexin.push.core.f.a().k().a("message", new String[]{"taskid", "messageid"}, new String[]{str, str2}, null, null);
                if (a != null) {
                    try {
                        if (a.getCount() > 0) {
                            while (a.moveToNext()) {
                                a(new JSONObject(new String(com.igexin.b.b.a.c(a.getBlob(a.getColumnIndexOrThrow("info"))))), a.getBlob(a.getColumnIndexOrThrow("msgextra")), false);
                                Map map = com.igexin.push.core.g.ai;
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(str);
                                stringBuilder2.append(Constants.COLON_SEPARATOR);
                                stringBuilder2.append(str2);
                                PushTaskBean pushTaskBean2 = (PushTaskBean) map.get(stringBuilder2.toString());
                                if (pushTaskBean2 == null) {
                                    if (a != null) {
                                        a.close();
                                    }
                                    return false;
                                }
                                pushTaskBean = pushTaskBean2;
                            }
                            if (a != null) {
                                a.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
                if (a != null) {
                    a.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                stringBuilder = new StringBuilder("CoreAction|");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                if (cursor != null) {
                    cursor.close();
                }
                executeTimes = pushTaskBean.getExecuteTimes();
                if (executeTimes >= 50) {
                    com.igexin.push.core.g.ai.remove(f);
                    return true;
                }
                pushTaskBean.setExecuteTimes(executeTimes + 1);
                a().b(pushTaskBean, str3);
                baseAction = pushTaskBean.getBaseAction(str3);
                if (baseAction != null) {
                    return false;
                }
                if (baseAction.isSupportExt()) {
                    while (r14.hasNext()) {
                        if (r15.executeAction(pushTaskBean, baseAction)) {
                            return true;
                        }
                    }
                }
                aVar = (a) b.get(baseAction.getType());
                if (aVar != null) {
                }
            }
        }
        executeTimes = pushTaskBean.getExecuteTimes();
        if (executeTimes >= 50) {
            com.igexin.push.core.g.ai.remove(f);
            return true;
        }
        pushTaskBean.setExecuteTimes(executeTimes + 1);
        a().b(pushTaskBean, str3);
        baseAction = pushTaskBean.getBaseAction(str3);
        if (baseAction != null) {
            return false;
        }
        if (baseAction.isSupportExt()) {
            while (r14.hasNext()) {
                if (r15.executeAction(pushTaskBean, baseAction)) {
                    return true;
                }
            }
        }
        aVar = (a) b.get(baseAction.getType());
        if (aVar != null && !pushTaskBean.isStop()) {
            return aVar.b(pushTaskBean, baseAction);
        }
    }

    public com.igexin.push.d.c.k c() {
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
        r6 = this;
        r0 = new com.igexin.push.d.c.k;
        r0.<init>();
        r1 = com.igexin.push.core.g.q;
        r0.a = r1;
        r1 = 0;
        r0.b = r1;
        r1 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r0.c = r1;
        r1 = com.igexin.push.core.g.a;
        r0.d = r1;
        r1 = com.igexin.push.util.a.a();	 Catch:{ Throwable -> 0x0089 }
        r2 = -1;	 Catch:{ Throwable -> 0x0089 }
        if (r1 == 0) goto L_0x0089;	 Catch:{ Throwable -> 0x0089 }
    L_0x001c:
        r1 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0089 }
        r1.<init>();	 Catch:{ Throwable -> 0x0089 }
        r3 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x0049 }
        r4 = "connectivity";	 Catch:{ Throwable -> 0x0049 }
        r3 = r3.getSystemService(r4);	 Catch:{ Throwable -> 0x0049 }
        r3 = (android.net.ConnectivityManager) r3;	 Catch:{ Throwable -> 0x0049 }
        if (r3 == 0) goto L_0x0049;	 Catch:{ Throwable -> 0x0049 }
    L_0x002d:
        r3 = r3.getActiveNetworkInfo();	 Catch:{ Throwable -> 0x0049 }
        if (r3 == 0) goto L_0x0049;	 Catch:{ Throwable -> 0x0049 }
    L_0x0033:
        r3 = r3.getType();	 Catch:{ Throwable -> 0x0049 }
        r2 = new com.igexin.push.d.c.l;	 Catch:{ Throwable -> 0x0048 }
        r2.<init>();	 Catch:{ Throwable -> 0x0048 }
        r4 = 2;	 Catch:{ Throwable -> 0x0048 }
        r2.a = r4;	 Catch:{ Throwable -> 0x0048 }
        r4 = java.lang.String.valueOf(r3);	 Catch:{ Throwable -> 0x0048 }
        r2.b = r4;	 Catch:{ Throwable -> 0x0048 }
        r1.add(r2);	 Catch:{ Throwable -> 0x0048 }
    L_0x0048:
        r2 = r3;
    L_0x0049:
        r3 = 1;
        if (r2 != r3) goto L_0x0081;
    L_0x004c:
        r2 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x0081 }
        r4 = "wifi";	 Catch:{ Throwable -> 0x0081 }
        r2 = r2.getSystemService(r4);	 Catch:{ Throwable -> 0x0081 }
        r2 = (android.net.wifi.WifiManager) r2;	 Catch:{ Throwable -> 0x0081 }
        r2 = r2.getConnectionInfo();	 Catch:{ Throwable -> 0x0081 }
        if (r2 == 0) goto L_0x0081;	 Catch:{ Throwable -> 0x0081 }
    L_0x005c:
        r4 = r2.getSSID();	 Catch:{ Throwable -> 0x0081 }
        r2 = r2.getBSSID();	 Catch:{ Throwable -> 0x0081 }
        if (r4 == 0) goto L_0x0072;	 Catch:{ Throwable -> 0x0081 }
    L_0x0066:
        r5 = new com.igexin.push.d.c.l;	 Catch:{ Throwable -> 0x0081 }
        r5.<init>();	 Catch:{ Throwable -> 0x0081 }
        r5.a = r3;	 Catch:{ Throwable -> 0x0081 }
        r5.b = r4;	 Catch:{ Throwable -> 0x0081 }
        r1.add(r5);	 Catch:{ Throwable -> 0x0081 }
    L_0x0072:
        if (r2 == 0) goto L_0x0081;	 Catch:{ Throwable -> 0x0081 }
    L_0x0074:
        r3 = new com.igexin.push.d.c.l;	 Catch:{ Throwable -> 0x0081 }
        r3.<init>();	 Catch:{ Throwable -> 0x0081 }
        r4 = 4;	 Catch:{ Throwable -> 0x0081 }
        r3.a = r4;	 Catch:{ Throwable -> 0x0081 }
        r3.b = r2;	 Catch:{ Throwable -> 0x0081 }
        r1.add(r3);	 Catch:{ Throwable -> 0x0081 }
    L_0x0081:
        r2 = r1.isEmpty();	 Catch:{ Throwable -> 0x0089 }
        if (r2 != 0) goto L_0x0089;	 Catch:{ Throwable -> 0x0089 }
    L_0x0087:
        r0.e = r1;	 Catch:{ Throwable -> 0x0089 }
    L_0x0089:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.c():com.igexin.push.d.c.k");
    }

    public String c(String str) {
        return com.igexin.push.core.g.b() == null ? null : (String) com.igexin.push.core.g.b().get(str);
    }

    public void c(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            try {
                String action = intent.getAction();
                if (!PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                    if (!("com.igexin.sdk.action.snlrefresh".equals(action) || com.igexin.push.core.g.V.equals(action))) {
                        if (!"com.igexin.sdk.action.snlretire".equals(action)) {
                            if ("com.igexin.sdk.action.execute".equals(action)) {
                                g(intent);
                                return;
                            } else if ("com.igexin.sdk.action.doaction".equals(action)) {
                                f(intent);
                                return;
                            } else if ("android.intent.action.TIME_SET".equals(action)) {
                                if (m.b != 0) {
                                    com.igexin.push.a.a.c.c().d();
                                    return;
                                }
                            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                                com.igexin.push.core.g.p = 1;
                                if (t()) {
                                    s();
                                    return;
                                }
                            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                                com.igexin.push.core.g.p = 0;
                                return;
                            } else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                                e(intent.getDataString());
                                return;
                            } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                                d(intent.getDataString());
                                return;
                            } else if ("com.igexin.sdk.action.core.clearmsg".equals(action)) {
                                com.igexin.push.core.f.a().k().a("message", null);
                                return;
                            } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && intent.getIntExtra("wifi_state", 0) == 3) {
                                com.igexin.push.core.f.a().d();
                            }
                        }
                    }
                    com.igexin.push.core.f.a().h().a(intent);
                } else if (com.igexin.b.a.b.c.b() != null) {
                    D();
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("CoreAction");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
        }
    }

    public void c(PushTaskBean pushTaskBean, String str) {
        if (pushTaskBean != null && !TextUtils.isEmpty(pushTaskBean.getMessageId())) {
            com.igexin.push.d.c.c cVar;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(pushTaskBean.getMessageId());
            stringBuilder.append("|");
            stringBuilder.append(str);
            String stringBuilder2 = stringBuilder.toString();
            com.igexin.push.e.j g;
            StringBuilder stringBuilder3;
            if (com.igexin.push.core.g.al.containsKey(stringBuilder2)) {
                cVar = (com.igexin.push.d.c.c) com.igexin.push.core.g.al.get(stringBuilder2);
                if (cVar.c() < 2) {
                    g = com.igexin.push.core.f.a().g();
                    stringBuilder3 = new StringBuilder("C-");
                    stringBuilder3.append(com.igexin.push.core.g.r);
                    g.a(stringBuilder3.toString(), cVar);
                    cVar.a(cVar.c() + 1);
                }
                stringBuilder = new StringBuilder("cdnfeedback|");
                stringBuilder.append(pushTaskBean.getTaskId());
                stringBuilder.append("|");
                stringBuilder.append(pushTaskBean.getMessageId());
                stringBuilder.append("|");
                stringBuilder.append(str);
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
            cVar = new com.igexin.push.d.c.c();
            String str2 = ITagManager.SUCCESS;
            long currentTimeMillis = System.currentTimeMillis();
            cVar.a();
            StringBuilder stringBuilder4 = new StringBuilder("FDB");
            stringBuilder4.append(pushTaskBean.getMessageId());
            stringBuilder4.append("|");
            stringBuilder4.append(pushTaskBean.getTaskId());
            stringBuilder4.append("|");
            stringBuilder4.append(str);
            stringBuilder4.append("|");
            stringBuilder4.append(str2);
            stringBuilder4.append("|");
            stringBuilder4.append(currentTimeMillis);
            cVar.c = stringBuilder4.toString();
            cVar.d = com.igexin.push.core.g.r;
            cVar.a = (int) currentTimeMillis;
            g = com.igexin.push.core.f.a().g();
            stringBuilder3 = new StringBuilder("C-");
            stringBuilder3.append(com.igexin.push.core.g.r);
            g.a(stringBuilder3.toString(), cVar);
            a(cVar, pushTaskBean, str, stringBuilder2);
            stringBuilder = new StringBuilder("cdnfeedback|");
            stringBuilder.append(pushTaskBean.getTaskId());
            stringBuilder.append("|");
            stringBuilder.append(pushTaskBean.getMessageId());
            stringBuilder.append("|");
            stringBuilder.append(str);
            com.igexin.b.a.c.a.b(stringBuilder.toString());
        }
    }

    public void c(String str, String str2) {
        if (com.igexin.push.core.g.f != null) {
            try {
                Class b = b(com.igexin.push.core.g.f);
                if (b != null) {
                    Intent intent = new Intent(com.igexin.push.core.g.f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 10010);
                    bundle.putSerializable(PushConsts.KEY_CMD_MSG, new SetTagCmdMessage(str, str2, 10009));
                    intent.putExtras(bundle);
                    com.igexin.push.core.g.f.startService(intent);
                    return;
                }
                Intent E = E();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("action", 10009);
                bundle2.putString("sn", str);
                bundle2.putString("code", str2);
                E.putExtras(bundle2);
                com.igexin.push.core.g.f.sendBroadcast(E);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("CoreAction|");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
        }
    }

    public void c(boolean z) {
        f();
        d(z);
    }

    public int d() {
        if (com.igexin.push.core.g.i && com.igexin.push.core.g.j && !com.igexin.push.util.a.a(System.currentTimeMillis())) {
            if (com.igexin.push.util.a.b()) {
                com.igexin.push.d.c.e iVar = new com.igexin.push.d.c.i();
                iVar.a = com.igexin.push.core.g.a;
                return (com.igexin.push.core.f.a().g().a("K-", iVar, true) < 0 ? 0 : true) != 0 ? 1 : 0;
            }
        }
        com.igexin.b.a.c.a.b("CoreAction|keyNegotiate stop ++++++++++");
        return -1;
    }

    public void d(android.content.Intent r12) {
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
        r11 = this;
        if (r12 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = "id";	 Catch:{ Throwable -> 0x013c }
        r1 = -1;	 Catch:{ Throwable -> 0x013c }
        r0 = r12.getIntExtra(r0, r1);	 Catch:{ Throwable -> 0x013c }
        r2 = "result";	 Catch:{ Throwable -> 0x013c }
        r3 = 0;	 Catch:{ Throwable -> 0x013c }
        r2 = r12.getBooleanExtra(r2, r3);	 Catch:{ Throwable -> 0x013c }
        if (r0 != r1) goto L_0x0014;	 Catch:{ Throwable -> 0x013c }
    L_0x0013:
        return;	 Catch:{ Throwable -> 0x013c }
    L_0x0014:
        r1 = com.igexin.push.core.g.ar;	 Catch:{ Throwable -> 0x013c }
        r4 = 1;	 Catch:{ Throwable -> 0x013c }
        r1 = r1 + r4;	 Catch:{ Throwable -> 0x013c }
        com.igexin.push.core.g.ar = r1;	 Catch:{ Throwable -> 0x013c }
        if (r2 == 0) goto L_0x0126;	 Catch:{ Throwable -> 0x013c }
    L_0x001c:
        r1 = "isReload";	 Catch:{ Throwable -> 0x013c }
        r12 = r12.getBooleanExtra(r1, r3);	 Catch:{ Throwable -> 0x013c }
        if (r12 == 0) goto L_0x002c;	 Catch:{ Throwable -> 0x013c }
    L_0x0024:
        r12 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x013c }
        android.os.Process.killProcess(r12);	 Catch:{ Throwable -> 0x013c }
        return;	 Catch:{ Throwable -> 0x013c }
    L_0x002c:
        r12 = com.igexin.push.core.g.aq;	 Catch:{ Throwable -> 0x013c }
        r12 = r12 + r4;	 Catch:{ Throwable -> 0x013c }
        com.igexin.push.core.g.aq = r12;	 Catch:{ Throwable -> 0x013c }
        r12 = 0;	 Catch:{ Throwable -> 0x013c }
        r1 = com.igexin.push.core.g.as;	 Catch:{ Throwable -> 0x013c }
        if (r1 == 0) goto L_0x003c;	 Catch:{ Throwable -> 0x013c }
    L_0x0036:
        r12 = com.igexin.push.core.g.as;	 Catch:{ Throwable -> 0x013c }
        r12 = r12.b();	 Catch:{ Throwable -> 0x013c }
    L_0x003c:
        if (r12 != 0) goto L_0x003f;	 Catch:{ Throwable -> 0x013c }
    L_0x003e:
        return;	 Catch:{ Throwable -> 0x013c }
    L_0x003f:
        r1 = com.igexin.push.config.m.s;	 Catch:{ Throwable -> 0x013c }
        if (r1 == 0) goto L_0x0072;	 Catch:{ Throwable -> 0x013c }
    L_0x0043:
        r1 = com.igexin.push.config.m.s;	 Catch:{ Throwable -> 0x013c }
        r1 = r1.b();	 Catch:{ Throwable -> 0x013c }
        if (r1 != 0) goto L_0x004c;	 Catch:{ Throwable -> 0x013c }
    L_0x004b:
        return;	 Catch:{ Throwable -> 0x013c }
    L_0x004c:
        r2 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x013c }
        r2 = r1.containsKey(r2);	 Catch:{ Throwable -> 0x013c }
        if (r2 == 0) goto L_0x0086;	 Catch:{ Throwable -> 0x013c }
    L_0x0056:
        r2 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x013c }
        r2 = r1.get(r2);	 Catch:{ Throwable -> 0x013c }
        r2 = (com.igexin.push.core.bean.f) r2;	 Catch:{ Throwable -> 0x013c }
        if (r2 == 0) goto L_0x0069;	 Catch:{ Throwable -> 0x013c }
    L_0x0062:
        r2 = r2.c();	 Catch:{ Throwable -> 0x013c }
        com.igexin.push.util.e.b(r2);	 Catch:{ Throwable -> 0x013c }
    L_0x0069:
        r2 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x013c }
        r1.remove(r2);	 Catch:{ Throwable -> 0x013c }
        r3 = r4;	 Catch:{ Throwable -> 0x013c }
        goto L_0x0086;	 Catch:{ Throwable -> 0x013c }
    L_0x0072:
        r1 = new java.util.HashMap;	 Catch:{ Throwable -> 0x013c }
        r1.<init>();	 Catch:{ Throwable -> 0x013c }
        r2 = new com.igexin.push.core.bean.g;	 Catch:{ Throwable -> 0x013c }
        r2.<init>();	 Catch:{ Throwable -> 0x013c }
        r4 = "0";	 Catch:{ Throwable -> 0x013c }
        r2.a(r4);	 Catch:{ Throwable -> 0x013c }
        r2.a(r1);	 Catch:{ Throwable -> 0x013c }
        com.igexin.push.config.m.s = r2;	 Catch:{ Throwable -> 0x013c }
    L_0x0086:
        r2 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x013c }
        r12 = r12.get(r2);	 Catch:{ Throwable -> 0x013c }
        r12 = (com.igexin.push.core.bean.f) r12;	 Catch:{ Throwable -> 0x013c }
        if (r12 != 0) goto L_0x0093;	 Catch:{ Throwable -> 0x013c }
    L_0x0092:
        return;	 Catch:{ Throwable -> 0x013c }
    L_0x0093:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x013c }
        r2.<init>();	 Catch:{ Throwable -> 0x013c }
        r4 = com.igexin.push.core.g.ac;	 Catch:{ Throwable -> 0x013c }
        r2.append(r4);	 Catch:{ Throwable -> 0x013c }
        r4 = "/";	 Catch:{ Throwable -> 0x013c }
        r2.append(r4);	 Catch:{ Throwable -> 0x013c }
        r4 = r12.c();	 Catch:{ Throwable -> 0x013c }
        r2.append(r4);	 Catch:{ Throwable -> 0x013c }
        r7 = r2.toString();	 Catch:{ Throwable -> 0x013c }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x013c }
        r2.<init>(r7);	 Catch:{ Throwable -> 0x013c }
        r2 = r2.exists();	 Catch:{ Throwable -> 0x013c }
        if (r2 == 0) goto L_0x0126;	 Catch:{ Throwable -> 0x013c }
    L_0x00b8:
        r2 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x013c }
        r1.put(r2, r12);	 Catch:{ Throwable -> 0x013c }
        r2 = com.igexin.push.core.g.aq;	 Catch:{ Throwable -> 0x013c }
        r4 = com.igexin.push.core.g.ap;	 Catch:{ Throwable -> 0x013c }
        if (r2 != r4) goto L_0x00d0;	 Catch:{ Throwable -> 0x013c }
    L_0x00c5:
        r2 = com.igexin.push.config.m.s;	 Catch:{ Throwable -> 0x013c }
        r4 = com.igexin.push.core.g.as;	 Catch:{ Throwable -> 0x013c }
        r4 = r4.a();	 Catch:{ Throwable -> 0x013c }
        r2.a(r4);	 Catch:{ Throwable -> 0x013c }
    L_0x00d0:
        if (r3 != 0) goto L_0x011f;	 Catch:{ Throwable -> 0x013c }
    L_0x00d2:
        r5 = com.igexin.push.extension.a.a();	 Catch:{ Throwable -> 0x013c }
        r6 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x013c }
        r8 = r12.d();	 Catch:{ Throwable -> 0x013c }
        r9 = r12.j();	 Catch:{ Throwable -> 0x013c }
        r10 = r12.c();	 Catch:{ Throwable -> 0x013c }
        r2 = r5.a(r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x013c }
        if (r2 == 0) goto L_0x011f;	 Catch:{ Throwable -> 0x013c }
    L_0x00ea:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x013c }
        r3 = "CoreAction|load ";	 Catch:{ Throwable -> 0x013c }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x013c }
        r3 = r12.d();	 Catch:{ Throwable -> 0x013c }
        r2.append(r3);	 Catch:{ Throwable -> 0x013c }
        r3 = " success";	 Catch:{ Throwable -> 0x013c }
        r2.append(r3);	 Catch:{ Throwable -> 0x013c }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x013c }
        com.igexin.b.a.c.a.b(r2);	 Catch:{ Throwable -> 0x013c }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x013c }
        r12.b(r2);	 Catch:{ Throwable -> 0x013c }
        r2 = r12.g();	 Catch:{ Throwable -> 0x013c }
        if (r2 == 0) goto L_0x011f;	 Catch:{ Throwable -> 0x013c }
    L_0x0111:
        r12 = r12.c();	 Catch:{ Throwable -> 0x013c }
        com.igexin.push.util.e.b(r12);	 Catch:{ Throwable -> 0x013c }
        r12 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x013c }
        r1.remove(r12);	 Catch:{ Throwable -> 0x013c }
    L_0x011f:
        r12 = com.igexin.push.config.a.a();	 Catch:{ Throwable -> 0x013c }
        r12.g();	 Catch:{ Throwable -> 0x013c }
    L_0x0126:
        r12 = com.igexin.push.core.g.ar;	 Catch:{ Throwable -> 0x013c }
        r0 = com.igexin.push.core.g.ap;	 Catch:{ Throwable -> 0x013c }
        if (r12 != r0) goto L_0x013c;	 Catch:{ Throwable -> 0x013c }
    L_0x012c:
        r12 = com.igexin.push.core.g.at;	 Catch:{ Throwable -> 0x013c }
        if (r12 == 0) goto L_0x013c;	 Catch:{ Throwable -> 0x013c }
    L_0x0130:
        r12 = "CoreActiondownload ext success, restart service ###";	 Catch:{ Throwable -> 0x013c }
        com.igexin.b.a.c.a.b(r12);	 Catch:{ Throwable -> 0x013c }
        r12 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x013c }
        android.os.Process.killProcess(r12);	 Catch:{ Throwable -> 0x013c }
    L_0x013c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.d(android.content.Intent):void");
    }

    public void d(String str, String str2) {
        if (com.igexin.push.core.g.f != null) {
            try {
                Class b = b(com.igexin.push.core.g.f);
                if (b != null) {
                    Intent intent = new Intent(com.igexin.push.core.g.f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 10010);
                    bundle.putSerializable(PushConsts.KEY_CMD_MSG, new BindAliasCmdMessage(str, str2, 10010));
                    intent.putExtras(bundle);
                    com.igexin.push.core.g.f.startService(intent);
                    return;
                }
                Intent E = E();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("action", 10010);
                bundle2.putString("sn", str);
                bundle2.putString("code", str2);
                E.putExtras(bundle2);
                com.igexin.push.core.g.f.sendBroadcast(E);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("CoreAction|");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
        }
    }

    public void d(boolean z) {
        com.igexin.b.a.b.c.b().a((Object) new com.igexin.push.d.b.b(z));
        com.igexin.b.a.b.c.b().c();
    }

    public void e() {
        boolean z = true;
        if (com.igexin.push.core.g.k) {
            com.igexin.push.core.g.k ^= true;
            com.igexin.push.core.g.L = System.currentTimeMillis() + (((long) Math.abs(new Random().nextInt() % 24)) * 3600000);
        }
        com.igexin.push.c.i.a().e().g();
        com.igexin.push.d.c.e fVar;
        com.igexin.push.e.j g;
        if (com.igexin.push.core.g.q == 0) {
            StringBuilder stringBuilder;
            com.igexin.b.a.c.a.b("registerReq #####");
            fVar = new com.igexin.push.d.c.f(com.igexin.push.core.g.t, com.igexin.push.core.g.u, com.igexin.push.core.g.B, com.igexin.push.core.g.a);
            g = com.igexin.push.core.f.a().g();
            stringBuilder = new StringBuilder("R-");
            stringBuilder.append(com.igexin.push.core.g.B);
            if (g.a(stringBuilder.toString(), fVar, true) < 0) {
                z = false;
            }
            StringBuilder stringBuilder2 = new StringBuilder("registerReq|");
            stringBuilder2.append(z);
            stringBuilder2.append("|");
            stringBuilder2.append(com.igexin.push.core.g.B);
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
            return;
        }
        fVar = c();
        StringBuilder stringBuilder3 = new StringBuilder("loginReqBefore|");
        stringBuilder3.append(fVar.a);
        com.igexin.b.a.c.a.b(stringBuilder3.toString());
        g = com.igexin.push.core.f.a().g();
        stringBuilder = new StringBuilder("S-");
        stringBuilder.append(String.valueOf(com.igexin.push.core.g.q));
        if (g.a(stringBuilder.toString(), fVar, true) < 0) {
            z = false;
        }
        if (z) {
            stringBuilder2 = new StringBuilder("CoreAction|loginReq|");
            stringBuilder2.append(com.igexin.push.core.g.r);
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
        }
    }

    public void e(Intent intent) {
        try {
            Object stringExtra = intent.getStringExtra("from");
            Object stringExtra2 = intent.getStringExtra("did");
            if (!TextUtils.isEmpty(stringExtra)) {
                if (!TextUtils.isEmpty(stringExtra2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(stringExtra);
                    stringBuilder.append("|");
                    stringBuilder.append(com.igexin.push.core.g.f.getPackageName());
                    stringBuilder.append("|");
                    stringBuilder.append(stringExtra2);
                    stringBuilder.append("|");
                    stringBuilder.append(com.igexin.push.core.g.y);
                    stringBuilder.append("|");
                    stringBuilder.append(com.igexin.push.core.g.a);
                    stringBuilder.append("|");
                    stringBuilder.append(com.igexin.push.core.g.r);
                    stringBuilder.append("|");
                    stringBuilder.append(System.currentTimeMillis());
                    af.a().a("21", stringBuilder.toString());
                    return;
                }
            }
            com.igexin.b.a.c.a.b("CoreAction|doThirdGuardSt from or did is empty");
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("CoreAction|doThirdGuardSt exception: ");
            stringBuilder2.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
        }
    }

    public void e(String str, String str2) {
        if (com.igexin.push.core.g.f != null) {
            try {
                Class b = b(com.igexin.push.core.g.f);
                if (b != null) {
                    Intent intent = new Intent(com.igexin.push.core.g.f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 10010);
                    bundle.putSerializable(PushConsts.KEY_CMD_MSG, new UnBindAliasCmdMessage(str, str2, 10011));
                    intent.putExtras(bundle);
                    com.igexin.push.core.g.f.startService(intent);
                    return;
                }
                Intent E = E();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("action", 10011);
                bundle2.putString("sn", str);
                bundle2.putString("code", str2);
                E.putExtras(bundle2);
                com.igexin.push.core.g.f.sendBroadcast(E);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("CoreAction|");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
        }
    }

    public void e(boolean z) {
        com.igexin.b.a.b.c.b().a((Object) new com.igexin.push.d.b.c(z));
        com.igexin.b.a.b.c.b().c();
    }

    public String f(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public void f() {
        com.igexin.b.a.b.a.a.d.a().b();
    }

    public int g() {
        com.igexin.b.a.c.a.a("CoreAction|send heart beat data ........");
        com.igexin.push.e.j g = com.igexin.push.core.f.a().g();
        StringBuilder stringBuilder = new StringBuilder("H-");
        stringBuilder.append(com.igexin.push.core.g.r);
        return g.a(stringBuilder.toString(), new com.igexin.push.d.c.h(), true);
    }

    public com.igexin.push.core.b g(String str, String str2) {
        com.igexin.push.core.b bVar = com.igexin.push.core.b.a;
        PushTaskBean pushTaskBean = (PushTaskBean) com.igexin.push.core.g.ai.get(f(str, str2));
        if (pushTaskBean == null) {
            return com.igexin.push.core.b.c;
        }
        int i = 0;
        for (BaseAction baseAction : pushTaskBean.getActionChains()) {
            com.igexin.push.core.b bVar2 = com.igexin.push.core.b.c;
            if (baseAction == null) {
                return bVar2;
            }
            for (IPushExtension prepareExecuteAction : com.igexin.push.extension.a.a().c()) {
                bVar2 = prepareExecuteAction.prepareExecuteAction(pushTaskBean, baseAction);
                if (bVar2 != com.igexin.push.core.b.c) {
                    break;
                }
            }
            if (bVar2 == com.igexin.push.core.b.c) {
                a aVar = (a) b.get(baseAction.getType());
                if (aVar == null) {
                    return bVar2;
                }
                bVar2 = aVar.a(pushTaskBean, baseAction);
                if (bVar2 == com.igexin.push.core.b.c) {
                    return bVar2;
                }
            }
            if (bVar == com.igexin.push.core.b.a) {
                bVar = bVar2;
            }
            if (bVar2 == com.igexin.push.core.b.b) {
                i++;
            }
        }
        if (!(i == 0 || com.igexin.push.core.g.a(str, Integer.valueOf(i), true))) {
            bVar = com.igexin.push.core.b.a;
        }
        return bVar;
    }

    public void h() {
        try {
            for (com.igexin.push.core.bean.j jVar : com.igexin.push.core.b.d.a().b()) {
                if (jVar.d() + 20000 <= System.currentTimeMillis()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject(jVar.b());
                    com.igexin.push.d.c.e dVar = new com.igexin.push.d.c.d();
                    dVar.a();
                    dVar.a = (int) currentTimeMillis;
                    dVar.d = "17258000";
                    if (jSONObject.has("extraData")) {
                        dVar.f = com.igexin.push.util.h.a(jSONObject.optString("extraData").getBytes(), 0);
                        jSONObject.remove("extraData");
                    }
                    dVar.e = jVar.b();
                    dVar.g = com.igexin.push.core.g.r;
                    com.igexin.push.e.j g = com.igexin.push.core.f.a().g();
                    StringBuilder stringBuilder = new StringBuilder("C-");
                    stringBuilder.append(com.igexin.push.core.g.r);
                    g.a(stringBuilder.toString(), dVar);
                    StringBuilder stringBuilder2 = new StringBuilder("freshral|");
                    stringBuilder2.append(jVar.b());
                    com.igexin.b.a.c.a.b(stringBuilder2.toString());
                    com.igexin.push.core.b.d.a().a(jVar.a());
                    jVar.a(System.currentTimeMillis() + 20000);
                    com.igexin.push.core.b.d.a().a(jVar);
                }
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder3 = new StringBuilder("CoreActionfreshRAL error :");
            stringBuilder3.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder3.toString());
        }
    }

    public void i() {
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
        r0 = java.lang.System.currentTimeMillis();
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = "action";	 Catch:{ JSONException -> 0x0019 }
        r4 = "request_deviceid";	 Catch:{ JSONException -> 0x0019 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0019 }
        r3 = "id";	 Catch:{ JSONException -> 0x0019 }
        r4 = java.lang.String.valueOf(r0);	 Catch:{ JSONException -> 0x0019 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0019 }
    L_0x0019:
        r2 = r2.toString();
        r3 = new com.igexin.push.d.c.d;
        r3.<init>();
        r3.a();
        r0 = (int) r0;
        r3.a = r0;
        r0 = "17258000";
        r3.d = r0;
        r3.e = r2;
        r0 = com.igexin.push.core.g.r;
        r3.g = r0;
        r0 = com.igexin.push.core.f.a();
        r0 = r0.g();
        r1 = new java.lang.StringBuilder;
        r2 = "C-";
        r1.<init>(r2);
        r2 = com.igexin.push.core.g.r;
        r1.append(r2);
        r1 = r1.toString();
        r0.a(r1, r3);
        r0 = "CoreAction|deviceidReq";
        com.igexin.b.a.c.a.b(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.i():void");
    }

    public void j() {
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
        r6 = this;
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0047 }
        r2 = com.igexin.push.core.g.G;	 Catch:{ Throwable -> 0x0047 }
        r4 = r0 - r2;	 Catch:{ Throwable -> 0x0047 }
        r0 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ Throwable -> 0x0047 }
        r2 = r4 - r0;	 Catch:{ Throwable -> 0x0047 }
        r0 = 0;	 Catch:{ Throwable -> 0x0047 }
        r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));	 Catch:{ Throwable -> 0x0047 }
        r0 = 0;	 Catch:{ Throwable -> 0x0047 }
        r1 = 1;	 Catch:{ Throwable -> 0x0047 }
        if (r4 <= 0) goto L_0x0017;	 Catch:{ Throwable -> 0x0047 }
    L_0x0015:
        r2 = r1;	 Catch:{ Throwable -> 0x0047 }
        goto L_0x0018;	 Catch:{ Throwable -> 0x0047 }
    L_0x0017:
        r2 = r0;	 Catch:{ Throwable -> 0x0047 }
    L_0x0018:
        if (r2 == 0) goto L_0x002c;	 Catch:{ Throwable -> 0x0047 }
    L_0x001a:
        r2 = com.igexin.push.core.b.g.a();	 Catch:{ Throwable -> 0x0047 }
        r2.b(r0);	 Catch:{ Throwable -> 0x0047 }
        r2 = com.igexin.push.core.b.g.a();	 Catch:{ Throwable -> 0x0047 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0047 }
        r2.h(r3);	 Catch:{ Throwable -> 0x0047 }
    L_0x002c:
        r2 = com.igexin.push.core.g.aC;	 Catch:{ Throwable -> 0x0047 }
        r3 = 5;	 Catch:{ Throwable -> 0x0047 }
        if (r2 > r3) goto L_0x0047;	 Catch:{ Throwable -> 0x0047 }
    L_0x0031:
        r2 = com.igexin.push.core.b.g.a();	 Catch:{ Throwable -> 0x0047 }
        r3 = com.igexin.push.core.g.aC;	 Catch:{ Throwable -> 0x0047 }
        r3 = r3 + r1;	 Catch:{ Throwable -> 0x0047 }
        r2.b(r3);	 Catch:{ Throwable -> 0x0047 }
        r2 = com.igexin.b.a.b.c.b();	 Catch:{ Throwable -> 0x0047 }
        r3 = new com.igexin.push.core.a.g;	 Catch:{ Throwable -> 0x0047 }
        r3.<init>(r6);	 Catch:{ Throwable -> 0x0047 }
        r2.a(r3, r0, r1);	 Catch:{ Throwable -> 0x0047 }
    L_0x0047:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.j():void");
    }

    public void k() {
        if (com.igexin.push.core.g.f != null) {
            new StringBuilder("clientid is ").append(com.igexin.push.core.g.r);
            StringBuilder stringBuilder = new StringBuilder("broadcastClientid|");
            stringBuilder.append(com.igexin.push.core.g.r);
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            try {
                Class b = b(com.igexin.push.core.g.f);
                if (b != null) {
                    Intent intent = new Intent(com.igexin.push.core.g.f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 10002);
                    bundle.putString(PushConsts.KEY_CLIENT_ID, com.igexin.push.core.g.r);
                    intent.putExtras(bundle);
                    com.igexin.push.core.g.f.startService(intent);
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder2 = new StringBuilder("CoreAction|");
                stringBuilder2.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder2.toString());
            }
            Intent E = E();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("action", 10002);
            bundle2.putString(PushConsts.KEY_CLIENT_ID, com.igexin.push.core.g.r);
            E.putExtras(bundle2);
            com.igexin.push.core.g.f.sendBroadcast(E);
        }
    }

    public void l() {
        if (com.igexin.push.core.g.f != null) {
            try {
                Class b = b(com.igexin.push.core.g.f);
                if (b != null) {
                    Intent intent = new Intent(com.igexin.push.core.g.f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 10007);
                    bundle.putBoolean(PushConsts.KEY_ONLINE_STATE, com.igexin.push.core.g.l);
                    intent.putExtras(bundle);
                    com.igexin.push.core.g.f.startService(intent);
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("CoreAction|");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
            Intent E = E();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("action", 10007);
            bundle2.putBoolean(PushConsts.KEY_ONLINE_STATE, com.igexin.push.core.g.l);
            E.putExtras(bundle2);
            com.igexin.push.core.g.f.sendBroadcast(E);
        }
    }

    public java.lang.String m() {
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
        r6 = this;
        r0 = new java.io.File;
        r1 = com.igexin.push.core.g.Z;
        r0.<init>(r1);
        r0 = r0.exists();
        r1 = 0;
        if (r0 == 0) goto L_0x005b;
    L_0x000e:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x004f, all -> 0x0042 }
        r3 = com.igexin.push.core.g.Z;	 Catch:{ Exception -> 0x004f, all -> 0x0042 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x004f, all -> 0x0042 }
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0040, all -> 0x003e }
        r3.<init>();	 Catch:{ Exception -> 0x0040, all -> 0x003e }
    L_0x001e:
        r4 = r2.read(r0);	 Catch:{ Exception -> 0x0051, all -> 0x003b }
        r5 = -1;	 Catch:{ Exception -> 0x0051, all -> 0x003b }
        if (r4 == r5) goto L_0x002a;	 Catch:{ Exception -> 0x0051, all -> 0x003b }
    L_0x0025:
        r5 = 0;	 Catch:{ Exception -> 0x0051, all -> 0x003b }
        r3.write(r0, r5, r4);	 Catch:{ Exception -> 0x0051, all -> 0x003b }
        goto L_0x001e;	 Catch:{ Exception -> 0x0051, all -> 0x003b }
    L_0x002a:
        r0 = r3.toByteArray();	 Catch:{ Exception -> 0x0051, all -> 0x003b }
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0051, all -> 0x003b }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0051, all -> 0x003b }
        r2.close();	 Catch:{ Exception -> 0x0036 }
    L_0x0036:
        r3.close();	 Catch:{ Exception -> 0x0039 }
    L_0x0039:
        r1 = r4;
        return r1;
    L_0x003b:
        r0 = move-exception;
        r1 = r3;
        goto L_0x0044;
    L_0x003e:
        r0 = move-exception;
        goto L_0x0044;
    L_0x0040:
        r3 = r1;
        goto L_0x0051;
    L_0x0042:
        r0 = move-exception;
        r2 = r1;
    L_0x0044:
        if (r2 == 0) goto L_0x0049;
    L_0x0046:
        r2.close();	 Catch:{ Exception -> 0x0049 }
    L_0x0049:
        if (r1 == 0) goto L_0x004e;
    L_0x004b:
        r1.close();	 Catch:{ Exception -> 0x004e }
    L_0x004e:
        throw r0;
    L_0x004f:
        r2 = r1;
        r3 = r2;
    L_0x0051:
        if (r2 == 0) goto L_0x0056;
    L_0x0053:
        r2.close();	 Catch:{ Exception -> 0x0056 }
    L_0x0056:
        if (r3 == 0) goto L_0x005b;
    L_0x0058:
        r3.close();	 Catch:{ Exception -> 0x005b }
    L_0x005b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.m():java.lang.String");
    }

    public void n() {
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
        r0 = new java.util.ArrayList;
        r0.<init>();
        r9.a(r0);
        r1 = r0.isEmpty();
        if (r1 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r1 = new org.json.JSONObject;
        r1.<init>();
        r2 = 0;
        r3 = "action";	 Catch:{ Exception -> 0x007b }
        r4 = "reportapplist";	 Catch:{ Exception -> 0x007b }
        r1.put(r3, r4);	 Catch:{ Exception -> 0x007b }
        r3 = "session_last";	 Catch:{ Exception -> 0x007b }
        r4 = com.igexin.push.core.g.q;	 Catch:{ Exception -> 0x007b }
        r1.put(r3, r4);	 Catch:{ Exception -> 0x007b }
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x007b }
        r3.<init>();	 Catch:{ Exception -> 0x007b }
        r4 = r0.size();	 Catch:{ Exception -> 0x007b }
        r5 = r2;	 Catch:{ Exception -> 0x007b }
    L_0x002d:
        if (r5 >= r4) goto L_0x0076;	 Catch:{ Exception -> 0x007b }
    L_0x002f:
        r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x007b }
        r6.<init>();	 Catch:{ Exception -> 0x007b }
        r7 = "appid";	 Catch:{ Exception -> 0x007b }
        r8 = r0.get(r5);	 Catch:{ Exception -> 0x007b }
        r8 = (com.igexin.push.core.bean.n) r8;	 Catch:{ Exception -> 0x007b }
        r8 = r8.d();	 Catch:{ Exception -> 0x007b }
        r6.put(r7, r8);	 Catch:{ Exception -> 0x007b }
        r7 = "name";	 Catch:{ Exception -> 0x007b }
        r8 = r0.get(r5);	 Catch:{ Exception -> 0x007b }
        r8 = (com.igexin.push.core.bean.n) r8;	 Catch:{ Exception -> 0x007b }
        r8 = r8.b();	 Catch:{ Exception -> 0x007b }
        r6.put(r7, r8);	 Catch:{ Exception -> 0x007b }
        r7 = "version";	 Catch:{ Exception -> 0x007b }
        r8 = r0.get(r5);	 Catch:{ Exception -> 0x007b }
        r8 = (com.igexin.push.core.bean.n) r8;	 Catch:{ Exception -> 0x007b }
        r8 = r8.c();	 Catch:{ Exception -> 0x007b }
        r6.put(r7, r8);	 Catch:{ Exception -> 0x007b }
        r7 = "versionName";	 Catch:{ Exception -> 0x007b }
        r8 = r0.get(r5);	 Catch:{ Exception -> 0x007b }
        r8 = (com.igexin.push.core.bean.n) r8;	 Catch:{ Exception -> 0x007b }
        r8 = r8.a();	 Catch:{ Exception -> 0x007b }
        r6.put(r7, r8);	 Catch:{ Exception -> 0x007b }
        r3.put(r6);	 Catch:{ Exception -> 0x007b }
        r5 = r5 + 1;	 Catch:{ Exception -> 0x007b }
        goto L_0x002d;	 Catch:{ Exception -> 0x007b }
    L_0x0076:
        r0 = "applist";	 Catch:{ Exception -> 0x007b }
        r1.put(r0, r3);	 Catch:{ Exception -> 0x007b }
    L_0x007b:
        r0 = new com.igexin.push.f.a.c;
        r3 = new com.igexin.push.core.c.a;
        r4 = com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl();
        r1 = r1.toString();
        r1 = r1.getBytes();
        r3.<init>(r4, r1);
        r0.<init>(r3);
        r1 = com.igexin.b.a.b.c.b();
        r3 = 1;
        r1.a(r0, r2, r3);
        r0 = r9.o();
        r9.f(r0);
        r0 = "reportapplist";
        com.igexin.b.a.c.a.b(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.n():void");
    }

    public String o() {
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        a(arrayList2);
        int size = arrayList2.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                arrayList.add(((n) arrayList2.get(i)).d());
            }
        }
        return arrayList.toString();
    }

    public boolean p() {
        return false;
    }

    public void q() {
        long currentTimeMillis = System.currentTimeMillis() - 604800000;
        StringBuilder stringBuilder = new StringBuilder("createtime <= ");
        stringBuilder.append(currentTimeMillis);
        com.igexin.push.core.f.a().k().a("message", stringBuilder.toString());
    }

    public void r() {
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
        r15 = this;
        r0 = new java.text.SimpleDateFormat;
        r1 = "yyyy-MM-dd";
        r2 = java.util.Locale.getDefault();
        r0.<init>(r1, r2);
        r1 = new java.util.Date;
        r1.<init>();
        r1 = r0.format(r1);
        r2 = "/sdcard/libs//";
        r3 = new java.io.File;
        r3.<init>(r2);
        r4 = com.igexin.push.core.g.e;
        if (r4 != 0) goto L_0x0021;
    L_0x001f:
        r4 = "unknowPacageName";
    L_0x0021:
        r5 = r3.exists();
        if (r5 != 0) goto L_0x0028;
    L_0x0027:
        return;
    L_0x0028:
        r3 = r3.list();
        r5 = 0;
        r6 = r3.length;
        r7 = r5;
    L_0x002f:
        if (r7 >= r6) goto L_0x00af;
    L_0x0031:
        r8 = r3[r7];
        r8 = r8.length();
        r9 = r3[r7];
        r9 = r9.startsWith(r4);
        if (r9 == 0) goto L_0x00ac;
    L_0x003f:
        r9 = r3[r7];
        r10 = ".log";
        r9 = r9.endsWith(r10);
        if (r9 == 0) goto L_0x00ac;
    L_0x0049:
        r9 = r4.length();
        r9 = r9 + 14;
        if (r8 <= r9) goto L_0x00ac;
    L_0x0051:
        r9 = r3[r7];
        r10 = r8 + -15;
        r9 = r9.substring(r5, r10);
        r9 = r4.equals(r9);
        if (r9 == 0) goto L_0x00ac;
    L_0x005f:
        r9 = r3[r7];
        r10 = r4.length();
        r10 = r10 + 1;
        r8 = r8 + -4;
        r8 = r9.substring(r10, r8);
        r8 = r0.parse(r8);	 Catch:{ Exception -> 0x00ac }
        r9 = r0.parse(r1);	 Catch:{ Exception -> 0x00ac }
        r9 = r9.getTime();	 Catch:{ Exception -> 0x00ac }
        r11 = r8.getTime();	 Catch:{ Exception -> 0x00ac }
        r13 = r9 - r11;	 Catch:{ Exception -> 0x00ac }
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ Exception -> 0x00ac }
        r13 = r13 / r8;	 Catch:{ Exception -> 0x00ac }
        r8 = java.lang.Math.abs(r13);	 Catch:{ Exception -> 0x00ac }
        r10 = 6;	 Catch:{ Exception -> 0x00ac }
        r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ Exception -> 0x00ac }
        if (r12 <= 0) goto L_0x00ac;	 Catch:{ Exception -> 0x00ac }
    L_0x008d:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x00ac }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ac }
        r9.<init>();	 Catch:{ Exception -> 0x00ac }
        r9.append(r2);	 Catch:{ Exception -> 0x00ac }
        r10 = r3[r7];	 Catch:{ Exception -> 0x00ac }
        r9.append(r10);	 Catch:{ Exception -> 0x00ac }
        r9 = r9.toString();	 Catch:{ Exception -> 0x00ac }
        r8.<init>(r9);	 Catch:{ Exception -> 0x00ac }
        r9 = r8.exists();	 Catch:{ Exception -> 0x00ac }
        if (r9 == 0) goto L_0x00ac;	 Catch:{ Exception -> 0x00ac }
    L_0x00a9:
        r8.delete();	 Catch:{ Exception -> 0x00ac }
    L_0x00ac:
        r7 = r7 + 1;
        goto L_0x002f;
    L_0x00af:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.r():void");
    }

    public void s() {
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
        r11 = this;
        r0 = r11.F();	 Catch:{ Exception -> 0x0148 }
        if (r0 == 0) goto L_0x0007;	 Catch:{ Exception -> 0x0148 }
    L_0x0006:
        return;	 Catch:{ Exception -> 0x0148 }
    L_0x0007:
        r0 = "CoreAction--------checkConditionStatus start to read pushMessageMap data...";	 Catch:{ Exception -> 0x0148 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ Exception -> 0x0148 }
        r0 = com.igexin.push.core.g.ai;	 Catch:{ Exception -> 0x0148 }
        r0 = r0.entrySet();	 Catch:{ Exception -> 0x0148 }
        r0 = r0.iterator();	 Catch:{ Exception -> 0x0148 }
    L_0x0016:
        r1 = r0.hasNext();	 Catch:{ Exception -> 0x0148 }
        if (r1 == 0) goto L_0x0147;	 Catch:{ Exception -> 0x0148 }
    L_0x001c:
        r1 = r0.next();	 Catch:{ Exception -> 0x0148 }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ Exception -> 0x0148 }
        r2 = r1.getKey();	 Catch:{ Exception -> 0x0148 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0148 }
        r1 = r1.getValue();	 Catch:{ Exception -> 0x0148 }
        r1 = (com.igexin.push.core.bean.PushTaskBean) r1;	 Catch:{ Exception -> 0x0148 }
        r3 = "";	 Catch:{ Exception -> 0x0148 }
        if (r1 == 0) goto L_0x0016;	 Catch:{ Exception -> 0x0148 }
    L_0x0032:
        r4 = r1.getStatus();	 Catch:{ Exception -> 0x0148 }
        r5 = com.igexin.push.core.a.k;	 Catch:{ Exception -> 0x0148 }
        if (r4 != r5) goto L_0x0016;	 Catch:{ Exception -> 0x0148 }
    L_0x003a:
        r4 = r1.getTaskId();	 Catch:{ Exception -> 0x0148 }
        r5 = r1.getConditionMap();	 Catch:{ Exception -> 0x0148 }
        if (r5 != 0) goto L_0x0045;	 Catch:{ Exception -> 0x0148 }
    L_0x0044:
        return;	 Catch:{ Exception -> 0x0148 }
    L_0x0045:
        r6 = "endTime";	 Catch:{ Exception -> 0x0148 }
        r6 = r5.containsKey(r6);	 Catch:{ Exception -> 0x0148 }
        if (r6 == 0) goto L_0x0070;	 Catch:{ Exception -> 0x0148 }
    L_0x004d:
        r6 = "endTime";	 Catch:{ Exception -> 0x0148 }
        r6 = r5.get(r6);	 Catch:{ Exception -> 0x0148 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0148 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x0148 }
        r6 = r6.longValue();	 Catch:{ Exception -> 0x0148 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0148 }
        r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));	 Catch:{ Exception -> 0x0148 }
        if (r10 >= 0) goto L_0x0070;	 Catch:{ Exception -> 0x0148 }
    L_0x0065:
        r3 = com.igexin.push.core.a.m;	 Catch:{ Exception -> 0x0148 }
        r11.a(r3, r4, r2);	 Catch:{ Exception -> 0x0148 }
        r2 = com.igexin.push.core.a.l;	 Catch:{ Exception -> 0x0148 }
    L_0x006c:
        r1.setStatus(r2);	 Catch:{ Exception -> 0x0148 }
        goto L_0x0016;	 Catch:{ Exception -> 0x0148 }
    L_0x0070:
        r6 = "wifi";	 Catch:{ Exception -> 0x0148 }
        r6 = r5.containsKey(r6);	 Catch:{ Exception -> 0x0148 }
        if (r6 == 0) goto L_0x008f;	 Catch:{ Exception -> 0x0148 }
    L_0x0078:
        r6 = "wifi";	 Catch:{ Exception -> 0x0148 }
        r6 = r5.get(r6);	 Catch:{ Exception -> 0x0148 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0148 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0148 }
        r6 = r6.intValue();	 Catch:{ Exception -> 0x0148 }
        r11.v();	 Catch:{ Exception -> 0x0148 }
        r7 = com.igexin.push.core.g.o;	 Catch:{ Exception -> 0x0148 }
        if (r6 != r7) goto L_0x0016;	 Catch:{ Exception -> 0x0148 }
    L_0x008f:
        r6 = "screenOn";	 Catch:{ Exception -> 0x0148 }
        r6 = r5.containsKey(r6);	 Catch:{ Exception -> 0x0148 }
        if (r6 == 0) goto L_0x00ae;	 Catch:{ Exception -> 0x0148 }
    L_0x0097:
        r6 = "screenOn";	 Catch:{ Exception -> 0x0148 }
        r6 = r5.get(r6);	 Catch:{ Exception -> 0x0148 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0148 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0148 }
        r6 = r6.intValue();	 Catch:{ Exception -> 0x0148 }
        r11.u();	 Catch:{ Exception -> 0x0148 }
        r7 = com.igexin.push.core.g.p;	 Catch:{ Exception -> 0x0148 }
        if (r6 != r7) goto L_0x0016;	 Catch:{ Exception -> 0x0148 }
    L_0x00ae:
        r6 = "ssid";	 Catch:{ Exception -> 0x0148 }
        r6 = r5.containsKey(r6);	 Catch:{ Exception -> 0x0148 }
        if (r6 == 0) goto L_0x00c9;	 Catch:{ Exception -> 0x0148 }
    L_0x00b6:
        r3 = "ssid";	 Catch:{ Exception -> 0x0148 }
        r3 = r5.get(r3);	 Catch:{ Exception -> 0x0148 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0148 }
        r11.w();	 Catch:{ Exception -> 0x0148 }
        r6 = com.igexin.push.core.g.ao;	 Catch:{ Exception -> 0x0148 }
        r6 = r6.containsValue(r3);	 Catch:{ Exception -> 0x0148 }
        if (r6 == 0) goto L_0x0016;	 Catch:{ Exception -> 0x0148 }
    L_0x00c9:
        r6 = "bssid";	 Catch:{ Exception -> 0x0148 }
        r6 = r5.containsKey(r6);	 Catch:{ Exception -> 0x0148 }
        if (r6 == 0) goto L_0x00ef;	 Catch:{ Exception -> 0x0148 }
    L_0x00d1:
        r6 = "bssid";	 Catch:{ Exception -> 0x0148 }
        r6 = r5.get(r6);	 Catch:{ Exception -> 0x0148 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0148 }
        r7 = com.igexin.push.core.g.ao;	 Catch:{ Exception -> 0x0148 }
        r7 = r7.containsKey(r6);	 Catch:{ Exception -> 0x0148 }
        if (r7 == 0) goto L_0x0016;	 Catch:{ Exception -> 0x0148 }
    L_0x00e1:
        r7 = com.igexin.push.core.g.ao;	 Catch:{ Exception -> 0x0148 }
        r6 = r7.get(r6);	 Catch:{ Exception -> 0x0148 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0148 }
        r3 = r6.equals(r3);	 Catch:{ Exception -> 0x0148 }
        if (r3 == 0) goto L_0x0016;	 Catch:{ Exception -> 0x0148 }
    L_0x00ef:
        r3 = "startTime";	 Catch:{ Exception -> 0x0148 }
        r3 = r5.containsKey(r3);	 Catch:{ Exception -> 0x0148 }
        if (r3 == 0) goto L_0x010f;	 Catch:{ Exception -> 0x0148 }
    L_0x00f7:
        r3 = "startTime";	 Catch:{ Exception -> 0x0148 }
        r3 = r5.get(r3);	 Catch:{ Exception -> 0x0148 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0148 }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ Exception -> 0x0148 }
        r6 = r3.longValue();	 Catch:{ Exception -> 0x0148 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0148 }
        r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));	 Catch:{ Exception -> 0x0148 }
        if (r3 > 0) goto L_0x0016;	 Catch:{ Exception -> 0x0148 }
    L_0x010f:
        r3 = "netConnected";	 Catch:{ Exception -> 0x0148 }
        r3 = r5.containsKey(r3);	 Catch:{ Exception -> 0x0148 }
        if (r3 == 0) goto L_0x012f;
    L_0x0117:
        r3 = "netConnected";	 Catch:{ Exception -> 0x0016 }
        r3 = r5.get(r3);	 Catch:{ Exception -> 0x0016 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0016 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0016 }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x0016 }
        r5 = com.igexin.push.util.a.g();	 Catch:{ Exception -> 0x0016 }
        if (r3 == r5) goto L_0x012f;
    L_0x012d:
        goto L_0x0016;
    L_0x012f:
        r3 = r1.getMessageId();	 Catch:{ Exception -> 0x0148 }
        r5 = a();	 Catch:{ Exception -> 0x0148 }
        r6 = com.igexin.push.core.g.a;	 Catch:{ Exception -> 0x0148 }
        r7 = com.igexin.push.core.g.e;	 Catch:{ Exception -> 0x0148 }
        r5.b(r4, r3, r6, r7);	 Catch:{ Exception -> 0x0148 }
        r3 = com.igexin.push.core.a.l;	 Catch:{ Exception -> 0x0148 }
        r11.a(r3, r4, r2);	 Catch:{ Exception -> 0x0148 }
        r2 = com.igexin.push.core.a.l;	 Catch:{ Exception -> 0x0148 }
        goto L_0x006c;
    L_0x0147:
        return;
    L_0x0148:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r2 = "CoreAction|";
        r1.<init>(r2);
        r0 = r0.toString();
        r1.append(r0);
        r0 = r1.toString();
        com.igexin.b.a.c.a.b(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.s():void");
    }

    public boolean t() {
        long currentTimeMillis = System.currentTimeMillis();
        if (com.igexin.push.core.g.I <= 0) {
            com.igexin.push.core.g.I = currentTimeMillis - 60000;
            return true;
        } else if (currentTimeMillis - com.igexin.push.core.g.I <= 60000) {
            return false;
        } else {
            com.igexin.push.core.g.I = currentTimeMillis;
            return true;
        }
    }

    public void u() {
        com.igexin.push.core.g.p = ((PowerManager) com.igexin.push.core.g.f.getSystemService("power")).isScreenOn() ? 1 : 0;
    }

    public void v() {
        State state = ((ConnectivityManager) com.igexin.push.core.g.f.getSystemService("connectivity")).getNetworkInfo(1).getState();
        if (state != State.CONNECTED) {
            if (state != State.CONNECTING) {
                com.igexin.push.core.g.o = 0;
                return;
            }
        }
        com.igexin.push.core.g.o = 1;
    }

    public void w() {
        try {
            List scanResults = ((WifiManager) com.igexin.push.core.g.f.getSystemService("wifi")).getScanResults();
            com.igexin.push.core.g.ao.clear();
            if (!(scanResults == null || scanResults.isEmpty())) {
                for (int i = 0; i < scanResults.size(); i++) {
                    com.igexin.push.core.g.ao.put(((ScanResult) scanResults.get(i)).BSSID, ((ScanResult) scanResults.get(i)).SSID);
                }
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("CoreAction|");
            stringBuilder.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
        }
    }

    public void x() {
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
        r10 = this;
        r0 = com.igexin.push.config.m.p;
        if (r0 == 0) goto L_0x0084;
    L_0x0004:
        r0 = java.lang.System.currentTimeMillis();
        r2 = r10.d;
        r4 = r0 - r2;
        r0 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x0014;
    L_0x0013:
        return;
    L_0x0014:
        r0 = java.lang.System.currentTimeMillis();
        r10.d = r0;
        r0 = com.igexin.push.core.b.g.a();
        r0 = r0.d();
        r1 = r0.isEmpty();
        if (r1 != 0) goto L_0x0084;
    L_0x0028:
        r1 = com.igexin.push.config.m.E;
        if (r1 > 0) goto L_0x002d;
    L_0x002c:
        return;
    L_0x002d:
        r1 = 0;
        r0 = r0.entrySet();
        r0 = r0.iterator();
    L_0x0036:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0084;
    L_0x003c:
        r2 = r0.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = com.igexin.push.config.m.E;
        if (r1 >= r3) goto L_0x0084;
    L_0x0046:
        r3 = r2.getKey();
        r8 = r3;
        r8 = (java.lang.String) r8;
        r2 = r2.getValue();
        r9 = r2;
        r9 = (java.lang.String) r9;
        r2 = com.igexin.push.config.m.G;
        if (r2 == 0) goto L_0x007e;
    L_0x0058:
        r2 = "com.igexin.sdk.GActivity";
        r2 = com.igexin.push.util.a.a(r8, r2);
        if (r2 == 0) goto L_0x007e;
    L_0x0060:
        r2 = new java.util.Random;	 Catch:{ Exception -> 0x0081 }
        r2.<init>();	 Catch:{ Exception -> 0x0081 }
        r3 = 6;	 Catch:{ Exception -> 0x0081 }
        r2 = r2.nextInt(r3);	 Catch:{ Exception -> 0x0081 }
        r3 = 1;	 Catch:{ Exception -> 0x0081 }
        r3 = r3 + r2;	 Catch:{ Exception -> 0x0081 }
        r3 = r3 * 1000;	 Catch:{ Exception -> 0x0081 }
        r2 = new com.igexin.push.core.a.i;	 Catch:{ Exception -> 0x0081 }
        r6 = (long) r3;	 Catch:{ Exception -> 0x0081 }
        r4 = r2;	 Catch:{ Exception -> 0x0081 }
        r5 = r10;	 Catch:{ Exception -> 0x0081 }
        r4.<init>(r5, r6, r8, r9);	 Catch:{ Exception -> 0x0081 }
        r3 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x0081 }
        r3.a(r2);	 Catch:{ Exception -> 0x0081 }
        goto L_0x0081;
    L_0x007e:
        r10.h(r8, r9);
    L_0x0081:
        r1 = r1 + 1;
        goto L_0x0036;
    L_0x0084:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.f.x():void");
    }

    public void y() {
        int i = com.igexin.push.core.g.an - 100;
        if (i < 0) {
            i = 0;
        }
        com.igexin.push.core.g.an = i;
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = com.igexin.push.core.g.am.entrySet().iterator();
        while (it.hasNext()) {
            if (currentTimeMillis - ((Long) ((Entry) it.next()).getValue()).longValue() > 3600000) {
                it.remove();
            }
        }
    }

    public void z() {
        if (com.igexin.push.core.g.P < System.currentTimeMillis()) {
            com.igexin.push.core.b.g.a().a(false);
        }
    }
}
