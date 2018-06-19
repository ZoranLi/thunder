package com.xiaomi.xmpush.thrift;

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
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.j;

public class p implements Serializable, Cloneable, org.apache.thrift.a<p, a> {
    public static final Map<a, b> d;
    private static final j e = new j("LocationInfo");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("wifiList", (byte) 15, (short) 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("cellList", (byte) 15, (short) 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("gps", (byte) 12, (short) 3);
    public List<y> a;
    public List<c> b;
    public l c;

    public enum a {
        WIFI_LIST((short) 1, "wifiList"),
        CELL_LIST((short) 2, "cellList"),
        GPS((short) 3, "gps");
        
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
        enumMap.put(a.WIFI_LIST, new b("wifiList", (byte) 2, new d((byte) 15, new g((byte) 12, y.class))));
        enumMap.put(a.CELL_LIST, new b("cellList", (byte) 2, new d((byte) 15, new g((byte) 12, c.class))));
        enumMap.put(a.GPS, new b("gps", (byte) 2, new g((byte) 12, l.class)));
        d = Collections.unmodifiableMap(enumMap);
        b.a(p.class, d);
    }

    public p a(l lVar) {
        this.c = lVar;
        return this;
    }

    public p a(List<y> list) {
        this.a = list;
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
        if (r1 == 0) goto L_0x007d;
    L_0x000b:
        r1 = r0.c;
        r2 = 0;
        r3 = 15;
        switch(r1) {
            case 1: goto L_0x0051;
            case 2: goto L_0x002c;
            case 3: goto L_0x0019;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r5, r0);
        goto L_0x0079;
    L_0x0019:
        r1 = r0.b;
        r2 = 12;
        if (r1 != r2) goto L_0x0013;
    L_0x001f:
        r0 = new com.xiaomi.xmpush.thrift.l;
        r0.<init>();
        r4.c = r0;
        r0 = r4.c;
        r0.a(r5);
        goto L_0x0079;
    L_0x002c:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0013;
    L_0x0030:
        r0 = r5.m();
        r1 = new java.util.ArrayList;
        r3 = r0.b;
        r1.<init>(r3);
        r4.b = r1;
    L_0x003d:
        r1 = r0.b;
        if (r2 >= r1) goto L_0x0076;
    L_0x0041:
        r1 = new com.xiaomi.xmpush.thrift.c;
        r1.<init>();
        r1.a(r5);
        r3 = r4.b;
        r3.add(r1);
        r2 = r2 + 1;
        goto L_0x003d;
    L_0x0051:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0013;
    L_0x0055:
        r0 = r5.m();
        r1 = new java.util.ArrayList;
        r3 = r0.b;
        r1.<init>(r3);
        r4.a = r1;
    L_0x0062:
        r1 = r0.b;
        if (r2 >= r1) goto L_0x0076;
    L_0x0066:
        r1 = new com.xiaomi.xmpush.thrift.y;
        r1.<init>();
        r1.a(r5);
        r3 = r4.a;
        r3.add(r1);
        r2 = r2 + 1;
        goto L_0x0062;
    L_0x0076:
        r5.n();
    L_0x0079:
        r5.j();
        goto L_0x0003;
    L_0x007d:
        r5.h();
        r4.e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.p.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.p r4) {
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
        r1 = r3.d();
        r2 = r4.d();
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
        r4 = r1.a(r4);
        if (r4 != 0) goto L_0x0058;
    L_0x0057:
        return r0;
    L_0x0058:
        r4 = 1;
        return r4;
    L_0x005a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.p.a(com.xiaomi.xmpush.thrift.p):boolean");
    }

    public int b(p pVar) {
        if (!getClass().equals(pVar.getClass())) {
            return getClass().getName().compareTo(pVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(pVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, pVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(pVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, pVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(pVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            int a = org.apache.thrift.b.a(this.c, pVar.c);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public p b(List<c> list) {
        this.b = list;
        return this;
    }

    public void b(e eVar) {
        e();
        eVar.a(e);
        if (this.a != null && a()) {
            eVar.a(f);
            eVar.a(new c((byte) 12, this.a.size()));
            for (y b : this.a) {
                b.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(g);
            eVar.a(new c((byte) 12, this.b.size()));
            for (c b2 : this.b) {
                b2.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.c != null && d()) {
            eVar.a(h);
            this.c.b(eVar);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public l c() {
        return this.c;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((p) obj);
    }

    public boolean d() {
        return this.c != null;
    }

    public void e() {
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof p)) ? a((p) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("LocationInfo(");
        if (a()) {
            stringBuilder.append("wifiList:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj = null;
        } else {
            obj = 1;
        }
        if (b()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("cellList:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
            obj = null;
        }
        if (d()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("gps:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
