package com.xiaomi.xmpush.thrift;

import com.alipay.sdk.cons.c;
import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.e;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.j;

public class f implements Serializable, Cloneable, org.apache.thrift.a<f, a> {
    public static final Map<a, b> l;
    private static final j m = new j("ClientUploadDataItem");
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("channel", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("data", (byte) 11, (short) 2);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b(c.e, (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("counter", (byte) 10, (short) 4);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("timestamp", (byte) 10, (short) 5);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("fromSdk", (byte) 2, (short) 6);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("category", (byte) 11, (short) 7);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("sourcePackage", (byte) 11, (short) 8);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 9);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("extra", (byte) 13, (short) 10);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("pkgName", (byte) 11, (short) 11);
    public String a;
    public String b;
    public String c;
    public long d;
    public long e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public Map<String, String> j;
    public String k;
    private BitSet y = new BitSet(3);

    public enum a {
        CHANNEL((short) 1, "channel"),
        DATA((short) 2, "data"),
        NAME((short) 3, c.e),
        COUNTER((short) 4, "counter"),
        TIMESTAMP((short) 5, "timestamp"),
        FROM_SDK((short) 6, "fromSdk"),
        CATEGORY((short) 7, "category"),
        SOURCE_PACKAGE((short) 8, "sourcePackage"),
        ID((short) 9, AgooConstants.MESSAGE_ID),
        EXTRA((short) 10, "extra"),
        PKG_NAME((short) 11, "pkgName");
        
        private static final Map<String, a> l = null;
        private final short m;
        private final String n;

        static {
            l = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                l.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.m = s;
            this.n = str;
        }

        public final String a() {
            return this.n;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.CHANNEL, new b("channel", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.DATA, new b("data", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.NAME, new b(c.e, (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.COUNTER, new b("counter", (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(a.TIMESTAMP, new b("timestamp", (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(a.FROM_SDK, new b("fromSdk", (byte) 2, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.SOURCE_PACKAGE, new b("sourcePackage", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.ID, new b(AgooConstants.MESSAGE_ID, (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.EXTRA, new b("extra", (byte) 2, new e((byte) 13, new org.apache.thrift.meta_data.c((byte) 11), new org.apache.thrift.meta_data.c((byte) 11))));
        enumMap.put(a.PKG_NAME, new b("pkgName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        l = Collections.unmodifiableMap(enumMap);
        b.a(f.class, l);
    }

    public f a(long j) {
        this.d = j;
        a(true);
        return this;
    }

    public f a(String str) {
        this.a = str;
        return this;
    }

    public String a() {
        return this.a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r7) {
        /*
        r6 = this;
        r7.g();
    L_0x0003:
        r0 = r7.i();
        r1 = r0.b;
        if (r1 == 0) goto L_0x00c7;
    L_0x000b:
        r1 = r0.c;
        r2 = 10;
        r3 = 2;
        r4 = 1;
        r5 = 11;
        switch(r1) {
            case 1: goto L_0x00b8;
            case 2: goto L_0x00ad;
            case 3: goto L_0x00a2;
            case 4: goto L_0x0094;
            case 5: goto L_0x0086;
            case 6: goto L_0x0078;
            case 7: goto L_0x006d;
            case 8: goto L_0x0062;
            case 9: goto L_0x0057;
            case 10: goto L_0x0029;
            case 11: goto L_0x001d;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r7, r0);
        goto L_0x00c2;
    L_0x001d:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0016;
    L_0x0021:
        r0 = r7.w();
        r6.k = r0;
        goto L_0x00c2;
    L_0x0029:
        r1 = r0.b;
        r2 = 13;
        if (r1 != r2) goto L_0x0016;
    L_0x002f:
        r0 = r7.k();
        r1 = new java.util.HashMap;
        r2 = r0.c;
        r3 = r3 * r2;
        r1.<init>(r3);
        r6.j = r1;
        r1 = 0;
    L_0x003e:
        r2 = r0.c;
        if (r1 >= r2) goto L_0x0052;
    L_0x0042:
        r2 = r7.w();
        r3 = r7.w();
        r4 = r6.j;
        r4.put(r2, r3);
        r1 = r1 + 1;
        goto L_0x003e;
    L_0x0052:
        r7.l();
        goto L_0x00c2;
    L_0x0057:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0016;
    L_0x005b:
        r0 = r7.w();
        r6.i = r0;
        goto L_0x00c2;
    L_0x0062:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0016;
    L_0x0066:
        r0 = r7.w();
        r6.h = r0;
        goto L_0x00c2;
    L_0x006d:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0016;
    L_0x0071:
        r0 = r7.w();
        r6.g = r0;
        goto L_0x00c2;
    L_0x0078:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0016;
    L_0x007c:
        r0 = r7.q();
        r6.f = r0;
        r6.d(r4);
        goto L_0x00c2;
    L_0x0086:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0016;
    L_0x008a:
        r0 = r7.u();
        r6.e = r0;
        r6.b(r4);
        goto L_0x00c2;
    L_0x0094:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0016;
    L_0x0098:
        r0 = r7.u();
        r6.d = r0;
        r6.a(r4);
        goto L_0x00c2;
    L_0x00a2:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0016;
    L_0x00a6:
        r0 = r7.w();
        r6.c = r0;
        goto L_0x00c2;
    L_0x00ad:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0016;
    L_0x00b1:
        r0 = r7.w();
        r6.b = r0;
        goto L_0x00c2;
    L_0x00b8:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0016;
    L_0x00bc:
        r0 = r7.w();
        r6.a = r0;
    L_0x00c2:
        r7.j();
        goto L_0x0003;
    L_0x00c7:
        r7.h();
        r6.r();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.f.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.y.set(0, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.f r7) {
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
        if (r1 == 0) goto L_0x0132;
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
        if (r2 == 0) goto L_0x003c;
    L_0x002c:
        if (r1 == 0) goto L_0x0132;
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
        r1 = r6.e();
        r2 = r7.e();
        if (r1 != 0) goto L_0x0048;
    L_0x0046:
        if (r2 == 0) goto L_0x0058;
    L_0x0048:
        if (r1 == 0) goto L_0x0132;
    L_0x004a:
        if (r2 != 0) goto L_0x004d;
    L_0x004c:
        return r0;
    L_0x004d:
        r1 = r6.c;
        r2 = r7.c;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0058;
    L_0x0057:
        return r0;
    L_0x0058:
        r1 = r6.f();
        r2 = r7.f();
        if (r1 != 0) goto L_0x0064;
    L_0x0062:
        if (r2 == 0) goto L_0x0072;
    L_0x0064:
        if (r1 == 0) goto L_0x0132;
    L_0x0066:
        if (r2 != 0) goto L_0x0069;
    L_0x0068:
        return r0;
    L_0x0069:
        r1 = r6.d;
        r3 = r7.d;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x0072;
    L_0x0071:
        return r0;
    L_0x0072:
        r1 = r6.h();
        r2 = r7.h();
        if (r1 != 0) goto L_0x007e;
    L_0x007c:
        if (r2 == 0) goto L_0x008c;
    L_0x007e:
        if (r1 == 0) goto L_0x0132;
    L_0x0080:
        if (r2 != 0) goto L_0x0083;
    L_0x0082:
        return r0;
    L_0x0083:
        r1 = r6.e;
        r3 = r7.e;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x008c;
    L_0x008b:
        return r0;
    L_0x008c:
        r1 = r6.i();
        r2 = r7.i();
        if (r1 != 0) goto L_0x0098;
    L_0x0096:
        if (r2 == 0) goto L_0x00a4;
    L_0x0098:
        if (r1 == 0) goto L_0x0132;
    L_0x009a:
        if (r2 != 0) goto L_0x009d;
    L_0x009c:
        return r0;
    L_0x009d:
        r1 = r6.f;
        r2 = r7.f;
        if (r1 == r2) goto L_0x00a4;
    L_0x00a3:
        return r0;
    L_0x00a4:
        r1 = r6.j();
        r2 = r7.j();
        if (r1 != 0) goto L_0x00b0;
    L_0x00ae:
        if (r2 == 0) goto L_0x00c0;
    L_0x00b0:
        if (r1 == 0) goto L_0x0132;
    L_0x00b2:
        if (r2 != 0) goto L_0x00b5;
    L_0x00b4:
        return r0;
    L_0x00b5:
        r1 = r6.g;
        r2 = r7.g;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00c0;
    L_0x00bf:
        return r0;
    L_0x00c0:
        r1 = r6.l();
        r2 = r7.l();
        if (r1 != 0) goto L_0x00cc;
    L_0x00ca:
        if (r2 == 0) goto L_0x00dc;
    L_0x00cc:
        if (r1 == 0) goto L_0x0132;
    L_0x00ce:
        if (r2 != 0) goto L_0x00d1;
    L_0x00d0:
        return r0;
    L_0x00d1:
        r1 = r6.h;
        r2 = r7.h;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00dc;
    L_0x00db:
        return r0;
    L_0x00dc:
        r1 = r6.n();
        r2 = r7.n();
        if (r1 != 0) goto L_0x00e8;
    L_0x00e6:
        if (r2 == 0) goto L_0x00f8;
    L_0x00e8:
        if (r1 == 0) goto L_0x0132;
    L_0x00ea:
        if (r2 != 0) goto L_0x00ed;
    L_0x00ec:
        return r0;
    L_0x00ed:
        r1 = r6.i;
        r2 = r7.i;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00f8;
    L_0x00f7:
        return r0;
    L_0x00f8:
        r1 = r6.o();
        r2 = r7.o();
        if (r1 != 0) goto L_0x0104;
    L_0x0102:
        if (r2 == 0) goto L_0x0114;
    L_0x0104:
        if (r1 == 0) goto L_0x0132;
    L_0x0106:
        if (r2 != 0) goto L_0x0109;
    L_0x0108:
        return r0;
    L_0x0109:
        r1 = r6.j;
        r2 = r7.j;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0114;
    L_0x0113:
        return r0;
    L_0x0114:
        r1 = r6.q();
        r2 = r7.q();
        if (r1 != 0) goto L_0x0120;
    L_0x011e:
        if (r2 == 0) goto L_0x0130;
    L_0x0120:
        if (r1 == 0) goto L_0x0132;
    L_0x0122:
        if (r2 != 0) goto L_0x0125;
    L_0x0124:
        return r0;
    L_0x0125:
        r1 = r6.k;
        r7 = r7.k;
        r7 = r1.equals(r7);
        if (r7 != 0) goto L_0x0130;
    L_0x012f:
        return r0;
    L_0x0130:
        r7 = 1;
        return r7;
    L_0x0132:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.f.a(com.xiaomi.xmpush.thrift.f):boolean");
    }

    public int b(f fVar) {
        if (!getClass().equals(fVar.getClass())) {
            return getClass().getName().compareTo(fVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.a, fVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.b, fVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.c, fVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.d, fVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fVar.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.b.a(this.e, fVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.f, fVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.b.a(this.g, fVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(fVar.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            compareTo = org.apache.thrift.b.a(this.h, fVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(fVar.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            compareTo = org.apache.thrift.b.a(this.i, fVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(o()).compareTo(Boolean.valueOf(fVar.o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (o()) {
            compareTo = org.apache.thrift.b.a(this.j, fVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(q()).compareTo(Boolean.valueOf(fVar.q()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (q()) {
            int a = org.apache.thrift.b.a(this.k, fVar.k);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public f b(long j) {
        this.e = j;
        b(true);
        return this;
    }

    public f b(String str) {
        this.b = str;
        return this;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        r();
        eVar.a(m);
        if (this.a != null && b()) {
            eVar.a(n);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && c()) {
            eVar.a(o);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null && e()) {
            eVar.a(p);
            eVar.a(this.c);
            eVar.b();
        }
        if (f()) {
            eVar.a(q);
            eVar.a(this.d);
            eVar.b();
        }
        if (h()) {
            eVar.a(r);
            eVar.a(this.e);
            eVar.b();
        }
        if (i()) {
            eVar.a(s);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && j()) {
            eVar.a(t);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && l()) {
            eVar.a(u);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && n()) {
            eVar.a(v);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && o()) {
            eVar.a(w);
            eVar.a(new d((byte) 11, (byte) 11, this.j.size()));
            for (Entry entry : this.j.entrySet()) {
                eVar.a((String) entry.getKey());
                eVar.a((String) entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.k != null && q()) {
            eVar.a(x);
            eVar.a(this.k);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.y.set(1, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public f c(String str) {
        this.c = str;
        return this;
    }

    public f c(boolean z) {
        this.f = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((f) obj);
    }

    public f d(String str) {
        this.g = str;
        return this;
    }

    public String d() {
        return this.c;
    }

    public void d(boolean z) {
        this.y.set(2, z);
    }

    public f e(String str) {
        this.h = str;
        return this;
    }

    public boolean e() {
        return this.c != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof f)) ? a((f) obj) : false;
    }

    public f f(String str) {
        this.i = str;
        return this;
    }

    public boolean f() {
        return this.y.get(0);
    }

    public long g() {
        return this.e;
    }

    public f g(String str) {
        this.k = str;
        return this;
    }

    public boolean h() {
        return this.y.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.y.get(2);
    }

    public boolean j() {
        return this.g != null;
    }

    public String k() {
        return this.h;
    }

    public boolean l() {
        return this.h != null;
    }

    public String m() {
        return this.i;
    }

    public boolean n() {
        return this.i != null;
    }

    public boolean o() {
        return this.j != null;
    }

    public String p() {
        return this.k;
    }

    public boolean q() {
        return this.k != null;
    }

    public void r() {
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("ClientUploadDataItem(");
        if (b()) {
            stringBuilder.append("channel:");
            stringBuilder.append(this.a == null ? "null" : this.a);
            obj = null;
        } else {
            obj = 1;
        }
        if (c()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("data:");
            stringBuilder.append(this.b == null ? "null" : this.b);
            obj = null;
        }
        if (e()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("name:");
            stringBuilder.append(this.c == null ? "null" : this.c);
            obj = null;
        }
        if (f()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("counter:");
            stringBuilder.append(this.d);
            obj = null;
        }
        if (h()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("timestamp:");
            stringBuilder.append(this.e);
            obj = null;
        }
        if (i()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("fromSdk:");
            stringBuilder.append(this.f);
            obj = null;
        }
        if (j()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("category:");
            stringBuilder.append(this.g == null ? "null" : this.g);
            obj = null;
        }
        if (l()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("sourcePackage:");
            stringBuilder.append(this.h == null ? "null" : this.h);
            obj = null;
        }
        if (n()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("id:");
            stringBuilder.append(this.i == null ? "null" : this.i);
            obj = null;
        }
        if (o()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("extra:");
            if (this.j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.j);
            }
            obj = null;
        }
        if (q()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("pkgName:");
            stringBuilder.append(this.k == null ? "null" : this.k);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
