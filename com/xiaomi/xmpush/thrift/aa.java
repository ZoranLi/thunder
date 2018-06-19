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
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.e;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class aa implements Serializable, Cloneable, a<aa, a> {
    public static final Map<a, b> l;
    private static final j m = new j("XmPushActionAckNotification");
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("debug", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("target", (byte) 12, (short) 2);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("appId", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("type", (byte) 11, (short) 5);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b(SocialConstants.TYPE_REQUEST, (byte) 12, (short) 6);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("errorCode", (byte) 10, (short) 7);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b(DownloadManager.COLUMN_REASON, (byte) 11, (short) 8);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("extra", (byte) 13, (short) 9);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 10);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("category", (byte) 11, (short) 11);
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public ai f;
    public long g;
    public String h;
    public Map<String, String> i;
    public String j;
    public String k;
    private BitSet y = new BitSet(1);

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.b, new b("target", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.c, new b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.d, new b("appId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.e, new b("type", (byte) 2, new c((byte) 11)));
        enumMap.put(a.f, new b(SocialConstants.TYPE_REQUEST, (byte) 2, new g((byte) 12, ai.class)));
        enumMap.put(a.g, new b("errorCode", (byte) 1, new c((byte) 10)));
        enumMap.put(a.h, new b(DownloadManager.COLUMN_REASON, (byte) 2, new c((byte) 11)));
        enumMap.put(a.i, new b("extra", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.j, new b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        enumMap.put(a.k, new b("category", (byte) 2, new c((byte) 11)));
        l = Collections.unmodifiableMap(enumMap);
        b.a(aa.class, l);
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
        if (r1 == 0) goto L_0x00d0;
    L_0x000b:
        r1 = r0.c;
        r2 = 12;
        r3 = 11;
        switch(r1) {
            case 1: goto L_0x00c1;
            case 2: goto L_0x00b0;
            case 3: goto L_0x00a5;
            case 4: goto L_0x009a;
            case 5: goto L_0x008f;
            case 6: goto L_0x007e;
            case 7: goto L_0x006d;
            case 8: goto L_0x0062;
            case 9: goto L_0x0033;
            case 10: goto L_0x0027;
            case 11: goto L_0x001b;
            default: goto L_0x0014;
        };
    L_0x0014:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r6, r0);
        goto L_0x00cb;
    L_0x001b:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x001f:
        r0 = r6.w();
        r5.k = r0;
        goto L_0x00cb;
    L_0x0027:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x002b:
        r0 = r6.w();
        r5.j = r0;
        goto L_0x00cb;
    L_0x0033:
        r1 = r0.b;
        r2 = 13;
        if (r1 != r2) goto L_0x0014;
    L_0x0039:
        r0 = r6.k();
        r1 = new java.util.HashMap;
        r2 = 2;
        r3 = r0.c;
        r2 = r2 * r3;
        r1.<init>(r2);
        r5.i = r1;
        r1 = 0;
    L_0x0049:
        r2 = r0.c;
        if (r1 >= r2) goto L_0x005d;
    L_0x004d:
        r2 = r6.w();
        r3 = r6.w();
        r4 = r5.i;
        r4.put(r2, r3);
        r1 = r1 + 1;
        goto L_0x0049;
    L_0x005d:
        r6.l();
        goto L_0x00cb;
    L_0x0062:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x0066:
        r0 = r6.w();
        r5.h = r0;
        goto L_0x00cb;
    L_0x006d:
        r1 = r0.b;
        r2 = 10;
        if (r1 != r2) goto L_0x0014;
    L_0x0073:
        r0 = r6.u();
        r5.g = r0;
        r0 = 1;
        r5.a(r0);
        goto L_0x00cb;
    L_0x007e:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0014;
    L_0x0082:
        r0 = new com.xiaomi.xmpush.thrift.ai;
        r0.<init>();
        r5.f = r0;
        r0 = r5.f;
        r0.a(r6);
        goto L_0x00cb;
    L_0x008f:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x0093:
        r0 = r6.w();
        r5.e = r0;
        goto L_0x00cb;
    L_0x009a:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x009e:
        r0 = r6.w();
        r5.d = r0;
        goto L_0x00cb;
    L_0x00a5:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x00a9:
        r0 = r6.w();
        r5.c = r0;
        goto L_0x00cb;
    L_0x00b0:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0014;
    L_0x00b4:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r5.b = r0;
        r0 = r5.b;
        r0.a(r6);
        goto L_0x00cb;
    L_0x00c1:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0014;
    L_0x00c5:
        r0 = r6.w();
        r5.a = r0;
    L_0x00cb:
        r6.j();
        goto L_0x0003;
    L_0x00d0:
        r6.h();
        r6 = r5.h();
        if (r6 != 0) goto L_0x00f1;
    L_0x00d9:
        r6 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'errorCode' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r5.toString();
        r0.append(r1);
        r0 = r0.toString();
        r6.<init>(r0);
        throw r6;
    L_0x00f1:
        r5.m();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.aa.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.y.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.aa r7) {
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
        if (r1 == 0) goto L_0x0127;
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
        if (r1 == 0) goto L_0x0127;
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
        r1 = r6.d();
        r2 = r7.d();
        if (r1 != 0) goto L_0x0048;
    L_0x0046:
        if (r2 == 0) goto L_0x0058;
    L_0x0048:
        if (r1 == 0) goto L_0x0127;
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
        r1 = r6.e();
        r2 = r7.e();
        if (r1 != 0) goto L_0x0064;
    L_0x0062:
        if (r2 == 0) goto L_0x0074;
    L_0x0064:
        if (r1 == 0) goto L_0x0127;
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
        r1 = r6.f();
        r2 = r7.f();
        if (r1 != 0) goto L_0x0080;
    L_0x007e:
        if (r2 == 0) goto L_0x0090;
    L_0x0080:
        if (r1 == 0) goto L_0x0127;
    L_0x0082:
        if (r2 != 0) goto L_0x0085;
    L_0x0084:
        return r0;
    L_0x0085:
        r1 = r6.e;
        r2 = r7.e;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0090;
    L_0x008f:
        return r0;
    L_0x0090:
        r1 = r6.g();
        r2 = r7.g();
        if (r1 != 0) goto L_0x009c;
    L_0x009a:
        if (r2 == 0) goto L_0x00ac;
    L_0x009c:
        if (r1 == 0) goto L_0x0127;
    L_0x009e:
        if (r2 != 0) goto L_0x00a1;
    L_0x00a0:
        return r0;
    L_0x00a1:
        r1 = r6.f;
        r2 = r7.f;
        r1 = r1.a(r2);
        if (r1 != 0) goto L_0x00ac;
    L_0x00ab:
        return r0;
    L_0x00ac:
        r1 = r6.g;
        r3 = r7.g;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x00b5;
    L_0x00b4:
        return r0;
    L_0x00b5:
        r1 = r6.i();
        r2 = r7.i();
        if (r1 != 0) goto L_0x00c1;
    L_0x00bf:
        if (r2 == 0) goto L_0x00d1;
    L_0x00c1:
        if (r1 == 0) goto L_0x0127;
    L_0x00c3:
        if (r2 != 0) goto L_0x00c6;
    L_0x00c5:
        return r0;
    L_0x00c6:
        r1 = r6.h;
        r2 = r7.h;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00d1;
    L_0x00d0:
        return r0;
    L_0x00d1:
        r1 = r6.j();
        r2 = r7.j();
        if (r1 != 0) goto L_0x00dd;
    L_0x00db:
        if (r2 == 0) goto L_0x00ed;
    L_0x00dd:
        if (r1 == 0) goto L_0x0127;
    L_0x00df:
        if (r2 != 0) goto L_0x00e2;
    L_0x00e1:
        return r0;
    L_0x00e2:
        r1 = r6.i;
        r2 = r7.i;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00ed;
    L_0x00ec:
        return r0;
    L_0x00ed:
        r1 = r6.k();
        r2 = r7.k();
        if (r1 != 0) goto L_0x00f9;
    L_0x00f7:
        if (r2 == 0) goto L_0x0109;
    L_0x00f9:
        if (r1 == 0) goto L_0x0127;
    L_0x00fb:
        if (r2 != 0) goto L_0x00fe;
    L_0x00fd:
        return r0;
    L_0x00fe:
        r1 = r6.j;
        r2 = r7.j;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0109;
    L_0x0108:
        return r0;
    L_0x0109:
        r1 = r6.l();
        r2 = r7.l();
        if (r1 != 0) goto L_0x0115;
    L_0x0113:
        if (r2 == 0) goto L_0x0125;
    L_0x0115:
        if (r1 == 0) goto L_0x0127;
    L_0x0117:
        if (r2 != 0) goto L_0x011a;
    L_0x0119:
        return r0;
    L_0x011a:
        r1 = r6.k;
        r7 = r7.k;
        r7 = r1.equals(r7);
        if (r7 != 0) goto L_0x0125;
    L_0x0124:
        return r0;
    L_0x0125:
        r7 = 1;
        return r7;
    L_0x0127:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.aa.a(com.xiaomi.xmpush.thrift.aa):boolean");
    }

    public int b(aa aaVar) {
        if (!getClass().equals(aaVar.getClass())) {
            return getClass().getName().compareTo(aaVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aaVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, aaVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aaVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, aaVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aaVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.c, aaVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(aaVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.d, aaVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aaVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.e, aaVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aaVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.f, aaVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(aaVar.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.b.a(this.g, aaVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(aaVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.h, aaVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(aaVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.b.a(this.i, aaVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(aaVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.b.a(this.j, aaVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(aaVar.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            int a = org.apache.thrift.b.a(this.k, aaVar.k);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        m();
        eVar.a(m);
        if (this.a != null && a()) {
            eVar.a(n);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(o);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(p);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && e()) {
            eVar.a(q);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && f()) {
            eVar.a(r);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && g()) {
            eVar.a(s);
            this.f.b(eVar);
            eVar.b();
        }
        eVar.a(t);
        eVar.a(this.g);
        eVar.b();
        if (this.h != null && i()) {
            eVar.a(u);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && j()) {
            eVar.a(v);
            eVar.a(new d((byte) 11, (byte) 11, this.i.size()));
            for (Entry entry : this.i.entrySet()) {
                eVar.a((String) entry.getKey());
                eVar.a((String) entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.j != null && k()) {
            eVar.a(w);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && l()) {
            eVar.a(x);
            eVar.a(this.k);
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
        return b((aa) obj);
    }

    public boolean d() {
        return this.c != null;
    }

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof aa)) ? a((aa) obj) : false;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public boolean h() {
        return this.y.get(0);
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

    public boolean k() {
        return this.j != null;
    }

    public boolean l() {
        return this.k != null;
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
        StringBuilder stringBuilder = new StringBuilder("XmPushActionAckNotification(");
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
        if (e()) {
            stringBuilder.append(", ");
            stringBuilder.append("appId:");
            stringBuilder.append(this.d == null ? "null" : this.d);
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("type:");
            stringBuilder.append(this.e == null ? "null" : this.e);
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("errorCode:");
        stringBuilder.append(this.g);
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            stringBuilder.append(this.h == null ? "null" : this.h);
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("extra:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.j == null ? "null" : this.j);
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            stringBuilder.append(this.k == null ? "null" : this.k);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
