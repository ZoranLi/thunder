package com.xiaomi.xmpush.thrift;

import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class l implements Serializable, Cloneable, org.apache.thrift.a<l, a> {
    public static final Map<a, b> e;
    private static final j f = new j("GPS");
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("location", (byte) 12, (short) 1);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("provider", (byte) 11, (short) 2);
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("period", (byte) 10, (short) 3);
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("accuracy", (byte) 4, (short) 4);
    public o a;
    public String b;
    public long c;
    public double d;
    private BitSet k = new BitSet(2);

    public enum a {
        LOCATION((short) 1, "location"),
        PROVIDER((short) 2, "provider"),
        PERIOD((short) 3, "period"),
        ACCURACY((short) 4, "accuracy");
        
        private static final Map<String, a> e = null;
        private final short f;
        private final String g;

        static {
            e = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                e.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.f = s;
            this.g = str;
        }

        public final String a() {
            return this.g;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.LOCATION, new b("location", (byte) 1, new g((byte) 12, o.class)));
        enumMap.put(a.PROVIDER, new b("provider", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PERIOD, new b("period", (byte) 2, new c((byte) 10)));
        enumMap.put(a.ACCURACY, new b("accuracy", (byte) 2, new c((byte) 4)));
        e = Collections.unmodifiableMap(enumMap);
        b.a(l.class, e);
    }

    public l a(double d) {
        this.d = d;
        b(true);
        return this;
    }

    public l a(long j) {
        this.c = j;
        a(true);
        return this;
    }

    public l a(o oVar) {
        this.a = oVar;
        return this;
    }

    public l a(String str) {
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
        if (r1 == 0) goto L_0x0059;
    L_0x000b:
        r1 = r0.c;
        r2 = 1;
        switch(r1) {
            case 1: goto L_0x0043;
            case 2: goto L_0x0036;
            case 3: goto L_0x0026;
            case 4: goto L_0x0017;
            default: goto L_0x0011;
        };
    L_0x0011:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r5, r0);
        goto L_0x0055;
    L_0x0017:
        r1 = r0.b;
        r3 = 4;
        if (r1 != r3) goto L_0x0011;
    L_0x001c:
        r0 = r5.v();
        r4.d = r0;
        r4.b(r2);
        goto L_0x0055;
    L_0x0026:
        r1 = r0.b;
        r3 = 10;
        if (r1 != r3) goto L_0x0011;
    L_0x002c:
        r0 = r5.u();
        r4.c = r0;
        r4.a(r2);
        goto L_0x0055;
    L_0x0036:
        r1 = r0.b;
        r2 = 11;
        if (r1 != r2) goto L_0x0011;
    L_0x003c:
        r0 = r5.w();
        r4.b = r0;
        goto L_0x0055;
    L_0x0043:
        r1 = r0.b;
        r2 = 12;
        if (r1 != r2) goto L_0x0011;
    L_0x0049:
        r0 = new com.xiaomi.xmpush.thrift.o;
        r0.<init>();
        r4.a = r0;
        r0 = r4.a;
        r0.a(r5);
    L_0x0055:
        r5.j();
        goto L_0x0003;
    L_0x0059:
        r5.h();
        r4.e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.l.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.k.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.l r7) {
        /*
        r6 = this;
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r6.a();
        r2 = r7.a();
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        if (r2 == 0) goto L_0x0020;
    L_0x0010:
        if (r1 == 0) goto L_0x0072;
    L_0x0012:
        if (r2 != 0) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        r1 = r6.a;
        r2 = r7.a;
        r1 = r1.a(r2);
        if (r1 != 0) goto L_0x0020;
    L_0x001f:
        return r0;
    L_0x0020:
        r1 = r6.b();
        r2 = r7.b();
        if (r1 != 0) goto L_0x002c;
    L_0x002a:
        if (r2 == 0) goto L_0x003c;
    L_0x002c:
        if (r1 == 0) goto L_0x0072;
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
        r1 = r6.c();
        r2 = r7.c();
        if (r1 != 0) goto L_0x0048;
    L_0x0046:
        if (r2 == 0) goto L_0x0056;
    L_0x0048:
        if (r1 == 0) goto L_0x0072;
    L_0x004a:
        if (r2 != 0) goto L_0x004d;
    L_0x004c:
        return r0;
    L_0x004d:
        r1 = r6.c;
        r3 = r7.c;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x0056;
    L_0x0055:
        return r0;
    L_0x0056:
        r1 = r6.d();
        r2 = r7.d();
        if (r1 != 0) goto L_0x0062;
    L_0x0060:
        if (r2 == 0) goto L_0x0070;
    L_0x0062:
        if (r1 == 0) goto L_0x0072;
    L_0x0064:
        if (r2 != 0) goto L_0x0067;
    L_0x0066:
        return r0;
    L_0x0067:
        r1 = r6.d;
        r3 = r7.d;
        r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r7 == 0) goto L_0x0070;
    L_0x006f:
        return r0;
    L_0x0070:
        r7 = 1;
        return r7;
    L_0x0072:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.l.a(com.xiaomi.xmpush.thrift.l):boolean");
    }

    public int b(l lVar) {
        if (!getClass().equals(lVar.getClass())) {
            return getClass().getName().compareTo(lVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(lVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, lVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(lVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, lVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(lVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.c, lVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(lVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            int a = org.apache.thrift.b.a(this.d, lVar.d);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(e eVar) {
        e();
        eVar.a(f);
        if (this.a != null) {
            eVar.a(g);
            this.a.b(eVar);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(h);
            eVar.a(this.b);
            eVar.b();
        }
        if (c()) {
            eVar.a(i);
            eVar.a(this.c);
            eVar.b();
        }
        if (d()) {
            eVar.a(j);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.k.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.k.get(0);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((l) obj);
    }

    public boolean d() {
        return this.k.get(1);
    }

    public void e() {
        if (this.a == null) {
            StringBuilder stringBuilder = new StringBuilder("Required field 'location' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof l)) ? a((l) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GPS(");
        stringBuilder.append("location:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (b()) {
            stringBuilder.append(", ");
            stringBuilder.append("provider:");
            stringBuilder.append(this.b == null ? "null" : this.b);
        }
        if (c()) {
            stringBuilder.append(", ");
            stringBuilder.append("period:");
            stringBuilder.append(this.c);
        }
        if (d()) {
            stringBuilder.append(", ");
            stringBuilder.append("accuracy:");
            stringBuilder.append(this.d);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
