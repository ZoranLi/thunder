package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.a;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
public class al implements Runnable {
    public int a;
    public int b;
    protected int c;
    protected long d;
    protected long e;
    protected boolean f;
    private final Context g;
    private final int h;
    private final byte[] i;
    private final a j;
    private final com.tencent.bugly.crashreport.common.strategy.a k;
    private final ai l;
    private final ak m;
    private final int n;
    private final aj o;
    private final aj p;
    private String q;
    private final String r;
    private final Map<String, String> s;
    private boolean t;

    public al(Context context, int i, int i2, byte[] bArr, String str, String str2, aj ajVar, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, ajVar, z, 2, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, z2, null);
    }

    public al(Context context, int i, int i2, byte[] bArr, String str, String str2, aj ajVar, boolean z, int i3, int i4, boolean z2, Map<String, String> map) {
        this.a = 2;
        this.b = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        this.q = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.t = false;
        this.g = context;
        this.j = a.a(context);
        this.i = bArr;
        this.k = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.l = ai.a(context);
        this.m = ak.a();
        this.n = i;
        this.q = str;
        this.r = str2;
        this.o = ajVar;
        this.p = this.m.a;
        this.f = z;
        this.h = i2;
        if (i3 > 0) {
            this.a = i3;
        }
        if (i4 > 0) {
            this.b = i4;
        }
        this.t = z2;
        this.s = map;
    }

    protected void a() {
        this.m.a(this.n, System.currentTimeMillis());
        if (this.o != null) {
            this.o.a(this.h);
        }
        if (this.p != null) {
            this.p.a(this.h);
        }
    }

    protected void a(int i, String str) {
        an.e("[Upload] Failed to upload(%d): %s", Integer.valueOf(i), str);
    }

    protected void a(be beVar, boolean z, int i, String str, int i2) {
        String valueOf;
        int i3 = this.h;
        if (i3 != 630) {
            if (i3 != 640) {
                if (i3 != 830) {
                    if (i3 != 840) {
                        valueOf = String.valueOf(this.h);
                        if (z) {
                            an.a("[Upload] Success: %s", valueOf);
                        } else {
                            an.e("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i), valueOf, str);
                            if (this.f != 0) {
                                this.m.a(i2, null);
                            }
                        }
                        if (this.d + this.e > 0) {
                            this.m.a((this.m.a(this.t) + this.d) + this.e, this.t);
                        }
                        if (this.o != 0) {
                            this.o.a(this.h, beVar, this.d, this.e, z, str);
                        }
                        if (this.p == 0) {
                            this.p.a(this.h, beVar, this.d, this.e, z, str);
                        }
                    }
                }
            }
            valueOf = "userinfo";
            if (z) {
                an.e("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i), valueOf, str);
                if (this.f != 0) {
                    this.m.a(i2, null);
                }
            } else {
                an.a("[Upload] Success: %s", valueOf);
            }
            if (this.d + this.e > 0) {
                this.m.a((this.m.a(this.t) + this.d) + this.e, this.t);
            }
            if (this.o != 0) {
                this.o.a(this.h, beVar, this.d, this.e, z, str);
            }
            if (this.p == 0) {
                this.p.a(this.h, beVar, this.d, this.e, z, str);
            }
        }
        valueOf = "crash";
        if (z) {
            an.a("[Upload] Success: %s", valueOf);
        } else {
            an.e("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i), valueOf, str);
            if (this.f != 0) {
                this.m.a(i2, null);
            }
        }
        if (this.d + this.e > 0) {
            this.m.a((this.m.a(this.t) + this.d) + this.e, this.t);
        }
        if (this.o != 0) {
            this.o.a(this.h, beVar, this.d, this.e, z, str);
        }
        if (this.p == 0) {
            this.p.a(this.h, beVar, this.d, this.e, z, str);
        }
    }

    protected boolean a(be beVar, a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (beVar == null) {
            an.d("resp == null!", new Object[0]);
            return false;
        } else if (beVar.a != (byte) 0) {
            an.e("resp result error %d", new Object[]{Byte.valueOf(beVar.a)});
            return false;
        } else {
            try {
                if (!(ap.a(beVar.d) || a.b().i().equals(beVar.d))) {
                    ae.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "key_ip", beVar.d.getBytes("UTF-8"), null, true);
                    aVar.d(beVar.d);
                }
                if (!(ap.a(beVar.g) || a.b().j().equals(beVar.g))) {
                    ae.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "key_imei", beVar.g.getBytes("UTF-8"), null, true);
                    aVar.e(beVar.g);
                }
            } catch (Throwable th) {
                an.a(th);
            }
            aVar.n = beVar.e;
            if (beVar.b == 510) {
                if (beVar.c == null) {
                    an.e("[Upload] Strategy data is null. Response cmd: %d", new Object[]{Integer.valueOf(beVar.b)});
                    return false;
                }
                bg bgVar = (bg) ah.a(beVar.c, bg.class);
                if (bgVar == null) {
                    an.e("[Upload] Failed to decode strategy from server. Response cmd: %d", new Object[]{Integer.valueOf(beVar.b)});
                    return false;
                }
                aVar2.a(bgVar);
            }
            return true;
        }
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r23 = this;
        r7 = r23;
        r1 = 0;
        r7.c = r1;	 Catch:{ Throwable -> 0x03c3 }
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r7.d = r2;	 Catch:{ Throwable -> 0x03c3 }
        r7.e = r2;	 Catch:{ Throwable -> 0x03c3 }
        r4 = r7.i;	 Catch:{ Throwable -> 0x03c3 }
        r5 = r7.g;	 Catch:{ Throwable -> 0x03c3 }
        r5 = com.tencent.bugly.crashreport.common.info.b.f(r5);	 Catch:{ Throwable -> 0x03c3 }
        if (r5 != 0) goto L_0x0020;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0015:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "network is not available";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0020:
        if (r4 == 0) goto L_0x03b8;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0022:
        r5 = r4.length;	 Catch:{ Throwable -> 0x03c3 }
        if (r5 != 0) goto L_0x0027;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0025:
        goto L_0x03b8;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0027:
        r5 = r7.m;	 Catch:{ Throwable -> 0x03c3 }
        r6 = r7.t;	 Catch:{ Throwable -> 0x03c3 }
        r5 = r5.a(r6);	 Catch:{ Throwable -> 0x03c3 }
        r8 = r4.length;	 Catch:{ Throwable -> 0x03c3 }
        r8 = (long) r8;	 Catch:{ Throwable -> 0x03c3 }
        r10 = r5 + r8;	 Catch:{ Throwable -> 0x03c3 }
        r8 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;	 Catch:{ Throwable -> 0x03c3 }
        r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));	 Catch:{ Throwable -> 0x03c3 }
        r10 = 2;	 Catch:{ Throwable -> 0x03c3 }
        r11 = 1;	 Catch:{ Throwable -> 0x03c3 }
        if (r12 < 0) goto L_0x005a;	 Catch:{ Throwable -> 0x03c3 }
    L_0x003c:
        r2 = "[Upload] Upload too much data, try next time: %d/%d";	 Catch:{ Throwable -> 0x03c3 }
        r3 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x03c3 }
        r4 = java.lang.Long.valueOf(r5);	 Catch:{ Throwable -> 0x03c3 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x03c3 }
        r1 = java.lang.Long.valueOf(r8);	 Catch:{ Throwable -> 0x03c3 }
        r3[r11] = r1;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.e(r2, r3);	 Catch:{ Throwable -> 0x03c3 }
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "over net consume: 2048K";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x005a:
        r5 = "[Upload] Run upload task with cmd: %d";	 Catch:{ Throwable -> 0x03c3 }
        r6 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x03c3 }
        r8 = r7.h;	 Catch:{ Throwable -> 0x03c3 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x03c3 }
        r6[r1] = r8;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.c(r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        r5 = r7.g;	 Catch:{ Throwable -> 0x03c3 }
        if (r5 == 0) goto L_0x03ad;	 Catch:{ Throwable -> 0x03c3 }
    L_0x006d:
        r5 = r7.j;	 Catch:{ Throwable -> 0x03c3 }
        if (r5 == 0) goto L_0x03ad;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0071:
        r5 = r7.k;	 Catch:{ Throwable -> 0x03c3 }
        if (r5 == 0) goto L_0x03ad;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0075:
        r5 = r7.l;	 Catch:{ Throwable -> 0x03c3 }
        if (r5 != 0) goto L_0x007b;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0079:
        goto L_0x03ad;	 Catch:{ Throwable -> 0x03c3 }
    L_0x007b:
        r5 = r7.k;	 Catch:{ Throwable -> 0x03c3 }
        r5 = r5.c();	 Catch:{ Throwable -> 0x03c3 }
        if (r5 != 0) goto L_0x008e;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0083:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "illegal local strategy";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x008e:
        r6 = new java.util.HashMap;	 Catch:{ Throwable -> 0x03c3 }
        r6.<init>();	 Catch:{ Throwable -> 0x03c3 }
        r8 = "prodId";	 Catch:{ Throwable -> 0x03c3 }
        r9 = r7.j;	 Catch:{ Throwable -> 0x03c3 }
        r9 = r9.f();	 Catch:{ Throwable -> 0x03c3 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r8 = "bundleId";	 Catch:{ Throwable -> 0x03c3 }
        r9 = r7.j;	 Catch:{ Throwable -> 0x03c3 }
        r9 = r9.d;	 Catch:{ Throwable -> 0x03c3 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r8 = "appVer";	 Catch:{ Throwable -> 0x03c3 }
        r9 = r7.j;	 Catch:{ Throwable -> 0x03c3 }
        r9 = r9.o;	 Catch:{ Throwable -> 0x03c3 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r8 = r7.s;	 Catch:{ Throwable -> 0x03c3 }
        if (r8 == 0) goto L_0x00b9;	 Catch:{ Throwable -> 0x03c3 }
    L_0x00b4:
        r8 = r7.s;	 Catch:{ Throwable -> 0x03c3 }
        r6.putAll(r8);	 Catch:{ Throwable -> 0x03c3 }
    L_0x00b9:
        r8 = r7.f;	 Catch:{ Throwable -> 0x03c3 }
        if (r8 == 0) goto L_0x011f;	 Catch:{ Throwable -> 0x03c3 }
    L_0x00bd:
        r8 = "cmd";	 Catch:{ Throwable -> 0x03c3 }
        r9 = r7.h;	 Catch:{ Throwable -> 0x03c3 }
        r9 = java.lang.Integer.toString(r9);	 Catch:{ Throwable -> 0x03c3 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r8 = "platformId";	 Catch:{ Throwable -> 0x03c3 }
        r9 = java.lang.Byte.toString(r11);	 Catch:{ Throwable -> 0x03c3 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r8 = "sdkVer";	 Catch:{ Throwable -> 0x03c3 }
        r9 = r7.j;	 Catch:{ Throwable -> 0x03c3 }
        r9.getClass();	 Catch:{ Throwable -> 0x03c3 }
        r9 = "2.6.5";	 Catch:{ Throwable -> 0x03c3 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r8 = "strategylastUpdateTime";	 Catch:{ Throwable -> 0x03c3 }
        r12 = r5.p;	 Catch:{ Throwable -> 0x03c3 }
        r9 = java.lang.Long.toString(r12);	 Catch:{ Throwable -> 0x03c3 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r8 = r7.m;	 Catch:{ Throwable -> 0x03c3 }
        r8 = r8.a(r6);	 Catch:{ Throwable -> 0x03c3 }
        if (r8 != 0) goto L_0x00fb;	 Catch:{ Throwable -> 0x03c3 }
    L_0x00f0:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "failed to add security info to HTTP headers";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x00fb:
        r4 = com.tencent.bugly.proguard.ap.a(r4, r10);	 Catch:{ Throwable -> 0x03c3 }
        if (r4 != 0) goto L_0x010c;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0101:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "failed to zip request body";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x010c:
        r8 = r7.m;	 Catch:{ Throwable -> 0x03c3 }
        r4 = r8.a(r4);	 Catch:{ Throwable -> 0x03c3 }
        if (r4 != 0) goto L_0x011f;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0114:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "failed to encrypt request body";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x011f:
        r23.a();	 Catch:{ Throwable -> 0x03c3 }
        r8 = r7.q;	 Catch:{ Throwable -> 0x03c3 }
        r9 = -1;	 Catch:{ Throwable -> 0x03c3 }
        r12 = r8;	 Catch:{ Throwable -> 0x03c3 }
        r13 = r9;	 Catch:{ Throwable -> 0x03c3 }
        r8 = r1;	 Catch:{ Throwable -> 0x03c3 }
        r9 = r8;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0129:
        r14 = r8 + 1;	 Catch:{ Throwable -> 0x03c3 }
        r15 = r7.a;	 Catch:{ Throwable -> 0x03c3 }
        if (r8 >= r15) goto L_0x03a2;	 Catch:{ Throwable -> 0x03c3 }
    L_0x012f:
        if (r14 <= r11) goto L_0x0155;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0131:
        r8 = "[Upload] Failed to upload last time, wait and try(%d) again.";	 Catch:{ Throwable -> 0x03c3 }
        r9 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x03c3 }
        r15 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x03c3 }
        r9[r1] = r15;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.d(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r8 = r7.b;	 Catch:{ Throwable -> 0x03c3 }
        r8 = (long) r8;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.ap.b(r8);	 Catch:{ Throwable -> 0x03c3 }
        r8 = r7.a;	 Catch:{ Throwable -> 0x03c3 }
        if (r14 != r8) goto L_0x0155;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0148:
        r8 = "[Upload] Use the back-up url at the last time: %s";	 Catch:{ Throwable -> 0x03c3 }
        r9 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x03c3 }
        r12 = r7.r;	 Catch:{ Throwable -> 0x03c3 }
        r9[r1] = r12;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.d(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r12 = r7.r;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0155:
        r8 = "[Upload] Send %d bytes";	 Catch:{ Throwable -> 0x03c3 }
        r9 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x03c3 }
        r15 = r4.length;	 Catch:{ Throwable -> 0x03c3 }
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ Throwable -> 0x03c3 }
        r9[r1] = r15;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.c(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r8 = r7.f;	 Catch:{ Throwable -> 0x03c3 }
        if (r8 == 0) goto L_0x016c;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0167:
        r8 = a(r12);	 Catch:{ Throwable -> 0x03c3 }
        r12 = r8;	 Catch:{ Throwable -> 0x03c3 }
    L_0x016c:
        r8 = "[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).";	 Catch:{ Throwable -> 0x03c3 }
        r9 = 4;	 Catch:{ Throwable -> 0x03c3 }
        r9 = new java.lang.Object[r9];	 Catch:{ Throwable -> 0x03c3 }
        r9[r1] = r12;	 Catch:{ Throwable -> 0x03c3 }
        r15 = r7.h;	 Catch:{ Throwable -> 0x03c3 }
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ Throwable -> 0x03c3 }
        r9[r11] = r15;	 Catch:{ Throwable -> 0x03c3 }
        r15 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x03c3 }
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ Throwable -> 0x03c3 }
        r9[r10] = r15;	 Catch:{ Throwable -> 0x03c3 }
        r15 = android.os.Process.myTid();	 Catch:{ Throwable -> 0x03c3 }
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ Throwable -> 0x03c3 }
        r2 = 3;	 Catch:{ Throwable -> 0x03c3 }
        r9[r2] = r15;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.c(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r3 = r7.l;	 Catch:{ Throwable -> 0x03c3 }
        r3 = r3.a(r12, r4, r7, r6);	 Catch:{ Throwable -> 0x03c3 }
        if (r3 != 0) goto L_0x01a5;	 Catch:{ Throwable -> 0x03c3 }
    L_0x019b:
        r2 = "Failed to upload for no response!";	 Catch:{ Throwable -> 0x03c3 }
        r7.a(r11, r2);	 Catch:{ Throwable -> 0x03c3 }
    L_0x01a0:
        r9 = r11;	 Catch:{ Throwable -> 0x03c3 }
        r8 = r14;	 Catch:{ Throwable -> 0x03c3 }
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        goto L_0x0129;	 Catch:{ Throwable -> 0x03c3 }
    L_0x01a5:
        r8 = r7.l;	 Catch:{ Throwable -> 0x03c3 }
        r8 = r8.b;	 Catch:{ Throwable -> 0x03c3 }
        r9 = r7.f;	 Catch:{ Throwable -> 0x03c3 }
        if (r9 == 0) goto L_0x02df;	 Catch:{ Throwable -> 0x03c3 }
    L_0x01ad:
        r9 = a(r8);	 Catch:{ Throwable -> 0x03c3 }
        if (r9 != 0) goto L_0x020b;	 Catch:{ Throwable -> 0x03c3 }
    L_0x01b3:
        r2 = "[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).";	 Catch:{ Throwable -> 0x03c3 }
        r3 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x03c3 }
        r9 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x03c3 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x03c3 }
        r3[r1] = r9;	 Catch:{ Throwable -> 0x03c3 }
        r9 = android.os.Process.myTid();	 Catch:{ Throwable -> 0x03c3 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x03c3 }
        r3[r11] = r9;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.c(r2, r3);	 Catch:{ Throwable -> 0x03c3 }
        r2 = "[Upload] Failed to upload for no status header.";	 Catch:{ Throwable -> 0x03c3 }
        r7.a(r11, r2);	 Catch:{ Throwable -> 0x03c3 }
        if (r8 == 0) goto L_0x0203;	 Catch:{ Throwable -> 0x03c3 }
    L_0x01d5:
        r2 = r8.entrySet();	 Catch:{ Throwable -> 0x03c3 }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x03c3 }
    L_0x01dd:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x03c3 }
        if (r3 == 0) goto L_0x0203;	 Catch:{ Throwable -> 0x03c3 }
    L_0x01e3:
        r3 = r2.next();	 Catch:{ Throwable -> 0x03c3 }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ Throwable -> 0x03c3 }
        r8 = "[key]: %s, [value]: %s";	 Catch:{ Throwable -> 0x03c3 }
        r9 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x03c3 }
        r15 = r3.getKey();	 Catch:{ Throwable -> 0x03c3 }
        r9[r1] = r15;	 Catch:{ Throwable -> 0x03c3 }
        r3 = r3.getValue();	 Catch:{ Throwable -> 0x03c3 }
        r9[r11] = r3;	 Catch:{ Throwable -> 0x03c3 }
        r3 = java.lang.String.format(r8, r9);	 Catch:{ Throwable -> 0x03c3 }
        r8 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.c(r3, r8);	 Catch:{ Throwable -> 0x03c3 }
        goto L_0x01dd;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0203:
        r2 = "[Upload] Failed to upload for no status header.";	 Catch:{ Throwable -> 0x03c3 }
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.c(r2, r3);	 Catch:{ Throwable -> 0x03c3 }
        goto L_0x01a0;
    L_0x020b:
        r9 = "status";	 Catch:{ Throwable -> 0x02c3 }
        r9 = r8.get(r9);	 Catch:{ Throwable -> 0x02c3 }
        r9 = (java.lang.String) r9;	 Catch:{ Throwable -> 0x02c3 }
        r9 = java.lang.Integer.parseInt(r9);	 Catch:{ Throwable -> 0x02c3 }
        r13 = "[Upload] Status from server is %d (pid=%d | tid=%d).";	 Catch:{ Throwable -> 0x02bf }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x02bf }
        r15 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x02bf }
        r2[r1] = r15;	 Catch:{ Throwable -> 0x02bf }
        r15 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x02bf }
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ Throwable -> 0x02bf }
        r2[r11] = r15;	 Catch:{ Throwable -> 0x02bf }
        r15 = android.os.Process.myTid();	 Catch:{ Throwable -> 0x02bf }
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ Throwable -> 0x02bf }
        r2[r10] = r15;	 Catch:{ Throwable -> 0x02bf }
        com.tencent.bugly.proguard.an.c(r13, r2);	 Catch:{ Throwable -> 0x02bf }
        if (r9 == 0) goto L_0x02bd;
    L_0x023a:
        if (r9 != r10) goto L_0x02a6;
    L_0x023c:
        r2 = r7.d;	 Catch:{ Throwable -> 0x03c3 }
        r4 = r7.e;	 Catch:{ Throwable -> 0x03c3 }
        r12 = r2 + r4;	 Catch:{ Throwable -> 0x03c3 }
        r15 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r2 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1));	 Catch:{ Throwable -> 0x03c3 }
        if (r2 <= 0) goto L_0x025f;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0248:
        r2 = r7.m;	 Catch:{ Throwable -> 0x03c3 }
        r3 = r7.t;	 Catch:{ Throwable -> 0x03c3 }
        r2 = r2.a(r3);	 Catch:{ Throwable -> 0x03c3 }
        r4 = r7.d;	 Catch:{ Throwable -> 0x03c3 }
        r12 = r2 + r4;	 Catch:{ Throwable -> 0x03c3 }
        r2 = r7.e;	 Catch:{ Throwable -> 0x03c3 }
        r4 = r12 + r2;	 Catch:{ Throwable -> 0x03c3 }
        r2 = r7.m;	 Catch:{ Throwable -> 0x03c3 }
        r3 = r7.t;	 Catch:{ Throwable -> 0x03c3 }
        r2.a(r4, r3);	 Catch:{ Throwable -> 0x03c3 }
    L_0x025f:
        r2 = r7.m;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r2.a(r9, r3);	 Catch:{ Throwable -> 0x03c3 }
        r2 = "[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).";	 Catch:{ Throwable -> 0x03c3 }
        r3 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x03c3 }
        r4 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x03c3 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x03c3 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x03c3 }
        r1 = android.os.Process.myTid();	 Catch:{ Throwable -> 0x03c3 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x03c3 }
        r3[r11] = r1;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.a(r2, r3);	 Catch:{ Throwable -> 0x03c3 }
        r12 = r7.m;	 Catch:{ Throwable -> 0x03c3 }
        r13 = r7.n;	 Catch:{ Throwable -> 0x03c3 }
        r14 = r7.h;	 Catch:{ Throwable -> 0x03c3 }
        r15 = r7.i;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7.q;	 Catch:{ Throwable -> 0x03c3 }
        r2 = r7.r;	 Catch:{ Throwable -> 0x03c3 }
        r3 = r7.o;	 Catch:{ Throwable -> 0x03c3 }
        r4 = r7.a;	 Catch:{ Throwable -> 0x03c3 }
        r5 = r7.b;	 Catch:{ Throwable -> 0x03c3 }
        r21 = 1;	 Catch:{ Throwable -> 0x03c3 }
        r6 = r7.s;	 Catch:{ Throwable -> 0x03c3 }
        r16 = r1;	 Catch:{ Throwable -> 0x03c3 }
        r17 = r2;	 Catch:{ Throwable -> 0x03c3 }
        r18 = r3;	 Catch:{ Throwable -> 0x03c3 }
        r19 = r4;	 Catch:{ Throwable -> 0x03c3 }
        r20 = r5;	 Catch:{ Throwable -> 0x03c3 }
        r22 = r6;	 Catch:{ Throwable -> 0x03c3 }
        r12.a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x02a6:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 1;	 Catch:{ Throwable -> 0x03c3 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "status of server is ";	 Catch:{ Throwable -> 0x03c3 }
        r1.<init>(r5);	 Catch:{ Throwable -> 0x03c3 }
        r1.append(r9);	 Catch:{ Throwable -> 0x03c3 }
        r5 = r1.toString();	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r6 = r9;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x02bd:
        r13 = r9;	 Catch:{ Throwable -> 0x03c3 }
        goto L_0x02df;	 Catch:{ Throwable -> 0x03c3 }
    L_0x02bf:
        r15 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r13 = r9;	 Catch:{ Throwable -> 0x03c3 }
        goto L_0x02c5;	 Catch:{ Throwable -> 0x03c3 }
    L_0x02c3:
        r15 = 0;	 Catch:{ Throwable -> 0x03c3 }
    L_0x02c5:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03c3 }
        r3 = "[Upload] Failed to upload for format of status header is invalid: ";	 Catch:{ Throwable -> 0x03c3 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x03c3 }
        r3 = java.lang.Integer.toString(r13);	 Catch:{ Throwable -> 0x03c3 }
        r2.append(r3);	 Catch:{ Throwable -> 0x03c3 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x03c3 }
        r7.a(r11, r2);	 Catch:{ Throwable -> 0x03c3 }
        r9 = r11;	 Catch:{ Throwable -> 0x03c3 }
        r8 = r14;	 Catch:{ Throwable -> 0x03c3 }
        r2 = r15;	 Catch:{ Throwable -> 0x03c3 }
        goto L_0x0129;	 Catch:{ Throwable -> 0x03c3 }
    L_0x02df:
        r2 = "[Upload] Received %d bytes";	 Catch:{ Throwable -> 0x03c3 }
        r4 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x03c3 }
        r6 = r3.length;	 Catch:{ Throwable -> 0x03c3 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x03c3 }
        r4[r1] = r6;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.c(r2, r4);	 Catch:{ Throwable -> 0x03c3 }
        r2 = r7.f;	 Catch:{ Throwable -> 0x03c3 }
        if (r2 == 0) goto L_0x034b;	 Catch:{ Throwable -> 0x03c3 }
    L_0x02f1:
        r2 = r3.length;	 Catch:{ Throwable -> 0x03c3 }
        if (r2 != 0) goto L_0x0327;	 Catch:{ Throwable -> 0x03c3 }
    L_0x02f4:
        r2 = r8.entrySet();	 Catch:{ Throwable -> 0x03c3 }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x03c3 }
    L_0x02fc:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x03c3 }
        if (r3 == 0) goto L_0x031c;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0302:
        r3 = r2.next();	 Catch:{ Throwable -> 0x03c3 }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ Throwable -> 0x03c3 }
        r4 = "[Upload] HTTP headers from server: key = %s, value = %s";	 Catch:{ Throwable -> 0x03c3 }
        r5 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x03c3 }
        r6 = r3.getKey();	 Catch:{ Throwable -> 0x03c3 }
        r5[r1] = r6;	 Catch:{ Throwable -> 0x03c3 }
        r3 = r3.getValue();	 Catch:{ Throwable -> 0x03c3 }
        r5[r11] = r3;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.c(r4, r5);	 Catch:{ Throwable -> 0x03c3 }
        goto L_0x02fc;	 Catch:{ Throwable -> 0x03c3 }
    L_0x031c:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 1;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "response data from server is empty";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0327:
        r2 = r7.m;	 Catch:{ Throwable -> 0x03c3 }
        r2 = r2.b(r3);	 Catch:{ Throwable -> 0x03c3 }
        if (r2 != 0) goto L_0x033a;	 Catch:{ Throwable -> 0x03c3 }
    L_0x032f:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 1;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "failed to decrypt response from server";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x033a:
        r3 = com.tencent.bugly.proguard.ap.b(r2, r10);	 Catch:{ Throwable -> 0x03c3 }
        if (r3 != 0) goto L_0x034b;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0340:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 1;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "failed unzip(Gzip) response from server";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x034b:
        r2 = r7.f;	 Catch:{ Throwable -> 0x03c3 }
        r2 = com.tencent.bugly.proguard.ah.a(r3, r5, r2);	 Catch:{ Throwable -> 0x03c3 }
        if (r2 != 0) goto L_0x035e;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0353:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 1;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "failed to decode response package";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x035e:
        r3 = r7.f;	 Catch:{ Throwable -> 0x03c3 }
        if (r3 == 0) goto L_0x0367;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0362:
        r3 = r7.m;	 Catch:{ Throwable -> 0x03c3 }
        r3.a(r13, r2);	 Catch:{ Throwable -> 0x03c3 }
    L_0x0367:
        r3 = "[Upload] Response cmd is: %d, length of sBuffer is: %d";	 Catch:{ Throwable -> 0x03c3 }
        r4 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x03c3 }
        r5 = r2.b;	 Catch:{ Throwable -> 0x03c3 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x03c3 }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x03c3 }
        r5 = r2.c;	 Catch:{ Throwable -> 0x03c3 }
        if (r5 != 0) goto L_0x0378;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0377:
        goto L_0x037b;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0378:
        r1 = r2.c;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r1.length;	 Catch:{ Throwable -> 0x03c3 }
    L_0x037b:
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x03c3 }
        r4[r11] = r1;	 Catch:{ Throwable -> 0x03c3 }
        com.tencent.bugly.proguard.an.c(r3, r4);	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7.j;	 Catch:{ Throwable -> 0x03c3 }
        r3 = r7.k;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7.a(r2, r1, r3);	 Catch:{ Throwable -> 0x03c3 }
        if (r1 != 0) goto L_0x0398;	 Catch:{ Throwable -> 0x03c3 }
    L_0x038e:
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 2;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "failed to process response package";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x0398:
        r3 = 1;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 2;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "successfully uploaded";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x03a2:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "failed after many attempts";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r4 = r9;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x03ad:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "illegal access error";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;	 Catch:{ Throwable -> 0x03c3 }
    L_0x03b8:
        r2 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r4 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r5 = "request package is empty!";	 Catch:{ Throwable -> 0x03c3 }
        r6 = 0;	 Catch:{ Throwable -> 0x03c3 }
        r1 = r7;	 Catch:{ Throwable -> 0x03c3 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x03c3 }
        return;
    L_0x03c3:
        r0 = move-exception;
        r1 = r0;
        r2 = com.tencent.bugly.proguard.an.a(r1);
        if (r2 != 0) goto L_0x03ce;
    L_0x03cb:
        r1.printStackTrace();
    L_0x03ce:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.al.run():void");
    }

    public void a(String str, long j, String str2) {
        this.c++;
        this.d += j;
    }

    public void a(long j) {
        this.e += j;
    }

    private static String a(String str) {
        if (ap.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", new Object[]{str, UUID.randomUUID().toString()});
        } catch (Throwable th) {
            an.a(th);
            return str;
        }
    }

    private static boolean a(Map<String, String> map) {
        if (map != null) {
            if (map.size() != 0) {
                if (!map.containsKey("status")) {
                    an.d("[Upload] Headers does not contain %s", "status");
                    return false;
                } else if (map.containsKey("Bugly-Version")) {
                    if (((String) map.get("Bugly-Version")).contains("bugly")) {
                        an.c("[Upload] Bugly version from headers is: %s", (String) map.get("Bugly-Version"));
                        return true;
                    }
                    an.d("[Upload] Bugly version is not valid: %s", (String) map.get("Bugly-Version"));
                    return false;
                } else {
                    an.d("[Upload] Headers does not contain %s", "Bugly-Version");
                    return false;
                }
            }
        }
        an.d("[Upload] Headers is empty.", new Object[0]);
        return false;
    }
}
