package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.e;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class an implements Serializable, Cloneable, a<an, a> {
    public static final Map<a, b> m;
    private static final j n = new j("XmPushActionSendMessage");
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("debug", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("target", (byte) 12, (short) 2);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("appId", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 5);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("topic", (byte) 11, (short) 6);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("aliasName", (byte) 11, (short) 7);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("message", (byte) 12, (short) 8);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("needAck", (byte) 2, (short) 9);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("params", (byte) 13, (short) 10);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("category", (byte) 11, (short) 11);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("userAccount", (byte) 11, (short) 12);
    private BitSet A = new BitSet(1);
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public t h;
    public boolean i = true;
    public Map<String, String> j;
    public String k;
    public String l;

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.b, new b("target", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.c, new b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.d, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.e, new b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        enumMap.put(a.f, new b("topic", (byte) 2, new c((byte) 11)));
        enumMap.put(a.g, new b("aliasName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.h, new b("message", (byte) 2, new g((byte) 12, t.class)));
        enumMap.put(a.i, new b("needAck", (byte) 2, new c((byte) 2)));
        enumMap.put(a.j, new b("params", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.k, new b("category", (byte) 2, new c((byte) 11)));
        enumMap.put(a.l, new b("userAccount", (byte) 2, new c((byte) 11)));
        m = Collections.unmodifiableMap(enumMap);
        b.a(an.class, m);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r6) {
        /*
        r5 = this;
        r6.g();
    L_0x0003:
        r0 = r6.i();
        r1 = r0.b;
        if (r1 == 0) goto L_0x00d9;
    L_0x000b:
        r1 = r0.c;
        r2 = 12;
        r3 = 2;
        r4 = 11;
        switch(r1) {
            case 1: goto L_0x00ca;
            case 2: goto L_0x00b9;
            case 3: goto L_0x00ae;
            case 4: goto L_0x00a3;
            case 5: goto L_0x0098;
            case 6: goto L_0x008d;
            case 7: goto L_0x0082;
            case 8: goto L_0x0071;
            case 9: goto L_0x0062;
            case 10: goto L_0x0034;
            case 11: goto L_0x0028;
            case 12: goto L_0x001c;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r6, r0);
        goto L_0x00d4;
    L_0x001c:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x0020:
        r0 = r6.w();
        r5.l = r0;
        goto L_0x00d4;
    L_0x0028:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x002c:
        r0 = r6.w();
        r5.k = r0;
        goto L_0x00d4;
    L_0x0034:
        r1 = r0.b;
        r2 = 13;
        if (r1 != r2) goto L_0x0015;
    L_0x003a:
        r0 = r6.k();
        r1 = new java.util.HashMap;
        r2 = r0.c;
        r3 = r3 * r2;
        r1.<init>(r3);
        r5.j = r1;
        r1 = 0;
    L_0x0049:
        r2 = r0.c;
        if (r1 >= r2) goto L_0x005d;
    L_0x004d:
        r2 = r6.w();
        r3 = r6.w();
        r4 = r5.j;
        r4.put(r2, r3);
        r1 = r1 + 1;
        goto L_0x0049;
    L_0x005d:
        r6.l();
        goto L_0x00d4;
    L_0x0062:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0015;
    L_0x0066:
        r0 = r6.q();
        r5.i = r0;
        r0 = 1;
        r5.a(r0);
        goto L_0x00d4;
    L_0x0071:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0015;
    L_0x0075:
        r0 = new com.xiaomi.xmpush.thrift.t;
        r0.<init>();
        r5.h = r0;
        r0 = r5.h;
        r0.a(r6);
        goto L_0x00d4;
    L_0x0082:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x0086:
        r0 = r6.w();
        r5.g = r0;
        goto L_0x00d4;
    L_0x008d:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x0091:
        r0 = r6.w();
        r5.f = r0;
        goto L_0x00d4;
    L_0x0098:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x009c:
        r0 = r6.w();
        r5.e = r0;
        goto L_0x00d4;
    L_0x00a3:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x00a7:
        r0 = r6.w();
        r5.d = r0;
        goto L_0x00d4;
    L_0x00ae:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x00b2:
        r0 = r6.w();
        r5.c = r0;
        goto L_0x00d4;
    L_0x00b9:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0015;
    L_0x00bd:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r5.b = r0;
        r0 = r5.b;
        r0.a(r6);
        goto L_0x00d4;
    L_0x00ca:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x00ce:
        r0 = r6.w();
        r5.a = r0;
    L_0x00d4:
        r6.j();
        goto L_0x0003;
    L_0x00d9:
        r6.h();
        r5.t();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.an.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.A.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.an r4) {
        /*
        r3 = this;
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r3.a();
        r2 = r4.a();
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        if (r2 == 0) goto L_0x0020;
    L_0x0010:
        if (r1 == 0) goto L_0x0152;
    L_0x0012:
        if (r2 != 0) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        r1 = r3.a;
        r2 = r4.a;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0020;
    L_0x001f:
        return r0;
    L_0x0020:
        r1 = r3.b();
        r2 = r4.b();
        if (r1 != 0) goto L_0x002c;
    L_0x002a:
        if (r2 == 0) goto L_0x003c;
    L_0x002c:
        if (r1 == 0) goto L_0x0152;
    L_0x002e:
        if (r2 != 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r3.b;
        r2 = r4.b;
        r1 = r1.a(r2);
        if (r1 != 0) goto L_0x003c;
    L_0x003b:
        return r0;
    L_0x003c:
        r1 = r3.d();
        r2 = r4.d();
        if (r1 != 0) goto L_0x0048;
    L_0x0046:
        if (r2 == 0) goto L_0x0058;
    L_0x0048:
        if (r1 == 0) goto L_0x0152;
    L_0x004a:
        if (r2 != 0) goto L_0x004d;
    L_0x004c:
        return r0;
    L_0x004d:
        r1 = r3.c;
        r2 = r4.c;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0058;
    L_0x0057:
        return r0;
    L_0x0058:
        r1 = r3.f();
        r2 = r4.f();
        if (r1 != 0) goto L_0x0064;
    L_0x0062:
        if (r2 == 0) goto L_0x0074;
    L_0x0064:
        if (r1 == 0) goto L_0x0152;
    L_0x0066:
        if (r2 != 0) goto L_0x0069;
    L_0x0068:
        return r0;
    L_0x0069:
        r1 = r3.d;
        r2 = r4.d;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0074;
    L_0x0073:
        return r0;
    L_0x0074:
        r1 = r3.g();
        r2 = r4.g();
        if (r1 != 0) goto L_0x0080;
    L_0x007e:
        if (r2 == 0) goto L_0x0090;
    L_0x0080:
        if (r1 == 0) goto L_0x0152;
    L_0x0082:
        if (r2 != 0) goto L_0x0085;
    L_0x0084:
        return r0;
    L_0x0085:
        r1 = r3.e;
        r2 = r4.e;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0090;
    L_0x008f:
        return r0;
    L_0x0090:
        r1 = r3.i();
        r2 = r4.i();
        if (r1 != 0) goto L_0x009c;
    L_0x009a:
        if (r2 == 0) goto L_0x00ac;
    L_0x009c:
        if (r1 == 0) goto L_0x0152;
    L_0x009e:
        if (r2 != 0) goto L_0x00a1;
    L_0x00a0:
        return r0;
    L_0x00a1:
        r1 = r3.f;
        r2 = r4.f;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00ac;
    L_0x00ab:
        return r0;
    L_0x00ac:
        r1 = r3.k();
        r2 = r4.k();
        if (r1 != 0) goto L_0x00b8;
    L_0x00b6:
        if (r2 == 0) goto L_0x00c8;
    L_0x00b8:
        if (r1 == 0) goto L_0x0152;
    L_0x00ba:
        if (r2 != 0) goto L_0x00bd;
    L_0x00bc:
        return r0;
    L_0x00bd:
        r1 = r3.g;
        r2 = r4.g;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00c8;
    L_0x00c7:
        return r0;
    L_0x00c8:
        r1 = r3.m();
        r2 = r4.m();
        if (r1 != 0) goto L_0x00d4;
    L_0x00d2:
        if (r2 == 0) goto L_0x00e4;
    L_0x00d4:
        if (r1 == 0) goto L_0x0152;
    L_0x00d6:
        if (r2 != 0) goto L_0x00d9;
    L_0x00d8:
        return r0;
    L_0x00d9:
        r1 = r3.h;
        r2 = r4.h;
        r1 = r1.a(r2);
        if (r1 != 0) goto L_0x00e4;
    L_0x00e3:
        return r0;
    L_0x00e4:
        r1 = r3.n();
        r2 = r4.n();
        if (r1 != 0) goto L_0x00f0;
    L_0x00ee:
        if (r2 == 0) goto L_0x00fc;
    L_0x00f0:
        if (r1 == 0) goto L_0x0152;
    L_0x00f2:
        if (r2 != 0) goto L_0x00f5;
    L_0x00f4:
        return r0;
    L_0x00f5:
        r1 = r3.i;
        r2 = r4.i;
        if (r1 == r2) goto L_0x00fc;
    L_0x00fb:
        return r0;
    L_0x00fc:
        r1 = r3.o();
        r2 = r4.o();
        if (r1 != 0) goto L_0x0108;
    L_0x0106:
        if (r2 == 0) goto L_0x0118;
    L_0x0108:
        if (r1 == 0) goto L_0x0152;
    L_0x010a:
        if (r2 != 0) goto L_0x010d;
    L_0x010c:
        return r0;
    L_0x010d:
        r1 = r3.j;
        r2 = r4.j;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0118;
    L_0x0117:
        return r0;
    L_0x0118:
        r1 = r3.q();
        r2 = r4.q();
        if (r1 != 0) goto L_0x0124;
    L_0x0122:
        if (r2 == 0) goto L_0x0134;
    L_0x0124:
        if (r1 == 0) goto L_0x0152;
    L_0x0126:
        if (r2 != 0) goto L_0x0129;
    L_0x0128:
        return r0;
    L_0x0129:
        r1 = r3.k;
        r2 = r4.k;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0134;
    L_0x0133:
        return r0;
    L_0x0134:
        r1 = r3.s();
        r2 = r4.s();
        if (r1 != 0) goto L_0x0140;
    L_0x013e:
        if (r2 == 0) goto L_0x0150;
    L_0x0140:
        if (r1 == 0) goto L_0x0152;
    L_0x0142:
        if (r2 != 0) goto L_0x0145;
    L_0x0144:
        return r0;
    L_0x0145:
        r1 = r3.l;
        r4 = r4.l;
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x0150;
    L_0x014f:
        return r0;
    L_0x0150:
        r4 = 1;
        return r4;
    L_0x0152:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.an.a(com.xiaomi.xmpush.thrift.an):boolean");
    }

    public int b(an anVar) {
        if (!getClass().equals(anVar.getClass())) {
            return getClass().getName().compareTo(anVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(anVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, anVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(anVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, anVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(anVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.c, anVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(anVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.d, anVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(anVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.e, anVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(anVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.f, anVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(anVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.b.a(this.g, anVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m()).compareTo(Boolean.valueOf(anVar.m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m()) {
            compareTo = org.apache.thrift.b.a(this.h, anVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(anVar.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            compareTo = org.apache.thrift.b.a(this.i, anVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(o()).compareTo(Boolean.valueOf(anVar.o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (o()) {
            compareTo = org.apache.thrift.b.a(this.j, anVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(q()).compareTo(Boolean.valueOf(anVar.q()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (q()) {
            compareTo = org.apache.thrift.b.a(this.k, anVar.k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(s()).compareTo(Boolean.valueOf(anVar.s()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (s()) {
            int a = org.apache.thrift.b.a(this.l, anVar.l);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        t();
        eVar.a(n);
        if (this.a != null && a()) {
            eVar.a(o);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(p);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(q);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(r);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && g()) {
            eVar.a(s);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && i()) {
            eVar.a(t);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && k()) {
            eVar.a(u);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && m()) {
            eVar.a(v);
            this.h.b(eVar);
            eVar.b();
        }
        if (n()) {
            eVar.a(w);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && o()) {
            eVar.a(x);
            eVar.a(new d((byte) 11, (byte) 11, this.j.size()));
            for (Entry entry : this.j.entrySet()) {
                eVar.a((String) entry.getKey());
                eVar.a((String) entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.k != null && q()) {
            eVar.a(y);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && s()) {
            eVar.a(z);
            eVar.a(this.l);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((an) obj);
    }

    public boolean d() {
        return this.c != null;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof an)) ? a((an) obj) : false;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.e != null;
    }

    public String h() {
        return this.f;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f != null;
    }

    public String j() {
        return this.g;
    }

    public boolean k() {
        return this.g != null;
    }

    public t l() {
        return this.h;
    }

    public boolean m() {
        return this.h != null;
    }

    public boolean n() {
        return this.A.get(0);
    }

    public boolean o() {
        return this.j != null;
    }

    public String p() {
        return this.k;
    }

    public boolean q() {
        return this.k != null;
    }

    public String r() {
        return this.l;
    }

    public boolean s() {
        return this.l != null;
    }

    public void t() {
        StringBuilder stringBuilder;
        if (this.c == null) {
            stringBuilder = new StringBuilder("Required field 'id' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.d == null) {
            stringBuilder = new StringBuilder("Required field 'appId' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSendMessage(");
        if (a()) {
            stringBuilder.append("debug:");
            stringBuilder.append(this.a == null ? "null" : this.a);
            obj = null;
        } else {
            obj = 1;
        }
        if (b()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
            obj = null;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        stringBuilder.append(this.c == null ? "null" : this.c);
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        stringBuilder.append(this.d == null ? "null" : this.d);
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.e == null ? "null" : this.e);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            stringBuilder.append(this.f == null ? "null" : this.f);
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("aliasName:");
            stringBuilder.append(this.g == null ? "null" : this.g);
        }
        if (m()) {
            stringBuilder.append(", ");
            stringBuilder.append("message:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("needAck:");
            stringBuilder.append(this.i);
        }
        if (o()) {
            stringBuilder.append(", ");
            stringBuilder.append("params:");
            if (this.j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.j);
            }
        }
        if (q()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            stringBuilder.append(this.k == null ? "null" : this.k);
        }
        if (s()) {
            stringBuilder.append(", ");
            stringBuilder.append("userAccount:");
            stringBuilder.append(this.l == null ? "null" : this.l);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
