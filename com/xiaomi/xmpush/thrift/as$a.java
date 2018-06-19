package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public enum as$a {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, AgooConstants.MESSAGE_ID),
    APP_ID((short) 4, "appId"),
    TOPIC((short) 5, "topic"),
    PACKAGE_NAME((short) 6, Constants.KEY_PACKAGE_NAME),
    CATEGORY((short) 7, "category");
    
    private static final Map<String, as$a> h = null;
    private final short i;
    private final String j;

    static {
        h = new HashMap();
        Iterator it = EnumSet.allOf(as$a.class).iterator();
        while (it.hasNext()) {
            as$a com_xiaomi_xmpush_thrift_as_a = (as$a) it.next();
            h.put(com_xiaomi_xmpush_thrift_as_a.a(), com_xiaomi_xmpush_thrift_as_a);
        }
    }

    private as$a(short s, String str) {
        this.i = s;
        this.j = str;
    }

    public final String a() {
        return this.j;
    }
}
