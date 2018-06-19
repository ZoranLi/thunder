package com.xiaomi.xmpush.thrift;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum v$a {
    GEO_FENCINGS((short) 1, "geoFencings");
    
    private static final Map<String, v$a> b = null;
    private final short c;
    private final String d;

    static {
        b = new HashMap();
        Iterator it = EnumSet.allOf(v$a.class).iterator();
        while (it.hasNext()) {
            v$a com_xiaomi_xmpush_thrift_v_a = (v$a) it.next();
            b.put(com_xiaomi_xmpush_thrift_v_a.a(), com_xiaomi_xmpush_thrift_v_a);
        }
    }

    private v$a(short s, String str) {
        this.c = s;
        this.d = str;
    }

    public final String a() {
        return this.d;
    }
}
