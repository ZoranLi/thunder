package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class ad implements Serializable, Cloneable, a<ad, a> {
    public static final Map<a, b> i;
    private static final j j = new j("XmPushActionCommand");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("debug", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("target", (byte) 12, (short) 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("appId", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("cmdName", (byte) 11, (short) 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("cmdArgs", (byte) 15, (short) 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("category", (byte) 11, (short) 9);
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public List<String> f;
    public String g;
    public String h;

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.b, new b("target", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.c, new b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.d, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.e, new b("cmdName", (byte) 1, new c((byte) 11)));
        enumMap.put(a.f, new b("cmdArgs", (byte) 2, new d((byte) 15, new c((byte) 11))));
        enumMap.put(a.g, new b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        enumMap.put(a.h, new b("category", (byte) 2, new c((byte) 11)));
        i = Collections.unmodifiableMap(enumMap);
        b.a(ad.class, i);
    }

    public ad a(String str) {
        this.c = str;
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
        if (r1 == 0) goto L_0x009b;
    L_0x000b:
        r1 = r0.c;
        r2 = 11;
        switch(r1) {
            case 1: goto L_0x008c;
            case 2: goto L_0x0079;
            case 3: goto L_0x006e;
            case 4: goto L_0x0063;
            case 5: goto L_0x0058;
            case 6: goto L_0x0030;
            case 7: goto L_0x0025;
            case 8: goto L_0x0012;
            case 9: goto L_0x0019;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r5, r0);
        goto L_0x0096;
    L_0x0019:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x001d:
        r0 = r5.w();
        r4.h = r0;
        goto L_0x0096;
    L_0x0025:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0029:
        r0 = r5.w();
        r4.g = r0;
        goto L_0x0096;
    L_0x0030:
        r1 = r0.b;
        r2 = 15;
        if (r1 != r2) goto L_0x0012;
    L_0x0036:
        r0 = r5.m();
        r1 = new java.util.ArrayList;
        r2 = r0.b;
        r1.<init>(r2);
        r4.f = r1;
        r1 = 0;
    L_0x0044:
        r2 = r0.b;
        if (r1 >= r2) goto L_0x0054;
    L_0x0048:
        r2 = r5.w();
        r3 = r4.f;
        r3.add(r2);
        r1 = r1 + 1;
        goto L_0x0044;
    L_0x0054:
        r5.n();
        goto L_0x0096;
    L_0x0058:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x005c:
        r0 = r5.w();
        r4.e = r0;
        goto L_0x0096;
    L_0x0063:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0067:
        r0 = r5.w();
        r4.d = r0;
        goto L_0x0096;
    L_0x006e:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0072:
        r0 = r5.w();
        r4.c = r0;
        goto L_0x0096;
    L_0x0079:
        r1 = r0.b;
        r2 = 12;
        if (r1 != r2) goto L_0x0012;
    L_0x007f:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r4.b = r0;
        r0 = r4.b;
        r0.a(r5);
        goto L_0x0096;
    L_0x008c:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0090:
        r0 = r5.w();
        r4.a = r0;
    L_0x0096:
        r5.j();
        goto L_0x0003;
    L_0x009b:
        r5.h();
        r4.i();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ad.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.ad r4) {
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
        if (r1 == 0) goto L_0x00e6;
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
        if (r1 == 0) goto L_0x00e6;
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
        if (r1 == 0) goto L_0x00e6;
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
        if (r1 == 0) goto L_0x00e6;
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
        if (r1 == 0) goto L_0x00e6;
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
        if (r1 == 0) goto L_0x00e6;
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
        if (r1 == 0) goto L_0x00e6;
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
        if (r1 == 0) goto L_0x00e6;
    L_0x00d6:
        if (r2 != 0) goto L_0x00d9;
    L_0x00d8:
        return r0;
    L_0x00d9:
        r1 = r3.h;
        r4 = r4.h;
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x00e4;
    L_0x00e3:
        return r0;
    L_0x00e4:
        r4 = 1;
        return r4;
    L_0x00e6:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ad.a(com.xiaomi.xmpush.thrift.ad):boolean");
    }

    public int b(ad adVar) {
        if (!getClass().equals(adVar.getClass())) {
            return getClass().getName().compareTo(adVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(adVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, adVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(adVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, adVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(adVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.c, adVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(adVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.d, adVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(adVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.e, adVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(adVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.f, adVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(adVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.g, adVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(adVar.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            int a = org.apache.thrift.b.a(this.h, adVar.h);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public ad b(String str) {
        this.d = str;
        return this;
    }

    public void b(e eVar) {
        i();
        eVar.a(j);
        if (this.a != null && a()) {
            eVar.a(k);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(l);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(m);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(n);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null) {
            eVar.a(o);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(p);
            eVar.a(new org.apache.thrift.protocol.c((byte) 11, this.f.size()));
            for (String a : this.f) {
                eVar.a(a);
            }
            eVar.e();
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(q);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(r);
            eVar.a(this.h);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public ad c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((ad) obj);
    }

    public void d(String str) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(str);
    }

    public boolean d() {
        return this.d != null;
    }

    public ad e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ad)) ? a((ad) obj) : false;
    }

    public ad f(String str) {
        this.h = str;
        return this;
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

    public void i() {
        StringBuilder stringBuilder;
        if (this.c == null) {
            stringBuilder = new StringBuilder("Required field 'id' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.d == null) {
            stringBuilder = new StringBuilder("Required field 'appId' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.e == null) {
            stringBuilder = new StringBuilder("Required field 'cmdName' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCommand(");
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
        stringBuilder.append(", ");
        stringBuilder.append("cmdName:");
        stringBuilder.append(this.e == null ? "null" : this.e);
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("cmdArgs:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.g == null ? "null" : this.g);
        }
        if (h()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            stringBuilder.append(this.h == null ? "null" : this.h);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
