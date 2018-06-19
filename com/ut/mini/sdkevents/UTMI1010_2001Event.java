package com.ut.mini.sdkevents;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.model.LogField;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTInterfaceCallDelegate;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.plugin.UTPlugin;
import java.util.Map;

public class UTMI1010_2001Event extends UTPlugin implements UTMCAppStatusCallbacks {
    private long C = 0;
    private long D = 0;
    private long E = 0;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public int[] returnRequiredMsgIds() {
        return new int[]{3};
    }

    public void onPluginMsgArrivedFromSDK(int i, Object obj) {
        if (i == 3) {
            Map map = (Map) obj;
            if (map.containsKey(LogField.EVENTID.toString()) != 0) {
                if ("2001".equals((String) map.get(LogField.EVENTID.toString())) != 0) {
                    if (map.containsKey(LogField.ARG3.toString()) != 0) {
                        try {
                            i = Long.parseLong((String) map.get(LogField.ARG3.toString()));
                        } catch (int i2) {
                            i2.printStackTrace();
                        }
                        this.C += i2;
                        if (p() != 0) {
                            a(this.C);
                            this.C = 0;
                        }
                    }
                    i2 = 0;
                    this.C += i2;
                    if (p() != 0) {
                        a(this.C);
                        this.C = 0;
                    }
                }
            }
        }
    }

    private static boolean p() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = com.alibaba.mtl.log.b.a();	 Catch:{ Exception -> 0x0040 }
        r1 = r1.a;	 Catch:{ Exception -> 0x0040 }
        r2 = 1;	 Catch:{ Exception -> 0x0040 }
        if (r1 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x0040 }
    L_0x000a:
        r3 = r1.getPackageName();	 Catch:{ Exception -> 0x0040 }
        if (r3 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x0040 }
    L_0x0010:
        r4 = "activity";	 Catch:{ Exception -> 0x0040 }
        r1 = r1.getSystemService(r4);	 Catch:{ Exception -> 0x0040 }
        r1 = (android.app.ActivityManager) r1;	 Catch:{ Exception -> 0x0040 }
        if (r1 == 0) goto L_0x003f;
    L_0x001a:
        r1 = r1.getRunningTasks(r2);	 Catch:{ Exception -> 0x003b }
        if (r1 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x003b }
    L_0x0020:
        r4 = r1.size();	 Catch:{ Exception -> 0x003b }
        if (r4 <= 0) goto L_0x003f;	 Catch:{ Exception -> 0x003b }
    L_0x0026:
        r1 = r1.get(r0);	 Catch:{ Exception -> 0x003b }
        r1 = (android.app.ActivityManager.RunningTaskInfo) r1;	 Catch:{ Exception -> 0x003b }
        r1 = r1.topActivity;	 Catch:{ Exception -> 0x003b }
        if (r1 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x003b }
    L_0x0030:
        r1 = r1.getPackageName();	 Catch:{ Exception -> 0x003b }
        r1 = r3.contains(r1);	 Catch:{ Exception -> 0x003b }
        if (r1 == 0) goto L_0x003f;
    L_0x003a:
        return r0;
    L_0x003b:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x0040 }
    L_0x003f:
        return r2;
    L_0x0040:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.sdkevents.UTMI1010_2001Event.p():boolean");
    }

    private void a(long j) {
        if (!c.a().c()) {
            long j2 = 0;
            if (j > 0) {
                if (0 != this.E) {
                    j2 = SystemClock.elapsedRealtime() - this.E;
                }
                UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("UT", 1010, String.valueOf(j), String.valueOf(j2), null, null);
                j = UTAnalytics.getInstance().getDefaultTracker();
                if (j != null) {
                    j.send(uTOriginalCustomHitBuilder.build());
                    return;
                }
                i.b("Record app display event error", "Fatal Error,must call setRequestAuthentication method first.");
            }
        }
    }

    public void onSwitchBackground() {
        a(SystemClock.elapsedRealtime() - this.D);
        this.E = SystemClock.elapsedRealtime();
    }

    public void onSwitchForeground() {
        this.D = SystemClock.elapsedRealtime();
    }

    public void onActivityPaused(Activity activity) {
        UTInterfaceCallDelegate.pageDisAppearByAuto(activity);
    }

    public void onActivityResumed(Activity activity) {
        UTInterfaceCallDelegate.pageAppearByAuto(activity);
    }
}
