package com.xiaomi.push.thrift;

import com.umeng.message.proguard.k;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class b implements Serializable, Cloneable, org.apache.thrift.a<b, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> k;
    private static final j l = new j("StatsEvent");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("chid", (byte) 3, (short) 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("type", (byte) 8, (short) 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b(RequestHeaders.COLUMN_VALUE, (byte) 8, (short) 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("connpt", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("host", (byte) 11, (short) 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("subvalue", (byte) 8, (short) 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("annotation", (byte) 11, (short) 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b(MessageInfo.USER, (byte) 11, (short) 8);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("time", (byte) 8, (short) 9);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("clientIp", (byte) 8, (short) 10);
    public byte a;
    public int b;
    public int c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;
    private BitSet w = new BitSet(6);

    public enum a {
        CHID((short) 1, "chid"),
        TYPE((short) 2, "type"),
        VALUE((short) 3, RequestHeaders.COLUMN_VALUE),
        CONNPT((short) 4, "connpt"),
        HOST((short) 5, "host"),
        SUBVALUE((short) 6, "subvalue"),
        ANNOTATION((short) 7, "annotation"),
        USER((short) 8, MessageInfo.USER),
        TIME((short) 9, "time"),
        CLIENT_IP((short) 10, "clientIp");
        
        private static final Map<String, a> k = null;
        private final short l;
        private final String m;

        static {
            k = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                k.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.l = s;
            this.m = str;
        }

        public final String a() {
            return this.m;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.CHID, new org.apache.thrift.meta_data.b("chid", (byte) 1, new c((byte) 3)));
        enumMap.put(a.TYPE, new org.apache.thrift.meta_data.b("type", (byte) 1, new c((byte) 8)));
        enumMap.put(a.VALUE, new org.apache.thrift.meta_data.b(RequestHeaders.COLUMN_VALUE, (byte) 1, new c((byte) 8)));
        enumMap.put(a.CONNPT, new org.apache.thrift.meta_data.b("connpt", (byte) 1, new c((byte) 11)));
        enumMap.put(a.HOST, new org.apache.thrift.meta_data.b("host", (byte) 2, new c((byte) 11)));
        enumMap.put(a.SUBVALUE, new org.apache.thrift.meta_data.b("subvalue", (byte) 2, new c((byte) 8)));
        enumMap.put(a.ANNOTATION, new org.apache.thrift.meta_data.b("annotation", (byte) 2, new c((byte) 11)));
        enumMap.put(a.USER, new org.apache.thrift.meta_data.b(MessageInfo.USER, (byte) 2, new c((byte) 11)));
        enumMap.put(a.TIME, new org.apache.thrift.meta_data.b("time", (byte) 2, new c((byte) 8)));
        enumMap.put(a.CLIENT_IP, new org.apache.thrift.meta_data.b("clientIp", (byte) 2, new c((byte) 8)));
        k = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(b.class, k);
    }

    public b a(byte b) {
        this.a = b;
        a(true);
        return this;
    }

    public b a(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public b a(String str) {
        this.d = str;
        return this;
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
        if (r1 == 0) goto L_0x00a2;
    L_0x000b:
        r1 = r0.c;
        r2 = 11;
        r3 = 8;
        r4 = 1;
        switch(r1) {
            case 1: goto L_0x008f;
            case 2: goto L_0x0081;
            case 3: goto L_0x0073;
            case 4: goto L_0x0068;
            case 5: goto L_0x005d;
            case 6: goto L_0x004f;
            case 7: goto L_0x0044;
            case 8: goto L_0x0039;
            case 9: goto L_0x002b;
            case 10: goto L_0x001c;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r6, r0);
        goto L_0x009d;
    L_0x001c:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0015;
    L_0x0020:
        r0 = r6.t();
        r5.j = r0;
        r5.f(r4);
        goto L_0x009d;
    L_0x002b:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0015;
    L_0x002f:
        r0 = r6.t();
        r5.i = r0;
        r5.e(r4);
        goto L_0x009d;
    L_0x0039:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0015;
    L_0x003d:
        r0 = r6.w();
        r5.h = r0;
        goto L_0x009d;
    L_0x0044:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0015;
    L_0x0048:
        r0 = r6.w();
        r5.g = r0;
        goto L_0x009d;
    L_0x004f:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0015;
    L_0x0053:
        r0 = r6.t();
        r5.f = r0;
        r5.d(r4);
        goto L_0x009d;
    L_0x005d:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0015;
    L_0x0061:
        r0 = r6.w();
        r5.e = r0;
        goto L_0x009d;
    L_0x0068:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0015;
    L_0x006c:
        r0 = r6.w();
        r5.d = r0;
        goto L_0x009d;
    L_0x0073:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0015;
    L_0x0077:
        r0 = r6.t();
        r5.c = r0;
        r5.c(r4);
        goto L_0x009d;
    L_0x0081:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0015;
    L_0x0085:
        r0 = r6.t();
        r5.b = r0;
        r5.b(r4);
        goto L_0x009d;
    L_0x008f:
        r1 = r0.b;
        r2 = 3;
        if (r1 != r2) goto L_0x0015;
    L_0x0094:
        r0 = r6.r();
        r5.a = r0;
        r5.a(r4);
    L_0x009d:
        r6.j();
        goto L_0x0003;
    L_0x00a2:
        r6.h();
        r6 = r5.a();
        if (r6 != 0) goto L_0x00c3;
    L_0x00ab:
        r6 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'chid' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r5.toString();
        r0.append(r1);
        r0 = r0.toString();
        r6.<init>(r0);
        throw r6;
    L_0x00c3:
        r6 = r5.b();
        if (r6 != 0) goto L_0x00e1;
    L_0x00c9:
        r6 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'type' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r5.toString();
        r0.append(r1);
        r0 = r0.toString();
        r6.<init>(r0);
        throw r6;
    L_0x00e1:
        r6 = r5.c();
        if (r6 != 0) goto L_0x00ff;
    L_0x00e7:
        r6 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'value' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r5.toString();
        r0.append(r1);
        r0 = r0.toString();
        r6.<init>(r0);
        throw r6;
    L_0x00ff:
        r5.k();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.thrift.b.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.w.set(0, z);
    }

    public boolean a() {
        return this.w.get(0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.push.thrift.b r4) {
        /*
        r3 = this;
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r3.a;
        r2 = r4.a;
        if (r1 == r2) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r1 = r3.b;
        r2 = r4.b;
        if (r1 == r2) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = r3.c;
        r2 = r4.c;
        if (r1 == r2) goto L_0x0019;
    L_0x0018:
        return r0;
    L_0x0019:
        r1 = r3.d();
        r2 = r4.d();
        if (r1 != 0) goto L_0x0025;
    L_0x0023:
        if (r2 == 0) goto L_0x0035;
    L_0x0025:
        if (r1 == 0) goto L_0x00d3;
    L_0x0027:
        if (r2 != 0) goto L_0x002a;
    L_0x0029:
        return r0;
    L_0x002a:
        r1 = r3.d;
        r2 = r4.d;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0035;
    L_0x0034:
        return r0;
    L_0x0035:
        r1 = r3.e();
        r2 = r4.e();
        if (r1 != 0) goto L_0x0041;
    L_0x003f:
        if (r2 == 0) goto L_0x0051;
    L_0x0041:
        if (r1 == 0) goto L_0x00d3;
    L_0x0043:
        if (r2 != 0) goto L_0x0046;
    L_0x0045:
        return r0;
    L_0x0046:
        r1 = r3.e;
        r2 = r4.e;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0051;
    L_0x0050:
        return r0;
    L_0x0051:
        r1 = r3.f();
        r2 = r4.f();
        if (r1 != 0) goto L_0x005d;
    L_0x005b:
        if (r2 == 0) goto L_0x0069;
    L_0x005d:
        if (r1 == 0) goto L_0x00d3;
    L_0x005f:
        if (r2 != 0) goto L_0x0062;
    L_0x0061:
        return r0;
    L_0x0062:
        r1 = r3.f;
        r2 = r4.f;
        if (r1 == r2) goto L_0x0069;
    L_0x0068:
        return r0;
    L_0x0069:
        r1 = r3.g();
        r2 = r4.g();
        if (r1 != 0) goto L_0x0075;
    L_0x0073:
        if (r2 == 0) goto L_0x0085;
    L_0x0075:
        if (r1 == 0) goto L_0x00d3;
    L_0x0077:
        if (r2 != 0) goto L_0x007a;
    L_0x0079:
        return r0;
    L_0x007a:
        r1 = r3.g;
        r2 = r4.g;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0085;
    L_0x0084:
        return r0;
    L_0x0085:
        r1 = r3.h();
        r2 = r4.h();
        if (r1 != 0) goto L_0x0091;
    L_0x008f:
        if (r2 == 0) goto L_0x00a1;
    L_0x0091:
        if (r1 == 0) goto L_0x00d3;
    L_0x0093:
        if (r2 != 0) goto L_0x0096;
    L_0x0095:
        return r0;
    L_0x0096:
        r1 = r3.h;
        r2 = r4.h;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00a1;
    L_0x00a0:
        return r0;
    L_0x00a1:
        r1 = r3.i();
        r2 = r4.i();
        if (r1 != 0) goto L_0x00ad;
    L_0x00ab:
        if (r2 == 0) goto L_0x00b9;
    L_0x00ad:
        if (r1 == 0) goto L_0x00d3;
    L_0x00af:
        if (r2 != 0) goto L_0x00b2;
    L_0x00b1:
        return r0;
    L_0x00b2:
        r1 = r3.i;
        r2 = r4.i;
        if (r1 == r2) goto L_0x00b9;
    L_0x00b8:
        return r0;
    L_0x00b9:
        r1 = r3.j();
        r2 = r4.j();
        if (r1 != 0) goto L_0x00c5;
    L_0x00c3:
        if (r2 == 0) goto L_0x00d1;
    L_0x00c5:
        if (r1 == 0) goto L_0x00d3;
    L_0x00c7:
        if (r2 != 0) goto L_0x00ca;
    L_0x00c9:
        return r0;
    L_0x00ca:
        r1 = r3.j;
        r4 = r4.j;
        if (r1 == r4) goto L_0x00d1;
    L_0x00d0:
        return r0;
    L_0x00d1:
        r4 = 1;
        return r4;
    L_0x00d3:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.thrift.b.a(com.xiaomi.push.thrift.b):boolean");
    }

    public int b(b bVar) {
        if (!getClass().equals(bVar.getClass())) {
            return getClass().getName().compareTo(bVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(bVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, bVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(bVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, bVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(bVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.c, bVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(bVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.d, bVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(bVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.e, bVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(bVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.f, bVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(bVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.g, bVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(bVar.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.b.a(this.h, bVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(bVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.i, bVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(bVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            int a = org.apache.thrift.b.a(this.j, bVar.j);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public b b(int i) {
        this.c = i;
        c(true);
        return this;
    }

    public b b(String str) {
        this.e = str;
        return this;
    }

    public void b(e eVar) {
        k();
        eVar.a(l);
        eVar.a(m);
        eVar.a(this.a);
        eVar.b();
        eVar.a(n);
        eVar.a(this.b);
        eVar.b();
        eVar.a(o);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(p);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(q);
            eVar.a(this.e);
            eVar.b();
        }
        if (f()) {
            eVar.a(r);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(s);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(t);
            eVar.a(this.h);
            eVar.b();
        }
        if (i()) {
            eVar.a(u);
            eVar.a(this.i);
            eVar.b();
        }
        if (j()) {
            eVar.a(v);
            eVar.a(this.j);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.w.set(1, z);
    }

    public boolean b() {
        return this.w.get(1);
    }

    public b c(int i) {
        this.f = i;
        d(true);
        return this;
    }

    public b c(String str) {
        this.g = str;
        return this;
    }

    public void c(boolean z) {
        this.w.set(2, z);
    }

    public boolean c() {
        return this.w.get(2);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((b) obj);
    }

    public b d(int i) {
        this.i = i;
        e(true);
        return this;
    }

    public b d(String str) {
        this.h = str;
        return this;
    }

    public void d(boolean z) {
        this.w.set(3, z);
    }

    public boolean d() {
        return this.d != null;
    }

    public b e(int i) {
        this.j = i;
        f(true);
        return this;
    }

    public void e(boolean z) {
        this.w.set(4, z);
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof b)) ? a((b) obj) : false;
    }

    public void f(boolean z) {
        this.w.set(5, z);
    }

    public boolean f() {
        return this.w.get(3);
    }

    public boolean g() {
        return this.g != null;
    }

    public boolean h() {
        return this.h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.w.get(4);
    }

    public boolean j() {
        return this.w.get(5);
    }

    public void k() {
        if (this.d == null) {
            StringBuilder stringBuilder = new StringBuilder("Required field 'connpt' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatsEvent(");
        stringBuilder.append("chid:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("type:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("value:");
        stringBuilder.append(this.c);
        stringBuilder.append(", ");
        stringBuilder.append("connpt:");
        stringBuilder.append(this.d == null ? "null" : this.d);
        if (e()) {
            stringBuilder.append(", ");
            stringBuilder.append("host:");
            stringBuilder.append(this.e == null ? "null" : this.e);
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("subvalue:");
            stringBuilder.append(this.f);
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("annotation:");
            stringBuilder.append(this.g == null ? "null" : this.g);
        }
        if (h()) {
            stringBuilder.append(", ");
            stringBuilder.append("user:");
            stringBuilder.append(this.h == null ? "null" : this.h);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("time:");
            stringBuilder.append(this.i);
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("clientIp:");
            stringBuilder.append(this.j);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
