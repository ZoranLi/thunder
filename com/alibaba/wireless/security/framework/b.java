package com.alibaba.wireless.security.framework;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.wireless.security.framework.a.c;
import com.alibaba.wireless.security.open.IRouterComponent;
import com.alibaba.wireless.security.open.SecException;
import com.alipay.sdk.util.h;
import com.qihoo360.replugin.RePlugin;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;

public class b {
    private static b d;
    HashMap<Class, Object> a = new HashMap();
    IRouterComponent b = null;
    com.alibaba.wireless.security.framework.b.b c = null;
    private Context e;
    private final HashMap<String, c> f = new HashMap();
    private int g = 0;
    private File h = null;
    private int i;
    private boolean j = true;
    private String k = null;

    private interface a {
        void a(int i, Class<? extends Service> cls);
    }

    private b(Context context) {
        this.e = context.getApplicationContext();
        this.k = null;
        this.h = this.e.getDir("SGLib", 0);
        Context context2 = this.e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.h);
        stringBuilder.append(File.separator);
        stringBuilder.append("lock.lock");
        this.c = new com.alibaba.wireless.security.framework.b.b(context2, stringBuilder.toString());
    }

    private int a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length < split2.length ? split.length : split2.length;
        for (int i = 0; i < length; i++) {
            int parseInt = Integer.parseInt(split[i]);
            int parseInt2 = Integer.parseInt(split2[i]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    private android.content.res.Resources a(android.content.res.AssetManager r4) {
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
        r0 = r3.e;	 Catch:{ Exception -> 0x0014 }
        r0 = r0.getResources();	 Catch:{ Exception -> 0x0014 }
        r1 = new android.content.res.Resources;	 Catch:{ Exception -> 0x0014 }
        r2 = r0.getDisplayMetrics();	 Catch:{ Exception -> 0x0014 }
        r0 = r0.getConfiguration();	 Catch:{ Exception -> 0x0014 }
        r1.<init>(r4, r2, r0);	 Catch:{ Exception -> 0x0014 }
        return r1;
    L_0x0014:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.a(android.content.res.AssetManager):android.content.res.Resources");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.alibaba.wireless.security.framework.a.c a(java.lang.String r20, java.lang.String r21, android.content.Context r22, java.lang.String r23) throws com.alibaba.wireless.security.open.SecException {
        /*
        r19 = this;
        r1 = r19;
        r2 = r20;
        r3 = r21;
        r4 = r22;
        r5 = 1;
        r1.g = r5;
        r6 = java.lang.System.currentTimeMillis();
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0239 }
        r10 = r1.e;	 Catch:{ all -> 0x0239 }
        r10 = r10.getPackageManager();	 Catch:{ all -> 0x0239 }
        r11 = 133; // 0x85 float:1.86E-43 double:6.57E-322;
        r10 = r10.getPackageArchiveInfo(r3, r11);	 Catch:{ all -> 0x0239 }
        r11 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        if (r10 != 0) goto L_0x002e;
    L_0x0023:
        r3 = new com.alibaba.wireless.security.open.SecException;	 Catch:{ all -> 0x0029 }
        r3.<init>(r11);	 Catch:{ all -> 0x0029 }
        throw r3;	 Catch:{ all -> 0x0029 }
    L_0x0029:
        r0 = move-exception;
        r3 = r0;
        r15 = r6;
        goto L_0x023c;
    L_0x002e:
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0239 }
        r13 = "    getPackageArchiveInfo( ";
        r12.<init>(r13);	 Catch:{ all -> 0x0239 }
        r12.append(r3);	 Catch:{ all -> 0x0239 }
        r13 = " ) used time: ";
        r12.append(r13);	 Catch:{ all -> 0x0239 }
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0239 }
        r15 = r6;
        r5 = r13 - r8;
        r12.append(r5);	 Catch:{ all -> 0x0237 }
        r5 = " ms";
        r12.append(r5);	 Catch:{ all -> 0x0237 }
        r5 = r12.toString();	 Catch:{ all -> 0x0237 }
        com.alibaba.wireless.security.framework.b.a.b(r5);	 Catch:{ all -> 0x0237 }
        r5 = r10.versionName;	 Catch:{ all -> 0x0237 }
        r6 = r10.applicationInfo;	 Catch:{ all -> 0x0237 }
        r6 = r6.metaData;	 Catch:{ all -> 0x0237 }
        r7 = "dependencies";
        r6 = r6.getString(r7);	 Catch:{ all -> 0x0237 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0237 }
        r7.<init>();	 Catch:{ all -> 0x0237 }
        r7.append(r2);	 Catch:{ all -> 0x0237 }
        r8 = "(";
        r7.append(r8);	 Catch:{ all -> 0x0237 }
        r7.append(r5);	 Catch:{ all -> 0x0237 }
        r8 = ")";
        r7.append(r8);	 Catch:{ all -> 0x0237 }
        r7 = r7.toString();	 Catch:{ all -> 0x0237 }
        r8 = r23.length();	 Catch:{ all -> 0x0237 }
        if (r8 != 0) goto L_0x007f;
    L_0x007e:
        goto L_0x0095;
    L_0x007f:
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0237 }
        r8.<init>();	 Catch:{ all -> 0x0237 }
        r9 = r23;
        r8.append(r9);	 Catch:{ all -> 0x0237 }
        r9 = "->";
        r8.append(r9);	 Catch:{ all -> 0x0237 }
        r8.append(r7);	 Catch:{ all -> 0x0237 }
        r7 = r8.toString();	 Catch:{ all -> 0x0237 }
    L_0x0095:
        r8 = 0;
        r6 = r1.a(r6, r7, r8);	 Catch:{ all -> 0x0237 }
        if (r6 != 0) goto L_0x00a2;
    L_0x009c:
        r3 = new com.alibaba.wireless.security.open.SecException;	 Catch:{ all -> 0x0237 }
        r3.<init>(r11);	 Catch:{ all -> 0x0237 }
        throw r3;	 Catch:{ all -> 0x0237 }
    L_0x00a2:
        r6 = r10.applicationInfo;	 Catch:{ all -> 0x0237 }
        r6 = r6.metaData;	 Catch:{ all -> 0x0237 }
        r7 = "pluginid";
        r6 = r6.getInt(r7);	 Catch:{ all -> 0x0237 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0237 }
        r9 = "libsg";
        r7.<init>(r9);	 Catch:{ all -> 0x0237 }
        r7.append(r2);	 Catch:{ all -> 0x0237 }
        r9 = "so-";
        r7.append(r9);	 Catch:{ all -> 0x0237 }
        r7.append(r5);	 Catch:{ all -> 0x0237 }
        r9 = ".so";
        r7.append(r9);	 Catch:{ all -> 0x0237 }
        r7 = r7.toString();	 Catch:{ all -> 0x0237 }
        r9 = r1.h;	 Catch:{ all -> 0x0237 }
        r9 = r9.getAbsolutePath();	 Catch:{ all -> 0x0237 }
        r9 = r1.a(r3, r9, r7);	 Catch:{ all -> 0x0237 }
        if (r9 != 0) goto L_0x00d9;
    L_0x00d3:
        r3 = new com.alibaba.wireless.security.open.SecException;	 Catch:{ all -> 0x0237 }
        r3.<init>(r11);	 Catch:{ all -> 0x0237 }
        throw r3;	 Catch:{ all -> 0x0237 }
    L_0x00d9:
        r9 = r10.applicationInfo;	 Catch:{ all -> 0x0237 }
        r9 = r9.metaData;	 Catch:{ all -> 0x0237 }
        r12 = "pluginclass";
        r9 = r9.getString(r12);	 Catch:{ all -> 0x0237 }
        if (r9 != 0) goto L_0x00eb;
    L_0x00e5:
        r3 = new com.alibaba.wireless.security.open.SecException;	 Catch:{ all -> 0x0237 }
        r3.<init>(r11);	 Catch:{ all -> 0x0237 }
        throw r3;	 Catch:{ all -> 0x0237 }
    L_0x00eb:
        r9 = r9.trim();	 Catch:{ all -> 0x0237 }
        r12 = r1.d(r3);	 Catch:{ all -> 0x0237 }
        r13 = r1.a(r12, r9);	 Catch:{ all -> 0x0237 }
        if (r13 != 0) goto L_0x0115;
    L_0x00f9:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0237 }
        r4 = "load ";
        r3.<init>(r4);	 Catch:{ all -> 0x0237 }
        r3.append(r9);	 Catch:{ all -> 0x0237 }
        r4 = " failed from plugin ";
        r3.append(r4);	 Catch:{ all -> 0x0237 }
        r3 = r3.toString();	 Catch:{ all -> 0x0237 }
        com.alibaba.wireless.security.framework.b.a.b(r3);	 Catch:{ all -> 0x0237 }
        r3 = new com.alibaba.wireless.security.open.SecException;	 Catch:{ all -> 0x0237 }
        r3.<init>(r11);	 Catch:{ all -> 0x0237 }
        throw r3;	 Catch:{ all -> 0x0237 }
    L_0x0115:
        r9 = 0;
        r11 = r13.newInstance();	 Catch:{ InstantiationException -> 0x020c, IllegalAccessException -> 0x0203, SecException -> 0x01c2 }
        r11 = (com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin) r11;	 Catch:{ InstantiationException -> 0x020c, IllegalAccessException -> 0x0203, SecException -> 0x01c2 }
        r3 = r1.e(r3);	 Catch:{ InstantiationException -> 0x020c, IllegalAccessException -> 0x0203, SecException -> 0x01c2 }
        r3 = r1.a(r3);	 Catch:{ InstantiationException -> 0x020c, IllegalAccessException -> 0x0203, SecException -> 0x01c2 }
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ InstantiationException -> 0x020c, IllegalAccessException -> 0x0203, SecException -> 0x01c2 }
        r8 = new com.alibaba.wireless.security.framework.a.c;	 Catch:{ InstantiationException -> 0x020c, IllegalAccessException -> 0x0203, SecException -> 0x01c2 }
        r8.<init>(r12, r3, r10, r11);	 Catch:{ InstantiationException -> 0x020c, IllegalAccessException -> 0x0203, SecException -> 0x01c2 }
        r3 = r1.b;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01c2 }
        r3 = r11.onPluginLoaded(r4, r3, r10, r9);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01c2 }
        r9 = 1;
        if (r6 != r9) goto L_0x014d;
    L_0x0136:
        r1.b = r3;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x0147 }
        r3 = new java.lang.Object[r9];	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x0147 }
        r9 = r1.j;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x0147 }
        r9 = java.lang.Boolean.valueOf(r9);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x0147 }
        r10 = 0;
        r3[r10] = r9;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x0147 }
        r11.init(r4, r3);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x0147 }
        goto L_0x014d;
    L_0x0147:
        r0 = move-exception;
        r3 = r0;
        r18 = r7;
        goto L_0x01c6;
    L_0x014d:
        r3 = new java.lang.StringBuilder;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01c2 }
        r4 = "    onPluginLoaded( ";
        r3.<init>(r4);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01c2 }
        r3.append(r2);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01c2 }
        r4 = " ) used time: ";
        r3.append(r4);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01c2 }
        r9 = java.lang.System.currentTimeMillis();	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01c2 }
        r17 = r6;
        r18 = r7;
        r6 = r9 - r13;
        r3.append(r6);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r4 = " ms";
        r3.append(r4);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r3 = r3.toString();	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        com.alibaba.wireless.security.framework.b.a.b(r3);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r3 = new java.lang.StringBuilder;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r4 = "sg";
        r3.<init>(r4);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r3.append(r2);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r4 = "so-";
        r3.append(r4);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r3.append(r5);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r3 = r3.toString();	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r3 = com.alibaba.wireless.security.framework.h.a(r12, r3);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r4 = new java.lang.StringBuilder;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r6 = "so full path: ";
        r4.<init>(r6);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r4.append(r3);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r4 = r4.toString();	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        com.alibaba.wireless.security.framework.b.a.b(r4);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r4 = 3;
        r12 = new java.lang.String[r4];	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r4 = 0;
        r12[r4] = r2;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r6 = 1;
        r12[r6] = r5;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r5 = 2;
        r12[r5] = r3;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r11 = new int[r6];	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r11[r4] = r17;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r9 = r1.b;	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        r10 = 10102; // 0x2776 float:1.4156E-41 double:4.991E-320;
        r13 = 0;
        r14 = 0;
        r9.doCommandNative(r10, r11, r12, r13, r14);	 Catch:{ InstantiationException -> 0x01bf, IllegalAccessException -> 0x01bc, SecException -> 0x01ba }
        goto L_0x0212;
    L_0x01ba:
        r0 = move-exception;
        goto L_0x01c5;
    L_0x01bc:
        r0 = move-exception;
        r3 = r0;
        goto L_0x0206;
    L_0x01bf:
        r0 = move-exception;
        r3 = r0;
        goto L_0x020f;
    L_0x01c2:
        r0 = move-exception;
        r18 = r7;
    L_0x01c5:
        r3 = r0;
    L_0x01c6:
        r4 = r3.getErrorCode();	 Catch:{ all -> 0x0237 }
        r5 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        if (r4 != r5) goto L_0x0202;
    L_0x01ce:
        r4 = new java.io.File;	 Catch:{ all -> 0x0237 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0237 }
        r5.<init>();	 Catch:{ all -> 0x0237 }
        r6 = r1.h;	 Catch:{ all -> 0x0237 }
        r6 = r6.getAbsolutePath();	 Catch:{ all -> 0x0237 }
        r5.append(r6);	 Catch:{ all -> 0x0237 }
        r6 = java.io.File.separator;	 Catch:{ all -> 0x0237 }
        r5.append(r6);	 Catch:{ all -> 0x0237 }
        r6 = r18;
        r5.append(r6);	 Catch:{ all -> 0x0237 }
        r5 = r5.toString();	 Catch:{ all -> 0x0237 }
        r4.<init>(r5);	 Catch:{ all -> 0x0237 }
        r5 = r1.c;	 Catch:{ all -> 0x0237 }
        r5.a();	 Catch:{ all -> 0x0237 }
        r5 = r4.exists();	 Catch:{ all -> 0x0237 }
        if (r5 == 0) goto L_0x01fd;
    L_0x01fa:
        r4.delete();	 Catch:{ all -> 0x0237 }
    L_0x01fd:
        r4 = r1.c;	 Catch:{ all -> 0x0237 }
        r4.b();	 Catch:{ all -> 0x0237 }
    L_0x0202:
        throw r3;	 Catch:{ all -> 0x0237 }
    L_0x0203:
        r0 = move-exception;
        r3 = r0;
        r8 = r9;
    L_0x0206:
        r4 = "";
    L_0x0208:
        com.alibaba.wireless.security.framework.b.a.a(r4, r3);	 Catch:{ all -> 0x0237 }
        goto L_0x0212;
    L_0x020c:
        r0 = move-exception;
        r3 = r0;
        r8 = r9;
    L_0x020f:
        r4 = "";
        goto L_0x0208;
    L_0x0212:
        r3 = new java.lang.StringBuilder;
        r4 = "loadApk( ";
        r3.<init>(r4);
        r3.append(r2);
        r2 = " ) used time: ";
        r3.append(r2);
        r4 = java.lang.System.currentTimeMillis();
        r6 = r4 - r15;
        r3.append(r6);
        r2 = " ms";
        r3.append(r2);
        r2 = r3.toString();
        com.alibaba.wireless.security.framework.b.a.b(r2);
        return r8;
    L_0x0237:
        r0 = move-exception;
        goto L_0x023b;
    L_0x0239:
        r0 = move-exception;
        r15 = r6;
    L_0x023b:
        r3 = r0;
    L_0x023c:
        r4 = new java.lang.StringBuilder;
        r5 = "loadApk( ";
        r4.<init>(r5);
        r4.append(r2);
        r2 = " ) used time: ";
        r4.append(r2);
        r5 = java.lang.System.currentTimeMillis();
        r7 = r5 - r15;
        r4.append(r7);
        r2 = " ms";
        r4.append(r2);
        r2 = r4.toString();
        com.alibaba.wireless.security.framework.b.a.b(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.a(java.lang.String, java.lang.String, android.content.Context, java.lang.String):com.alibaba.wireless.security.framework.a.c");
    }

    public static b a(Context context) {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b(context);
                }
            }
        }
        return d;
    }

    private Class<?> a(ClassLoader classLoader, String str) {
        Class<?> cls;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        StringBuilder stringBuilder = new StringBuilder("    loadPluginClass( ");
        stringBuilder.append(str);
        stringBuilder.append(" ) used time: ");
        stringBuilder.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuilder.append(" ms");
        com.alibaba.wireless.security.framework.b.a.b(stringBuilder.toString());
        return cls;
    }

    private String a(a aVar, c cVar) {
        String b = aVar.b();
        if (b == null) {
            b = cVar.b;
        }
        if (!b.startsWith(".")) {
            return b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aVar.a());
        stringBuilder.append(b);
        return stringBuilder.toString();
    }

    private void a(a aVar, a aVar2) {
        String a = aVar.a();
        if (TextUtils.isEmpty(a)) {
            throw new NullPointerException("disallow null packageName.");
        }
        c b = b(a);
        if (b == null) {
            aVar2.a(1, null);
            return;
        }
        String b2 = aVar.b();
        Class a2 = a(b.c, b2);
        if (a2 == null) {
            aVar2.a(2, null);
            return;
        }
        a2 = c(a2);
        if (a2 == null) {
            aVar2.a(3, null);
            return;
        }
        aVar.putExtra("extra.class", b2);
        aVar.putExtra("extra.package", a);
        aVar2.a(0, a2);
    }

    private boolean a(File file) {
        try {
            return file.getAbsolutePath().equals(file.getCanonicalPath()) ^ 1;
        } catch (Throwable e) {
            com.alibaba.wireless.security.framework.b.a.a("", e);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.io.File r12, java.io.File r13) {
        /*
        r11 = this;
        r0 = 0;
        if (r12 == 0) goto L_0x00ff;
    L_0x0003:
        if (r13 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
        r3.<init>();	 Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
        r4 = r13.getAbsolutePath();	 Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
        r3.append(r4);	 Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
        r4 = ".tmp";
        r3.append(r4);	 Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
        r3 = r2.exists();	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
        if (r3 == 0) goto L_0x002a;
    L_0x0027:
        r2.delete();	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
    L_0x002a:
        r3 = r13.exists();	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
        if (r3 == 0) goto L_0x0033;
    L_0x0030:
        r13.delete();	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
    L_0x0033:
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
        r3.<init>(r12);	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
        r3 = r3.getChannel();	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
        r4 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r10 = r4.getChannel();	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r6 = 0;
        r8 = r3.size();	 Catch:{ Exception -> 0x0090, all -> 0x008e }
        r4 = r10;
        r5 = r3;
        r4.transferFrom(r5, r6, r8);	 Catch:{ Exception -> 0x0090, all -> 0x008e }
        r4 = 1;
        r3.close();	 Catch:{ Exception -> 0x0056, all -> 0x008e }
        r3 = r4;
        goto L_0x005d;
    L_0x0056:
        r5 = move-exception;
        r6 = "";
        com.alibaba.wireless.security.framework.b.a.a(r6, r5);	 Catch:{ Exception -> 0x0090, all -> 0x008e }
        r3 = r0;
    L_0x005d:
        r10.close();	 Catch:{ Exception -> 0x0064, all -> 0x0061 }
        goto L_0x006b;
    L_0x0061:
        r12 = move-exception;
        goto L_0x00da;
    L_0x0064:
        r4 = move-exception;
        r5 = "";
        com.alibaba.wireless.security.framework.b.a.a(r5, r4);	 Catch:{ Exception -> 0x008b, all -> 0x0061 }
        r4 = r0;
    L_0x006b:
        if (r3 == 0) goto L_0x0087;
    L_0x006d:
        if (r4 == 0) goto L_0x0087;
    L_0x006f:
        r3 = r2.exists();	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
        if (r3 == 0) goto L_0x0087;
    L_0x0075:
        r3 = r2.length();	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
        r5 = r12.length();	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
        r12 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r12 != 0) goto L_0x0087;
    L_0x0081:
        r12 = r2.renameTo(r13);	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
        r0 = r12;
        return r0;
    L_0x0087:
        r2.delete();	 Catch:{ Exception -> 0x009b, all -> 0x0098 }
        return r0;
    L_0x008b:
        r12 = move-exception;
        r3 = r1;
        goto L_0x009e;
    L_0x008e:
        r12 = move-exception;
        goto L_0x00d9;
    L_0x0090:
        r12 = move-exception;
        goto L_0x009e;
    L_0x0092:
        r12 = move-exception;
        r10 = r1;
        goto L_0x00d9;
    L_0x0095:
        r12 = move-exception;
        r10 = r1;
        goto L_0x009e;
    L_0x0098:
        r12 = move-exception;
        r10 = r1;
        goto L_0x00da;
    L_0x009b:
        r12 = move-exception;
        r3 = r1;
        r10 = r3;
    L_0x009e:
        r1 = r2;
        goto L_0x00a7;
    L_0x00a0:
        r12 = move-exception;
        r2 = r1;
        r10 = r2;
        goto L_0x00da;
    L_0x00a4:
        r12 = move-exception;
        r3 = r1;
        r10 = r3;
    L_0x00a7:
        r2 = "";
        com.alibaba.wireless.security.framework.b.a.a(r2, r12);	 Catch:{ all -> 0x00d7 }
        r1.delete();	 Catch:{ all -> 0x00d7 }
        r13.delete();	 Catch:{ all -> 0x00d7 }
        if (r3 == 0) goto L_0x00c4;
    L_0x00b4:
        r3.close();	 Catch:{ Exception -> 0x00b8 }
        goto L_0x00c4;
    L_0x00b8:
        r12 = move-exception;
        r2 = "";
        com.alibaba.wireless.security.framework.b.a.a(r2, r12);
        r1.delete();
        r13.delete();
    L_0x00c4:
        if (r10 == 0) goto L_0x00d6;
    L_0x00c6:
        r10.close();	 Catch:{ Exception -> 0x00ca }
        return r0;
    L_0x00ca:
        r12 = move-exception;
        r2 = "";
        com.alibaba.wireless.security.framework.b.a.a(r2, r12);
        r1.delete();
        r13.delete();
    L_0x00d6:
        return r0;
    L_0x00d7:
        r12 = move-exception;
        r2 = r1;
    L_0x00d9:
        r1 = r3;
    L_0x00da:
        if (r1 == 0) goto L_0x00ec;
    L_0x00dc:
        r1.close();	 Catch:{ Exception -> 0x00e0 }
        goto L_0x00ec;
    L_0x00e0:
        r0 = move-exception;
        r1 = "";
        com.alibaba.wireless.security.framework.b.a.a(r1, r0);
        r2.delete();
        r13.delete();
    L_0x00ec:
        if (r10 == 0) goto L_0x00fe;
    L_0x00ee:
        r10.close();	 Catch:{ Exception -> 0x00f2 }
        goto L_0x00fe;
    L_0x00f2:
        r0 = move-exception;
        r1 = "";
        com.alibaba.wireless.security.framework.b.a.a(r1, r0);
        r2.delete();
        r13.delete();
    L_0x00fe:
        throw r12;
    L_0x00ff:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.a(java.io.File, java.io.File):boolean");
    }

    private synchronized boolean a(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
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
        monitor-enter(r10);
        r0 = r10.e;	 Catch:{ all -> 0x0179 }
        r0 = com.alibaba.wireless.security.framework.h.a(r0);	 Catch:{ all -> 0x0179 }
        r1 = 1;	 Catch:{ all -> 0x0179 }
        if (r0 == 0) goto L_0x0012;	 Catch:{ all -> 0x0179 }
    L_0x000a:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0179 }
        r2 = 19;
        if (r0 <= r2) goto L_0x0012;
    L_0x0010:
        monitor-exit(r10);
        return r1;
    L_0x0012:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0179 }
        r0 = r10.c;	 Catch:{ all -> 0x0179 }
        r0.a();	 Catch:{ all -> 0x0179 }
        r0 = 0;
        r4 = 0;
        r5 = new java.io.File;	 Catch:{ IOException -> 0x0116 }
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0116 }
        r6.<init>();	 Catch:{ IOException -> 0x0116 }
        r6.append(r12);	 Catch:{ IOException -> 0x0116 }
        r12 = java.io.File.separator;	 Catch:{ IOException -> 0x0116 }
        r6.append(r12);	 Catch:{ IOException -> 0x0116 }
        r6.append(r13);	 Catch:{ IOException -> 0x0116 }
        r12 = r6.toString();	 Catch:{ IOException -> 0x0116 }
        r5.<init>(r12);	 Catch:{ IOException -> 0x0116 }
        r12 = r5.exists();	 Catch:{ IOException -> 0x0116 }
        if (r12 == 0) goto L_0x0067;
    L_0x003c:
        r12 = r10.c;	 Catch:{ all -> 0x0179 }
        r12.b();	 Catch:{ all -> 0x0179 }
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0179 }
        r13 = "    extractSoInPlugin( ";	 Catch:{ all -> 0x0179 }
        r12.<init>(r13);	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r11 = " ) used time: ";	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0179 }
        r6 = r4 - r2;	 Catch:{ all -> 0x0179 }
        r12.append(r6);	 Catch:{ all -> 0x0179 }
        r11 = " ms";	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r11 = r12.toString();	 Catch:{ all -> 0x0179 }
        com.alibaba.wireless.security.framework.b.a.b(r11);	 Catch:{ all -> 0x0179 }
        monitor-exit(r10);
        return r1;
    L_0x0067:
        r12 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x0116 }
        r12.<init>(r11);	 Catch:{ IOException -> 0x0116 }
        r0 = 5;
        r6 = new java.lang.String[r0];	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r7 = "armeabi";	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r6[r4] = r7;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r7 = "armeabi-v7a";	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r6[r1] = r7;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r1 = 2;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r7 = "x86";	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r6[r1] = r7;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r1 = 3;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r7 = "arm64-v8a";	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r6[r1] = r7;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r1 = 4;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r7 = "x86_64";	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r6[r1] = r7;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r1 = r4;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
    L_0x0087:
        if (r1 >= r0) goto L_0x00e1;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
    L_0x0089:
        r7 = r6[r1];	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r9 = "lib";	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r8.<init>(r9);	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r9 = java.io.File.separator;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r8.append(r9);	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r8.append(r7);	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r7 = java.io.File.separator;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r8.append(r7);	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r8.append(r13);	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r7 = r8.toString();	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r7 = r12.getEntry(r7);	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        if (r7 == 0) goto L_0x00de;	 Catch:{ IOException -> 0x0110, all -> 0x010e }
    L_0x00ac:
        r13 = a(r12, r7, r5);	 Catch:{ IOException -> 0x0110, all -> 0x010e }
        r0 = r10.c;	 Catch:{ all -> 0x0179 }
        r0.b();	 Catch:{ all -> 0x0179 }
        r12.close();	 Catch:{ IOException -> 0x00b8 }
    L_0x00b8:
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0179 }
        r0 = "    extractSoInPlugin( ";	 Catch:{ all -> 0x0179 }
        r12.<init>(r0);	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r11 = " ) used time: ";	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0179 }
        r4 = r0 - r2;	 Catch:{ all -> 0x0179 }
        r12.append(r4);	 Catch:{ all -> 0x0179 }
        r11 = " ms";	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r11 = r12.toString();	 Catch:{ all -> 0x0179 }
        com.alibaba.wireless.security.framework.b.a.b(r11);	 Catch:{ all -> 0x0179 }
        monitor-exit(r10);
        return r13;
    L_0x00de:
        r1 = r1 + 1;
        goto L_0x0087;
    L_0x00e1:
        r13 = r10.c;	 Catch:{ all -> 0x0179 }
        r13.b();	 Catch:{ all -> 0x0179 }
        r12.close();	 Catch:{ IOException -> 0x00e9 }
    L_0x00e9:
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0179 }
        r13 = "    extractSoInPlugin( ";	 Catch:{ all -> 0x0179 }
        r12.<init>(r13);	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r11 = " ) used time: ";	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0179 }
        r5 = r0 - r2;	 Catch:{ all -> 0x0179 }
        r12.append(r5);	 Catch:{ all -> 0x0179 }
        r11 = " ms";	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r11 = r12.toString();	 Catch:{ all -> 0x0179 }
    L_0x010a:
        com.alibaba.wireless.security.framework.b.a.b(r11);	 Catch:{ all -> 0x0179 }
        goto L_0x0148;
    L_0x010e:
        r13 = move-exception;
        goto L_0x014a;
    L_0x0110:
        r13 = move-exception;
        r0 = r12;
        goto L_0x0117;
    L_0x0113:
        r13 = move-exception;
        r12 = r0;
        goto L_0x014a;
    L_0x0116:
        r13 = move-exception;
    L_0x0117:
        r12 = "";	 Catch:{ all -> 0x0113 }
        com.alibaba.wireless.security.framework.b.a.a(r12, r13);	 Catch:{ all -> 0x0113 }
        r12 = r10.c;	 Catch:{ all -> 0x0179 }
        r12.b();	 Catch:{ all -> 0x0179 }
        if (r0 == 0) goto L_0x0126;
    L_0x0123:
        r0.close();	 Catch:{ IOException -> 0x0126 }
    L_0x0126:
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0179 }
        r13 = "    extractSoInPlugin( ";	 Catch:{ all -> 0x0179 }
        r12.<init>(r13);	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r11 = " ) used time: ";	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0179 }
        r5 = r0 - r2;	 Catch:{ all -> 0x0179 }
        r12.append(r5);	 Catch:{ all -> 0x0179 }
        r11 = " ms";	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r11 = r12.toString();	 Catch:{ all -> 0x0179 }
        goto L_0x010a;
    L_0x0148:
        monitor-exit(r10);
        return r4;
    L_0x014a:
        r0 = r10.c;	 Catch:{ all -> 0x0179 }
        r0.b();	 Catch:{ all -> 0x0179 }
        if (r12 == 0) goto L_0x0154;
    L_0x0151:
        r12.close();	 Catch:{ IOException -> 0x0154 }
    L_0x0154:
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0179 }
        r0 = "    extractSoInPlugin( ";	 Catch:{ all -> 0x0179 }
        r12.<init>(r0);	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r11 = " ) used time: ";	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0179 }
        r4 = r0 - r2;	 Catch:{ all -> 0x0179 }
        r12.append(r4);	 Catch:{ all -> 0x0179 }
        r11 = " ms";	 Catch:{ all -> 0x0179 }
        r12.append(r11);	 Catch:{ all -> 0x0179 }
        r11 = r12.toString();	 Catch:{ all -> 0x0179 }
        com.alibaba.wireless.security.framework.b.a.b(r11);	 Catch:{ all -> 0x0179 }
        throw r13;	 Catch:{ all -> 0x0179 }
    L_0x0179:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private boolean a(String str, String str2, boolean z) throws SecException {
        if (str.trim().length() == 0) {
            return true;
        }
        String[] split = str.split(h.b);
        for (String trim : split) {
            String trim2 = trim2.trim();
            if (trim2.length() != 0) {
                String[] split2 = trim2.split(Constants.COLON_SEPARATOR);
                if (split2.length != 2) {
                    throw new SecException(199);
                }
                int indexOf = str2.indexOf(split2[0]);
                StringBuilder stringBuilder;
                StringBuilder stringBuilder2;
                if (indexOf >= 0) {
                    int indexOf2 = str2.indexOf(k.s, indexOf);
                    indexOf = str2.indexOf(k.t, indexOf);
                    if (indexOf2 >= 0 && indexOf >= 0) {
                        if (indexOf2 <= indexOf) {
                            String substring = str2.substring(indexOf2 + 1, indexOf);
                            if (a(substring, split2[1]) < 0) {
                                stringBuilder = new StringBuilder("version ");
                                stringBuilder.append(substring);
                                stringBuilder.append(" of ");
                                stringBuilder.append(split2[0]);
                                stringBuilder.append(" is not meet the requirement: ");
                                stringBuilder.append(split2[1]);
                                str = stringBuilder.toString();
                                if (str2.length() != 0) {
                                    stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(str);
                                    stringBuilder2.append(", depended by: ");
                                    stringBuilder2.append(str2);
                                    str = stringBuilder2.toString();
                                }
                                throw new SecException(str, 113);
                            }
                        }
                    }
                    throw new SecException(199);
                }
                c cVar = (c) this.f.get(split2[0]);
                if (cVar == null) {
                    cVar = c(split2[0], str2, z ^ 1);
                    if (cVar == null) {
                        if (!z) {
                            throw new SecException(str2, 199);
                        }
                    }
                }
                if (a(cVar.g.getVersion(), split2[1]) < 0) {
                    stringBuilder = new StringBuilder("version ");
                    stringBuilder.append(cVar.g.getVersion());
                    stringBuilder.append(" of ");
                    stringBuilder.append(split2[0]);
                    stringBuilder.append(" is not meet the requirement: ");
                    stringBuilder.append(split2[1]);
                    str = stringBuilder.toString();
                    if (str2.length() != 0) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str);
                        stringBuilder2.append(", depended by: ");
                        stringBuilder2.append(str2);
                        str = stringBuilder2.toString();
                    }
                    throw new SecException(str, 113);
                }
            }
        }
        return true;
    }

    public static boolean a(java.util.zip.ZipFile r8, java.util.zip.ZipEntry r9, java.io.File r10) {
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
        if (r8 == 0) goto L_0x00e6;
    L_0x0003:
        if (r9 == 0) goto L_0x00e6;
    L_0x0005:
        if (r10 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ Exception -> 0x00a3, all -> 0x009f }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a3, all -> 0x009f }
        r3.<init>();	 Catch:{ Exception -> 0x00a3, all -> 0x009f }
        r4 = r10.getAbsolutePath();	 Catch:{ Exception -> 0x00a3, all -> 0x009f }
        r3.append(r4);	 Catch:{ Exception -> 0x00a3, all -> 0x009f }
        r4 = ".tmp";	 Catch:{ Exception -> 0x00a3, all -> 0x009f }
        r3.append(r4);	 Catch:{ Exception -> 0x00a3, all -> 0x009f }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00a3, all -> 0x009f }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00a3, all -> 0x009f }
        r3 = r2.exists();	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        if (r3 == 0) goto L_0x002c;	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
    L_0x0029:
        r2.delete();	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
    L_0x002c:
        r3 = r10.exists();	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        if (r3 == 0) goto L_0x0035;	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
    L_0x0032:
        r10.delete();	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
    L_0x0035:
        r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        r8 = r8.getInputStream(r9);	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        r3.<init>(r8);	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        r8 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r4 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r8.<init>(r4);	 Catch:{ Exception -> 0x0094, all -> 0x0091 }
        r4 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r4 = new byte[r4];	 Catch:{ Exception -> 0x008b, all -> 0x0085 }
    L_0x004c:
        r5 = r3.read(r4);	 Catch:{ Exception -> 0x008b, all -> 0x0085 }
        r6 = -1;	 Catch:{ Exception -> 0x008b, all -> 0x0085 }
        if (r5 == r6) goto L_0x0057;	 Catch:{ Exception -> 0x008b, all -> 0x0085 }
    L_0x0053:
        r8.write(r4, r0, r5);	 Catch:{ Exception -> 0x008b, all -> 0x0085 }
        goto L_0x004c;
    L_0x0057:
        r4 = 1;
        r3.close();	 Catch:{ Exception -> 0x005d, all -> 0x0085 }
        r3 = r4;
        goto L_0x005e;
    L_0x005d:
        r3 = r0;
    L_0x005e:
        r8.close();	 Catch:{ Exception -> 0x0064, all -> 0x0062 }
        goto L_0x0065;
    L_0x0062:
        r9 = move-exception;
        goto L_0x0087;
    L_0x0064:
        r4 = r0;
    L_0x0065:
        if (r3 == 0) goto L_0x0081;
    L_0x0067:
        if (r4 == 0) goto L_0x0081;
    L_0x0069:
        r8 = r2.exists();	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        if (r8 == 0) goto L_0x0081;	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
    L_0x006f:
        r3 = r2.length();	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        r8 = r9.getSize();	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1));	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        if (r5 != 0) goto L_0x0081;	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
    L_0x007b:
        r8 = r2.renameTo(r10);	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        r0 = r8;	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        return r0;	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
    L_0x0081:
        r2.delete();	 Catch:{ Exception -> 0x009a, all -> 0x0097 }
        return r0;
    L_0x0085:
        r9 = move-exception;
        r1 = r3;
    L_0x0087:
        r7 = r9;
        r9 = r8;
        r8 = r7;
        goto L_0x00cd;
    L_0x008b:
        r9 = move-exception;
        r1 = r2;
        r7 = r9;
        r9 = r8;
        r8 = r7;
        goto L_0x00a6;
    L_0x0091:
        r8 = move-exception;
        r9 = r1;
        goto L_0x00cc;
    L_0x0094:
        r8 = move-exception;
        r9 = r1;
        goto L_0x009d;
    L_0x0097:
        r8 = move-exception;
        r9 = r1;
        goto L_0x00cd;
    L_0x009a:
        r8 = move-exception;
        r9 = r1;
        r3 = r9;
    L_0x009d:
        r1 = r2;
        goto L_0x00a6;
    L_0x009f:
        r8 = move-exception;
        r9 = r1;
        r2 = r9;
        goto L_0x00cd;
    L_0x00a3:
        r8 = move-exception;
        r9 = r1;
        r3 = r9;
    L_0x00a6:
        r2 = "";	 Catch:{ all -> 0x00ca }
        com.alibaba.wireless.security.framework.b.a.a(r2, r8);	 Catch:{ all -> 0x00ca }
        r1.delete();	 Catch:{ all -> 0x00ca }
        r10.delete();	 Catch:{ all -> 0x00ca }
        if (r3 == 0) goto L_0x00bd;
    L_0x00b3:
        r3.close();	 Catch:{ Exception -> 0x00b7 }
        goto L_0x00bd;
    L_0x00b7:
        r1.delete();
        r10.delete();
    L_0x00bd:
        if (r9 == 0) goto L_0x00c9;
    L_0x00bf:
        r9.close();	 Catch:{ Exception -> 0x00c3 }
        return r0;
    L_0x00c3:
        r1.delete();
        r10.delete();
    L_0x00c9:
        return r0;
    L_0x00ca:
        r8 = move-exception;
        r2 = r1;
    L_0x00cc:
        r1 = r3;
    L_0x00cd:
        if (r1 == 0) goto L_0x00d9;
    L_0x00cf:
        r1.close();	 Catch:{ Exception -> 0x00d3 }
        goto L_0x00d9;
    L_0x00d3:
        r2.delete();
        r10.delete();
    L_0x00d9:
        if (r9 == 0) goto L_0x00e5;
    L_0x00db:
        r9.close();	 Catch:{ Exception -> 0x00df }
        goto L_0x00e5;
    L_0x00df:
        r2.delete();
        r10.delete();
    L_0x00e5:
        throw r8;
    L_0x00e6:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.a(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    private File b(String str, String str2, boolean z) throws SecException {
        this.c.a();
        try {
            File f = f(str);
            File file = null;
            if (!b(f)) {
                f = null;
            }
            if (f == null) {
                f = g(str);
            }
            if (f != null) {
                File file2 = this.h;
                StringBuilder stringBuilder = new StringBuilder("libsg");
                stringBuilder.append(str);
                stringBuilder.append("_");
                stringBuilder.append(f.lastModified());
                stringBuilder.append(".zip");
                File file3 = new File(file2, stringBuilder.toString());
                if (file3.exists()) {
                    if (a(file3) && !c(file3, f)) {
                        file3.delete();
                    }
                    file = file3;
                }
                file3.delete();
                StringBuilder stringBuilder2 = new StringBuilder("Source plugin ");
                stringBuilder2.append(f.getAbsolutePath());
                stringBuilder2.append(" existed, try to create symbolic link!");
                com.alibaba.wireless.security.framework.b.a.b(stringBuilder2.toString());
                if (b(f, file3)) {
                    stringBuilder2 = new StringBuilder("Symbolic link ");
                    stringBuilder2.append(f.getAbsolutePath());
                    stringBuilder2.append(" to ");
                    stringBuilder2.append(file3.getAbsolutePath());
                    stringBuilder2.append(" create success");
                    str = stringBuilder2.toString();
                } else {
                    com.alibaba.wireless.security.framework.b.a.b("Create symbolic link failed, we need to copy the source to the destination!");
                    if (a(f, file3)) {
                        stringBuilder2 = new StringBuilder("copy plugin from ");
                        stringBuilder2.append(f.getAbsolutePath());
                        stringBuilder2.append(" to ");
                        stringBuilder2.append(file3.getAbsolutePath());
                        stringBuilder2.append(" success!");
                        str = stringBuilder2.toString();
                    }
                }
                com.alibaba.wireless.security.framework.b.a.b(str);
                file = file3;
            } else if (z) {
                file = h(str);
            }
            this.c.b();
            return file;
        } catch (Throwable th) {
            this.c.b();
        }
    }

    private Class<? extends Activity> b(Class<?> cls) {
        return SGBasePluginActivity.class.isAssignableFrom(cls) ? SGProxyActivity.class : null;
    }

    private void b(Context context, a aVar, int i) {
        StringBuilder stringBuilder = new StringBuilder("launch ");
        stringBuilder.append(aVar.b());
        com.alibaba.wireless.security.framework.b.a.b(stringBuilder.toString());
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(aVar, i);
        } else {
            context.startActivity(aVar);
        }
    }

    private boolean b(java.io.File r2) {
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
        r1 = this;
        if (r2 == 0) goto L_0x0022;
    L_0x0002:
        r2 = r2.getAbsolutePath();	 Catch:{ Exception -> 0x0022 }
        if (r2 == 0) goto L_0x0022;	 Catch:{ Exception -> 0x0022 }
    L_0x0008:
        r0 = r2.length();	 Catch:{ Exception -> 0x0022 }
        if (r0 > 0) goto L_0x000f;	 Catch:{ Exception -> 0x0022 }
    L_0x000e:
        goto L_0x0022;	 Catch:{ Exception -> 0x0022 }
    L_0x000f:
        r0 = r1.e;	 Catch:{ Exception -> 0x0022 }
        r0 = com.alibaba.wireless.security.framework.h.a(r0);	 Catch:{ Exception -> 0x0022 }
        if (r0 != 0) goto L_0x0020;	 Catch:{ Exception -> 0x0022 }
    L_0x0017:
        r0 = "/system/";	 Catch:{ Exception -> 0x0022 }
        r2 = r2.startsWith(r0);	 Catch:{ Exception -> 0x0022 }
        if (r2 == 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0022;
    L_0x0020:
        r2 = 1;
        return r2;
    L_0x0022:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.b(java.io.File):boolean");
    }

    private boolean b(File file, File file2) {
        try {
            Method declaredMethod;
            Object obj = null;
            if (VERSION.SDK_INT >= 21) {
                declaredMethod = Class.forName("android.system.Os").getDeclaredMethod("symlink", new Class[]{String.class, String.class});
            } else {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                declaredField.setAccessible(true);
                obj = declaredField.get(null);
                declaredMethod = obj.getClass().getMethod("symlink", new Class[]{String.class, String.class});
            }
            declaredMethod.invoke(obj, new Object[]{file.getAbsolutePath(), file2.getAbsolutePath()});
            return true;
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("create symbolic link( ");
            stringBuilder.append(file2.getAbsolutePath());
            stringBuilder.append(" -> ");
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append(" ) failed");
            com.alibaba.wireless.security.framework.b.a.a(stringBuilder.toString(), e);
            return false;
        }
    }

    private synchronized c c(String str, String str2, boolean z) throws SecException {
        c cVar = (c) this.f.get(str);
        if (cVar != null) {
            return cVar;
        }
        if (this.h.exists() || this.h.mkdirs()) {
            File b = b(str, str2, z);
            if (b != null) {
                if (b.exists()) {
                    c a = a(str, b.getPath(), this.e, str2);
                    if (a == null) {
                        throw new SecException(str, 111);
                    }
                    this.f.put(str, a);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(k.s);
                    stringBuilder.append(a.g.getVersion());
                    stringBuilder.append(k.t);
                    str = stringBuilder.toString();
                    String metaData = a.g.getMetaData("weakdependencies");
                    if (str2.length() != 0) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str2);
                        stringBuilder2.append("->");
                        stringBuilder2.append(str);
                        str = stringBuilder2.toString();
                    }
                    Looper myLooper = Looper.myLooper();
                    if (myLooper == null) {
                        com.alibaba.wireless.security.framework.b.a.a("looper of current thread is null, try to create a new thread with a looper");
                        HandlerThread handlerThread = new HandlerThread("SGBackgroud");
                        handlerThread.start();
                        myLooper = handlerThread.getLooper();
                    }
                    new Handler(myLooper).postDelayed(new g(this, metaData, str), 2000);
                    return a;
                }
            }
            if (!z) {
                return null;
            }
            StringBuilder stringBuilder3 = new StringBuilder("plugin ");
            stringBuilder3.append(str);
            stringBuilder3.append(" not existed");
            str = stringBuilder3.toString();
            if (str2.length() != 0) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str);
                stringBuilder3.append(", depended by ");
                stringBuilder3.append(str2);
                str = stringBuilder3.toString();
            }
            throw new SecException(str, 110);
        }
        throw new SecException(114);
    }

    private Class<? extends Service> c(Class<?> cls) {
        return null;
    }

    private boolean c(File file, File file2) {
        try {
            return file.getCanonicalPath().equals(file2.getAbsolutePath());
        } catch (Throwable e) {
            com.alibaba.wireless.security.framework.b.a.a("", e);
            return false;
        }
    }

    private DexClassLoader d(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.c.a();
        String absolutePath = this.h.getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e.getApplicationInfo().nativeLibraryDir);
        stringBuilder.append(File.pathSeparator);
        stringBuilder.append(this.h);
        DexClassLoader dexClassLoader = new DexClassLoader(str, absolutePath, stringBuilder.toString(), this.e.getClassLoader());
        this.c.b();
        StringBuilder stringBuilder2 = new StringBuilder("    createDexClassLoader( ");
        stringBuilder2.append(str);
        stringBuilder2.append(" ) used time: ");
        stringBuilder2.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuilder2.append(" ms");
        com.alibaba.wireless.security.framework.b.a.b(stringBuilder2.toString());
        return dexClassLoader;
    }

    private String d(Class cls) {
        String str = "";
        String[] split = cls.getName().split("\\.");
        if (split.length < 2) {
            return str;
        }
        String str2 = split[split.length - 2];
        r5 = new String[20][];
        r5[0] = new String[]{"securesignature", RePlugin.PLUGIN_NAME_MAIN};
        r5[1] = new String[]{"staticdatastore", RePlugin.PLUGIN_NAME_MAIN};
        r5[2] = new String[]{"staticdataencrypt", RePlugin.PLUGIN_NAME_MAIN};
        r5[3] = new String[]{"atlasencrypt", RePlugin.PLUGIN_NAME_MAIN};
        r5[4] = new String[]{"datacollection", RePlugin.PLUGIN_NAME_MAIN};
        r5[5] = new String[]{"dynamicdataencrypt", RePlugin.PLUGIN_NAME_MAIN};
        r5[6] = new String[]{"dynamicdatastore", RePlugin.PLUGIN_NAME_MAIN};
        r5[7] = new String[]{"opensdk", RePlugin.PLUGIN_NAME_MAIN};
        r5[8] = new String[]{"statickeyencrypt", RePlugin.PLUGIN_NAME_MAIN};
        r5[9] = new String[]{"umid", RePlugin.PLUGIN_NAME_MAIN};
        r5[10] = new String[]{"safetoken", RePlugin.PLUGIN_NAME_MAIN};
        r5[11] = new String[]{"securitybody", "securitybody"};
        r5[12] = new String[]{"simulatordetect", "securitybody"};
        r5[13] = new String[]{"rootdetect", "securitybody"};
        r5[14] = new String[]{"maldetection", "securitybody"};
        r5[15] = new String[]{"nocaptcha", "nocaptcha"};
        r5[16] = new String[]{"useraction", "uatrace"};
        r5[17] = new String[]{"indiekit", "misc"};
        r5[18] = new String[]{"pkgvaliditycheck", "misc"};
        r5[19] = new String[]{"avmp", "avmp"};
        for (int i = 0; i < 20; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(r5[i][0]);
            stringBuilder.append(" ");
            stringBuilder.append(r5[i][1]);
            com.alibaba.wireless.security.framework.b.a.b(stringBuilder.toString());
            if (str2.equalsIgnoreCase(r5[i][0])) {
                str = r5[i][1];
                break;
            }
        }
        return str.length() == 0 ? str2 : str;
    }

    private AssetManager e(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
            return assetManager;
        } catch (Throwable e) {
            com.alibaba.wireless.security.framework.b.a.a("", e);
            return null;
        }
    }

    private File f(String str) {
        File file = null;
        if (this.k != null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("sg");
        stringBuilder.append(str);
        str = h.a(b.class.getClassLoader(), stringBuilder.toString());
        if (str != null && str.length() > 0) {
            file = new File(str);
        }
        return file;
    }

    private java.io.File g(java.lang.String r3) {
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
        r0 = r2.k;
        if (r0 != 0) goto L_0x000d;
    L_0x0004:
        r1 = r2.e;	 Catch:{ Exception -> 0x000d }
        r1 = r1.getApplicationInfo();	 Catch:{ Exception -> 0x000d }
        r1 = r1.nativeLibraryDir;	 Catch:{ Exception -> 0x000d }
        r0 = r1;
    L_0x000d:
        if (r0 == 0) goto L_0x003f;
    L_0x000f:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x003f;
    L_0x0015:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r0);
        r0 = java.io.File.separator;
        r1.append(r0);
        r0 = "libsg";
        r1.append(r0);
        r1.append(r3);
        r3 = ".so";
        r1.append(r3);
        r3 = r1.toString();
        r0 = new java.io.File;
        r0.<init>(r3);
        r3 = r0.exists();
        if (r3 == 0) goto L_0x003f;
    L_0x003e:
        return r0;
    L_0x003f:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.g(java.lang.String):java.io.File");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File h(java.lang.String r10) {
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
        r1 = r9.e;	 Catch:{ Exception -> 0x000a }
        r1 = r1.getApplicationInfo();	 Catch:{ Exception -> 0x000a }
        r1 = r1.sourceDir;	 Catch:{ Exception -> 0x000a }
        goto L_0x000b;
    L_0x000a:
        r1 = r0;
    L_0x000b:
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        return r0;
    L_0x000e:
        r2 = new java.lang.StringBuilder;
        r3 = "libsg";
        r2.<init>(r3);
        r2.append(r10);
        r3 = ".so";
        r2.append(r3);
        r2 = r2.toString();
        r3 = "Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed";	 Catch:{ IOException -> 0x00d8 }
        com.alibaba.wireless.security.framework.b.a.b(r3);	 Catch:{ IOException -> 0x00d8 }
        r3 = 4;	 Catch:{ IOException -> 0x00d8 }
        r4 = new java.lang.String[r3];	 Catch:{ IOException -> 0x00d8 }
        r5 = "armeabi";	 Catch:{ IOException -> 0x00d8 }
        r6 = 0;	 Catch:{ IOException -> 0x00d8 }
        r4[r6] = r5;	 Catch:{ IOException -> 0x00d8 }
        r5 = "armeabi-v7";	 Catch:{ IOException -> 0x00d8 }
        r7 = 1;	 Catch:{ IOException -> 0x00d8 }
        r4[r7] = r5;	 Catch:{ IOException -> 0x00d8 }
        r5 = 2;	 Catch:{ IOException -> 0x00d8 }
        r7 = "arm64-v8a";	 Catch:{ IOException -> 0x00d8 }
        r4[r5] = r7;	 Catch:{ IOException -> 0x00d8 }
        r5 = 3;	 Catch:{ IOException -> 0x00d8 }
        r7 = "x86_64";	 Catch:{ IOException -> 0x00d8 }
        r4[r5] = r7;	 Catch:{ IOException -> 0x00d8 }
        r5 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x00d8 }
        r5.<init>(r1);	 Catch:{ IOException -> 0x00d8 }
    L_0x0042:
        if (r6 >= r3) goto L_0x00d1;
    L_0x0044:
        r1 = r4[r6];	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r8 = "lib";	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r7.<init>(r8);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r8 = java.io.File.separator;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r7.append(r8);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r7.append(r1);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r1 = java.io.File.separator;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r7.append(r1);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r7.append(r2);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r1 = r7.toString();	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r1 = r5.getEntry(r1);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        if (r1 == 0) goto L_0x00c7;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
    L_0x0067:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r3 = "Plugin existed  in ";	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2.<init>(r3);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r3 = r1.getName();	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2.append(r3);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2 = r2.toString();	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        com.alibaba.wireless.security.framework.b.a.b(r2);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r3 = "libsg";	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2.<init>(r3);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2.append(r10);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r10 = "_";	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2.append(r10);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r3 = r1.getTime();	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2.append(r3);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r10 = ".zip";	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2.append(r10);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r10 = r2.toString();	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2 = new java.io.File;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r3 = r9.h;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r2.<init>(r3, r10);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        r10 = r9.a(r2);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        if (r10 == 0) goto L_0x00ab;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
    L_0x00a8:
        r2.delete();	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
    L_0x00ab:
        r10 = r2.exists();	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        if (r10 != 0) goto L_0x00be;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
    L_0x00b1:
        r10 = a(r5, r1, r2);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        if (r10 == 0) goto L_0x00b8;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
    L_0x00b7:
        goto L_0x00be;	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
    L_0x00b8:
        r10 = "Extract failed!!";	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        com.alibaba.wireless.security.framework.b.a.b(r10);	 Catch:{ IOException -> 0x00cd, all -> 0x00cb }
        goto L_0x00d1;
    L_0x00be:
        r10 = "Extract success";	 Catch:{ IOException -> 0x00c5, all -> 0x00cb }
        com.alibaba.wireless.security.framework.b.a.b(r10);	 Catch:{ IOException -> 0x00c5, all -> 0x00cb }
        r0 = r2;
        goto L_0x00d1;
    L_0x00c5:
        r10 = move-exception;
        goto L_0x00cf;
    L_0x00c7:
        r6 = r6 + 1;
        goto L_0x0042;
    L_0x00cb:
        r10 = move-exception;
        goto L_0x00e5;
    L_0x00cd:
        r10 = move-exception;
        r2 = r0;
    L_0x00cf:
        r0 = r5;
        goto L_0x00da;
    L_0x00d1:
        r5.close();	 Catch:{ Exception -> 0x00d4 }
    L_0x00d4:
        return r0;
    L_0x00d5:
        r10 = move-exception;
        r5 = r0;
        goto L_0x00e5;
    L_0x00d8:
        r10 = move-exception;
        r2 = r0;
    L_0x00da:
        r1 = "getPluginFile throws exception";	 Catch:{ all -> 0x00d5 }
        com.alibaba.wireless.security.framework.b.a.a(r1, r10);	 Catch:{ all -> 0x00d5 }
        if (r0 == 0) goto L_0x00e4;
    L_0x00e1:
        r0.close();	 Catch:{ Exception -> 0x00e4 }
    L_0x00e4:
        return r2;
    L_0x00e5:
        if (r5 == 0) goto L_0x00ea;
    L_0x00e7:
        r5.close();	 Catch:{ Exception -> 0x00ea }
    L_0x00ea:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.h(java.lang.String):java.io.File");
    }

    public int a(Context context, a aVar) {
        if (this.g == 0) {
            aVar.setClassName(context, aVar.b());
            context.startService(aVar);
            return 0;
        }
        a(aVar, new c(this, aVar, context));
        return this.i;
    }

    @TargetApi(14)
    public int a(Context context, a aVar, int i) {
        if (this.g == 0) {
            aVar.setClassName(context, aVar.b());
        } else {
            String a = aVar.a();
            if (TextUtils.isEmpty(a)) {
                throw new NullPointerException("disallow null packageName.");
            }
            c b = b(a);
            if (b == null) {
                return 1;
            }
            String a2 = a(aVar, b);
            Class a3 = a(b.c, a2);
            if (a3 == null) {
                return 2;
            }
            a3 = b(a3);
            if (a3 == null) {
                return 3;
            }
            aVar.putExtra("extra.class", a2);
            aVar.putExtra("extra.package", a);
            aVar.setClass(this.e, a3);
        }
        b(context, aVar, i);
        return 0;
    }

    public int a(Context context, a aVar, ServiceConnection serviceConnection) {
        if (this.g == 0) {
            context.unbindService(serviceConnection);
            return 0;
        }
        a(aVar, new f(this, context, serviceConnection));
        return this.i;
    }

    public int a(Context context, a aVar, ServiceConnection serviceConnection, int i) {
        if (this.g == 0) {
            aVar.setClassName(context, aVar.b());
            context.bindService(aVar, serviceConnection, i);
            return 0;
        }
        a(aVar, new e(this, aVar, context, serviceConnection, i));
        return this.i;
    }

    public synchronized <T> T a(Class<T> cls) throws SecException {
        Object obj = this.a.get(cls);
        if (obj != null) {
            return cls.cast(obj);
        }
        String d = d((Class) cls);
        if (d.length() == 0) {
            return null;
        }
        c c = c(d, "", true);
        if (c == null) {
            throw new SecException(110);
        }
        obj = c.g.getInterface(cls);
        if (obj == null) {
            throw new SecException(112);
        }
        this.a.put(cls, obj);
        return cls.cast(obj);
    }

    public String a() {
        return RePlugin.PLUGIN_NAME_MAIN;
    }

    public void a(String str) {
        if (str != null && !str.isEmpty()) {
            this.k = str;
        }
    }

    public void a(boolean z) {
        this.j = z;
    }

    public int b(Context context, a aVar) {
        if (this.g == 0) {
            aVar.setClassName(context, aVar.b());
            context.stopService(aVar);
            return 0;
        }
        a(aVar, new d(this, aVar, context));
        return this.i;
    }

    public c b(String str) {
        for (Entry value : this.f.entrySet()) {
            c cVar = (c) value.getValue();
            if (cVar.a.equalsIgnoreCase(str)) {
                return cVar;
            }
        }
        return null;
    }

    public c c(String str) throws SecException {
        return c(str, "", true);
    }
}
