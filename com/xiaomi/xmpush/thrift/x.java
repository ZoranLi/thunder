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

public class x implements Serializable, Cloneable, org.apache.thrift.a<x, a> {
    public static final Map<a, b> f;
    private static final j g = new j("Target");
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("channelId", (byte) 10, (short) 1);
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("userId", (byte) 11, (short) 2);
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("server", (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("resource", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("isPreview", (byte) 2, (short) 5);
    public long a = 5;
    public String b;
    public String c = "xiaomi.com";
    public String d = "";
    public boolean e = false;
    private BitSet m = new BitSet(2);

    public enum a {
        CHANNEL_ID((short) 1, "channelId"),
        USER_ID((short) 2, "userId"),
        SERVER((short) 3, "server"),
        RESOURCE((short) 4, "resource"),
        IS_PREVIEW((short) 5, "isPreview");
        
        private static final Map<String, a> f = null;
        private final short g;
        private final String h;

        static {
            f = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                f.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.g = s;
            this.h = str;
        }

        public final String a() {
            return this.h;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.CHANNEL_ID, new b("channelId", (byte) 1, new c((byte) 10)));
        enumMap.put(a.USER_ID, new b("userId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.SERVER, new b("server", (byte) 2, new c((byte) 11)));
        enumMap.put(a.RESOURCE, new b("resource", (byte) 2, new c((byte) 11)));
        enumMap.put(a.IS_PREVIEW, new b("isPreview", (byte) 2, new c((byte) 2)));
        f = Collections.unmodifiableMap(enumMap);
        b.a(x.class, f);
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
        if (r1 == 0) goto L_0x005c;
    L_0x000b:
        r1 = r0.c;
        r2 = 1;
        r3 = 11;
        switch(r1) {
            case 1: goto L_0x0049;
            case 2: goto L_0x003e;
            case 3: goto L_0x0033;
            case 4: goto L_0x0028;
            case 5: goto L_0x0019;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r5, r0);
        goto L_0x0058;
    L_0x0019:
        r1 = r0.b;
        r3 = 2;
        if (r1 != r3) goto L_0x0013;
    L_0x001e:
        r0 = r5.q();
        r4.e = r0;
        r4.b(r2);
        goto L_0x0058;
    L_0x0028:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0013;
    L_0x002c:
        r0 = r5.w();
        r4.d = r0;
        goto L_0x0058;
    L_0x0033:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0013;
    L_0x0037:
        r0 = r5.w();
        r4.c = r0;
        goto L_0x0058;
    L_0x003e:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0013;
    L_0x0042:
        r0 = r5.w();
        r4.b = r0;
        goto L_0x0058;
    L_0x0049:
        r1 = r0.b;
        r3 = 10;
        if (r1 != r3) goto L_0x0013;
    L_0x004f:
        r0 = r5.u();
        r4.a = r0;
        r4.a(r2);
    L_0x0058:
        r5.j();
        goto L_0x0003;
    L_0x005c:
        r5.h();
        r5 = r4.a();
        if (r5 != 0) goto L_0x007d;
    L_0x0065:
        r5 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'channelId' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r4.toString();
        r0.append(r1);
        r0 = r0.toString();
        r5.<init>(r0);
        throw r5;
    L_0x007d:
        r4.f();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.x.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.m.set(0, z);
    }

    public boolean a() {
        return this.m.get(0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.x r7) {
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
        if (r1 == 0) goto L_0x007b;
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
        r1 = r6.c();
        r2 = r7.c();
        if (r1 != 0) goto L_0x0035;
    L_0x0033:
        if (r2 == 0) goto L_0x0045;
    L_0x0035:
        if (r1 == 0) goto L_0x007b;
    L_0x0037:
        if (r2 != 0) goto L_0x003a;
    L_0x0039:
        return r0;
    L_0x003a:
        r1 = r6.c;
        r2 = r7.c;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0045;
    L_0x0044:
        return r0;
    L_0x0045:
        r1 = r6.d();
        r2 = r7.d();
        if (r1 != 0) goto L_0x0051;
    L_0x004f:
        if (r2 == 0) goto L_0x0061;
    L_0x0051:
        if (r1 == 0) goto L_0x007b;
    L_0x0053:
        if (r2 != 0) goto L_0x0056;
    L_0x0055:
        return r0;
    L_0x0056:
        r1 = r6.d;
        r2 = r7.d;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0061;
    L_0x0060:
        return r0;
    L_0x0061:
        r1 = r6.e();
        r2 = r7.e();
        if (r1 != 0) goto L_0x006d;
    L_0x006b:
        if (r2 == 0) goto L_0x0079;
    L_0x006d:
        if (r1 == 0) goto L_0x007b;
    L_0x006f:
        if (r2 != 0) goto L_0x0072;
    L_0x0071:
        return r0;
    L_0x0072:
        r1 = r6.e;
        r7 = r7.e;
        if (r1 == r7) goto L_0x0079;
    L_0x0078:
        return r0;
    L_0x0079:
        r7 = 1;
        return r7;
    L_0x007b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.x.a(com.xiaomi.xmpush.thrift.x):boolean");
    }

    public int b(x xVar) {
        if (!getClass().equals(xVar.getClass())) {
            return getClass().getName().compareTo(xVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(xVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, xVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(xVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, xVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(xVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.c, xVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(xVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.d, xVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(xVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            int a = org.apache.thrift.b.a(this.e, xVar.e);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(e eVar) {
        f();
        eVar.a(g);
        eVar.a(h);
        eVar.a(this.a);
        eVar.b();
        if (this.b != null) {
            eVar.a(i);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null && c()) {
            eVar.a(j);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && d()) {
            eVar.a(k);
            eVar.a(this.d);
            eVar.b();
        }
        if (e()) {
            eVar.a(l);
            eVar.a(this.e);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.m.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((x) obj);
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.m.get(1);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof x)) ? a((x) obj) : false;
    }

    public void f() {
        if (this.b == null) {
            StringBuilder stringBuilder = new StringBuilder("Required field 'userId' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Target(");
        stringBuilder.append("channelId:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("userId:");
        stringBuilder.append(this.b == null ? "null" : this.b);
        if (c()) {
            stringBuilder.append(", ");
            stringBuilder.append("server:");
            stringBuilder.append(this.c == null ? "null" : this.c);
        }
        if (d()) {
            stringBuilder.append(", ");
            stringBuilder.append("resource:");
            stringBuilder.append(this.d == null ? "null" : this.d);
        }
        if (e()) {
            stringBuilder.append(", ");
            stringBuilder.append("isPreview:");
            stringBuilder.append(this.e);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
