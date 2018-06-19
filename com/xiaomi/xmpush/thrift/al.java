package com.xiaomi.xmpush.thrift;

import com.umeng.message.proguard.k;
import java.io.Serializable;
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

public class al implements Serializable, Cloneable, org.apache.thrift.a<al, a> {
    public static final Map<a, b> g;
    private static final j h = new j("XmPushActionSendFeedback");
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("debug", (byte) 11, (short) 1);
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("target", (byte) 12, (short) 2);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("appId", (byte) 11, (short) 4);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("feedbacks", (byte) 13, (short) 5);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("category", (byte) 11, (short) 6);
    public String a;
    public x b;
    public String c;
    public String d;
    public Map<String, String> e;
    public String f;

    public enum a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, "target"),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, "appId"),
        FEEDBACKS((short) 5, "feedbacks"),
        CATEGORY((short) 6, "category");
        
        private static final Map<String, a> g = null;
        private final short h;
        private final String i;

        static {
            g = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                g.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.h = s;
            this.i = str;
        }

        public final String a() {
            return this.i;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.DEBUG, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new b("target", (byte) 2, new g((byte) 12, x.class)));
        enumMap.put(a.ID, new b(AgooConstants.MESSAGE_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.FEEDBACKS, new b("feedbacks", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new c((byte) 11)));
        g = Collections.unmodifiableMap(enumMap);
        b.a(al.class, g);
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
        if (r1 == 0) goto L_0x008a;
    L_0x000b:
        r1 = r0.c;
        r2 = 11;
        switch(r1) {
            case 1: goto L_0x007b;
            case 2: goto L_0x0068;
            case 3: goto L_0x005d;
            case 4: goto L_0x0052;
            case 5: goto L_0x0024;
            case 6: goto L_0x0019;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r0.b;
        org.apache.thrift.protocol.h.a(r6, r0);
        goto L_0x0085;
    L_0x0019:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x001d:
        r0 = r6.w();
        r5.f = r0;
        goto L_0x0085;
    L_0x0024:
        r1 = r0.b;
        r2 = 13;
        if (r1 != r2) goto L_0x0012;
    L_0x002a:
        r0 = r6.k();
        r1 = new java.util.HashMap;
        r2 = 2;
        r3 = r0.c;
        r2 = r2 * r3;
        r1.<init>(r2);
        r5.e = r1;
        r1 = 0;
    L_0x003a:
        r2 = r0.c;
        if (r1 >= r2) goto L_0x004e;
    L_0x003e:
        r2 = r6.w();
        r3 = r6.w();
        r4 = r5.e;
        r4.put(r2, r3);
        r1 = r1 + 1;
        goto L_0x003a;
    L_0x004e:
        r6.l();
        goto L_0x0085;
    L_0x0052:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0056:
        r0 = r6.w();
        r5.d = r0;
        goto L_0x0085;
    L_0x005d:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x0061:
        r0 = r6.w();
        r5.c = r0;
        goto L_0x0085;
    L_0x0068:
        r1 = r0.b;
        r2 = 12;
        if (r1 != r2) goto L_0x0012;
    L_0x006e:
        r0 = new com.xiaomi.xmpush.thrift.x;
        r0.<init>();
        r5.b = r0;
        r0 = r5.b;
        r0.a(r6);
        goto L_0x0085;
    L_0x007b:
        r1 = r0.b;
        if (r1 != r2) goto L_0x0012;
    L_0x007f:
        r0 = r6.w();
        r5.a = r0;
    L_0x0085:
        r6.j();
        goto L_0x0003;
    L_0x008a:
        r6.h();
        r5.g();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.al.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xiaomi.xmpush.thrift.al r4) {
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
        if (r1 == 0) goto L_0x00ae;
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
        if (r1 == 0) goto L_0x00ae;
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
        if (r1 == 0) goto L_0x00ae;
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
        if (r1 == 0) goto L_0x00ae;
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
        if (r1 == 0) goto L_0x00ae;
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
        if (r1 == 0) goto L_0x00ae;
    L_0x009e:
        if (r2 != 0) goto L_0x00a1;
    L_0x00a0:
        return r0;
    L_0x00a1:
        r1 = r3.f;
        r4 = r4.f;
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x00ac;
    L_0x00ab:
        return r0;
    L_0x00ac:
        r4 = 1;
        return r4;
    L_0x00ae:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.al.a(com.xiaomi.xmpush.thrift.al):boolean");
    }

    public int b(al alVar) {
        if (!getClass().equals(alVar.getClass())) {
            return getClass().getName().compareTo(alVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(alVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.b.a(this.a, alVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(alVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.b.a(this.b, alVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(alVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.b.a(this.c, alVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(alVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.b.a(this.d, alVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(alVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.b.a(this.e, alVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(alVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            int a = org.apache.thrift.b.a(this.f, alVar.f);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        g();
        eVar.a(h);
        if (this.a != null && a()) {
            eVar.a(i);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(j);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(k);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(l);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(m);
            eVar.a(new d((byte) 11, (byte) 11, this.e.size()));
            for (Entry entry : this.e.entrySet()) {
                eVar.a((String) entry.getKey());
                eVar.a((String) entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(n);
            eVar.a(this.f);
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
        return b((al) obj);
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof al)) ? a((al) obj) : false;
    }

    public boolean f() {
        return this.f != null;
    }

    public void g() {
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

    public int hashCode() {
        return 0;
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSendFeedback(");
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
            stringBuilder.append("feedbacks:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            stringBuilder.append(this.f == null ? "null" : this.f);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
