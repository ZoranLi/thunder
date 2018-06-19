package com.tencent.bugly.beta.upgrade;

import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.m;
import com.tencent.bugly.proguard.x;

/* compiled from: BUGLY */
public class b {
    public static b a = new b();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected synchronized void a(int r19, byte[] r20, com.tencent.bugly.beta.upgrade.a r21, boolean r22, java.lang.String r23) {
        /*
        r18 = this;
        monitor-enter(r18);
        r1 = com.tencent.bugly.crashreport.common.info.a.b();	 Catch:{ all -> 0x0255 }
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Throwable -> 0x0239 }
        r2 = r2.s;	 Catch:{ Throwable -> 0x0239 }
        r4 = r19;
        r3 = r20;
        r2 = com.tencent.bugly.proguard.ah.a(r2, r4, r3);	 Catch:{ Throwable -> 0x0237 }
        if (r2 == 0) goto L_0x0235;
    L_0x0013:
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Throwable -> 0x0237 }
        r5 = r3.u;	 Catch:{ Throwable -> 0x0237 }
        r2.b = r5;	 Catch:{ Throwable -> 0x0237 }
        r5 = r3.P;	 Catch:{ Throwable -> 0x0237 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x0237 }
        if (r5 != 0) goto L_0x0025;
    L_0x0021:
        r5 = r3.P;	 Catch:{ Throwable -> 0x0237 }
        r2.e = r5;	 Catch:{ Throwable -> 0x0237 }
    L_0x0025:
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        if (r5 == 0) goto L_0x0235;
    L_0x0029:
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G6";
        r7 = r3.v;	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G10";
        r7 = "1.3.4";
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G3";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r3.x;	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G11";
        r7 = r3.w;	 Catch:{ Throwable -> 0x0237 }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G7";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r1.m();	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G8";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r1.k();	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G9";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r1.l();	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G2";
        r7 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.s;	 Catch:{ Throwable -> 0x0237 }
        r7 = com.tencent.bugly.beta.global.a.a(r7);	 Catch:{ Throwable -> 0x0237 }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G12";
        r7 = r3.o;	 Catch:{ Throwable -> 0x0237 }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "A21";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r1.g();	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "A22";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r1.h();	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G13";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r3.J;	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G14";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r3.K;	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G15";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r3.M;	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G17";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r1.x();	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "C01";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r1.H();	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r6 = "G18";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r7.<init>();	 Catch:{ Throwable -> 0x0237 }
        r8 = r1.g();	 Catch:{ Throwable -> 0x0237 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0237 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0237 }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x0237 }
        r5 = r1.B();	 Catch:{ Throwable -> 0x0237 }
        if (r5 == 0) goto L_0x01b2;
    L_0x017a:
        r6 = r5.size();	 Catch:{ Throwable -> 0x0237 }
        if (r6 <= 0) goto L_0x01b2;
    L_0x0180:
        r5 = r5.entrySet();	 Catch:{ Throwable -> 0x0237 }
        r5 = r5.iterator();	 Catch:{ Throwable -> 0x0237 }
    L_0x0188:
        r6 = r5.hasNext();	 Catch:{ Throwable -> 0x0237 }
        if (r6 == 0) goto L_0x01b2;
    L_0x018e:
        r6 = r5.next();	 Catch:{ Throwable -> 0x0237 }
        r6 = (java.util.Map.Entry) r6;	 Catch:{ Throwable -> 0x0237 }
        r7 = r2.k;	 Catch:{ Throwable -> 0x0237 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r9 = "C03_";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0237 }
        r9 = r6.getKey();	 Catch:{ Throwable -> 0x0237 }
        r9 = (java.lang.String) r9;	 Catch:{ Throwable -> 0x0237 }
        r8.append(r9);	 Catch:{ Throwable -> 0x0237 }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x0237 }
        r6 = r6.getValue();	 Catch:{ Throwable -> 0x0237 }
        r7.put(r8, r6);	 Catch:{ Throwable -> 0x0237 }
        goto L_0x0188;
    L_0x01b2:
        r5 = "app version is: [%s.%s], [deviceId:%s], channel: [%s], base tinkerId:[%s], patch tinkerId:[%s], patch version:[%s]";
        r6 = 7;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x0237 }
        r7 = 0;
        r8 = r3.x;	 Catch:{ Throwable -> 0x0237 }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x0237 }
        r7 = 1;
        r8 = r3.w;	 Catch:{ Throwable -> 0x0237 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x0237 }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x0237 }
        r7 = 2;
        r1 = r1.h();	 Catch:{ Throwable -> 0x0237 }
        r6[r7] = r1;	 Catch:{ Throwable -> 0x0237 }
        r1 = 3;
        r7 = r2.e;	 Catch:{ Throwable -> 0x0237 }
        r6[r1] = r7;	 Catch:{ Throwable -> 0x0237 }
        r1 = 4;
        r7 = r3.J;	 Catch:{ Throwable -> 0x0237 }
        r6[r1] = r7;	 Catch:{ Throwable -> 0x0237 }
        r1 = 5;
        r7 = r3.K;	 Catch:{ Throwable -> 0x0237 }
        r6[r1] = r7;	 Catch:{ Throwable -> 0x0237 }
        r1 = 6;
        r3 = r3.M;	 Catch:{ Throwable -> 0x0237 }
        r6[r1] = r3;	 Catch:{ Throwable -> 0x0237 }
        com.tencent.bugly.proguard.an.c(r5, r6);	 Catch:{ Throwable -> 0x0237 }
        r1 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0237 }
        r1.<init>();	 Catch:{ Throwable -> 0x0237 }
        r3 = "grayStrategyUpdateTime";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0237 }
        r5.<init>();	 Catch:{ Throwable -> 0x0237 }
        r6 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Throwable -> 0x0237 }
        r6 = r6.F;	 Catch:{ Throwable -> 0x0237 }
        r6 = r6.b;	 Catch:{ Throwable -> 0x0237 }
        r5.append(r6);	 Catch:{ Throwable -> 0x0237 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0237 }
        r1.put(r3, r5);	 Catch:{ Throwable -> 0x0237 }
        if (r22 == 0) goto L_0x021e;
    L_0x0201:
        r7 = com.tencent.bugly.proguard.ak.a();	 Catch:{ Throwable -> 0x0237 }
        r8 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r9 = r2.g;	 Catch:{ Throwable -> 0x0237 }
        r10 = com.tencent.bugly.proguard.ah.a(r2);	 Catch:{ Throwable -> 0x0237 }
        r14 = 0;
        r15 = 1;
        r16 = 1;
        r11 = r23;
        r12 = r23;
        r13 = r21;
        r17 = r1;
        r7.a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ Throwable -> 0x0237 }
        monitor-exit(r18);
        return;
    L_0x021e:
        r7 = com.tencent.bugly.proguard.ak.a();	 Catch:{ Throwable -> 0x0237 }
        r8 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r9 = r2.g;	 Catch:{ Throwable -> 0x0237 }
        r10 = com.tencent.bugly.proguard.ah.a(r2);	 Catch:{ Throwable -> 0x0237 }
        r14 = 0;
        r11 = r23;
        r12 = r23;
        r13 = r21;
        r15 = r1;
        r7.a(r8, r9, r10, r11, r12, r13, r14, r15);	 Catch:{ Throwable -> 0x0237 }
    L_0x0235:
        monitor-exit(r18);
        return;
    L_0x0237:
        r0 = move-exception;
        goto L_0x023c;
    L_0x0239:
        r0 = move-exception;
        r4 = r19;
    L_0x023c:
        r1 = r0;
        r2 = com.tencent.bugly.proguard.an.a(r1);	 Catch:{ all -> 0x0255 }
        if (r2 != 0) goto L_0x0246;
    L_0x0243:
        r1.printStackTrace();	 Catch:{ all -> 0x0255 }
    L_0x0246:
        r5 = 0;
        r6 = 0;
        r8 = 0;
        r10 = 0;
        r11 = "sendRequest failed";
        r3 = r21;
        r3.a(r4, r5, r6, r8, r10, r11);	 Catch:{ all -> 0x0255 }
        monitor-exit(r18);
        return;
    L_0x0255:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r18);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.b.a(int, byte[], com.tencent.bugly.beta.upgrade.a, boolean, java.lang.String):void");
    }

    public synchronized void a(x xVar, boolean z) {
        if (xVar != null) {
            try {
                a(SecExceptionCode.SEC_ERROR_PKG_VALID_NO_MEMORY, ah.a((m) xVar), new a(2, SecExceptionCode.SEC_ERROR_PKG_VALID_NO_MEMORY, xVar, Boolean.valueOf(z)), false, e.E.F.a.d);
            } catch (x xVar2) {
                if (!an.b(xVar2)) {
                    xVar2.printStackTrace();
                }
            }
        }
    }
}
