package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.tencent.open.SocialConstants;
import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.e;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.b;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class z implements Serializable, Cloneable, a<z, a> {
    private static final b A = new b("messageTs", (byte) 10, (short) 5);
    private static final b B = new b("topic", (byte) 11, (short) 6);
    private static final b C = new b("aliasName", (byte) 11, (short) 7);
    private static final b D = new b(SocialConstants.TYPE_REQUEST, (byte) 12, (short) 8);
    private static final b E = new b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 9);
    private static final b F = new b("category", (byte) 11, (short) 10);
    private static final b G = new b("isOnline", (byte) 2, (short) 11);
    private static final b H = new b("regId", (byte) 11, (short) 12);
    private static final b I = new b("callbackUrl", (byte) 11, (short) 13);
    private static final b J = new b("userAccount", (byte) 11, (short) 14);
    private static final b K = new b("deviceStatus", (byte) 6, (short) 15);
    private static final b L = new b("geoMsgStatus", (byte) 6, (short) 16);
    private static final b M = new b("imeiMd5", (byte) 11, (short) 20);
    private static final b N = new b("deviceId", (byte) 11, (short) 21);
    private static final b O = new b("passThrough", (byte) 8, (short) 22);
    private static final b P = new b("extra", (byte) 13, (short) 23);
    public static final Map<a, org.apache.thrift.meta_data.b> u;
    private static final j v = new j("XmPushActionAckMessage");
    private static final b w = new b("debug", (byte) 11, (short) 1);
    private static final b x = new b("target", (byte) 12, (short) 2);
    private static final b y = new b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
    private static final b z = new b("appId", (byte) 11, (short) 4);
    private BitSet Q = new BitSet(5);
    public String a;
    public x b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public an h;
    public String i;
    public String j;
    public boolean k = false;
    public String l;
    public String m;
    public String n;
    public short o;
    public short p;
    public String q;
    public String r;
    public int s;
    public Map<String, String> t;

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.c, new org.apache.thrift.meta_data.b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.e, new org.apache.thrift.meta_data.b("messageTs", (byte) 1, new c((byte) 10)));
        enumMap.put(a.f, new org.apache.thrift.meta_data.b("topic", (byte) 2, new c((byte) 11)));
        enumMap.put(a.g, new org.apache.thrift.meta_data.b("aliasName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.h, new org.apache.thrift.meta_data.b(SocialConstants.TYPE_REQUEST, (byte) 2, new g((byte) 12, an.class)));
        enumMap.put(a.i, new org.apache.thrift.meta_data.b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        enumMap.put(a.j, new org.apache.thrift.meta_data.b("category", (byte) 2, new c((byte) 11)));
        enumMap.put(a.k, new org.apache.thrift.meta_data.b("isOnline", (byte) 2, new c((byte) 2)));
        enumMap.put(a.l, new org.apache.thrift.meta_data.b("regId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.m, new org.apache.thrift.meta_data.b("callbackUrl", (byte) 2, new c((byte) 11)));
        enumMap.put(a.n, new org.apache.thrift.meta_data.b("userAccount", (byte) 2, new c((byte) 11)));
        enumMap.put(a.o, new org.apache.thrift.meta_data.b("deviceStatus", (byte) 2, new c((byte) 6)));
        enumMap.put(a.p, new org.apache.thrift.meta_data.b("geoMsgStatus", (byte) 2, new c((byte) 6)));
        enumMap.put(a.q, new org.apache.thrift.meta_data.b("imeiMd5", (byte) 2, new c((byte) 11)));
        enumMap.put(a.r, new org.apache.thrift.meta_data.b("deviceId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.s, new org.apache.thrift.meta_data.b("passThrough", (byte) 2, new c((byte) 8)));
        enumMap.put(a.t, new org.apache.thrift.meta_data.b("extra", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        u = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(z.class, u);
    }

    public z a(long j) {
        this.e = j;
        a(true);
        return this;
    }

    public z a(String str) {
        this.c = str;
        return this;
    }

    public z a(short s) {
        this.o = s;
        c(true);
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r8) {
        /*
        r7 = this;
        r8.g();
    L_0x0003:
        r0 = r8.i();
        r1 = r0.b;
        if (r1 == 0) goto L_0x014b;
    L_0x000b:
        r1 = r0.c;
        r2 = 12;
        r3 = 6;
        r4 = 2;
        r5 = 1;
        r6 = 11;
        switch(r1) {
            case 1: goto L_0x013c;
            case 2: goto L_0x012b;
            case 3: goto L_0x0120;
            case 4: goto L_0x0115;
            case 5: goto L_0x0105;
            case 6: goto L_0x00fa;
            case 7: goto L_0x00ef;
            case 8: goto L_0x00de;
            case 9: goto L_0x00d2;
            case 10: goto L_0x00c6;
            case 11: goto L_0x00b7;
            case 12: goto L_0x00ab;
            case 13: goto L_0x009f;
            case 14: goto L_0x0093;
            case 15: goto L_0x0084;
            case 16: goto L_0x0075;
            case 17: goto L_0x0017;
            case 18: goto L_0x0017;
            case 19: goto L_0x0017;
            case 20: goto L_0x0069;
            case 21: goto L_0x005d;
            case 22: goto L_0x004c;
            case 23: goto L_0x001e;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r8, r0);
        goto L_0x0146;
    L_0x001e:
        r1 = r0.b;
        r2 = 13;
        if (r1 != r2) goto L_0x0017;
    L_0x0024:
        r0 = r8.k();
        r1 = new java.util.HashMap;
        r2 = r0.c;
        r4 = r4 * r2;
        r1.<init>(r4);
        r7.t = r1;
        r1 = 0;
    L_0x0033:
        r2 = r0.c;
        if (r1 >= r2) goto L_0x0047;
    L_0x0037:
        r2 = r8.w();
        r3 = r8.w();
        r4 = r7.t;
        r4.put(r2, r3);
        r1 = r1 + 1;
        goto L_0x0033;
    L_0x0047:
        r8.l();
        goto L_0x0146;
    L_0x004c:
        r1 = r0.b;
        r2 = 8;
        if (r1 != r2) goto L_0x0017;
    L_0x0052:
        r0 = r8.t();
        r7.s = r0;
        r7.e(r5);
        goto L_0x0146;
    L_0x005d:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x0061:
        r0 = r8.w();
        r7.r = r0;
        goto L_0x0146;
    L_0x0069:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x006d:
        r0 = r8.w();
        r7.q = r0;
        goto L_0x0146;
    L_0x0075:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x0079:
        r0 = r8.s();
        r7.p = r0;
        r7.d(r5);
        goto L_0x0146;
    L_0x0084:
        r1 = r0.b;
        if (r1 != r3) goto L_0x0017;
    L_0x0088:
        r0 = r8.s();
        r7.o = r0;
        r7.c(r5);
        goto L_0x0146;
    L_0x0093:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x0097:
        r0 = r8.w();
        r7.n = r0;
        goto L_0x0146;
    L_0x009f:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x00a3:
        r0 = r8.w();
        r7.m = r0;
        goto L_0x0146;
    L_0x00ab:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x00af:
        r0 = r8.w();
        r7.l = r0;
        goto L_0x0146;
    L_0x00b7:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0017;
    L_0x00bb:
        r0 = r8.q();
        r7.k = r0;
        r7.b(r5);
        goto L_0x0146;
    L_0x00c6:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x00ca:
        r0 = r8.w();
        r7.j = r0;
        goto L_0x0146;
    L_0x00d2:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x00d6:
        r0 = r8.w();
        r7.i = r0;
        goto L_0x0146;
    L_0x00de:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0017;
    L_0x00e2:
        r0 = new com.xiaomi.xmpush.thrift.an;
        r0.<init>();
        r7.h = r0;
        r0 = r7.h;
        r0.a(r8);
        goto L_0x0146;
    L_0x00ef:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x00f3:
        r0 = r8.w();
        r7.g = r0;
        goto L_0x0146;
    L_0x00fa:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x00fe:
        r0 = r8.w();
        r7.f = r0;
        goto L_0x0146;
    L_0x0105:
        r1 = r0.b;
        r2 = 10;
        if (r1 != r2) goto L_0x0017;
    L_0x010b:
        r0 = r8.u();
        r7.e = r0;
        r7.a(r5);
        goto L_0x0146;
    L_0x0115:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x0119:
        r0 = r8.w();
        r7.d = r0;
        goto L_0x0146;
    L_0x0120:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x0124:
        r0 = r8.w();
        r7.c = r0;
        goto L_0x0146;
    L_0x012b:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0017;
    L_0x012f:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r7.b = r0;
        r0 = r7.b;
        r0.a(r8);
        goto L_0x0146;
    L_0x013c:
        r1 = r0.b;
        if (r1 != r6) goto L_0x0017;
    L_0x0140:
        r0 = r8.w();
        r7.a = r0;
    L_0x0146:
        r8.j();
        goto L_0x0003;
    L_0x014b:
        r8.h();
        r8 = r7.e();
        if (r8 != 0) goto L_0x016c;
    L_0x0154:
        r8 = new org.apache.thrift.protocol.f;
        r0 = new java.lang.StringBuilder;
        r1 = "Required field 'messageTs' was not found in serialized data! Struct: ";
        r0.<init>(r1);
        r1 = r7.toString();
        r0.append(r1);
        r0 = r0.toString();
        r8.<init>(r0);
        throw r8;
    L_0x016c:
        r7.u();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.z.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.Q.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.z r7) {
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
        if (r1 == 0) goto L_0x0213;
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
        if (r1 == 0) goto L_0x0213;
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
        if (r1 == 0) goto L_0x0213;
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
        if (r1 == 0) goto L_0x0213;
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
        r1 = r6.e;
        r3 = r7.e;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x007d;
    L_0x007c:
        return r0;
    L_0x007d:
        r1 = r6.f();
        r2 = r7.f();
        if (r1 != 0) goto L_0x0089;
    L_0x0087:
        if (r2 == 0) goto L_0x0099;
    L_0x0089:
        if (r1 == 0) goto L_0x0213;
    L_0x008b:
        if (r2 != 0) goto L_0x008e;
    L_0x008d:
        return r0;
    L_0x008e:
        r1 = r6.f;
        r2 = r7.f;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0099;
    L_0x0098:
        return r0;
    L_0x0099:
        r1 = r6.g();
        r2 = r7.g();
        if (r1 != 0) goto L_0x00a5;
    L_0x00a3:
        if (r2 == 0) goto L_0x00b5;
    L_0x00a5:
        if (r1 == 0) goto L_0x0213;
    L_0x00a7:
        if (r2 != 0) goto L_0x00aa;
    L_0x00a9:
        return r0;
    L_0x00aa:
        r1 = r6.g;
        r2 = r7.g;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00b5;
    L_0x00b4:
        return r0;
    L_0x00b5:
        r1 = r6.h();
        r2 = r7.h();
        if (r1 != 0) goto L_0x00c1;
    L_0x00bf:
        if (r2 == 0) goto L_0x00d1;
    L_0x00c1:
        if (r1 == 0) goto L_0x0213;
    L_0x00c3:
        if (r2 != 0) goto L_0x00c6;
    L_0x00c5:
        return r0;
    L_0x00c6:
        r1 = r6.h;
        r2 = r7.h;
        r1 = r1.a(r2);
        if (r1 != 0) goto L_0x00d1;
    L_0x00d0:
        return r0;
    L_0x00d1:
        r1 = r6.i();
        r2 = r7.i();
        if (r1 != 0) goto L_0x00dd;
    L_0x00db:
        if (r2 == 0) goto L_0x00ed;
    L_0x00dd:
        if (r1 == 0) goto L_0x0213;
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
        r1 = r6.j();
        r2 = r7.j();
        if (r1 != 0) goto L_0x00f9;
    L_0x00f7:
        if (r2 == 0) goto L_0x0109;
    L_0x00f9:
        if (r1 == 0) goto L_0x0213;
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
        r1 = r6.k();
        r2 = r7.k();
        if (r1 != 0) goto L_0x0115;
    L_0x0113:
        if (r2 == 0) goto L_0x0121;
    L_0x0115:
        if (r1 == 0) goto L_0x0213;
    L_0x0117:
        if (r2 != 0) goto L_0x011a;
    L_0x0119:
        return r0;
    L_0x011a:
        r1 = r6.k;
        r2 = r7.k;
        if (r1 == r2) goto L_0x0121;
    L_0x0120:
        return r0;
    L_0x0121:
        r1 = r6.l();
        r2 = r7.l();
        if (r1 != 0) goto L_0x012d;
    L_0x012b:
        if (r2 == 0) goto L_0x013d;
    L_0x012d:
        if (r1 == 0) goto L_0x0213;
    L_0x012f:
        if (r2 != 0) goto L_0x0132;
    L_0x0131:
        return r0;
    L_0x0132:
        r1 = r6.l;
        r2 = r7.l;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x013d;
    L_0x013c:
        return r0;
    L_0x013d:
        r1 = r6.m();
        r2 = r7.m();
        if (r1 != 0) goto L_0x0149;
    L_0x0147:
        if (r2 == 0) goto L_0x0159;
    L_0x0149:
        if (r1 == 0) goto L_0x0213;
    L_0x014b:
        if (r2 != 0) goto L_0x014e;
    L_0x014d:
        return r0;
    L_0x014e:
        r1 = r6.m;
        r2 = r7.m;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0159;
    L_0x0158:
        return r0;
    L_0x0159:
        r1 = r6.n();
        r2 = r7.n();
        if (r1 != 0) goto L_0x0165;
    L_0x0163:
        if (r2 == 0) goto L_0x0175;
    L_0x0165:
        if (r1 == 0) goto L_0x0213;
    L_0x0167:
        if (r2 != 0) goto L_0x016a;
    L_0x0169:
        return r0;
    L_0x016a:
        r1 = r6.n;
        r2 = r7.n;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0175;
    L_0x0174:
        return r0;
    L_0x0175:
        r1 = r6.o();
        r2 = r7.o();
        if (r1 != 0) goto L_0x0181;
    L_0x017f:
        if (r2 == 0) goto L_0x018d;
    L_0x0181:
        if (r1 == 0) goto L_0x0213;
    L_0x0183:
        if (r2 != 0) goto L_0x0186;
    L_0x0185:
        return r0;
    L_0x0186:
        r1 = r6.o;
        r2 = r7.o;
        if (r1 == r2) goto L_0x018d;
    L_0x018c:
        return r0;
    L_0x018d:
        r1 = r6.p();
        r2 = r7.p();
        if (r1 != 0) goto L_0x0199;
    L_0x0197:
        if (r2 == 0) goto L_0x01a5;
    L_0x0199:
        if (r1 == 0) goto L_0x0213;
    L_0x019b:
        if (r2 != 0) goto L_0x019e;
    L_0x019d:
        return r0;
    L_0x019e:
        r1 = r6.p;
        r2 = r7.p;
        if (r1 == r2) goto L_0x01a5;
    L_0x01a4:
        return r0;
    L_0x01a5:
        r1 = r6.q();
        r2 = r7.q();
        if (r1 != 0) goto L_0x01b1;
    L_0x01af:
        if (r2 == 0) goto L_0x01c1;
    L_0x01b1:
        if (r1 == 0) goto L_0x0213;
    L_0x01b3:
        if (r2 != 0) goto L_0x01b6;
    L_0x01b5:
        return r0;
    L_0x01b6:
        r1 = r6.q;
        r2 = r7.q;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x01c1;
    L_0x01c0:
        return r0;
    L_0x01c1:
        r1 = r6.r();
        r2 = r7.r();
        if (r1 != 0) goto L_0x01cd;
    L_0x01cb:
        if (r2 == 0) goto L_0x01dd;
    L_0x01cd:
        if (r1 == 0) goto L_0x0213;
    L_0x01cf:
        if (r2 != 0) goto L_0x01d2;
    L_0x01d1:
        return r0;
    L_0x01d2:
        r1 = r6.r;
        r2 = r7.r;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x01dd;
    L_0x01dc:
        return r0;
    L_0x01dd:
        r1 = r6.s();
        r2 = r7.s();
        if (r1 != 0) goto L_0x01e9;
    L_0x01e7:
        if (r2 == 0) goto L_0x01f5;
    L_0x01e9:
        if (r1 == 0) goto L_0x0213;
    L_0x01eb:
        if (r2 != 0) goto L_0x01ee;
    L_0x01ed:
        return r0;
    L_0x01ee:
        r1 = r6.s;
        r2 = r7.s;
        if (r1 == r2) goto L_0x01f5;
    L_0x01f4:
        return r0;
    L_0x01f5:
        r1 = r6.t();
        r2 = r7.t();
        if (r1 != 0) goto L_0x0201;
    L_0x01ff:
        if (r2 == 0) goto L_0x0211;
    L_0x0201:
        if (r1 == 0) goto L_0x0213;
    L_0x0203:
        if (r2 != 0) goto L_0x0206;
    L_0x0205:
        return r0;
    L_0x0206:
        r1 = r6.t;
        r7 = r7.t;
        r7 = r1.equals(r7);
        if (r7 != 0) goto L_0x0211;
    L_0x0210:
        return r0;
    L_0x0211:
        r7 = 1;
        return r7;
    L_0x0213:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.z.a(com.xiaomi.xmpush.thrift.z):boolean");
    }

    public int b(z zVar) {
        if (!getClass().equals(zVar.getClass())) {
            return getClass().getName().compareTo(zVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(zVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, zVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(zVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, zVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(zVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.c, zVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(zVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.d, zVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(zVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.e, zVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(zVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.f, zVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(zVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.g, zVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(zVar.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.b.a(this.h, zVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(zVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.i, zVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(zVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.b.a(this.j, zVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(zVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.b.a(this.k, zVar.k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(zVar.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            compareTo = org.apache.thrift.b.a(this.l, zVar.l);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m()).compareTo(Boolean.valueOf(zVar.m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m()) {
            compareTo = org.apache.thrift.b.a(this.m, zVar.m);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(zVar.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            compareTo = org.apache.thrift.b.a(this.n, zVar.n);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(o()).compareTo(Boolean.valueOf(zVar.o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (o()) {
            compareTo = org.apache.thrift.b.a(this.o, zVar.o);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(p()).compareTo(Boolean.valueOf(zVar.p()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (p()) {
            compareTo = org.apache.thrift.b.a(this.p, zVar.p);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(q()).compareTo(Boolean.valueOf(zVar.q()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (q()) {
            compareTo = org.apache.thrift.b.a(this.q, zVar.q);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(r()).compareTo(Boolean.valueOf(zVar.r()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (r()) {
            compareTo = org.apache.thrift.b.a(this.r, zVar.r);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(s()).compareTo(Boolean.valueOf(zVar.s()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (s()) {
            compareTo = org.apache.thrift.b.a(this.s, zVar.s);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(t()).compareTo(Boolean.valueOf(zVar.t()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (t()) {
            int a = org.apache.thrift.b.a(this.t, zVar.t);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public z b(String str) {
        this.d = str;
        return this;
    }

    public z b(short s) {
        this.p = s;
        d(true);
        return this;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        u();
        eVar.a(v);
        if (this.a != null && a()) {
            eVar.a(w);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(x);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(y);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(z);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.a(A);
        eVar.a(this.e);
        eVar.b();
        if (this.f != null && f()) {
            eVar.a(B);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(C);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(D);
            this.h.b(eVar);
            eVar.b();
        }
        if (this.i != null && i()) {
            eVar.a(E);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && j()) {
            eVar.a(F);
            eVar.a(this.j);
            eVar.b();
        }
        if (k()) {
            eVar.a(G);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && l()) {
            eVar.a(H);
            eVar.a(this.l);
            eVar.b();
        }
        if (this.m != null && m()) {
            eVar.a(I);
            eVar.a(this.m);
            eVar.b();
        }
        if (this.n != null && n()) {
            eVar.a(J);
            eVar.a(this.n);
            eVar.b();
        }
        if (o()) {
            eVar.a(K);
            eVar.a(this.o);
            eVar.b();
        }
        if (p()) {
            eVar.a(L);
            eVar.a(this.p);
            eVar.b();
        }
        if (this.q != null && q()) {
            eVar.a(M);
            eVar.a(this.q);
            eVar.b();
        }
        if (this.r != null && r()) {
            eVar.a(N);
            eVar.a(this.r);
            eVar.b();
        }
        if (s()) {
            eVar.a(O);
            eVar.a(this.s);
            eVar.b();
        }
        if (this.t != null && t()) {
            eVar.a(P);
            eVar.a(new d((byte) 11, (byte) 11, this.t.size()));
            for (Entry entry : this.t.entrySet()) {
                eVar.a((String) entry.getKey());
                eVar.a((String) entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.Q.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public z c(String str) {
        this.f = str;
        return this;
    }

    public void c(boolean z) {
        this.Q.set(2, z);
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((z) obj);
    }

    public z d(String str) {
        this.g = str;
        return this;
    }

    public void d(boolean z) {
        this.Q.set(3, z);
    }

    public boolean d() {
        return this.d != null;
    }

    public void e(boolean z) {
        this.Q.set(4, z);
    }

    public boolean e() {
        return this.Q.get(0);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof z)) ? a((z) obj) : false;
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

    public boolean k() {
        return this.Q.get(1);
    }

    public boolean l() {
        return this.l != null;
    }

    public boolean m() {
        return this.m != null;
    }

    public boolean n() {
        return this.n != null;
    }

    public boolean o() {
        return this.Q.get(2);
    }

    public boolean p() {
        return this.Q.get(3);
    }

    public boolean q() {
        return this.q != null;
    }

    public boolean r() {
        return this.r != null;
    }

    public boolean s() {
        return this.Q.get(4);
    }

    public boolean t() {
        return this.t != null;
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionAckMessage(");
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
        stringBuilder.append("messageTs:");
        stringBuilder.append(this.e);
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            stringBuilder.append(this.f == null ? "null" : this.f);
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("aliasName:");
            stringBuilder.append(this.g == null ? "null" : this.g);
        }
        if (h()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.i == null ? "null" : this.i);
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            stringBuilder.append(this.j == null ? "null" : this.j);
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("isOnline:");
            stringBuilder.append(this.k);
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("regId:");
            stringBuilder.append(this.l == null ? "null" : this.l);
        }
        if (m()) {
            stringBuilder.append(", ");
            stringBuilder.append("callbackUrl:");
            stringBuilder.append(this.m == null ? "null" : this.m);
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("userAccount:");
            stringBuilder.append(this.n == null ? "null" : this.n);
        }
        if (o()) {
            stringBuilder.append(", ");
            stringBuilder.append("deviceStatus:");
            stringBuilder.append(this.o);
        }
        if (p()) {
            stringBuilder.append(", ");
            stringBuilder.append("geoMsgStatus:");
            stringBuilder.append(this.p);
        }
        if (q()) {
            stringBuilder.append(", ");
            stringBuilder.append("imeiMd5:");
            stringBuilder.append(this.q == null ? "null" : this.q);
        }
        if (r()) {
            stringBuilder.append(", ");
            stringBuilder.append("deviceId:");
            stringBuilder.append(this.r == null ? "null" : this.r);
        }
        if (s()) {
            stringBuilder.append(", ");
            stringBuilder.append("passThrough:");
            stringBuilder.append(this.s);
        }
        if (t()) {
            stringBuilder.append(", ");
            stringBuilder.append("extra:");
            if (this.t == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.t);
            }
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    public void u() {
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
}
