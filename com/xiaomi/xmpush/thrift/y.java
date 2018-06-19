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
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class y implements Serializable, Cloneable, org.apache.thrift.a<y, a> {
    public static final Map<a, b> d;
    private static final j e = new j("Wifi");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("macAddress", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("signalStrength", (byte) 8, (short) 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("ssid", (byte) 11, (short) 3);
    public String a;
    public int b;
    public String c;
    private BitSet i = new BitSet(1);

    public enum a {
        MAC_ADDRESS((short) 1, "macAddress"),
        SIGNAL_STRENGTH((short) 2, "signalStrength"),
        SSID((short) 3, "ssid");
        
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
        enumMap.put(a.MAC_ADDRESS, new b("macAddress", (byte) 1, new c((byte) 11)));
        enumMap.put(a.SIGNAL_STRENGTH, new b("signalStrength", (byte) 1, new c((byte) 8)));
        enumMap.put(a.SSID, new b("ssid", (byte) 2, new c((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        b.a(y.class, d);
    }

    public y a(int i) {
        this.b = i;
        a(true);
        return this;
    }

    public y a(String str) {
        this.a = str;
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r4) {
        /*
        r3 = this;
        r4.g();
    L_0x0003:
        r0 = r4.i();
        r1 = r0.b;
        if (r1 == 0) goto L_0x0042;
    L_0x000b:
        r1 = r0.c;
        r2 = 11;
        switch(r1) {
            case 1: goto L_0x0034;
            case 2: goto L_0x0023;
            case 3: goto L_0x0018;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r4, r0);
        goto L_0x003e;
    L_0x0018:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x001c:
        r0 = r4.w();
        r3.c = r0;
        goto L_0x003e;
    L_0x0023:
        r1 = r0.b;
        r2 = 8;
        if (r1 != r2) goto L_0x0012;
    L_0x0029:
        r0 = r4.t();
        r3.b = r0;
        r0 = 1;
        r3.a(r0);
        goto L_0x003e;
    L_0x0034:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0038:
        r0 = r4.w();
        r3.a = r0;
    L_0x003e:
        r4.j();
        goto L_0x0003;
    L_0x0042:
        r4.h();
        r4 = r3.b();
        if (r4 != 0) goto L_0x0063;
    L_0x004b:
        r4 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'signalStrength' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r3.toString();
        r0.append(r1);
        r0 = r0.toString();
        r4.<init>(r0);
        throw r4;
    L_0x0063:
        r3.d();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.y.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.i.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.y r4) {
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
        if (r1 == 0) goto L_0x0045;
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
        r1 = r3.b;
        r2 = r4.b;
        if (r1 == r2) goto L_0x0027;
    L_0x0026:
        return r0;
    L_0x0027:
        r1 = r3.c();
        r2 = r4.c();
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.y.a(com.xiaomi.xmpush.thrift.y):boolean");
    }

    public int b(y yVar) {
        if (!getClass().equals(yVar.getClass())) {
            return getClass().getName().compareTo(yVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(yVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, yVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(yVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, yVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(yVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            int a = org.apache.thrift.b.a(this.c, yVar.c);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public y b(String str) {
        this.c = str;
        return this;
    }

    public void b(e eVar) {
        d();
        eVar.a(e);
        if (this.a != null) {
            eVar.a(f);
            eVar.a(this.a);
            eVar.b();
        }
        eVar.a(g);
        eVar.a(this.b);
        eVar.b();
        if (this.c != null && c()) {
            eVar.a(h);
            eVar.a(this.c);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.i.get(0);
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((y) obj);
    }

    public void d() {
        if (this.a == null) {
            StringBuilder stringBuilder = new StringBuilder("Required field 'macAddress' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof y)) ? a((y) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Wifi(");
        stringBuilder.append("macAddress:");
        stringBuilder.append(this.a == null ? "null" : this.a);
        stringBuilder.append(", ");
        stringBuilder.append("signalStrength:");
        stringBuilder.append(this.b);
        if (c()) {
            stringBuilder.append(", ");
            stringBuilder.append("ssid:");
            stringBuilder.append(this.c == null ? "null" : this.c);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
