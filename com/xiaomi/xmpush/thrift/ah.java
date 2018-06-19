package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
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

public class ah implements Serializable, Cloneable, org.apache.thrift.a<ah, a> {
    public static final Map<a, b> d;
    private static final j e = new j("XmPushActionNormalConfig");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("normalConfigs", (byte) 15, (short) 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("appId", (byte) 10, (short) 4);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 5);
    public List<q> a;
    public long b;
    public String c;
    private BitSet i = new BitSet(1);

    public enum a {
        NORMAL_CONFIGS((short) 1, "normalConfigs"),
        APP_ID((short) 4, "appId"),
        PACKAGE_NAME((short) 5, Constants.KEY_PACKAGE_NAME);
        
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
        enumMap.put(a.NORMAL_CONFIGS, new b("normalConfigs", (byte) 1, new d((byte) 15, new g((byte) 12, q.class))));
        enumMap.put(a.APP_ID, new b("appId", (byte) 2, new c((byte) 10)));
        enumMap.put(a.PACKAGE_NAME, new b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        b.a(ah.class, d);
    }

    public List<q> a() {
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
        r2 = 1;
        if (r1 == r2) goto L_0x0036;
    L_0x0010:
        switch(r1) {
            case 4: goto L_0x0026;
            case 5: goto L_0x0019;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r5, r0);
        goto L_0x0061;
    L_0x0019:
        r1 = r0.b;
        r2 = 11;
        if (r1 != r2) goto L_0x0013;
    L_0x001f:
        r0 = r5.w();
        r4.c = r0;
        goto L_0x0061;
    L_0x0026:
        r1 = r0.b;
        r3 = 10;
        if (r1 != r3) goto L_0x0013;
    L_0x002c:
        r0 = r5.u();
        r4.b = r0;
        r4.a(r2);
        goto L_0x0061;
    L_0x0036:
        r1 = r0.b;
        r2 = 15;
        if (r1 != r2) goto L_0x0013;
    L_0x003c:
        r0 = r5.m();
        r1 = new java.util.ArrayList;
        r2 = r0.b;
        r1.<init>(r2);
        r4.a = r1;
        r1 = 0;
    L_0x004a:
        r2 = r0.b;
        if (r1 >= r2) goto L_0x005e;
    L_0x004e:
        r2 = new com.xiaomi.xmpush.thrift.q;
        r2.<init>();
        r2.a(r5);
        r3 = r4.a;
        r3.add(r2);
        r1 = r1 + 1;
        goto L_0x004a;
    L_0x005e:
        r5.n();
    L_0x0061:
        r5.j();
        goto L_0x0003;
    L_0x0065:
        r5.h();
        r4.e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ah.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.i.set(0, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.ah r7) {
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
        if (r1 == 0) goto L_0x0058;
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
        r1 = r6.c();
        r2 = r7.c();
        if (r1 != 0) goto L_0x002c;
    L_0x002a:
        if (r2 == 0) goto L_0x003a;
    L_0x002c:
        if (r1 == 0) goto L_0x0058;
    L_0x002e:
        if (r2 != 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r6.b;
        r3 = r7.b;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x003a;
    L_0x0039:
        return r0;
    L_0x003a:
        r1 = r6.d();
        r2 = r7.d();
        if (r1 != 0) goto L_0x0046;
    L_0x0044:
        if (r2 == 0) goto L_0x0056;
    L_0x0046:
        if (r1 == 0) goto L_0x0058;
    L_0x0048:
        if (r2 != 0) goto L_0x004b;
    L_0x004a:
        return r0;
    L_0x004b:
        r1 = r6.c;
        r7 = r7.c;
        r7 = r1.equals(r7);
        if (r7 != 0) goto L_0x0056;
    L_0x0055:
        return r0;
    L_0x0056:
        r7 = 1;
        return r7;
    L_0x0058:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ah.a(com.xiaomi.xmpush.thrift.ah):boolean");
    }

    public int b(ah ahVar) {
        if (!getClass().equals(ahVar.getClass())) {
            return getClass().getName().compareTo(ahVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ahVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.a, ahVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ahVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.b, ahVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ahVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            int a = org.apache.thrift.b.a(this.c, ahVar.c);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(e eVar) {
        e();
        eVar.a(e);
        if (this.a != null) {
            eVar.a(f);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.a.size()));
            for (q b : this.a) {
                b.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (c()) {
            eVar.a(g);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null && d()) {
            eVar.a(h);
            eVar.a(this.c);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.a != null;
    }

    public boolean c() {
        return this.i.get(0);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((ah) obj);
    }

    public boolean d() {
        return this.c != null;
    }

    public void e() {
        if (this.a == null) {
            StringBuilder stringBuilder = new StringBuilder("Required field 'normalConfigs' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ah)) ? a((ah) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionNormalConfig(");
        stringBuilder.append("normalConfigs:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (c()) {
            stringBuilder.append(", ");
            stringBuilder.append("appId:");
            stringBuilder.append(this.b);
        }
        if (d()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.c == null ? "null" : this.c);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
