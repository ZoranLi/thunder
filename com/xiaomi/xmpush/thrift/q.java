package com.xiaomi.xmpush.thrift;

import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class q implements Serializable, Cloneable, org.apache.thrift.a<q, a> {
    public static final Map<a, b> d;
    private static final j e = new j("NormalConfig");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("version", (byte) 8, (short) 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("configItems", (byte) 15, (short) 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("type", (byte) 8, (short) 3);
    public int a;
    public List<s> b;
    public h c;
    private BitSet i = new BitSet(1);

    public enum a {
        VERSION((short) 1, "version"),
        CONFIG_ITEMS((short) 2, "configItems"),
        TYPE((short) 3, "type");
        
        private static final Map<String, a> d = null;
        private final short e;
        private final String f;

        static {
            d = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                d.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public final String a() {
            return this.f;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.VERSION, new b("version", (byte) 1, new c((byte) 8)));
        enumMap.put(a.CONFIG_ITEMS, new b("configItems", (byte) 1, new d((byte) 15, new g((byte) 12, s.class))));
        enumMap.put(a.TYPE, new b("type", (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, h.class)));
        d = Collections.unmodifiableMap(enumMap);
        b.a(q.class, d);
    }

    public int a() {
        return this.a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r5) {
        /*
        r4 = this;
        r5.g();
    L_0x0003:
        r0 = r5.i();
        r1 = r0.b;
        if (r1 == 0) goto L_0x0065;
    L_0x000b:
        r1 = r0.c;
        r2 = 8;
        switch(r1) {
            case 1: goto L_0x0053;
            case 2: goto L_0x0027;
            case 3: goto L_0x0018;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r5, r0);
        goto L_0x0061;
    L_0x0018:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x001c:
        r0 = r5.t();
        r0 = com.xiaomi.xmpush.thrift.h.a(r0);
        r4.c = r0;
        goto L_0x0061;
    L_0x0027:
        r1 = r0.b;
        r2 = 15;
        if (r1 != r2) goto L_0x0012;
    L_0x002d:
        r0 = r5.m();
        r1 = new java.util.ArrayList;
        r2 = r0.b;
        r1.<init>(r2);
        r4.b = r1;
        r1 = 0;
    L_0x003b:
        r2 = r0.b;
        if (r1 >= r2) goto L_0x004f;
    L_0x003f:
        r2 = new com.xiaomi.xmpush.thrift.s;
        r2.<init>();
        r2.a(r5);
        r3 = r4.b;
        r3.add(r2);
        r1 = r1 + 1;
        goto L_0x003b;
    L_0x004f:
        r5.n();
        goto L_0x0061;
    L_0x0053:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0057:
        r0 = r5.t();
        r4.a = r0;
        r0 = 1;
        r4.a(r0);
    L_0x0061:
        r5.j();
        goto L_0x0003;
    L_0x0065:
        r5.h();
        r5 = r4.b();
        if (r5 != 0) goto L_0x0086;
    L_0x006e:
        r5 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'version' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r4.toString();
        r0.append(r1);
        r0 = r0.toString();
        r5.<init>(r0);
        throw r5;
    L_0x0086:
        r4.f();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.q.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.i.set(0, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.q r4) {
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
        r1 = r3.c();
        r2 = r4.c();
        if (r1 != 0) goto L_0x0017;
    L_0x0015:
        if (r2 == 0) goto L_0x0027;
    L_0x0017:
        if (r1 == 0) goto L_0x0045;
    L_0x0019:
        if (r2 != 0) goto L_0x001c;
    L_0x001b:
        return r0;
    L_0x001c:
        r1 = r3.b;
        r2 = r4.b;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0027;
    L_0x0026:
        return r0;
    L_0x0027:
        r1 = r3.e();
        r2 = r4.e();
        if (r1 != 0) goto L_0x0033;
    L_0x0031:
        if (r2 == 0) goto L_0x0043;
    L_0x0033:
        if (r1 == 0) goto L_0x0045;
    L_0x0035:
        if (r2 != 0) goto L_0x0038;
    L_0x0037:
        return r0;
    L_0x0038:
        r1 = r3.c;
        r4 = r4.c;
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x0043;
    L_0x0042:
        return r0;
    L_0x0043:
        r4 = 1;
        return r4;
    L_0x0045:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.q.a(com.xiaomi.xmpush.thrift.q):boolean");
    }

    public int b(q qVar) {
        if (!getClass().equals(qVar.getClass())) {
            return getClass().getName().compareTo(qVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(qVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.a, qVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(qVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.b, qVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(qVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            int a = org.apache.thrift.b.a(this.c, qVar.c);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(e eVar) {
        f();
        eVar.a(e);
        eVar.a(f);
        eVar.a(this.a);
        eVar.b();
        if (this.b != null) {
            eVar.a(g);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.b.size()));
            for (s b : this.b) {
                b.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(h);
            eVar.a(this.c.a());
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.i.get(0);
    }

    public boolean c() {
        return this.b != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((q) obj);
    }

    public h d() {
        return this.c;
    }

    public boolean e() {
        return this.c != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof q)) ? a((q) obj) : false;
    }

    public void f() {
        StringBuilder stringBuilder;
        if (this.b == null) {
            stringBuilder = new StringBuilder("Required field 'configItems' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.c == null) {
            stringBuilder = new StringBuilder("Required field 'type' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NormalConfig(");
        stringBuilder.append("version:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("configItems:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("type:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
