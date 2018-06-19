package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.nio.ByteBuffer;
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

public class af implements Serializable, Cloneable, org.apache.thrift.a<af, a> {
    public static final Map<a, b> i;
    private static final j j = new j("XmPushActionContainer");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("action", (byte) 8, (short) 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("encryptAction", (byte) 2, (short) 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("isRequest", (byte) 2, (short) 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("pushAction", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("appid", (byte) 11, (short) 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("target", (byte) 12, (short) 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("metaInfo", (byte) 12, (short) 8);
    public a a;
    public boolean b = true;
    public boolean c = true;
    public ByteBuffer d;
    public String e;
    public String f;
    public x g;
    public u h;
    private BitSet s = new BitSet(2);

    public enum a {
        ACTION((short) 1, "action"),
        ENCRYPT_ACTION((short) 2, "encryptAction"),
        IS_REQUEST((short) 3, "isRequest"),
        PUSH_ACTION((short) 4, "pushAction"),
        APPID((short) 5, "appid"),
        PACKAGE_NAME((short) 6, Constants.KEY_PACKAGE_NAME),
        TARGET((short) 7, "target"),
        META_INFO((short) 8, "metaInfo");
        
        private static final Map<String, a> i = null;
        private final short j;
        private final String k;

        static {
            i = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                i.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.j = s;
            this.k = str;
        }

        public final String a() {
            return this.k;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.ACTION, new b("action", (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, a.class)));
        enumMap.put(a.ENCRYPT_ACTION, new b("encryptAction", (byte) 1, new c((byte) 2)));
        enumMap.put(a.IS_REQUEST, new b("isRequest", (byte) 1, new c((byte) 2)));
        enumMap.put(a.PUSH_ACTION, new b("pushAction", (byte) 1, new c((byte) 11)));
        enumMap.put(a.APPID, new b("appid", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PACKAGE_NAME, new b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new b("target", (byte) 1, new g((byte) 12, x.class)));
        enumMap.put(a.META_INFO, new b("metaInfo", (byte) 2, new g((byte) 12, u.class)));
        i = Collections.unmodifiableMap(enumMap);
        b.a(af.class, i);
    }

    public a a() {
        return this.a;
    }

    public af a(a aVar) {
        this.a = aVar;
        return this;
    }

    public af a(u uVar) {
        this.h = uVar;
        return this;
    }

    public af a(x xVar) {
        this.g = xVar;
        return this;
    }

    public af a(String str) {
        this.e = str;
        return this;
    }

    public af a(ByteBuffer byteBuffer) {
        this.d = byteBuffer;
        return this;
    }

    public af a(boolean z) {
        this.b = z;
        b(true);
        return this;
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
        if (r1 == 0) goto L_0x0091;
    L_0x000b:
        r1 = r0.c;
        r2 = 1;
        r3 = 2;
        r4 = 12;
        r5 = 11;
        switch(r1) {
            case 1: goto L_0x007c;
            case 2: goto L_0x006e;
            case 3: goto L_0x0060;
            case 4: goto L_0x0055;
            case 5: goto L_0x004a;
            case 6: goto L_0x003f;
            case 7: goto L_0x002e;
            case 8: goto L_0x001d;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r7, r0);
        goto L_0x008c;
    L_0x001d:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0016;
    L_0x0021:
        r0 = new com.xiaomi.xmpush.thrift.u;
        r0.<init>();
        r6.h = r0;
        r0 = r6.h;
        r0.a(r7);
        goto L_0x008c;
    L_0x002e:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0016;
    L_0x0032:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r6.g = r0;
        r0 = r6.g;
        r0.a(r7);
        goto L_0x008c;
    L_0x003f:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0016;
    L_0x0043:
        r0 = r7.w();
        r6.f = r0;
        goto L_0x008c;
    L_0x004a:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0016;
    L_0x004e:
        r0 = r7.w();
        r6.e = r0;
        goto L_0x008c;
    L_0x0055:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0016;
    L_0x0059:
        r0 = r7.x();
        r6.d = r0;
        goto L_0x008c;
    L_0x0060:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0016;
    L_0x0064:
        r0 = r7.q();
        r6.c = r0;
        r6.d(r2);
        goto L_0x008c;
    L_0x006e:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0016;
    L_0x0072:
        r0 = r7.q();
        r6.b = r0;
        r6.b(r2);
        goto L_0x008c;
    L_0x007c:
        r1 = r0.b;
        r2 = 8;
        if (r1 != r2) goto L_0x0016;
    L_0x0082:
        r0 = r7.t();
        r0 = com.xiaomi.xmpush.thrift.a.a(r0);
        r6.a = r0;
    L_0x008c:
        r7.j();
        goto L_0x0003;
    L_0x0091:
        r7.h();
        r7 = r6.d();
        if (r7 != 0) goto L_0x00b2;
    L_0x009a:
        r7 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'encryptAction' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r6.toString();
        r0.append(r1);
        r0 = r0.toString();
        r7.<init>(r0);
        throw r7;
    L_0x00b2:
        r7 = r6.e();
        if (r7 != 0) goto L_0x00d0;
    L_0x00b8:
        r7 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'isRequest' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r6.toString();
        r0.append(r1);
        r0 = r0.toString();
        r7.<init>(r0);
        throw r7;
    L_0x00d0:
        r6.o();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.af.a(org.apache.thrift.protocol.e):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.af r4) {
        /*
        r3 = this;
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r3.b();
        r2 = r4.b();
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        if (r2 == 0) goto L_0x0020;
    L_0x0010:
        if (r1 == 0) goto L_0x00bc;
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
        r1 = r3.c;
        r2 = r4.c;
        if (r1 == r2) goto L_0x002e;
    L_0x002d:
        return r0;
    L_0x002e:
        r1 = r3.g();
        r2 = r4.g();
        if (r1 != 0) goto L_0x003a;
    L_0x0038:
        if (r2 == 0) goto L_0x004a;
    L_0x003a:
        if (r1 == 0) goto L_0x00bc;
    L_0x003c:
        if (r2 != 0) goto L_0x003f;
    L_0x003e:
        return r0;
    L_0x003f:
        r1 = r3.d;
        r2 = r4.d;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x004a;
    L_0x0049:
        return r0;
    L_0x004a:
        r1 = r3.i();
        r2 = r4.i();
        if (r1 != 0) goto L_0x0056;
    L_0x0054:
        if (r2 == 0) goto L_0x0066;
    L_0x0056:
        if (r1 == 0) goto L_0x00bc;
    L_0x0058:
        if (r2 != 0) goto L_0x005b;
    L_0x005a:
        return r0;
    L_0x005b:
        r1 = r3.e;
        r2 = r4.e;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0066;
    L_0x0065:
        return r0;
    L_0x0066:
        r1 = r3.k();
        r2 = r4.k();
        if (r1 != 0) goto L_0x0072;
    L_0x0070:
        if (r2 == 0) goto L_0x0082;
    L_0x0072:
        if (r1 == 0) goto L_0x00bc;
    L_0x0074:
        if (r2 != 0) goto L_0x0077;
    L_0x0076:
        return r0;
    L_0x0077:
        r1 = r3.f;
        r2 = r4.f;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0082;
    L_0x0081:
        return r0;
    L_0x0082:
        r1 = r3.l();
        r2 = r4.l();
        if (r1 != 0) goto L_0x008e;
    L_0x008c:
        if (r2 == 0) goto L_0x009e;
    L_0x008e:
        if (r1 == 0) goto L_0x00bc;
    L_0x0090:
        if (r2 != 0) goto L_0x0093;
    L_0x0092:
        return r0;
    L_0x0093:
        r1 = r3.g;
        r2 = r4.g;
        r1 = r1.a(r2);
        if (r1 != 0) goto L_0x009e;
    L_0x009d:
        return r0;
    L_0x009e:
        r1 = r3.n();
        r2 = r4.n();
        if (r1 != 0) goto L_0x00aa;
    L_0x00a8:
        if (r2 == 0) goto L_0x00ba;
    L_0x00aa:
        if (r1 == 0) goto L_0x00bc;
    L_0x00ac:
        if (r2 != 0) goto L_0x00af;
    L_0x00ae:
        return r0;
    L_0x00af:
        r1 = r3.h;
        r4 = r4.h;
        r4 = r1.a(r4);
        if (r4 != 0) goto L_0x00ba;
    L_0x00b9:
        return r0;
    L_0x00ba:
        r4 = 1;
        return r4;
    L_0x00bc:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.af.a(com.xiaomi.xmpush.thrift.af):boolean");
    }

    public int b(af afVar) {
        if (!getClass().equals(afVar.getClass())) {
            return getClass().getName().compareTo(afVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(afVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.a, afVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(afVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.b, afVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(afVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.c, afVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(afVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.d, afVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(afVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.e, afVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(afVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.b.a(this.f, afVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(afVar.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            compareTo = org.apache.thrift.b.a(this.g, afVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(afVar.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            int a = org.apache.thrift.b.a(this.h, afVar.h);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public af b(String str) {
        this.f = str;
        return this;
    }

    public void b(e eVar) {
        o();
        eVar.a(j);
        if (this.a != null) {
            eVar.a(k);
            eVar.a(this.a.a());
            eVar.b();
        }
        eVar.a(l);
        eVar.a(this.b);
        eVar.b();
        eVar.a(m);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(n);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && i()) {
            eVar.a(o);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && k()) {
            eVar.a(p);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null) {
            eVar.a(q);
            this.g.b(eVar);
            eVar.b();
        }
        if (this.h != null && n()) {
            eVar.a(r);
            this.h.b(eVar);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.s.set(0, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public af c(boolean z) {
        this.c = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((af) obj);
    }

    public void d(boolean z) {
        this.s.set(1, z);
    }

    public boolean d() {
        return this.s.get(0);
    }

    public boolean e() {
        return this.s.get(1);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof af)) ? a((af) obj) : false;
    }

    public byte[] f() {
        a(org.apache.thrift.b.c(this.d));
        return this.d.array();
    }

    public boolean g() {
        return this.d != null;
    }

    public String h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.e != null;
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g != null;
    }

    public u m() {
        return this.h;
    }

    public boolean n() {
        return this.h != null;
    }

    public void o() {
        StringBuilder stringBuilder;
        if (this.a == null) {
            stringBuilder = new StringBuilder("Required field 'action' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.d == null) {
            stringBuilder = new StringBuilder("Required field 'pushAction' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.g == null) {
            stringBuilder = new StringBuilder("Required field 'target' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionContainer(");
        stringBuilder.append("action:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("encryptAction:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("isRequest:");
        stringBuilder.append(this.c);
        stringBuilder.append(", ");
        stringBuilder.append("pushAction:");
        if (this.d == null) {
            stringBuilder.append("null");
        } else {
            org.apache.thrift.b.a(this.d, stringBuilder);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("appid:");
            stringBuilder.append(this.e == null ? "null" : this.e);
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.f == null ? "null" : this.f);
        }
        stringBuilder.append(", ");
        stringBuilder.append("target:");
        if (this.g == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.g);
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("metaInfo:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
