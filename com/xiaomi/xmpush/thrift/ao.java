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

public class ao implements Serializable, Cloneable, a<ao, a> {
    public static final Map<a, b> h;
    private static final j i = new j("XmPushActionSubscription");
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("debug", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("target", (byte) 12, (short) 2);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("appId", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("topic", (byte) 11, (short) 5);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 6);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("category", (byte) 11, (short) 7);
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.b, new b("target", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.c, new b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.d, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.e, new b("topic", (byte) 1, new c((byte) 11)));
        enumMap.put(a.f, new b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        enumMap.put(a.g, new b("category", (byte) 2, new c((byte) 11)));
        h = Collections.unmodifiableMap(enumMap);
        b.a(ao.class, h);
    }

    public ao a(String str) {
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
        if (r1 == 0) goto L_0x0070;
    L_0x000b:
        r1 = r0.c;
        r2 = 11;
        switch(r1) {
            case 1: goto L_0x0062;
            case 2: goto L_0x004f;
            case 3: goto L_0x0044;
            case 4: goto L_0x0039;
            case 5: goto L_0x002e;
            case 6: goto L_0x0023;
            case 7: goto L_0x0018;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r4, r0);
        goto L_0x006c;
    L_0x0018:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x001c:
        r0 = r4.w();
        r3.g = r0;
        goto L_0x006c;
    L_0x0023:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0027:
        r0 = r4.w();
        r3.f = r0;
        goto L_0x006c;
    L_0x002e:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0032:
        r0 = r4.w();
        r3.e = r0;
        goto L_0x006c;
    L_0x0039:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x003d:
        r0 = r4.w();
        r3.d = r0;
        goto L_0x006c;
    L_0x0044:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0048:
        r0 = r4.w();
        r3.c = r0;
        goto L_0x006c;
    L_0x004f:
        r1 = r0.b;
        r2 = 12;
        if (r1 != r2) goto L_0x0012;
    L_0x0055:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r3.b = r0;
        r0 = r3.b;
        r0.a(r4);
        goto L_0x006c;
    L_0x0062:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0066:
        r0 = r4.w();
        r3.a = r0;
    L_0x006c:
        r4.j();
        goto L_0x0003;
    L_0x0070:
        r4.h();
        r3.h();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ao.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.ao r4) {
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
        if (r1 == 0) goto L_0x00ca;
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
        if (r1 == 0) goto L_0x00ca;
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
        if (r1 == 0) goto L_0x00ca;
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
        if (r1 == 0) goto L_0x00ca;
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
        if (r1 == 0) goto L_0x00ca;
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
        if (r1 == 0) goto L_0x00ca;
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
        if (r1 == 0) goto L_0x00ca;
    L_0x00ba:
        if (r2 != 0) goto L_0x00bd;
    L_0x00bc:
        return r0;
    L_0x00bd:
        r1 = r3.g;
        r4 = r4.g;
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x00c8;
    L_0x00c7:
        return r0;
    L_0x00c8:
        r4 = 1;
        return r4;
    L_0x00ca:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ao.a(com.xiaomi.xmpush.thrift.ao):boolean");
    }

    public int b(ao aoVar) {
        if (!getClass().equals(aoVar.getClass())) {
            return getClass().getName().compareTo(aoVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aoVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, aoVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aoVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, aoVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(aoVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.c, aoVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aoVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.d, aoVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(aoVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.e, aoVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aoVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.f, aoVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aoVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            int a = org.apache.thrift.b.a(this.g, aoVar.g);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public ao b(String str) {
        this.d = str;
        return this;
    }

    public void b(e eVar) {
        h();
        eVar.a(i);
        if (this.a != null && a()) {
            eVar.a(j);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(k);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(l);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(m);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null) {
            eVar.a(n);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(o);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(p);
            eVar.a(this.g);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public ao c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((ao) obj);
    }

    public ao d(String str) {
        this.f = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public ao e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ao)) ? a((ao) obj) : false;
    }

    public boolean f() {
        return this.f != null;
    }

    public boolean g() {
        return this.g != null;
    }

    public void h() {
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
            stringBuilder = new StringBuilder("Required field 'topic' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSubscription(");
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
        stringBuilder.append("topic:");
        stringBuilder.append(this.e == null ? "null" : this.e);
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.f == null ? "null" : this.f);
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            stringBuilder.append(this.g == null ? "null" : this.g);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
