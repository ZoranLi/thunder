package com.xiaomi.xmpush.thrift;

import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.j;

public class v implements Serializable, Cloneable, a<v, a> {
    public static final Map<a, b> b;
    private static final j c = new j("RegisteredGeoFencing");
    private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("geoFencings", (byte) 14, (short) 1);
    public Set<m> a;

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new b("geoFencings", (byte) 1, new f((byte) 14, new g((byte) 12, m.class))));
        b = Collections.unmodifiableMap(enumMap);
        b.a(v.class, b);
    }

    public v a(Set<m> set) {
        this.a = set;
        return this;
    }

    public Set<m> a() {
        return this.a;
    }

    public void a(e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b != (byte) 0) {
                if (i.c == (short) 1 && i.b == (byte) 14) {
                    i o = eVar.o();
                    this.a = new HashSet(2 * o.b);
                    for (int i2 = 0; i2 < o.b; i2++) {
                        m mVar = new m();
                        mVar.a(eVar);
                        this.a.add(mVar);
                    }
                    eVar.p();
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

    public boolean a(v vVar) {
        if (vVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = vVar.b();
        return !(b || b2) || (b && b2 && this.a.equals(vVar.a));
    }

    public int b(v vVar) {
        if (!getClass().equals(vVar.getClass())) {
            return getClass().getName().compareTo(vVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(vVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            int a = org.apache.thrift.b.a(this.a, vVar.a);
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
            eVar.a(new i((byte) 12, this.a.size()));
            for (m b : this.a) {
                b.b(eVar);
            }
            eVar.f();
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
            StringBuilder stringBuilder = new StringBuilder("Required field 'geoFencings' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new org.apache.thrift.protocol.f(stringBuilder.toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((v) obj);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof v)) ? a((v) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("RegisteredGeoFencing(");
        stringBuilder.append("geoFencings:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
