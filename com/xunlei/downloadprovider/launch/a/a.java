package com.xunlei.downloadprovider.launch.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: LaunchCounter */
public final class a {
    private static volatile int a = -1;

    private static synchronized void a(int i) {
        synchronized (a.class) {
            if (a < 0) {
                if (i < 0) {
                    i = 0;
                }
                a = i;
            }
        }
    }

    public static int a() {
        int i = 0;
        SharedPreferences sharedPreferences = BrothersApplication.getApplicationInstance().getSharedPreferences("count", 0);
        if (sharedPreferences != null) {
            i = sharedPreferences.getInt("5.60.2.5510", 0);
            if (a < 0) {
                a(i);
            }
        }
        return i;
    }

    public static int b() {
        int i = 0;
        SharedPreferences sharedPreferences = BrothersApplication.getApplicationInstance().getSharedPreferences("count", 0);
        if (sharedPreferences != null) {
            String str = "5.60.2.5510";
            i = sharedPreferences.getInt(str, 0);
            i = i >= Integer.MAX_VALUE ? Integer.MAX_VALUE : i < 0 ? 1 : i + 1;
            if (a < 0) {
                a(i);
            }
            Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.apply();
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int c() {
        /*
        r0 = com.xunlei.downloadprovider.launch.a.a.class;
        monitor-enter(r0);
        r1 = a();	 Catch:{ all -> 0x011a }
        r2 = 1;
        r3 = 0;
        if (r1 != 0) goto L_0x000d;
    L_0x000b:
        r1 = r2;
        goto L_0x000e;
    L_0x000d:
        r1 = r3;
    L_0x000e:
        if (r1 == 0) goto L_0x0117;
    L_0x0010:
        r1 = "";
        r4 = "5.60.2.5510";
        r5 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ all -> 0x011a }
        r6 = "count";
        r5 = r5.getSharedPreferences(r6, r3);	 Catch:{ all -> 0x011a }
        r6 = "current_install_version";
        r6 = r5.contains(r6);	 Catch:{ all -> 0x011a }
        r7 = 2;
        if (r6 == 0) goto L_0x005f;
    L_0x0027:
        r6 = "current_install_version";
        r8 = "";
        r6 = r5.getString(r6, r8);	 Catch:{ all -> 0x011a }
        r8 = r4.equals(r6);	 Catch:{ all -> 0x011a }
        if (r8 != 0) goto L_0x0045;
    L_0x0035:
        r1 = r5.edit();	 Catch:{ all -> 0x011a }
        r8 = "last_install_version";
        r1 = r1.putString(r8, r6);	 Catch:{ all -> 0x011a }
        r1.apply();	 Catch:{ all -> 0x011a }
    L_0x0042:
        r1 = r7;
        goto L_0x00d0;
    L_0x0045:
        r6 = r4.equals(r6);	 Catch:{ all -> 0x011a }
        if (r6 == 0) goto L_0x00ce;
    L_0x004b:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x011a }
        r5 = "Error InstallLaunchCase already reported from:";
        r2.<init>(r5);	 Catch:{ all -> 0x011a }
        r2.append(r1);	 Catch:{ all -> 0x011a }
        r1 = " to:";
        r2.append(r1);	 Catch:{ all -> 0x011a }
        r2.append(r4);	 Catch:{ all -> 0x011a }
        monitor-exit(r0);
        return r3;
    L_0x005f:
        r6 = r5.getAll();	 Catch:{ all -> 0x011a }
        if (r6 == 0) goto L_0x00ce;
    L_0x0065:
        r8 = r6.isEmpty();	 Catch:{ all -> 0x011a }
        if (r8 != 0) goto L_0x00ce;
    L_0x006b:
        r6 = r6.keySet();	 Catch:{ all -> 0x011a }
        r8 = r6.isEmpty();	 Catch:{ all -> 0x011a }
        if (r8 != 0) goto L_0x00ce;
    L_0x0075:
        r8 = new java.util.ArrayList;	 Catch:{ all -> 0x011a }
        r9 = 3;
        r8.<init>(r9);	 Catch:{ all -> 0x011a }
        r9 = "\\d+\\.\\d+\\.\\d+\\.\\d+";
        r9 = java.util.regex.Pattern.compile(r9, r3);	 Catch:{ all -> 0x011a }
        r6 = r6.iterator();	 Catch:{ all -> 0x011a }
    L_0x0085:
        r10 = r6.hasNext();	 Catch:{ all -> 0x011a }
        if (r10 == 0) goto L_0x00a5;
    L_0x008b:
        r10 = r6.next();	 Catch:{ all -> 0x011a }
        r10 = (java.lang.String) r10;	 Catch:{ all -> 0x011a }
        r11 = r9.matcher(r10);	 Catch:{ all -> 0x011a }
        r11 = r11.matches();	 Catch:{ all -> 0x011a }
        if (r11 == 0) goto L_0x0085;
    L_0x009b:
        r11 = r4.equals(r10);	 Catch:{ all -> 0x011a }
        if (r11 != 0) goto L_0x0085;
    L_0x00a1:
        r8.add(r10);	 Catch:{ all -> 0x011a }
        goto L_0x0085;
    L_0x00a5:
        r6 = r8.isEmpty();	 Catch:{ all -> 0x011a }
        if (r6 != 0) goto L_0x00ce;
    L_0x00ab:
        r1 = new com.xunlei.downloadprovider.launch.a.b;	 Catch:{ all -> 0x011a }
        r1.<init>();	 Catch:{ all -> 0x011a }
        java.util.Collections.sort(r8, r1);	 Catch:{ all -> 0x011a }
        r1 = r8.size();	 Catch:{ all -> 0x011a }
        r1 = r1 - r2;
        r1 = r8.get(r1);	 Catch:{ all -> 0x011a }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x011a }
        r6 = r5.edit();	 Catch:{ all -> 0x011a }
        r8 = "last_install_version";
        r6 = r6.putString(r8, r1);	 Catch:{ all -> 0x011a }
        r6.apply();	 Catch:{ all -> 0x011a }
        r6 = r1;
        goto L_0x0042;
    L_0x00ce:
        r6 = r1;
        r1 = r2;
    L_0x00d0:
        if (r1 != r7) goto L_0x00d3;
    L_0x00d2:
        goto L_0x00d4;
    L_0x00d3:
        r2 = r3;
    L_0x00d4:
        r3 = "android_launch";
        r7 = "launch_install";
        r3 = com.xunlei.common.report.HubbleEventBuilder.build(r3, r7);	 Catch:{ all -> 0x011a }
        r7 = "install_status";
        if (r2 == 0) goto L_0x00e3;
    L_0x00e0:
        r2 = "update";
        goto L_0x00e5;
    L_0x00e3:
        r2 = "new";
    L_0x00e5:
        r3.add(r7, r2);	 Catch:{ all -> 0x011a }
        r2 = "last_version";
        r3.add(r2, r6);	 Catch:{ all -> 0x011a }
        com.xunlei.common.report.ThunderReport.reportEvent(r3);	 Catch:{ all -> 0x011a }
        r2 = r5.edit();	 Catch:{ all -> 0x011a }
        r3 = "current_install_version";
        r2.putString(r3, r4);	 Catch:{ all -> 0x011a }
        r2.apply();	 Catch:{ all -> 0x011a }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x011a }
        r3 = "InstallLaunchCase = ";
        r2.<init>(r3);	 Catch:{ all -> 0x011a }
        r2.append(r1);	 Catch:{ all -> 0x011a }
        r3 = " from:";
        r2.append(r3);	 Catch:{ all -> 0x011a }
        r2.append(r6);	 Catch:{ all -> 0x011a }
        r3 = " to:";
        r2.append(r3);	 Catch:{ all -> 0x011a }
        r2.append(r4);	 Catch:{ all -> 0x011a }
        goto L_0x0118;
    L_0x0117:
        r1 = r3;
    L_0x0118:
        monitor-exit(r0);
        return r1;
    L_0x011a:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.launch.a.a.c():int");
    }
}
