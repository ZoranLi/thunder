package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BUGLY */
public class a {
    private Context a;
    private long b;
    private int c;
    private boolean d = true;

    /* compiled from: BUGLY */
    class a implements Runnable {
        final /* synthetic */ a a;
        private boolean b;
        private UserInfoBean c;

        public a(a aVar, UserInfoBean userInfoBean, boolean z) {
            this.a = aVar;
            this.c = userInfoBean;
            this.b = z;
        }

        private void a(UserInfoBean userInfoBean) {
            if (userInfoBean != null) {
                com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                if (b != null) {
                    userInfoBean.j = b.e();
                }
            }
        }

        public void run() {
            try {
                if (this.c != null) {
                    a(this.c);
                    an.c("[UserInfo] Record user info.", new Object[0]);
                    this.a.a(this.c, false);
                }
                if (this.b) {
                    this.a.b();
                }
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* compiled from: BUGLY */
    class b implements Runnable {
        final /* synthetic */ a a;

        b(a aVar) {
            this.a = aVar;
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.a.b) {
                am.a().a(new b(this.a), (this.a.b - currentTimeMillis) + 5000);
                return;
            }
            this.a.a(3, false, 0);
            this.a.a();
        }
    }

    /* compiled from: BUGLY */
    class c implements Runnable {
        final /* synthetic */ a a;
        private long b = 21600000;

        public c(a aVar, long j) {
            this.a = aVar;
            this.b = j;
        }

        public void run() {
            this.a.b();
            this.a.b(this.b);
        }
    }

    public a(Context context, boolean z) {
        this.a = context;
        this.d = z;
    }

    private static UserInfoBean a(Context context, int i) {
        context = com.tencent.bugly.crashreport.common.info.a.a(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.b = i;
        userInfoBean.c = context.e;
        userInfoBean.d = context.g();
        userInfoBean.e = System.currentTimeMillis();
        userInfoBean.f = -1;
        userInfoBean.n = context.o;
        int i2 = 1;
        if (i != 1) {
            i2 = 0;
        }
        userInfoBean.o = i2;
        userInfoBean.l = context.a();
        userInfoBean.m = context.u;
        userInfoBean.g = context.v;
        userInfoBean.h = context.w;
        userInfoBean.i = context.x;
        userInfoBean.k = context.y;
        userInfoBean.r = context.B();
        userInfoBean.s = context.G();
        userInfoBean.p = context.H();
        userInfoBean.q = context.I();
        return userInfoBean;
    }

    public void a(int i, boolean z, long j) {
        com.tencent.bugly.crashreport.common.strategy.a a = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a == null || a.c().h || i == 1 || i == 3) {
            if (i == 1 || i == 3) {
                this.c++;
            }
            am.a().a(new a(this, a(this.a, i), z), j);
            return;
        }
        an.e("UserInfo is disable", new Object[false]);
    }

    public void a(long j) {
        am.a().a(new a(this, null, true), j);
    }

    public void b(long j) {
        am.a().a(new c(this, j), j);
    }

    public void a() {
        this.b = ap.b() + 86400000;
        am.a().a(new b(this), (this.b - System.currentTimeMillis()) + 5000);
    }

    private synchronized void c() {
        a aVar = this;
        synchronized (this) {
            if (aVar.d) {
                ak a = ak.a();
                if (a == null) {
                    return;
                }
                List a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
                if (a2 == null) {
                    return;
                }
                com.tencent.bugly.crashreport.common.strategy.a b = a2.b();
                if (b != null) {
                    b = a.b(1001);
                    if (b == null) {
                        return;
                    }
                }
                int i;
                try {
                    String str = com.tencent.bugly.crashreport.common.info.a.a(aVar.a).e;
                    ArrayList arrayList = new ArrayList();
                    ArrayList a3 = a(str);
                    i = 0;
                    int i2 = 1;
                    int size;
                    int i3;
                    m size2;
                    bd a4;
                    aj anonymousClass1;
                    StrategyBean c;
                    if (a3 != null) {
                        size = a3.size() - 20;
                        if (size > 0) {
                            while (i3 < b.size() - i2) {
                                int i4 = i3 + 1;
                                for (int i5 = i4; i5 < b.size(); i5++) {
                                    if (((UserInfoBean) b.get(i3)).e > ((UserInfoBean) b.get(i5)).e) {
                                        UserInfoBean userInfoBean = (UserInfoBean) b.get(i3);
                                        b.set(i3, b.get(i5));
                                        b.set(i5, userInfoBean);
                                    }
                                }
                                i3 = i4;
                            }
                            for (i3 = i; i3 < size; i3++) {
                                r4.add(b.get(i3));
                            }
                        }
                        Iterator it = b.iterator();
                        i3 = i;
                        while (it.hasNext()) {
                            UserInfoBean userInfoBean2 = (UserInfoBean) it.next();
                            if (userInfoBean2.f != -1) {
                                it.remove();
                                if (userInfoBean2.e < ap.b()) {
                                    r4.add(userInfoBean2);
                                }
                            }
                            if (userInfoBean2.e > System.currentTimeMillis() - 600000 && (userInfoBean2.b == i2 || userInfoBean2.b == 4 || userInfoBean2.b == 3)) {
                                i3++;
                            }
                        }
                        if (i3 > 15) {
                            Object[] objArr = new Object[i2];
                            objArr[i] = Integer.valueOf(i3);
                            an.d("[UserInfo] Upload user info too many times in 10 min: %d", objArr);
                            size = i;
                            i3 = size2.size();
                            if (i3 > 0) {
                                a((List) size2);
                            }
                            if (size != null) {
                                size2 = a2.size();
                                if (size2 == null) {
                                    size = new Object[i2];
                                    i3 = Integer.valueOf(a2.size());
                                    size[i] = i3;
                                    an.c("[UserInfo] Upload user info(size: %d)", size);
                                    arrayList = ah.a(a2, aVar.c == i2 ? i2 : 2);
                                    if (arrayList == null) {
                                        an.d("[UserInfo] Failed to create UserInfoPackage.", new Object[i]);
                                        return;
                                    }
                                    arrayList = ah.a((m) arrayList);
                                    if (arrayList == null) {
                                        an.d("[UserInfo] Failed to encode data.", new Object[i]);
                                        return;
                                    }
                                    size = a.b ? 840 : 640;
                                    i3 = aVar.a;
                                    a4 = ah.a((Context) i3, size, (byte[]) arrayList);
                                    if (a4 == null) {
                                        an.d("[UserInfo] Request package is null.", new Object[i]);
                                        return;
                                    }
                                    anonymousClass1 = new aj(aVar) {
                                        final /* synthetic */ a b;

                                        public void a(int i) {
                                        }

                                        public void a(int i, be beVar, long j, long j2, boolean z, String str) {
                                            if (z) {
                                                an.c("[UserInfo] Successfully uploaded user info.", new Object[null]);
                                                i = System.currentTimeMillis();
                                                for (UserInfoBean userInfoBean : a2) {
                                                    userInfoBean.f = i;
                                                    this.b.a(userInfoBean, true);
                                                }
                                            }
                                        }
                                    };
                                    c = com.tencent.bugly.crashreport.common.strategy.a.a().c();
                                    ak.a().a(1001, a4, a.b ? c.r : c.t, a.b ? StrategyBean.b : StrategyBean.a, anonymousClass1, aVar.c == i2 ? i2 : i);
                                    return;
                                }
                            }
                            a2 = new Object[i];
                            an.c("[UserInfo] There is no user info in local database.", a2);
                        }
                        size = i2;
                        i3 = size2.size();
                        if (i3 > 0) {
                            a((List) size2);
                        }
                        if (size != null) {
                            size2 = a2.size();
                            if (size2 == null) {
                                size = new Object[i2];
                                i3 = Integer.valueOf(a2.size());
                                size[i] = i3;
                                an.c("[UserInfo] Upload user info(size: %d)", size);
                                if (aVar.c == i2) {
                                }
                                arrayList = ah.a(a2, aVar.c == i2 ? i2 : 2);
                                if (arrayList == null) {
                                    arrayList = ah.a((m) arrayList);
                                    if (arrayList == null) {
                                        if (a.b) {
                                        }
                                        i3 = aVar.a;
                                        a4 = ah.a((Context) i3, size, (byte[]) arrayList);
                                        if (a4 == null) {
                                            anonymousClass1 = /* anonymous class already generated */;
                                            c = com.tencent.bugly.crashreport.common.strategy.a.a().c();
                                            if (a.b) {
                                            }
                                            if (a.b) {
                                            }
                                            if (aVar.c == i2) {
                                            }
                                            ak.a().a(1001, a4, a.b ? c.r : c.t, a.b ? StrategyBean.b : StrategyBean.a, anonymousClass1, aVar.c == i2 ? i2 : i);
                                            return;
                                        }
                                        an.d("[UserInfo] Request package is null.", new Object[i]);
                                        return;
                                    }
                                    an.d("[UserInfo] Failed to encode data.", new Object[i]);
                                    return;
                                }
                                an.d("[UserInfo] Failed to create UserInfoPackage.", new Object[i]);
                                return;
                            }
                        }
                        a2 = new Object[i];
                        an.c("[UserInfo] There is no user info in local database.", a2);
                    }
                    b = new ArrayList();
                    size = i2;
                    i3 = size2.size();
                    if (i3 > 0) {
                        a((List) size2);
                    }
                    if (size != null) {
                        size2 = a2.size();
                        if (size2 == null) {
                            size = new Object[i2];
                            i3 = Integer.valueOf(a2.size());
                            size[i] = i3;
                            an.c("[UserInfo] Upload user info(size: %d)", size);
                            if (aVar.c == i2) {
                            }
                            arrayList = ah.a(a2, aVar.c == i2 ? i2 : 2);
                            if (arrayList == null) {
                                an.d("[UserInfo] Failed to create UserInfoPackage.", new Object[i]);
                                return;
                            }
                            arrayList = ah.a((m) arrayList);
                            if (arrayList == null) {
                                an.d("[UserInfo] Failed to encode data.", new Object[i]);
                                return;
                            }
                            if (a.b) {
                            }
                            i3 = aVar.a;
                            a4 = ah.a((Context) i3, size, (byte[]) arrayList);
                            if (a4 == null) {
                                an.d("[UserInfo] Request package is null.", new Object[i]);
                                return;
                            }
                            anonymousClass1 = /* anonymous class already generated */;
                            c = com.tencent.bugly.crashreport.common.strategy.a.a().c();
                            if (a.b) {
                            }
                            if (a.b) {
                            }
                            if (aVar.c == i2) {
                            }
                            ak.a().a(1001, a4, a.b ? c.r : c.t, a.b ? StrategyBean.b : StrategyBean.a, anonymousClass1, aVar.c == i2 ? i2 : i);
                            return;
                        }
                    }
                    a2 = new Object[i];
                    an.c("[UserInfo] There is no user info in local database.", a2);
                } finally {
                    a = 
/*
Method generation error in method: com.tencent.bugly.crashreport.biz.a.c():void
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x018f: MERGE  (r2_15 'a' com.tencent.bugly.proguard.ak) = (r0_1 int), (r5_6 'i' int) in method: com.tencent.bugly.crashreport.biz.a.c():void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:227)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 40 more

*/

                    public void b() {
                        am a = am.a();
                        if (a != null) {
                            a.a(new Runnable(this) {
                                final /* synthetic */ a a;

                                {
                                    this.a = r1;
                                }

                                public void run() {
                                    try {
                                        this.a.c();
                                    } catch (Throwable th) {
                                        an.a(th);
                                    }
                                }
                            });
                        }
                    }

                    private void a(UserInfoBean userInfoBean, boolean z) {
                        if (userInfoBean != null) {
                            if (!(z || userInfoBean.b)) {
                                z = a(com.tencent.bugly.crashreport.common.info.a.a(this.a).e);
                                if (z && z.size() >= 20) {
                                    an.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(z.size()));
                                    return;
                                }
                            }
                            long a = ae.a().a("t_ui", a(userInfoBean), null, true);
                            if (a >= 0) {
                                an.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a));
                                userInfoBean.a = a;
                            }
                        }
                    }

                    public java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> a(java.lang.String r13) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r12 = this;
                        r0 = 0;
                        r1 = com.tencent.bugly.proguard.ap.a(r13);	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        if (r1 == 0) goto L_0x0009;	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                    L_0x0007:
                        r4 = r0;	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        goto L_0x001d;	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                    L_0x0009:
                        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r2 = "_pc = '";	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r1.<init>(r2);	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r1.append(r13);	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r13 = "'";	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r1.append(r13);	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r13 = r1.toString();	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r4 = r13;	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                    L_0x001d:
                        r1 = com.tencent.bugly.proguard.ae.a();	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r2 = "t_ui";	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r3 = 0;	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r5 = 0;	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r6 = 0;	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r7 = 1;	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        r13 = r1.a(r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00a5, all -> 0x00a0 }
                        if (r13 != 0) goto L_0x0033;
                    L_0x002d:
                        if (r13 == 0) goto L_0x0032;
                    L_0x002f:
                        r13.close();
                    L_0x0032:
                        return r0;
                    L_0x0033:
                        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009e }
                        r1.<init>();	 Catch:{ Throwable -> 0x009e }
                        r2 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x009e }
                        r2.<init>();	 Catch:{ Throwable -> 0x009e }
                    L_0x003d:
                        r3 = r13.moveToNext();	 Catch:{ Throwable -> 0x009e }
                        r4 = 0;	 Catch:{ Throwable -> 0x009e }
                        if (r3 == 0) goto L_0x0069;	 Catch:{ Throwable -> 0x009e }
                    L_0x0044:
                        r3 = r12.a(r13);	 Catch:{ Throwable -> 0x009e }
                        if (r3 == 0) goto L_0x004e;	 Catch:{ Throwable -> 0x009e }
                    L_0x004a:
                        r2.add(r3);	 Catch:{ Throwable -> 0x009e }
                        goto L_0x003d;
                    L_0x004e:
                        r3 = "_id";	 Catch:{ Throwable -> 0x0061 }
                        r3 = r13.getColumnIndex(r3);	 Catch:{ Throwable -> 0x0061 }
                        r5 = r13.getLong(r3);	 Catch:{ Throwable -> 0x0061 }
                        r3 = " or _id = ";	 Catch:{ Throwable -> 0x0061 }
                        r1.append(r3);	 Catch:{ Throwable -> 0x0061 }
                        r1.append(r5);	 Catch:{ Throwable -> 0x0061 }
                        goto L_0x003d;
                    L_0x0061:
                        r3 = "[Database] unknown id.";	 Catch:{ Throwable -> 0x009e }
                        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x009e }
                        com.tencent.bugly.proguard.an.d(r3, r4);	 Catch:{ Throwable -> 0x009e }
                        goto L_0x003d;	 Catch:{ Throwable -> 0x009e }
                    L_0x0069:
                        r1 = r1.toString();	 Catch:{ Throwable -> 0x009e }
                        r3 = r1.length();	 Catch:{ Throwable -> 0x009e }
                        if (r3 <= 0) goto L_0x0098;	 Catch:{ Throwable -> 0x009e }
                    L_0x0073:
                        r3 = 4;	 Catch:{ Throwable -> 0x009e }
                        r7 = r1.substring(r3);	 Catch:{ Throwable -> 0x009e }
                        r5 = com.tencent.bugly.proguard.ae.a();	 Catch:{ Throwable -> 0x009e }
                        r6 = "t_ui";	 Catch:{ Throwable -> 0x009e }
                        r8 = 0;	 Catch:{ Throwable -> 0x009e }
                        r9 = 0;	 Catch:{ Throwable -> 0x009e }
                        r10 = 1;	 Catch:{ Throwable -> 0x009e }
                        r1 = r5.a(r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x009e }
                        r3 = "[Database] deleted %s error data %d";	 Catch:{ Throwable -> 0x009e }
                        r5 = 2;	 Catch:{ Throwable -> 0x009e }
                        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x009e }
                        r6 = "t_ui";	 Catch:{ Throwable -> 0x009e }
                        r5[r4] = r6;	 Catch:{ Throwable -> 0x009e }
                        r4 = 1;	 Catch:{ Throwable -> 0x009e }
                        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x009e }
                        r5[r4] = r1;	 Catch:{ Throwable -> 0x009e }
                        com.tencent.bugly.proguard.an.d(r3, r5);	 Catch:{ Throwable -> 0x009e }
                    L_0x0098:
                        if (r13 == 0) goto L_0x009d;
                    L_0x009a:
                        r13.close();
                    L_0x009d:
                        return r2;
                    L_0x009e:
                        r1 = move-exception;
                        goto L_0x00a7;
                    L_0x00a0:
                        r13 = move-exception;
                        r11 = r0;
                        r0 = r13;
                        r13 = r11;
                        goto L_0x00b7;
                    L_0x00a5:
                        r1 = move-exception;
                        r13 = r0;
                    L_0x00a7:
                        r2 = com.tencent.bugly.proguard.an.a(r1);	 Catch:{ all -> 0x00b6 }
                        if (r2 != 0) goto L_0x00b0;	 Catch:{ all -> 0x00b6 }
                    L_0x00ad:
                        r1.printStackTrace();	 Catch:{ all -> 0x00b6 }
                    L_0x00b0:
                        if (r13 == 0) goto L_0x00b5;
                    L_0x00b2:
                        r13.close();
                    L_0x00b5:
                        return r0;
                    L_0x00b6:
                        r0 = move-exception;
                    L_0x00b7:
                        if (r13 == 0) goto L_0x00bc;
                    L_0x00b9:
                        r13.close();
                    L_0x00bc:
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.a.a(java.lang.String):java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>");
                    }

                    public void a(List<UserInfoBean> list) {
                        if (list != null) {
                            if (list.size() != 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                int i = 0;
                                while (i < list.size() && i < 50) {
                                    UserInfoBean userInfoBean = (UserInfoBean) list.get(i);
                                    stringBuilder.append(" or _id = ");
                                    stringBuilder.append(userInfoBean.a);
                                    i++;
                                }
                                list = stringBuilder.toString();
                                if (list.length() > 0) {
                                    list = list.substring(4);
                                }
                                String str = list;
                                stringBuilder.setLength(0);
                                try {
                                    list = ae.a().a("t_ui", str, null, null, true);
                                    an.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(list));
                                } catch (List<UserInfoBean> list2) {
                                    if (!an.a(list2)) {
                                        list2.printStackTrace();
                                    }
                                }
                            }
                        }
                    }

                    protected ContentValues a(UserInfoBean userInfoBean) {
                        if (userInfoBean == null) {
                            return null;
                        }
                        try {
                            ContentValues contentValues = new ContentValues();
                            if (userInfoBean.a > 0) {
                                contentValues.put("_id", Long.valueOf(userInfoBean.a));
                            }
                            contentValues.put("_tm", Long.valueOf(userInfoBean.e));
                            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
                            contentValues.put("_tp", Integer.valueOf(userInfoBean.b));
                            contentValues.put("_pc", userInfoBean.c);
                            contentValues.put("_dt", ap.a((Parcelable) userInfoBean));
                            return contentValues;
                        } catch (UserInfoBean userInfoBean2) {
                            if (!an.a(userInfoBean2)) {
                                userInfoBean2.printStackTrace();
                            }
                            return null;
                        }
                    }

                    protected UserInfoBean a(Cursor cursor) {
                        if (cursor == null) {
                            return null;
                        }
                        try {
                            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
                            if (blob == null) {
                                return null;
                            }
                            long j = cursor.getLong(cursor.getColumnIndex("_id"));
                            UserInfoBean userInfoBean = (UserInfoBean) ap.a(blob, UserInfoBean.CREATOR);
                            if (userInfoBean != null) {
                                userInfoBean.a = j;
                            }
                            return userInfoBean;
                        } catch (Cursor cursor2) {
                            if (!an.a(cursor2)) {
                                cursor2.printStackTrace();
                            }
                            return null;
                        }
                    }
                }
