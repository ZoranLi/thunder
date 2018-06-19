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
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.j;

public class s implements Serializable, Cloneable, org.apache.thrift.a<s, a> {
    public static final Map<a, b> h;
    private static final j i = new j("OnlineConfigItem");
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("key", (byte) 8, (short) 1);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("type", (byte) 8, (short) 2);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("clear", (byte) 2, (short) 3);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("intValue", (byte) 8, (short) 4);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("longValue", (byte) 10, (short) 5);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("stringValue", (byte) 11, (short) 6);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("boolValue", (byte) 2, (short) 7);
    public int a;
    public int b;
    public boolean c;
    public int d;
    public long e;
    public String f;
    public boolean g;
    private BitSet q = new BitSet(6);

    public enum a {
        KEY((short) 1, "key"),
        TYPE((short) 2, "type"),
        CLEAR((short) 3, "clear"),
        INT_VALUE((short) 4, "intValue"),
        LONG_VALUE((short) 5, "longValue"),
        STRING_VALUE((short) 6, "stringValue"),
        BOOL_VALUE((short) 7, "boolValue");
        
        private static final Map<String, a> h = null;
        private final short i;
        private final String j;

        static {
            h = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                h.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.i = s;
            this.j = str;
        }

        public final String a() {
            return this.j;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.KEY, new b("key", (byte) 2, new c((byte) 8)));
        enumMap.put(a.TYPE, new b("type", (byte) 2, new c((byte) 8)));
        enumMap.put(a.CLEAR, new b("clear", (byte) 2, new c((byte) 2)));
        enumMap.put(a.INT_VALUE, new b("intValue", (byte) 2, new c((byte) 8)));
        enumMap.put(a.LONG_VALUE, new b("longValue", (byte) 2, new c((byte) 10)));
        enumMap.put(a.STRING_VALUE, new b("stringValue", (byte) 2, new c((byte) 11)));
        enumMap.put(a.BOOL_VALUE, new b("boolValue", (byte) 2, new c((byte) 2)));
        h = Collections.unmodifiableMap(enumMap);
        b.a(s.class, h);
    }

    public int a() {
        return this.a;
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
        if (r1 == 0) goto L_0x0080;
    L_0x000b:
        r1 = r0.c;
        r2 = 2;
        r3 = 8;
        r4 = 1;
        switch(r1) {
            case 1: goto L_0x006f;
            case 2: goto L_0x0061;
            case 3: goto L_0x0053;
            case 4: goto L_0x0045;
            case 5: goto L_0x0035;
            case 6: goto L_0x0028;
            case 7: goto L_0x001a;
            default: goto L_0x0014;
        };
    L_0x0014:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r6, r0);
        goto L_0x007c;
    L_0x001a:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0014;
    L_0x001e:
        r0 = r6.q();
        r5.g = r0;
        r5.f(r4);
        goto L_0x007c;
    L_0x0028:
        r1 = r0.b;
        r2 = 11;
        if (r1 != r2) goto L_0x0014;
    L_0x002e:
        r0 = r6.w();
        r5.f = r0;
        goto L_0x007c;
    L_0x0035:
        r1 = r0.b;
        r2 = 10;
        if (r1 != r2) goto L_0x0014;
    L_0x003b:
        r0 = r6.u();
        r5.e = r0;
        r5.e(r4);
        goto L_0x007c;
    L_0x0045:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x0049:
        r0 = r6.t();
        r5.d = r0;
        r5.d(r4);
        goto L_0x007c;
    L_0x0053:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0014;
    L_0x0057:
        r0 = r6.q();
        r5.c = r0;
        r5.c(r4);
        goto L_0x007c;
    L_0x0061:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x0065:
        r0 = r6.t();
        r5.b = r0;
        r5.b(r4);
        goto L_0x007c;
    L_0x006f:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x0073:
        r0 = r6.t();
        r5.a = r0;
        r5.a(r4);
    L_0x007c:
        r6.j();
        goto L_0x0003;
    L_0x0080:
        r6.h();
        r5.n();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.s.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.q.set(0, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.s r7) {
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
        if (r2 == 0) goto L_0x001c;
    L_0x0010:
        if (r1 == 0) goto L_0x00b4;
    L_0x0012:
        if (r2 != 0) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        r1 = r6.a;
        r2 = r7.a;
        if (r1 == r2) goto L_0x001c;
    L_0x001b:
        return r0;
    L_0x001c:
        r1 = r6.d();
        r2 = r7.d();
        if (r1 != 0) goto L_0x0028;
    L_0x0026:
        if (r2 == 0) goto L_0x0034;
    L_0x0028:
        if (r1 == 0) goto L_0x00b4;
    L_0x002a:
        if (r2 != 0) goto L_0x002d;
    L_0x002c:
        return r0;
    L_0x002d:
        r1 = r6.b;
        r2 = r7.b;
        if (r1 == r2) goto L_0x0034;
    L_0x0033:
        return r0;
    L_0x0034:
        r1 = r6.e();
        r2 = r7.e();
        if (r1 != 0) goto L_0x0040;
    L_0x003e:
        if (r2 == 0) goto L_0x004c;
    L_0x0040:
        if (r1 == 0) goto L_0x00b4;
    L_0x0042:
        if (r2 != 0) goto L_0x0045;
    L_0x0044:
        return r0;
    L_0x0045:
        r1 = r6.c;
        r2 = r7.c;
        if (r1 == r2) goto L_0x004c;
    L_0x004b:
        return r0;
    L_0x004c:
        r1 = r6.g();
        r2 = r7.g();
        if (r1 != 0) goto L_0x0058;
    L_0x0056:
        if (r2 == 0) goto L_0x0064;
    L_0x0058:
        if (r1 == 0) goto L_0x00b4;
    L_0x005a:
        if (r2 != 0) goto L_0x005d;
    L_0x005c:
        return r0;
    L_0x005d:
        r1 = r6.d;
        r2 = r7.d;
        if (r1 == r2) goto L_0x0064;
    L_0x0063:
        return r0;
    L_0x0064:
        r1 = r6.i();
        r2 = r7.i();
        if (r1 != 0) goto L_0x0070;
    L_0x006e:
        if (r2 == 0) goto L_0x007e;
    L_0x0070:
        if (r1 == 0) goto L_0x00b4;
    L_0x0072:
        if (r2 != 0) goto L_0x0075;
    L_0x0074:
        return r0;
    L_0x0075:
        r1 = r6.e;
        r3 = r7.e;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x007e;
    L_0x007d:
        return r0;
    L_0x007e:
        r1 = r6.k();
        r2 = r7.k();
        if (r1 != 0) goto L_0x008a;
    L_0x0088:
        if (r2 == 0) goto L_0x009a;
    L_0x008a:
        if (r1 == 0) goto L_0x00b4;
    L_0x008c:
        if (r2 != 0) goto L_0x008f;
    L_0x008e:
        return r0;
    L_0x008f:
        r1 = r6.f;
        r2 = r7.f;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x009a;
    L_0x0099:
        return r0;
    L_0x009a:
        r1 = r6.m();
        r2 = r7.m();
        if (r1 != 0) goto L_0x00a6;
    L_0x00a4:
        if (r2 == 0) goto L_0x00b2;
    L_0x00a6:
        if (r1 == 0) goto L_0x00b4;
    L_0x00a8:
        if (r2 != 0) goto L_0x00ab;
    L_0x00aa:
        return r0;
    L_0x00ab:
        r1 = r6.g;
        r7 = r7.g;
        if (r1 == r7) goto L_0x00b2;
    L_0x00b1:
        return r0;
    L_0x00b2:
        r7 = 1;
        return r7;
    L_0x00b4:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.s.a(com.xiaomi.xmpush.thrift.s):boolean");
    }

