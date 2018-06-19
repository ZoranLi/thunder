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

public class o implements Serializable, Cloneable, org.apache.thrift.a<o, a> {
    public static final Map<a, b> c;
    private static final j d = new j("Location");
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("longitude", (byte) 4, (short) 1);
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("latitude", (byte) 4, (short) 2);
    public double a;
    public double b;
    private BitSet g = new BitSet(2);

    public enum a {
        LONGITUDE((short) 1, "longitude"),
        LATITUDE((short) 2, "latitude");
        
        private static final Map<String, a> c = null;
        private final short d;
        private final String e;

        static {
            c = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                c.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.d = s;
            this.e = str;
        }

        public final String a() {
            return this.e;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.LONGITUDE, new b("longitude", (byte) 1, new c((byte) 4)));
        enumMap.put(a.LATITUDE, new b("latitude", (byte) 1, new c((byte) 4)));
        c = Collections.unmodifiableMap(enumMap);
        b.a(o.class, c);
    }

    public double a() {
        return this.a;
    }

    public o a(double d) {
        this.a = d;
        a(true);
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
        if (r1 == 0) goto L_0x0037;
    L_0x000b:
        r1 = r0.c;
        r2 = 1;
        r3 = 4;
        switch(r1) {
            case 1: goto L_0x0026;
            case 2: goto L_0x0018;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r5, r0);
        goto L_0x0033;
    L_0x0018:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0012;
    L_0x001c:
        r0 = r5.v();
        r4.b = r0;
        r4.b(r2);
        goto L_0x0033;
    L_0x0026:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0012;
    L_0x002a:
        r0 = r5.v();
        r4.a = r0;
        r4.a(r2);
    L_0x0033:
        r5.j();
        goto L_0x0003;
    L_0x0037:
        r5.h();
        r5 = r4.b();
        if (r5 != 0) goto L_0x0058;
    L_0x0040:
        r5 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'longitude' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r4.toString();
        r0.append(r1);
        r0 = r0.toString();
        r5.<init>(r0);
        throw r5;
    L_0x0058:
        r5 = r4.d();
        if (r5 != 0) goto L_0x0076;
    L_0x005e:
        r5 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'latitude' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r4.toString();
        r0.append(r1);
        r0 = r0.toString();
        r5.<init>(r0);
        throw r5;
    L_0x0076:
        r4.e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.o.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.g.set(0, z);
    }

    public boolean a(o oVar) {
        return oVar != null && this.a == oVar.a && this.b == oVar.b;
    }

    public int b(o oVar) {
        if (!getClass().equals(oVar.getClass())) {
            return getClass().getName().compareTo(oVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(oVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.a, oVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(oVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            int a = org.apache.thrift.b.a(this.b, oVar.b);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public o b(double d) {
        this.b = d;
        b(true);
        return this;
    }

    public void b(e eVar) {
        e();
        eVar.a(d);
        eVar.a(e);
        eVar.a(this.a);
        eVar.b();
        eVar.a(f);
        eVar.a(this.b);
        eVar.b();
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.g.set(1, z);
    }

    public boolean b() {
        return this.g.get(0);
    }

    public double c() {
        return this.b;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((o) obj);
    }

    public boolean d() {
        return this.g.get(1);
    }

    public void e() {
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof o)) ? a((o) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Location(");
        stringBuilder.append("longitude:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("latitude:");
        stringBuilder.append(this.b);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
