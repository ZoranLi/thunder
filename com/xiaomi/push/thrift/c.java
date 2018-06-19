package com.xiaomi.push.thrift;

import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class c implements Serializable, Cloneable, org.apache.thrift.a<c, a> {
    public static final Map<a, b> d;
    private static final j e = new j("StatsEvents");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("uuid", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("operator", (byte) 11, (short) 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("events", (byte) 15, (short) 3);
    public String a;
    public String b;
    public List<b> c;

    public enum a {
        UUID((short) 1, "uuid"),
        OPERATOR((short) 2, "operator"),
        EVENTS((short) 3, "events");
        
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
        enumMap.put(a.UUID, new b("uuid", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.OPERATOR, new b("operator", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.EVENTS, new b("events", (byte) 1, new d((byte) 15, new g((byte) 12, b.class))));
        d = Collections.unmodifiableMap(enumMap);
        b.a(c.class, d);
    }

    public c(String str, List<b> list) {
        this();
        this.a = str;
        this.c = list;
    }

    public c a(String str) {
        this.b = str;
        return this;
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
        if (r1 == 0) goto L_0x005d;
    L_0x000b:
        r1 = r0.c;
        r2 = 11;
        switch(r1) {
            case 1: goto L_0x004f;
            case 2: goto L_0x0044;
            case 3: goto L_0x0018;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r5, r0);
        goto L_0x0059;
    L_0x0018:
        r1 = r0.b;
        r2 = 15;
        if (r1 != r2) goto L_0x0012;
    L_0x001e:
        r0 = r5.m();
        r1 = new java.util.ArrayList;
        r2 = r0.b;
        r1.<init>(r2);
        r4.c = r1;
        r1 = 0;
    L_0x002c:
        r2 = r0.b;
        if (r1 >= r2) goto L_0x0040;
    L_0x0030:
        r2 = new com.xiaomi.push.thrift.b;
        r2.<init>();
        r2.a(r5);
        r3 = r4.c;
        r3.add(r2);
        r1 = r1 + 1;
        goto L_0x002c;
    L_0x0040:
        r5.n();
        goto L_0x0059;
    L_0x0044:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0048:
        r0 = r5.w();
        r4.b = r0;
        goto L_0x0059;
    L_0x004f:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0053:
        r0 = r5.w();
        r4.a = r0;
    L_0x0059:
        r5.j();
        goto L_0x0003;
    L_0x005d:
        r5.h();
        r4.d();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.thrift.c.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.push.thrift.c r4) {
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
        if (r1 == 0) goto L_0x005a;
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
        if (r1 == 0) goto L_0x005a;
    L_0x002e:
        if (r2 != 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r3.b;
        r2 = r4.b;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x003c;
    L_0x003b:
        return r0;
    L_0x003c:
        r1 = r3.c();
        r2 = r4.c();
        if (r1 != 0) goto L_0x0048;
    L_0x0046:
        if (r2 == 0) goto L_0x0058;
    L_0x0048:
        if (r1 == 0) goto L_0x005a;
    L_0x004a:
        if (r2 != 0) goto L_0x004d;
    L_0x004c:
        return r0;
    L_0x004d:
        r1 = r3.c;
        r4 = r4.c;
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x0058;
    L_0x0057:
        return r0;
    L_0x0058:
        r4 = 1;
        return r4;
    L_0x005a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.thrift.c.a(com.xiaomi.push.thrift.c):boolean");
    }

    public int b(c cVar) {
        if (!getClass().equals(cVar.getClass())) {
            return getClass().getName().compareTo(cVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(cVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, cVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(cVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, cVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(cVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            int a = org.apache.thrift.b.a(this.c, cVar.c);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(e eVar) {
        d();
        eVar.a(e);
        if (this.a != null) {
            eVar.a(f);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(g);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(h);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.c.size()));
            for (b b : this.c) {
                b.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((c) obj);
    }

    public void d() {
        StringBuilder stringBuilder;
        if (this.a == null) {
            stringBuilder = new StringBuilder("Required field 'uuid' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.c == null) {
            stringBuilder = new StringBuilder("Required field 'events' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof c)) ? a((c) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatsEvents(");
        stringBuilder.append("uuid:");
        stringBuilder.append(this.a == null ? "null" : this.a);
        if (b()) {
            stringBuilder.append(", ");
            stringBuilder.append("operator:");
            stringBuilder.append(this.b == null ? "null" : this.b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("events:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
