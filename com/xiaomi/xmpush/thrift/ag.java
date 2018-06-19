package com.xiaomi.xmpush.thrift;

import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class ag implements Serializable, Cloneable, org.apache.thrift.a<ag, a> {
    public static final Map<a, b> b;
    private static final j c = new j("XmPushActionCustomConfig");
    private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("customConfigs", (byte) 15, (short) 1);
    public List<s> a;

    public enum a {
        CUSTOM_CONFIGS((short) 1, "customConfigs");
        
        private static final Map<String, a> b = null;
        private final short c;
        private final String d;

        static {
            b = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                b.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.c = s;
            this.d = str;
        }

        public final String a() {
            return this.d;
        }
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.CUSTOM_CONFIGS, new b("customConfigs", (byte) 1, new d((byte) 15, new g((byte) 12, s.class))));
        b = Collections.unmodifiableMap(enumMap);
        b.a(ag.class, b);
    }

    public List<s> a() {
        return this.a;
    }

    public void a(e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b != (byte) 0) {
                if (i.c == (short) 1 && i.b == (byte) 15) {
                    c m = eVar.m();
                    this.a = new ArrayList(m.b);
                    for (int i2 = 0; i2 < m.b; i2++) {
                        s sVar = new s();
                        sVar.a(eVar);
                        this.a.add(sVar);
                    }
                    eVar.n();
                } else {
                    h.a(eVar, i.b);
                }
                eVar.j();
            } else {
                eVar.h();
                c();
                return;
            }
        }
    }

    public boolean a(ag agVar) {
        if (agVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = agVar.b();
        return !(b || b2) || (b && b2 && this.a.equals(agVar.a));
    }

    public int b(ag agVar) {
        if (!getClass().equals(agVar.getClass())) {
            return getClass().getName().compareTo(agVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(agVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            int a = org.apache.thrift.b.a(this.a, agVar.a);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(e eVar) {
        c();
        eVar.a(c);
        if (this.a != null) {
            eVar.a(d);
            eVar.a(new c((byte) 12, this.a.size()));
            for (s b : this.a) {
                b.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.a != null;
    }

    public void c() {
        if (this.a == null) {
            StringBuilder stringBuilder = new StringBuilder("Required field 'customConfigs' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((ag) obj);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ag)) ? a((ag) obj) : false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCustomConfig(");
        stringBuilder.append("customConfigs:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
