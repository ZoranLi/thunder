package com.xiaomi.xmpush.thrift;

import com.alipay.sdk.cons.c;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class m implements Serializable, Cloneable, a<m, a> {
    public static final Map<a, b> k;
    private static final j l = new j("GeoFencing");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b(c.e, (byte) 11, (short) 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("appId", (byte) 10, (short) 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("createTime", (byte) 10, (short) 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("type", (byte) 8, (short) 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("circleCenter", (byte) 12, (short) 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("circleRadius", (byte) 4, (short) 9);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("polygonPoints", (byte) 15, (short) 10);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("coordinateProvider", (byte) 8, (short) 11);
    public String a;
    public String b;
    public long c;
    public String d;
    public long e;
    public n f;
    public o g;
    public double h;
    public List<o> i;
    public j j;
    private BitSet w = new BitSet(3);

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new b(AgooConstants.MESSAGE_ID, (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.b, new b(c.e, (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.c, new b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(a.d, new b(Constants.KEY_PACKAGE_NAME, (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.e, new b("createTime", (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(a.f, new b("type", (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, n.class)));
        enumMap.put(a.g, new b("circleCenter", (byte) 2, new g((byte) 12, o.class)));
        enumMap.put(a.h, new b("circleRadius", (byte) 2, new org.apache.thrift.meta_data.c((byte) 4)));
        enumMap.put(a.i, new b("polygonPoints", (byte) 2, new d((byte) 15, new g((byte) 12, o.class))));
        enumMap.put(a.j, new b("coordinateProvider", (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, j.class)));
        k = Collections.unmodifiableMap(enumMap);
        b.a(m.class, k);
    }

    public m a(double d) {
        this.h = d;
        c(true);
        return this;
    }

    public m a(long j) {
        this.c = j;
        a(true);
        return this;
    }

    public m a(j jVar) {
        this.j = jVar;
        return this;
    }

    public m a(n nVar) {
        this.f = nVar;
        return this;
    }

    public m a(o oVar) {
        this.g = oVar;
        return this;
    }

    public m a(String str) {
        this.a = str;
        return this;
    }

    public m a(List<o> list) {
        this.i = list;
        return this;
    }

    public String a() {
        return this.a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r7) {
        /*
        r6 = this;
        r7.g();
    L_0x0003:
        r0 = r7.i();
        r1 = r0.b;
        if (r1 == 0) goto L_0x00cd;
    L_0x000b:
        r1 = r0.c;
        r2 = 10;
        r3 = 8;
        r4 = 11;
        r5 = 1;
        switch(r1) {
            case 1: goto L_0x00be;
            case 2: goto L_0x00b3;
            case 3: goto L_0x00a5;
            case 4: goto L_0x009a;
            case 5: goto L_0x008c;
            case 6: goto L_0x007d;
            case 7: goto L_0x006a;
            case 8: goto L_0x0017;
            case 9: goto L_0x005b;
            case 10: goto L_0x002e;
            case 11: goto L_0x001e;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r7, r0);
        goto L_0x00c8;
    L_0x001e:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x0022:
        r0 = r7.t();
        r0 = com.xiaomi.xmpush.thrift.j.a(r0);
        r6.j = r0;
        goto L_0x00c8;
    L_0x002e:
        r1 = r0.b;
        r2 = 15;
        if (r1 != r2) goto L_0x0017;
    L_0x0034:
        r0 = r7.m();
        r1 = new java.util.ArrayList;
        r2 = r0.b;
        r1.<init>(r2);
        r6.i = r1;
        r1 = 0;
    L_0x0042:
        r2 = r0.b;
        if (r1 >= r2) goto L_0x0056;
    L_0x0046:
        r2 = new com.xiaomi.xmpush.thrift.o;
        r2.<init>();
        r2.a(r7);
        r3 = r6.i;
        r3.add(r2);
        r1 = r1 + 1;
        goto L_0x0042;
    L_0x0056:
        r7.n();
        goto L_0x00c8;
    L_0x005b:
        r1 = r0.b;
        r2 = 4;
        if (r1 != r2) goto L_0x0017;
    L_0x0060:
        r0 = r7.v();
        r6.h = r0;
        r6.c(r5);
        goto L_0x00c8;
    L_0x006a:
        r1 = r0.b;
        r2 = 12;
        if (r1 != r2) goto L_0x0017;
    L_0x0070:
        r0 = new com.xiaomi.xmpush.thrift.o;
        r0.<init>();
        r6.g = r0;
        r0 = r6.g;
        r0.a(r7);
        goto L_0x00c8;
    L_0x007d:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x0081:
        r0 = r7.t();
        r0 = com.xiaomi.xmpush.thrift.n.a(r0);
        r6.f = r0;
        goto L_0x00c8;
    L_0x008c:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0017;
    L_0x0090:
        r0 = r7.u();
        r6.e = r0;
        r6.b(r5);
        goto L_0x00c8;
    L_0x009a:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0017;
    L_0x009e:
        r0 = r7.w();
        r6.d = r0;
        goto L_0x00c8;
    L_0x00a5:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0017;
    L_0x00a9:
        r0 = r7.u();
        r6.c = r0;
        r6.a(r5);
        goto L_0x00c8;
    L_0x00b3:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0017;
    L_0x00b7:
        r0 = r7.w();
        r6.b = r0;
        goto L_0x00c8;
    L_0x00be:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0017;
    L_0x00c2:
        r0 = r7.w();
        r6.a = r0;
    L_0x00c8:
        r7.j();
        goto L_0x0003;
    L_0x00cd:
        r7.h();
        r7 = r6.f();
        if (r7 != 0) goto L_0x00ee;
    L_0x00d6:
        r7 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'appId' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r6.toString();
        r0.append(r1);
        r0 = r0.toString();
        r7.<init>(r0);
        throw r7;
    L_0x00ee:
        r7 = r6.j();
        if (r7 != 0) goto L_0x010c;
    L_0x00f4:
        r7 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'createTime' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r6.toString();
        r0.append(r1);
        r0 = r0.toString();
        r7.<init>(r0);
        throw r7;
    L_0x010c:
        r6.u();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.m.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.w.set(0, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.m r7) {
        /*
        r6 = this;
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r6.b();
        r2 = r7.b();
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        if (r2 == 0) goto L_0x0020;
    L_0x0010:
        if (r1 == 0) goto L_0x00f6;
    L_0x0012:
        if (r2 != 0) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        r1 = r6.a;
        r2 = r7.a;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0020;
    L_0x001f:
        return r0;
    L_0x0020:
        r1 = r6.d();
        r2 = r7.d();
        if (r1 != 0) goto L_0x002c;
    L_0x002a:
        if (r2 == 0) goto L_0x003c;
    L_0x002c:
        if (r1 == 0) goto L_0x00f6;
    L_0x002e:
        if (r2 != 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r6.b;
        r2 = r7.b;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x003c;
    L_0x003b:
        return r0;
    L_0x003c:
        r1 = r6.c;
        r3 = r7.c;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x0045;
    L_0x0044:
        return r0;
    L_0x0045:
        r1 = r6.h();
        r2 = r7.h();
        if (r1 != 0) goto L_0x0051;
    L_0x004f:
        if (r2 == 0) goto L_0x0061;
    L_0x0051:
        if (r1 == 0) goto L_0x00f6;
    L_0x0053:
        if (r2 != 0) goto L_0x0056;
    L_0x0055:
        return r0;
    L_0x0056:
        r1 = r6.d;
        r2 = r7.d;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0061;
    L_0x0060:
        return r0;
    L_0x0061:
        r1 = r6.e;
        r3 = r7.e;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x006a;
    L_0x0069:
        return r0;
    L_0x006a:
        r1 = r6.l();
        r2 = r7.l();
        if (r1 != 0) goto L_0x0076;
    L_0x0074:
        if (r2 == 0) goto L_0x0086;
    L_0x0076:
        if (r1 == 0) goto L_0x00f6;
    L_0x0078:
        if (r2 != 0) goto L_0x007b;
    L_0x007a:
        return r0;
    L_0x007b:
        r1 = r6.f;
        r2 = r7.f;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0086;
    L_0x0085:
        return r0;
    L_0x0086:
        r1 = r6.n();
        r2 = r7.n();
        if (r1 != 0) goto L_0x0092;
    L_0x0090:
        if (r2 == 0) goto L_0x00a2;
    L_0x0092:
        if (r1 == 0) goto L_0x00f6;
    L_0x0094:
        if (r2 != 0) goto L_0x0097;
    L_0x0096:
        return r0;
    L_0x0097:
        r1 = r6.g;
        r2 = r7.g;
        r1 = r1.a(r2);
        if (r1 != 0) goto L_0x00a2;
    L_0x00a1:
        return r0;
    L_0x00a2:
        r1 = r6.p();
        r2 = r7.p();
        if (r1 != 0) goto L_0x00ae;
    L_0x00ac:
        if (r2 == 0) goto L_0x00bc;
    L_0x00ae:
        if (r1 == 0) goto L_0x00f6;
    L_0x00b0:
        if (r2 != 0) goto L_0x00b3;
    L_0x00b2:
        return r0;
    L_0x00b3:
        r1 = r6.h;
        r3 = r7.h;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x00bc;
    L_0x00bb:
        return r0;
    L_0x00bc:
        r1 = r6.r();
        r2 = r7.r();
        if (r1 != 0) goto L_0x00c8;
    L_0x00c6:
        if (r2 == 0) goto L_0x00d8;
    L_0x00c8:
        if (r1 == 0) goto L_0x00f6;
    L_0x00ca:
        if (r2 != 0) goto L_0x00cd;
    L_0x00cc:
        return r0;
    L_0x00cd:
        r1 = r6.i;
        r2 = r7.i;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00d8;
    L_0x00d7:
        return r0;
    L_0x00d8:
        r1 = r6.t();
        r2 = r7.t();
        if (r1 != 0) goto L_0x00e4;
    L_0x00e2:
        if (r2 == 0) goto L_0x00f4;
    L_0x00e4:
        if (r1 == 0) goto L_0x00f6;
    L_0x00e6:
        if (r2 != 0) goto L_0x00e9;
    L_0x00e8:
        return r0;
    L_0x00e9:
        r1 = r6.j;
        r7 = r7.j;
        r7 = r1.equals(r7);
        if (r7 != 0) goto L_0x00f4;
    L_0x00f3:
        return r0;
    L_0x00f4:
        r7 = 1;
        return r7;
    L_0x00f6:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.m.a(com.xiaomi.xmpush.thrift.m):boolean");
    }

    public int b(m mVar) {
        if (!getClass().equals(mVar.getClass())) {
            return getClass().getName().compareTo(mVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(mVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.a, mVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(mVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.b, mVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(mVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.c, mVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(mVar.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.b.a(this.d, mVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(mVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.b.a(this.e, mVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(mVar.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            compareTo = org.apache.thrift.b.a(this.f, mVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(mVar.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            compareTo = org.apache.thrift.b.a(this.g, mVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(p()).compareTo(Boolean.valueOf(mVar.p()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (p()) {
            compareTo = org.apache.thrift.b.a(this.h, mVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(r()).compareTo(Boolean.valueOf(mVar.r()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (r()) {
            compareTo = org.apache.thrift.b.a(this.i, mVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(t()).compareTo(Boolean.valueOf(mVar.t()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (t()) {
            int a = org.apache.thrift.b.a(this.j, mVar.j);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public m b(long j) {
        this.e = j;
        b(true);
        return this;
    }

    public m b(String str) {
        this.b = str;
        return this;
    }

    public void b(e eVar) {
        u();
        eVar.a(l);
        if (this.a != null) {
            eVar.a(m);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null) {
            eVar.a(n);
            eVar.a(this.b);
            eVar.b();
        }
        eVar.a(o);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(p);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.a(q);
        eVar.a(this.e);
        eVar.b();
        if (this.f != null) {
            eVar.a(r);
            eVar.a(this.f.a());
            eVar.b();
        }
        if (this.g != null && n()) {
            eVar.a(s);
            this.g.b(eVar);
            eVar.b();
        }
        if (p()) {
            eVar.a(t);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && r()) {
            eVar.a(u);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.i.size()));
            for (o b : this.i) {
                b.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.j != null) {
            eVar.a(v);
            eVar.a(this.j.a());
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.w.set(1, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public m c(String str) {
        this.d = str;
        return this;
    }

    public String c() {
        return this.b;
    }

    public void c(boolean z) {
        this.w.set(2, z);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((m) obj);
    }

    public boolean d() {
        return this.b != null;
    }

    public long e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof m)) ? a((m) obj) : false;
    }

    public boolean f() {
        return this.w.get(0);
    }

    public String g() {
        return this.d;
    }

    public boolean h() {
        return this.d != null;
    }

    public int hashCode() {
        return 0;
    }

    public long i() {
        return this.e;
    }

    public boolean j() {
        return this.w.get(1);
    }

    public n k() {
        return this.f;
    }

    public boolean l() {
        return this.f != null;
    }

    public o m() {
        return this.g;
    }

    public boolean n() {
        return this.g != null;
    }

    public double o() {
        return this.h;
    }

    public boolean p() {
        return this.w.get(2);
    }

    public List<o> q() {
        return this.i;
    }

    public boolean r() {
        return this.i != null;
    }

    public j s() {
        return this.j;
    }

    public boolean t() {
        return this.j != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GeoFencing(");
        stringBuilder.append("id:");
        stringBuilder.append(this.a == null ? "null" : this.a);
        stringBuilder.append(", ");
        stringBuilder.append("name:");
        stringBuilder.append(this.b == null ? "null" : this.b);
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        stringBuilder.append(this.c);
        stringBuilder.append(", ");
        stringBuilder.append("packageName:");
        stringBuilder.append(this.d == null ? "null" : this.d);
        stringBuilder.append(", ");
        stringBuilder.append("createTime:");
        stringBuilder.append(this.e);
        stringBuilder.append(", ");
        stringBuilder.append("type:");
        if (this.f == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f);
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("circleCenter:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        if (p()) {
            stringBuilder.append(", ");
            stringBuilder.append("circleRadius:");
            stringBuilder.append(this.h);
        }
        if (r()) {
            stringBuilder.append(", ");
            stringBuilder.append("polygonPoints:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("coordinateProvider:");
        if (this.j == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.j);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    public void u() {
        StringBuilder stringBuilder;
        if (this.a == null) {
            stringBuilder = new StringBuilder("Required field 'id' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.b == null) {
            stringBuilder = new StringBuilder("Required field 'name' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.d == null) {
            stringBuilder = new StringBuilder("Required field 'packageName' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.f == null) {
            stringBuilder = new StringBuilder("Required field 'type' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.j == null) {
            stringBuilder = new StringBuilder("Required field 'coordinateProvider' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }
}