    public int b(s sVar) {
        if (!getClass().equals(sVar.getClass())) {
            return getClass().getName().compareTo(sVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(sVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.a, sVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(sVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.b, sVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(sVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.c, sVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(sVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.d, sVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(sVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.e, sVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(sVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.b.a(this.f, sVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m()).compareTo(Boolean.valueOf(sVar.m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m()) {
            int a = org.apache.thrift.b.a(this.g, sVar.g);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(e eVar) {
        n();
        eVar.a(i);
        if (b()) {
            eVar.a(j);
            eVar.a(this.a);
            eVar.b();
        }
        if (d()) {
            eVar.a(k);
            eVar.a(this.b);
            eVar.b();
        }
        if (e()) {
            eVar.a(l);
            eVar.a(this.c);
            eVar.b();
        }
        if (g()) {
            eVar.a(m);
            eVar.a(this.d);
            eVar.b();
        }
        if (i()) {
            eVar.a(n);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && k()) {
            eVar.a(o);
            eVar.a(this.f);
            eVar.b();
        }
        if (m()) {
            eVar.a(p);
            eVar.a(this.g);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.q.set(1, z);
    }

    public boolean b() {
        return this.q.get(0);
    }

    public int c() {
        return this.b;
    }

    public void c(boolean z) {
        this.q.set(2, z);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((s) obj);
    }

    public void d(boolean z) {
        this.q.set(3, z);
    }

    public boolean d() {
        return this.q.get(1);
    }

    public void e(boolean z) {
        this.q.set(4, z);
    }

    public boolean e() {
        return this.q.get(2);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof s)) ? a((s) obj) : false;
    }

    public int f() {
        return this.d;
    }

    public void f(boolean z) {
        this.q.set(5, z);
    }

    public boolean g() {
        return this.q.get(3);
    }

    public long h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.q.get(4);
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g;
    }

    public boolean m() {
        return this.q.get(5);
    }

    public void n() {
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("OnlineConfigItem(");
        if (b()) {
            stringBuilder.append("key:");
            stringBuilder.append(this.a);
            obj = null;
        } else {
            obj = 1;
        }
        if (d()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("type:");
            stringBuilder.append(this.b);
            obj = null;
        }
        if (e()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("clear:");
            stringBuilder.append(this.c);
            obj = null;
        }
        if (g()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("intValue:");
            stringBuilder.append(this.d);
            obj = null;
        }
        if (i()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("longValue:");
            stringBuilder.append(this.e);
            obj = null;
        }
        if (k()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("stringValue:");
            stringBuilder.append(this.f == null ? "null" : this.f);
            obj = null;
        }
        if (m()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("boolValue:");
            stringBuilder.append(this.g);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
