package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.tencent.open.SocialConstants;
import com.umeng.message.proguard.k;
import com.xunlei.download.DownloadManager;
import java.io.Serializable;
import java.util.BitSet;
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

public class ap implements Serializable, Cloneable, a<ap, a> {
    public static final Map<a, b> k;
    private static final j l = new j("XmPushActionSubscriptionResult");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("debug", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("target", (byte) 12, (short) 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("appId", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b(SocialConstants.TYPE_REQUEST, (byte) 12, (short) 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("errorCode", (byte) 10, (short) 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b(DownloadManager.COLUMN_REASON, (byte) 11, (short) 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("topic", (byte) 11, (short) 8);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 9);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("category", (byte) 11, (short) 10);
    public String a;
    public x b;
    public String c;
    public String d;
    public ao e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    private BitSet w = new BitSet(1);

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.b, new b("target", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.c, new b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.d, new b("appId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.e, new b(SocialConstants.TYPE_REQUEST, (byte) 2, new g((byte) 12, ao.class)));
        enumMap.put(a.f, new b("errorCode", (byte) 2, new c((byte) 10)));
        enumMap.put(a.g, new b(DownloadManager.COLUMN_REASON, (byte) 2, new c((byte) 11)));
        enumMap.put(a.h, new b("topic", (byte) 2, new c((byte) 11)));
        enumMap.put(a.i, new b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        enumMap.put(a.j, new b("category", (byte) 2, new c((byte) 11)));
        k = Collections.unmodifiableMap(enumMap);
        b.a(ap.class, k);
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
        if (r1 == 0) goto L_0x00a1;
    L_0x000b:
        r1 = r0.c;
        r2 = 12;
        r3 = 11;
        switch(r1) {
            case 1: goto L_0x0092;
            case 2: goto L_0x0081;
            case 3: goto L_0x0076;
            case 4: goto L_0x006b;
            case 5: goto L_0x005a;
            case 6: goto L_0x0049;
            case 7: goto L_0x003e;
            case 8: goto L_0x0033;
            case 9: goto L_0x0027;
            case 10: goto L_0x001b;
            default: goto L_0x0014;
        };
    L_0x0014:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r5, r0);
        goto L_0x009c;
    L_0x001b:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x001f:
        r0 = r5.w();
        r4.j = r0;
        goto L_0x009c;
    L_0x0027:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x002b:
        r0 = r5.w();
        r4.i = r0;
        goto L_0x009c;
    L_0x0033:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x0037:
        r0 = r5.w();
        r4.h = r0;
        goto L_0x009c;
    L_0x003e:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x0042:
        r0 = r5.w();
        r4.g = r0;
        goto L_0x009c;
    L_0x0049:
        r1 = r0.b;
        r2 = 10;
        if (r1 != r2) goto L_0x0014;
    L_0x004f:
        r0 = r5.u();
        r4.f = r0;
        r0 = 1;
        r4.a(r0);
        goto L_0x009c;
    L_0x005a:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0014;
    L_0x005e:
        r0 = new com.xiaomi.xmpush.thrift.ao;
        r0.<init>();
        r4.e = r0;
        r0 = r4.e;
        r0.a(r5);
        goto L_0x009c;
    L_0x006b:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x006f:
        r0 = r5.w();
        r4.d = r0;
        goto L_0x009c;
    L_0x0076:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x007a:
        r0 = r5.w();
        r4.c = r0;
        goto L_0x009c;
    L_0x0081:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0014;
    L_0x0085:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r4.b = r0;
        r0 = r4.b;
        r0.a(r5);
        goto L_0x009c;
    L_0x0092:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x0096:
        r0 = r5.w();
        r4.a = r0;
    L_0x009c:
        r5.j();
        goto L_0x0003;
    L_0x00a1:
        r5.h();
        r4.m();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ap.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.w.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.ap r7) {
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
        if (r1 == 0) goto L_0x011c;
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
        r1 = r6.b();
        r2 = r7.b();
        if (r1 != 0) goto L_0x002c;
    L_0x002a:
        if (r2 == 0) goto L_0x003c;
    L_0x002c:
        if (r1 == 0) goto L_0x011c;
    L_0x002e:
        if (r2 != 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r6.b;
        r2 = r7.b;
        r1 = r1.a(r2);
        if (r1 != 0) goto L_0x003c;
    L_0x003b:
        return r0;
    L_0x003c:
        r1 = r6.c();
        r2 = r7.c();
        if (r1 != 0) goto L_0x0048;
    L_0x0046:
        if (r2 == 0) goto L_0x0058;
    L_0x0048:
        if (r1 == 0) goto L_0x011c;
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
        r1 = r6.d();
        r2 = r7.d();
        if (r1 != 0) goto L_0x0064;
    L_0x0062:
        if (r2 == 0) goto L_0x0074;
    L_0x0064:
        if (r1 == 0) goto L_0x011c;
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
        r1 = r6.e();
        r2 = r7.e();
        if (r1 != 0) goto L_0x0080;
    L_0x007e:
        if (r2 == 0) goto L_0x0090;
    L_0x0080:
        if (r1 == 0) goto L_0x011c;
    L_0x0082:
        if (r2 != 0) goto L_0x0085;
    L_0x0084:
        return r0;
    L_0x0085:
        r1 = r6.e;
        r2 = r7.e;
        r1 = r1.a(r2);
        if (r1 != 0) goto L_0x0090;
    L_0x008f:
        return r0;
    L_0x0090:
        r1 = r6.f();
        r2 = r7.f();
        if (r1 != 0) goto L_0x009c;
    L_0x009a:
        if (r2 == 0) goto L_0x00aa;
    L_0x009c:
        if (r1 == 0) goto L_0x011c;
    L_0x009e:
        if (r2 != 0) goto L_0x00a1;
    L_0x00a0:
        return r0;
    L_0x00a1:
        r1 = r6.f;
        r3 = r7.f;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x00aa;
    L_0x00a9:
        return r0;
    L_0x00aa:
        r1 = r6.g();
        r2 = r7.g();
        if (r1 != 0) goto L_0x00b6;
    L_0x00b4:
        if (r2 == 0) goto L_0x00c6;
    L_0x00b6:
        if (r1 == 0) goto L_0x011c;
    L_0x00b8:
        if (r2 != 0) goto L_0x00bb;
    L_0x00ba:
        return r0;
    L_0x00bb:
        r1 = r6.g;
        r2 = r7.g;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00c6;
    L_0x00c5:
        return r0;
    L_0x00c6:
        r1 = r6.i();
        r2 = r7.i();
        if (r1 != 0) goto L_0x00d2;
    L_0x00d0:
        if (r2 == 0) goto L_0x00e2;
    L_0x00d2:
        if (r1 == 0) goto L_0x011c;
    L_0x00d4:
        if (r2 != 0) goto L_0x00d7;
    L_0x00d6:
        return r0;
    L_0x00d7:
        r1 = r6.h;
        r2 = r7.h;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00e2;
    L_0x00e1:
        return r0;
    L_0x00e2:
        r1 = r6.j();
        r2 = r7.j();
        if (r1 != 0) goto L_0x00ee;
    L_0x00ec:
        if (r2 == 0) goto L_0x00fe;
    L_0x00ee:
        if (r1 == 0) goto L_0x011c;
    L_0x00f0:
        if (r2 != 0) goto L_0x00f3;
    L_0x00f2:
        return r0;
    L_0x00f3:
        r1 = r6.i;
        r2 = r7.i;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00fe;
    L_0x00fd:
        return r0;
    L_0x00fe:
        r1 = r6.l();
        r2 = r7.l();
        if (r1 != 0) goto L_0x010a;
    L_0x0108:
        if (r2 == 0) goto L_0x011a;
    L_0x010a:
        if (r1 == 0) goto L_0x011c;
    L_0x010c:
        if (r2 != 0) goto L_0x010f;
    L_0x010e:
        return r0;
    L_0x010f:
        r1 = r6.j;
        r7 = r7.j;
        r7 = r1.equals(r7);
        if (r7 != 0) goto L_0x011a;
    L_0x0119:
        return r0;
    L_0x011a:
        r7 = 1;
        return r7;
    L_0x011c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ap.a(com.xiaomi.xmpush.thrift.ap):boolean");
    }

    public int b(ap apVar) {
        if (!getClass().equals(apVar.getClass())) {
            return getClass().getName().compareTo(apVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(apVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, apVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(apVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, apVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(apVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.c, apVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(apVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.d, apVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(apVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.e, apVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(apVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.f, apVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(apVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.g, apVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(apVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.h, apVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(apVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.b.a(this.i, apVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(apVar.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            int a = org.apache.thrift.b.a(this.j, apVar.j);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(e eVar) {
        m();
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
        if (this.d != null && d()) {
            eVar.a(p);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(q);
            this.e.b(eVar);
            eVar.b();
        }
        if (f()) {
            eVar.a(r);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(s);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && i()) {
            eVar.a(t);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && j()) {
            eVar.a(u);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
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

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((ap) obj);
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ap)) ? a((ap) obj) : false;
    }

    public boolean f() {
        return this.w.get(0);
    }

    public boolean g() {
        return this.g != null;
    }

    public String h() {
        return this.h;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.h != null;
    }

    public boolean j() {
        return this.i != null;
    }

    public String k() {
        return this.j;
    }

    public boolean l() {
        return this.j != null;
    }

    public void m() {
        if (this.c == null) {
            StringBuilder stringBuilder = new StringBuilder("Required field 'id' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSubscriptionResult(");
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
        if (d()) {
            stringBuilder.append(", ");
            stringBuilder.append("appId:");
            stringBuilder.append(this.d == null ? "null" : this.d);
        }
        if (e()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("errorCode:");
            stringBuilder.append(this.f);
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            stringBuilder.append(this.g == null ? "null" : this.g);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            stringBuilder.append(this.h == null ? "null" : this.h);
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.i == null ? "null" : this.i);
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            stringBuilder.append(this.j == null ? "null" : this.j);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
