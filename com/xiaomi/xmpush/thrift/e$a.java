package com.xiaomi.xmpush.thrift;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum e$a {
    UPLOAD_DATA_ITEMS((short) 1, "uploadDataItems");
    
    private static final Map<String, e$a> b = null;
    private final short c;
    private final String d;

    static {
        b = new HashMap();
        Iterator it = EnumSet.allOf(e$a.class).iterator();
        while (it.hasNext()) {
            e$a com_xiaomi_xmpush_thrift_e_a = (e$a) it.next();
            b.put(com_xiaomi_xmpush_thrift_e_a.a(), com_xiaomi_xmpush_thrift_e_a);
        }
    }

    private e$a(short s, String str) {
        this.c = s;
        this.d = str;
    }

    public final String a() {
        return this.d;
    }
}
