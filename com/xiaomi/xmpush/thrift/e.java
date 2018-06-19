package com.xiaomi.xmpush.thrift;

import com.umeng.message.proguard.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class e implements Serializable, Cloneable, a<e, a> {
    public static final Map<a, b> b;
    private static final j c = new j("ClientUploadData");
    private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("uploadDataItems", (byte) 15, (short) 1);
    public List<f> a;

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.a, new b("uploadDataItems", (byte) 1, new d((byte) 15, new g((byte) 12, f.class))));
        b = Collections.unmodifiableMap(enumMap);
        b.a(e.class, b);
    }

    public int a() {
        return this.a == null ? 0 : this.a.size();
    }

    public void a(f fVar) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(fVar);
    }

    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b != (byte) 0) {
                if (i.c == (short) 1 && i.b == (byte) 15) {
                    c m = eVar.m();
                    this.a = new ArrayList(m.b);
                    for (int i2 = 0; i2 < m.b; i2++) {
                        f fVar = new f();
                        fVar.a(eVar);
                        this.a.add(fVar);
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

    public boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = eVar.b();
        return !(b || b2) || (b && b2 && this.a.equals(eVar.a));
    }

    public int b(e eVar) {
        if (!getClass().equals(eVar.getClass())) {
            return getClass().getName().compareTo(eVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(eVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            int a = org.apache.thrift.b.a(this.a, eVar.a);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        c();
        eVar.a(c);
        if (this.a != null) {
            eVar.a(d);
            eVar.a(new c((byte) 12, this.a.size()));
            for (f b : this.a) {
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
            StringBuilder stringBuilder = new StringBuilder("Required field 'uploadDataItems' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((e) obj);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof e)) ? a((e) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ClientUploadData(");
        stringBuilder.append("uploadDataItems:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
