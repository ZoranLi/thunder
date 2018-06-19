package com.xiaomi.xmpush.thrift;

import com.igexin.assist.sdk.AssistPushConsts;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class t implements Serializable, Cloneable, org.apache.thrift.a<t, a> {
    public static final Map<a, b> i;
    private static final j j = new j("PushMessage");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("to", (byte) 12, (short) 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("appId", (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b(AssistPushConsts.MSG_TYPE_PAYLOAD, (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("createAt", (byte) 10, (short) 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("ttl", (byte) 10, (short) 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("collapseKey", (byte) 11, (short) 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 8);
    public x a;
    public String b;
    public String c;
    public String d;
    public long e;
    public long f;
    public String g;
    public String h;
    private BitSet s = new BitSet(2);

    public enum a {
        TO((short) 1, "to"),
        ID((short) 2, AgooConstants.MESSAGE_ID),
        APP_ID((short) 3, "appId"),
        PAYLOAD((short) 4, AssistPushConsts.MSG_TYPE_PAYLOAD),
        CREATE_AT((short) 5, "createAt"),
        TTL((short) 6, "ttl"),
        COLLAPSE_KEY((short) 7, "collapseKey"),
        PACKAGE_NAME((short) 8, Constants.KEY_PACKAGE_NAME);
        
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
        enumMap.put(a.TO, new b("to", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.ID, new b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.PAYLOAD, new b(AssistPushConsts.MSG_TYPE_PAYLOAD, (byte) 1, new c((byte) 11)));
        enumMap.put(a.CREATE_AT, new b("createAt", (byte) 2, new c((byte) 10)));
        enumMap.put(a.TTL, new b("ttl", (byte) 2, new c((byte) 10)));
        enumMap.put(a.COLLAPSE_KEY, new b("collapseKey", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PACKAGE_NAME, new b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        i = Collections.unmodifiableMap(enumMap);
        b.a(t.class, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r6) {
        /*
        r5 = this;
        r6.g();
    L_0x0003:
        r0 = r6.i();
        r1 = r0.b;
        if (r1 == 0) goto L_0x0085;
    L_0x000b:
        r1 = r0.c;
        r2 = 1;
        r3 = 10;
        r4 = 11;
        switch(r1) {
            case 1: goto L_0x006e;
            case 2: goto L_0x0063;
            case 3: goto L_0x0058;
            case 4: goto L_0x004d;
            case 5: goto L_0x003f;
            case 6: goto L_0x0031;
            case 7: goto L_0x0026;
            case 8: goto L_0x001b;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r6, r0);
        goto L_0x0080;
    L_0x001b:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x001f:
        r0 = r6.w();
        r5.h = r0;
        goto L_0x0080;
    L_0x0026:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x002a:
        r0 = r6.w();
        r5.g = r0;
        goto L_0x0080;
    L_0x0031:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0015;
    L_0x0035:
        r0 = r6.u();
        r5.f = r0;
        r5.b(r2);
        goto L_0x0080;
    L_0x003f:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0015;
    L_0x0043:
        r0 = r6.u();
        r5.e = r0;
        r5.a(r2);
        goto L_0x0080;
    L_0x004d:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x0051:
        r0 = r6.w();
        r5.d = r0;
        goto L_0x0080;
    L_0x0058:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x005c:
        r0 = r6.w();
        r5.c = r0;
        goto L_0x0080;
    L_0x0063:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0015;
    L_0x0067:
        r0 = r6.w();
        r5.b = r0;
        goto L_0x0080;
    L_0x006e:
        r1 = r0.b;
        r2 = 12;
        if (r1 != r2) goto L_0x0015;
    L_0x0074:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r5.a = r0;
        r0 = r5.a;
        r0.a(r6);
    L_0x0080:
        r6.j();
        goto L_0x0003;
    L_0x0085:
        r6.h();
        r5.m();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.t.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.s.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.t r7) {
        /*
        r6 = this;
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r6.a();
        r2 = r7.a();
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        if (r2 == 0) goto L_0x0020;
    L_0x0010:
        if (r1 == 0) goto L_0x00e2;
    L_0x0012:
        if (r2 != 0) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        r1 = r6.a;
        r2 = r7.a;
        r1 = r1.a(r2);
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
        if (r1 == 0) goto L_0x00e2;
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
        if (r1 == 0) goto L_0x00e2;
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
        r1 = r6.g();
        r2 = r7.g();
        if (r1 != 0) goto L_0x0064;
    L_0x0062:
        if (r2 == 0) goto L_0x0074;
    L_0x0064:
        if (r1 == 0) goto L_0x00e2;
    L_0x0066:
        if (r2 != 0) goto L_0x0069;
    L_0x0068:
        return r0;
    L_0x0069:
        r1 = r6.d;
        r2 = r7.d;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0074;
    L_0x0073:
        return r0;
    L_0x0074:
        r1 = r6.i();
        r2 = r7.i();
        if (r1 != 0) goto L_0x0080;
    L_0x007e:
        if (r2 == 0) goto L_0x008e;
    L_0x0080:
        if (r1 == 0) goto L_0x00e2;
    L_0x0082:
        if (r2 != 0) goto L_0x0085;
    L_0x0084:
        return r0;
    L_0x0085:
        r1 = r6.e;
        r3 = r7.e;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x008e;
    L_0x008d:
        return r0;
    L_0x008e:
        r1 = r6.j();
        r2 = r7.j();
        if (r1 != 0) goto L_0x009a;
    L_0x0098:
        if (r2 == 0) goto L_0x00a8;
    L_0x009a:
        if (r1 == 0) goto L_0x00e2;
    L_0x009c:
        if (r2 != 0) goto L_0x009f;
    L_0x009e:
        return r0;
    L_0x009f:
        r1 = r6.f;
        r3 = r7.f;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x00a8;
    L_0x00a7:
        return r0;
    L_0x00a8:
        r1 = r6.k();
        r2 = r7.k();
        if (r1 != 0) goto L_0x00b4;
    L_0x00b2:
        if (r2 == 0) goto L_0x00c4;
    L_0x00b4:
        if (r1 == 0) goto L_0x00e2;
    L_0x00b6:
        if (r2 != 0) goto L_0x00b9;
    L_0x00b8:
        return r0;
    L_0x00b9:
        r1 = r6.g;
        r2 = r7.g;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00c4;
    L_0x00c3:
        return r0;
    L_0x00c4:
        r1 = r6.l();
        r2 = r7.l();
        if (r1 != 0) goto L_0x00d0;
    L_0x00ce:
        if (r2 == 0) goto L_0x00e0;
    L_0x00d0:
        if (r1 == 0) goto L_0x00e2;
    L_0x00d2:
        if (r2 != 0) goto L_0x00d5;
    L_0x00d4:
        return r0;
    L_0x00d5:
        r1 = r6.h;
        r7 = r7.h;
        r7 = r1.equals(r7);
        if (r7 != 0) goto L_0x00e0;
    L_0x00df:
        return r0;
    L_0x00e0:
        r7 = 1;
        return r7;
    L_0x00e2:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.t.a(com.xiaomi.xmpush.thrift.t):boolean");
    }

    public int b(t tVar) {
        if (!getClass().equals(tVar.getClass())) {
            return getClass().getName().compareTo(tVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(tVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, tVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(tVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.b, tVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(tVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.c, tVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(tVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.d, tVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(tVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.e, tVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(tVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.b.a(this.f, tVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(tVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.b.a(this.g, tVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(tVar.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            int a = org.apache.thrift.b.a(this.h, tVar.h);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public String b() {
        return this.b;
    }

    public void b(e eVar) {
        m();
        eVar.a(j);
        if (this.a != null && a()) {
            eVar.a(k);
            this.a.b(eVar);
            eVar.b();
        }
        if (this.b != null) {
            eVar.a(l);
            eVar.a(this.b);
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
        if (i()) {
            eVar.a(o);
            eVar.a(this.e);
            eVar.b();
        }
        if (j()) {
            eVar.a(p);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && k()) {
            eVar.a(q);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && l()) {
            eVar.a(r);
            eVar.a(this.h);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.s.set(1, z);
    }

    public boolean c() {
        return this.b != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((t) obj);
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return this.c != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof t)) ? a((t) obj) : false;
    }

    public String f() {
        return this.d;
    }

    public boolean g() {
        return this.d != null;
    }

    public long h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.s.get(0);
    }

    public boolean j() {
        return this.s.get(1);
    }

    public boolean k() {
        return this.g != null;
    }

    public boolean l() {
        return this.h != null;
    }

    public void m() {
        StringBuilder stringBuilder;
        if (this.b == null) {
            stringBuilder = new StringBuilder("Required field 'id' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.c == null) {
            stringBuilder = new StringBuilder("Required field 'appId' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.d == null) {
            stringBuilder = new StringBuilder("Required field 'payload' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("PushMessage(");
        if (a()) {
            stringBuilder.append("to:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        stringBuilder.append(this.b == null ? "null" : this.b);
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        stringBuilder.append(this.c == null ? "null" : this.c);
        stringBuilder.append(", ");
        stringBuilder.append("payload:");
        stringBuilder.append(this.d == null ? "null" : this.d);
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("createAt:");
            stringBuilder.append(this.e);
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("ttl:");
            stringBuilder.append(this.f);
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("collapseKey:");
            stringBuilder.append(this.g == null ? "null" : this.g);
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.h == null ? "null" : this.h);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
