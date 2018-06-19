package com.igexin.push.c;

import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.m;
import com.igexin.push.core.a.f;
import com.igexin.push.core.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {
    private static final String f = "com.igexin.push.c.a";
    public volatile d a = d.NORMAL;
    public AtomicBoolean b = new AtomicBoolean(false);
    protected int c;
    protected volatile long d;
    protected volatile long e;
    private int g;
    private int h;
    private int i;
    private j j;
    private final List<e> k = new ArrayList();
    private final List<j> l = new ArrayList();
    private final Object m = new Object();
    private final Object n = new Object();
    private int o = 0;
    private final Comparator<j> p = new b(this);

    private String a(boolean z) {
        String b;
        synchronized (this.m) {
            this.g = this.g >= this.l.size() ? 0 : this.g;
            this.j = (j) this.l.get(this.g);
            b = this.j.b(z);
        }
        return b;
    }

    private synchronized void a(d dVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f);
        stringBuilder.append("|set domain type = ");
        stringBuilder.append(dVar);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        if (m.f) {
            String stringBuilder2;
            if (this.a != dVar) {
                a(null);
            }
            switch (c.a[dVar.ordinal()]) {
                case 1:
                    break;
                case 2:
                    this.b.set(true);
                    if (this.a != dVar) {
                        this.d = System.currentTimeMillis();
                    }
                    SDKUrlConfig.setCmAddress(SDKUrlConfig.XFR_ADDRESS_BAK[0]);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(f);
                    stringBuilder.append("|set domain type backup cm = ");
                    stringBuilder.append(SDKUrlConfig.getCmAddress());
                    stringBuilder2 = stringBuilder.toString();
                    break;
                case 3:
                    if (this.a != dVar) {
                        this.o = 0;
                        break;
                    }
                    break;
                default:
                    break;
            }
            this.g = 0;
            SDKUrlConfig.setCmAddress(a(true));
            if (dVar == d.NORMAL) {
                this.b.set(false);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(f);
            stringBuilder.append("|set domain type normal cm = ");
            stringBuilder.append(SDKUrlConfig.getCmAddress());
            stringBuilder2 = stringBuilder.toString();
            com.igexin.b.a.c.a.b(stringBuilder2);
            this.a = dVar;
            i.a().i().p();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(boolean r11) {
        /*
        r10 = this;
        r0 = 0;
        r1 = r10.n;	 Catch:{ Exception -> 0x00ee }
        monitor-enter(r1);	 Catch:{ Exception -> 0x00ee }
        r2 = r10.k;	 Catch:{ all -> 0x00eb }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x00eb }
        r3 = 0;
        if (r2 == 0) goto L_0x0029;
    L_0x000d:
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r11.<init>();	 Catch:{ all -> 0x00eb }
        r2 = f;	 Catch:{ all -> 0x00eb }
        r11.append(r2);	 Catch:{ all -> 0x00eb }
        r2 = "cm list size = 0";
        r11.append(r2);	 Catch:{ all -> 0x00eb }
        r11 = r11.toString();	 Catch:{ all -> 0x00eb }
        com.igexin.b.a.c.a.b(r11);	 Catch:{ all -> 0x00eb }
        r10.i = r3;	 Catch:{ all -> 0x00eb }
        r10.h = r3;	 Catch:{ all -> 0x00eb }
        monitor-exit(r1);	 Catch:{ all -> 0x00eb }
        return r0;
    L_0x0029:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r2.<init>();	 Catch:{ all -> 0x00eb }
        r4 = f;	 Catch:{ all -> 0x00eb }
        r2.append(r4);	 Catch:{ all -> 0x00eb }
        r4 = "cm try = ";
        r2.append(r4);	 Catch:{ all -> 0x00eb }
        r4 = r10.i;	 Catch:{ all -> 0x00eb }
        r2.append(r4);	 Catch:{ all -> 0x00eb }
        r4 = " times";
        r2.append(r4);	 Catch:{ all -> 0x00eb }
        r2 = r2.toString();	 Catch:{ all -> 0x00eb }
        com.igexin.b.a.c.a.b(r2);	 Catch:{ all -> 0x00eb }
        r2 = r10.i;	 Catch:{ all -> 0x00eb }
        r4 = r10.k;	 Catch:{ all -> 0x00eb }
        r4 = r4.size();	 Catch:{ all -> 0x00eb }
        r4 = r4 * 3;
        if (r2 < r4) goto L_0x0076;
    L_0x0055:
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r11.<init>();	 Catch:{ all -> 0x00eb }
        r2 = f;	 Catch:{ all -> 0x00eb }
        r11.append(r2);	 Catch:{ all -> 0x00eb }
        r2 = "cm invalid";
        r11.append(r2);	 Catch:{ all -> 0x00eb }
        r11 = r11.toString();	 Catch:{ all -> 0x00eb }
        com.igexin.b.a.c.a.b(r11);	 Catch:{ all -> 0x00eb }
        r10.i = r3;	 Catch:{ all -> 0x00eb }
        r10.h = r3;	 Catch:{ all -> 0x00eb }
        r11 = r10.k;	 Catch:{ all -> 0x00eb }
        r11.clear();	 Catch:{ all -> 0x00eb }
        monitor-exit(r1);	 Catch:{ all -> 0x00eb }
        return r0;
    L_0x0076:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00eb }
        r2 = r10.k;	 Catch:{ all -> 0x00eb }
        r2 = r2.iterator();	 Catch:{ all -> 0x00eb }
    L_0x0080:
        r6 = r2.hasNext();	 Catch:{ all -> 0x00eb }
        if (r6 == 0) goto L_0x00b6;
    L_0x0086:
        r6 = r2.next();	 Catch:{ all -> 0x00eb }
        r6 = (com.igexin.push.c.e) r6;	 Catch:{ all -> 0x00eb }
        r7 = r6.b;	 Catch:{ all -> 0x00eb }
        r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1));
        if (r9 >= 0) goto L_0x0080;
    L_0x0092:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r7.<init>();	 Catch:{ all -> 0x00eb }
        r8 = f;	 Catch:{ all -> 0x00eb }
        r7.append(r8);	 Catch:{ all -> 0x00eb }
        r8 = "|add[";
        r7.append(r8);	 Catch:{ all -> 0x00eb }
        r6 = r6.a;	 Catch:{ all -> 0x00eb }
        r7.append(r6);	 Catch:{ all -> 0x00eb }
        r6 = "] outDate";
        r7.append(r6);	 Catch:{ all -> 0x00eb }
        r6 = r7.toString();	 Catch:{ all -> 0x00eb }
        com.igexin.b.a.c.a.b(r6);	 Catch:{ all -> 0x00eb }
        r2.remove();	 Catch:{ all -> 0x00eb }
        goto L_0x0080;
    L_0x00b6:
        r2 = r10.k;	 Catch:{ all -> 0x00eb }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x00eb }
        if (r2 == 0) goto L_0x00c0;
    L_0x00be:
        monitor-exit(r1);	 Catch:{ all -> 0x00eb }
        return r0;
    L_0x00c0:
        r2 = r10.h;	 Catch:{ all -> 0x00eb }
        r4 = r10.k;	 Catch:{ all -> 0x00eb }
        r4 = r4.size();	 Catch:{ all -> 0x00eb }
        if (r2 < r4) goto L_0x00cb;
    L_0x00ca:
        goto L_0x00cd;
    L_0x00cb:
        r3 = r10.h;	 Catch:{ all -> 0x00eb }
    L_0x00cd:
        r10.h = r3;	 Catch:{ all -> 0x00eb }
        r2 = r10.k;	 Catch:{ all -> 0x00eb }
        r3 = r10.h;	 Catch:{ all -> 0x00eb }
        r2 = r2.get(r3);	 Catch:{ all -> 0x00eb }
        r2 = (com.igexin.push.c.e) r2;	 Catch:{ all -> 0x00eb }
        r2 = r2.a;	 Catch:{ all -> 0x00eb }
        r3 = r10.h;	 Catch:{ all -> 0x00eb }
        r3 = r3 + 1;
        r10.h = r3;	 Catch:{ all -> 0x00eb }
        if (r11 == 0) goto L_0x00e9;
    L_0x00e3:
        r11 = r10.i;	 Catch:{ all -> 0x00eb }
        r11 = r11 + 1;
        r10.i = r11;	 Catch:{ all -> 0x00eb }
    L_0x00e9:
        monitor-exit(r1);	 Catch:{ all -> 0x00eb }
        return r2;
    L_0x00eb:
        r11 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00eb }
        throw r11;	 Catch:{ Exception -> 0x00ee }
    L_0x00ee:
        r11 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = f;
        r1.append(r2);
        r2 = "|";
        r1.append(r2);
        r11 = r11.toString();
        r1.append(r11);
        r11 = r1.toString();
        com.igexin.b.a.c.a.b(r11);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.a.b(boolean):java.lang.String");
    }

    private void k() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f);
        stringBuilder.append("|before disconnect, type = ");
        stringBuilder.append(this.a);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        switch (c.a[this.a.ordinal()]) {
            case 1:
                if (System.currentTimeMillis() - this.e > 172800000 && this.c > m.B) {
                    a(d.BACKUP);
                    break;
                }
            case 2:
                if (System.currentTimeMillis() - this.d > m.z) {
                    a(d.TRY_NORMAL);
                    return;
                }
                break;
            default:
                return;
        }
    }

    public void a() {
        try {
            boolean B = f.a().B() ^ 1;
            String b = b(B);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f);
            stringBuilder.append("|get from cm = ");
            stringBuilder.append(b);
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            if (b == null) {
                if (m.f && this.a == d.BACKUP) {
                    this.g = this.g >= SDKUrlConfig.XFR_ADDRESS_BAK.length ? 0 : this.g;
                    b = SDKUrlConfig.XFR_ADDRESS_BAK[this.g];
                    this.g++;
                } else {
                    if (!(this.j == null || this.j.f())) {
                        this.g++;
                    }
                    b = a(B);
                }
            }
            if (!SDKUrlConfig.getCmAddress().equals(b)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(f);
                stringBuilder2.append("|address changed : form [");
                stringBuilder2.append(SDKUrlConfig.getCmAddress());
                stringBuilder2.append("] to [");
                stringBuilder2.append(b);
                stringBuilder2.append("]");
                com.igexin.b.a.c.a.b(stringBuilder2.toString());
            }
            SDKUrlConfig.setCmAddress(b);
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(f);
            stringBuilder3.append("|switch address|");
            stringBuilder3.append(e.toString());
            com.igexin.b.a.c.a.b(stringBuilder3.toString());
        }
    }

    public void a(List<e> list) {
        synchronized (this.n) {
            this.h = 0;
            this.i = 0;
            this.k.clear();
            if (list != null) {
                this.k.addAll(list);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(f);
                stringBuilder.append("|set cm list: ");
                stringBuilder.append(list.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
        }
    }

    public synchronized void b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f);
        stringBuilder.append("|login or register success, cmConncetTryCnt = 0");
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        this.i = 0;
        if (this.j != null) {
            this.j.h();
        }
    }

    public void b(List<j> list) {
        synchronized (this.m) {
            this.l.clear();
            this.l.addAll(list);
            Collections.sort(this.l, this.p);
        }
    }

    public synchronized void c() {
        this.c++;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f);
        stringBuilder.append("|before login success, loginFailedlCnt = ");
        stringBuilder.append(this.c);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
    }

    public void d() {
        synchronized (this.m) {
            int i = 0;
            this.g = 0;
            Collections.sort(this.l, this.p);
            try {
                int length = SDKUrlConfig.getXfrAddress().length;
                if (length >= 3) {
                    while (i < this.l.size()) {
                        ((j) this.l.get(i)).b(length - i);
                        i++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(f);
                stringBuilder.append("|");
                stringBuilder.append(e.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
        }
    }

    public void e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f);
        stringBuilder.append("|detect success, current type = ");
        stringBuilder.append(this.a);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        if (this.a == d.BACKUP) {
            a(d.TRY_NORMAL);
            f.a().c(true);
        }
    }

    public void f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f);
        stringBuilder.append("|detect max cnt ,set type = backup");
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        a(d.BACKUP);
        f.a().c(true);
    }

    public void g() {
        if (c.a[this.a.ordinal()] == 2 && System.currentTimeMillis() - this.d > m.z) {
            a(d.TRY_NORMAL);
        }
    }

    public void h() {
        if (this.a != d.BACKUP) {
            this.c = 0;
        }
        switch (c.a[this.a.ordinal()]) {
            case 1:
                this.e = System.currentTimeMillis();
                i.a().i().p();
                this.b.set(false);
                return;
            case 2:
                return;
            case 3:
                a(d.NORMAL);
                this.b.set(false);
                return;
            default:
                return;
        }
    }

    public void i() {
        k();
        if (g.l && this.a != d.BACKUP) {
            this.e = System.currentTimeMillis();
            i.a().i().p();
        }
        switch (c.a[this.a.ordinal()]) {
            case 1:
            case 2:
                break;
            case 3:
                int i = this.o + 1;
                this.o = i;
                if (i >= 10) {
                    this.c = 0;
                    this.d = System.currentTimeMillis();
                    a(d.BACKUP);
                    return;
                }
                break;
            default:
                return;
        }
    }

    public boolean j() {
        return this.a == d.NORMAL;
    }
}
