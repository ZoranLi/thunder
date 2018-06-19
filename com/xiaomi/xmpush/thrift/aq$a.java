package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public enum aq$a {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, AgooConstants.MESSAGE_ID),
    APP_ID((short) 4, "appId"),
    REG_ID((short) 5, "regId"),
    APP_VERSION((short) 6, "appVersion"),
    PACKAGE_NAME((short) 7, Constants.KEY_PACKAGE_NAME),
    TOKEN((short) 8, "token"),
    DEVICE_ID((short) 9, "deviceId"),
    ALIAS_NAME((short) 10, "aliasName");
    
    private static final Map<String, aq$a> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(aq$a.class).iterator();
        while (it.hasNext()) {
            aq$a com_xiaomi_xmpush_thrift_aq_a = (aq$a) it.next();
            k.put(com_xiaomi_xmpush_thrift_aq_a.a(), com_xiaomi_xmpush_thrift_aq_a);
        }
    }

    private aq$a(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public final String a() {
        return this.m;
    }
}
