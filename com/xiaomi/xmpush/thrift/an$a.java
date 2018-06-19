package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public enum an$a {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, AgooConstants.MESSAGE_ID),
    APP_ID((short) 4, "appId"),
    PACKAGE_NAME((short) 5, Constants.KEY_PACKAGE_NAME),
    TOPIC((short) 6, "topic"),
    ALIAS_NAME((short) 7, "aliasName"),
    MESSAGE((short) 8, "message"),
    NEED_ACK((short) 9, "needAck"),
    PARAMS((short) 10, "params"),
    CATEGORY((short) 11, "category"),
    USER_ACCOUNT((short) 12, "userAccount");
    
    private static final Map<String, an$a> m = null;
    private final short n;
    private final String o;

    static {
        m = new HashMap();
        Iterator it = EnumSet.allOf(an$a.class).iterator();
        while (it.hasNext()) {
            an$a com_xiaomi_xmpush_thrift_an_a = (an$a) it.next();
            m.put(com_xiaomi_xmpush_thrift_an_a.a(), com_xiaomi_xmpush_thrift_an_a);
        }
    }

    private an$a(short s, String str) {
        this.n = s;
        this.o = str;
    }

    public final String a() {
        return this.o;
    }
}
