package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
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
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.e;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.b;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class aj implements Serializable, Cloneable, a<aj, a> {
    private static final b A = new b("target", (byte) 12, (short) 2);
    private static final b B = new b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
    private static final b C = new b("appId", (byte) 11, (short) 4);
    private static final b D = new b("appVersion", (byte) 11, (short) 5);
    private static final b E = new b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 6);
    private static final b F = new b("token", (byte) 11, (short) 7);
    private static final b G = new b("deviceId", (byte) 11, (short) 8);
    private static final b H = new b("aliasName", (byte) 11, (short) 9);
    private static final b I = new b(Constants.KEY_SDK_VERSION, (byte) 11, (short) 10);
    private static final b J = new b("regId", (byte) 11, (short) 11);
    private static final b K = new b("pushSdkVersionName", (byte) 11, (short) 12);
    private static final b L = new b("pushSdkVersionCode", (byte) 8, (short) 13);
    private static final b M = new b(Constants.KEY_APP_VERSION_CODE, (byte) 8, (short) 14);
    private static final b N = new b("androidId", (byte) 11, (short) 15);
    private static final b O = new b("imei", (byte) 11, (short) 16);
    private static final b P = new b("serial", (byte) 11, (short) 17);
    private static final b Q = new b("imeiMd5", (byte) 11, (short) 18);
    private static final b R = new b("spaceId", (byte) 8, (short) 19);
    private static final b S = new b(DownloadManager.COLUMN_REASON, (byte) 8, (short) 20);
    private static final b T = new b("connectionAttrs", (byte) 13, (short) 100);
    private static final b U = new b("cleanOldRegInfo", (byte) 2, (short) 101);
    private static final b V = new b("oldRegId", (byte) 11, (short) 102);
    public static final Map<a, org.apache.thrift.meta_data.b> x;
    private static final j y = new j("XmPushActionRegistration");
    private static final b z = new b("debug", (byte) 11, (short) 1);
    private BitSet W = new BitSet(4);
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
    public String k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String p;
    public String q;
    public String r;
    public int s;
    public w t;
    public Map<String, String> u;
    public boolean v = false;
    public String w;

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.c, new org.apache.thrift.meta_data.b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.e, new org.apache.thrift.meta_data.b("appVersion", (byte) 2, new c((byte) 11)));
        enumMap.put(a.f, new org.apache.thrift.meta_data.b(Constants.KEY_PACKAGE_NAME, (byte) 2, new c((byte) 11)));
        enumMap.put(a.g, new org.apache.thrift.meta_data.b("token", (byte) 1, new c((byte) 11)));
        enumMap.put(a.h, new org.apache.thrift.meta_data.b("deviceId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.i, new org.apache.thrift.meta_data.b("aliasName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.j, new org.apache.thrift.meta_data.b(Constants.KEY_SDK_VERSION, (byte) 2, new c((byte) 11)));
        enumMap.put(a.k, new org.apache.thrift.meta_data.b("regId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.l, new org.apache.thrift.meta_data.b("pushSdkVersionName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.m, new org.apache.thrift.meta_data.b("pushSdkVersionCode", (byte) 2, new c((byte) 8)));
        enumMap.put(a.n, new org.apache.thrift.meta_data.b(Constants.KEY_APP_VERSION_CODE, (byte) 2, new c((byte) 8)));
        enumMap.put(a.o, new org.apache.thrift.meta_data.b("androidId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.p, new org.apache.thrift.meta_data.b("imei", (byte) 2, new c((byte) 11)));
        enumMap.put(a.q, new org.apache.thrift.meta_data.b("serial", (byte) 2, new c((byte) 11)));
        enumMap.put(a.r, new org.apache.thrift.meta_data.b("imeiMd5", (byte) 2, new c((byte) 11)));
        enumMap.put(a.s, new org.apache.thrift.meta_data.b("spaceId", (byte) 2, new c((byte) 8)));
        enumMap.put(a.t, new org.apache.thrift.meta_data.b(DownloadManager.COLUMN_REASON, (byte) 2, new org.apache.thrift.meta_data.a((byte) 16, w.class)));
        enumMap.put(a.u, new org.apache.thrift.meta_data.b("connectionAttrs", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.v, new org.apache.thrift.meta_data.b("cleanOldRegInfo", (byte) 2, new c((byte) 2)));
        enumMap.put(a.w, new org.apache.thrift.meta_data.b("oldRegId", (byte) 2, new c((byte) 11)));
        x = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(aj.class, x);
    }

    public aj a(int i) {
        this.m = i;
        a(true);
        return this;
    }

    public aj a(w wVar) {
        this.t = wVar;
        return this;
    }

    public aj a(String str) {
        this.c = str;
        return this;
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
        if (r1 == 0) goto L_0x0169;
    L_0x000b:
        r1 = r0.c;
        r2 = 8;
        r3 = 1;
        r4 = 11;
        switch(r1) {
            case 1: goto L_0x015a;
            case 2: goto L_0x0147;
            case 3: goto L_0x013c;
            case 4: goto L_0x0131;
            case 5: goto L_0x0126;
            case 6: goto L_0x011b;
            case 7: goto L_0x0110;
            case 8: goto L_0x0105;
            case 9: goto L_0x00fa;
            case 10: goto L_0x00ee;
            case 11: goto L_0x00e2;
            case 12: goto L_0x00d6;
            case 13: goto L_0x00c7;
            case 14: goto L_0x00b8;
            case 15: goto L_0x00ac;
            case 16: goto L_0x00a0;
            case 17: goto L_0x0094;
            case 18: goto L_0x0088;
            case 19: goto L_0x0079;
            case 20: goto L_0x0069;
            default: goto L_0x0015;
        };
    L_0x0015:
        r2 = 2;
        switch(r1) {
            case 100: goto L_0x003b;
            case 101: goto L_0x002c;
            case 102: goto L_0x0020;
            default: goto L_0x0019;
        };
    L_0x0019:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r6, r0);
        goto L_0x0164;
    L_0x0020:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x0024:
        r0 = r6.w();
        r5.w = r0;
        goto L_0x0164;
    L_0x002c:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0019;
    L_0x0030:
        r0 = r6.q();
        r5.v = r0;
        r5.d(r3);
        goto L_0x0164;
    L_0x003b:
        r1 = r0.b;
        r3 = 13;
        if (r1 != r3) goto L_0x0019;
    L_0x0041:
        r0 = r6.k();
        r1 = new java.util.HashMap;
        r3 = r0.c;
        r2 = r2 * r3;
        r1.<init>(r2);
        r5.u = r1;
        r1 = 0;
    L_0x0050:
        r2 = r0.c;
        if (r1 >= r2) goto L_0x0064;
    L_0x0054:
        r2 = r6.w();
        r3 = r6.w();
        r4 = r5.u;
        r4.put(r2, r3);
        r1 = r1 + 1;
        goto L_0x0050;
    L_0x0064:
        r6.l();
        goto L_0x0164;
    L_0x0069:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0019;
    L_0x006d:
        r0 = r6.t();
        r0 = com.xiaomi.xmpush.thrift.w.a(r0);
        r5.t = r0;
        goto L_0x0164;
    L_0x0079:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0019;
    L_0x007d:
        r0 = r6.t();
        r5.s = r0;
        r5.c(r3);
        goto L_0x0164;
    L_0x0088:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x008c:
        r0 = r6.w();
        r5.r = r0;
        goto L_0x0164;
    L_0x0094:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x0098:
        r0 = r6.w();
        r5.q = r0;
        goto L_0x0164;
    L_0x00a0:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x00a4:
        r0 = r6.w();
        r5.p = r0;
        goto L_0x0164;
    L_0x00ac:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x00b0:
        r0 = r6.w();
        r5.o = r0;
        goto L_0x0164;
    L_0x00b8:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0019;
    L_0x00bc:
        r0 = r6.t();
        r5.n = r0;
        r5.b(r3);
        goto L_0x0164;
    L_0x00c7:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0019;
    L_0x00cb:
        r0 = r6.t();
        r5.m = r0;
        r5.a(r3);
        goto L_0x0164;
    L_0x00d6:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x00da:
        r0 = r6.w();
        r5.l = r0;
        goto L_0x0164;
    L_0x00e2:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x00e6:
        r0 = r6.w();
        r5.k = r0;
        goto L_0x0164;
    L_0x00ee:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x00f2:
        r0 = r6.w();
        r5.j = r0;
        goto L_0x0164;
    L_0x00fa:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x00fe:
        r0 = r6.w();
        r5.i = r0;
        goto L_0x0164;
    L_0x0105:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x0109:
        r0 = r6.w();
        r5.h = r0;
        goto L_0x0164;
    L_0x0110:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x0114:
        r0 = r6.w();
        r5.g = r0;
        goto L_0x0164;
    L_0x011b:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x011f:
        r0 = r6.w();
        r5.f = r0;
        goto L_0x0164;
    L_0x0126:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x012a:
        r0 = r6.w();
        r5.e = r0;
        goto L_0x0164;
    L_0x0131:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x0135:
        r0 = r6.w();
        r5.d = r0;
        goto L_0x0164;
    L_0x013c:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x0140:
        r0 = r6.w();
        r5.c = r0;
        goto L_0x0164;
    L_0x0147:
        r1 = r0.b;
        r2 = 12;
        if (r1 != r2) goto L_0x0019;
    L_0x014d:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r5.b = r0;
        r0 = r5.b;
        r0.a(r6);
        goto L_0x0164;
    L_0x015a:
        r1 = r0.b;
        if (r1 != r4) goto L_0x0019;
    L_0x015e:
        r0 = r6.w();
        r5.a = r0;
    L_0x0164:
        r6.j();
        goto L_0x0003;
    L_0x0169:
        r6.h();
        r5.z();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.aj.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.W.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.aj r4) {
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
        if (r1 == 0) goto L_0x027a;
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
        if (r1 == 0) goto L_0x027a;
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
        if (r1 == 0) goto L_0x027a;
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
        if (r1 == 0) goto L_0x027a;
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
        if (r1 == 0) goto L_0x027a;
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
        r1 = r3.g();
        r2 = r4.g();
        if (r1 != 0) goto L_0x009c;
    L_0x009a:
        if (r2 == 0) goto L_0x00ac;
    L_0x009c:
        if (r1 == 0) goto L_0x027a;
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
        r1 = r3.i();
        r2 = r4.i();
        if (r1 != 0) goto L_0x00b8;
    L_0x00b6:
        if (r2 == 0) goto L_0x00c8;
    L_0x00b8:
        if (r1 == 0) goto L_0x027a;
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
        r1 = r3.j();
        r2 = r4.j();
        if (r1 != 0) goto L_0x00d4;
    L_0x00d2:
        if (r2 == 0) goto L_0x00e4;
    L_0x00d4:
        if (r1 == 0) goto L_0x027a;
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
        r1 = r3.k();
        r2 = r4.k();
        if (r1 != 0) goto L_0x00f0;
    L_0x00ee:
        if (r2 == 0) goto L_0x0100;
    L_0x00f0:
        if (r1 == 0) goto L_0x027a;
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
        r1 = r3.l();
        r2 = r4.l();
        if (r1 != 0) goto L_0x010c;
    L_0x010a:
        if (r2 == 0) goto L_0x011c;
    L_0x010c:
        if (r1 == 0) goto L_0x027a;
    L_0x010e:
        if (r2 != 0) goto L_0x0111;
    L_0x0110:
        return r0;
    L_0x0111:
        r1 = r3.j;
        r2 = r4.j;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x011c;
    L_0x011b:
        return r0;
    L_0x011c:
        r1 = r3.m();
        r2 = r4.m();
        if (r1 != 0) goto L_0x0128;
    L_0x0126:
        if (r2 == 0) goto L_0x0138;
    L_0x0128:
        if (r1 == 0) goto L_0x027a;
    L_0x012a:
        if (r2 != 0) goto L_0x012d;
    L_0x012c:
        return r0;
    L_0x012d:
        r1 = r3.k;
        r2 = r4.k;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0138;
    L_0x0137:
        return r0;
    L_0x0138:
        r1 = r3.n();
        r2 = r4.n();
        if (r1 != 0) goto L_0x0144;
    L_0x0142:
        if (r2 == 0) goto L_0x0154;
    L_0x0144:
        if (r1 == 0) goto L_0x027a;
    L_0x0146:
        if (r2 != 0) goto L_0x0149;
    L_0x0148:
        return r0;
    L_0x0149:
        r1 = r3.l;
        r2 = r4.l;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0154;
    L_0x0153:
        return r0;
    L_0x0154:
        r1 = r3.o();
        r2 = r4.o();
        if (r1 != 0) goto L_0x0160;
    L_0x015e:
        if (r2 == 0) goto L_0x016c;
    L_0x0160:
        if (r1 == 0) goto L_0x027a;
    L_0x0162:
        if (r2 != 0) goto L_0x0165;
    L_0x0164:
        return r0;
    L_0x0165:
        r1 = r3.m;
        r2 = r4.m;
        if (r1 == r2) goto L_0x016c;
    L_0x016b:
        return r0;
    L_0x016c:
        r1 = r3.p();
        r2 = r4.p();
        if (r1 != 0) goto L_0x0178;
    L_0x0176:
        if (r2 == 0) goto L_0x0184;
    L_0x0178:
        if (r1 == 0) goto L_0x027a;
    L_0x017a:
        if (r2 != 0) goto L_0x017d;
    L_0x017c:
        return r0;
    L_0x017d:
        r1 = r3.n;
        r2 = r4.n;
        if (r1 == r2) goto L_0x0184;
    L_0x0183:
        return r0;
    L_0x0184:
        r1 = r3.q();
        r2 = r4.q();
        if (r1 != 0) goto L_0x0190;
    L_0x018e:
        if (r2 == 0) goto L_0x01a0;
    L_0x0190:
        if (r1 == 0) goto L_0x027a;
    L_0x0192:
        if (r2 != 0) goto L_0x0195;
    L_0x0194:
        return r0;
    L_0x0195:
        r1 = r3.o;
        r2 = r4.o;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x01a0;
    L_0x019f:
        return r0;
    L_0x01a0:
        r1 = r3.r();
        r2 = r4.r();
        if (r1 != 0) goto L_0x01ac;
    L_0x01aa:
        if (r2 == 0) goto L_0x01bc;
    L_0x01ac:
        if (r1 == 0) goto L_0x027a;
    L_0x01ae:
        if (r2 != 0) goto L_0x01b1;
    L_0x01b0:
        return r0;
    L_0x01b1:
        r1 = r3.p;
        r2 = r4.p;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x01bc;
    L_0x01bb:
        return r0;
    L_0x01bc:
        r1 = r3.s();
        r2 = r4.s();
        if (r1 != 0) goto L_0x01c8;
    L_0x01c6:
        if (r2 == 0) goto L_0x01d8;
    L_0x01c8:
        if (r1 == 0) goto L_0x027a;
    L_0x01ca:
        if (r2 != 0) goto L_0x01cd;
    L_0x01cc:
        return r0;
    L_0x01cd:
        r1 = r3.q;
        r2 = r4.q;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x01d8;
    L_0x01d7:
        return r0;
    L_0x01d8:
        r1 = r3.t();
        r2 = r4.t();
        if (r1 != 0) goto L_0x01e4;
    L_0x01e2:
        if (r2 == 0) goto L_0x01f4;
    L_0x01e4:
        if (r1 == 0) goto L_0x027a;
    L_0x01e6:
        if (r2 != 0) goto L_0x01e9;
    L_0x01e8:
        return r0;
    L_0x01e9:
        r1 = r3.r;
        r2 = r4.r;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x01f4;
    L_0x01f3:
        return r0;
    L_0x01f4:
        r1 = r3.u();
        r2 = r4.u();
        if (r1 != 0) goto L_0x0200;
    L_0x01fe:
        if (r2 == 0) goto L_0x020c;
    L_0x0200:
        if (r1 == 0) goto L_0x027a;
    L_0x0202:
        if (r2 != 0) goto L_0x0205;
    L_0x0204:
        return r0;
    L_0x0205:
        r1 = r3.s;
        r2 = r4.s;
        if (r1 == r2) goto L_0x020c;
    L_0x020b:
        return r0;
    L_0x020c:
        r1 = r3.v();
        r2 = r4.v();
        if (r1 != 0) goto L_0x0218;
    L_0x0216:
        if (r2 == 0) goto L_0x0228;
    L_0x0218:
        if (r1 == 0) goto L_0x027a;
    L_0x021a:
        if (r2 != 0) goto L_0x021d;
    L_0x021c:
        return r0;
    L_0x021d:
        r1 = r3.t;
        r2 = r4.t;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0228;
    L_0x0227:
        return r0;
    L_0x0228:
        r1 = r3.w();
        r2 = r4.w();
        if (r1 != 0) goto L_0x0234;
    L_0x0232:
        if (r2 == 0) goto L_0x0244;
    L_0x0234:
        if (r1 == 0) goto L_0x027a;
    L_0x0236:
        if (r2 != 0) goto L_0x0239;
    L_0x0238:
        return r0;
    L_0x0239:
        r1 = r3.u;
        r2 = r4.u;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0244;
    L_0x0243:
        return r0;
    L_0x0244:
        r1 = r3.x();
        r2 = r4.x();
        if (r1 != 0) goto L_0x0250;
    L_0x024e:
        if (r2 == 0) goto L_0x025c;
    L_0x0250:
        if (r1 == 0) goto L_0x027a;
    L_0x0252:
        if (r2 != 0) goto L_0x0255;
    L_0x0254:
        return r0;
    L_0x0255:
        r1 = r3.v;
        r2 = r4.v;
        if (r1 == r2) goto L_0x025c;
    L_0x025b:
        return r0;
    L_0x025c:
        r1 = r3.y();
        r2 = r4.y();
        if (r1 != 0) goto L_0x0268;
    L_0x0266:
        if (r2 == 0) goto L_0x0278;
    L_0x0268:
        if (r1 == 0) goto L_0x027a;
    L_0x026a:
        if (r2 != 0) goto L_0x026d;
    L_0x026c:
        return r0;
    L_0x026d:
        r1 = r3.w;
        r4 = r4.w;
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x0278;
    L_0x0277:
        return r0;
    L_0x0278:
        r4 = 1;
        return r4;
    L_0x027a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.aj.a(com.xiaomi.xmpush.thrift.aj):boolean");
    }

    public int b(aj ajVar) {
        if (!getClass().equals(ajVar.getClass())) {
            return getClass().getName().compareTo(ajVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(ajVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, ajVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ajVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, ajVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ajVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.c, ajVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ajVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.d, ajVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ajVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.b.a(this.e, ajVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ajVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.b.a(this.f, ajVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ajVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.b.a(this.g, ajVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ajVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.b.a(this.h, ajVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ajVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.b.a(this.i, ajVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ajVar.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            compareTo = org.apache.thrift.b.a(this.j, ajVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ajVar.m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m()) {
            compareTo = org.apache.thrift.b.a(this.k, ajVar.k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ajVar.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            compareTo = org.apache.thrift.b.a(this.l, ajVar.l);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ajVar.o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (o()) {
            compareTo = org.apache.thrift.b.a(this.m, ajVar.m);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ajVar.p()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (p()) {
            compareTo = org.apache.thrift.b.a(this.n, ajVar.n);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ajVar.q()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (q()) {
            compareTo = org.apache.thrift.b.a(this.o, ajVar.o);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ajVar.r()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (r()) {
            compareTo = org.apache.thrift.b.a(this.p, ajVar.p);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ajVar.s()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (s()) {
            compareTo = org.apache.thrift.b.a(this.q, ajVar.q);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ajVar.t()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (t()) {
            compareTo = org.apache.thrift.b.a(this.r, ajVar.r);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(u()).compareTo(Boolean.valueOf(ajVar.u()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (u()) {
            compareTo = org.apache.thrift.b.a(this.s, ajVar.s);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(v()).compareTo(Boolean.valueOf(ajVar.v()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (v()) {
            compareTo = org.apache.thrift.b.a(this.t, ajVar.t);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(w()).compareTo(Boolean.valueOf(ajVar.w()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (w()) {
            compareTo = org.apache.thrift.b.a(this.u, ajVar.u);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(x()).compareTo(Boolean.valueOf(ajVar.x()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (x()) {
            compareTo = org.apache.thrift.b.a(this.v, ajVar.v);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(y()).compareTo(Boolean.valueOf(ajVar.y()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (y()) {
            int a = org.apache.thrift.b.a(this.w, ajVar.w);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public aj b(int i) {
        this.n = i;
        b(true);
        return this;
    }

    public aj b(String str) {
        this.d = str;
        return this;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        z();
        eVar.a(y);
        if (this.a != null && a()) {
            eVar.a(z);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(A);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(B);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(C);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && f()) {
            eVar.a(D);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && g()) {
            eVar.a(E);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null) {
            eVar.a(F);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && j()) {
            eVar.a(G);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && k()) {
            eVar.a(H);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
            eVar.a(I);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && m()) {
            eVar.a(J);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && n()) {
            eVar.a(K);
            eVar.a(this.l);
            eVar.b();
        }
        if (o()) {
            eVar.a(L);
            eVar.a(this.m);
            eVar.b();
        }
        if (p()) {
            eVar.a(M);
            eVar.a(this.n);
            eVar.b();
        }
        if (this.o != null && q()) {
            eVar.a(N);
            eVar.a(this.o);
            eVar.b();
        }
        if (this.p != null && r()) {
            eVar.a(O);
            eVar.a(this.p);
            eVar.b();
        }
        if (this.q != null && s()) {
            eVar.a(P);
            eVar.a(this.q);
            eVar.b();
        }
        if (this.r != null && t()) {
            eVar.a(Q);
            eVar.a(this.r);
            eVar.b();
        }
        if (u()) {
            eVar.a(R);
            eVar.a(this.s);
            eVar.b();
        }
        if (this.t != null && v()) {
            eVar.a(S);
            eVar.a(this.t.a());
            eVar.b();
        }
        if (this.u != null && w()) {
            eVar.a(T);
            eVar.a(new d((byte) 11, (byte) 11, this.u.size()));
            for (Entry entry : this.u.entrySet()) {
                eVar.a((String) entry.getKey());
                eVar.a((String) entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (x()) {
            eVar.a(U);
            eVar.a(this.v);
            eVar.b();
        }
        if (this.w != null && y()) {
            eVar.a(V);
            eVar.a(this.w);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.W.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public aj c(int i) {
        this.s = i;
        c(true);
        return this;
    }

    public aj c(String str) {
        this.e = str;
        return this;
    }

    public void c(boolean z) {
        this.W.set(2, z);
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((aj) obj);
    }

    public aj d(String str) {
        this.f = str;
        return this;
    }

    public String d() {
        return this.d;
    }

    public void d(boolean z) {
        this.W.set(3, z);
    }

    public aj e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof aj)) ? a((aj) obj) : false;
    }

    public aj f(String str) {
        this.h = str;
        return this;
    }

    public boolean f() {
        return this.e != null;
    }

    public aj g(String str) {
        this.l = str;
        return this;
    }

    public boolean g() {
        return this.f != null;
    }

    public aj h(String str) {
        this.o = str;
        return this;
    }

    public String h() {
        return this.g;
    }

    public int hashCode() {
        return 0;
    }

    public aj i(String str) {
        this.p = str;
        return this;
    }

    public boolean i() {
        return this.g != null;
    }

    public aj j(String str) {
        this.q = str;
        return this;
    }

    public boolean j() {
        return this.h != null;
    }

    public aj k(String str) {
        this.r = str;
        return this;
    }

    public boolean k() {
        return this.i != null;
    }

    public boolean l() {
        return this.j != null;
    }

    public boolean m() {
        return this.k != null;
    }

    public boolean n() {
        return this.l != null;
    }

    public boolean o() {
        return this.W.get(0);
    }

    public boolean p() {
        return this.W.get(1);
    }

    public boolean q() {
        return this.o != null;
    }

    public boolean r() {
        return this.p != null;
    }

    public boolean s() {
        return this.q != null;
    }

    public boolean t() {
        return this.r != null;
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionRegistration(");
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
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("appVersion:");
            stringBuilder.append(this.e == null ? "null" : this.e);
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.f == null ? "null" : this.f);
        }
        stringBuilder.append(", ");
        stringBuilder.append("token:");
        stringBuilder.append(this.g == null ? "null" : this.g);
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("deviceId:");
            stringBuilder.append(this.h == null ? "null" : this.h);
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("aliasName:");
            stringBuilder.append(this.i == null ? "null" : this.i);
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("sdkVersion:");
            stringBuilder.append(this.j == null ? "null" : this.j);
        }
        if (m()) {
            stringBuilder.append(", ");
            stringBuilder.append("regId:");
            stringBuilder.append(this.k == null ? "null" : this.k);
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("pushSdkVersionName:");
            stringBuilder.append(this.l == null ? "null" : this.l);
        }
        if (o()) {
            stringBuilder.append(", ");
            stringBuilder.append("pushSdkVersionCode:");
            stringBuilder.append(this.m);
        }
        if (p()) {
            stringBuilder.append(", ");
            stringBuilder.append("appVersionCode:");
            stringBuilder.append(this.n);
        }
        if (q()) {
            stringBuilder.append(", ");
            stringBuilder.append("androidId:");
            stringBuilder.append(this.o == null ? "null" : this.o);
        }
        if (r()) {
            stringBuilder.append(", ");
            stringBuilder.append("imei:");
            stringBuilder.append(this.p == null ? "null" : this.p);
        }
        if (s()) {
            stringBuilder.append(", ");
            stringBuilder.append("serial:");
            stringBuilder.append(this.q == null ? "null" : this.q);
        }
        if (t()) {
            stringBuilder.append(", ");
            stringBuilder.append("imeiMd5:");
            stringBuilder.append(this.r == null ? "null" : this.r);
        }
        if (u()) {
            stringBuilder.append(", ");
            stringBuilder.append("spaceId:");
            stringBuilder.append(this.s);
        }
        if (v()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            if (this.t == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.t);
            }
        }
        if (w()) {
            stringBuilder.append(", ");
            stringBuilder.append("connectionAttrs:");
            if (this.u == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.u);
            }
        }
        if (x()) {
            stringBuilder.append(", ");
            stringBuilder.append("cleanOldRegInfo:");
            stringBuilder.append(this.v);
        }
        if (y()) {
            stringBuilder.append(", ");
            stringBuilder.append("oldRegId:");
            stringBuilder.append(this.w == null ? "null" : this.w);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    public boolean u() {
        return this.W.get(2);
    }

    public boolean v() {
        return this.t != null;
    }

    public boolean w() {
        return this.u != null;
    }

    public boolean x() {
        return this.W.get(3);
    }

    public boolean y() {
        return this.w != null;
    }

    public void z() {
        StringBuilder stringBuilder;
        if (this.c == null) {
            stringBuilder = new StringBuilder("Required field 'id' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.d == null) {
            stringBuilder = new StringBuilder("Required field 'appId' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        } else if (this.g == null) {
            stringBuilder = new StringBuilder("Required field 'token' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }
}
