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

public class ab implements Serializable, Cloneable, org.apache.thrift.a<ab, a> {
    public static final Map<a, b> c;
    private static final j d = new j("XmPushActionCheckClientInfo");
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("miscConfigVersion", (byte) 8, (short) 1);
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("pluginConfigVersion", (byte) 8, (short) 2);
    public int a;
    public int b;
    private BitSet g = new BitSet(2);

    public enum a {
        MISC_CONFIG_VERSION((short) 1, "miscConfigVersion"),
        PLUGIN_CONFIG_VERSION((short) 2, "pluginConfigVersion");
        
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
        enumMap.put(a.MISC_CONFIG_VERSION, new b("miscConfigVersion", (byte) 1, new c((byte) 8)));
        enumMap.put(a.PLUGIN_CONFIG_VERSION, new b("pluginConfigVersion", (byte) 1, new c((byte) 8)));
        c = Collections.unmodifiableMap(enumMap);
        b.a(ab.class, c);
    }

    public ab a(int i) {
        this.a = i;
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
        if (r1 == 0) goto L_0x0038;
    L_0x000b:
        r1 = r0.c;
        r2 = 1;
        r3 = 8;
        switch(r1) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0019;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r5, r0);
        goto L_0x0034;
    L_0x0019:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0013;
    L_0x001d:
        r0 = r5.t();
        r4.b = r0;
        r4.b(r2);
        goto L_0x0034;
    L_0x0027:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0013;
    L_0x002b:
        r0 = r5.t();
        r4.a = r0;
        r4.a(r2);
    L_0x0034:
        r5.j();
        goto L_0x0003;
    L_0x0038:
        r5.h();
        r5 = r4.a();
        if (r5 != 0) goto L_0x0059;
    L_0x0041:
        r5 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'miscConfigVersion' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r4.toString();
        r0.append(r1);
        r0 = r0.toString();
        r5.<init>(r0);
        throw r5;
    L_0x0059:
        r5 = r4.b();
        if (r5 != 0) goto L_0x0077;
    L_0x005f:
        r5 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'pluginConfigVersion' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r4.toString();
        r0.append(r1);
        r0 = r0.toString();
        r5.<init>(r0);
        throw r5;
    L_0x0077:
        r4.c();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ab.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.g.set(0, z);
    }

    public boolean a() {
        return this.g.get(0);
    }

    public boolean a(ab abVar) {
        return abVar != null && this.a == abVar.a && this.b == abVar.b;
    }

    public int b(ab abVar) {
        if (!getClass().equals(abVar.getClass())) {
            return getClass().getName().compareTo(abVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(abVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, abVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(abVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            int a = org.apache.thrift.b.a(this.b, abVar.b);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public ab b(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public void b(e eVar) {
        c();
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
        return this.g.get(1);
    }

    public void c() {
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((ab) obj);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ab)) ? a((ab) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCheckClientInfo(");
        stringBuilder.append("miscConfigVersion:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("pluginConfigVersion:");
        stringBuilder.append(this.b);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
