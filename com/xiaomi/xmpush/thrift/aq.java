package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class aq implements Serializable, Cloneable, a<aq, a> {
    public static final Map<a, b> k;
    private static final j l = new j("XmPushActionUnRegistration");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("debug", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("target", (byte) 12, (short) 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("appId", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("regId", (byte) 11, (short) 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("appVersion", (byte) 11, (short) 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("token", (byte) 11, (short) 8);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("deviceId", (byte) 11, (short) 9);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("aliasName", (byte) 11, (short) 10);
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.b, new b("target", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.c, new b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.d, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.e, new b("regId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.f, new b("appVersion", (byte) 2, new c((byte) 11)));
        enumMap.put(a.g, new b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        enumMap.put(a.h, new b("token", (byte) 2, new c((byte) 11)));
        enumMap.put(a.i, new b("deviceId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.j, new b("aliasName", (byte) 2, new c((byte) 11)));
        k = Collections.unmodifiableMap(enumMap);
        b.a(aq.class, k);
    }

    public aq a(String str) {
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
        if (r1 == 0) goto L_0x0094;
    L_0x000b:
        r1 = r0.c;
        r2 = 11;
        switch(r1) {
            case 1: goto L_0x0085;
            case 2: goto L_0x0072;
            case 3: goto L_0x0067;
            case 4: goto L_0x005c;
            case 5: goto L_0x0051;
            case 6: goto L_0x0046;
            case 7: goto L_0x003b;
            case 8: goto L_0x0030;
            case 9: goto L_0x0025;
            case 10: goto L_0x0019;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r4, r0);
        goto L_0x008f;
    L_0x0019:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x001d:
        r0 = r4.w();
        r3.j = r0;
        goto L_0x008f;
    L_0x0025:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0029:
        r0 = r4.w();
        r3.i = r0;
        goto L_0x008f;
    L_0x0030:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0034:
        r0 = r4.w();
        r3.h = r0;
        goto L_0x008f;
    L_0x003b:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x003f:
        r0 = r4.w();
        r3.g = r0;
        goto L_0x008f;
    L_0x0046:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x004a:
        r0 = r4.w();
        r3.f = r0;
        goto L_0x008f;
    L_0x0051:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0055:
        r0 = r4.w();
        r3.e = r0;
        goto L_0x008f;
    L_0x005c:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0060:
        r0 = r4.w();
        r3.d = r0;
        goto L_0x008f;
    L_0x0067:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x006b:
        r0 = r4.w();
        r3.c = r0;
        goto L_0x008f;
    L_0x0072:
        r1 = r0.b;
        r2 = 12;
        if (r1 != r2) goto L_0x0012;
    L_0x0078:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r3.b = r0;
        r0 = r3.b;
        r0.a(r4);
        goto L_0x008f;
    L_0x0085:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0089:
        r0 = r4.w();
        r3.a = r0;
    L_0x008f:
        r4.j();
        goto L_0x0003;
    L_0x0094:
        r4.h();
        r3.k();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.aq.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.aq r4) {
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
        if (r1 == 0) goto L_0x011e;
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
        if (r1 == 0) goto L_0x011e;
    L_0x002e:
        if (r2 != 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r3.b;
        r2 = r4.b;
        r1 = r1.a(r2);
        if (r1 != 0) goto L_0x003c;
    L_0x003b:
        return r0;
    L_0x003c:
        r1 = r3.c();
        r2 = r4.c();
        if (r1 != 0) goto L_0x0048;
    L_0x0046:
        if (r2 == 0) goto L_0x0058;
    L_0x0048:
        if (r1 == 0) goto L_0x011e;
    L_0x004a:
        if (r2 != 0) goto L_0x004d;
    L_0x004c:
        return r0;
    L_0x004d:
        r1 = r3.c;
        r2 = r4.c;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0058;
    L_0x0057:
        return r0;
    L_0x0058:
        r1 = r3.d();
        r2 = r4.d();
        if (r1 != 0) goto L_0x0064;
    L_0x0062:
        if (r2 == 0) goto L_0x0074;
    L_0x0064:
        if (r1 == 0) goto L_0x011e;
    L_0x0066:
        if (r2 != 0) goto L_0x0069;
    L_0x0068:
        return r0;
    L_0x0069:
        r1 = r3.d;
        r2 = r4.d;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0074;
    L_0x0073:
        return r0;
    L_0x0074:
        r1 = r3.e();
        r2 = r4.e();
        if (r1 != 0) goto L_0x0080;
    L_0x007e:
        if (r2 == 0) goto L_0x0090;
    L_0x0080:
        if (r1 == 0) goto L_0x011e;
    L_0x0082:
        if (r2 != 0) goto L_0x0085;
    L_0x0084:
        return r0;
    L_0x0085:
        r1 = r3.e;
        r2 = r4.e;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0090;
    L_0x008f:
        return r0;
    L_0x0090:
        r1 = r3.f();
        r2 = r4.f();
        if (r1 != 0) goto L_0x009c;
    L_0x009a:
        if (r2 == 0) goto L_0x00ac;
    L_0x009c:
        if (r1 == 0) goto L_0x011e;
    L_0x009e:
        if (r2 != 0) goto L_0x00a1;
    L_0x00a0:
        return r0;
    L_0x00a1:
        r1 = r3.f;
        r2 = r4.f;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00ac;
    L_0x00ab:
        return r0;
    L_0x00ac:
        r1 = r3.g();
        r2 = r4.g();
        if (r1 != 0) goto L_0x00b8;
    L_0x00b6:
        if (r2 == 0) goto L_0x00c8;
    L_0x00b8:
        if (r1 == 0) goto L_0x011e;
    L_0x00ba:
        if (r2 != 0) goto L_0x00bd;
    L_0x00bc:
        return r0;
    L_0x00bd:
        r1 = r3.g;
        r2 = r4.g;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00c8;
    L_0x00c7:
        return r0;
    L_0x00c8:
        r1 = r3.h();
        r2 = r4.h();
        if (r1 != 0) goto L_0x00d4;
    L_0x00d2:
        if (r2 == 0) goto L_0x00e4;
    L_0x00d4:
        if (r1 == 0) goto L_0x011e;
    L_0x00d6:
        if (r2 != 0) goto L_0x00d9;
    L_0x00d8:
        return r0;
    L_0x00d9:
        r1 = r3.h;
        r2 = r4.h;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00e4;
    L_0x00e3:
        return r0;
    L_0x00e4:
        r1 = r3.i();
        r2 = r4.i();
        if (r1 != 0) goto L_0x00f0;
    L_0x00ee:
        if (r2 == 0) goto L_0x0100;
    L_0x00f0:
        if (r1 == 0) goto L_0x011e;
    L_0x00f2:
        if (r2 != 0) goto L_0x00f5;
    L_0x00f4:
        return r0;
    L_0x00f5:
        r1 = r3.i;
        r2 = r4.i;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0100;
    L_0x00ff:
        return r0;
    L_0x0100:
        r1 = r3.j();
        r2 = r4.j();
        if (r1 != 0) goto L_0x010c;
    L_0x010a:
        if (r2 == 0) goto L_0x011c;
    L_0x010c:
        if (r1 == 0) goto L_0x011e;
    L_0x010e:
        if (r2 != 0) goto L_0x0111;
    L_0x0110:
        return r0;
    L_0x0111:
        r1 = r3.j;
        r4 = r4.j;
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x011c;
    L_0x011b:
        return r0;
    L_0x011c:
        r4 = 1;
        return r4;
    L_0x011e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.aq.a(com.xiaomi.xmpush.thrift.aq):boolean");
    }

    public int b(aq aqVar) {
        if (!getClass().equals(aqVar.getClass())) {
            return getClass().getName().compareTo(aqVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aqVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, aqVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aqVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, aqVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(aqVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.c, aqVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aqVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.d, aqVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(aqVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.e, aqVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aqVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.f, aqVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aqVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.g, aqVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(aqVar.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.b.a(this.h, aqVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(aqVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.i, aqVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(aqVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            int a = org.apache.thrift.b.a(this.j, aqVar.j);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public aq b(String str) {
        this.d = str;
        return this;
    }

    public void b(e eVar) {
        k();
        eVar.a(l);
        if (this.a != null && a()) {
            eVar.a(m);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(n);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(o);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(p);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(q);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(r);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(s);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(t);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && i()) {
            eVar.a(u);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && j()) {
            eVar.a(v);
            eVar.a(this.j);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public aq c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((aq) obj);
    }

    public aq d(String str) {
        this.g = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public aq e(String str) {
        this.h = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof aq)) ? a((aq) obj) : false;
    }

    public boolean f() {
        return this.f != null;
    }

    public boolean g() {
        return this.g != null;
    }

    public boolean h() {
        return this.h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.i != null;
    }

    public boolean j() {
        return this.j != null;
    }

    public void k() {
        StringBuilder stringBuilder;
        if (this.c == null) {
            stringBuilder = new StringBuilder("Required field 'id' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.d == null) {
            stringBuilder = new StringBuilder("Required field 'appId' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionUnRegistration(");
        if (a()) {
            stringBuilder.append("debug:");
            stringBuilder.append(this.a == null ? "null" : this.a);
            obj = null;
        } else {
            obj = 1;
        }
        if (b()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
            obj = null;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        stringBuilder.append(this.c == null ? "null" : this.c);
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        stringBuilder.append(this.d == null ? "null" : this.d);
        if (e()) {
            stringBuilder.append(", ");
            stringBuilder.append("regId:");
            stringBuilder.append(this.e == null ? "null" : this.e);
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("appVersion:");
            stringBuilder.append(this.f == null ? "null" : this.f);
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.g == null ? "null" : this.g);
        }
        if (h()) {
            stringBuilder.append(", ");
            stringBuilder.append("token:");
            stringBuilder.append(this.h == null ? "null" : this.h);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("deviceId:");
            stringBuilder.append(this.i == null ? "null" : this.i);
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("aliasName:");
            stringBuilder.append(this.j == null ? "null" : this.j);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
