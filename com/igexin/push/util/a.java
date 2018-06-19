package com.igexin.push.util;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Process;
import com.igexin.push.config.m;
import com.igexin.push.core.bean.c;
import com.igexin.push.core.bean.f;
import com.igexin.push.core.bean.g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    private static final String a = "com.igexin.push.util.a";

    public static java.lang.String a(android.content.Context r3) {
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
        r0 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0027 }
        r1 = "activity";	 Catch:{ Throwable -> 0x0027 }
        r3 = r3.getSystemService(r1);	 Catch:{ Throwable -> 0x0027 }
        r3 = (android.app.ActivityManager) r3;	 Catch:{ Throwable -> 0x0027 }
        r3 = r3.getRunningAppProcesses();	 Catch:{ Throwable -> 0x0027 }
        r3 = r3.iterator();	 Catch:{ Throwable -> 0x0027 }
    L_0x0014:
        r1 = r3.hasNext();	 Catch:{ Throwable -> 0x0027 }
        if (r1 == 0) goto L_0x0027;	 Catch:{ Throwable -> 0x0027 }
    L_0x001a:
        r1 = r3.next();	 Catch:{ Throwable -> 0x0027 }
        r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1;	 Catch:{ Throwable -> 0x0027 }
        r2 = r1.pid;	 Catch:{ Throwable -> 0x0027 }
        if (r2 != r0) goto L_0x0014;	 Catch:{ Throwable -> 0x0027 }
    L_0x0024:
        r3 = r1.processName;	 Catch:{ Throwable -> 0x0027 }
        return r3;
    L_0x0027:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.a(android.content.Context):java.lang.String");
    }

    public static void a(g gVar) {
        com.igexin.push.core.g.ap = 0;
        com.igexin.push.core.g.aq = 0;
        com.igexin.push.core.g.as = gVar;
        Map b = gVar.b();
        if (m.s != null) {
            Map b2 = m.s.b();
            List<Integer> arrayList = new ArrayList();
            for (Entry entry : b2.entrySet()) {
                int intValue = ((Integer) entry.getKey()).intValue();
                f fVar = (f) entry.getValue();
                if (!b.containsKey(Integer.valueOf(intValue))) {
                    com.igexin.push.core.g.at = true;
                    e.b(fVar.c());
                    arrayList.add(Integer.valueOf(intValue));
                }
            }
            if (!arrayList.isEmpty()) {
                for (Integer intValue2 : arrayList) {
                    b2.remove(Integer.valueOf(intValue2.intValue()));
                }
                com.igexin.push.config.a.a().g();
            }
            boolean z = true;
            for (Entry entry2 : b.entrySet()) {
                int intValue3 = ((Integer) entry2.getKey()).intValue();
                f fVar2 = (f) entry2.getValue();
                if (b2.containsKey(Integer.valueOf(intValue3))) {
                    if (!((f) b2.get(Integer.valueOf(intValue3))).b().equals(fVar2.b())) {
                        com.igexin.push.core.g.at = true;
                    }
                }
                com.igexin.push.core.g.ap++;
                e.a(fVar2);
                z = false;
            }
            if (z) {
                m.s.a(gVar.a());
                com.igexin.push.config.a.a().g();
                Process.killProcess(Process.myPid());
            }
            return;
        }
        for (Entry value : b.entrySet()) {
            f fVar3 = (f) value.getValue();
            com.igexin.push.core.g.ap++;
            e.a(fVar3);
        }
    }

    private static void a(Map<String, c> map, String str) {
        c cVar = (c) map.get(str);
        map.remove(str);
        for (String str2 : cVar.b()) {
            c cVar2 = (c) map.get(str2);
            if (cVar2 != null) {
                cVar2.e();
                if (cVar2.c() == 0) {
                    a((Map) map, str2);
                }
            }
        }
    }

    public static boolean a() {
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
        r0 = 0;
        r1 = "none";	 Catch:{ Exception -> 0x005c }
        r2 = com.igexin.push.config.m.t;	 Catch:{ Exception -> 0x005c }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x005c }
        if (r1 != 0) goto L_0x005c;	 Catch:{ Exception -> 0x005c }
    L_0x000b:
        r1 = com.igexin.push.config.m.t;	 Catch:{ Exception -> 0x005c }
        r2 = ",";	 Catch:{ Exception -> 0x005c }
        r1 = r1.split(r2);	 Catch:{ Exception -> 0x005c }
        r2 = r1.length;	 Catch:{ Exception -> 0x005c }
        r3 = r0;	 Catch:{ Exception -> 0x005c }
    L_0x0015:
        if (r3 >= r2) goto L_0x0023;	 Catch:{ Exception -> 0x005c }
    L_0x0017:
        r4 = r1[r3];	 Catch:{ Exception -> 0x005c }
        r4 = b(r4);	 Catch:{ Exception -> 0x005c }
        if (r4 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x005c }
    L_0x001f:
        return r0;	 Catch:{ Exception -> 0x005c }
    L_0x0020:
        r3 = r3 + 1;	 Catch:{ Exception -> 0x005c }
        goto L_0x0015;	 Catch:{ Exception -> 0x005c }
    L_0x0023:
        r1 = "none";	 Catch:{ Exception -> 0x005c }
        r2 = com.igexin.push.config.m.u;	 Catch:{ Exception -> 0x005c }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x005c }
        if (r1 != 0) goto L_0x005c;	 Catch:{ Exception -> 0x005c }
    L_0x002d:
        r1 = com.igexin.push.config.m.u;	 Catch:{ Exception -> 0x005c }
        r2 = ",";	 Catch:{ Exception -> 0x005c }
        r1 = r1.split(r2);	 Catch:{ Exception -> 0x005c }
        r2 = "android.os.ServiceManager";	 Catch:{ Exception -> 0x005c }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x005c }
        r3 = "getService";	 Catch:{ Exception -> 0x005c }
        r4 = 1;	 Catch:{ Exception -> 0x005c }
        r5 = new java.lang.Class[r4];	 Catch:{ Exception -> 0x005c }
        r6 = java.lang.String.class;	 Catch:{ Exception -> 0x005c }
        r5[r0] = r6;	 Catch:{ Exception -> 0x005c }
        r3 = r2.getMethod(r3, r5);	 Catch:{ Exception -> 0x005c }
        r3.setAccessible(r4);	 Catch:{ Exception -> 0x005c }
        r5 = r1.length;	 Catch:{ Exception -> 0x005c }
        r6 = r0;	 Catch:{ Exception -> 0x005c }
    L_0x004d:
        if (r6 >= r5) goto L_0x005b;	 Catch:{ Exception -> 0x005c }
    L_0x004f:
        r7 = r1[r6];	 Catch:{ Exception -> 0x005c }
        r7 = a(r2, r3, r7);	 Catch:{ Exception -> 0x005c }
        if (r7 == 0) goto L_0x0058;
    L_0x0057:
        return r0;
    L_0x0058:
        r6 = r6 + 1;
        goto L_0x004d;
    L_0x005b:
        return r4;
    L_0x005c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.a():boolean");
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

    public static boolean a(Context context, Class cls) {
        if (context == null) {
            return false;
        }
        try {
            StringBuilder stringBuilder;
            PackageManager packageManager = context.getPackageManager();
            List queryIntentActivities = packageManager.queryIntentActivities(new Intent(context, cls), 0);
            if (queryIntentActivities != null) {
                if (queryIntentActivities.size() > 0) {
                    if (packageManager.getActivityInfo(new ComponentName(context.getPackageName(), cls.getName()), 128).theme == 16973840) {
                        return true;
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(cls.getName());
                    stringBuilder.append(" need set theme Theme.Translucent.NoTitleBar");
                    return false;
                }
            }
            stringBuilder = new StringBuilder("not regist ");
            stringBuilder.append(cls.getName());
            stringBuilder.append("in manifest");
            return false;
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|");
            stringBuilder2.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
            return false;
        }
    }

    public static boolean a(android.content.Intent r1, android.content.Context r2) {
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
        r0 = 0;
        if (r1 == 0) goto L_0x0018;
    L_0x0003:
        if (r2 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r2 = r2.getPackageManager();	 Catch:{ Throwable -> 0x0018 }
        r1 = r2.queryIntentServices(r1, r0);	 Catch:{ Throwable -> 0x0018 }
        if (r1 == 0) goto L_0x0018;	 Catch:{ Throwable -> 0x0018 }
    L_0x0010:
        r1 = r1.size();	 Catch:{ Throwable -> 0x0018 }
        if (r1 <= 0) goto L_0x0018;
    L_0x0016:
        r1 = 1;
        return r1;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.a(android.content.Intent, android.content.Context):boolean");
    }

    public static boolean a(ServiceInfo serviceInfo, PackageInfo packageInfo) {
        if (!(com.igexin.push.core.a.o.equals(serviceInfo.name) || com.igexin.push.core.a.n.equals(serviceInfo.name))) {
            if (!com.igexin.push.core.a.p.equals(serviceInfo.name)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(java.lang.Class<?> r3, java.lang.reflect.Method r4, java.lang.String r5) {
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
        r0 = 1;
        r1 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x000e }
        r2 = 0;	 Catch:{ Exception -> 0x000e }
        r1[r2] = r5;	 Catch:{ Exception -> 0x000e }
        r3 = r4.invoke(r3, r1);	 Catch:{ Exception -> 0x000e }
        if (r3 == 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        return r2;
    L_0x000e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.a(java.lang.Class, java.lang.reflect.Method, java.lang.String):boolean");
    }

    public static boolean a(java.lang.String r2) {
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
        r0 = 0;
        r1 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x000f }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x000f }
        r2 = r1.getLaunchIntentForPackage(r2);	 Catch:{ Exception -> 0x000f }
        if (r2 == 0) goto L_0x000f;
    L_0x000d:
        r2 = 1;
        return r2;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.a(java.lang.String):boolean");
    }

    public static <T extends Service> boolean a(String str, Context context, Class<T> cls) {
        if (cls == null) {
            try {
                if (!b(new Intent(context, Class.forName(com.igexin.push.core.a.n)), context)) {
                    return false;
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("|");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                return false;
            }
        }
        if (cls != null && com.igexin.push.core.a.n.equals(cls.getName()) && !b(new Intent(context, cls), context)) {
            return false;
        }
        if (cls == null || b(new Intent(context, cls), context)) {
            if (cls != null) {
                Class.forName(cls.getName());
            }
            return true;
        }
        StringBuilder stringBuilder2 = new StringBuilder("call - > initialize, parameter [userServiceName] is set, but didn't find class \"");
        stringBuilder2.append(cls.getName());
        stringBuilder2.append("\", please check your AndroidManifest");
        return false;
    }

    public static boolean a(java.lang.String r2, java.lang.String r3) {
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
        r0 = 0;
        r1 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0024 }
        if (r1 != 0) goto L_0x0024;	 Catch:{ Exception -> 0x0024 }
    L_0x0007:
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0024 }
        if (r1 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x0024 }
    L_0x000d:
        return r0;	 Catch:{ Exception -> 0x0024 }
    L_0x000e:
        r1 = new android.content.Intent;	 Catch:{ Exception -> 0x0024 }
        r1.<init>();	 Catch:{ Exception -> 0x0024 }
        r1.setClassName(r2, r3);	 Catch:{ Exception -> 0x0024 }
        r2 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x0024 }
        r2 = r2.getPackageManager();	 Catch:{ Exception -> 0x0024 }
        r2 = r2.resolveActivity(r1, r0);	 Catch:{ Exception -> 0x0024 }
        if (r2 == 0) goto L_0x0024;
    L_0x0022:
        r2 = 1;
        return r2;
    L_0x0024:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.a(java.lang.String, java.lang.String):boolean");
    }

    public static boolean a(JSONObject jSONObject) {
        try {
            c cVar;
            Map hashMap = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                cVar = new c();
                if (jSONObject2.has("actionid")) {
                    cVar.a(jSONObject2.getString("actionid"));
                    List arrayList = new ArrayList();
                    if (jSONObject2.has("type")) {
                        Object string;
                        String string2 = jSONObject2.getString("type");
                        if (AgooConstants.MESSAGE_POPUP.equals(string2)) {
                            if (jSONObject2.has("buttons")) {
                                JSONArray jSONArray2 = jSONObject2.getJSONArray("buttons");
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    if (((JSONObject) jSONArray2.get(i2)).has("do")) {
                                        arrayList.add(((JSONObject) jSONArray2.get(i2)).getString("do"));
                                    }
                                }
                            }
                            if (jSONObject2.has("do")) {
                                string = jSONObject2.getString("do");
                            }
                            cVar.a(arrayList);
                            hashMap.put(cVar.a(), cVar);
                        } else if ("startapp".equals(string2)) {
                            if (jSONObject2.has("noinstall_action")) {
                                arrayList.add(jSONObject2.getString("noinstall_action"));
                            }
                            if (jSONObject2.has("do")) {
                                string = jSONObject2.getString("do");
                            }
                            cVar.a(arrayList);
                            hashMap.put(cVar.a(), cVar);
                        } else if ("checkapp".equals(string2)) {
                            if (jSONObject2.has("do_installed")) {
                                arrayList.add(jSONObject2.getString("do_installed"));
                            }
                            if (jSONObject2.has("do_uninstalled")) {
                                string = jSONObject2.getString("do_uninstalled");
                            }
                            cVar.a(arrayList);
                            hashMap.put(cVar.a(), cVar);
                        } else if ("checkversions".equals(string2)) {
                            if (jSONObject2.has("do_match")) {
                                arrayList.add(jSONObject2.getString("do_match"));
                            }
                            if (jSONObject2.has("do_dismatch")) {
                                arrayList.add(jSONObject2.getString("do_dismatch"));
                            }
                            if (jSONObject2.has("do")) {
                                string = jSONObject2.getString("do");
                            }
                            cVar.a(arrayList);
                            hashMap.put(cVar.a(), cVar);
                        } else if ("startintent".equals(string2)) {
                            if (jSONObject2.has("do_failed")) {
                                arrayList.add(jSONObject2.getString("do_failed"));
                            }
                            if (jSONObject2.has("do")) {
                                string = jSONObject2.getString("do");
                            }
                            cVar.a(arrayList);
                            hashMap.put(cVar.a(), cVar);
                        } else {
                            if (!"null".equals(string2) && jSONObject2.has("do")) {
                                string = jSONObject2.getString("do");
                            }
                            cVar.a(arrayList);
                            hashMap.put(cVar.a(), cVar);
                        }
                        arrayList.add(string);
                        cVar.a(arrayList);
                        hashMap.put(cVar.a(), cVar);
                    }
                }
            }
            List<c> arrayList2 = new ArrayList(hashMap.values());
            for (Entry value : hashMap.entrySet()) {
                List<String> b = ((c) value.getValue()).b();
                if (b != null) {
                    for (String str : b) {
                        cVar = (c) hashMap.get(str);
                        if (cVar != null) {
                            cVar.d();
                            if (arrayList2.contains(cVar)) {
                                arrayList2.remove(cVar);
                            }
                        }
                    }
                }
            }
            for (c a : arrayList2) {
                a(hashMap, a.a());
            }
            if (hashMap.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("|action_chains have loop nodeMap not empty");
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                return true;
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|isHaveLoop exception :");
            stringBuilder2.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
        }
        return false;
    }

    public static boolean b() {
        return System.currentTimeMillis() > m.c;
    }

    public static boolean b(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            return queryIntentServices != null && queryIntentServices.size() > 0;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|");
            stringBuilder.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            return false;
        }
    }

    private static boolean b(java.lang.String r2) {
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
        r0 = 0;
        r1 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x000c }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x000c }
        r1.getPackageInfo(r2, r0);	 Catch:{ Exception -> 0x000c }
        r2 = 1;
        return r2;
    L_0x000c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.b(java.lang.String):boolean");
    }

    public static boolean c() {
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
        r0 = 0;
        r1 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x001e }
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x001e }
        r2 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x001e }
        r2 = r2.getPackageName();	 Catch:{ Throwable -> 0x001e }
        r3 = "android.permission.ACCESS_WIFI_STATE";	 Catch:{ Throwable -> 0x001e }
        r3 = r1.checkPermission(r3, r2);	 Catch:{ Throwable -> 0x001e }
        if (r3 != 0) goto L_0x001e;	 Catch:{ Throwable -> 0x001e }
    L_0x0015:
        r3 = "android.permission.CHANGE_WIFI_STATE";	 Catch:{ Throwable -> 0x001e }
        r1 = r1.checkPermission(r3, r2);	 Catch:{ Throwable -> 0x001e }
        if (r1 != 0) goto L_0x001e;
    L_0x001d:
        r0 = 1;
    L_0x001e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.c():boolean");
    }

    public static boolean d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.igexin.push.core.g.f.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean e() {
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
        r0 = "android.support.v4.content.LocalBroadcastManager";	 Catch:{ Exception -> 0x0007 }
        java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0007 }
        r0 = 1;
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.e():boolean");
    }

    public static boolean f() {
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
        r0 = com.igexin.push.config.m.L;	 Catch:{ Throwable -> 0x0023 }
        r1 = ",";	 Catch:{ Throwable -> 0x0023 }
        r0 = r0.split(r1);	 Catch:{ Throwable -> 0x0023 }
        r1 = r0.length;	 Catch:{ Throwable -> 0x0023 }
        r2 = 0;	 Catch:{ Throwable -> 0x0023 }
        r3 = r2;	 Catch:{ Throwable -> 0x0023 }
    L_0x000b:
        if (r3 >= r1) goto L_0x0023;	 Catch:{ Throwable -> 0x0023 }
    L_0x000d:
        r4 = r0[r3];	 Catch:{ Throwable -> 0x0023 }
        r5 = android.os.Build.MODEL;	 Catch:{ Throwable -> 0x0023 }
        r5 = r5.toLowerCase();	 Catch:{ Throwable -> 0x0023 }
        r4 = r4.toLowerCase();	 Catch:{ Throwable -> 0x0023 }
        r4 = r5.contains(r4);	 Catch:{ Throwable -> 0x0023 }
        if (r4 == 0) goto L_0x0020;
    L_0x001f:
        return r2;
    L_0x0020:
        r3 = r3 + 1;
        goto L_0x000b;
    L_0x0023:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.f():boolean");
    }

    public static boolean g() {
        ConnectivityManager j = com.igexin.push.core.f.a().j();
        if (j == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = j.getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getState() != State.CONNECTED) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|type = ");
        String str = activeNetworkInfo.getType() == 0 ? "mobile" : activeNetworkInfo.getType() == 1 ? "wifi" : "none";
        stringBuilder.append(str);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        return true;
    }

    public static boolean h() {
        return System.currentTimeMillis() >= 1182566108138L;
    }
}
