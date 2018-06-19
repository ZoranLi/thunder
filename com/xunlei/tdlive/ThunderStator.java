package com.xunlei.tdlive;

import android.content.Context;
import android.os.SystemClock;
import com.xunlei.tdlive.sdk.IStator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class ThunderStator implements IStator {
    private static Context mContext;
    private static ThunderStator sInst;
    private static long sLeaveTime;
    private static String sSessionId;

    public void addCommonData(String str, String str2) {
    }

    public void onPageEnd(String str) {
    }

    public void onPageStart(String str) {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void removeCommonData(String str) {
    }

    public void setUid(String str) {
    }

    public void traceValue(String str, Map<String, String> map, int i) {
    }

    public void uninit() {
    }

    private ThunderStator() {
    }

    public static ThunderStator getInstance() {
        if (sInst == null) {
            sInst = new ThunderStator();
        }
        return sInst;
    }

    public boolean init(Context context) {
        mContext = context.getApplicationContext();
        sSessionId = UUID.randomUUID().toString();
        sLeaveTime = SystemClock.elapsedRealtime();
        return true;
    }

    public void traceEvent(String str, String str2, String str3, Map<String, String> map) {
        traceEvent("android_caomei", str, str2, str3, (Map) map);
    }

    public void traceEvent(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x009a }
        if (r0 == 0) goto L_0x0007;	 Catch:{ Throwable -> 0x009a }
    L_0x0006:
        return;	 Catch:{ Throwable -> 0x009a }
    L_0x0007:
        r0 = "__onresume__";	 Catch:{ Throwable -> 0x009a }
        r0 = r0.equals(r4);	 Catch:{ Throwable -> 0x009a }
        if (r0 == 0) goto L_0x002f;	 Catch:{ Throwable -> 0x009a }
    L_0x000f:
        r3 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x009a }
        r5 = sLeaveTime;	 Catch:{ Throwable -> 0x009a }
        r0 = r3 - r5;	 Catch:{ Throwable -> 0x009a }
        r3 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;	 Catch:{ Throwable -> 0x009a }
        r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));	 Catch:{ Throwable -> 0x009a }
        if (r5 <= 0) goto L_0x002e;	 Catch:{ Throwable -> 0x009a }
    L_0x001e:
        r3 = java.util.UUID.randomUUID();	 Catch:{ Throwable -> 0x009a }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x009a }
        sSessionId = r3;	 Catch:{ Throwable -> 0x009a }
        r3 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x009a }
        sLeaveTime = r3;	 Catch:{ Throwable -> 0x009a }
    L_0x002e:
        return;	 Catch:{ Throwable -> 0x009a }
    L_0x002f:
        r0 = "__onpause__";	 Catch:{ Throwable -> 0x009a }
        r0 = r0.equals(r4);	 Catch:{ Throwable -> 0x009a }
        if (r0 == 0) goto L_0x003e;	 Catch:{ Throwable -> 0x009a }
    L_0x0037:
        r3 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x009a }
        sLeaveTime = r3;	 Catch:{ Throwable -> 0x009a }
        return;	 Catch:{ Throwable -> 0x009a }
    L_0x003e:
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x009a }
        if (r0 == 0) goto L_0x0046;	 Catch:{ Throwable -> 0x009a }
    L_0x0044:
        r3 = "android_caomei";	 Catch:{ Throwable -> 0x009a }
    L_0x0046:
        r3 = com.xunlei.common.report.HubbleEventBuilder.build(r3, r4);	 Catch:{ Throwable -> 0x009a }
        r4 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x009a }
        if (r4 != 0) goto L_0x0055;	 Catch:{ Throwable -> 0x009a }
    L_0x0050:
        r4 = "sdk_attr1";	 Catch:{ Throwable -> 0x009a }
        r3.add(r4, r5);	 Catch:{ Throwable -> 0x009a }
    L_0x0055:
        r4 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x009a }
        if (r4 != 0) goto L_0x0060;	 Catch:{ Throwable -> 0x009a }
    L_0x005b:
        r4 = "sdk_attr2";	 Catch:{ Throwable -> 0x009a }
        r3.add(r4, r6);	 Catch:{ Throwable -> 0x009a }
    L_0x0060:
        r4 = "version";	 Catch:{ Throwable -> 0x009a }
        r5 = com.xunlei.downloadprovider.launch.b.a.a();	 Catch:{ Throwable -> 0x009a }
        r6 = mContext;	 Catch:{ Throwable -> 0x009a }
        r5 = r5.getVersion(r6);	 Catch:{ Throwable -> 0x009a }
        r3.add(r4, r5);	 Catch:{ Throwable -> 0x009a }
        r4 = "sessionid";	 Catch:{ Throwable -> 0x009a }
        r5 = sSessionId;	 Catch:{ Throwable -> 0x009a }
        r3.add(r4, r5);	 Catch:{ Throwable -> 0x009a }
        if (r7 == 0) goto L_0x0096;	 Catch:{ Throwable -> 0x009a }
    L_0x0078:
        r4 = r7.keySet();	 Catch:{ Throwable -> 0x009a }
        r4 = r4.iterator();	 Catch:{ Throwable -> 0x009a }
    L_0x0080:
        r5 = r4.hasNext();	 Catch:{ Throwable -> 0x009a }
        if (r5 == 0) goto L_0x0096;	 Catch:{ Throwable -> 0x009a }
    L_0x0086:
        r5 = r4.next();	 Catch:{ Throwable -> 0x009a }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x009a }
        r6 = r7.get(r5);	 Catch:{ Throwable -> 0x009a }
        r6 = (java.lang.String) r6;	 Catch:{ Throwable -> 0x009a }
        r3.add(r5, r6);	 Catch:{ Throwable -> 0x009a }
        goto L_0x0080;	 Catch:{ Throwable -> 0x009a }
    L_0x0096:
        com.xunlei.common.report.ThunderReport.reportEvent(r3);	 Catch:{ Throwable -> 0x009a }
        return;
    L_0x009a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.ThunderStator.traceEvent(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public static void traceEvent(Context context, String str, String str2, String str3, Map<String, String> map) {
        getInstance().traceEvent(str, str2, str3, map);
    }

    private void log(String str, String str2, String str3, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder("name = ");
        stringBuilder.append(str);
        stringBuilder.append(", attr1 = ");
        stringBuilder.append(str2);
        stringBuilder.append(", attr2 = ");
        stringBuilder.append(str3);
        str = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            str.append((String) entry.getKey());
            str.append(": ");
            str.append((String) entry.getValue());
            str.append("\n");
        }
        str.append("----------------------------------------\n");
    }
}
