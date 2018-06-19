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
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.e;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class u implements Serializable, Cloneable, org.apache.thrift.a<u, a> {
    public static final Map<a, b> m;
    private static final j n = new j("PushMetaInfo");
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("messageTs", (byte) 10, (short) 2);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("topic", (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("title", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("description", (byte) 11, (short) 5);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("notifyType", (byte) 8, (short) 6);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("url", (byte) 11, (short) 7);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("passThrough", (byte) 8, (short) 8);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("notifyId", (byte) 8, (short) 9);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("extra", (byte) 13, (short) 10);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("internal", (byte) 13, (short) 11);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("ignoreRegInfo", (byte) 2, (short) 12);
    private BitSet A;
    public String a;
    public long b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public int h;
    public int i;
    public Map<String, String> j;
    public Map<String, String> k;
    public boolean l;

    public enum a {
        ID((short) 1, AgooConstants.MESSAGE_ID),
        MESSAGE_TS((short) 2, "messageTs"),
        TOPIC((short) 3, "topic"),
        TITLE((short) 4, "title"),
        DESCRIPTION((short) 5, "description"),
        NOTIFY_TYPE((short) 6, "notifyType"),
        URL((short) 7, "url"),
        PASS_THROUGH((short) 8, "passThrough"),
        NOTIFY_ID((short) 9, "notifyId"),
        EXTRA((short) 10, "extra"),
        INTERNAL((short) 11, "internal"),
        IGNORE_REG_INFO((short) 12, "ignoreRegInfo");
        
        private static final Map<String, a> m = null;
        private final short n;
        private final String o;

        static {
            m = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                m.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.n = s;
            this.o = str;
        }

        public final String a() {
            return this.o;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.ID, new b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.MESSAGE_TS, new b("messageTs", (byte) 1, new c((byte) 10)));
        enumMap.put(a.TOPIC, new b("topic", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TITLE, new b("title", (byte) 2, new c((byte) 11)));
        enumMap.put(a.DESCRIPTION, new b("description", (byte) 2, new c((byte) 11)));
        enumMap.put(a.NOTIFY_TYPE, new b("notifyType", (byte) 2, new c((byte) 8)));
        enumMap.put(a.URL, new b("url", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PASS_THROUGH, new b("passThrough", (byte) 2, new c((byte) 8)));
        enumMap.put(a.NOTIFY_ID, new b("notifyId", (byte) 2, new c((byte) 8)));
        enumMap.put(a.EXTRA, new b("extra", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.INTERNAL, new b("internal", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.IGNORE_REG_INFO, new b("ignoreRegInfo", (byte) 2, new c((byte) 2)));
        m = Collections.unmodifiableMap(enumMap);
        b.a(u.class, m);
    }

    public u() {
        this.A = new BitSet(5);
        this.l = false;
    }

    public u(u uVar) {
        Map hashMap;
        this.A = new BitSet(5);
        this.A.clear();
        this.A.or(uVar.A);
        if (uVar.c()) {
            this.a = uVar.a;
        }
        this.b = uVar.b;
        if (uVar.g()) {
            this.c = uVar.c;
        }
        if (uVar.i()) {
            this.d = uVar.d;
        }
        if (uVar.k()) {
            this.e = uVar.e;
        }
        this.f = uVar.f;
        if (uVar.n()) {
            this.g = uVar.g;
        }
        this.h = uVar.h;
        this.i = uVar.i;
        if (uVar.t()) {
            hashMap = new HashMap();
            for (Entry entry : uVar.j.entrySet()) {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
            this.j = hashMap;
        }
        if (uVar.v()) {
            hashMap = new HashMap();
            for (Entry entry2 : uVar.k.entrySet()) {
                hashMap.put((String) entry2.getKey(), (String) entry2.getValue());
            }
            this.k = hashMap;
        }
        this.l = uVar.l;
    }

    public u a() {
        return new u(this);
    }

    public u a(int i) {
        this.f = i;
        b(true);
        return this;
    }

    public u a(String str) {
        this.a = str;
        return this;
    }

    public u a(Map<String, String> map) {
        this.j = map;
        return this;
    }

    public void a(String str, String str2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        this.j.put(str, str2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r9) {
        /*
        r8 = this;
        r9.g();
    L_0x0003:
        r0 = r9.i();
        r1 = r0.b;
        if (r1 == 0) goto L_0x00f5;
    L_0x000b:
        r1 = r0.c;
        r2 = 0;
        r3 = 13;
        r4 = 8;
        r5 = 2;
        r6 = 11;
        r7 = 1;
        switch(r1) {
            case 1: goto L_0x00e6;
            case 2: goto L_0x00d6;
            case 3: goto L_0x00cb;
            case 4: goto L_0x00c0;
            case 5: goto L_0x00b5;
            case 6: goto L_0x00a7;
            case 7: goto L_0x009c;
            case 8: goto L_0x008e;
            case 9: goto L_0x0080;
            case 10: goto L_0x0055;
            case 11: goto L_0x002f;
            case 12: goto L_0x0020;
            default: goto L_0x0019;
        };
    L_0x0019:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r9, r0);
        goto L_0x00f0;
    L_0x0020:
        r1 = r0.b;
        if (r1 != r5) goto L_0x0019;
    L_0x0024:
        r0 = r9.q();
        r8.l = r0;
        r8.e(r7);
        goto L_0x00f0;
    L_0x002f:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0019;
    L_0x0033:
        r0 = r9.k();
        r1 = new java.util.HashMap;
        r3 = r0.c;
        r5 = r5 * r3;
        r1.<init>(r5);
        r8.k = r1;
    L_0x0041:
        r1 = r0.c;
        if (r2 >= r1) goto L_0x007b;
    L_0x0045:
        r1 = r9.w();
        r3 = r9.w();
        r4 = r8.k;
        r4.put(r1, r3);
        r2 = r2 + 1;
        goto L_0x0041;
    L_0x0055:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0019;
    L_0x0059:
        r0 = r9.k();
        r1 = new java.util.HashMap;
        r3 = r0.c;
        r5 = r5 * r3;
        r1.<init>(r5);
        r8.j = r1;
    L_0x0067:
        r1 = r0.c;
        if (r2 >= r1) goto L_0x007b;
    L_0x006b:
        r1 = r9.w();
        r3 = r9.w();
        r4 = r8.j;
        r4.put(r1, r3);
        r2 = r2 + 1;
        goto L_0x0067;
    L_0x007b:
        r9.l();
        goto L_0x00f0;
    L_0x0080:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x0084:
        r0 = r9.t();
        r8.i = r0;
        r8.d(r7);
        goto L_0x00f0;
    L_0x008e:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x0092:
        r0 = r9.t();
        r8.h = r0;
        r8.c(r7);
        goto L_0x00f0;
    L_0x009c:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0019;
    L_0x00a0:
        r0 = r9.w();
        r8.g = r0;
        goto L_0x00f0;
    L_0x00a7:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x00ab:
        r0 = r9.t();
        r8.f = r0;
        r8.b(r7);
        goto L_0x00f0;
    L_0x00b5:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0019;
    L_0x00b9:
        r0 = r9.w();
        r8.e = r0;
        goto L_0x00f0;
    L_0x00c0:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0019;
    L_0x00c4:
        r0 = r9.w();
        r8.d = r0;
        goto L_0x00f0;
    L_0x00cb:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0019;
    L_0x00cf:
        r0 = r9.w();
        r8.c = r0;
        goto L_0x00f0;
    L_0x00d6:
        r1 = r0.b;
        r2 = 10;
        if (r1 != r2) goto L_0x0019;
    L_0x00dc:
        r0 = r9.u();
        r8.b = r0;
        r8.a(r7);
        goto L_0x00f0;
    L_0x00e6:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0019;
    L_0x00ea:
        r0 = r9.w();
        r8.a = r0;
    L_0x00f0:
        r9.j();
        goto L_0x0003;
    L_0x00f5:
        r9.h();
        r9 = r8.e();
        if (r9 != 0) goto L_0x0116;
    L_0x00fe:
        r9 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'messageTs' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r8.toString();
        r0.append(r1);
        r0 = r0.toString();
        r9.<init>(r0);
        throw r9;
    L_0x0116:
        r8.y();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.u.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.A.set(0, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.u r7) {
        /*
        r6 = this;
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r6.c();
        r2 = r7.c();
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        if (r2 == 0) goto L_0x0020;
    L_0x0010:
        if (r1 == 0) goto L_0x0133;
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
        r1 = r6.b;
        r3 = r7.b;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x0029;
    L_0x0028:
        return r0;
    L_0x0029:
        r1 = r6.g();
        r2 = r7.g();
        if (r1 != 0) goto L_0x0035;
    L_0x0033:
        if (r2 == 0) goto L_0x0045;
    L_0x0035:
        if (r1 == 0) goto L_0x0133;
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
        r1 = r6.i();
        r2 = r7.i();
        if (r1 != 0) goto L_0x0051;
    L_0x004f:
        if (r2 == 0) goto L_0x0061;
    L_0x0051:
        if (r1 == 0) goto L_0x0133;
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
        r1 = r6.k();
        r2 = r7.k();
        if (r1 != 0) goto L_0x006d;
    L_0x006b:
        if (r2 == 0) goto L_0x007d;
    L_0x006d:
        if (r1 == 0) goto L_0x0133;
    L_0x006f:
        if (r2 != 0) goto L_0x0072;
    L_0x0071:
        return r0;
    L_0x0072:
        r1 = r6.e;
        r2 = r7.e;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x007d;
    L_0x007c:
        return r0;
    L_0x007d:
        r1 = r6.m();
        r2 = r7.m();
        if (r1 != 0) goto L_0x0089;
    L_0x0087:
        if (r2 == 0) goto L_0x0095;
    L_0x0089:
        if (r1 == 0) goto L_0x0133;
    L_0x008b:
        if (r2 != 0) goto L_0x008e;
    L_0x008d:
        return r0;
    L_0x008e:
        r1 = r6.f;
        r2 = r7.f;
        if (r1 == r2) goto L_0x0095;
    L_0x0094:
        return r0;
    L_0x0095:
        r1 = r6.n();
        r2 = r7.n();
        if (r1 != 0) goto L_0x00a1;
    L_0x009f:
        if (r2 == 0) goto L_0x00b1;
    L_0x00a1:
        if (r1 == 0) goto L_0x0133;
    L_0x00a3:
        if (r2 != 0) goto L_0x00a6;
    L_0x00a5:
        return r0;
    L_0x00a6:
        r1 = r6.g;
        r2 = r7.g;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00b1;
    L_0x00b0:
        return r0;
    L_0x00b1:
        r1 = r6.p();
        r2 = r7.p();
        if (r1 != 0) goto L_0x00bd;
    L_0x00bb:
        if (r2 == 0) goto L_0x00c9;
    L_0x00bd:
        if (r1 == 0) goto L_0x0133;
    L_0x00bf:
        if (r2 != 0) goto L_0x00c2;
    L_0x00c1:
        return r0;
    L_0x00c2:
        r1 = r6.h;
        r2 = r7.h;
        if (r1 == r2) goto L_0x00c9;
    L_0x00c8:
        return r0;
    L_0x00c9:
        r1 = r6.r();
        r2 = r7.r();
        if (r1 != 0) goto L_0x00d5;
    L_0x00d3:
        if (r2 == 0) goto L_0x00e1;
    L_0x00d5:
        if (r1 == 0) goto L_0x0133;
    L_0x00d7:
        if (r2 != 0) goto L_0x00da;
    L_0x00d9:
        return r0;
    L_0x00da:
        r1 = r6.i;
        r2 = r7.i;
        if (r1 == r2) goto L_0x00e1;
    L_0x00e0:
        return r0;
    L_0x00e1:
        r1 = r6.t();
        r2 = r7.t();
        if (r1 != 0) goto L_0x00ed;
    L_0x00eb:
        if (r2 == 0) goto L_0x00fd;
    L_0x00ed:
        if (r1 == 0) goto L_0x0133;
    L_0x00ef:
        if (r2 != 0) goto L_0x00f2;
    L_0x00f1:
        return r0;
    L_0x00f2:
        r1 = r6.j;
        r2 = r7.j;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00fd;
    L_0x00fc:
        return r0;
    L_0x00fd:
        r1 = r6.v();
        r2 = r7.v();
        if (r1 != 0) goto L_0x0109;
    L_0x0107:
        if (r2 == 0) goto L_0x0119;
    L_0x0109:
        if (r1 == 0) goto L_0x0133;
    L_0x010b:
        if (r2 != 0) goto L_0x010e;
    L_0x010d:
        return r0;
    L_0x010e:
        r1 = r6.k;
        r2 = r7.k;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0119;
    L_0x0118:
        return r0;
    L_0x0119:
        r1 = r6.x();
        r2 = r7.x();
        if (r1 != 0) goto L_0x0125;
    L_0x0123:
        if (r2 == 0) goto L_0x0131;
    L_0x0125:
        if (r1 == 0) goto L_0x0133;
    L_0x0127:
        if (r2 != 0) goto L_0x012a;
    L_0x0129:
        return r0;
    L_0x012a:
        r1 = r6.l;
        r7 = r7.l;
        if (r1 == r7) goto L_0x0131;
    L_0x0130:
        return r0;
    L_0x0131:
        r7 = 1;
        return r7;
    L_0x0133:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.u.a(com.xiaomi.xmpush.thrift.u):boolean");
    }

    public int b(u uVar) {
        if (!getClass().equals(uVar.getClass())) {
            return getClass().getName().compareTo(uVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(uVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.a, uVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(uVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.b, uVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(uVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.c, uVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(uVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.d, uVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(uVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.b.a(this.e, uVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m()).compareTo(Boolean.valueOf(uVar.m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m()) {
            compareTo = org.apache.thrift.b.a(this.f, uVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(uVar.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            compareTo = org.apache.thrift.b.a(this.g, uVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(p()).compareTo(Boolean.valueOf(uVar.p()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (p()) {
            compareTo = org.apache.thrift.b.a(this.h, uVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(r()).compareTo(Boolean.valueOf(uVar.r()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (r()) {
            compareTo = org.apache.thrift.b.a(this.i, uVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(t()).compareTo(Boolean.valueOf(uVar.t()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (t()) {
            compareTo = org.apache.thrift.b.a(this.j, uVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(v()).compareTo(Boolean.valueOf(uVar.v()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (v()) {
            compareTo = org.apache.thrift.b.a(this.k, uVar.k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(x()).compareTo(Boolean.valueOf(uVar.x()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (x()) {
            int a = org.apache.thrift.b.a(this.l, uVar.l);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public u b(int i) {
        this.h = i;
        c(true);
        return this;
    }

    public u b(String str) {
        this.c = str;
        return this;
    }

    public String b() {
        return this.a;
    }

    public void b(String str, String str2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        this.k.put(str, str2);
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        y();
        eVar.a(n);
        if (this.a != null) {
            eVar.a(o);
            eVar.a(this.a);
            eVar.b();
        }
        eVar.a(p);
        eVar.a(this.b);
        eVar.b();
        if (this.c != null && g()) {
            eVar.a(q);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && i()) {
            eVar.a(r);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && k()) {
            eVar.a(s);
            eVar.a(this.e);
            eVar.b();
        }
        if (m()) {
            eVar.a(t);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && n()) {
            eVar.a(u);
            eVar.a(this.g);
            eVar.b();
        }
        if (p()) {
            eVar.a(v);
            eVar.a(this.h);
            eVar.b();
        }
        if (r()) {
            eVar.a(w);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && t()) {
            eVar.a(x);
            eVar.a(new d((byte) 11, (byte) 11, this.j.size()));
            for (Entry entry : this.j.entrySet()) {
                eVar.a((String) entry.getKey());
                eVar.a((String) entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.k != null && v()) {
            eVar.a(y);
            eVar.a(new d((byte) 11, (byte) 11, this.k.size()));
            for (Entry entry2 : this.k.entrySet()) {
                eVar.a((String) entry2.getKey());
                eVar.a((String) entry2.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (x()) {
            eVar.a(z);
            eVar.a(this.l);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.A.set(1, z);
    }

    public u c(int i) {
        this.i = i;
        d(true);
        return this;
    }

    public u c(String str) {
        this.d = str;
        return this;
    }

    public void c(boolean z) {
        this.A.set(2, z);
    }

    public boolean c() {
        return this.a != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((u) obj);
    }

    public long d() {
        return this.b;
    }

    public u d(String str) {
        this.e = str;
        return this;
    }

    public void d(boolean z) {
        this.A.set(3, z);
    }

    public void e(boolean z) {
        this.A.set(4, z);
    }

    public boolean e() {
        return this.A.get(0);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof u)) ? a((u) obj) : false;
    }

    public String f() {
        return this.c;
    }

    public boolean g() {
        return this.c != null;
    }

    public String h() {
        return this.d;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.d != null;
    }

    public String j() {
        return this.e;
    }

    public boolean k() {
        return this.e != null;
    }

    public int l() {
        return this.f;
    }

    public boolean m() {
        return this.A.get(1);
    }

    public boolean n() {
        return this.g != null;
    }

    public int o() {
        return this.h;
    }

    public boolean p() {
        return this.A.get(2);
    }

    public int q() {
        return this.i;
    }

    public boolean r() {
        return this.A.get(3);
    }

    public Map<String, String> s() {
        return this.j;
    }

    public boolean t() {
        return this.j != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PushMetaInfo(");
        stringBuilder.append("id:");
        stringBuilder.append(this.a == null ? "null" : this.a);
        stringBuilder.append(", ");
        stringBuilder.append("messageTs:");
        stringBuilder.append(this.b);
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            stringBuilder.append(this.c == null ? "null" : this.c);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("title:");
            stringBuilder.append(this.d == null ? "null" : this.d);
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("description:");
            stringBuilder.append(this.e == null ? "null" : this.e);
        }
        if (m()) {
            stringBuilder.append(", ");
            stringBuilder.append("notifyType:");
            stringBuilder.append(this.f);
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("url:");
            stringBuilder.append(this.g == null ? "null" : this.g);
        }
        if (p()) {
            stringBuilder.append(", ");
            stringBuilder.append("passThrough:");
            stringBuilder.append(this.h);
        }
        if (r()) {
            stringBuilder.append(", ");
            stringBuilder.append("notifyId:");
            stringBuilder.append(this.i);
        }
        if (t()) {
            stringBuilder.append(", ");
            stringBuilder.append("extra:");
            if (this.j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.j);
            }
        }
        if (v()) {
            stringBuilder.append(", ");
            stringBuilder.append("internal:");
            if (this.k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.k);
            }
        }
        if (x()) {
            stringBuilder.append(", ");
            stringBuilder.append("ignoreRegInfo:");
            stringBuilder.append(this.l);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    public Map<String, String> u() {
        return this.k;
    }

    public boolean v() {
        return this.k != null;
    }

    public boolean w() {
        return this.l;
    }

    public boolean x() {
        return this.A.get(4);
    }

    public void y() {
        if (this.a == null) {
            StringBuilder stringBuilder = new StringBuilder("Required field 'id' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }
}
