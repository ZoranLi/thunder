package com.xiaomi.xmpush.thrift;

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

public class k implements Serializable, Cloneable, org.apache.thrift.a<k, a> {
    public static final Map<a, b> d;
    private static final j e = new j("DataCollectionItem");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("collectedAt", (byte) 10, (short) 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("collectionType", (byte) 8, (short) 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("content", (byte) 11, (short) 3);
    public long a;
    public d b;
    public String c;
    private BitSet i = new BitSet(1);

    public enum a {
        COLLECTED_AT((short) 1, "collectedAt"),
        COLLECTION_TYPE((short) 2, "collectionType"),
        CONTENT((short) 3, "content");
        
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
        enumMap.put(a.COLLECTED_AT, new b("collectedAt", (byte) 1, new c((byte) 10)));
        enumMap.put(a.COLLECTION_TYPE, new b("collectionType", (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, d.class)));
        enumMap.put(a.CONTENT, new b("content", (byte) 1, new c((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        b.a(k.class, d);
    }

    public k a(long j) {
        this.a = j;
        a(true);
        return this;
    }

    public k a(d dVar) {
        this.b = dVar;
        return this;
    }

    public k a(String str) {
        this.c = str;
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
        if (r1 == 0) goto L_0x0048;
    L_0x000b:
        r1 = r0.c;
        switch(r1) {
            case 1: goto L_0x0034;
            case 2: goto L_0x0023;
            case 3: goto L_0x0016;
            default: goto L_0x0010;
        };
    L_0x0010:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r4, r0);
        goto L_0x0044;
    L_0x0016:
        r1 = r0.b;
        r2 = 11;
        if (r1 != r2) goto L_0x0010;
    L_0x001c:
        r0 = r4.w();
        r3.c = r0;
        goto L_0x0044;
    L_0x0023:
        r1 = r0.b;
        r2 = 8;
        if (r1 != r2) goto L_0x0010;
    L_0x0029:
        r0 = r4.t();
        r0 = com.xiaomi.xmpush.thrift.d.a(r0);
        r3.b = r0;
        goto L_0x0044;
    L_0x0034:
        r1 = r0.b;
        r2 = 10;
        if (r1 != r2) goto L_0x0010;
    L_0x003a:
        r0 = r4.u();
        r3.a = r0;
        r0 = 1;
        r3.a(r0);
    L_0x0044:
        r4.j();
        goto L_0x0003;
    L_0x0048:
        r4.h();
        r4 = r3.a();
        if (r4 != 0) goto L_0x0069;
    L_0x0051:
        r4 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'collectedAt' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r3.toString();
        r0.append(r1);
        r0 = r0.toString();
        r4.<init>(r0);
        throw r4;
    L_0x0069:
        r3.e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.k.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.i.set(0, z);
    }

    public boolean a() {
        return this.i.get(0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.k r7) {
        /*
        r6 = this;
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r6.a;
        r3 = r7.a;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r1 = r6.b();
        r2 = r7.b();
        if (r1 != 0) goto L_0x0019;
    L_0x0017:
        if (r2 == 0) goto L_0x0029;
    L_0x0019:
        if (r1 == 0) goto L_0x0047;
    L_0x001b:
        if (r2 != 0) goto L_0x001e;
    L_0x001d:
        return r0;
    L_0x001e:
        r1 = r6.b;
        r2 = r7.b;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0029;
    L_0x0028:
        return r0;
    L_0x0029:
        r1 = r6.d();
        r2 = r7.d();
        if (r1 != 0) goto L_0x0035;
    L_0x0033:
        if (r2 == 0) goto L_0x0045;
    L_0x0035:
        if (r1 == 0) goto L_0x0047;
    L_0x0037:
        if (r2 != 0) goto L_0x003a;
    L_0x0039:
        return r0;
    L_0x003a:
        r1 = r6.c;
        r7 = r7.c;
        r7 = r1.equals(r7);
        if (r7 != 0) goto L_0x0045;
    L_0x0044:
        return r0;
    L_0x0045:
        r7 = 1;
        return r7;
    L_0x0047:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.k.a(com.xiaomi.xmpush.thrift.k):boolean");
    }

    public int b(k kVar) {
        if (!getClass().equals(kVar.getClass())) {
            return getClass().getName().compareTo(kVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(kVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, kVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(kVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, kVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(kVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            int a = org.apache.thrift.b.a(this.c, kVar.c);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(e eVar) {
        e();
        eVar.a(e);
        eVar.a(f);
        eVar.a(this.a);
        eVar.b();
        if (this.b != null) {
            eVar.a(g);
            eVar.a(this.b.a());
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(h);
            eVar.a(this.c);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((k) obj);
    }

    public boolean d() {
        return this.c != null;
    }

    public void e() {
        StringBuilder stringBuilder;
        if (this.b == null) {
            stringBuilder = new StringBuilder("Required field 'collectionType' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.c == null) {
            stringBuilder = new StringBuilder("Required field 'content' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof k)) ? a((k) obj) : false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataCollectionItem(");
        stringBuilder.append("collectedAt:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("collectionType:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("content:");
        stringBuilder.append(this.c == null ? "null" : this.c);
        stringBuilder.append(com.umeng.message.proguard.k.t);
        return stringBuilder.toString();
    }
}
