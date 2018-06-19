package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import com.alibaba.mtl.log.model.LogField;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;

/* compiled from: LogAssemble */
public final class h {
    public static String a(Map<String, String> map) {
        if (map.size() <= 0) {
            return null;
        }
        Object obj;
        b(map);
        StringBuilder stringBuilder = new StringBuilder();
        for (LogField logField : LogField.values()) {
            if (logField == LogField.ARGS) {
                break;
            }
            String stringBuilder2;
            if (map.containsKey(logField.toString())) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append((String) map.get(logField.toString()));
                stringBuilder2 = stringBuilder3.toString();
                map.remove(logField.toString());
            } else {
                stringBuilder2 = null;
            }
            stringBuilder.append(a(stringBuilder2));
            stringBuilder.append("||");
        }
        if (map.containsKey(LogField.ARGS.toString())) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append((String) map.get(LogField.ARGS.toString()));
            stringBuilder.append(a(stringBuilder4.toString()));
            map.remove(LogField.ARGS.toString());
            obj = null;
        } else {
            obj = 1;
        }
        for (String str : map.keySet()) {
            String stringBuilder5;
            if (map.containsKey(str)) {
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append((String) map.get(str));
                stringBuilder5 = stringBuilder6.toString();
            } else {
                stringBuilder5 = null;
            }
            if (obj != null) {
                if ("StackTrace".equals(str)) {
                    stringBuilder.append("StackTrace=====>");
                    stringBuilder.append(stringBuilder5);
                } else {
                    stringBuilder.append(a(str));
                    stringBuilder.append("=");
                    stringBuilder.append(stringBuilder5);
                }
                obj = null;
            } else if ("StackTrace".equals(str)) {
                stringBuilder.append(",StackTrace=====>");
                stringBuilder.append(stringBuilder5);
            } else {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append(a(str));
                stringBuilder.append("=");
                stringBuilder.append(stringBuilder5);
            }
        }
        map = stringBuilder.toString();
        if (!TextUtils.isEmpty(map) && map.endsWith("||")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(map);
            stringBuilder.append("-");
            map = stringBuilder.toString();
        }
        return map;
    }

    private static java.util.Map<java.lang.String, java.lang.String> b(java.util.Map<java.lang.String, java.lang.String> r6) {
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
        if (r6 != 0) goto L_0x0007;
    L_0x0002:
        r6 = new java.util.HashMap;
        r6.<init>();
    L_0x0007:
        r0 = com.alibaba.mtl.log.e.b.d();	 Catch:{ Throwable -> 0x015a }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x0026;	 Catch:{ Throwable -> 0x015a }
    L_0x0011:
        r1 = com.alibaba.mtl.log.model.LogField.USERNICK;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r1 = r6.containsKey(r1);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x0026;	 Catch:{ Throwable -> 0x015a }
    L_0x001d:
        r1 = com.alibaba.mtl.log.model.LogField.USERNICK;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r6.put(r1, r0);	 Catch:{ Throwable -> 0x015a }
    L_0x0026:
        r0 = com.alibaba.mtl.log.e.b.a();	 Catch:{ Throwable -> 0x015a }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x0045;	 Catch:{ Throwable -> 0x015a }
    L_0x0030:
        r1 = com.alibaba.mtl.log.model.LogField.LL_USERNICK;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r1 = r6.containsKey(r1);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x0045;	 Catch:{ Throwable -> 0x015a }
    L_0x003c:
        r1 = com.alibaba.mtl.log.model.LogField.LL_USERNICK;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r6.put(r1, r0);	 Catch:{ Throwable -> 0x015a }
    L_0x0045:
        r0 = com.alibaba.mtl.log.e.b.e();	 Catch:{ Throwable -> 0x015a }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x0064;	 Catch:{ Throwable -> 0x015a }
    L_0x004f:
        r1 = com.alibaba.mtl.log.model.LogField.USERID;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r1 = r6.containsKey(r1);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x0064;	 Catch:{ Throwable -> 0x015a }
    L_0x005b:
        r1 = com.alibaba.mtl.log.model.LogField.USERID;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r6.put(r1, r0);	 Catch:{ Throwable -> 0x015a }
    L_0x0064:
        r0 = com.alibaba.mtl.log.e.b.b();	 Catch:{ Throwable -> 0x015a }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x0083;	 Catch:{ Throwable -> 0x015a }
    L_0x006e:
        r1 = com.alibaba.mtl.log.model.LogField.LL_USERID;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r1 = r6.containsKey(r1);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x0083;	 Catch:{ Throwable -> 0x015a }
    L_0x007a:
        r1 = com.alibaba.mtl.log.model.LogField.LL_USERID;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r6.put(r1, r0);	 Catch:{ Throwable -> 0x015a }
    L_0x0083:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x015a }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Throwable -> 0x015a }
        r1 = com.alibaba.mtl.log.model.LogField.RECORD_TIMESTAMP;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r1 = r6.containsKey(r1);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x00a0;	 Catch:{ Throwable -> 0x015a }
    L_0x0097:
        r1 = com.alibaba.mtl.log.model.LogField.RECORD_TIMESTAMP;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r6.put(r1, r0);	 Catch:{ Throwable -> 0x015a }
    L_0x00a0:
        r0 = com.alibaba.mtl.log.model.LogField.START_SESSION_TIMESTAMP;	 Catch:{ Throwable -> 0x015a }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x015a }
        r0 = r6.containsKey(r0);	 Catch:{ Throwable -> 0x015a }
        if (r0 != 0) goto L_0x00bb;	 Catch:{ Throwable -> 0x015a }
    L_0x00ac:
        r0 = com.alibaba.mtl.log.model.LogField.START_SESSION_TIMESTAMP;	 Catch:{ Throwable -> 0x015a }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x015a }
        r1 = com.alibaba.mtl.log.a.f;	 Catch:{ Throwable -> 0x015a }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x015a }
        r6.put(r0, r1);	 Catch:{ Throwable -> 0x015a }
    L_0x00bb:
        r0 = com.alibaba.mtl.log.a.c();	 Catch:{ Throwable -> 0x015a }
        r0 = com.alibaba.mtl.log.e.d.a(r0);	 Catch:{ Throwable -> 0x015a }
        if (r0 == 0) goto L_0x00ef;	 Catch:{ Throwable -> 0x015a }
    L_0x00c5:
        r1 = r0.keySet();	 Catch:{ Throwable -> 0x015a }
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x015a }
    L_0x00cd:
        r2 = r1.hasNext();	 Catch:{ Throwable -> 0x015a }
        if (r2 == 0) goto L_0x00ef;	 Catch:{ Throwable -> 0x015a }
    L_0x00d3:
        r2 = r1.next();	 Catch:{ Throwable -> 0x015a }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x015a }
        r3 = r0.get(r2);	 Catch:{ Throwable -> 0x015a }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x015a }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x015a }
        if (r4 != 0) goto L_0x00cd;	 Catch:{ Throwable -> 0x015a }
    L_0x00e5:
        r4 = r6.containsKey(r2);	 Catch:{ Throwable -> 0x015a }
        if (r4 != 0) goto L_0x00cd;	 Catch:{ Throwable -> 0x015a }
    L_0x00eb:
        r6.put(r2, r3);	 Catch:{ Throwable -> 0x015a }
        goto L_0x00cd;	 Catch:{ Throwable -> 0x015a }
    L_0x00ef:
        r0 = "_ap=1";	 Catch:{ Throwable -> 0x015a }
        r1 = com.alibaba.mtl.log.a.c();	 Catch:{ Throwable -> 0x015a }
        r1 = com.alibaba.mtl.log.e.l.a(r1);	 Catch:{ Throwable -> 0x015a }
        if (r1 == 0) goto L_0x011b;	 Catch:{ Throwable -> 0x015a }
    L_0x00fb:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x015a }
        r2.<init>();	 Catch:{ Throwable -> 0x015a }
        r2.append(r0);	 Catch:{ Throwable -> 0x015a }
        r0 = "%s=%s";	 Catch:{ Throwable -> 0x015a }
        r3 = 2;	 Catch:{ Throwable -> 0x015a }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x015a }
        r4 = 0;	 Catch:{ Throwable -> 0x015a }
        r5 = "_mac";	 Catch:{ Throwable -> 0x015a }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x015a }
        r4 = 1;	 Catch:{ Throwable -> 0x015a }
        r3[r4] = r1;	 Catch:{ Throwable -> 0x015a }
        r0 = java.lang.String.format(r0, r3);	 Catch:{ Throwable -> 0x015a }
        r2.append(r0);	 Catch:{ Throwable -> 0x015a }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x015a }
    L_0x011b:
        r1 = com.alibaba.mtl.log.e.d.a();	 Catch:{ Throwable -> 0x015a }
        if (r1 == 0) goto L_0x013f;	 Catch:{ Throwable -> 0x015a }
    L_0x0121:
        r1 = com.alibaba.mtl.log.e.d.b();	 Catch:{ Throwable -> 0x015a }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x015a }
        if (r2 != 0) goto L_0x013f;	 Catch:{ Throwable -> 0x015a }
    L_0x012b:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x015a }
        r2.<init>();	 Catch:{ Throwable -> 0x015a }
        r2.append(r0);	 Catch:{ Throwable -> 0x015a }
        r0 = ",_did=";	 Catch:{ Throwable -> 0x015a }
        r2.append(r0);	 Catch:{ Throwable -> 0x015a }
        r2.append(r1);	 Catch:{ Throwable -> 0x015a }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x015a }
    L_0x013f:
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x015a;	 Catch:{ Throwable -> 0x015a }
    L_0x0145:
        r1 = com.alibaba.mtl.log.model.LogField.RESERVES;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r1 = r6.containsKey(r1);	 Catch:{ Throwable -> 0x015a }
        if (r1 != 0) goto L_0x015a;	 Catch:{ Throwable -> 0x015a }
    L_0x0151:
        r1 = com.alibaba.mtl.log.model.LogField.RESERVES;	 Catch:{ Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x015a }
        r6.put(r1, r0);	 Catch:{ Throwable -> 0x015a }
    L_0x015a:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.h.b(java.util.Map):java.util.Map<java.lang.String, java.lang.String>");
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }
}
