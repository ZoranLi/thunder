package com.xiaomi.xmpush.thrift;

import com.igexin.assist.sdk.AssistPushConsts;
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
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.e;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class ai implements Serializable, Cloneable, org.apache.thrift.a<ai, a> {
    public static final Map<a, b> l;
    private static final j m = new j("XmPushActionNotification");
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("debug", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("target", (byte) 12, (short) 2);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("appId", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("type", (byte) 11, (short) 5);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("requireAck", (byte) 2, (short) 6);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b(AssistPushConsts.MSG_TYPE_PAYLOAD, (byte) 11, (short) 7);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("extra", (byte) 13, (short) 8);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 9);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("category", (byte) 11, (short) 10);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("binaryExtra", (byte) 11, (short) 14);
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public Map<String, String> h;
    public String i;
    public String j;
    public ByteBuffer k;
    private BitSet y;

    public enum a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, "target"),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, "appId"),
        TYPE((short) 5, "type"),
        REQUIRE_ACK((short) 6, "requireAck"),
        PAYLOAD((short) 7, AssistPushConsts.MSG_TYPE_PAYLOAD),
        EXTRA((short) 8, "extra"),
        PACKAGE_NAME((short) 9, Constants.KEY_PACKAGE_NAME),
        CATEGORY((short) 10, "category"),
        BINARY_EXTRA((short) 14, "binaryExtra");
        
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
        enumMap.put(a.DEBUG, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new b("target", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.ID, new b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new b("appId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TYPE, new b("type", (byte) 2, new c((byte) 11)));
        enumMap.put(a.REQUIRE_ACK, new b("requireAck", (byte) 1, new c((byte) 2)));
        enumMap.put(a.PAYLOAD, new b(AssistPushConsts.MSG_TYPE_PAYLOAD, (byte) 2, new c((byte) 11)));
        enumMap.put(a.EXTRA, new b("extra", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.PACKAGE_NAME, new b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new c((byte) 11)));
        enumMap.put(a.BINARY_EXTRA, new b("binaryExtra", (byte) 2, new c((byte) 11)));
        l = Collections.unmodifiableMap(enumMap);
        b.a(ai.class, l);
    }

    public ai() {
        this.y = new BitSet(1);
        this.f = true;
    }

    public ai(String str, boolean z) {
        this();
        this.c = str;
        this.f = z;
        b(true);
    }

    public ai a(String str) {
        this.c = str;
        return this;
    }

    public ai a(ByteBuffer byteBuffer) {
        this.k = byteBuffer;
        return this;
    }

    public ai a(Map<String, String> map) {
        this.h = map;
        return this;
    }

    public ai a(boolean z) {
        this.f = z;
        b(true);
        return this;
    }

    public ai a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public void a(String str, String str2) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        this.h.put(str, str2);
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
        if (r1 == 0) goto L_0x00cb;
    L_0x000b:
        r1 = r0.c;
        r2 = 14;
        r3 = 11;
        if (r1 == r2) goto L_0x00bc;
    L_0x0013:
        r2 = 2;
        switch(r1) {
            case 1: goto L_0x00b1;
            case 2: goto L_0x009e;
            case 3: goto L_0x0093;
            case 4: goto L_0x0088;
            case 5: goto L_0x007d;
            case 6: goto L_0x006e;
            case 7: goto L_0x0063;
            case 8: goto L_0x0036;
            case 9: goto L_0x002a;
            case 10: goto L_0x001e;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r6, r0);
        goto L_0x00c6;
    L_0x001e:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x0022:
        r0 = r6.w();
        r5.j = r0;
        goto L_0x00c6;
    L_0x002a:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x002e:
        r0 = r6.w();
        r5.i = r0;
        goto L_0x00c6;
    L_0x0036:
        r1 = r0.b;
        r3 = 13;
        if (r1 != r3) goto L_0x0017;
    L_0x003c:
        r0 = r6.k();
        r1 = new java.util.HashMap;
        r3 = r0.c;
        r2 = r2 * r3;
        r1.<init>(r2);
        r5.h = r1;
        r1 = 0;
    L_0x004b:
        r2 = r0.c;
        if (r1 >= r2) goto L_0x005f;
    L_0x004f:
        r2 = r6.w();
        r3 = r6.w();
        r4 = r5.h;
        r4.put(r2, r3);
        r1 = r1 + 1;
        goto L_0x004b;
    L_0x005f:
        r6.l();
        goto L_0x00c6;
    L_0x0063:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x0067:
        r0 = r6.w();
        r5.g = r0;
        goto L_0x00c6;
    L_0x006e:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0017;
    L_0x0072:
        r0 = r6.q();
        r5.f = r0;
        r0 = 1;
        r5.b(r0);
        goto L_0x00c6;
    L_0x007d:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x0081:
        r0 = r6.w();
        r5.e = r0;
        goto L_0x00c6;
    L_0x0088:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x008c:
        r0 = r6.w();
        r5.d = r0;
        goto L_0x00c6;
    L_0x0093:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x0097:
        r0 = r6.w();
        r5.c = r0;
        goto L_0x00c6;
    L_0x009e:
        r1 = r0.b;
        r2 = 12;
        if (r1 != r2) goto L_0x0017;
    L_0x00a4:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r5.b = r0;
        r0 = r5.b;
        r0.a(r6);
        goto L_0x00c6;
    L_0x00b1:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x00b5:
        r0 = r6.w();
        r5.a = r0;
        goto L_0x00c6;
    L_0x00bc:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x00c0:
        r0 = r6.x();
        r5.k = r0;
    L_0x00c6:
        r6.j();
        goto L_0x0003;
    L_0x00cb:
        r6.h();
        r6 = r5.g();
        if (r6 != 0) goto L_0x00ec;
    L_0x00d4:
        r6 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'requireAck' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r5.toString();
        r0.append(r1);
        r0 = r0.toString();
        r6.<init>(r0);
        throw r6;
    L_0x00ec:
        r5.o();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ai.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.ai r4) {
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
        if (r1 == 0) goto L_0x0125;
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
        if (r1 == 0) goto L_0x0125;
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
        r1 = r3.d();
        r2 = r4.d();
        if (r1 != 0) goto L_0x0048;
    L_0x0046:
        if (r2 == 0) goto L_0x0058;
    L_0x0048:
        if (r1 == 0) goto L_0x0125;
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
        r1 = r3.e();
        r2 = r4.e();
        if (r1 != 0) goto L_0x0064;
    L_0x0062:
        if (r2 == 0) goto L_0x0074;
    L_0x0064:
        if (r1 == 0) goto L_0x0125;
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
        r1 = r3.f();
        r2 = r4.f();
        if (r1 != 0) goto L_0x0080;
    L_0x007e:
        if (r2 == 0) goto L_0x0090;
    L_0x0080:
        if (r1 == 0) goto L_0x0125;
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
        r1 = r3.f;
        r2 = r4.f;
        if (r1 == r2) goto L_0x0097;
    L_0x0096:
        return r0;
    L_0x0097:
        r1 = r3.h();
        r2 = r4.h();
        if (r1 != 0) goto L_0x00a3;
    L_0x00a1:
        if (r2 == 0) goto L_0x00b3;
    L_0x00a3:
        if (r1 == 0) goto L_0x0125;
    L_0x00a5:
        if (r2 != 0) goto L_0x00a8;
    L_0x00a7:
        return r0;
    L_0x00a8:
        r1 = r3.g;
        r2 = r4.g;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00b3;
    L_0x00b2:
        return r0;
    L_0x00b3:
        r1 = r3.j();
        r2 = r4.j();
        if (r1 != 0) goto L_0x00bf;
    L_0x00bd:
        if (r2 == 0) goto L_0x00cf;
    L_0x00bf:
        if (r1 == 0) goto L_0x0125;
    L_0x00c1:
        if (r2 != 0) goto L_0x00c4;
    L_0x00c3:
        return r0;
    L_0x00c4:
        r1 = r3.h;
        r2 = r4.h;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00cf;
    L_0x00ce:
        return r0;
    L_0x00cf:
        r1 = r3.k();
        r2 = r4.k();
        if (r1 != 0) goto L_0x00db;
    L_0x00d9:
        if (r2 == 0) goto L_0x00eb;
    L_0x00db:
        if (r1 == 0) goto L_0x0125;
    L_0x00dd:
        if (r2 != 0) goto L_0x00e0;
    L_0x00df:
        return r0;
    L_0x00e0:
        r1 = r3.i;
        r2 = r4.i;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00eb;
    L_0x00ea:
        return r0;
    L_0x00eb:
        r1 = r3.l();
        r2 = r4.l();
        if (r1 != 0) goto L_0x00f7;
    L_0x00f5:
        if (r2 == 0) goto L_0x0107;
    L_0x00f7:
        if (r1 == 0) goto L_0x0125;
    L_0x00f9:
        if (r2 != 0) goto L_0x00fc;
    L_0x00fb:
        return r0;
    L_0x00fc:
        r1 = r3.j;
        r2 = r4.j;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0107;
    L_0x0106:
        return r0;
    L_0x0107:
        r1 = r3.n();
        r2 = r4.n();
        if (r1 != 0) goto L_0x0113;
    L_0x0111:
        if (r2 == 0) goto L_0x0123;
    L_0x0113:
        if (r1 == 0) goto L_0x0125;
    L_0x0115:
        if (r2 != 0) goto L_0x0118;
    L_0x0117:
        return r0;
    L_0x0118:
        r1 = r3.k;
        r4 = r4.k;
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x0123;
    L_0x0122:
        return r0;
    L_0x0123:
        r4 = 1;
        return r4;
    L_0x0125:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ai.a(com.xiaomi.xmpush.thrift.ai):boolean");
    }

    public int b(ai aiVar) {
        if (!getClass().equals(aiVar.getClass())) {
            return getClass().getName().compareTo(aiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aiVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, aiVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aiVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, aiVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aiVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.c, aiVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(aiVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.d, aiVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aiVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.e, aiVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aiVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.f, aiVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(aiVar.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.b.a(this.g, aiVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(aiVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.b.a(this.h, aiVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(aiVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.b.a(this.i, aiVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(aiVar.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            compareTo = org.apache.thrift.b.a(this.j, aiVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(aiVar.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            int a = org.apache.thrift.b.a(this.k, aiVar.k);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public ai b(String str) {
        this.d = str;
        return this;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        o();
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
        eVar.a(s);
        eVar.a(this.f);
        eVar.b();
        if (this.g != null && h()) {
            eVar.a(t);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && j()) {
            eVar.a(u);
            eVar.a(new d((byte) 11, (byte) 11, this.h.size()));
            for (Entry entry : this.h.entrySet()) {
                eVar.a((String) entry.getKey());
                eVar.a((String) entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.i != null && k()) {
            eVar.a(v);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
            eVar.a(w);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && n()) {
            eVar.a(x);
            eVar.a(this.k);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.y.set(0, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public ai c(String str) {
        this.e = str;
        return this;
    }

    public String c() {
        return this.c;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((ai) obj);
    }

    public ai d(String str) {
        this.i = str;
        return this;
    }

    public boolean d() {
        return this.c != null;
    }

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ai)) ? a((ai) obj) : false;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.y.get(0);
    }

    public boolean h() {
        return this.g != null;
    }

    public int hashCode() {
        return 0;
    }

    public Map<String, String> i() {
        return this.h;
    }

    public boolean j() {
        return this.h != null;
    }

    public boolean k() {
        return this.i != null;
    }

    public boolean l() {
        return this.j != null;
    }

    public byte[] m() {
        a(org.apache.thrift.b.c(this.k));
        return this.k.array();
    }

    public boolean n() {
        return this.k != null;
    }

    public void o() {
        if (this.c == null) {
            StringBuilder stringBuilder = new StringBuilder("Required field 'id' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionNotification(");
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
        stringBuilder.append(", ");
        stringBuilder.append("requireAck:");
        stringBuilder.append(this.f);
        if (h()) {
            stringBuilder.append(", ");
            stringBuilder.append("payload:");
            stringBuilder.append(this.g == null ? "null" : this.g);
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("extra:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.i == null ? "null" : this.i);
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            stringBuilder.append(this.j == null ? "null" : this.j);
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("binaryExtra:");
            if (this.k == null) {
                stringBuilder.append("null");
            } else {
                org.apache.thrift.b.a(this.k, stringBuilder);
            }
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
