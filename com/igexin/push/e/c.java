package com.igexin.push.e;

import android.content.Context;
import android.content.Intent;
import com.igexin.push.core.d;
import com.igexin.push.core.g;
import com.igexin.push.d.c.a;
import com.igexin.push.d.c.b;
import com.igexin.push.d.c.e;
import com.igexin.push.d.c.f;
import com.igexin.push.d.c.i;
import com.igexin.push.d.c.k;
import com.igexin.push.d.c.m;
import com.igexin.push.d.c.n;
import com.igexin.push.d.c.o;
import com.igexin.push.d.c.p;
import com.igexin.push.d.c.q;
import com.igexin.push.f.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class c {
    private Context a;
    private d b;
    private h c;
    private h d;
    private b e;
    private List<i> f;
    private Map<String, b> g;
    private Map<String, b> h;
    private boolean i;

    private e a(byte[] bArr) {
        e qVar;
        b b = b(bArr);
        byte b2 = b.b;
        if (b2 == (byte) 9) {
            qVar = new q();
        } else if (b2 != (byte) 96) {
            switch (b2) {
                case (byte) 4:
                    qVar = new k();
                    break;
                case (byte) 5:
                    qVar = new m();
                    break;
                case (byte) 6:
                    qVar = new f();
                    break;
                default:
                    switch (b2) {
                        case (byte) 25:
                            qVar = new com.igexin.push.d.c.d();
                            break;
                        case (byte) 26:
                            qVar = new p();
                            break;
                        case (byte) 27:
                            qVar = new com.igexin.push.d.c.c();
                            break;
                        case (byte) 28:
                            qVar = new a();
                            break;
                        default:
                            switch (b2) {
                                case (byte) 36:
                                    qVar = new n();
                                    break;
                                case (byte) 37:
                                    qVar = new o();
                                    break;
                                default:
                                    qVar = null;
                                    break;
                            }
                    }
            }
        } else {
            qVar = new i();
        }
        if (qVar != null) {
            qVar.a(b.e);
        }
        return qVar;
    }

    private b b(byte[] bArr) {
        b bVar = new b();
        bVar.a = com.igexin.b.a.b.f.c(bArr, 0);
        bVar.b = bArr[2];
        bVar.e = new byte[bVar.a];
        com.igexin.b.a.b.f.a(bArr, 3, bVar.e, 0, bVar.a);
        return bVar;
    }

    private void b(a aVar) {
        switch (h.b[aVar.a.ordinal()]) {
            case 1:
                this.f.clear();
                this.g.clear();
                this.h.clear();
                if (this.c != null) {
                    this.c.u();
                }
                if (this.d != null) {
                    this.d.u();
                }
                this.i = false;
                boolean z = g.i;
                boolean z2 = g.j;
                boolean a = com.igexin.push.util.a.a(System.currentTimeMillis());
                boolean b = com.igexin.push.util.a.b();
                if (z && z2 && !a && b) {
                    if (com.igexin.push.config.m.n) {
                        Intent intent = new Intent();
                        intent.setAction("com.igexin.sdk.action.snlrefresh");
                        intent.putExtra("groupid", g.d);
                        intent.putExtra("branch", "open");
                        intent.putExtra("responseSNLAction", g.V);
                        this.a.sendBroadcast(intent);
                        this.c = new d(this, 1000);
                        com.igexin.push.core.f.a().a(this.c);
                        return;
                    }
                    com.igexin.b.a.c.a.b("SNLCoordinator|isSnl = false, doActive");
                    d();
                }
                return;
            case 2:
                int size = this.f.size();
                if (size == 0) {
                    d();
                    return;
                }
                i iVar = (i) this.f.get(0);
                for (int i = 1; i < size; i++) {
                    i iVar2 = (i) this.f.get(i);
                    if (iVar2.c() < iVar.c()) {
                        iVar = iVar2;
                    }
                }
                if (this.a.getPackageName().equals(iVar.a())) {
                    d();
                    return;
                }
                this.b = d.prepare;
                this.e = new b();
                this.e.a(iVar.a());
                this.e.b(iVar.b());
                aVar = new a();
                aVar.a(com.igexin.push.core.c.determine);
                a(aVar);
                return;
            case 3:
            case 4:
                if (this.c != null) {
                    this.c.u();
                }
                c();
                return;
            default:
                return;
        }
    }

    private void b(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.g;
        r0 = r0.get(r6);
        r0 = (com.igexin.push.e.b) r0;
        r1 = new com.igexin.push.e.g;
        r1.<init>(r5, r0, r6);
        r0.a(r1);
        r1 = r5.a;	 Catch:{ Exception -> 0x0036 }
        r2 = r0.a();	 Catch:{ Exception -> 0x0036 }
        r3 = 3;	 Catch:{ Exception -> 0x0036 }
        r1 = r1.createPackageContext(r2, r3);	 Catch:{ Exception -> 0x0036 }
        r2 = r1.getClassLoader();	 Catch:{ Exception -> 0x0036 }
        r3 = r0.b();	 Catch:{ Exception -> 0x0036 }
        r2 = r2.loadClass(r3);	 Catch:{ Exception -> 0x0036 }
        r3 = new android.content.Intent;	 Catch:{ Exception -> 0x0036 }
        r3.<init>(r1, r2);	 Catch:{ Exception -> 0x0036 }
        r1 = r5.a;	 Catch:{ Exception -> 0x0036 }
        r2 = r0.d();	 Catch:{ Exception -> 0x0036 }
        r4 = 0;	 Catch:{ Exception -> 0x0036 }
        r1.bindService(r3, r2, r4);	 Catch:{ Exception -> 0x0036 }
    L_0x0036:
        r1 = r5.g;
        r1.put(r6, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.c.b(java.lang.String):void");
    }

    private List<String> c(String str) {
        List<String> arrayList = new ArrayList();
        for (Entry entry : this.h.entrySet()) {
            if (((b) entry.getValue()).e().equals(str)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    private void c() {
        this.b = d.init;
        a aVar = new a();
        aVar.a(com.igexin.push.core.c.start);
        a(aVar);
    }

    private void c(com.igexin.push.e.a r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = com.igexin.push.e.h.b;
        r7 = r7.a;
        r7 = r7.ordinal();
        r7 = r0[r7];
        switch(r7) {
            case 3: goto L_0x0079;
            case 4: goto L_0x0079;
            case 5: goto L_0x0030;
            case 6: goto L_0x000e;
            default: goto L_0x000d;
        };
    L_0x000d:
        return;
    L_0x000e:
        r7 = r6.e;	 Catch:{ Exception -> 0x002f }
        r0 = r7.c();	 Catch:{ Exception -> 0x002f }
        r7 = r6.a;	 Catch:{ Exception -> 0x002f }
        r1 = r7.getPackageName();	 Catch:{ Exception -> 0x002f }
        r7 = com.igexin.push.core.a.f.a();	 Catch:{ Exception -> 0x002f }
        r2 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x002f }
        r7 = r7.a(r2);	 Catch:{ Exception -> 0x002f }
        r2 = r7.getName();	 Catch:{ Exception -> 0x002f }
        r3 = "";	 Catch:{ Exception -> 0x002f }
        r4 = 0;	 Catch:{ Exception -> 0x002f }
        r0.onPSNLConnected(r1, r2, r3, r4);	 Catch:{ Exception -> 0x002f }
    L_0x002f:
        return;
    L_0x0030:
        r7 = new com.igexin.push.e.e;
        r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r7.<init>(r6, r0);
        r6.d = r7;
        r7 = com.igexin.push.core.f.a();
        r0 = r6.d;
        r7.a(r0);
        r7 = r6.e;
        r0 = new com.igexin.push.e.f;
        r0.<init>(r6);
        r7.a(r0);
        r7 = r6.a;	 Catch:{ Exception -> 0x0078 }
        r0 = r6.e;	 Catch:{ Exception -> 0x0078 }
        r0 = r0.a();	 Catch:{ Exception -> 0x0078 }
        r1 = 3;	 Catch:{ Exception -> 0x0078 }
        r7 = r7.createPackageContext(r0, r1);	 Catch:{ Exception -> 0x0078 }
        r0 = r7.getClassLoader();	 Catch:{ Exception -> 0x0078 }
        r1 = r6.e;	 Catch:{ Exception -> 0x0078 }
        r1 = r1.b();	 Catch:{ Exception -> 0x0078 }
        r0 = r0.loadClass(r1);	 Catch:{ Exception -> 0x0078 }
        r1 = new android.content.Intent;	 Catch:{ Exception -> 0x0078 }
        r1.<init>(r7, r0);	 Catch:{ Exception -> 0x0078 }
        r7 = r6.a;	 Catch:{ Exception -> 0x0078 }
        r0 = r6.e;	 Catch:{ Exception -> 0x0078 }
        r0 = r0.d();	 Catch:{ Exception -> 0x0078 }
        r2 = 0;	 Catch:{ Exception -> 0x0078 }
        r7.bindService(r1, r0, r2);	 Catch:{ Exception -> 0x0078 }
    L_0x0078:
        return;
    L_0x0079:
        r7 = r6.d;
        if (r7 == 0) goto L_0x0082;
    L_0x007d:
        r7 = r6.d;
        r7.u();
    L_0x0082:
        r7 = r6.e;
        r7 = r7.c();
        if (r7 == 0) goto L_0x0095;
    L_0x008a:
        r7 = r6.a;	 Catch:{ Exception -> 0x0095 }
        r0 = r6.e;	 Catch:{ Exception -> 0x0095 }
        r0 = r0.d();	 Catch:{ Exception -> 0x0095 }
        r7.unbindService(r0);	 Catch:{ Exception -> 0x0095 }
    L_0x0095:
        r6.c();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.c.c(com.igexin.push.e.a):void");
    }

    private void d() {
        this.f.clear();
        this.b = d.active;
        if (this.i) {
            for (Entry key : this.g.entrySet()) {
                b((String) key.getKey());
            }
            this.i = false;
        }
        StringBuilder stringBuilder = new StringBuilder("SNLCoordinator|doActive, state = ");
        stringBuilder.append(this.b);
        stringBuilder.append(", setASNL = true");
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        com.igexin.push.core.f.a().g().a(true);
    }

    private void d(com.igexin.push.e.a r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = com.igexin.push.e.h.b;
        r4 = r4.a;
        r4 = r4.ordinal();
        r4 = r0[r4];
        r0 = 7;
        if (r4 == r0) goto L_0x00b9;
    L_0x000d:
        r0 = 0;
        switch(r4) {
            case 3: goto L_0x0065;
            case 4: goto L_0x0012;
            default: goto L_0x0011;
        };
    L_0x0011:
        return;
    L_0x0012:
        r1 = java.lang.System.currentTimeMillis();
        com.igexin.push.core.g.U = r1;
        r4 = r3.g;
        r4 = r4.entrySet();
        r4 = r4.iterator();
    L_0x0022:
        r1 = r4.hasNext();
        if (r1 == 0) goto L_0x003e;
    L_0x0028:
        r1 = r4.next();
        r1 = (java.util.Map.Entry) r1;
        r2 = r3.a;	 Catch:{ Exception -> 0x0022 }
        r1 = r1.getValue();	 Catch:{ Exception -> 0x0022 }
        r1 = (com.igexin.push.e.b) r1;	 Catch:{ Exception -> 0x0022 }
        r1 = r1.d();	 Catch:{ Exception -> 0x0022 }
        r2.unbindService(r1);	 Catch:{ Exception -> 0x0022 }
        goto L_0x0022;
    L_0x003e:
        r4 = new java.lang.StringBuilder;
        r1 = "SNLCoordinator | state = ";
        r4.<init>(r1);
        r1 = com.igexin.push.core.d.passive;
        r4.append(r1);
        r1 = ", setASNL(false)";
        r4.append(r1);
        r4 = r4.toString();
        com.igexin.b.a.c.a.b(r4);
        r4 = com.igexin.push.core.f.a();
        r4 = r4.g();
        r4.a(r0);
        r3.c();
        return;
    L_0x0065:
        r4 = "SNLCoordinator|event = stop, setASNL(false)";
        com.igexin.b.a.c.a.b(r4);
        r4 = com.igexin.push.core.f.a();
        r4 = r4.g();
        r4.a(r0);
        r4 = com.igexin.push.core.f.a();
        r4 = r4.g();
        r0 = 1;
        r4.b(r0);
        r4 = com.igexin.push.config.m.n;
        if (r4 == 0) goto L_0x00a3;
    L_0x0085:
        r4 = new android.content.Intent;
        r4.<init>();
        r0 = "com.igexin.sdk.action.snlretire";
        r4.setAction(r0);
        r0 = "groupid";
        r1 = com.igexin.push.core.g.d;
        r4.putExtra(r0, r1);
        r0 = "branch";
        r1 = "open";
        r4.putExtra(r0, r1);
        r0 = r3.a;
        r0.sendBroadcast(r4);
        return;
    L_0x00a3:
        r4 = new com.igexin.push.e.a;
        r4.<init>();
        r0 = com.igexin.push.core.c.retire;
        r4.a(r0);
        r0 = com.igexin.push.core.f.a();
        r0 = r0.h();
        r0.a(r4);
        return;
    L_0x00b9:
        r4 = new android.content.Intent;
        r4.<init>();
        r0 = "com.igexin.sdk.action.snlretire";
        r4.setAction(r0);
        r0 = "groupid";
        r1 = com.igexin.push.core.g.d;
        r4.putExtra(r0, r1);
        r0 = "branch";
        r1 = "open";
        r4.putExtra(r0, r1);
        r0 = r3.a;
        r0.sendBroadcast(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.c.d(com.igexin.push.e.a):void");
    }

    private void e(com.igexin.push.e.a r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = com.igexin.push.e.h.b;
        r6 = r6.a;
        r6 = r6.ordinal();
        r6 = r0[r6];
        r0 = 1;
        switch(r6) {
            case 3: goto L_0x000f;
            case 4: goto L_0x003b;
            default: goto L_0x000e;
        };
    L_0x000e:
        return;
    L_0x000f:
        r6 = com.igexin.push.core.g.l;
        if (r6 == 0) goto L_0x003b;
    L_0x0013:
        r6 = new com.igexin.push.d.c.n;
        r6.<init>();
        r1 = com.igexin.push.core.g.q;
        r6.a = r1;
        r1 = com.igexin.push.core.f.a();
        r1 = r1.g();
        r2 = new java.lang.StringBuilder;
        r3 = "S-";
        r2.<init>(r3);
        r3 = com.igexin.push.core.g.q;
        r3 = java.lang.String.valueOf(r3);
        r2.append(r3);
        r2 = r2.toString();
        r1.a(r2, r6, r0);
    L_0x003b:
        r1 = java.lang.System.currentTimeMillis();
        com.igexin.push.core.g.U = r1;
        r6 = com.igexin.push.core.f.a();
        r6 = r6.g();
        r6.b(r0);
        r6 = r5.a;	 Catch:{ Exception -> 0x0057 }
        r0 = r5.e;	 Catch:{ Exception -> 0x0057 }
        r0 = r0.d();	 Catch:{ Exception -> 0x0057 }
        r6.unbindService(r0);	 Catch:{ Exception -> 0x0057 }
    L_0x0057:
        r5.c();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.c.e(com.igexin.push.e.a):void");
    }

    public int a(String str) {
        if (this.b != d.prepare || str.equals("")) {
            return -1;
        }
        this.d.u();
        this.g.clear();
        this.h.clear();
        this.i = false;
        this.f.clear();
        this.e.c(str);
        this.b = d.passive;
        StringBuilder stringBuilder = new StringBuilder("SNLCoordinator | state = ");
        stringBuilder.append(d.passive);
        stringBuilder.append(", setASNL(false)");
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        com.igexin.push.core.f.a().g().a(false);
        return 0;
    }

    public int a(java.lang.String r3, com.igexin.push.d.c.e r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new com.igexin.push.d.c.b;
        r0.<init>();
        r1 = r4.d();
        r0.e = r1;
        r1 = r0.e;
        if (r1 == 0) goto L_0x003d;
    L_0x000f:
        r1 = r0.e;
        r1 = r1.length;
        r0.a = r1;
        r4 = r4.i;
        r4 = (byte) r4;
        r0.b = r4;
        r4 = r0.a();
        r0 = r2.e;
        if (r0 == 0) goto L_0x003d;
    L_0x0021:
        r0 = r2.e;
        r0 = r0.c();
        if (r0 == 0) goto L_0x003d;
    L_0x0029:
        r0 = r2.e;	 Catch:{ Exception -> 0x003a }
        r0 = r0.c();	 Catch:{ Exception -> 0x003a }
        r1 = r2.e;	 Catch:{ Exception -> 0x003a }
        r1 = r1.e();	 Catch:{ Exception -> 0x003a }
        r3 = r0.sendByASNL(r1, r3, r4);	 Catch:{ Exception -> 0x003a }
        return r3;
    L_0x003a:
        r2.c();
    L_0x003d:
        r3 = -1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.c.a(java.lang.String, com.igexin.push.d.c.e):int");
    }

    public int a(String str, String str2) {
        if (this.b == d.prepare || this.b == d.passive) {
            return -1;
        }
        b bVar = new b();
        bVar.a(str);
        bVar.b(str2);
        bVar.c(str);
        this.g.put(str, bVar);
        if (this.b == d.active) {
            b(str);
        } else {
            this.i = true;
        }
        return 0;
    }

    public int a(String str, String str2, byte[] bArr) {
        e a = a(bArr);
        b bVar = (b) this.g.get(str);
        if (bVar == null || !g.l) {
            return -1;
        }
        this.h.put(str2, bVar);
        return com.igexin.push.core.f.a().g().a(str2, a);
    }

    public void a(Context context) {
        this.a = context;
        this.b = d.init;
        this.f = new ArrayList();
        this.g = new HashMap();
        this.h = new HashMap();
    }

    public void a(Intent intent) {
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        if (intent.getAction().equals("com.igexin.sdk.action.snlrefresh") && com.igexin.push.config.m.n) {
            stringExtra = intent.getStringExtra("groupid");
            stringExtra2 = intent.getStringExtra("responseSNLAction");
            boolean z = g.i;
            boolean z2 = g.j;
            stringExtra3 = intent.getStringExtra("branch");
            boolean a = com.igexin.push.util.a.a(System.currentTimeMillis());
            long a2 = com.igexin.push.core.q.a() + com.igexin.push.core.q.b();
            if (g.d.equals(stringExtra) && "open".equals(stringExtra3) && z && z2 && !a) {
                intent = new Intent();
                intent.setAction(stringExtra2);
                intent.putExtra("groupid", g.d);
                intent.putExtra("branch", "open");
                intent.putExtra("pkgname", g.f.getPackageName());
                intent.putExtra("classname", com.igexin.push.core.a.f.a().a(g.f));
                intent.putExtra("startup_time", g.U);
                intent.putExtra("network_traffic", a2);
                g.f.sendBroadcast(intent);
            }
        } else if (intent.getAction().equals(g.V) && com.igexin.push.config.m.n) {
            stringExtra = intent.getStringExtra("groupid");
            stringExtra2 = intent.getStringExtra("branch");
            if (g.d.equals(stringExtra) && "open".equals(stringExtra2)) {
                i iVar = new i();
                iVar.a(intent.getStringExtra("groupid"));
                iVar.b(intent.getStringExtra("pkgname"));
                iVar.c(intent.getStringExtra("classname"));
                iVar.a(intent.getLongExtra("startup_time", 0));
                iVar.b(intent.getLongExtra("network_traffic", 0));
                this.f.add(iVar);
            }
        } else {
            if (intent.getAction().equals("com.igexin.sdk.action.snlretire") && com.igexin.push.config.m.n) {
                stringExtra = intent.getStringExtra("groupid");
                stringExtra3 = intent.getStringExtra("branch");
                if (g.d.equals(stringExtra) && "open".equals(stringExtra3)) {
                    a aVar = new a();
                    aVar.a(com.igexin.push.core.c.retire);
                    com.igexin.push.core.f.a().h().a(aVar);
                }
            }
        }
    }

    public void a(a aVar) {
        StringBuilder stringBuilder = new StringBuilder("SNLCoordinator|state = ");
        stringBuilder.append(this.b);
        stringBuilder.append(", doEvent = ");
        stringBuilder.append(aVar.a);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        switch (h.a[this.b.ordinal()]) {
            case 1:
                b(aVar);
                return;
            case 2:
                c(aVar);
                return;
            case 3:
                d(aVar);
                return;
            case 4:
                e(aVar);
                return;
            default:
                return;
        }
    }

    public boolean a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.b;
        r1 = com.igexin.push.core.d.active;
        if (r0 != r1) goto L_0x002c;
    L_0x0006:
        r0 = r2.g;
        r0 = r0.entrySet();
        r0 = r0.iterator();
    L_0x0010:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x002a;
    L_0x0016:
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        r1 = r1.getValue();	 Catch:{ Exception -> 0x0010 }
        r1 = (com.igexin.push.e.b) r1;	 Catch:{ Exception -> 0x0010 }
        r1 = r1.c();	 Catch:{ Exception -> 0x0010 }
        r1.onASNLNetworkConnected();	 Catch:{ Exception -> 0x0010 }
        goto L_0x0010;
    L_0x002a:
        r0 = 1;
        return r0;
    L_0x002c:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.c.a():boolean");
    }

    public int b(java.lang.String r6, com.igexin.push.d.c.e r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new com.igexin.push.d.c.b;
        r0.<init>();
        r1 = r7.d();
        r0.e = r1;
        r1 = r0.e;
        r1 = r1.length;
        r0.a = r1;
        r7 = r7.i;
        r7 = (byte) r7;
        r0.b = r7;
        r7 = r0.a();
        r0 = r5.h;
        r0 = r0.get(r6);
        r0 = (com.igexin.push.e.b) r0;
        if (r0 == 0) goto L_0x0066;
    L_0x0023:
        r1 = "S-";	 Catch:{ RemoteException -> 0x0058 }
        r1 = r6.startsWith(r1);	 Catch:{ RemoteException -> 0x0058 }
        if (r1 == 0) goto L_0x004b;	 Catch:{ RemoteException -> 0x0058 }
    L_0x002b:
        r1 = 2;	 Catch:{ RemoteException -> 0x0058 }
        r2 = r6.length();	 Catch:{ RemoteException -> 0x0058 }
        r1 = r6.substring(r1, r2);	 Catch:{ RemoteException -> 0x0058 }
        r1 = com.igexin.b.b.a.a(r1);	 Catch:{ RemoteException -> 0x0058 }
        r2 = r5.h;	 Catch:{ RemoteException -> 0x0058 }
        r3 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0058 }
        r4 = "C-";	 Catch:{ RemoteException -> 0x0058 }
        r3.<init>(r4);	 Catch:{ RemoteException -> 0x0058 }
        r3.append(r1);	 Catch:{ RemoteException -> 0x0058 }
        r1 = r3.toString();	 Catch:{ RemoteException -> 0x0058 }
        r2.put(r1, r0);	 Catch:{ RemoteException -> 0x0058 }
    L_0x004b:
        r1 = r0.c();	 Catch:{ RemoteException -> 0x0058 }
        r2 = r0.e();	 Catch:{ RemoteException -> 0x0058 }
        r7 = r1.receiveToPSNL(r2, r6, r7);	 Catch:{ RemoteException -> 0x0058 }
        return r7;
    L_0x0058:
        r7 = r5.g;
        r0 = r0.e();
        r7.remove(r0);
        r7 = r5.h;
        r7.remove(r6);
    L_0x0066:
        r6 = -1;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.c.b(java.lang.String, com.igexin.push.d.c.e):int");
    }

    public int b(String str, String str2, byte[] bArr) {
        com.igexin.push.core.f.a().g().a(a(bArr));
        return 0;
    }

    public boolean b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.b;
        r1 = com.igexin.push.core.d.active;
        if (r0 != r1) goto L_0x002c;
    L_0x0006:
        r0 = r2.g;
        r0 = r0.entrySet();
        r0 = r0.iterator();
    L_0x0010:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x002a;
    L_0x0016:
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        r1 = r1.getValue();	 Catch:{ Exception -> 0x0010 }
        r1 = (com.igexin.push.e.b) r1;	 Catch:{ Exception -> 0x0010 }
        r1 = r1.c();	 Catch:{ Exception -> 0x0010 }
        r1.onASNLNetworkDisconnected();	 Catch:{ Exception -> 0x0010 }
        goto L_0x0010;
    L_0x002a:
        r0 = 1;
        return r0;
    L_0x002c:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.c.b():boolean");
    }
}
