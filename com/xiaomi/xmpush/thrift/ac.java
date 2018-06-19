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

public class ac implements Serializable, Cloneable, org.apache.thrift.a<ac, a> {
    public static final Map<a, b> b;
    private static final j c = new j("XmPushActionCollectData");
    private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("dataCollectionItems", (byte) 15, (short) 1);
    public List<k> a;

    public enum a {
        DATA_COLLECTION_ITEMS((short) 1, "dataCollectionItems");
        
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
        enumMap.put(a.DATA_COLLECTION_ITEMS, new b("dataCollectionItems", (byte) 1, new d((byte) 15, new g((byte) 12, k.class))));
        b = Collections.unmodifiableMap(enumMap);
        b.a(ac.class, b);
    }

    public ac a(List<k> list) {
        this.a = list;
        return this;
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
                        k kVar = new k();
                        kVar.a(eVar);
                        this.a.add(kVar);
                    }
                    eVar.n();
                } else {
                    h.a(eVar, i.b);
                }
                eVar.j();
            } else {
                eVar.h();
                b();
                return;
            }
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ac acVar) {
        if (acVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = acVar.a();
        return !(a || a2) || (a && a2 && this.a.equals(acVar.a));
    }

    public int b(ac acVar) {
        if (!getClass().equals(acVar.getClass())) {
            return getClass().getName().compareTo(acVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(acVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a = org.apache.thrift.b.a(this.a, acVar.a);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public void b() {
        if (this.a == null) {
            StringBuilder stringBuilder = new StringBuilder("Required field 'dataCollectionItems' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new f(stringBuilder.toString());
        }
    }

    public void b(e eVar) {
        b();
        eVar.a(c);
        if (this.a != null) {
            eVar.a(d);
            eVar.a(new c((byte) 12, this.a.size()));
            for (k b : this.a) {
                b.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((ac) obj);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ac)) ? a((ac) obj) : false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCollectData(");
        stringBuilder.append("dataCollectionItems:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
