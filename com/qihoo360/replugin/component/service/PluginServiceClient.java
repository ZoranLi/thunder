package com.qihoo360.replugin.component.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import com.qihoo360.i.Factory;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.ComponentList;
import com.qihoo360.replugin.component.utils.PluginClientHelper;

public class PluginServiceClient {
    private static b a = new b();
    private static a b = new a();
    private static Handler c = new Handler(Looper.getMainLooper());
    private static Messenger d = new Messenger(c);

    public static ComponentName startService(Context context, Intent intent) {
        return startService(context, intent, false);
    }

    public static boolean stopService(Context context, Intent intent) {
        return stopService(context, intent, false);
    }

    public static boolean stopService(android.content.Context r3, android.content.Intent r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.getComponent();
        r0 = com.qihoo360.replugin.component.utils.PluginClientHelper.a(r3, r0);
        r1 = a(r0);
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r1 != r2) goto L_0x0035;
    L_0x0011:
        r0 = com.qihoo360.replugin.b.c.a;
        if (r0 == 0) goto L_0x0028;
    L_0x0015:
        r0 = "ws001";
        r1 = new java.lang.StringBuilder;
        r2 = "PSS.stopService(): Call SystemAPI: in=";
        r1.<init>(r2);
        r1.append(r4);
        r1 = r1.toString();
        com.qihoo360.replugin.b.c.a(r0, r1);
    L_0x0028:
        if (r5 == 0) goto L_0x0030;
    L_0x002a:
        r3 = new com.qihoo360.replugin.component.utils.PluginClientHelper$ShouldCallSystem;
        r3.<init>();
        throw r3;
    L_0x0030:
        r3 = r3.stopService(r4);
        return r3;
    L_0x0035:
        r4.setComponent(r0);
        r3 = a;
        r3 = r3.a(r1);
        r5 = 0;
        if (r3 != 0) goto L_0x0042;
    L_0x0041:
        return r5;
    L_0x0042:
        r0 = d;	 Catch:{ Throwable -> 0x004d }
        r3 = r3.b(r4, r0);	 Catch:{ Throwable -> 0x004d }
        if (r3 == 0) goto L_0x004c;
    L_0x004a:
        r3 = 1;
        return r3;
    L_0x004c:
        return r5;
    L_0x004d:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.service.PluginServiceClient.stopService(android.content.Context, android.content.Intent, boolean):boolean");
    }

    public static boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return bindService(context, intent, serviceConnection, i, false);
    }

    public static boolean bindService(android.content.Context r7, android.content.Intent r8, android.content.ServiceConnection r9, int r10, boolean r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r8.getComponent();
        r0 = com.qihoo360.replugin.component.utils.PluginClientHelper.a(r7, r0);
        r6 = a(r0);
        r1 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r6 != r1) goto L_0x0035;
    L_0x0011:
        r0 = com.qihoo360.replugin.b.c.a;
        if (r0 == 0) goto L_0x0028;
    L_0x0015:
        r0 = "ws001";
        r1 = new java.lang.StringBuilder;
        r2 = "PSS.bindService(): Call SystemAPI: in=";
        r1.<init>(r2);
        r1.append(r8);
        r1 = r1.toString();
        com.qihoo360.replugin.b.c.a(r0, r1);
    L_0x0028:
        if (r11 == 0) goto L_0x0030;
    L_0x002a:
        r7 = new com.qihoo360.replugin.component.utils.PluginClientHelper$ShouldCallSystem;
        r7.<init>();
        throw r7;
    L_0x0030:
        r7 = r7.bindService(r8, r9, r10);
        return r7;
    L_0x0035:
        r8.setComponent(r0);
        r11 = a;
        r11 = r11.a(r6);
        r0 = 0;
        if (r11 != 0) goto L_0x0042;
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = b;	 Catch:{ Throwable -> 0x005a }
        r4 = c;	 Catch:{ Throwable -> 0x005a }
        r2 = r9;	 Catch:{ Throwable -> 0x005a }
        r3 = r7;	 Catch:{ Throwable -> 0x005a }
        r5 = r10;	 Catch:{ Throwable -> 0x005a }
        r7 = r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x005a }
        r7 = r7.a;	 Catch:{ Throwable -> 0x005a }
        r9 = d;	 Catch:{ Throwable -> 0x005a }
        r7 = r11.a(r8, r7, r10, r9);	 Catch:{ Throwable -> 0x005a }
        if (r7 == 0) goto L_0x0059;
    L_0x0057:
        r7 = 1;
        return r7;
    L_0x0059:
        return r0;
    L_0x005a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.service.PluginServiceClient.bindService(android.content.Context, android.content.Intent, android.content.ServiceConnection, int, boolean):boolean");
    }

    public static boolean unbindService(Context context, ServiceConnection serviceConnection) {
        return unbindService(context, serviceConnection, true);
    }

    public static boolean unbindService(android.content.Context r2, android.content.ServiceConnection r3, boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r4 == 0) goto L_0x001c;
    L_0x0002:
        r4 = com.qihoo360.replugin.b.c.a;	 Catch:{ Throwable -> 0x001c }
        if (r4 == 0) goto L_0x0019;	 Catch:{ Throwable -> 0x001c }
    L_0x0006:
        r4 = "ws001";	 Catch:{ Throwable -> 0x001c }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x001c }
        r1 = "PSS.unbindService(): First, We call SystemAPI: sc=";	 Catch:{ Throwable -> 0x001c }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x001c }
        r0.append(r3);	 Catch:{ Throwable -> 0x001c }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x001c }
        com.qihoo360.replugin.b.c.a(r4, r0);	 Catch:{ Throwable -> 0x001c }
    L_0x0019:
        r2.unbindService(r3);	 Catch:{ Throwable -> 0x001c }
    L_0x001c:
        r4 = b;
        r2 = r4.a(r2, r3);
        r3 = 0;
        if (r2 != 0) goto L_0x0026;
    L_0x0025:
        return r3;
    L_0x0026:
        r4 = a;
        r0 = r2.f;
        r4 = r4.a(r0);
        if (r4 != 0) goto L_0x0031;
    L_0x0030:
        return r3;
    L_0x0031:
        r2 = r2.a;	 Catch:{ Throwable -> 0x0038 }
        r2 = r4.a(r2);	 Catch:{ Throwable -> 0x0038 }
        return r2;
    L_0x0038:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.service.PluginServiceClient.unbindService(android.content.Context, android.content.ServiceConnection, boolean):boolean");
    }

    public static void stopSelf(android.app.Service r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new android.content.Intent;
        r1 = r2.getClass();
        r0.<init>(r2, r1);
        r2 = com.qihoo360.loader2.n.b;	 Catch:{ Throwable -> 0x0016 }
        r2 = r2.m;	 Catch:{ Throwable -> 0x0016 }
        r2 = r2.c();	 Catch:{ Throwable -> 0x0016 }
        r1 = 0;	 Catch:{ Throwable -> 0x0016 }
        r2.b(r0, r1);	 Catch:{ Throwable -> 0x0016 }
        return;
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.service.PluginServiceClient.stopSelf(android.app.Service):void");
    }

    private static int a(ComponentName componentName) {
        if (componentName == null) {
            return Integer.MAX_VALUE;
        }
        String packageName = componentName.getPackageName();
        ComponentList queryPluginComponentList = Factory.queryPluginComponentList(packageName);
        if (queryPluginComponentList == null) {
            componentName = c.a;
            return Integer.MAX_VALUE;
        }
        componentName = queryPluginComponentList.getService(componentName.getClassName());
        if (componentName == null) {
            componentName = c.a;
            return Integer.MAX_VALUE;
        }
        componentName = PluginClientHelper.a(componentName.processName).intValue();
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("getProcessByComponentName(): Okay! Process=");
            stringBuilder.append(componentName);
            stringBuilder.append("; pn=");
            stringBuilder.append(packageName);
        }
        return componentName;
    }

    public static android.content.ComponentName startService(android.content.Context r4, android.content.Intent r5, boolean r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.getClassLoader();
        r0 = com.qihoo360.i.Factory.fetchPluginName(r0);
        r1 = r5.getComponent();
        r2 = 0;
        if (r1 == 0) goto L_0x0018;
    L_0x000f:
        r0 = r5.getComponent();
        r0 = com.qihoo360.replugin.component.utils.PluginClientHelper.a(r4, r0);
        goto L_0x004b;
    L_0x0018:
        r1 = r5.getAction();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x003f;
    L_0x0022:
        r0 = com.qihoo360.i.Factory.queryPluginComponentList(r0);
        if (r0 == 0) goto L_0x004a;
    L_0x0028:
        r0 = r0.getServiceAndPluginByIntent(r4, r5);
        if (r0 == 0) goto L_0x004a;
    L_0x002e:
        r1 = new android.content.ComponentName;
        r3 = r0.second;
        r3 = (java.lang.String) r3;
        r0 = r0.first;
        r0 = (android.content.pm.ServiceInfo) r0;
        r0 = r0.name;
        r1.<init>(r3, r0);
        r0 = r1;
        goto L_0x004b;
    L_0x003f:
        r0 = com.qihoo360.replugin.b.c.a;
        if (r0 == 0) goto L_0x004a;
    L_0x0043:
        r0 = "ws001";
        r1 = "PSS.startService(): No Component and no Action";
        com.qihoo360.replugin.b.c.a(r0, r1);
    L_0x004a:
        r0 = r2;
    L_0x004b:
        r1 = a(r0);
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r1 != r3) goto L_0x0078;
    L_0x0054:
        r0 = com.qihoo360.replugin.b.c.a;
        if (r0 == 0) goto L_0x006b;
    L_0x0058:
        r0 = "ws001";
        r1 = new java.lang.StringBuilder;
        r2 = "PSS.startService(): Call SystemAPI: in=";
        r1.<init>(r2);
        r1.append(r5);
        r1 = r1.toString();
        com.qihoo360.replugin.b.c.a(r0, r1);
    L_0x006b:
        if (r6 == 0) goto L_0x0073;
    L_0x006d:
        r4 = new com.qihoo360.replugin.component.utils.PluginClientHelper$ShouldCallSystem;
        r4.<init>();
        throw r4;
    L_0x0073:
        r4 = r4.startService(r5);
        return r4;
    L_0x0078:
        r5.setComponent(r0);
        r4 = a;
        r4 = r4.a(r1);
        if (r4 != 0) goto L_0x0084;
    L_0x0083:
        return r2;
    L_0x0084:
        r6 = d;	 Catch:{ Throwable -> 0x008b }
        r4 = r4.a(r5, r6);	 Catch:{ Throwable -> 0x008b }
        return r4;
    L_0x008b:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.service.PluginServiceClient.startService(android.content.Context, android.content.Intent, boolean):android.content.ComponentName");
    }
}
